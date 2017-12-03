package Util.Report;

import Factory.Factory.Config;
import com.relevantcodes.extentreports.ExtentReports;

import static com.relevantcodes.extentreports.DisplayOrder.NEWEST_FIRST;
import static com.relevantcodes.extentreports.DisplayOrder.OLDEST_FIRST;
import static com.relevantcodes.extentreports.NetworkMode.OFFLINE;

/**
 * 单例
 */
public class ExtentManager {

    static ExtentReports extent;
    static String filePath = new String( Config.OUTPUT + "Extent.html");

    public synchronized static ExtentReports getoneReporter() {
        if (extent == null) {
            extent = new ExtentReports(  filePath , false , NEWEST_FIRST , OFFLINE );
            extent.config()
                    .documentTitle("测试报表-1.0")
                    .reportName("Android Test")
                    .reportHeadline("Com.BenLai");
        }

        return extent;
    }

    public static ExtentReports getExtentReport (){
        extent = new ExtentReports(  filePath , true ,OLDEST_FIRST , OFFLINE );
        extent.config ().documentTitle("测试报表-1.0")
                        .reportName("Android Test")
                        .reportHeadline("Com.BenLai");
        return extent;
    }

/*    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance(System.getProperty ( "user.dir" ) + "/test-output/extent.html");

        return extent;
    }*/

/*    public static ExtentReports createInstance(String fileName) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }*/
}
