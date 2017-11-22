import Util.ReDB.JdbcLink;
import Util.ReFile.ReFile;
import Util.ReFile.ReString;
import Util.Read.ReadXml;
import Util.TestUtil.ReInitialize;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by chenbo on 2017/10/25.
 */
public class Test extends ReInitialize{

    @org.testng.annotations.Test(enabled = false)
    public void  test(){
        String element = "Button;text=\"确定\"";
        String[] a = element.split ( ";" );
        String classname = "android.widget." + a[0];
        String attribute = a[1];
        String[] b = attribute.split ( "=" );
        System.out.println ( classname );
        String key = b[0];
        String value = b[1].replaceAll ( "\"" , "" );
        System.out.println ( key );
        System.out.println ( value );
    }

    @org.testng.annotations.Test( enabled = false )
    public void getXpath() throws ParserConfigurationException, IOException, SAXException {

        List<String> attrFilter = new ArrayList<String>();
        String xpath = "";
//        attrFilter.add("android.widget.RelativeLayout");
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><hierarchy  rotation=\"0\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"1\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"android:id/content\" instance=\"2\"><android.widget.RelativeLayout index=\"0\" text=\"\" class=\"android.widget.RelativeLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.ImageView index=\"0\" text=\"\" class=\"android.widget.ImageView\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1308]\" resource-id=\"com.android.benlailife.activity:id/iv_dialog_red_package_image\" instance=\"0\"/><android.widget.Button index=\"1\" text=\"立即领取\" class=\"android.widget.Button\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[327,1008][753,1116]\" resource-id=\"com.android.benlailife.activity:id/btn_dialog_red_package_go\" instance=\"0\"/><android.widget.ImageButton index=\"2\" text=\"\" class=\"android.widget.ImageButton\" package=\"com.android.benlailife.activity\" content-desc=\"关闭\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[496,1452][583,1539]\" resource-id=\"com.android.benlailife.activity:id/ib_dialog_red_package_close\" instance=\"0\"/></android.widget.RelativeLayout></android.widget.FrameLayout></android.widget.FrameLayout></android.widget.FrameLayout></hierarchy>";
        StringReader reader = new StringReader ( xml );
        InputSource input = new InputSource ( reader );
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
        DocumentBuilder builder = factory.newDocumentBuilder ();
        Document doc = builder.parse ( input );
        org.w3c.dom.Element root = doc.getDocumentElement ();
        short type = root.getNodeType ();

        if ( type == Node.COMMENT_NODE ){
            xpath = xpath + "/" + root.getTagName ();
        }
        NamedNodeMap namedNodeMap = root.getAttributes();
        String nodeXpath = "[ ";
        System.out.println ( namedNodeMap.getLength () );

        for ( int i = 0; i < namedNodeMap.getLength(); i++) {
            Node attribute = namedNodeMap.item ( i );
            System.out.println ( attribute );

            if (attrFilter == null || attrFilter.size () == 0) {
                String nameAttr = " and @" + attribute.getNodeName () + "='"
                        + attribute.getNodeValue () + "'";
                System.out.println ( nameAttr );
                nodeXpath += nameAttr;

            }
            System.out.println ( nodeXpath );
        }
        ////        attrFilter.add("android.view.View");
////        String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
////                + "<doc>\n" + "    <person>\n" + "        <name>某人</name>\n"
////                + "        <adds>            \n"
////                + "            <add ID=\"10002\">\n"
////                + "                <BS>10002</BS>\n"
////                + "                <note>西安市太白路</note>\n"
////                + "            </add>\n" + "            <add ID=\"\">\n"
////                + "                <BS>10002</BS>\n"
////                + "                <note>空ID节点啊</note>\n"
////                + "            </add>\n" + "            <add>\n"
////                + "                <BS>10002</BS>\n"
////                + "                <note>空ID节点啊</note>\n"
////                + "            </add>\n" + "\t\t\t<add ID=\"10001\">\n"
////                + "\t\t\t\t<BS xmlns=\"10001\"/>\n"
////                + "                <note>西安市太白路2</note>\n"
////                + "            </add>\n" + "\t\t</adds>\n" + "    </person>\n"
////                + "    <other>\n" + "        <name ID=\"HEHE\">ASDF</name>\n"
////                + "    </other>\n" + "</doc>";
//
//        XmlErgodicTool xmlErgodic = new XmlErgodicTool();
//
//        List<XmlLeafBean> xmlLeafBeanList = xmlErgodic.getXmlLeafBeanList(
//                element, attrFilter);
//
//        for (XmlLeafBean xmlLeafBean : xmlLeafBeanList) {
//            System.out.println(xmlLeafBean.getXpath() + " , "
//                    + xmlLeafBean.getValue());
//        }
//
////        System.out.println("__________");
////
////        XmlErgodicTool xmlErgodicTool = new XmlErgodicTool();
////        List<XmlLeafBean> xmlLeafBeanList2 = xmlErgodicTool
////                .getXmlLeafBeanList(
////                        new File(
////                                "F:\\IdeaProJect\\AppTest\\com\\android\\benlai\\activity\\main\\MainActivity.xml"),
////                        attrFilter);
////        for (XmlLeafBean xmlLeafBean : xmlLeafBeanList2) {
////            System.out.println( xmlLeafBean.getXpath() + " , "
////                    + xmlLeafBean.getValue());
////        }
//

}

