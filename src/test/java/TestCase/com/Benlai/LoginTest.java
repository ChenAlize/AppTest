package TestCase.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.WelcomeAct;
import Activity.UserHomeAty;
import AppUtil.AppDriver;
import TestCase.AppTest;
import Util.Report.Initialize;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends Initialize{

    public AndroidDriver driver;

    @Test(enabled = false )
    public void LoginTest(){
        AppDriver appdriver = new AppDriver ();
        driver = appdriver.getDriver ();
        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( driver );
        welcomeAct.welcome ();
        //首页操作 ---  进入个人中心
        MainAct mainAct = new MainAct( driver );
        mainAct.toUserHome();
        //未登录状态 ---- 点击登录
        UserHomeAty homeAty = new UserHomeAty ( driver );
        homeAty.clickCenterLogin ();
        //帐号密码登录
        LoginAct loginAct = new LoginAct ( driver );
        loginAct.Login ();
        System.out.println ( "【是否登录成功】<?> " + loginAct.Config.getIsLogin () );
        driver.quit();
    }

    @Test(enabled = true )
    public  void test(){
        AppDriver appdriver = new AppDriver ();
        driver = appdriver.getDriver ();
        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( driver );
        welcomeAct.welcome ();
        driver.quit();
    }


}
