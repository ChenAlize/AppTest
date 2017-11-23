package DB_Script;

import Util.ReDB.Insert;
import Util.ReDB.Select;
import Util.ReDB.Update;
import org.testng.annotations.Test;

/**
 * Created by chenbo on 2017/11/22.
 */
public class CouponOldToNew {

    @org.testng.annotations.Test(enabled = false)
    public void couponOldToNew(){
        Select select = new Select ( "192.168.60.245" );
        String oldCustomer = "13312340001";
        String nowCustomer = "13312341015";
        //获取CustomerSysNo
        int oldCustomerSysNo = select.CustomerSysNo ( oldCustomer );
        int nowCustomerSysNo = select.CustomerSysNo ( nowCustomer );
        select.close ();
        Update update = new Update ( "192.168.60.245" );
        //修改账户余额
        update.CustomerBalance ( "99" , nowCustomerSysNo );
        //修改用户邀请关系
        update.customerOld ( oldCustomerSysNo , nowCustomerSysNo );
        update.close ();
        Insert insert = new Insert ( "192.168.60.245" );
        //插入老拉新关系表
        insert.oldPullNew ( oldCustomerSysNo ,nowCustomerSysNo ,nowCustomer );
        //情况sql资源
        insert.close ();
    }

    @org.testng.annotations.Test( enabled = true)
    public void CustomerBalance(){

        Select select = new Select ( "192.168.60.49" );

        int customerSysNo = select.CustomerSysNo ( "13312341032" ) ;

        Update update = new Update ( "192.168.60.49" );
        //修改账户余额
        update.CustomerBalance ( "199" , customerSysNo );
        select.close ();
        update.close ();
    }
}
