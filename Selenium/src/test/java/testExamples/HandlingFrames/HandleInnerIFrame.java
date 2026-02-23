package testExamples.HandlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerIFrame {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
	
		WebElement f3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(f3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hii...");
		
		driver.switchTo().frame(0);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//label[@class='docssharedWizToggleLabeledContainer ajBQVb']")).click();
		
		driver.switchTo().defaultContent(); //Must use inorder to switch from one outer frame to another
	}
}
