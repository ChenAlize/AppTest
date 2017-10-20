package Util.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.bcel.generic.NEW;

import java.lang.reflect.Method;

public class Reports {

//https://testerhome.com/topics/9994             //自动化工具 ExtentReports 官方说明文档翻译

    public  ExtentReports report;
    public  ExtentHtmlReporter htmlReporter;
    public  ExtentTest extent;
    public  Class<?> clacc;

    public Reports ( Class<?> clacc , String name) {
        this.clacc = clacc;
        htmlReporter = new ExtentHtmlReporter ( System.getProperty("user.dir")+"/reports/Extent.html" );
        htmlReporter.config().setChartVisibilityOnOpen( true );
        htmlReporter.setAppendExisting( true );
        report = new ExtentReports();
        report.attachReporter( htmlReporter );
        extent = report.createTest ( name , "【描述】：自定义测试！");
    }

    public Reports ( Class<?> clacc , Method method ) {
        this.clacc = clacc;
        htmlReporter = new ExtentHtmlReporter ( System.getProperty("user.dir")+"/reports/Extent.html" );
        report = new ExtentReports();
        report.attachReporter( htmlReporter );
        extent = report.createTest ( method.getName () , "【描述】：自动化测试！" );
    }

    public void pass( String message ) {
        extent.log (Status.PASS, clacc.getSimpleName () + message );
    }

    public void error( String message ) {
        extent.log ( Status.ERROR ,clacc.getSimpleName () +message );
    }

    public void fatal( String message ) {
        extent.log ( Status.FATAL ,clacc.getSimpleName () +message );
    }

    public void info( String message ) {
        extent.log ( Status.INFO ,clacc.getSimpleName () +message );
    }

    public void skip( String message ) {
        extent.log ( Status.SKIP ,clacc.getSimpleName () +message);
    }

    public void warning( String message ) {
        extent.log ( Status.WARNING ,clacc.getSimpleName () +message );
    }

    public void conmit () {
        report.removeTest( extent );
        report.flush ();
    }


}
