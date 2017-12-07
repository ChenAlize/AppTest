package Factory.ElementFactory;

import Locator.AppAction;
import Locator.MobileLocator;
import Util.Logger.Log;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chenbo on 2017/11/7.
 */
public class MobileElement extends Intersection {

    Log logger = new Log ( MobileElement.class );

    /**
     * 通过定位器定位单个元素
     * @param
     * @return
     */
    public WebElement getFindElement( String node ){
        MobileLocator locator = new MobileLocator ();
        locator.UiSelect ( node );
        By by = locator.mobileBy ();
        logger.info ( "定位方式：" + by );
        WebElement element = driver.findElement ( by );
        System.out.println ( element );
        return element;
    }

    /**
     * 显示等待单个Locator元素出现
     * @param
     * @return
     */
    public WebElement findElement ( final String node  ){

        WebDriverWait wait = new WebDriverWait ( driver , 6 );
        WebElement androidelement = null;
                try {
                    androidelement = wait.until ( new ExpectedCondition <WebElement> () {
                        @Override
                        public WebElement apply(WebDriver webDriver) {
                            return getFindElement ( node );
                        }
                    } );
                }catch ( Exception e ){
                    logger.error ( "定位超时！！！" );
                }
        return androidelement;
    }

    public AppAction appElement( String node){
        ReFile.PageSource ( driver );
        AndroidElement element = (AndroidElement) findElement ( node );
        AppAction appAction = new AppAction ();
        appAction.setAndroidElement ( element );
        return appAction;
    }

}
