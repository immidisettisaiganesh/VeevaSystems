package testExamples.waitings;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitngs {
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(20))
								.pollingEvery(Duration.ofSeconds(2))
								.ignoring(NoSuchElementException.class);
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		uname.sendKeys("Admin");
		
		WebElement upass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
		upass.sendKeys("admin123");	
		
		WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-button")));
		submitbtn.click();
		
	}
	
}
