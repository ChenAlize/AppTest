package Util.TestUtil;

import Util.Logger.Log;
import org.testng.Assert;

/**
 * Created by chenbo on 2017/10/25.
 */
public class ReAssert {

    static Log log = new Log ( ReAssert.class );

    /**
     * 布尔值判断
     * @param b
     * @param msg
     */
    public static void isTrue( boolean b , String msg) {
        try {
            Assert.assertTrue ( b  , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：True\n实际值：" + b );
        }
    }

    public static void isFalse( boolean b , String msg) {
        try {
            Assert.assertFalse ( b  , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：False\n实际值：" + b );
        }
    }

    /**
     * 相等判断
     * @param Expected
     * @param Actual
     * @param msg
     */
    public static void isSame( Object Expected ,Object Actual , String msg ) {
        try {
            Assert.assertSame ( Expected  , Actual , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：" + Expected + "\n实际值：" + Actual );
        }
    }

    public static void isNotSame(Object Expected ,Object Actual , String msg ) {
        try {
            Assert.assertNotSame ( Expected , Actual , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：" + Expected + "\n实际值：" + Actual );
        }
    }

    /**
     * 相等判断，必须是相同类型，支持数组，迭代器，set ,map ......
     * @param Expected
     * @param Actual
     * @param msg
     */
    public static void isEquals(Object Expected ,Object Actual , String msg ) {
        try {
            Assert.assertEquals ( Expected , Actual , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：" + Expected + "\n实际值：" + Actual );
        }
    }

    public static void isNotEquals(Object Expected ,Object Actual , String msg ) {
        try {
            Assert.assertNotEquals ( Expected , Actual , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch (  AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：" + Expected + "\n实际值：" + Actual );
        }
    }

    /**
     * 判断是否为 null
     * @param o
     * @param msg
     */
    public static void isNull ( Object o , String msg ) {
        try {
            Assert.assertNull ( o , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch ( AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：Null" + "\n实际值：" + o );
        }
    }

    public static void isNotNull ( Object o , String msg ) {
        try {
            Assert.assertNotNull ( o , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch ( AssertionError error ){
            log.error ( "【Fail】 ：" + msg + "断言失败！\n期望值：NotNull" + "\n实际值：" + o );
        }
    }

    /**
     * 忽略顺序是否相等判断
     * @param Expected
     * @param Actual
     * @param msg
     */
    public static void isEqualsNoOrder ( Object[] Expected ,Object[] Actual , String msg ) {
        try {
            Assert.assertEqualsNoOrder ( Expected , Actual , msg );
            log.info ( "【Pass】 : " + msg +" 断言成立！ "  );
        } catch ( AssertionError error ){
            log.error ( "【Fail】 ：" + msg +  "断言失败！\n期望值：" + Expected + "\n实际值：" + Actual );
        }
    }

}
