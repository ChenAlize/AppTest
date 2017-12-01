package BenLai;

import Factory.ElementFactory.FindElement;
import Solutions.MainActivity;
import Solutions.Welcome;
import Util.ReDB.Select;
import Util.TestUtil.ReInitialize;

/**
 * Created by chenbo on 2017/11/16.
 */
public class TestBase extends ReInitialize{

    public FindElement Test = new FindElement ();

    public void welcome(){
        Welcome.welcome ();
    }

    public void userHome(){

    }

    public String sms( String phone ){
        Select select = new Select ( "192.169.60.49" );
        return select.sms ( phone );
    }

}
