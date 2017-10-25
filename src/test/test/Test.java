import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by chenbo on 2017/10/25.
 */
public class Test {

    @org.testng.annotations.Test
    public void tets(){
        // JDBC mysql driver
         final String JDBC_MySql_DRIVER = "com.mysql.jdbc.Driver";
        // JDBC sqlserver driver
         final String JDBC_SqlServer_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //
         final String DB_URL = "jdbc:mysql://192.168.60.245:1433/BenLaiSales";

        final String benlaisales = "jdbc:sqlserver://192.168.60.245:1433;databaseName=BenLaiSales";

        //  Database credentials -- 数据库名和密码自己修改
         final String USER = "sa";
         final String PASS = "cc.1234";

        try {

            Class.forName ( JDBC_SqlServer_DRIVER );

            Connection com = DriverManager.getConnection ( benlaisales , "sa" , "cc.123" );

            Statement statement = com.createStatement ();

            String sql = "select Avgpoint,SOSysNo FROM SO_ITEM WHERE SOSYSNO=900166377";

            ResultSet resultSet = statement.executeQuery ( sql );

            while ( resultSet.next () ){
                int Avgpoint = resultSet.getInt ( "Avgpoint" );
                int SOSysNo = resultSet.getInt ( "SOSysNo" );
                System.out.println ( Avgpoint );
                System.out.println ( SOSysNo );
            }

            resultSet.close ();
            statement.close ();
            com.close ();

        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
