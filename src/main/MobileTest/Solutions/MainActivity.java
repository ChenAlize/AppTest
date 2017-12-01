package Solutions;

import Factory.ElementFactory.MobileElement;
import Locator.AppAction;

/**
 * Created by chenbo on 2017/11/16.
 */
public class MainActivity extends MobileElement{

    public AppAction userHome(){
        return appElement ( "ImageButton;resource-id=\"com.android.benlailife.activity:id/img_tab_center\"" );
    }

}
