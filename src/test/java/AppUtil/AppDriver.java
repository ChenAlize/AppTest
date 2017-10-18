package AppUtil;

import Util.Log;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppDriver {

    private Log log = new Log ( this.getClass () );

    public AndroidDriver driver;
    //启动app，获取derver
    public AppDriver(){

        DesiredCapabilities des = new DesiredCapabilities (  );
        //设备配置
        des.setCapability ( "deviceName","anything" );
        des.setCapability ( "platformVersion" ,"6.0" );
        des.setCapability ( "udid" , "GWY0216B26003168" );
        //app入口
        des.setCapability ( "appPackage" , "com.android.benlailife.activity" );
        des.setCapability ( "appActivity" , "com.android.benlai.activity.WelcomeActivity" );
        //支持中文
        des.setCapability("unicodeKeyboard", "True");
        //在设定了 unicodeKeyboard 关键字的 Unicode 测试结束后，重置输入法到原有状态
        des.setCapability("resetKeyboard", "True");
        //没有新命令是的超出时间设置
        des.setCapability("nowCommandTimeout", "10");
        //跳过检查和对应用进行debug  签名的步骤
        des.setCapability("nosign", "True");

        try {
            driver = new AndroidDriver ( new URL ( "http://127.0.0.1:4723/wd/hub" ) ,des );
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        }
//        return driver;
    }

    /**
     * 水平划动
     */
    public void scrollLevel( int x1 , int x2 ,int y ) {
        screenShot ();
        log.info ( "【水平划动】 ： ( " + x1 + " , " + y + " : " + x2 + " , " + y + " ) " );
        driver.swipe ( x1 , y , x2 ,y , 0 );

        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 竖直划动
     */
    public void scrollUp ( int x , int y1 ,int y2 ) {
        screenShot ();
        log.info ( "【竖直划动】( " + x + " , " + y1 + " : " + x + " , " + y2 + " ) " );
        driver.swipe ( x , y1 , x , y2 , 0 );
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 截图
     */
    public void screenShot ( ) {
        File screenshot = driver.getScreenshotAs ( OutputType.FILE );
        try {
            FileUtil.copyFile ( screenshot , new File ( System.getProperty ( "user.dir" )+"/screenSho/"+data ()+".jpg" ) );

        } catch (IOException e) {
            log.error ( "【截图失败】 " );
            e.printStackTrace ();
        }
    }

    /**
     * 获取时间格式
     */
    public String data ( ) {
        Date date = new Date();
        return new SimpleDateFormat ("yyyy_MM_dd_HH_mm_ss").format(date);
    }

    /**
     * 坐标点击
     * @param x
     * @param y
     */
    public void coordinateClick ( int x , int y ){
        screenShot ();
        log.info ( "【点击坐标】 ： ( " + x + " , " + y + " )" );
        driver.tap ( 1,x,y,0 );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
