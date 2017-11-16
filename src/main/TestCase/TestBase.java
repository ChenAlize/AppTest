import Factory.ElementFactory.FindElement;
import Solutions.MainActivity;
import Solutions.Welcome;

/**
 * Created by chenbo on 2017/11/16.
 */
public class TestBase extends FindElement{

    public void welcome(){
        Welcome.welcome ();
    }

    public void userHome(){
        MainActivity.userHome ();
    }

}
