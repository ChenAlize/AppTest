package Activity;

import AppUtil.AppCreateElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/11/4.
 */
public class GetPermissionsAty extends AppCreateElement {

    public GetPermissionsAty(AndroidDriver driver) {
        super ( driver );
        String path = ReFile.writePage ( driver , this.getClass ().getSimpleName ());
        System.out.println ( "读取元素" );
        super.setPath ( path );
    }

    public void permissionsClick(){
        System.out.println ( "点击确定" );
        clickButton ( "确定" );
    }
}
