package Config;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by chenbo on 2017/11/30.
 */
public class ConfigTest {
    public static String IP;
    public static int PORT;
    public static String NAME;
    public static Boolean ISLOCAL;

    @Test
    public void tet(){
        ConfigTest.configTest ();
        System.out.println ( IP );
        System.out.println ( PORT );
        System.out.println ( NAME );
        System.out.println ( ISLOCAL );
    }


    public static void configTest(){
        InputStream stream = ConfigTest.class.getClassLoader ().getResourceAsStream ( "testConfig.properties" );
        Properties properties = new Properties (  );
        try {
            properties.load ( stream );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        Field field[] = ConfigTest.class.getDeclaredFields ();

        for (Field f : field) {
            ConfigValue cf = ConfigValueFactory.getConfigValue(f.getType());
            Object ov = properties.get(f.getName().toLowerCase());
            Object ovs = cf.getValue(ov);
            try {
                f.set(null,ovs);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
