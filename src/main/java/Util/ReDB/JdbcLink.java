package Util.ReDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by chenbo on 2017/10/26.
 */
public class JdbcLink {
    static Connection connection ;
    static Statement statement ;
    static ResultSet resultSet ;

    String Url = "192.168.60.49:1433" ;
    String userName = "sa";
    String passWrod = "cc.123";

    /**
     * 链接数据库
     * @param db
     */
    public void getConnection ( String db ) {
        String sqlDriver = null ;
        String DB_Url = null ;

        if ( db.equalsIgnoreCase ( "SQLServer" ) ) {        //忽略大小写判断字符串相等
            sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            DB_Url = "jdbc:sqlserver://" + Url + ";databaseName=BenLaiSales";
        }else if (db.equalsIgnoreCase ( "MYSQL" ) ){
            sqlDriver = "com.mysql.jdbc.Driver";
        } else if ( db.equalsIgnoreCase ( "oracle" )) {
            sqlDriver = "oracle.jdbc.driver.OracleDriver";
        }

        try {
            Class.forName ( sqlDriver );
            connection = DriverManager.getConnection (  DB_Url , userName , passWrod );
            statement = connection.createStatement ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public ResultSet getSelect( String sql ){

        try {

            resultSet = statement.executeQuery ( sql );

        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return resultSet;
    }

    /**
     * 清除资源
     */
    public void close(){
        try {
            statement.close ();
            connection.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
