package DB_Script;

import Factory.Factory.Config;
import Factory.Factory.ReadConfig;
import Util.ReDB.Select;

/**
 * Created by chenbo on 2017/11/21.
 */
public class selectTest {

    @org.testng.annotations.Test(enabled = true)
    public void test() {
        String url = Config.trunk;
        Select select = new Select ( url );
        String sms = "111111";
        sms = select.sms ( "13312341020" );
//       sms = select.sms_SMS ( "13312341011" );
        select.close ();
        System.out.println ( sms );

    }
}
