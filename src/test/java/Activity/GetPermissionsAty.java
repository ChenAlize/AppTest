package Activity;

import AppUtil.MobileElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/11/4.
 */
public class GetPermissionsAty extends MobileElement {

    public GetPermissionsAty(AndroidDriver driver) {
        super ( driver );
        String path = ReFile.writePage ( driver , this.getClass ().getSimpleName ());
        super.setPath ( path );
    }

    public void permissionsClick(){
        clickButton ( "确定" );
    }
}
