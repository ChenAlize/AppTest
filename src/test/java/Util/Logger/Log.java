package Util.Logger;

import Util.Report.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import java.lang.reflect.Method;


/**
 * Created by chenbo on 2017/7/7.
 */
public class Log {

    public Logger logger;

    public Log(){}

    /**
     *  2282440078.Q
     * 初始化log
     * @param clacc
     */
    public Log(Class<?> clacc ) { logger = LogManager.getLogger ( clacc ); }

    /**
     * 成功
     * @param message
     */
    public void pass( String message ) {
        logger.info ( " [成功] " + message );
        }

    /**
     *
     * @param message
     */
    public void error( String message ) {
        logger.error (  "[错误] " + message );
        }

    /**
     *
     * @param message
     */
    public void fatal( String message ) {
        logger.fatal( "[错误] " + message );
        }

    /**
     *
     * @param message
     */
    public void info( String message  ) {
        logger.info (  "[信息] " + message );
    }

    /**
     *
     * @param message
     */
    public void unknown( String message ) {
        logger.error ("[未知] " + message );
        }

    /**
     *
     * @param message
     */
    public void warning( String message ) {
        logger.warn ( "[警告] " + message );
        }

}
