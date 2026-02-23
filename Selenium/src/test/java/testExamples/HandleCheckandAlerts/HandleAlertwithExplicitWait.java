package testExamples.HandleCheckandAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertwithExplicitWait {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));		
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Alert alert= mywait.until(ExpectedConditions.alertIsPresent());		
		alert.accept();
	
	}

}
