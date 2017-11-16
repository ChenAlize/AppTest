/**
 * Created by chenbo on 2017/11/16.
 */
public class LoginTest extends TestBase{

    @org.testng.annotations.Test
    public void loginTest(){
        welcome ();
        click ( "Button" , "text=\"确定\"" );
        click ( "Button" , "text=\"始终允许\"" );
        click ( "Button" , "text=\"始终允许\"" );
        click ( "Button" , "text=\"始终允许\"" );
        click ( "ImageButton" , "content-desc=\"关闭\"" );
        userHome();
        click ( "TextView" , "text=\"登录/注册\"" );
        input( "EditText" , "text=\"请输入您的手机号\"" , "13312345678" );
        click ( "Button" , "text=\"获取验证码\"" );
    }
}
