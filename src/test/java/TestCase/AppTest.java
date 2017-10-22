package TestCase;

import AppUtil.AppDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppTest{

    public static AndroidDriver driver;

    public static void  init(){

    }

    public static void end(){ driver.quit (); }

}
