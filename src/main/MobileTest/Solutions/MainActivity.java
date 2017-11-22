package Solutions;

import Factory.ElementFactory.FindElement;

/**
 * Created by chenbo on 2017/11/16.
 */
public class MainActivity {

    public static void userHome(){
        FindElement Element = new FindElement ();
        Element.click ( "ImageButton;resource-id=\"com.android.benlailife.activity:id/img_tab_center\"" );
    }
}
