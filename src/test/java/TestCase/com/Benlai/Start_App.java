package TestCase.com.Benlai;

import Act.com.Benlai.MainAct;
import Act.com.Benlai.WelcomeAct;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/24.
 */
public class Start_App extends ReInitialize {

    @Test ( enabled = true , priority = 0 )
    public void mate_9 (){
        AppTest.init ( "HAWEI Mate 9" );
        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        welcomeAct.welcome ();
        MainAct mainAct = new MainAct ( AppTest.driver );
        //获取当前页面的Activity
        String aty = AppTest.driver.currentActivity ();
        System.out.println ( aty );
        String page = AppTest.driver.getPageSource ();
        System.out.println ( page );
        AppTest.end ();
    }
}
