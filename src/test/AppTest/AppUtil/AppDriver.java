package AppUtil;

import AppData.AppConfig;
import Util.Logger.Log;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by chenbo on 2017/10/19.
 */
public class AppDriver {

    private static Log log = new Log ( AppDriver.class );

    private static AndroidDriver driver;


    //启动app，获取derver
    public AndroidDriver getAppDriver( String phoneModels ){

        AppConfig config = new AppConfig ( phoneModels );

        DesiredCapabilities des = new DesiredCapabilities (  );
        //设备配置
        des.setCapability ( "deviceName","anything" );
        des.setCapability ( "platformVersion" ,config.getplatformVersion () );
        des.setCapability ( "udid" , config.getudid () );
        //app入口
        des.setCapability ( "appPackage" , config.getAppPackage () );
        des.setCapability ( "appActivity" , config.getAppActivity () );
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
        } catch ( Exception e) {
            log.error ( "【获取 AndroidDriver 失败！】" );
            e.printStackTrace ();
        }
        return driver;
    }




}
