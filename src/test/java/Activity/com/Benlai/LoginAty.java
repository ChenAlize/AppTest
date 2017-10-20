package Activity.com.Benlai;

import AppUtil.AppElement;
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
        click ( "密码登录" );
    }

    public void inputUserNmae(){
        typing ( "用户名" , "13508496358" );
    }

    public void inputPassWord(){
        typing ( "密码" , "qwe123456" );
    }

    public void clickBPWLogin(){
        click ( "密码登录btn" );
    }
}
