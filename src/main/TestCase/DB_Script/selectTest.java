package DB_Script;

import Factory.Factory.Config;
import Util.ReDB.Select;
import Util.ReDB.Update;

/**
 * Created by chenbo on 2017/11/21.
 */
public class selectTest {

    int cell = 33   ;

    @org.testng.annotations.Test(enabled = true)
    public void test() {
        String phon = "133123410" + String.valueOf ( cell );
        String url = Config.TRUNK;
        Select select = new Select ( url );
        String sms = "111111";
        sms = select.sms ( phon );
//       sms = select.sms_SMS ( "13312341011" );
        select.close ();
        System.out.println ( sms );

    }

    @org.testng.annotations.Test( enabled = true)
    public void CustomerBalance(){
        String phon = "133123410" + String.valueOf ( cell );
        String url = Config.TRUNK;

        Select select = new Select ( url );

        int customerSysNo = select.CustomerSysNo ( phon ) ;

        Update update = new Update ( url );
        //修改账户余额
        update.CustomerBalance ( "199" , customerSysNo );
        select.close ();
        update.close ();
    }
}
