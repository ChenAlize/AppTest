package AppData;

import Util.Report.Log;
import Util.Reader.ReadExcel;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/19.
 */
public class Locator {

    Log log = new Log ( Locator.class );

    /**
     * 定义枚举类型
     */
    public enum ByType{
        xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
    }
    private String location;
    private String element;
    private int waittime;
    private ByType bytype;

    public Locator(){

    }
    /**
     * 通过元素name遍历查找相应参数
     * @param location
     */
    public  Locator ( String location ,String classname ){
        ReadExcel excel = new ReadExcel ();
        String[][] locatorMap = excel.getLocatorMap( classname );
        try {
            for ( int i = 0 ; i < locatorMap.length ; i++ ){
                // trim() -- 去除左右空格  equalsIgnoreCase() --忽略大小写比较
                if ( locatorMap[i][0] != null && locatorMap[i][0].trim ().equalsIgnoreCase ( location.trim () )){
                    this.location = locatorMap[i][0];
                    this.element = locatorMap[i][1];
                    this.waittime = Integer.valueOf ( locatorMap[i][2] );
                    //  valueOf()：返回最适合该对象类型的原始值
                    this.bytype = Locator.ByType.valueOf ( locatorMap[i][3].trim () );
                }
            }
        }catch ( Exception E ){
            log.error ( "【数组取值错误】 :" + location  );
        }
    }

    public String getLocation () {
        return this.location;
    }

    public String getElement () {
        return this.element;
    }

    public int getWaittime () {
        return this.waittime;
    }

    public ByType getByType () {
        return this.bytype;
    }

    @Test( enabled = false )
    public void test (){
        Locator locator = new Locator ( "密码" , "LoginAty" );

        log.info ("【密码】 ： " +  locator.getElement () );
    }
}
