import Util.ReDB.Insert;
import Util.ReDB.Select;
import Util.ReDB.Update;
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

    @org.testng.annotations.Test(enabled = false)
    public void xmlTest(){
        String  path = "com/android/benlai/activity/main/MainActivity/UserHomeAty.xml";
        ReadXml readXml = new ReadXml ();
        readXml.Xml ( path );
        int index = readXml.attributeNumber ( "text" , "上海" ) ;
        System.out.println ( index );
    }


}
