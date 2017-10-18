package Test;

import Activity.WelcomeAty;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppTest {

    @Test(enabled = false )
    public void test01(){
        WelcomeAty welcomeAty = new WelcomeAty ();
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.permissionsClick ();
        welcomeAty.allowClick ();
    }
}
