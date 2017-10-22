package Util.Logger;

import Util.Report.ExtentManager;
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
        String path = new String( System.getProperty ( "user.dir" ) + "/test-output/extent.html");
        extentReports =  new ExtentReports(  path , false , NEWEST_FIRST , OFFLINE );
        test = extentReports.startTest( clacc.getSimpleName() , "@class" );
    }

    public void addNode( Method method ){

        node = extentReports.startTest( method.getName() , "@test" );
        test.appendChild( node );            //添加日志节点

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

    public void error( String message , String path) {
        logger.error (  "[错误] " + message );
        node.log( LogStatus.ERROR , message + node.addBase64ScreenShot( path ));
    }

    public void fatal( String message ) {
        logger.fatal( "[错误] " + message );
        node.log( LogStatus.FATAL , message );
        }

    public void info( String message , String path ) {
        logger.info (  "[信息] " + message );
        node.log( LogStatus.INFO , message + node.addBase64ScreenShot( path ) );
    }

    public void info( String message  ) {
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
