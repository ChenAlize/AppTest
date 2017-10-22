package Act;

import AppData.AppConfig;
import Util.Logger.Log;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenbo on 2017/10/20.
 */
public class ActBase {

    public Log log;
    public AndroidDriver driver;
    public AppConfig Config;

    public ActBase(AndroidDriver driver){this.driver = driver;log = new Log ( this.getClass () );Config = new AppConfig ( );}

    public AndroidDriver getDriver(){return this.driver;}

    /**
     * 线程等待
     * @param min
     */
    public void sleep( int min ){
        try {
            Thread.sleep ( min*1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 隐式等待
     * @param min
     */
    public void waits( int min ){driver.manage ().timeouts ().implicitlyWait ( min , TimeUnit.MINUTES );}
}
