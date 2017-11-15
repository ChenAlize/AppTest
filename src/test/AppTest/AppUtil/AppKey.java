package AppUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppKey extends AppAction {

    public AppKey(AndroidDriver driver) {
        super(driver);
    }

    /**
     * 按键：返回
     */
    public void back(){
        driver.pressKeyCode ( AndroidKeyCode.BACK );
        log.info ( "【返回】" , screenShot ());
    }

    /**
     * 收起键盘
     */
    public void hideKey(){
        driver.hideKeyboard ();
    }
}
