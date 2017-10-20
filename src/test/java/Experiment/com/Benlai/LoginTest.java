package Experiment.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.WelcomeAct;
import Activity.UserHomeAty;
import Activity.MainAty;
import AppData.AppConfig;
import Experiment.AppTest;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends AppTest {

    @Test(enabled = true )
    public void LoginTest() throws InterruptedException {

        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( driver );
        welcomeAct.welcome ();
        //首页操作 ---  进入个人中心
        MainAty mainAty = new MainAty ( driver );
        mainAty.clickPackageClose ();
        mainAty.clickUserHome ();
        //未登录状态 ---- 点击登录
        UserHomeAty homeAty = new UserHomeAty ( driver );
        homeAty.clickCenterLogin ();
        //帐号密码登录
        LoginAct loginAct = new LoginAct ( driver );
        loginAct.Login ();

        System.out.println ( "【是否登录成功】<?> " + loginAct.Config.getIsLogin () );
    }

    @Test(enabled = false )
    public  void test(){
        AppConfig config = new AppConfig (  );
        config.setIsLogin ( true );
        System.out.println ( config.getIsLogin () );
    }
}
