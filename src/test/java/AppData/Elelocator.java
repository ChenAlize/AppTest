package AppData;

import Util.Read.ReadXml;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by chenbo on 2017/10/31.
 */
public class Elelocator {

    private ReadXml xml = new ReadXml ();
    private Element element ;
    private int index ;
    private String text;
    private String className;
    private String packageName;
    private String content ;
    private String bounds;
    private String id ;
    private String instance;

    public Elelocator( String path){ xml.Xml ( path ); }

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
    public int getIndex() {
        return index;
    }
    public String getBounds() {
        return bounds;
    }
    public String getClassName() {
        return className;
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
          index = Integer.parseInt ( element.attributeValue ( "index" ) );
          text = element.attributeValue ( "text" );
          className = element.attributeValue ( "class" );
          packageName = element.attributeValue ( "package" );
          content = element.attributeValue ( "content-desc" );
          bounds = element.attributeValue ( "bounds" );
          id = element.attributeValue ( "resource-id" );
          instance = element.attributeValue ( "instance" );
    }
}
