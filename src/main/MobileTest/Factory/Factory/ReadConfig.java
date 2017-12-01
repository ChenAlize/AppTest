package Factory.Factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadConfig {

    public List<Element> path(){
        String path = ReadConfig.class.getClassLoader().getResource("Config.xml").getPath();
        SAXReader reader = new SAXReader ( );
        Document doc = null;
        try {
            doc = reader.read ( new File ( path )  );

        } catch (DocumentException e) {
            e.printStackTrace ();
        }
        Element element = doc.getRootElement ();
        List<Element> list = element.elements ( "add" );
        return list;
    }

    public Map<String,String> getMap(){
        Map<String,String> map = new HashMap();
        java.util.List<Element> list = path();
        for ( Element e : list ){
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            map.put( name , value );
        }
        return map;
    }

    public String Config( String key){
        Map<String,String> map = getMap();
        String value = map.get( key );
        System.out.println ( "配置：" + key + "=" + value  );
        return value;
    }

}
