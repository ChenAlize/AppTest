package Factory.ElementFactory;

import Factory.Factory.Config;
import Util.Logger.Log;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chenbo on 2017/11/16.
 */
public class DriverFactory {

    private static Log log = new Log ( DriverFactory.class );

    private static AndroidDriver driver = null;

    /**
     * 单例
     * @return
     */
    public static synchronized AndroidDriver androidDriver(){

        if ( driver == null ){

            try {
                driver = android ();
                log.pass ( " 初始化 AndroidDriver " );
            } catch (MalformedURLException e) {
                log.error ( "初始化 AndroidDriver"  );
                e.printStackTrace ();
            }
        }
        return (AndroidDriver)driver;
    }

    /**
     * androidDriver
     * @return
     * @throws MalformedURLException
     */
    private static AndroidDriver android() throws MalformedURLException {

        DesiredCapabilities des = new DesiredCapabilities (  );
        //设备配置
        des.setCapability ( "deviceName","anything" );
        des.setCapability ( "platformVersion" , "7.0" );
        des.setCapability ( "udid" , Config.UDID);
        //app入口
        des.setCapability ( "appPackage" , Config.APPPACKAGE );
        des.setCapability ( "appActivity" ,Config.APPACTIVITY );
        //支持中文
//        des.setCapability("unicodeKeyboard", "True");
        //在设定了 unicodeKeyboard 关键字的 Unicode 测试结束后，重置输入法到原有状态
//        des.setCapability("resetKeyboard", "True");
        //没有新命令是的超出时间设置
        des.setCapability("nowCommandTimeout", "10");
        //跳过检查和对应用进行debug  签名的步骤
        des.setCapability("nosign", "True");

        AndroidDriver driver = new AndroidDriver( new URL ( Config.URL ), des );
        ReFile.PageSource ( driver );
        return driver;
    }
}
