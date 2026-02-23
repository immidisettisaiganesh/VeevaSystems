package testExamples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LocatorsTesing {
	public static void main(String args[]) throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		 
		driver.get("https://www.screener.in/login/");
		
		driver.findElement(By.name("username")).sendKeys("saiganeshimmidisetti@gmail.com");
		
		driver.findElement(By.id("id_password")).sendKeys("S@ig@nesh999");

		driver.findElement(By.cssSelector("button.button-primary")).click();
				
//	boolean c1=	driver.findElement(By.cssSelector("input.u-full-width")).isDisplayed();
//	boolean c2=	driver.findElement(By.cssSelector("input.u-full-width")).isEnabled();
//	boolean c3=	driver.findElement(By.cssSelector("input.u-full-width")).isSelected();
		
		driver.findElement(By.xpath("//*[@id=\"desktop-search\"]//input")).sendKeys("MRF");
		
		//dynamic loading the text to be waited for a minute
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"desktop-search\"]//input")).sendKeys(Keys.ENTER);
		
//	System.out.print(c1+" "+ c2+" "+c3);
		
		
		
//		driver.get("https://practicetestautomation.com/practice-test-login/");
//		driver.findElement(By.xpath("//*[@id=\"menu-item-43\"]/a")).click();
//		driver.findElement(By.cssSelector("#username")).sendKeys("MRF");	
//		driver.findElement(By.cssSelector("input.mailpoet_text")).sendKeys("Sai");
//		driver.findElement(By.name("data[form_field_ODhhN2IwZjQ3NTMzX2VtYWls]")).sendKeys("saiganeshimmidisetti@gamil.com");
//		
//		driver.findElement(By.cssSelector("input.mailpoet_submit")).click();	
		
	}
}
