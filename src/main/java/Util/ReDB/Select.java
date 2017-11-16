package Util.ReDB;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenbo on 2017/10/26.
 */
public class Select {

    JdbcLink db = new JdbcLink ();
    ResultSet select ;

    public Select(){
        db.getConnection ( "SQLServer" );
    }

    public String sms( String value ){
        String sql = "SELECT top 1 SMSContent FROM BenLaiSales..SMS WHERE CellNumber='" + value + "' ORDER BY CreateTime DESC" ;
        select = db.getSelect ( sql );
        String SMS = null;
        try {
            while(select.next()) {
                SMS = select.getNString ( "SMSContent" );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        String regEx = "[^0-9]";//匹配指定范围内的数字

        //Pattern是一个正则表达式经编译后的表现模式
        Pattern p = Pattern.compile(regEx);

        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
        Matcher m = p.matcher(SMS);

        //将输入的字符串中非数字部分用空格取代并存入一个字符串
        String string = m.replaceAll ( "" );

        db.close ();
        return string;
    }

    @Test
    public void test() throws SQLException {

        String sms = sms ( "13312340001" );
        System.out.println ( sms );

//
//        JdbcLink jdbcLink = new JdbcLink ();
//
//        jdbcLink.getConnection ( "SQLServer" );
//        String sql = "SELECT top 1 SMSCONTENT FROM BenLaiSales..SMS WHERE CellNumber='13312340001' ORDER BY CreateTime DESC" ;
//        ResultSet resultSet = jdbcLink.getSelect ( sql );
//        String SMS = null;
//        while(resultSet.next()) {//rs.next();
//            SMS =  resultSet.getNString ( "SMSCONTENT" ) ;
//        }
//        String regEx = "[^0-9]";//匹配指定范围内的数字
//
//        //Pattern是一个正则表达式经编译后的表现模式
//        Pattern p = Pattern.compile(regEx);
//
//        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
//        Matcher m = p.matcher(SMS);
//
//        //将输入的字符串中非数字部分用空格取代并存入一个字符串
//        String string = m.replaceAll ( "" );
//
//        System.out.println ( string );
    }
}
