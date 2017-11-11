package AppData;

import Util.Read.ReadXml;
import io.appium.java_client.MobileBy;
import org.dom4j.Element;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by chenbo on 2017/10/31.
 */
public class MobileLocator {

    private ReadXml xml = new ReadXml ();
    private Element element ;
    private String index ;
    private String text;
    private String className;
    private String packageName;
    private String name ;
    private String bounds;
    private String id ;
    private String instance;

    public By mobileText(){
        By ss = null;
        if ( attributeOnly ( id )){
            ss = MobileBy.id ( id );
        } else if ( attributeOnly ( name )){
            ss = MobileBy.AccessibilityId ( name );
        } else if ( elementOnly ( id ) ){
            ss = MobileBy.xpath ( "//"+className+"[@resource-id='" +id + "']" );
        } else if ( elementOnly ( text ) ) {
            ss = MobileBy.xpath ( "//"+className+"[@text='" +text + "']" );
        } else if ( elementOnly ( index ) ) {
            ss = MobileBy.xpath ( "//"+className+"[@index='" +index + "']" );
        }
        return ss;
    }

    public MobileLocator(String path){ xml.Xml ( path ); }

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
    public boolean attributeOnly( String attribut ){
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
    public boolean elementOnly( String attribut ){
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
