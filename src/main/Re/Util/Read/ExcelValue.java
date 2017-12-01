package Util.Read;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelValue {

    public void excelValue( Class<?> className ){
        ExcelFile excelFile = new ExcelFile ();
        Workbook workbook = excelFile.getWorkBook ( "Dictionary.xlsx" );

        Sheet sheet = workbook.getSheet ( className.getSimpleName () );

        Map map = new HashMap ();

        try {
            workbook.close ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
