package Activity;

import AppUtil.AppElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/24.
 */
public class CategoryAty extends AppElement{

    public CategoryAty(AndroidDriver driver) {
        super ( driver );
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
     * 大类--镇店之宝
     */
    public void clickTopOne (){
        click ( "镇店之宝" );
    }

    /**
     * 大类--水果
     */
    public void clickFruits (){
        click ( "水果" );
    }

    /**
     * 第一个小类
     * @param index
     */
    public void clickSmallClass ( int index ) {
        listClick ( "小类" , index );
    }


}
