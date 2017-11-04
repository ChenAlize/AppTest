package AppData;

import Util.Read.ReadXml;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by chenbo on 2017/10/31.
 */
public class Elelocator {

    private ReadXml xml = new ReadXml ();
    private Element element ;

    public int index=2;
    public String text="确定";
    public String className="android.widget.Button";
    public String packagename="com.android.benlailife.activity";
    public String content_desc="";
    public String bounds="[135,1073][945,1217]";
    public String id="com.android.benlailife.activity:id/btn_dialog_onlytrue";
    public String instance="0";

    public Elelocator( String path){ xml.Xml ( path ); }


}
