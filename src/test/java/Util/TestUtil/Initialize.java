package Util.TestUtil;

import Util.Logger.Log;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Initialize {

    public Log log;

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
