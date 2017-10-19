package Test;

import Activity.MainAty;
import Activity.WelcomeAty;
import AppData.AppConfig;
import AppUtil.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppTest {

    @Test(enabled = true )
    public void test01(){
        AppDriver appdriver = new AppDriver ();
        AndroidDriver driver = appdriver.getDriver ();
        WelcomeAty welcomeAty = new WelcomeAty ( driver );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.permissionsClick ();
        welcomeAty.allowClick ();
        MainAty mainAty = new MainAty ( driver );
        mainAty.clickUserHome ();
    }

    @Test(enabled = false )
    public  void test(){
        AppConfig appConfig = new AppConfig ( "HAWEI mate 9" );
        System.out.println ( appConfig.getAppActivity () );
    }
}
