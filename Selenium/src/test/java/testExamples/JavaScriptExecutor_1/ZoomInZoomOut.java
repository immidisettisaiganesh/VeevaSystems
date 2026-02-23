package testExamples.JavaScriptExecutor_1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		
		exe.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(4000);
		exe.executeScript("document.body.style.zoom='90%'");

	}
}
