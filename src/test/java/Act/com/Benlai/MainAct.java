package Act.com.Benlai;

import Act.ActBase;
import Activity.MainAty;
import io.appium.java_client.android.AndroidDriver;

public class MainAct extends ActBase {

    public MainAct(AndroidDriver driver) { super(driver); }

    public MainAty mainAty = new MainAty( driver );

    /**
     * 进入个人中心
     */
    public void toUserHome(){
        mainAty.clickPackageClose();
        mainAty.clickUserHome();
    }

    /**
     * 进入城市
     */
    public void toCity(){
        mainAty.clickPackageClose();
        mainAty.clickTvCity();
    }

    public void toCateGory(){
        mainAty.clickPackageClose ();
        mainAty.clickCategory ();
    }
}
