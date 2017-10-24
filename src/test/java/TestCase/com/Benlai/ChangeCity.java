package TestCase.com.Benlai;

import Act.com.Benlai.CategoryAct;
import Act.com.Benlai.CityAct;
import Act.com.Benlai.MainAct;
import TestCase.AppTest;
import Util.TestUtil.Initialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/23.
 */
public class ChangeCity extends Initialize{

    @Test ( enabled = true ,priority = 0 ,dependsOnMethods = { "TestCase.com.Benlai.Start_App.mate_9" } )
    public void mainToBeiJing(){
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toBeiJing ();
    }

    @Test ( enabled = true , priority = 1 ,dependsOnMethods = { "TestCase.com.Benlai.Start_App.mate_9" } )
    public void mainToShangHai(){
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toShangHai ();
    }

    @Test ( enabled = true , priority = 2 ,dependsOnMethods = { "TestCase.com.Benlai.Start_App.mate_9" } )
    public void mainToGuangZhou (){
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toGuangZhou ();
    }

    @Test ( enabled = true , priority = 3 , dependsOnMethods = "TestCase.com.Benlai.Start_App.mate_9" )
    public void categoryToBeiJing(){
        MainAct mainAct = new MainAct ( AppTest.driver );
        mainAct.toCateGory ();
        mainAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toBeiJing ();
    }

    @Test ( enabled = true , priority = 4 , dependsOnMethods = "TestCase.com.Benlai.Start_App.mate_9" )
    public void categoryToShangHai (){
        CategoryAct categoryAct = new CategoryAct ( AppTest.driver );
        categoryAct.toCity ();
        CityAct cityAct = new CityAct ( AppTest.driver );
        cityAct.toShangHai ();
    }

}
