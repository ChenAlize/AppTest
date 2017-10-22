package TestCase;

import AppUtil.AppDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppTest{

    public AndroidDriver driver;

    public void  init(){
        AppDriver appdriver = new AppDriver ();
        driver = appdriver.getDriver ();
    }

    public void end(){ driver.quit (); }

}
