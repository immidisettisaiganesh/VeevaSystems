package testExamples.HandleCheckandAlerts;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HandleCheckBoxes {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//To select one check box
//		driver.findElement(By.xpath("//*[@id=\"sunday\"]")).click();
		
		//to check multiple check boxes at a time 
		
		//tag[@attr1='v1' and @attr2='v2'] xpath syntax
		List<WebElement> l =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		for(WebElement x:l)
		{
			x.click();
			Thread.sleep(Duration.ofSeconds(1));
		}
		System.out.println(l.size());
		for(int i=3;i<l.size();i++)
		{
			if(l.get(i).isSelected())
			{
				l.get(i).click();
			}
		}
		
	}

}
