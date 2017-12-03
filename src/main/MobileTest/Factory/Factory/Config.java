package Factory.Factory;

import Util.Read.ReadProperties;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/11/29.
 */
public class Config {
    static {
        ReadProperties.getPropertiesValue( Config.class);
    }

    public static String UDID ;
    public static String APPPACKAGE;
    public static String APPACTIVITY;
    public static String URL;
    public static String TRUNK;
    public static String BRANCH;
    public static String OUTPUT;

}
