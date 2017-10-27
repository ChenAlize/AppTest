package AppUtil;

import AppData.AppConfig;
import Util.Logger.Log;
import Util.ReFile.ReDate;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppAction {

    public Log log = new Log ( this.getClass () );

    public AndroidDriver driver;

    public AppAction ( AndroidDriver driver ){
        this.driver =driver;
    }

    /**
     * 水平划动
     */
    public void scrollLevel( int x1 , int x2 ,int y ) {

        driver.swipe ( x1 , y , x2 ,y , 0 );
        log.info ( "【水平划动】 ： ( " + x1 + " , " + y + " : " + x2 + " , " + y + " ) " , screenShot () );
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 竖直划动
     */
    public void scrollUp ( int x , int y1 ,int y2 ) {


        driver.swipe ( x , y1 , x , y2 , 0 );
        log.info ( "【竖直划动】( " + x + " , " + y1 + " : " + x + " , " + y2 + " ) " ,screenShot () );
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 截图
     */
    public java.lang.String screenShot ( ) {
        File screenShot = driver.getScreenshotAs ( OutputType.FILE );
        java.lang.String screenCast = AppConfig.getLogPath () + "/screenSho/"+ ReDate.nowData ()+".jpg" ;
        try {

            FileUtil.copyFile ( screenShot , new File ( screenCast ) );

        } catch (IOException e) {
            log.error ( "【截图失败】 " );
            e.printStackTrace ();
        }
        return screenCast;
    }

    /**
     * 坐标点击
     * @param x
     * @param y
     */
    public void coordinateClick ( int x , int y ){

        driver.tap ( 1,x,y,0 );
        log.info ( "【点击坐标】 ： ( " + x + " , " + y + " )" , screenShot ());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }


}
