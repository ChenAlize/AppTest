import Util.ReDB.JdbcLink;
import Util.ReFile.ReFile;
import Util.ReFile.ReString;
import Util.TestUtil.ReInitialize;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by chenbo on 2017/10/25.
 */
public class Test extends ReInitialize{


    @org.testng.annotations.Test(enabled = true)
    public void write() throws IOException {

        String pageName = "com.android.benlai.activity.main.MainActivity";

        String element = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<hierarchy rotation=\"0\">\n<android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"1\"><android.widget.FrameLayout index=\"0\" text=\"\" class=\"android.widget.FrameLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"android:id/content\" instance=\"2\"><android.widget.RelativeLayout index=\"0\" text=\"\" class=\"android.widget.RelativeLayout\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1539]\" resource-id=\"\" instance=\"0\"><android.widget.ImageView index=\"0\" text=\"\" class=\"android.widget.ImageView\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"false\" enabled=\"true\" focusable=\"false\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[135,344][945,1308]\" resource-id=\"com.android.benlailife.activity:id/iv_dialog_red_package_image\" instance=\"0\"/><android.widget.Button index=\"1\" text=\"立即领取\" class=\"android.widget.Button\" package=\"com.android.benlailife.activity\" content-desc=\"\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[327,1008][753,1116]\" resource-id=\"com.android.benlailife.activity:id/btn_dialog_red_package_go\" instance=\"0\"/><android.widget.ImageButton index=\"2\" text=\"\" class=\"android.widget.ImageButton\" package=\"com.android.benlailife.activity\" content-desc=\"关闭\" checkable=\"false\" checked=\"false\" clickable=\"true\" enabled=\"true\" focusable=\"true\" focused=\"false\" scrollable=\"false\" long-clickable=\"false\" password=\"false\" selected=\"false\" bounds=\"[496,1452][583,1539]\" resource-id=\"com.android.benlailife.activity:id/ib_dialog_red_package_close\" instance=\"0\"/></android.widget.RelativeLayout></android.widget.FrameLayout></android.widget.FrameLayout></android.widget.FrameLayout></hierarchy>";

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

            JdbcLink jdbcLink = new JdbcLink ();

            jdbcLink.getConnection ( "SQLServer" );

            ResultSet resultSet = jdbcLink.getSelect ( sql2 );

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
        jdbcLink.close ();
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




