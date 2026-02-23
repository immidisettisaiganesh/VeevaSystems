package testExamples.JavaScriptExecutor_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JavaScriptExecutorPractice {
	
	public static void main(String args[])
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		WebElement male=driver.findElement(By.xpath("//input[@id='male']"));
		
		//jsExecutor for sendKeys() operation
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','sai')", name);      
		
		//jsExecutor for click() operation
		js.executeScript("arguments[0].click()", male);
		
	}
	
}
