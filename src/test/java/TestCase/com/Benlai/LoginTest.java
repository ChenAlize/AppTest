package TestCase.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.UserHomeAct;
import Act.com.Benlai.WelcomeAct;
import AppData.AppConfig;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends ReInitialize {

    @Test(enabled = true  , priority = 3 )
    public void LoginTest(){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        welcomeAct.welcome ();
        //首页操作 ---  进入个人中心
        MainAct mainAct = new MainAct( AppTest.driver );
        mainAct.toUserHome ();
        //未登录状态 ---- 点击登录
        UserHomeAct userHomeAct = new UserHomeAct ( AppTest.driver );
        userHomeAct.userHomeAty.clickCenterLogin ();
        //帐号密码登录
        LoginAct loginAct = new LoginAct ( AppTest.driver );
        loginAct.Login ();
        System.out.println ( "【是否登录成功】<?> " + AppConfig.getIsLogin () );
        AppTest.end ();

    }

}
