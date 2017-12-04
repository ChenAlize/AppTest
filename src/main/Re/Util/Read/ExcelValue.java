package Util.Read;

import Data.Dictionary;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelValue {

    public static Map<String,Dictionary> excelValue( Class<?> className ){
        ExcelFile excelFile = new ExcelFile ();
        Workbook workbook = excelFile.getWorkBook ( "Dictionary.xlsx" );
        Sheet sheet = workbook.getSheet ( className.getSimpleName () );
        Map<String,Dictionary> map = new HashMap<String,Dictionary> ();
        int rowsStart = sheet.getFirstRowNum();
        //有效行数
//        int rowsEnd = sheet.getLastRowNum();
        //不为空的行数
        int rownotnull = sheet.getPhysicalNumberOfRows();

        for ( int i = rowsStart+1 ; i< rownotnull ; i++ ){
            Row row = sheet.getRow( i );
            List<String> list = excelFile.cellValue( row );
            Dictionary dictionary = excelFile.inputDictionary ( list );
            map.put ( list.get ( 0 ) , dictionary );
        }
        try {
            workbook.close ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
        return map;
    }

}
