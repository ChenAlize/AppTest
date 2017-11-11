import Activity.GetPermissionsAty;
import Activity.WelcomeAty;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


/**
 * Created by chenbo on 2017/11/8.
 */
public class MobileTest extends ReInitialize{

    @org.testng.annotations.Test
    public void mobileTest() throws InterruptedException {
        AppTest.init ( "HAWEI Mate 9" );
        AndroidDriver driver = AppTest.driver;
        WelcomeAty welcomeAty = new WelcomeAty ( AppTest.driver );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        GetPermissionsAty aty = new GetPermissionsAty ( AppTest.driver );
        aty.permissionsClick ();
        welcomeAty.allowClick ();
        driver.findElement ( MobileBy.AccessibilityId ( "关闭" ) ).click ();
//        driver.findElement ( By.xpath ( "//android.widget.Button[@text='立即领取']" ) ).click ();
        AppTest.end ();


    }
}
