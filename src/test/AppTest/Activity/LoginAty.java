package Activity;

import AppUtil.AppElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/9/29.
 */
public class LoginAty extends AppElement {
    /**
     * 获取分辨率
     *
     * @param driver
     */
    public LoginAty(AndroidDriver driver) {
        super ( driver );
    }

    public void clickPWLogin(){
        ReFile.writePage ( driver , "LoginAty" );
        click ( "密码登录" );
    }

    public void inputUserNmae( String userName ){

        typing ( "用户名" , userName );
    }

    public void inputPassWord( String passWord ){

        typing ( "密码" , passWord );
    }

    public void clickBPWLogin(){

        click ( "密码登录btn" );
    }
}
