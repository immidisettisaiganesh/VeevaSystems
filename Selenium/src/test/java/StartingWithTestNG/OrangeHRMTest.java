package StartingWithTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@Test(priority = 1)
	public void openApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println("opened app");

	}
	
	@Test(priority = 2)
	public void findLogo()
	{
		driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img")).isDisplayed();
		
		System.out.println("logo found");

	}
	
	@Test(priority = 3)
	public void login() {
		driver.findElement(By.xpath("//form//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//form//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("loggedin...");

	}
	@Test(priority = 4)
	public void logout()
	{
		driver.quit();
		System.out.println("loggedout...");
	}
}
