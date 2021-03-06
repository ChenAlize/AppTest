package TestCase.com.Benlai;

import Act.com.Benlai.LoginAct;
import Act.com.Benlai.UserHomeAct;
import AppData.AppConfig;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class LoginTest extends ReInitialize {

    @Test(enabled = true  , priority = 3 )
    public void LoginTest(){
        AppTest.init ( "HAWEI Mate 9" );
        UserHomeAct userHomeAct = new UserHomeAct ( AppTest.driver );
        userHomeAct.userHomeAty.clickCenterLogin ();
        //帐号密码登录
        LoginAct loginAct = new LoginAct ( AppTest.driver );
        loginAct.Login ();
        System.out.println ( "【是否登录成功】<?> " + AppConfig.getIsLogin () );
        AppTest.end ();

    }

}
