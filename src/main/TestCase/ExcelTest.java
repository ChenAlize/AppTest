import Data.Dictionary;
import Solutions.GetPermissionsActivity;
import Solutions.MainActivity;
import Util.Read.ExcelPOI;
import Util.Read.ExcelValue;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelTest {

    @org.testng.annotations.Test
    public void test() {

        Map<String,Dictionary> map = ExcelValue.excelValue ( GetPermissionsActivity.class );
        Map<String,Dictionary> main = ExcelValue.excelValue ( MainActivity.class );
        Dictionary dictionary = map.get ("Permission_Allow");
        Dictionary MainDic = main.get ( "userHome" );
        Iterator <Map.Entry <String, Dictionary>> entrys = map.entrySet ().iterator ();
        Map.Entry entry;
        int i = 0;
        while (entrys.hasNext ()){
            entry = entrys.next ();
            System.out.println ( i + "  :" + entry.getKey () + "=" + entry.getValue () );
            i++;
        }

        System.out.println ( dictionary.path );
        System.out.println ( MainDic.path );
        // 获得当前类名
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        // 获得当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println ( clazz );
        System.out.println ( method );

    }

    @org.testng.annotations.Test
    public void testindex(){
        ExcelPOI excelPOI = new ExcelPOI ();
        Workbook workbook = excelPOI.getWorkBook ( "Dictionary.xlsx" );
        Sheet sheet = workbook.getSheet ( GetPermissionsActivity.class.getSimpleName () );
        Util.Read.Sheet biao = new Util.Read.Sheet ();
        biao.setSheet ( sheet );
        System.out.println ( biao.getIndex ( "KeyWord" ));
        System.out.println ( biao.getCell ( "B2" ));
    }

    @Test
    public void testAs(){
        String cell_1 = "Ba";
        String cell_2 = "a2";

    }


}
