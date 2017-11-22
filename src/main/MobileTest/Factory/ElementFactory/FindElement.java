package Factory.ElementFactory;

import Util.ReFile.ReFile;

/**
 * Created by chenbo on 2017/11/14.
 */
public class FindElement extends MobileElement {

    public void click( String node  ){
        ReFile.PageSource ( driver );
        findElement ( node ).click ();
    }

    public void input( String node , String value ){
        ReFile.PageSource ( driver );
        findElement ( node ).sendKeys ( value );
    }

    public void close(){
        driver.quit ();
    }
}
