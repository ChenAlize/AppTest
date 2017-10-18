package Data;

import Util.Log;
import Util.ReadXml;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppConfig {
    Log log = new Log ( this.getClass () );
    private String appValue;         //APP版本
    private String appPackage;       //APP包名
    private String appActivity;      //APP的Activity
    private String cellphone = "HAWEI mate 9";        //手机型号
    private String platformVersion;  //安卓系统版本
    private String udid;             //设备号
    private int isLogin = 0 ;        //是否已登录

    public AppConfig(){
    }

    public AppConfig( String Value , String Package , String Activity ,String Version ,String DevicesID ){
        this.appValue = Value;
        this.appPackage = Package;
        this.appActivity = Activity;
        this.platformVersion = Version ;
        this.udid = DevicesID;
        log.info( appValue );
        log.info( appPackage );
        log.info( appActivity );
        log.info( platformVersion );
        log.info( udid );
    }

    public String getAppValue(){
        return this.appValue;
    }
    public String getAppPackage(){
        return this.appPackage;
    }
    public String getAppActivity(){
        return this.appActivity;
    }
    public String getplatformVersion(){
        return this.platformVersion;
    }
    public String getudid(){
        return this.udid;
    }



    @Test(enabled = true )
    public  void test(){
        ReadXml read = new ReadXml ();
        read.readXml ( cellphone  );
    }
}
