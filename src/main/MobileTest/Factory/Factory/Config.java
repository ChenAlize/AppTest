package Factory.Factory;

/**
 * Created by chenbo on 2017/11/29.
 */
public class Config {

    static ReadConfig config = new ReadConfig ();

    public static final String UDID = config.Config ( "udid" );
    public static final String APPPackage = config.Config ( "appPackage" );
    public static final String APPActivity = config.Config ( "appActivity" );
    public static final String url = config.Config ( "url" );
    public static final String trunk = config.Config ( "trunk" );
    public static final String branch = config.Config ( "branch" );

}
