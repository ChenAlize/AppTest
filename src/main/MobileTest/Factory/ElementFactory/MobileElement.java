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

    MobileLocator locator;

    Log logger = new Log ( MobileElement.class );

    public void setPath( String path ){ locator = new MobileLocator ( path );
    }
    /**
     * 通过定位器定位单个元素
     * @param
     * @return
     */
    public WebElement getFindElement( String node , String element  ){
        logger.info ( " 开始查找元素：" + node );
        locator.UiSelect ( node , element);
        return driver.findElement ( locator.mobileBy () );
    }

    /**
     * 显示等待单个Locator元素出现
     * @param
     * @return
     */
    public WebElement findElement ( final String node , final String element ){

        WebDriverWait wait = new WebDriverWait ( driver , 3 );
        WebElement Androidelement = null;
        try {
            Androidelement = wait.until ( new ExpectedCondition<WebElement> () {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return getFindElement ( node , element);
                }
            } );
        }catch ( Exception e ){
            log.error ( "定位超时！" );
        }
        return Androidelement;
    }
}
