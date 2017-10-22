package TestCase.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.WelcomeAct;
import Activity.UserHomeAty;
import AppUtil.AppDriver;
import TestCase.AppTest;
import Util.Logger.Log;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends AppTest{

    public AndroidDriver driver;

    public Log log;

    @Test(enabled = false )
    public void LoginTest(){
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

    }

    @Test(enabled = true )
    public  void test(){
        init();
        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( driver );
        welcomeAct.welcome ();
        end();
    }

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println( " 1 ===== 测试开始：  " + this.getClass().getSimpleName() );
        log = new Log();
        log.createTest( this.getClass() );
    }

    @BeforeMethod
    public void beforeMethod( Method method ) {
        System.out.println( " 5 ===== 执行测试方法：  " + method.getName() );
        log.addNode( method );
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        log.flush();
        System.out.println( " ===== 测试方法结束：  " + result.getName() );
    }

    @AfterClass
    public void aftrtClass(){
        System.out.println( " ===== 测试结束：  " + this.getClass().getSimpleName() );
        log.close();
    }

}
