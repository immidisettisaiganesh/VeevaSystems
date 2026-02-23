package StartingWithTestNG.DataProviderandPrallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "dp")					//Test will execute until all the data values ends up in dataProvider i.e 2
	public void test(String email,String pwd)
	{
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		boolean check=driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
		if(check)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item' and text()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterClass
	public void clear()
	{
		driver.quit();
	}
	
	@DataProvider(name="dp",indices = {0,1,3})
	public Object[][] data()
	{
		Object data[][]= {
				{"saiganeshimmidisettti03@gmail.com","dqTPx@5yK@6QYv"},
				{"abc@gmail.com","123"},
				{"xyz@gmail.com","234"},
				{"sai@gmail.com","sai"}
		};
		return data;
	}
}
