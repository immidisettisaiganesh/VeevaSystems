package testCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

public class TestFrames {
	
	
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement f1=driver.findElement(By.xpath("//frame[@src='frame_1.html']")); 
		driver.switchTo().frame(f1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello...");
		
		driver.switchTo().defaultContent(); 
		
		WebElement f2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(f2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();
	}
}