    /**
     * 读取XML
     * @throws DocumentException
     */
    @org.testng.annotations.Test(enabled = false )
    public void  readerXml() throws DocumentException {
        String  path = "com/android/benlai/activity/main/MainActivity/UserHomeAty.xml";
        ReadXml readXml = new ReadXml ();
        readXml.Xml ( path );
        Element root = readXml.getRootElement ();
        String xpath = "/";
        /*获取根节点下，所以节点名称为 "" 的节点 */
        java.util.List <Element> element = readXml.getNodes ( "TextView" );
        Element te = readXml.getElement ( element , "[375,307][704,412]" );

            xpath = xpath + te.getPath ();
            System.out.println ( "节点名称 ：" + te.getName ());
            System.out.println ( "节点的绝对路径：" + te.getPath ());
            System.out.println ( "当前节点の父节点："+te.getParent ());

        System.out.println ( "退换货节点ID："+ te.attributeValue ( "text" ));
        System.out.println ( xpath );
        org.dom4j.Node e = root.selectSingleNode ( xpath );
        System.out.println ( "节点名称 ：" + e.getName ());

    }

    /**
     * 写入文件
     */
    @org.testng.annotations.Test(enabled = false)
    public void write(){

        String pageName = "com.android.benlai.activity.main.MainActivity";
        String element = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><hierarchy rotation=\"0\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"1\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"android:id/content\" instance=\"2\"><android.widget.RelativeLayout index=\"0\" text=\"\" class=\"android.widget.RelativeLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.ImageView index=\"0\" text=\"\" class=\"android.widget.ImageView\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1308]\" resource-id=\"com.android.benlailife.activity:id/iv_dialog_red_package_image\" instance=\"0\"/><android.widget.Button index=\"1\" text=\"立即领取\" class=\"android.widget.Button\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[327,1008][753,1116]\" resource-id=\"com.android.benlailife.activity:id/btn_dialog_red_package_go\" instance=\"0\"/><android.widget.ImageButton index=\"2\" text=\"\" class=\"android.widget.ImageButton\" package=\"com.android.benlailife.activity\" content-desc=\"关闭\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[496,1452][583,1539]\" resource-id=\"com.android.benlailife.activity:id/ib_dialog_red_package_close\" instance=\"0\"/></android.widget.RelativeLayout></android.widget.FrameLayout></android.widget.FrameLayout></android.widget.FrameLayout></hierarchy>";
        String path = pageName + File.separator + this.getClass ().getSimpleName ();
        String pathDir = ReString.pathDir ( pageName );
        String pathFile = ReString.pathFile ( path , "xml" );
//        ReFile.createDir ( pathDir );
        ReFile.write ( element , pathFile  );
        System.out.println ( pathFile );

    }

    /**
     * 数据库链接操作
     */
    @org.testng.annotations.Test(enabled = false)
    public void tets(){
        // JDBC mysql driver
//         final String JDBC_MySql_DRIVER = "com.mysql.jdbc.Driver";
        // JDBC sqlserver driver
//         final String JDBC_SqlServer_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //
//         final String DB_URL = "jdbc:mysql://192.168.60.245:1433/BenLaiSales";

//        final String benlaisales = "jdbc:sqlserver://192.168.60.245:1433;databaseName=BenLaiSales";

        //  Database credentials -- 数据库名和密码自己修改
//         final String USER = "sa";
//         final String PASS = "cc.1234";

//            Class.forName ( JDBC_SqlServer_DRIVER );

//            Connection com = DriverManager.getConnection ( benlaisales , "sa" , "cc.123" );

//            Statement statement = com.createStatement ();

            String sql = "select Avgpoint,SOSysNo FROM benlaisales..SO_ITEM WHERE SOSYSNO=900166377";
            String sql2 = "SELECT CustomerSysNo,DeviceID FROM CustomerDB..AppCustomerDevice WHERE CustomerSysNo=7308371 order BY CreateTime DESC";

            JdbcLink jdbcLink = new JdbcLink ( "192.168.60.49" );

            ResultSet resultSet = jdbcLink.select ( sql2 );

            Map map = new HashMap ( );

        try {
            while ( resultSet.next () ){
                int CustomerID = resultSet.getInt ( "CustomerSysNo" );
                String DeviceID =  resultSet.getNString ( "DeviceID" ) ;
                map.put ( CustomerID , DeviceID );
             }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        System.out.println ( map.get ( 7308371 ) );
        jdbcLink.Close ();
    }

    /**
     * 数据格式转换
     */
    @org.testng.annotations.Test(enabled = false )
    public void date(){
        String newStr = "1332391500000";
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(Long.parseLong(newStr));
        cal.getTime(); //Thu Mar 22 12:45:00 CST 2012
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println(cal.get(Calendar.MONTH));
//        System.out.println(cal.get(Calendar.DATE));
//        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//        System.out.println(cal.get(Calendar.MINUTE));
//        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(String.format ( "%tF" , cal ));  //2012-03-22
        System.out.println(String.format ( "%tc" , cal ));  //星期四 三月 22 12:45:00 CST 2012
        System.out.println(String.format ( "%tD" , cal ));  //03/22/12
        System.out.println(String.format ( "%tT" , cal ));  //12:45:00
        Date date = new Date ();
        String str = String.format ( "%ts" , date );   //转换为时间戳(秒)
        String stra = String.format ( "%tQ" , date );  //转换为时间戳（毫秒）
        System.out.println( str );
        System.out.println( stra );

        int a = 10;
        String b = String.format ( "%s",a );   //转换为String类型
        System.out.println( b );
    }
}




