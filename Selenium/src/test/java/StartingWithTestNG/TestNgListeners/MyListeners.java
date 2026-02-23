package StartingWithTestNG.TestNgListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {
	
	//Implemented in two ways : 1) implementing "ITestListener" 2) extending "TestListenerAdapter"
	
	public void onStart(ITestContext context) {
		System.out.println("On Start...");	  
	}
	
	public void onTestStart(ITestResult result) {
	    System.out.println("On test start..");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("On test success...");
	  }
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("On test failure..");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    System.out.println("On test skipped..");
		  }
	  
	  public void onFinish(ITestContext context) {
		    System.out.println("On finish...");
		  }
}
