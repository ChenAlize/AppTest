package Data;

import Solutions.GetPermissionsActivity;
import Util.Read.ExcelValue;

/**
 * Created by chenbo on 2017/12/1.
 */
public class Dictionary {

    public  String path;
    public  String Id;
    public  String AccessibilityId;
    public  String XPath;

    public Dictionary(){

    }
    public Dictionary(String AccessibilityId ,String Id ,String path ,String XPath ) {
        this.AccessibilityId = AccessibilityId;
        this.Id = Id;
        this.path = path;
        this.XPath = XPath;
    }

}
