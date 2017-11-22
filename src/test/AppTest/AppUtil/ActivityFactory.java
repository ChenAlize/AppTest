package AppUtil;

import Util.Logger.Log;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Constructor;

/**
 * Created by chenbo on 2017/10/11.
 */
public class ActivityFactory {

    static Log logger = new Log ( ActivityFactory.class );
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

//            /**
//             * 将当前页面元素信息写入XML文件中
//             */
//            //获取当前activity
//            String activity = driver.currentActivity();
//            logger.info("【当前】：" + activity );
//            //获取当前页面元素信息
//            String pageElement = driver.getPageSource();
//            System.out.println( pageElement );
//            //生成xml文件
//            String path = ReFile.createFile( activity , "xml" );
//            //将当前页面元素信息写入XML文件中
//            ReFile.write( pageElement , path );

        } catch (Exception e) {
            logger.error ( "【页面跳转失败】  目标页面： " + classname );
        }
        logger.info ( "【页面跳转成功】" );
        return object;
    }
}
