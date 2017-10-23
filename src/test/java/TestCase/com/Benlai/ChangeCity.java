package TestCase.com.Benlai;

import Act.com.Benlai.CityAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.WelcomeAct;
import TestCase.AppTest;
import Util.TestUtil.Initialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/23.
 */
public class ChangeCity extends Initialize{

    @Test(enabled = true)
    public void toBeiJing(){
        AppTest.init ();
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        welcomeAct.welcome ();
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toBeiJing ();
    }

    @Test(enabled = true)
    public void toShangHai(){
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toShangHai ();
        AppTest.end ();
    }
}
