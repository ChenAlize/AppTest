package Util.ReFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenbo on 2017/10/27.
 */
public class ReDate {

    /**
     * 获取当前时间格式
     */
    public static java.lang.String nowData ( ) {
        Date date = new Date();
        return new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss").format(date);
    }


}
