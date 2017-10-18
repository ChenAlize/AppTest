package Util;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;


import java.util.Iterator;
import java.util.List;

/**
 * Created by chenbo on 2017/10/18.
 */
public class ReadXml {

    Log log = new Log ( this.getClass () );

    public void readXml( String name ,String classname ){

        String path = ReadXml.class.getClassLoader ().getResource ( classname + ".xml" ).getFile ();

        log.info ( path );
        SAXReader reader = new SAXReader ( );

        try {
            Document doc = reader.read ( path );
            Element element = doc.getRootElement ();
            log.info ( "根节点：" + element.getName () );

            List<Element> config = element.elements ( name );
            for( Element e: config ){
                log.info ( e.element ( "appPackage" ).attributeValue ( "name" ) );
                log.info ( e.element ( "appActivity" ).getText () );

            }

        } catch (DocumentException e) {
            e.printStackTrace ();
        }
    }


}
