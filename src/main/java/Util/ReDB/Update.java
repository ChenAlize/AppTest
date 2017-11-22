package Util.ReDB;

/**
 * Created by chenbo on 2017/11/21.
 */
public class Update extends JdbcLink{

    public Update( String DBUrl ) {
        super ( DBUrl );
    }

    /**
     * 插入账户余额
     * @param balance
     * @param SysNo
     */
    public void CustomerBalance( String balance , int SysNo){
        String sql = "update BenlaiSales..Customer set totalbalance='"
                + balance
                + "'where SysNo='"
                + SysNo
                + "'";
        System.out.println ( sql );
        update ( sql );
    }

    public void customerOld( int oldCustomerSysNo , int customerSysNo){
        String sql = "update Customer set InvitatorSysNo= " +
                oldCustomerSysNo +
                " where sysno= " +
                customerSysNo ;
        System.out.println ( sql );
        update ( sql );
    }

    public void close(){
        Close ();
    }

}
