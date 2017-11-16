package Solutions;

import Factory.ElementFactory.FindElement;

/**
 * Created by chenbo on 2017/11/16.
 */
public class MainActivity {

    static FindElement Element = new FindElement ();

    public static void userHome(){
        Element.click ( "ImageButton" , "resource-id=\"com.android.benlailife.activity:id/img_tab_center\"" );
    }
}
