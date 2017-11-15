package Util.Logger;

import Util.Report.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;

import java.lang.reflect.Method;

/**
 * Created by chenbo on 2017/11/11.
 */
public class ReportLog {

    private static ExtentReports extentReports;
    private static com.relevantcodes.extentreports.ExtentTest test;
    public static com.relevantcodes.extentreports.ExtentTest node;   //用例日志

    /**
     * 初始化Extent ,创建测试
     * @param clacc
     */
    public void createTest( Class<?> clacc ){
        extentReports =  ExtentManager.getExtentReport ();
        test = extentReports.startTest( clacc.getSimpleName() , "@class" );
    }

    /**
     * 添加测试节点
     * @param method
     */
    public void addNode( Method method ){
        node = extentReports.startTest( method.getName() , "@test" );
        test.appendChild( node );            //添加日志节点

    }

    /**
     * 测试结算，写入日志和结果
     * @param result
     */
    public void flush( ITestResult result ){
        if (result.getStatus() == ITestResult.FAILURE) {
            node.log( LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            node.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            node.log(LogStatus.PASS, "Test passed");
        }
        extentReports.flush();
    }

    /**
     * 清空Extent资源
     */
    public void close(){
        extentReports.endTest( test );
        extentReports.close();
    }

    /**
     * 成功
     * @param message
     */
    public void pass( String message ) {

        node.log( LogStatus.PASS , message  );
    }

    /**
     * 成功
     * @param message
     */
    public void pass( String message  , String path ) {

        node.log( LogStatus.PASS , message + node.addBase64ScreenShot( path ) );
    }

    /**
     *
     * @param message
     */
    public void error( String message ) {
        node.log( LogStatus.ERROR , message );
    }

    /**
     *
     * @param message
     * @param path
     */
    public void error( String message , String path) {

        node.log( LogStatus.ERROR , message + node.addBase64ScreenShot( path ));
    }

    /**
     *
     * @param message
     */
    public void fatal( String message ) {

        node.log( LogStatus.FATAL , message );
    }

    /**
     *
     * @param message
     * @param path
     */
    public void info( String message , String path ) {

        node.log( LogStatus.INFO , message + node.addBase64ScreenShot( path ) );
    }

    /**
     *
     * @param message
     */
    public void info( String message  ) {

        node.log( LogStatus.INFO , message );
    }

    /**
     *
     * @param message
     */
    public void unknown( String message ) {

        node.log( LogStatus.UNKNOWN , message );
    }

    /**
     *
     * @param message
     */
    public void warning( String message ) {

        node.log( LogStatus.WARNING , message );
    }

}
