package testExamples.NavigationCommands;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String args[]) throws MalformedURLException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");            //Accepts url only in string format
//		URL myurl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.navigate().to(myurl);  //Internally uses get() method and accept url and string format also    
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to("https://www.screener.in/");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.print(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
	}
	
}
