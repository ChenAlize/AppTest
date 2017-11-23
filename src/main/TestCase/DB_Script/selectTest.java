package DB_Script;

import Util.ReDB.Select;

/**
 * Created by chenbo on 2017/11/21.
 */
public class selectTest {

    @org.testng.annotations.Test(enabled = true)
    public void test() {
        Select select = new Select ( "192.168.60.49" );
        String sms = "111111";
        sms = select.sms ( "13312341032" );
//       sms = select.sms_SMS ( "13312341234" );
        select.close ();
        System.out.println ( sms );

    }
}
