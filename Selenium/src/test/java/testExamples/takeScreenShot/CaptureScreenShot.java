package testExamples.takeScreenShot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShot {
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		// Take full page screenshot
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		File target=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
//		source.renameTo(target);
		
		//capture a specific webelement screenshot or specific area 
		WebElement ele=driver.findElement(By.xpath("//div[@class=\'widget HTML\' and @id='HTML1']"));
		
		File source=ele.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\webelement.png");
		source.renameTo(target);
	}
}
