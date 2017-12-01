package Config;

/**
 * Created by chenbo on 2017/11/30.
 */
public class IntValue implements ConfigValue {
    @Override
    public Object getValue(Object value) {
        return Integer.parseInt(value.toString());
    }
}
