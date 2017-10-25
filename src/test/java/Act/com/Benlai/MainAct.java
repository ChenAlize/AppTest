package Act.com.Benlai;

import Act.ActBase;
import Activity.MainAty;
import io.appium.java_client.android.AndroidDriver;

public class MainAct extends ActBase {

    public MainAct(AndroidDriver driver) { super(driver); }

    public MainAty mainAty = new MainAty( driver );

    /**
     * 启动进入个人中心
     */
    public void toUserHome(){
        mainAty.clickPackageClose();
        mainAty.clickUserHome();
    }

    /**
     * 启动进入城市列表
     */
    public void toCity(){
        mainAty.clickPackageClose();
        mainAty.clickTvCity();
    }

    /**
     * 启动进入分类
     */
    public void toCateGory(){
        mainAty.clickPackageClose ();
        mainAty.clickCategory ();
    }
}
