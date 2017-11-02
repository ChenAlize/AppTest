package Util.Read;


import Util.Logger.Log;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by chenbo on 2017/10/18.
 */
public class ReadXml {

    Log log = new Log ( ReadXml.class );

    private Element elements;
    private Document doc ;

    public  ReadXml(){

    }

    public  ReadXml(String path){
        SAXReader reader = new SAXReader (  );
        try {
            doc = reader.read ( new File ( path )  );
        } catch (DocumentException e) {
            e.printStackTrace ();
        }
    }

    public void setElements( Element root ){
        elements = root;
    }

    public Element getRootElement(){
        Element root = doc.getRootElement ();
        return root;
    }

    public void next( Element root , String nodes ){
        if ( !root.getName ().equals ( nodes )){
            List<Element> node = root.elements ( );
            for ( Element e : node ){
                next ( e , nodes );
            }
        }else {
            setElements ( root );
        }
    }

    static List<Element> list = new ArrayList <Element> (  );

    public List<Element> selectNode(Element root , String node ){
        List<Element> ele = root.elements ();
        for ( Element e : ele ) {
           String nodeName = e.getName ();
           boolean ssk = nodeName.equals ( node );
           if ( ssk ) {
               list.add ( e );
           }
        }
        for ( Element e : ele ){
            selectNode(e , node);
        }
        return list;
    }

    /**
     * xml 读取手机配置
     * @param phoneMobile
     * @return
     */
    public HashMap<String,String> readXml(String phoneMobile ){

        String path = ReadXml.class.getClassLoader ().getResource ( "AppConfig.xml" ).getFile ();

        log.info ( "【配置路径】：" + path );

        SAXReader reader = new SAXReader ( );
        Map<String,String> map = new HashMap ();
        try {
            Document doc = reader.read ( path );
            Element element = doc.getRootElement ();    //根节点<appconfig>
            Iterator<Element> iterator = element.elementIterator ();    //一级子节点<cellphone>

            while ( iterator.hasNext () ){
                Element ele = iterator.next ();     //一级子节点<cellphone>  递归遍历
                if ( ele.attributeValue("name").equals( phoneMobile ) && ele != null ) {       //判读手机符合型号
                        Iterator<Element> ite = ele.elementIterator ();         //二级子节点 <appValue>等
                    while ( ite.hasNext () ) {
                        Element e = ite.next ();            //二级子节点   递归
                        map.put ( e.getName () , e.getText () );        //

                        log.info ( "【节点】：" + e.getName () + " <-> 【值】：" + e.getText ()  );

                    }
                }
            }

        } catch (DocumentException e) {
            log.error ( "【读取配置失败】" + phoneMobile );
            e.printStackTrace ();
        }
        return (HashMap <String, String>) map;
    }

}
