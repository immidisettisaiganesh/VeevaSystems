package StartingWithTestNG.TestNgListeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(StartingWithTestNG.TestNgListeners.MyListeners.class)	//One more type to specify Listeners...
//Instead of specifying @listener annot for n testcases we can add the once in xml so xml way is preferable
public class OrangeHRMTest {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void testLogo() throws InterruptedException {
		Thread.sleep(5000);
		boolean bool = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img")).isDisplayed();
		Assert.assertEquals(bool, true);
	}

	@Test(priority = 2,dependsOnMethods =  {"testUrl"})
	public void testTitle() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 3)
	public void testUrl() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
