package Act.com.Benlai;

import Act.ActBase;
import Activity.UserHomeAty;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/20.
 */
public class UserHomeAct extends ActBase{

    public UserHomeAct(AndroidDriver driver) {
        super ( driver );
    }

    public UserHomeAty userHomeAty = new UserHomeAty ( driver );

    public void login(){
        if ( Config.getIsLogin () ){
            log.pass ( "【你已经是登录状态！】" );
        } else {
            userHomeAty.clickCenterLogin ();
        }
    }
}
