package Act.com.Benlai;

import Act.ActBase;
import Activity.MainAty;
import Activity.WelcomeAty;
import AppUtil.ActivityFactory;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/20.
 */
public class WelcomeAct  {

    static AndroidDriver driver;

    public static void setDriver( AndroidDriver driver ){
        WelcomeAct.driver = driver ;
    }

    public static AndroidDriver getDriver(){
        return WelcomeAct.driver;
    }


    /**
     * 欢迎
     */
    public static MainAty welcome(){
        WelcomeAty welcomeAty = new WelcomeAty ( getDriver() );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.permissionsClick ();
        welcomeAty.allowClick ();
        return (MainAty) ActivityFactory.atyFactory( MainAty.class , getDriver()  );
    }

}
