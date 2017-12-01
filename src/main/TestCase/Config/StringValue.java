package Config;

/**
 * Created by chenbo on 2017/11/30.
 */
public class StringValue implements ConfigValue {
    @Override
    public Object getValue(Object value) {
        return value.toString();
    }
}
