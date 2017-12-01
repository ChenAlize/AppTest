package Solutions;

/**
 * Created by chenbo on 2017/11/29.
 */
public class LogoActivity extends Factory.ElementFactory.MobileElement{

    public Locator.AppAction tv_Skip(){
        return appElement ( "TextView;text=\"跳过\"" );
    }

    public Locator.AppAction ivLogoAd(){
        return appElement ( "ImageView;content-desc=\"本来生活\"" );
    }
}
