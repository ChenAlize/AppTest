package Util.Read;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelFactory {

    public static Workbook readExcel(String file , InputStream stream ){
        String classname = null;
       String  filetype =  file.substring ( file.lastIndexOf ( "." ) + 1 );
        if (filetype.equalsIgnoreCase ( "xls" )){
            classname = "org.apache.poi.hssf.usermodel.HSSFWorkbook";
        }
        if ( filetype.equalsIgnoreCase ( "xlsx" ) ){
            classname = "org.apache.poi.xssf.usermodel.XSSFWorkbook";
        }
        try {

            Class<?> claxx = Class.forName ( classname );
//获取带参构造方法，传入对象的参数类型
            Constructor constructor = claxx.getConstructor( InputStream.class );

            return (Workbook) constructor.newInstance ( stream );

        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (NoSuchMethodException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (InvocationTargetException e) {
            e.printStackTrace ();
        }

        return null;
    }


}
