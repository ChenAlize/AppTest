import Activity.WelcomeAty;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import com.android.uiautomator.core.UiSelector;
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

        WelcomeAty welcomeAty = new WelcomeAty ( driver );
        welcomeAty.liftRow ();
        welcomeAty.experienceClick ();

        String ss = String.valueOf ( new UiSelector ().text ( "确认" ) );
        driver.findElement ( MobileBy.AndroidUIAutomator ( ss ) ).click ();
        Thread.sleep ( 2000 );
        String yx = String.valueOf ( new UiSelector ().textContains ( "允许" ) );
        driver.findElement ( MobileBy.AndroidUIAutomator ( yx ) ).click ();
        Thread.sleep ( 2000 );
        String sz = String.valueOf ( new UiSelector ().textStartsWith ( "始终" ) );
        driver.findElement ( MobileBy.AndroidUIAutomator ( sz ) ).click ();
        Thread.sleep ( 2000 );
        String zz = String.valueOf ( new UiSelector ().textMatches ( "^终允.*" ) );
        driver.findElement ( MobileBy.AndroidUIAutomator ( zz ) ).click ();

    }
}
