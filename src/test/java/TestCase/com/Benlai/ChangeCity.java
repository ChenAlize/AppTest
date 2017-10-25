package TestCase.com.Benlai;

import Act.com.Benlai.CategoryAct;
import Act.com.Benlai.CityAct;
import Act.com.Benlai.MainAct;
import Act.com.Benlai.UserHomeAct;
import Act.com.Benlai.WelcomeAct;
import TestCase.AppTest;
import Util.TestUtil.ReInitialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/23.
 */
public class ChangeCity extends ReInitialize {

    @Test ( enabled = true ,priority = 0  )
    public void mainToCity(){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        MainAct mainAct = new MainAct ( AppTest.driver );
        CityAct cityAct = new CityAct ( AppTest.driver );
        //欢迎
        welcomeAct.welcome ();
        //北京
        mainAct.toCity ();
        cityAct.toBeiJing ();
        //上海
        mainAct.mainAty.clickTvCity ();
        cityAct.toShangHai ();
        //广州
        mainAct.mainAty.clickTvCity ();
        cityAct.toGuangZhou ();
        AppTest.end ();
    }

    @Test ( enabled = true , priority = 1  )
    public void categoryToCity(){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        MainAct mainAct = new MainAct ( AppTest.driver );
        CategoryAct categoryAct = new CategoryAct ( AppTest.driver );
        CityAct cityAct = new CityAct ( AppTest.driver );
        //欢迎
        welcomeAct.welcome ();
        //进入“分类”
        mainAct.toCateGory ();
        //北京
        categoryAct.categoryAty.clickTvCity();
        cityAct.toBeiJing ();
        //上海
        categoryAct.categoryAty.clickTvCity();
        cityAct.toShangHai ();
        //广州
        categoryAct.categoryAty.clickTvCity();
        cityAct.toGuangZhou ();
        AppTest.end ();
    }

    @Test ( enabled = true , priority = 2  )
    public void homeToCity (){
        AppTest.init ( "HAWEI Mate 9" );
        WelcomeAct welcomeAct = new WelcomeAct ( AppTest.driver );
        MainAct mainAct = new MainAct ( AppTest.driver );
        UserHomeAct userHomeAct = new UserHomeAct ( AppTest.driver );
        CityAct cityAct = new CityAct ( AppTest.driver );
        //欢迎
        welcomeAct.welcome ();
        //进入个人中心
        mainAct.toUserHome ();
        //北京
        userHomeAct.userHomeAty.clickTvCity ();
        cityAct.toBeiJing ();
        //上海
        userHomeAct.userHomeAty.clickTvCity ();
        cityAct.toShangHai ();
        //广州
        userHomeAct.userHomeAty.clickTvCity ();
        cityAct.toGuangZhou ();
        AppTest.end ();
    }

}
