package Util.ReFile;

import java.io.File;
import java.io.IOException;

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

    public static void createFile( String pageName ){
        File file = new File ( pageName );
        try {
            if (!file.exists ()){
                file.createNewFile ();
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}
