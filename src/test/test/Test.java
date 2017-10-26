import Util.ReDB.JdbcLink;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenbo on 2017/10/25.
 */
public class Test {

    @org.testng.annotations.Test
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
}




