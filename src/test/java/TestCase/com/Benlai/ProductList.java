package TestCase.com.Benlai;

import Act.com.Benlai.CategoryAct;
import TestCase.AppTest;
import Util.TestUtil.Initialize;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/10/24.
 */
public class ProductList extends Initialize{

    @Test( enabled = true , priority = 5 )
    public void toProductList () {
        CategoryAct categoryAct = new CategoryAct ( AppTest.driver );
        categoryAct.toProductList ();
    }
}
