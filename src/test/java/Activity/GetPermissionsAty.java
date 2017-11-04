package Activity;

import AppData.Elelocator;
import AppUtil.AppElement;
import Util.ReFile.ReFile;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/11/4.
 */
public class GetPermissionsAty extends AppElement{

    String path ;


    public GetPermissionsAty(AndroidDriver driver) {
        super ( driver );
        path = ReFile.writePage ( driver , this.getClass ().getSimpleName ());

    }

    public void setPath(){
        Elelocator  elelocator = new Elelocator ( path );
    }

    public void permissionsClick(){
        click ( "确定" );
    }
}
