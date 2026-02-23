package testExamples.MouseActionsHandle;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverHandle {

	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/#");
		
		WebElement w1=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		WebElement w2=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(w1).moveToElement(w2).click().build().perform();
	}

}
