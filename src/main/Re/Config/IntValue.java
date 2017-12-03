package Config;

public class IntValue implements ConfigValue {
    @Override
    public Object configValue(Object object) {
        return Integer.parseInt( object.toString());
    }
}
