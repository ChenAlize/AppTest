package TestCase.com.Benlai;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import static com.relevantcodes.extentreports.NetworkMode.OFFLINE;

public class ExtentTest {

    String path = System.getProperty ( "user.dir" ) + "/test-output/extent.html";

    public ExtentReports extentReports = new ExtentReports(  path , OFFLINE );

    @Test
    public void  test(){
        com.relevantcodes.extentreports.ExtentTest test = extentReports.startTest( this.getClass().getSimpleName() , "@class" );
        com.relevantcodes.extentreports.ExtentTest node = extentReports.startTest( "TEST" , "@TEST" );
        test.appendChild( node );
        node.log( LogStatus.INFO , "IFON");
        node.log( LogStatus.WARNING , "WARNING");
        node.log( LogStatus.UNKNOWN , "UNKNOWN");
        node.log( LogStatus.FATAL , "FATAL");
        node.log( LogStatus.PASS , "PASS");
        node.log( LogStatus.FAIL , "FAIL");
        node.log( LogStatus.SKIP , "SKIP");
        extentReports.flush();
        extentReports.endTest( test );
        extentReports.close();

    }
}
