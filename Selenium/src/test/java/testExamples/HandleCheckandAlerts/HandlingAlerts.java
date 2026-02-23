package testExamples.HandleCheckandAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		/*
		//Normal alerts
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		Thread.sleep(1000);
		String ans=driver.switchTo().alert().getText();
		System.out.println(ans);
		
		driver.switchTo().alert().accept();
		*/
		
		/*
		//conformation alert
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
//		alert.accept();
		alert.dismiss();
		*/
		
		
		//pormt alert
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert myalert = driver.switchTo().alert();

		myalert.sendKeys("Hello....");
		myalert.accept();
		
		
		
	}

}
