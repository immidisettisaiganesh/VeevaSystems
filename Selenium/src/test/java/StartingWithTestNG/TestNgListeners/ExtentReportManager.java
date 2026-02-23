package StartingWithTestNG.TestNgListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReport;			//UI of the report - look and feel 
	public ExtentReports report;				//populating common info in report i.e tester name browser name os name project name etc,,,
	public ExtentTest test;				   //updating the status in report i.e pass fail skip etc..
	
	public void onStart(ITestContext contest)
	{
		sparkReport=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setTheme(Theme.STANDARD);
		sparkReport.config().setReportName("Functional Testing");
		
		
		report=new ExtentReports();
		report.attachReporter(sparkReport);
		
		report.setSystemInfo("ComputerName", "localhost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("TesterName", "SAI");
		report.setSystemInfo("os","Windows10");
		report.setSystemInfo("BrowserName","Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.PASS, "Testcase Passed "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed "+result.getName());
		test.log(Status.FAIL, "Test case failed cause is :"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=report.createTest(result.getName());
		test.log(Status.SKIP, "test case skipped "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	
}
