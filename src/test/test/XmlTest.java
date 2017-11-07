import Util.Read.ReadXml;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by chenbo on 2017/11/7.
 */
public class XmlTest {



    @org.testng.annotations.Test
    public void xmlTest(){
        String  path = "com/android/benlai/activity/main/MainActivity/UserHomeAty.xml";
        ReadXml readXml = new ReadXml ();
        readXml.Xml ( path );
        List<String> text = readXml.selectAttribute ( "text" );
        int index = 0 ;
        for ( int i = 0 ; i < text.size () ; i ++ ){
            if ( text.get ( i ).equals ( "元" )){
                index = index+1;
            }
        }
        System.out.println ( index );


    }




}
