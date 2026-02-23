package testExamples.KeyBoardActionsSlidersTabsandWindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiBrowserSingleDriver {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
//		driver.switchTo().newWindow(WindowType.TAB);                 //Seperate tab
		driver.switchTo().newWindow(WindowType.WINDOW);              // Seperate window
		
		driver.get("https://youtube.com/");
		
		List<String> id=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(id.get(0));
		
		Thread.sleep(Duration.ofSeconds(3));
		
		driver.switchTo().window(id.get(1));
		driver.close();                       // closes only one window that one pointing to i.e youtube

	}
	
}
