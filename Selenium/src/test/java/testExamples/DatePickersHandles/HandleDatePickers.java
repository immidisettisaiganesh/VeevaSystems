package testExamples.DatePickersHandles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDatePickers {
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		
		//Switch to the frame of the element 
		driver.switchTo().frame(0);
		
		//Method 1 : using send keys method
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/11/2002");// dd/mm/yyyy
		
		//Method 2 : using date pickers
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String month="November";
		String year="2022";
		String day="2";
		
		while(true)
		{
			String currmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curryear =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();	
			
			if(currmonth.equals(month) && curryear.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Past Date
		}
		
		List<WebElement> dates=driver.findElements(By.xpath("//table//tr/td/a"));
		
		for(WebElement b:dates)
		{
			if(b.getText().equals(day))
			{
				b.click();
				break;
			}
		}
		
	}
}
