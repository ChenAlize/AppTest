package AppUtil;

import AppData.Locator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.List;

/**
 * Created by chenbo on 2017/10/19.
 */
public class AppElement extends AppKey {

    public AppElement(AndroidDriver driver) {
        super ( driver );
    }

    /**
     * 通过定位器定位单个元素
     * @param locator
     * @return
     */
    public WebElement getFindElement( Locator locator ){
        WebElement element = null ;
        try {
            switch (locator.getByType ()) {
                case id:
                    element = driver.findElement ( By.id ( locator.getElement () ) );
                    break;
                case name:
                    element = driver.findElementByAccessibilityId ( locator.getElement () );
                    if ( element == null ){
                        element = driver.findElement( By.name ( locator.getElement () ));
                    }
                    break;
                case xpath:
                    element = driver.findElement ( By.xpath ( locator.getElement () ) );
                    break;
                case tagName:
                    element = driver.findElement ( By.tagName ( locator.getElement () ) );
                    break;
                case linkText:
                    element = driver.findElement ( By.linkText ( locator.getElement () ) );
                    break;
                case className:
                    element = driver.findElement ( By.className ( locator.getElement () ) );
                    break;
                case cssSelector:
                    element = driver.findElement ( By.cssSelector ( locator.getElement () ) );
                    break;
                case partialLinkText:
                    element = driver.findElement ( By.partialLinkText ( locator.getElement () ) );
                    break;
                default:
                    element = driver.findElement ( By.id ( locator.getElement () ) );
                    break;
            }
        }catch ( Exception e ){
            log.error ( "【元素定位失败】： " + locator.getLocation () , screenShot () );

        }
        return element;
    }

    /**
     * 通过定位器定位多个元素
     * @param locator
     * @return
     */
    public List<WebElement> getFindElements(Locator locator ){
        List<WebElement> element = null ;
        try {
            switch (locator.getByType ()) {
                case id:
                    element = driver.findElements ( By.id ( locator.getElement () ) );
                    break;
                case name:
                    element = driver.findElementsByAccessibilityId ( locator.getElement () );
                    break;
                case xpath:
                    element = driver.findElements ( By.xpath ( locator.getElement () ) );
                    break;
                case tagName:
                    element = driver.findElements ( By.tagName ( locator.getElement () ) );
                    break;
                case linkText:
                    element = driver.findElements ( By.linkText ( locator.getElement () ) );
                    break;
                case className:
                    element = driver.findElements ( By.className ( locator.getElement () ) );
                    break;
                case cssSelector:
                    element = driver.findElements ( By.cssSelector ( locator.getElement () ) );
                    break;
                case partialLinkText:
                    element = driver.findElements ( By.partialLinkText ( locator.getElement () ) );
                    break;
                default:
                    element = driver.findElements ( By.id ( locator.getElement () ) );
                    break;
            }
        }catch ( Exception e ){
            log.error ( "【元素定位失败】 ： " + locator.getLocation () ,screenShot () );

        }
        return element;
    }

    /**
     * 显示等待单个Locator元素出现
     * @param element
     * @return
     */
    public WebElement findElement (final String element ){

        String classname = this.getClass ().getSimpleName ();
        final Locator locator = new Locator ( element ,classname );

        WebDriverWait wait = new WebDriverWait ( driver , locator.getWaittime () );
        WebElement Androidelement = null;
        try {
            Androidelement = wait.until ( new ExpectedCondition <WebElement> () {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return getFindElement ( locator );
                }
            } );
        }catch ( Exception e ){
            log.error ( "【查找元素超时】：" + element +":"+ locator.getElement () );
        }
        return Androidelement;
    }

    /**
     * 显示等待多个Locator元素出现
     * @param element
     * @return
     */
    public List<WebElement> findElements (final String element ){
        String classname = this.getClass ().getSimpleName ();
        final Locator locator = new Locator ( element ,classname );
        WebDriverWait wait = new WebDriverWait ( driver , locator.getWaittime () );

        List<WebElement> elementList = null;
        try {
        elementList = wait.until ( new ExpectedCondition <List <WebElement>> () {
            @Override
            public List <WebElement> apply(WebDriver webDriver) {
                return getFindElements ( locator );
            }
        } );
        }catch ( Exception e ){
            log.error ( "【查找元素超时】：" + element +":"+ locator.getElement () );
        }
        return elementList;
    }

    /**
     * 判断元素是否存在
     * @param element
     * @return
     */
    public boolean isExist( String element ){

        if ( findElement ( element ) == null || findElements ( element ) == null ){
            log.info ( "【元素不存在】" + element ,screenShot ());
            return false;
        } else {
            log.info ( "【元素存在】" + element ,screenShot ());
            return true;
        }
    }

    /**
     * 点击元素
     * @param locator
     */
    public void click( String locator ){
        WebElement element = findElement ( locator );
        if ( element == null ){
            log.info ( "【元素不存在】"  ,screenShot ());
        } else {
            element.click ();
            log.info ( "【点击】 ： " + locator, screenShot () );
        }
    }

    /**
     * 点击列表元素
     * @param locator
     * @param index
     */
    public void listClick( String locator , int index ){
        List<WebElement> elements = findElements ( locator );
        if ( index < elements.size () || elements == null ){
            elements.get ( index ).click ();
            log.info ( "【点击】 ： " + locator ,screenShot ());
        } else {
            log.error ( "【控件不存在】 ： " + locator , screenShot () );
        }
    }

    /**
     * 在元素内输入参数
     * @param locator
     */
    public void typing( String locator , String input ){

        WebElement element = findElement ( locator );

        if ( element == null || input == null || input.equals ( "" ) ) {
            log.info ( "【元素不存在】" + element ,screenShot ());
        } else {
            element.sendKeys ( input );
            log.info ( "【输入】  " + locator + " : " + input, screenShot () );
        }
    }

    /**
     * 获取元素内文本
     * @param locator
     * @return
     */
    public String getText( String locator ){
        WebElement element = findElement ( locator );
        String text = null;
        if ( element != null ) {
             text = element.getText ();
             log.info (  "【获取文本】 ： " + text ,screenShot ());
        } else {
            log.info ( "【元素不存在】" + element ,screenShot ());
        }
        return text;
    }

    /**
     * 获取列表元素内文案
     * @param locator
     * @param index
     * @return
     */
    public String getListText( String locator , int index ){
        String text = findElements ( locator ).get ( index ).getText ();
        log.info (  "【获取文本】 ： " + text ,screenShot ());

        return text;
    }

}
