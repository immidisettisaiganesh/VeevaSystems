package VeevaAssignment.AutomationTest_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_4 {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		if(driver.getTitle().equals("Google")) {
			System.out.println("title matched..");
		}else
		{
			System.out.println("Title not mathced");
		}
		
		System.out.println(driver.getCurrentUrl());
	}
	
}
