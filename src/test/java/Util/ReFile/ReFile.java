package Util.ReFile;

import java.io.*;

/**
 * Created by chenbo on 2017/10/26.
 */
public class ReFile {

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
            System.out.println("创建目录失败，目标目录已存在！");
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
     * 创建XML文件
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

}
