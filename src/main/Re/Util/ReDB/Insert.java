package Util.ReDB;

/**
 * Created by chenbo on 2017/11/21.
 */
public class Insert extends JdbcLink {

    public Insert(String DBUrl) {
        super ( DBUrl );
    }

    public void oldPullNew( int oldCustomerSysNo , int nowCustomerSysNo , String nowCustomer ){
        String sql =
                "INSERT INTO BenlaiSales..OldRecommendNewLog ([ReferSysNo],[OldCustomerSysno],[NewCustomerSysno],[NewCustomerID],[SoSysno],[BindCouponStatus],[BindCouponDescription],[CreateTime],[UpdateTime],[ReferType],[RegisterTime],[NewCustomerNick])\n" +
                "VALUES (1431" +
                "," +oldCustomerSysNo +
                "," +nowCustomerSysNo +
                "," +nowCustomer +
                ",NULL,NULL,NULL,getdate(),getdate(),12,getdate(),NULL)" ;
        System.out.println ( sql );
        update ( sql );
    }

    public void close(){
        Close ();
    }
}
