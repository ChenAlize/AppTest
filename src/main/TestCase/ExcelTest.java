import Util.Read.ExcelFile;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelTest {

    @org.testng.annotations.Test
    public void test() throws IOException {
        ExcelFile excelFile = new ExcelFile ();
        Workbook workbook = excelFile.getWorkBook ( "Dictionary.xlsx" );
        workbook.close ();

    }
}
