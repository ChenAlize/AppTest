package Solutions;

import Data.Dictionary;
import Util.Read.ExcelValue;

import java.util.Map;

/**
 * Created by chenbo on 2017/11/29.
 */
public class GetPermissionsActivity extends Factory.ElementFactory.MobileElement{

    Map<String,Dictionary> map = ExcelValue.excelValue ( GetPermissionsActivity.class );

    public Locator.AppAction only_True(){
        String mod = Thread.currentThread() .getStackTrace()[1].getMethodName();
        Dictionary dictionary = map.get ( mod ) ;
        return  appElement ( "Button;text=\"确定\"" );
    }

    public Locator.AppAction Permission_Deny(){
        return appElement ( "Button;text=\"禁止\"" );
    }

    public Locator.AppAction Permission_Allow(){
        return appElement ( "Button;text=\"始终允许\"" );
    }
}
