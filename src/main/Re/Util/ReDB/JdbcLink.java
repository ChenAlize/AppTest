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

    private Connection connection = null ;
    private Statement statement = null ;

    private String userName = "sa";
    private String passWrod = "cc.123";

    public JdbcLink( String Url ){

            if ( Url == null || Url.equals ( "" )){
                 Url = "192.168.60.49";
            }
            if ( connection != null ){
                Close ();
            }
            DB ( Url );
    }

    /**
     * 链接数据库
     * @param Url
     */
    private void DB ( String Url ) {
        String sqlDriver = null ;
        String DB_Url = null ;
        String db = "SQLServer";
        if ( db.equalsIgnoreCase ( "SQLServer" ) ) {        //忽略大小写判断字符串相等
            sqlDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            DB_Url = "jdbc:sqlserver://" + Url + ":1433;databaseName=BenLaiSales";
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
    public ResultSet select(String sql){
        ResultSet resultSet = null ;
        try {
            resultSet = statement.executeQuery ( sql );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return resultSet;
    }
    /**
     * 数据库更改 执行一个SQL语句：UPDATE，INSERT或DELETE语句
     * @param sql
     */
    public void update( String sql ){
        int resultSet = 0 ;
        try {
            resultSet = statement.executeUpdate ( sql );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
       System.out.println ( resultSet + "行受影响！" );
    }
    /**
     * 清除资源
     */
    public void Close(){
        try {
            if ( statement != null || connection != null ) {
                statement.close ();
                connection.close ();
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
