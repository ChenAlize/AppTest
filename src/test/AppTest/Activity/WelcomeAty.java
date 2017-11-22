package Activity;

import AppUtil.AppElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

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

            super.scrollLevel ( 1000, 100, 1000 );

            super.scrollLevel ( 1000, 100, 1000 );
    }
    //       点击立即体验
    public void experienceClick(){

        super.coordinateClick ( 314,1671 );
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
