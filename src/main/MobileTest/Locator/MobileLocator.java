package Locator;

import Util.Read.ReadXml;
import io.appium.java_client.MobileBy;
import org.dom4j.Element;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by chenbo on 2017/10/31.
 */
public class MobileLocator {
    static Util.Logger.Log log = new Util.Logger.Log ( MobileLocator.class );
    private static ReadXml xml = new ReadXml ();
    private static Element element ;
    private static String index ;
    private static String text;
    private static String className;
    private static String packageName;
    private static String name ;
    private static String bounds;
    private static String id ;
    private static String instance;

    public static By mobileBy(){
        By ss = null;
        java.lang.String xpath ;
        if ( attributeOnly ( id )){
            ss = MobileBy.id ( id );
            log.info ( "id定位：" + id );

            } else if ( attributeOnly ( name )){
                ss = MobileBy.AccessibilityId ( name );
                log.info ( "AccessibilityId定位：" + name );

                } else if ( elementOnly ( id ) ){
                    xpath = "//"+className+"[@resource-id='" +id + "']" ;
                    ss = MobileBy.xpath ( xpath );
                    log.info ( "xpath定位：" + xpath );

                    } else if ( elementOnly ( text ) ) {
                        xpath = "//"+className+"[@text='" +text + "']" ;
                        ss = MobileBy.xpath ( xpath );
                        log.info ( "xpath定位：" + xpath );

                        } else if ( elementOnly ( index ) ) {
                            xpath = "//"+className+"[@index='" +index + "']" ;
                            ss = MobileBy.xpath ( xpath );
                            log.info ( "xpath定位：" + xpath );
                        }
        return ss;
    }

    public MobileLocator( String path ){ xml.Xml ( path ); }

    public void Button( String select ){
        List<Element> list = xml.getNodes ( "Button" );
        element = xml.getElement ( list , select );
        setValue();
    }

    public void TextView( String select ){
        List<Element> list = xml.getNodes ( "TextView" );
        element = xml.getElement ( list , select );
        setValue();
    }

    public void ImageView( String select ){
        List<Element> list = xml.getNodes ( "ImageView" );
        element = xml.getElement ( list , select );
        setValue();
    }

    public void View( String select ){
        List<Element> list = xml.getNodes ( "View" );
        element = xml.getElement ( list , select );
        setValue();
    }

    public void ImageButton( String select ){
        List<Element> list = xml.getNodes ( "ImageButton" );
        element = xml.getElement ( list , select );
        setValue();
    }

    public Element getElement() {
        return element;
    }
    public String getIndex() {
        return index;
    }
    public String getClassName() {
        return className;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public String getInstance() {
        return instance;
    }
    public String getPackageName() {
        return packageName;
    }

    public void setValue() {
          index = element.attributeValue ( "index" ) ;
          text = element.attributeValue ( "text" );
          className = element.attributeValue ( "class" );
          packageName = element.attributeValue ( "package" );
          name = element.attributeValue ( "content-desc" );
          bounds = element.attributeValue ( "bounds" );
          id = element.attributeValue ( "resource-id" );
          instance = element.attributeValue ( "instance" );
    }

    /**
     * attribute 唯一性确定
     * @param attribut
     * @return
     */
    public static boolean attributeOnly( String attribut ){
        boolean only = false ;
        int number = 0 ;
        if ( attribut == id ){
            number =  xml.attributeNumber ( "resource-id" , attribut );
        }
        if ( attribut == name ){
            number =  xml.attributeNumber ( "content-desc" , attribut );
        }
       if ( number == 1 ){
           only = true;
       }
       return only;
    }

    /**
     * element 唯一性确定
     * @param attribut
     * @return
     */
    public static boolean elementOnly( String attribut ){
        boolean only = false ;
        int number = 0 ;
        if ( attribut == id ){
            number =  xml.elementNumber ( className , "resource-id" , attribut );
        }
        if ( attribut == text ){
            number =  xml.elementNumber ( className ,"text" , attribut );
        }
        if ( attribut == index ){
            number =  xml.elementNumber ( className ,"index" , attribut );
        }
        if ( number == 1 ){
            only = true;
        }
        return only;
    }
}
