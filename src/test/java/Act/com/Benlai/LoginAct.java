package Act.com.Benlai;

import Act.ActBase;
import Activity.LoginAty;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/20.
 */
public class LoginAct extends ActBase {

    public LoginAct(AndroidDriver driver) {
        super ( driver );
    }

    LoginAty loginAty = new LoginAty ( getDriver () );


    public void Login(){
            loginAty.clickPWLogin ();
            loginAty.inputUserNmae ();
            loginAty.inputPassWord ();
            loginAty.hideKey ();
            loginAty.clickBPWLogin ();
            Config.setIsLogin ( true );
    }

}
