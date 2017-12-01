package Locator;

import io.appium.java_client.android.AndroidElement;

/**
 * Created by chenbo on 2017/11/29.
 */
public class AppAction {

    private AndroidElement androidElement = null ;

    public void setAndroidElement(AndroidElement androidElement) {
        this.androidElement = androidElement;
    }

    public void Click(){
        androidElement.click ();
    }

    public void SendKey( String text ){
        try{
            androidElement.sendKeys ( text );
        }catch ( Exception e ){
            try {
                throw new Exception ( "键入文字失败" );
            } catch (Exception e1) {
                e1.printStackTrace ();
            }
        }

    }
}
