package Util.Read;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelFile {

    private java.io.InputStream excelStream( String filename ){
        return ExcelFile.class.getClassLoader ().getResourceAsStream ( filename );
    }

    public Workbook getWorkBook( String filename ){
        return ExcelFactory.readExcel ( filename ,excelStream ( filename ) );
    }

}
