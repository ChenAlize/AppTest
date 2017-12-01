package Config;

/**
 * Created by chenbo on 2017/11/30.
 */
public class BooleanValue implements ConfigValue {
    @Override
    public Object getValue(Object value) {
        return new Boolean ( value.toString () );
    }
}
