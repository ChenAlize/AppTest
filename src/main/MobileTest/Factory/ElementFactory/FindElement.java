package Factory.ElementFactory;

/**
 * Created by chenbo on 2017/11/14.
 */
public class FindElement extends MobileElement {

    public void click( String node  ){
        findElement ( node ).click ();
    }

    public void input( String node , String value ){
        findElement ( node ).sendKeys ( value );
    }
}
