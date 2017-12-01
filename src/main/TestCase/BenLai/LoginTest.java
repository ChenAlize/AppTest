package BenLai;

import Act.com.Benlai.MainAct;
import Solutions.GetPermissionsActivity;
import Solutions.LogoActivity;
import Solutions.MainActivity;
import Util.ReDB.Update;
import org.testng.annotations.*;

/**
 * Created by chenbo on 2017/11/16.
 */
public class LoginTest extends TestBase {

    @org.testng.annotations.Test(enabled = false)
    public void loginTest() throws InterruptedException {
        welcome ();
//        GetPermissionsActivity getPermissionsActivity = new GetPermissionsActivity ();
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

    @Test(enabled = true )
    public void test_PO(){
        welcome ();
        GetPermissionsActivity getPermissionsActivity = new GetPermissionsActivity ();
        getPermissionsActivity.only_True ().Click ();
        getPermissionsActivity.Permission_Allow ().Click ();
        getPermissionsActivity.Permission_Allow ().Click ();
        getPermissionsActivity.Permission_Allow ().Click ();
        LogoActivity logoActivity = new LogoActivity ();
        logoActivity.tv_Skip ().Click ();
        MainActivity mainActivity = new MainActivity ();
        mainActivity.userHome ();
    }

}
