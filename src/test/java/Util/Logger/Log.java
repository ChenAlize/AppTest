package Util.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

import static com.relevantcodes.extentreports.DisplayOrder.NEWEST_FIRST;
import static com.relevantcodes.extentreports.NetworkMode.OFFLINE;


/**
 * Created by chenbo on 2017/7/7.
 */
public class Log {

    public Logger logger;

    private ExtentReports extentReports;

    private static com.relevantcodes.extentreports.ExtentTest test;
    public static com.relevantcodes.extentreports.ExtentTest node;   //用例日志

    public Log(){
        System.out.println( " 2 ===== 初始化log：  " );
    }

    public Log(Class<?> clacc ) { logger = LogManager.getLogger ( clacc ); }

    public void createTest( Class<?> clacc ){
        System.out.println( "3 ===== 开始测试报表：  " + clacc.getSimpleName() );
        String path = new String( System.getProperty ( "user.dir" ) + "/test-output/extent.html");
        extentReports = new ExtentReports(  path , false , NEWEST_FIRST , OFFLINE );
        test = extentReports.startTest( clacc.getSimpleName() , "@class" );
        System.out.println( " 4 ===== 开始测试报表成功：  " + test );
    }

    public void addNode( Method method ){
        System.out.println( " 6 ===== 添加子测试：  " );
        node = extentReports.startTest( method.getName() , "@test" );
        test.appendChild( node );
        System.out.println( " 7 ===== 添加子测试成功：  " + node );

    }

    public void flush(){
        extentReports.endTest( test );
        extentReports.flush();
    }

    public void close(){
        extentReports.close();
    }

    public void pass( String message ) {
        logger.info ( " [成功] " + message );
        node.log( LogStatus.PASS , message );
        }

    public void error( String message ) {
        logger.error (  "[错误] " + message );
        node.log( LogStatus.ERROR , message );
        }

    public void fatal( String message ) {
        logger.fatal( "[错误] " + message );
        node.log( LogStatus.FATAL , message );
        }

    public void info( String message ) {
        logger.info (  "[信息] " + message );
        node.log( LogStatus.INFO , message );
    }

    public void unknown( String message ) {
        logger.error ("[未知] " + message );
        node.log( LogStatus.UNKNOWN , message );
        }

    public void warning( String message ) {
        logger.warn ( "[警告] " + message );
        node.log( LogStatus.WARNING , message );
        }

}
