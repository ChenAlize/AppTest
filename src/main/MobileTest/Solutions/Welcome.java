package Solutions;

import Factory.ElementFactory.FindElement;

/**
 * Created by chenbo on 2017/11/16.
 */
public class Welcome {

    static FindElement Element = new FindElement ();

    public static void welcome(){
        Element.scrollLevel ( 1000, 100, 1000 );
        Element.scrollLevel ( 1000, 100, 1000 );
        Element.coordinateClick ( 314,1671 );
    }

}
