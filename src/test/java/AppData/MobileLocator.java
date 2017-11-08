package AppData;

import Util.Read.ReadXml;
import com.android.uiautomator.core.UiSelector;
import org.dom4j.Element;
import org.jsoup.nodes.Entities;

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

    public String mobileText(){
        String ss = null;
        if ( attributeOnly ( id )){
            ss = String.valueOf ( new UiSelector ().resourceId ( id ) );
        } else if ( attributeOnly ( text )){
            ss = String.valueOf ( new UiSelector ().text ( text ) );
        } else if ( elementOnly ( id ) ){
            ss = String.valueOf ( new UiSelector ().className ( className ).resourceId ( id ) );
        } else if ( elementOnly ( text ) ) {
            ss = String.valueOf ( new UiSelector ().className ( className ).text ( text ) );
        } else if ( elementOnly ( index ) ) {
            ss = String.valueOf ( new UiSelector ().className ( className ).index ( Integer.getInteger ( index )) );
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
        if ( attribut == text ){
            number =  xml.attributeNumber ( "text" , attribut );
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
