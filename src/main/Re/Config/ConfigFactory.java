package Config;

public class ConfigFactory {

    public static ConfigValue getConfig( Class<?> className ){

        String classname = new StringBuffer()
                                .append( "Config.")
                                .append( className.getSimpleName().substring( 0,1 ).toUpperCase())
                                .append( className.getSimpleName().substring( 1 ))
                                .append( "Value" ).toString();
        try {
            return  (ConfigValue) Class.forName( classname ).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
