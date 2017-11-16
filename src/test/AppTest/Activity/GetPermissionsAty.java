package Activity;

import Factory.ElementFactory.MobileElement;
import Util.ReFile.ReFile;

/**
 * Created by chenbo on 2017/11/4.
 */
public class GetPermissionsAty extends MobileElement {

    public GetPermissionsAty() {


        String path = ReFile.writePage ( driver , this.getClass ().getSimpleName ());
        setPath ( path );
    }

}
