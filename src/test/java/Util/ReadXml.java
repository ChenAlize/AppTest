package Util;


import Data.AppConfig;
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

    public void readXml( String name  ){

        String path = ReadXml.class.getClassLoader ().getResource ( "AppConfig.xml" ).getFile ();

        log.info ( path );

        SAXReader reader = new SAXReader ( );

        try {

            Document doc = reader.read ( path );

            Element element = doc.getRootElement ();

            List<Element> phone = element.elements("cellphone");

            String Value = element.element( "appValue" ).getText();
            String Package = element.element( "appPackage" ).getText();
            String Activity = element.element( "appActivity" ).getText();

            String Version = null;
            String udid = null;

            for ( Element e : phone ){
                if ( e.attributeValue("name").equals( name ) && e != null ){
                    Version = e.element( "platformVersion" ).getText();
                    udid = e.element( "udid" ).getText();
                }
            }

            new AppConfig( Value , Package , Activity , Version , udid );

//            log.info( Value );
//            log.info( Package );
//            log.info( Activity );
//            log.info( Version );
//            log.info( udid );

        } catch (DocumentException e) {
            e.printStackTrace ();
        }
    }


}
