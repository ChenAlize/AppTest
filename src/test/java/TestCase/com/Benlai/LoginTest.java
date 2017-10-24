package TestCase.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.WelcomeAct;
import Activity.UserHomeAty;
import AppData.AppConfig;
import TestCase.AppTest;
import Util.TestUtil.Initialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends Initialize{

    @Test(enabled = true , dependsOnMethods = { "TestCase.com.Benlai.Start_App.mate_9" } )
    public void LoginTest(){
        //首页操作 ---  进入个人中心
        MainAct mainAct = new MainAct( AppTest.driver );
        mainAct.toUserHome ();
        //未登录状态 ---- 点击登录
        UserHomeAty homeAty = new UserHomeAty ( AppTest.driver );
        homeAty.clickCenterLogin ();
        //帐号密码登录
        LoginAct loginAct = new LoginAct ( AppTest.driver );
        loginAct.Login ();
        System.out.println ( "【是否登录成功】<?> " + AppConfig.getIsLogin () );
        AppTest.end ();
    }

}
