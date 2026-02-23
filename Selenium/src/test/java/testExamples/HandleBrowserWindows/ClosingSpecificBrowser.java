package testExamples.HandleBrowserWindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowser {
	
	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String>hs=driver.getWindowHandles();
		System.out.println(hs.toString());
		
		for(String x : hs)
		{
			System.out.println(driver.switchTo().window(x).getTitle());
			if(driver.getTitle().equals("OrangeHRM"))
			{
				driver.close();
			}
		}
		System.out.println(driver.getWindowHandles().toString());
	}
	
}
