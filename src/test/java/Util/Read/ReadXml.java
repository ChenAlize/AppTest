package Util.Read;


import AppData.Elelocator;
import Util.Logger.Log;
import org.dom4j.Attribute;
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

    static List<Element> selectlist = new ArrayList <Element> ( );
    static List<Element> tlist = new ArrayList <Element> ( );

    public  ReadXml(){}

    /**
     * 读取xml文件，创建 Document 对象
     * @param path  xml文件路径
     */
    public void Xml(String path){
        SAXReader reader = new SAXReader (  );
        try {
            doc = reader.read ( new File ( path )  );
        } catch (DocumentException e) {
            e.printStackTrace ();
        }
    }

    public void setElements( Element root ){ elements = root;}
    /**
     * 获取跟节点
     */
    public Element getRootElement(){
        Element root = doc.getRootElement ();
        return root;
    }

    /**
     * 获取指定节点 List<Element>
     * @param root 父节点
     * @param node 筛选的节点名称
     * @return
     */
    private List<Element> selectNode(Element root , String node ){
        List<Element> ele = root.elements ();
        for ( Element e : ele ) {
           String nodeName = e.getName ();
           boolean ssk = nodeName.equals ( node );
           if ( ssk ) {
               selectlist.add ( e );
           }
        }
        for ( Element e : ele ){
            selectNode(e , node);
        }
        return selectlist;
    }

    /**
     * 获取所以节点 List<Element>
     * @param root 父节点
     * @return
     */
    public List<Element> allNode(Element root ){
        List<Element> ele = root.elements ();
        for ( Element e : ele ) {
            tlist.add ( e );
        }
        for ( Element e : ele ){
            allNode( e );
        }
        return tlist;
    }

    /**
     * 获取当前节点的path路径
     * @param element
     * @return
     */
    public String getpath( Element element ){
        return element.getPath ();
    }
    /**
     * 通过属性，在相同的节点中定位到元素节点
     * @param element
     * @param attribute
     * @return
     */
    public Element getElement(List<Element> element , String attribute){
        for ( Element e : element  ) {
            if (e.attributeValue ( "text" ).equals ( attribute )) {
                setElements ( e );
            }
            if (e.attributeValue ( "index" ).equals ( attribute )) {
                setElements ( e );
            }
            if (e.attributeValue ( "content-desc" ).equals ( attribute )) {
                setElements ( e );
            }
            if (e.attributeValue ( "bounds" ).equals ( attribute )) {
                setElements ( e );
            }
        }
        return elements;
    }

    /**
     * 查询控件
     */
    public List<Element> getNodes( String node ){
        Element root = getRootElement ();
        List<Element> list = new ArrayList <Element> ();
        if ( node.equalsIgnoreCase ( "TextView" )){
            list = selectNode ( root , "android.widget.TextView" );
        }
        if ( node.equalsIgnoreCase ( "ImageView" )){
            list = selectNode ( root , "android.widget.ImageView" );
        }
        if ( node.equalsIgnoreCase ( "View" )){
            list = selectNode ( root , "android.widget.View" );
        }
        if ( node.equalsIgnoreCase ( "Button" )){
            list = selectNode ( root , "android.widget.Button" );
        }
        if ( node.equalsIgnoreCase ( "ImageButton" )){
            list = selectNode ( root , "android.widget.ImageButton" );
        }
        return list;
    }

    /**
     * 获取当前节点的所以attribute 保存到map中
     * @param node
     * @return
     */
    public Map<String, String> getAttribute(Element node){
        Map<String, String> map = new HashMap <String, String> (  );
        List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
        for(Attribute attr:listAttr){       //遍历当前节点的所有属性
            String name=attr.getName();     //属性名称
            String value=attr.getValue();   //属性的值
            map.put ( name , value );
        }
        return map;
    }

    public List<String> selectAttribute( String select){
        Element root = getRootElement ();
        List<Element> list = allNode ( root );
        Map<String, String> map ;
        List<String > text = new ArrayList <String> (  );
        for (int i = 0; i < list.size () ; i++ ){
            Element e = list.get ( i );
            map = getAttribute ( e );
            String value = map.get ( select );
            if ( value!= null && !value.equals ( "" )){
                text.add ( value );
            }
        }
        return text;
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
