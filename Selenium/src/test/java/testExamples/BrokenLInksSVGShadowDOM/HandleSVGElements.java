package testExamples.BrokenLInksSVGShadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVGElements {
	public 	static void main(String args[]) {
		
		// SVG Element also donot support the XPath.......
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Identifying SVG Element
		driver.findElement(By.xpath("(//*[name()='svg' and contains(@class,'oxd-main-menu-item--icon')])[2]")).click();
		
	}
}
