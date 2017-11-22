package Util.ReFile;

import Locator.MobileLocator;
import io.appium.java_client.android.AndroidDriver;

import java.io.*;

/**
 * Created by chenbo on 2017/10/26.
 */
public class ReFile {

    static String Activity = null ;
    static String Page = null ;

    public enum FileType{
        XML , HTML ,TXT , BAT , CSS , JS , JAVA , JSON , JSP , YML , PNG , JPG
    }

    /**
     * 不区分大小写获取文件类型
     * @param file
     * @return
     */
    public static FileType fileType( String file ){
        //小写转大写
        String type = file.toUpperCase();
        //大写转小写
//        file.toLowerCase ();
        return ReFile.FileType.valueOf ( type );
    }

    /**
     * 创建目录
     * @param destDirName
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {// 判断目录是否存在
            System.out.println( "【目录】：" + dir);
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {// 创建目标目录
            System.out.println("创建目录成功！" + destDirName);
            return true;
        } else {
            System.out.println("创建目录失败！");
            return false;
        }
    }

    /**
     * 创建文件
     */
    public static String createFile( String Activity , String filetype ){
        String files = ReString.pathFile( Activity , filetype );
        File file = new File( files );
        if ( file.isDirectory() ){
            if ( !file.exists() ){
                ReFile.createDir( files );
            }
        } else if ( !file.getParentFile().exists() ) {
            file.getParentFile().mkdirs();
        }
        if ( !file.exists() ){
            try {
                file.createNewFile ();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return files;
    }

    /**
     * 将文件写入到指定文件中
     * @param pageElement
     * @param path
     */
    public static void write( String pageElement , String path ){
        System.out.println ( path );
        System.out.println ( pageElement );
        pageElement = pageElement.replace( ">\n" , ">" ).replace( ">" , ">\n" );
        Writer outputStream = null;
        try {
            outputStream = new OutputStreamWriter( new FileOutputStream( new File( path ) ) , "UTF-8" );
            outputStream.append( pageElement );
            if ( null != outputStream ){
                outputStream.close();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * x写入页面元素到指定文件
     * @param driver
     * @param clazzname
     */
    public static String writePage(AndroidDriver driver , String clazzname ){
        String pageName = driver.currentActivity ();
        String element = driver.getPageSource ();
        String path = pageName ;
        String pathDir = ReString.pathDir ( pageName );
        String pathFile = ReString.pathFile ( path , "xml" );
        createDir ( pathDir );
        write ( element , pathFile  );
        return pathFile;
    }

    public static void PageSource( AndroidDriver driver ){
        String nowActivity = driver.currentActivity ();
        String nowPage = driver.getPageSource ();
        String path = null ;
        if ( Activity == null && nowActivity != null || Activity != nowActivity ){
            Activity = nowActivity;
            path = createFile ( Activity , "xml" );
        }
        if ( nowPage != null ) {
            Page = nowPage;
            write ( Page, path );
        }
        MobileLocator.Xml ( path );
    }
}
