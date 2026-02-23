package testExamples.DatePickersHandles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDropDown {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		List<WebElement>month=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']/option"));
		for(WebElement x:month)
		{
			if(x.getText().equals("May"))
			{
				x.click();
				break;
			}
		}
		
		List<WebElement> year = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']/option"));
		for(WebElement x:year)
		{
			if(x.getText().equals("2031"))
			{
				x.click();
				break;
			}
		}
		
		
	}
	
}
