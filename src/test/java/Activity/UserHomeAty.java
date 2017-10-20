package Activity;

import AppUtil.AppElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/17.
 */
public class UserHomeAty extends AppElement {
    /**
     * @param driver
     */
    public UserHomeAty(AndroidDriver driver) {
        super ( driver );
    }

    /**
     * 点击：登录注册 按钮
     */
    public void clickCenterLogin(){
        click ( "登录注册" );
    }
}
