package Util.Read;

import Config.ConfigFactory;
import Config.ConfigValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class ReadProperties {

    public static void getPropertiesValue( Class<?> className ){
//        字符串拼接，getSimpleName()获取类名（ConfingTest）
        String path = new StringBuffer().append( className.getSimpleName() ).append( ".properties" ).toString();
//
        InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream( path );

        java.util.Properties properties = new java.util.Properties();

        try {

            properties.load( new InputStreamReader( inputStream ) );
            Class clzss = Class.forName ( className.getName () );
            Field field[] = clzss.getFields();
            Object o = clzss.newInstance ();
            for ( Field f : field ) {
                ConfigValue configValue = ConfigFactory.getConfig( f.getType() );
                Object object = properties.get( f.getName().toLowerCase() );
                Object value =  configValue.configValue( object );

                try {
                    f.set( o , value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
    }
}
