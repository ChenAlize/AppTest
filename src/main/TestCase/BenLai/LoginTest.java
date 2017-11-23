package BenLai;

import Util.ReDB.Update;
import org.testng.annotations.*;

/**
 * Created by chenbo on 2017/11/16.
 */
public class LoginTest extends TestBase {

    @org.testng.annotations.Test(enabled = true)
    public void loginTest() throws InterruptedException {
        welcome ();
        Test.click ( "Button;text=\"确定\"" );
        Test.click ( "Button;text=\"始终允许\"" );
        Test.click ( "Button;text=\"始终允许\"" );
        Test.click ( "Button;text=\"始终允许\"" );
        Thread.sleep ( 3000 );
        Test.click ( "ImageButton;content-desc=\"关闭\"" );
        userHome();
        Test.click ( "TextView;text=\"登录/注册\"" );
        Test.input( "EditText;text=\"请输入您的手机号\"" , "13508496358" );
        Test.click ( "Button;text=\"获取验证码\"" );
//        String sms = sms ( "13312345678" );
//        Test.input ( "EditText;text=\"请输入验证码\"" , sms );
        Test.close ();
    }

}
