package VeevaAssignment.AutomationTest_3;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_3 {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		
		driver.findElement(By.xpath("//div[@class='a4bIc']//textarea[@title='Search']")).sendKeys("Virat kohli age");
		Thread.sleep(4000);
		List<WebElement>els=driver.findElements(By.xpath("//div[@class='lnnVSe']//span"));
		
		for(WebElement el:els)
		{
			if(el.isDisplayed())
			{
				if(el.getText().equals("Virat kohli age"))
				{
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].click()");
					
				}
			}
		}
	}
}
