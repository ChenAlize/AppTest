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
    private static  ReadXml xml = new ReadXml () ;
    private  Element element ;
    private  String index ;
    private  String text;
    private  String className;
    private  String packageName;
    private  String name ;
    private  String bounds;
    private  String id ;
    private  String instance;

    public By mobileBy(){
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
                        }else {

            ss = MobileBy.id ( id );
            log.info ( "id定位：" + id );
//                    xpath = "//" + element.getPath ();
//                    ss = MobileBy.xpath ( xpath );
//                    log.info ( "xpath定位：" + xpath );
        }
        return ss;
    }

    public static void Xml( String path ){
        xml.Xml ( path );
        System.out.println ( "读取文件：" + path );
    }

    public void UiSelect( String select ){
        log.info ( " 开始查找元素：" + select );
        String[] a = select.split ( ";" );
        String node = a[0];
        String value = a[1];
        List<Element> list = xml.getNodes ( "android.widget." + node );
        element = xml.getElement ( list , value );
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

    public  void setValue() {
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
    public  boolean attributeOnly( String attribut ){
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
    public  boolean elementOnly( String attribut ){
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
