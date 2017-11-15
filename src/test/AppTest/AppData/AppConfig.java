package AppData;

import Util.Logger.Log;
import Util.Read.ReadXml;

import java.util.HashMap;

/**
 * Created by chenbo on 2017/10/18.
 */
public class AppConfig {

    static Log log = new Log ( AppConfig.class );

    private static String appValue;         //APP版本
    private static String appPackage;       //APP包名
    private static String appActivity;      //APP的Activity
    private static String cellphone;        //手机型号
    private static String platformVersion;  //安卓系统版本
    private static String udid;             //设备号
    private static boolean isLogin = false ;        //是否已登录
    private static String logPath ;

    public AppConfig() {}

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
        this.logPath = map.get ( "logPath" ).toString ();
    }

    public static void setIsLogin( boolean login ){
        isLogin = login;
        if ( isLogin ){
            log.info ( "【登录成功】" );
        }
    }

    public static boolean getIsLogin(){
        return isLogin;
    }
    public static String getAppValue(){
        return appValue;
    }
    public static String getAppPackage(){
        return appPackage;
    }
    public static String getAppActivity(){
        return appActivity ;
    }
    public static String getplatformVersion(){
        return platformVersion;
    }
    public static String getudid(){
        return udid;
    }
    public static String getLogPath(){
        return new String ( System.getProperty ( "user.dir" ) + logPath );
    }

}
