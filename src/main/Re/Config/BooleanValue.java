package Config;

public class BooleanValue implements ConfigValue {
    @Override
    public Object configValue(Object object) {
        return new Boolean( object.toString());
    }
}
