package Util.ReFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenbo on 2017/10/27.
 */
public class ReString {

    /**
     * 用"."分割字符串，保存到list中
     * @param str
     * @return
     */
    public static List<String> folderPoint( String str , int index ){

        //String.split() 分割字符串到数组
        String[] s = str.split ( "\\." );
        List<String> stringList = new ArrayList <String> ();
        for ( int i = 0 ; i< s.length + index ; i++ ){
            stringList.add ( s[i] );
        }
        return stringList;
    }

    /**
     * 当前目录下创建文件路径
     * @param pageName
     * @return
     */
    public static String pathFile ( String pageName , String pathtype ) {
        String path = System.getProperty ( "user.dir" );
        List<String> list = ReString.folderPoint ( pageName , 0 );
        String suffix = suffix( ReFile.fileType( pathtype ) );

        for ( String i : list ){
            String fileStr = File.separator + i ;
            path = path + fileStr;
        }
       return path + suffix;
    }

    /**
     * 拼接绝对路径到工程目录下
     * @param pageName
     * @return
     */
    public static String pathDir ( String pageName ) {
        String path = System.getProperty ( "user.dir" );
        List<String> list = ReString.folderPoint ( pageName , -1 );
        for ( String i : list ){
            String fileStr = File.separator + i ;
            path = path + fileStr;
        }
        return path;
    }



    /**
     * 生成对应的后缀名
     * @param type
     * @return
     */
    public static String suffix( ReFile.FileType type ){
        String suf = null ;
        switch ( type ){
            case XML: suf = ".xml";break;
            case JS: suf = ".js" ;break;
        }
        return suf ;
    }

    public static String code( String SMS){
        String regEx = "[^0-9]";//匹配指定范围内的数字

        //Pattern是一个正则表达式经编译后的表现模式
        Pattern p = Pattern.compile(regEx);

        // 一个Matcher对象是一个状态机器，它依据Pattern对象做为匹配模式对字符串展开匹配检查。
        Matcher m = p.matcher(SMS);

        //将输入的字符串中非数字部分用空格取代并存入一个字符串
        return m.replaceAll ( "" ).substring ( 0,6 );
    }

}
