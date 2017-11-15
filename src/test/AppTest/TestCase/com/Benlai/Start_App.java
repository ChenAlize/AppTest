package TestCase.com.Benlai;

import Act.com.Benlai.MainAct;
import Act.com.Benlai.UserHomeAct;
import Act.com.Benlai.WelcomeAct;
import Activity.GetPermissionsAty;
import Activity.LoginAty;
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

    @Test ( enabled = true )
    public void GetPermissions(){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAty welcomeAty = new WelcomeAty ( AppTest.driver );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        GetPermissionsAty aty = new GetPermissionsAty (  );
        aty.permissionsClick ();
        AppTest.end ();
    }

    @Test ( enabled = false , priority = 0 )
    public void mate_9 (){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAty welcomeAty = new WelcomeAty ( AppTest.driver );
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.allowClick ();
        MainAty mainAty = new MainAty ( AppTest.driver );
        mainAty.clickPackageClose();
        mainAty.clickUserHome();
        UserHomeAty userHomeAty = new UserHomeAty ( AppTest.driver );
        userHomeAty.clickCenterLogin ();
        LoginAty loginAty = new LoginAty ( AppTest.driver );
        loginAty.clickPWLogin ();
        loginAty.inputUserNmae ( "13508496358");
        loginAty.inputPassWord ( "qwe123456" );
        loginAty.back ();
        loginAty.clickBPWLogin ();
        AppTest.end ();
    }
}
