package testExamples.KeyBoardActionsSlidersTabsandWindows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demoSite/practice/slider/range.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement minSlider=driver.findElement(By.xpath("//div[@id='slider-range']//span[@class=\'ui-slider-handle ui-corner-all ui-state-default\'][1]"));
		WebElement maxSlider=driver.findElement(By.xpath("//div[@id='slider-range']//span[@class=\'ui-slider-handle ui-corner-all ui-state-default\'][2]"));
		
		System.out.println(minSlider.getLocation());
		System.out.println(maxSlider.getLocation());
		
		Actions act=new Actions(driver);
		
		act.dragAndDropBy(minSlider, 100, 47).build().perform();  //           (slider , how much to move x (Increase), how much to move y);
		act.dragAndDropBy(maxSlider, -100, 47).build().perform(); //           (slider , -how much to move x (Decrease), how much to move y);
		
		System.out.println(minSlider.getLocation().getX());
		System.out.println(maxSlider.getLocation().getX());

	}
	
}
