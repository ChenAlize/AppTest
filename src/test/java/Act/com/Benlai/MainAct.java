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
        if ( mainAty.isPackage()){ mainAty.clickPackageClose(); }
        mainAty.clickUserHome();
    }

    /**
     * 进入城市
     */
    public void toCity(){
        if ( mainAty.isPackage() ){
            mainAty.clickPackageClose();
        }
        mainAty.clickTvCity();
    }
}
