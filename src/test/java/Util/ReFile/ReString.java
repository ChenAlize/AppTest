package Util.ReFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbo on 2017/10/27.
 */
public class ReString {

    /**
     * 用"."分割字符串，保存到list中
     * @param str
     * @return
     */
    public static List<String> folder( String str ){

        //String.split() 分割字符串到数组
        String[] s = str.split ( "\\." );
        List<String> stringList = new ArrayList <String> ();
        for ( int i = 0 ; i< s.length ; i++ ){
            stringList.add ( s[i] );
        }
        return stringList;
    }

    /**
     * 拼接绝对路径到工程目录下
     * @param pageName
     * @return
     */
    public static String pathUrl ( String pageName ) {
        String path = System.getProperty ( "user.dir" );
        List<String> list = ReString.folder ( pageName );
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

}
