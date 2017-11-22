package Factory.ElementFactory;

import Locator.MobileLocator;
import Util.Logger.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

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

        MobileLocator.UiSelect ( node );
        return driver.findElement ( MobileLocator.mobileBy () );
    }

    /**
     * 显示等待单个Locator元素出现
     * @param
     * @return
     */
    public WebElement findElement ( final String node  ){

        WebDriverWait wait = new WebDriverWait ( driver , 3 );
        WebElement androidelement = null;
        try {
            androidelement = wait.until ( new ExpectedCondition<WebElement> () {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return getFindElement ( node );
                }
            } );
        }catch ( Exception e ){
            log.error ( "定位超时！" );
        }
        System.out.println ( androidelement );
        return androidelement;
    }
}
