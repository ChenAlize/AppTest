package Util.Report;

import com.relevantcodes.extentreports.ExtentReports;

import static com.relevantcodes.extentreports.DisplayOrder.NEWEST_FIRST;
import static com.relevantcodes.extentreports.NetworkMode.OFFLINE;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports createReports( String filePath ){
        extent = new ExtentReports( filePath , false , NEWEST_FIRST , OFFLINE );
        extent.addSystemInfo( "Selenium Version", "2.46" );
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
