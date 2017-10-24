package TestCase.com.Benlai;

import Act.com.Benlai.WelcomeAct;
import TestCase.AppTest;
import Util.TestUtil.Initialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/24.
 */
public class Start_App extends Initialize {

    @Test ( enabled = true , priority = 0 )
    public void mate_9 (){
        AppTest.init ( "HAWEI Mate 9" );
        //欢迎
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        welcomeAct.welcome ();
    }
}
