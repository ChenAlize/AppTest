package Activity;

import AppUtil.AppAction;
import AppUtil.AppElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenbo on 2017/10/18.
 */
public class WelcomeAty extends AppElement {

    public WelcomeAty(AndroidDriver driver) {
        super ( driver );
    }

    public AndroidDriver getDriver () {
        return driver;
    }
    //       向左滑动2次
    public void liftRow(){
            ReFile.writePage ( driver , "now_user" );
            super.scrollLevel ( 1000, 100, 1000 );
            ReFile.writePage ( driver , "zhu_cheng" );
            super.scrollLevel ( 1000, 100, 1000 );
    }
    //       点击立即体验
    public void experienceClick(){
        ReFile.writePage ( driver , "Experience" );
        super.coordinateClick ( 314,1671 );
    }
    //       点击权限确认
    public void permissionsClick(){
        ReFile.writePage ( driver , "Permissions" );
        super.coordinateClick ( 527,1149 );
    }
    //       允许权限
    public void allowClick(){
        ReFile.writePage ( driver, "storage" );
        super.coordinateClick ( 783, 1686 );
        ReFile.writePage ( driver, "position" );
        super.coordinateClick ( 783, 1686 );
        ReFile.writePage ( driver, "telephone" );
        super.coordinateClick ( 783, 1686 );
        ReFile.writePage ( driver, "logo" );
    }
}
