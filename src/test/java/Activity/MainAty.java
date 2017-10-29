package Activity;

import AppUtil.AppElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/11.
 */
public class MainAty extends AppElement {

    public MainAty(AndroidDriver driver) {
        super ( driver );
    }

    public AndroidDriver getDriver (){
        return driver;
    }

    public boolean isPackage(){
       return isExist( "立即领取" );
    }

    /**
     * 点击——立即领取
     */
    public void clickPackageGo(){
        click ( "立即领取" );
    }
    /**
     * 点击——关闭红包
     */
    public void clickPackageClose(){
        click ( "关闭红包" );
    }
    /**
     * 点击--首页
     */
    public void clickMain(){
        click ( "首页" );
    }
    /**
     * 点击--分类
     */
    public void clickCategory(){
        click ( "分类" );
    }
    /**
     * 点击--新品
     */
    public void clickProduct(){
        click ( "新品" );
    }
    /**
     * 点击--购物车
     */
    public void clickCart(){
        click ( "购物车" );
    }
    /**
     * 点击——我的本来
     */
    public void clickUserHome(){
        click ( "我的本来" );
    }
    /**
     * 点击--切站
     */
    public void clickTvCity(){
        click ( "点击切站" );
    }
    /**
     * 点击--搜索框
     */
    public void clickViewBarBg(){
        click ( "搜索框" );
    }
    /**
     * 获取--首页热搜词
     */
    public String getTvContent(){
        return getText ( "首页热搜" );
    }
    /**
     * 点击--消息中心
     */
    public void clickIvCenterMsg(){
        click ( "消息中心" );
    }
    /**
     * 获取--推荐Tab的text
     */
    public String getRecommend(){
        return getListText ( "Tab" , 0 );
    }

    public boolean isTab(){
        return isExist( "水产" );
    }


}
