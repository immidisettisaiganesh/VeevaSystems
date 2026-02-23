package testExamples.MouseActionsHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		WebElement w1=driver.findElement(By.xpath("//button[@id='rightclick']"));
		
		Actions act = new Actions(driver);
		act.contextClick(w1).build().perform();
		
		driver.findElement(By.xpath("//div[@id='myDiv']//center[1]/a")).click();
		
		
	}
	
}
