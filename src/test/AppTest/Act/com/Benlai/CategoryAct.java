package Act.com.Benlai;

import Act.ActBase;
import Activity.CategoryAty;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by chenbo on 2017/10/24.
 */
public class CategoryAct extends ActBase{

    public CategoryAct(AndroidDriver driver) {
        super ( driver );
    }

    public CategoryAty categoryAty = new CategoryAty ( driver );

    /**
     * 进入商品列表
     */
    public void toProductList(){
        categoryAty.clickTopOne ();
        categoryAty.clickSmallClass ( 0 );
    }
}
