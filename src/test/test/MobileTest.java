import Activity.GetPermissionsAty;
import Factory.ElementFactory.MobileElement;
import Util.TestUtil.ReInitialize;
import io.appium.java_client.MobileBy;

import java.net.MalformedURLException;


/**
 * Created by chenbo on 2017/11/8.
 */
public class MobileTest extends ReInitialize{

    @org.testng.annotations.Test
    public void mobileTest() throws InterruptedException, MalformedURLException {

        MobileElement element = new MobileElement ();
        element.scrollLevel ( 1000, 100, 1000 );
        element.scrollLevel ( 1000, 100, 1000 );
        element.coordinateClick ( 314,1671 );

//        element.driver.findElement ( MobileBy.xpath ( "//android.widget.Button[@text='确定']" ) ).click ();
        element.driver.findElement ( MobileBy.xpath ( "//android.widget.Button[@text='始终允许']" ) ).click ();
        element.driver.findElement ( MobileBy.xpath ( "//android.widget.Button[@text='始终允许']" ) ).click ();
        element.driver.findElement ( MobileBy.xpath ( "//android.widget.Button[@text='始终允许']" ) ).click ();
        java.lang.Thread.sleep ( 5000 );

        element.driver.findElement ( MobileBy.AccessibilityId ( "关闭" ) ).click ();
//      driver.findElement ( By.xpath ( "//android.widget.Button[@text='立即领取']" ) ).click ();
        element.driver.quit ();

    }
}
