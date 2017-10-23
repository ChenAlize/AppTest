package Act.com.Benlai;

import Act.ActBase;
import Activity.CityAty;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/23.
 */
public class CityAct extends ActBase{

    public CityAct(AndroidDriver driver) {
        super ( driver );
    }

    CityAty cityAty = new CityAty ( driver );

    public void toBeiJing(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "北京" );
    }

    public void toShangHai(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "上海" );
    }

    public void toGuangZhou(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "广州" );
    }

    public void toShenZheng(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "深圳" );
    }

    public void toNanJing(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "南京" );
    }

    public void toHangZhou(){
        log.info ( "【查看】 ：" + cityAty.nowCity () , cityAty.screenShot () );
        cityAty.hotCity ( "杭州" );
    }

}
