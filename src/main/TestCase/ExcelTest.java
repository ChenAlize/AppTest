import Data.Dictionary;
import Factory.Factory.Config;
import Util.Read.ExcelFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelTest {

    @org.testng.annotations.Test
    public void test() throws IOException, ClassNotFoundException {
//        ExcelFile excelFile = new ExcelFile ();
//        Workbook workbook = excelFile.getWorkBook ( "Dictionary.xlsx" );
//        workbook.close ();

        Class dic = Class.forName("Data.Dictionary");
        Field[] fields =  dic.getFields();
        for ( Field F : fields){
            System.out.println( F );
        }

    }

}
