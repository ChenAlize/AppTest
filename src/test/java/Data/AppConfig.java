package Data;

import Util.ReadXml;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppConfig {
    private String appValue;         //APP版本
    private String appPackage;       //APP包名
    private String appActivity;      //APP的Activity
    private String cellphone;        //手机型号
    private String platformVersion;  //安卓系统版本
    private String udid;             //设备号
    private int isLogin = 0 ;        //是否已登录

    public AppConfig(){

    }

    public AppConfig( String appValue , String appPackage , String appActivity , String cellphone ,String platformVersion ,String udid){
        this.appValue = appValue;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.cellphone = cellphone;
        this.platformVersion = platformVersion ;
        this.udid = udid;
    }

    public String getAppValue(){
        return this.appValue;
    }

    public void xml(){
        ReadXml readXml = new ReadXml ();
        readXml.readXml ( "Android" , this.getClass ().getSimpleName ());
    }

    @Test(enabled = true )
    public  void test(){
        AppConfig appConfig = new AppConfig (  );
        appConfig.xml ();
    }
}
