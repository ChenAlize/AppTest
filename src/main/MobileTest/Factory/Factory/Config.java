package Factory.Factory;

import Util.Read.ReadXml;
import org.dom4j.Element;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static ReadXml path(){
        ReadXml xml = new ReadXml();
        String path = Config.class.getClassLoader().getResource("Config.xml").getPath();
        xml.Xml( path );
        return xml;
    }

    public static Map<String,String> getMap(){
        Map<String,String> map = new HashMap();
        java.util.List<Element> list = path().getNodes("add");
        for ( Element e : list ){
            String name = e.attributeValue("name");

            String value = e.attributeValue("value");

            map.put( name , value );
        }
        return map;
    }

    public static String Config( String key){
        Map<String,String> map = getMap();
        return map.get( key );
    }

}
