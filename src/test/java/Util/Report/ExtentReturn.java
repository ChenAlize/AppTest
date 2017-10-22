package Util.Report;


import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReturn {

    private ExtentTest parent;

    public void setParent( ExtentTest parent ){ this.parent = parent; }

    public ExtentTest getParent(){ return this.parent; }
}
