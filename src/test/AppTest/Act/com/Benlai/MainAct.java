package Act.com.Benlai;

import Activity.MainAty;
import Activity.UserHomeAty;
import AppUtil.ActivityFactory;
import io.appium.java_client.android.AndroidDriver;

public class MainAct  {

    static AndroidDriver driver;

    public static void setDriver(AndroidDriver driver){
        MainAct.driver = driver ;
    }

    public static AndroidDriver getDriver(){
        return MainAct.driver ;
    }
    /**
     * 启动进入个人中心
     */
    public static UserHomeAty toUserHome(){
        WelcomeAct.setDriver( getDriver() );
        WelcomeAct.welcome();
        MainAty mainAty = new MainAty( getDriver() );
        mainAty.clickPackageClose();
        mainAty.clickUserHome();
        return (UserHomeAty) ActivityFactory.atyFactory(UserHomeAty.class , getDriver() );
    }

    /**
     * 启动进入城市列表
     */
    public void toCity(){
        MainAty mainAty = new MainAty( driver );
        mainAty.clickPackageClose();
        mainAty.clickTvCity();
    }

    /**
     * 启动进入分类
     */
    public void toCateGory(){
        MainAty mainAty = new MainAty( driver );
        mainAty.clickPackageClose ();
        mainAty.clickCategory ();
    }
}
