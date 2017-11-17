import Factory.ElementFactory.FindElement;
import Solutions.MainActivity;
import Solutions.Welcome;
import Util.ReDB.Select;

/**
 * Created by chenbo on 2017/11/16.
 */
public class TestBase extends FindElement{

    Select select = new Select ();

    public void welcome(){
        Welcome.welcome ();
    }

    public void userHome(){
        MainActivity.userHome ();
    }

    public String sms( String phone ){
        return select.sms ( phone );
    }

}
