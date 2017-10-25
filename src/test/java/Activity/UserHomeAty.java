package Activity;

import AppUtil.AppElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/17.
 */
public class UserHomeAty extends AppElement {
    /**
     * @param driver
     */
    public UserHomeAty(AndroidDriver driver) {
        super ( driver );
    }

    /**
     * 点击：登录注册 按钮
     */
    public void clickCenterLogin(){
        click ( "登录注册" );
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
     * 点击--设置
     */
    public void clickSetting(){
        click ( "设置" );
    }
    /**
     * 点击--个人头像
     */
    public void clickUserPortrait(){ click ( "个人头像" ); }
    /**
     * 获取昵称
     * @return
     */
    public String getNickName() { return getText ( "昵称" );}
}
