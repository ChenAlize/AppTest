package Util.TestUtil;

import Factory.ElementFactory.FindElement;
import Util.Logger.ReportLog;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.lang.reflect.Method;

public class ReInitialize {

    public ReportLog log;

    @BeforeClass
    public void beforeClass() {

        log = new ReportLog();
        log.createTest( this.getClass() );
        System.out.println( " ===== 测试开始：  " + this.getClass().getSimpleName() + "初始化报表！");
    }

    @BeforeMethod
    public void beforeMethod( Method method ) {

        log.addNode( method );
        System.out.println( " ===== 执行测试方法：  " + method.getName() + "添加报表节点");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        log.flush( result );
        System.out.println( " ===== 测试方法结束：  " + result.getName() + "写入报表日志");
    }

    @AfterClass
    public void aftrtClass(){
        FindElement.close ();
        log.close();
        System.out.println( " ===== 测试结束：  " + this.getClass().getSimpleName() + "清空Extent资源" );
    }

}
