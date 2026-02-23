package testExamples.KeyBoardActionsSlidersTabsandWindows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {
	
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("//ul/li/a[@href='https://www.pavanonlinetrainings.com/p/udemy-courses.html']"));
		
		act.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).perform();
	
		//Switch to child window 
		List<String> ids=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		
	}
	
}
