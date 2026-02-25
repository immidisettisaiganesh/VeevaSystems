package VeevaAssignment.AutomationTest_3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_1 {
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void login()
	{
		UtilTest log=new UtilTest(driver);
		log.setName("Admin");
		log.setPassword("admin123");
		log.click();
	}
	
	@AfterClass
	public void clear()
	{
		driver.close();
	}
}
