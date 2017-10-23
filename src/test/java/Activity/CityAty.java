package Activity;

import AppUtil.AppElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/23.
 */
public class CityAty extends AppElement{

    public CityAty(AndroidDriver driver) {
        super ( driver );
    }

    /**
     * 关闭城市选择页面
     */
    public void leave(){ click ( "离开" ); }

    /**
     * 显示当前城市
     * @return
     */
    public String nowCity(){ return getText ( "当前城市" );}

    /**
     * 城市搜索框
     * @param city
     */
    public void searchCity( String city ){
        typing ( "搜索城市" , city );
    }

    /**
     * 定位城市
     */
    public void localize(){
        click ( "定位城市" );
    }

    public void lastVisit( int index ){
        listClick ( "最近访问城市" , index );
    }

    /**
     * 热门城市
     * @param city
     */
    public void hotCity( String city ){
        click ( city );
    }
}
