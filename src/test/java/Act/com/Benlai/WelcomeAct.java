package Act.com.Benlai;

import Act.ActBase;
import Activity.WelcomeAty;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/20.
 */
public class WelcomeAct extends ActBase {

    public WelcomeAct(AndroidDriver driver) {
        super ( driver );
    }

    WelcomeAty welcomeAty = new WelcomeAty ( driver );

    /**
     * 欢迎
     */
    public void welcome(){
        welcomeAty.liftRow();
        welcomeAty.experienceClick ();
        welcomeAty.permissionsClick ();
        welcomeAty.allowClick ();
        sleep ( 5 );
    }

}
