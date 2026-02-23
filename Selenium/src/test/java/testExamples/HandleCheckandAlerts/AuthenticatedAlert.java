package testExamples.HandleCheckandAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Switch command won't work
public class AuthenticatedAlert {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		
		//Syntax :" http://username:password@the-internet.herokuapp.com/basic_auth "  switch not work
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		
	}

}
