package Factory.ElementFactory;

/**
 * Created by chenbo on 2017/11/14.
 */
public class FindElement extends MobileElement {

    public void click( String node , String element ){
        findElement ( node,element ).click ();
    }

    public void input( String node , String element , String value ){
        findElement ( node,element ).sendKeys ( value );
    }
}
