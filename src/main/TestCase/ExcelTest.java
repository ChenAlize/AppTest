import Data.Dictionary;
import Factory.Factory.Config;
import Solutions.GetPermissionsActivity;
import Util.Read.ExcelFile;
import Util.Read.ExcelValue;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by chenbo on 2017/12/1.
 */
public class ExcelTest {

    @org.testng.annotations.Test
    public void test() {

        Map<String,Dictionary> map = ExcelValue.excelValue ( GetPermissionsActivity.class );
        Dictionary dictionary = map.get ("Permission_Allow");
        System.out.println ( dictionary.path );
        // 获得当前类名
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        // 获得当前方法名
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println ( clazz );
        System.out.println ( method );


    }

}
