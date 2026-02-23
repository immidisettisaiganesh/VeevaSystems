package testExamples.takeScreenShot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoveLaunchAlertAutomation {
	
	public static void main(String args[])
	{
		ChromeOptions options=new ChromeOptions();
		
		//Removes altert i.e chrome is controlled by automation software
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://youtube.com");
		
		System.out.println(driver.getTitle());       //expried.badssl.com
	}
	
}
