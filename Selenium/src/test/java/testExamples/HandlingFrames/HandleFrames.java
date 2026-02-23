package testExamples.HandlingFrames;

import java.net.http.WebSocketHandshakeException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement f1=driver.findElement(By.xpath("//frame[@src='frame_1.html']")); ///html/frameset/frame[1]
		driver.switchTo().frame(f1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello...");
		
		driver.switchTo().defaultContent(); //should come to default inorder to perform any other traverse
		
		WebElement f2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(f2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();
		
	}
	
}
