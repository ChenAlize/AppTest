package Util.ReDB;

import Util.ReFile.ReString;
import org.testng.annotations.Test;

import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenbo on 2017/10/26.
 */
public class Select extends JdbcLink{

    public Select( String DBUrl){
        super ( DBUrl );
    }
    /**
     * 查询手机验证码
     * @param value
     * @return
     */
    public String sms( String value ){
        String sql = "SELECT top 1 SMSContent FROM BenLaiSales..SMS WHERE CellNumber='" + value + "' ORDER BY CreateTime DESC" ;
        ResultSet select = select ( sql );
        String code = "000000";

            String SMS = null;
            try {
                while (select.next ()) {
                    SMS = select.getNString ( "SMSContent" );
                    System.out.println ( "SMSContent : " + SMS );
                }
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        if (SMS!=null) {

            code = ReString.code ( SMS );
        }
            try {
                select.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        return code;
    }
    /**
     * 查询小呈现手机验证码
     * @param value
     * @return
     */
    public String sms_SMS( String value ){
        String sql = "SELECT top 1 Content FROM SMS..SMS WHERE CellNumber='" + value + "' ORDER BY CreateTime DESC" ;
        ResultSet select = select ( sql );
        String string = "000000";
        String SMS = null;
        try {
            while(select.next()) {
                SMS = select.getNString ( "Content" );
                System.out.println ( "Content : " + SMS );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        if (SMS!=null){
            string = ReString.code ( SMS );
        }
        try {
            select.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return string;
    }

    public int  CustomerSysNo( String CustomerID){
        String sql = "select SysNo " +
                " from Customer " +
                " where Customerid='" +
                CustomerID +
                "' or SafeCellPhone= '" +
                CustomerID +
                "'";
        System.out.println ( sql );
        ResultSet select = select ( sql );
        int SysNo = 0;
        try {
            while(select.next()) {
                SysNo = select.getInt ( "SysNo" );
                System.out.println ( "SysNo : " + SysNo );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        try {
            select.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return SysNo;
    }

    public void close(){
        Close ();
    }


}
