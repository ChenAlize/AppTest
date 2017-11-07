package AppUtil;

import AppData.Elelocator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chenbo on 2017/11/7.
 */
public class AppCreateElement extends AppKey {

    public AppCreateElement(AndroidDriver driver) {
        super ( driver );
    }

    Elelocator elelocator;

    public void setPath( String path ){
        elelocator = new Elelocator ( path );
    }

    public void clickButton( String select){
        elelocator.Button ( select );
        System.out.println ( "查找元素：" + select );
        findElement ( ).click ();
    }

    /**
     * 通过定位器定位单个元素
     * @param
     * @return
     */
    public WebElement getFindElement( ){
        WebElement element = null ;
        if ( elelocator.getId () != null ) {
            element = driver.findElement ( By.id ( elelocator.getId () ) );
        }
        return element;
    }

    /**
     * 显示等待单个Locator元素出现
     * @param
     * @return
     */
    public WebElement findElement ( ){

        WebDriverWait wait = new WebDriverWait ( driver , 3 );
        WebElement Androidelement = null;
        try {
            Androidelement = wait.until ( new ExpectedCondition<WebElement> () {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return getFindElement ();
                }
            } );
        }catch ( Exception e ){
        }
        return Androidelement;
    }
}
