package testExamples.HandleBrowserWindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleBrowserWindows {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.cssSelector("a[href='http://www.orangehrm.com']")).click();
		
		Set<String>hs=driver.getWindowHandles();
		List<String> l = new ArrayList<String>(hs);
		String s1=l.get(0);
		String s2=l.get(1);
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(s2);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(s1);
		System.out.println(driver.getTitle());
		
		
		
	}
}
