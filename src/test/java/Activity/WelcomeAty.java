package Activity;

import AppUtil.AppAction;
import AppUtil.AppElement;
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
        for(int i=0 ; i < 2 ; i++) {
            super.scrollLevel ( 1000, 100, 1000 );
        }
    }
    //       点击立即体验
    public void experienceClick(){
        super.coordinateClick ( 314,1671 );
    }
    //       点击权限确认
    public void permissionsClick(){
        super.coordinateClick ( 527,1149 );
    }
    //       允许权限
    public void allowClick(){
        super.coordinateClick ( 783,1686 );
        super.coordinateClick ( 783,1686 );
        super.coordinateClick ( 783,1686 );
    }
}
