package testExamples.JavaScriptExecutor_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SliderWithJS {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor je=(JavascriptExecutor)driver;

//		Scroll the page until 3000px vertically
//		je.executeScript("window.scrollBy(0,3000)");
//		System.out.println(je.executeScript("return window.pageYOffset;"));       //3000
		
//		Scroll the page until element visible
//		WebElement ele=driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
//		je.executeScript("arguments[0].scrollIntoView()",ele);
//		System.out.println(je.executeScript("return window.pageYOffset;"));          //2772
		
//		Scroll until End Of Page		
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(je.executeScript("return window.pageYOffset;")); 		//3416.800048828125
		
		Thread.sleep(3);
		
//		Scrolling upto top of document
		je.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(je.executeScript("return window.pageYOffset;")); 
	}
	
}
