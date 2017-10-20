package AppData;

import Util.Report.Log;
import Util.Reader.ReadXml;

import java.util.HashMap;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppConfig {

    Log log = new Log ( this.getClass () );

    private String appValue;         //APP版本
    private String appPackage;       //APP包名
    private String appActivity;      //APP的Activity
    private String cellphone;        //手机型号
    private String platformVersion;  //安卓系统版本
    private String udid;             //设备号
    private boolean isLogin = false ;        //是否已登录

    public AppConfig( String phone ){
        if ( phone == null || phone.equals ( "" ) ){
            cellphone = "HAWEI mate 9";
        }else {
            this.cellphone = phone;
        }
        ReadXml read = new ReadXml ();
        HashMap map = read.readXml ( cellphone  );
        this.appValue = map.get ( "appValue" ).toString ();
        this.appPackage = map.get ( "appPackage" ).toString ();
        this.appActivity = map.get ( "appActivity" ).toString ();
        this.platformVersion = map.get ( "platformVersion" ).toString () ;
        this.udid = map.get ( "udid" ).toString ();
    }

    public void setIsLogin( boolean islogin ){
        this.isLogin = islogin;
    }

    public boolean getIsLogin(){
        return this.isLogin;
    }
    public String getAppValue(){
        return this.appValue;
    }
    public String getAppPackage(){
        return this.appPackage;
    }
    public String getAppActivity(){
        return appActivity ;
    }
    public String getplatformVersion(){
        return this.platformVersion;
    }
    public String getudid(){
        return this.udid;
    }

}
