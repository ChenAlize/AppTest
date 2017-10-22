package AppUtil;

import AppData.Locator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by chenbo on 2017/10/19.
 */
public class AppElement extends AppAction {

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
                    element = driver.findElement ( By.name ( locator.getElement () ) );
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
                    element = driver.findElements ( By.name ( locator.getElement () ) );
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

        String classname = this.getClass ().getSimpleName ();

        final Locator locator = new Locator ( element ,classname );

        try {
            new WebDriverWait ( driver , locator.getWaittime () ).until(new ExpectedCondition<List<WebElement>>() {
                @Override
                public List<WebElement> apply( WebDriver webDriver ) {
                    List<WebElement> element ;
                    switch ( locator.getByType()) {
                        case id:
                            element = driver.findElements ( By.id ( locator.getElement () ) );
                            break;
                        case name:
                            element = driver.findElements ( By.name ( locator.getElement () ) );
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
                    return element ;
                }
            });
            return true;
        } catch ( Exception e ){
            log.error( "【元素不存在】" + locator.getLocation() + " : " + locator.getElement() ,screenShot ());
            return false;
        }
    }

    /**
     * 点击元素
     * @param locator
     */
    public void click( String locator ){
        findElement ( locator ).click ();

        log.info ( "【点击】 ： " + locator ,screenShot ());
    }

    /**
     * 点击列表元素
     * @param locator
     * @param index
     */
    public void listClick( String locator , int index ){
        findElements ( locator ).get ( index ).click ();
        log.info ( "【点击】 ： " + locator ,screenShot ());

    }

    /**
     * 在元素内输入参数
     * @param locator
     */
    public void typing( String locator , String element ){
        findElement ( locator ).sendKeys ( element );
        log.info ( "【输入】  " +  locator +  " : " + element ,screenShot ());

    }

    /**
     * 获取元素内文本
     * @param locator
     * @return
     */
    public String getText( String locator ){
        String text = findElement ( locator ).getText ();
        log.info (  "【获取文本】 ： " + text ,screenShot ());

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

    /**
     * 按键：返回
     */
    public void back(){
        driver.pressKeyCode ( AndroidKeyCode.BACK );
        log.info ( "【返回】" , screenShot ());
    }

}
