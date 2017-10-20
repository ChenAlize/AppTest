package Experiment;

import AppUtil.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppTest {

    public AndroidDriver driver;

    @BeforeSuite
    public  void init(){
        AppDriver appdriver = new AppDriver ();
        driver = appdriver.getDriver ();
    }

    @AfterSuite
    public void end(){ driver.quit (); }

    /**
     * 在每一个测试方法调用前运行
     */
    @BeforeMethod
    public void beforeMethod ( Method method ) {
        System.out.println ( "【在每一个测试方法调用前运行】" + method );
//        log = new Reports( this.getClass(), method);
    }
    /*在每一个测试方法调用后运行*/
    @AfterMethod
    public void afterMethod ( ITestResult result ) {
        System.out.println ( "【在每一个测试方法调用后运行】" + result );
//        log.conmit ();
    }

    /**
     * 在列表中的gourp前运行
     */
    @BeforeGroups
    public void beforeGroups () {}
    /*在列表中的gourp后运行*/
    @AfterGroups
    public void afterGroups () {}

    /**
     * 在测试运行前运行
     */
    @BeforeTest
    public void beforeTest () {}
    /*在测试运行后运行 */
    @AfterTest
    public void afterTest () {  }
}
