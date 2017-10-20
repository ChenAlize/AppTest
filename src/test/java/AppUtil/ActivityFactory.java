package AppUtil;

import Util.Report.Log;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Constructor;

/**
 * Created by chenbo on 2017/10/11.
 */
public class ActivityFactory {

    static Log log = new Log ( ActivityFactory.class );
    /**
     * 反射--跳转页面
     * @param clazz
     * @param driver
     * @return
     */
    public static Object atyFactory(Class clazz , AndroidDriver driver){

        //获取对象名称
        String classname = clazz.getCanonicalName ();

        Object object = null;
        try {
            //创建类对象
            Class claxx = Class.forName ( classname );
            //获取类对象的公告构造方法
            Constructor constructor = claxx.getConstructor ( AndroidDriver.class );
            //object指向类对象
            object = constructor.newInstance ( driver );
        } catch (Exception e) {
            log.error ( "【页面跳转失败】  目标页面： " + classname );
        }
        log.info ( "【页面跳转成功】"  + classname );
        return object;
    }
}
