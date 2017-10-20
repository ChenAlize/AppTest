package Util.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by chenbo on 2017/7/7.
 */
public class Log {

        private static Logger logger;
        private static Class<?> clacc;

        public Log(Class<?> clacc ) {
        this.clacc = clacc;
        this.logger = LogManager.getLogger ( this.clacc );
    }

        public void pass( String message ) {
            logger.info ( " [成功] " + message );
        }

        public void error( String message ) {
            logger.error ( this.getClass ().getSimpleName () + "[错误] " + message );
        }

        public void fatal( String message ) {
            logger.fatal( "[错误] " + message );
        }

        public void info( String message ) {
            logger.info ( this.getClass ().getSimpleName () + "[信息] " + message );
        }

        public void unknown( String message ) {
            logger.error ("[未知] " + message );
        }

        public void warning( String message ) {
            logger.warn ( "[警告] " + message );
        }

}
