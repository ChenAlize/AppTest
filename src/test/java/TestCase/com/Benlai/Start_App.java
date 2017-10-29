package TestCase.com.Benlai;

import Act.com.Benlai.MainAct;
import Act.com.Benlai.UserHomeAct;
import Act.com.Benlai.WelcomeAct;
import Activity.MainAty;
import Activity.UserHomeAty;
import Activity.WelcomeAty;
import AppUtil.ActivityFactory;
import AppUtil.AppDriver;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/24.
 */
public class Start_App extends ReInitialize {

    @Test ( enabled = true , priority = 0 )
    public void mate_9 (){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAty welcomeAty = new WelcomeAty ( AppTest.driver );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.permissionsClick ();
        welcomeAty.allowClick ();
        MainAty mainAty = (MainAty) ActivityFactory.atyFactory( MainAty.class , welcomeAty.getDriver() );
        System.out.println(mainAty.driver.currentActivity());
        mainAty.clickPackageClose();
        System.out.println(mainAty.driver.currentActivity());
        mainAty.clickUserHome();
        UserHomeAty userHomeAty = (UserHomeAty) ActivityFactory.atyFactory( UserHomeAty.class , mainAty.getDriver() );
        System.out.println(userHomeAty.driver.currentActivity());
        AppTest.end ();
    }
}
