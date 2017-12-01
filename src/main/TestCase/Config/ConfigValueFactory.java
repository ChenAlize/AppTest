package Config;

/**
 * Created by chenbo on 2017/11/30.
 */
public class ConfigValueFactory {

    public static ConfigValue getConfigValue(Class<?> className) {
        String ConfigClass = null ;
        StringBuffer Config = new StringBuffer ( );

        Config.append ( "Config." );

        Config.append ( className.getSimpleName ().substring ( 0,1 ).toUpperCase () );

        Config.append ( className.getSimpleName ().substring ( 1 ) );
        Config.append ( "Value" );

        ConfigClass = Config.toString ();



        try {

         return (ConfigValue) Class.forName ( ConfigClass ).newInstance ();


        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }

        return null;
    }

}
