package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private WebDriver driver=BaseClass.driver;
	// Generate timestamp
	public String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	@Override
	public void onStart(ITestContext context) { // context stores the current test information...

		String reportPath = System.getProperty("user.dir") + "/reports/AutomationReport_" + getTimeStamp() + ".html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

		spark.config().setDocumentTitle("Automation Execution Report");
		spark.config().setReportName("OrangeHRM Functional Test Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		// System Info
		extent.setSystemInfo("Machine", "Localhost");
		extent.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		extent.setSystemInfo("Environment", "QA");

		extent.setSystemInfo("Groups", context.getCurrentXmlTest().getIncludedGroups().toString());
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		extentTest.assignAuthor("Sai Ganesh");
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.info("Test Started: " + result.getMethod().getMethodName());

		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, result.getTestClass().getName() + "Test Passed Successfully");
		test.get().pass("Execution Time: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.get().log(Status.FAIL, "Test Failed");
		test.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

			String screenshotPath = captureScreenshot(driver, result.getName());
			test.get().addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.get().log(Status.SKIP, "Test Skipped");
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	// Screenshot method
	public String captureScreenshot(WebDriver driver, String testName) throws IOException {

		String timeStamp = getTimeStamp();
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String targetPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

		FileUtils.copyFile(source, new File(targetPath));

		return targetPath;
	}
}
