package Config;

public class StringValue implements ConfigValue {
    @Override
    public Object configValue(Object object) {
        return object.toString();
    }
}
