package testExamples.HandleDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BoostrapDropDownHandling {

public static void main(String args[]) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicitWait
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//span[@class='comboTreeArrowBtnImg']")).click(); 		//opens dropdown options
//		driver.findElement(By.xpath("//span[contains(text(),'choice 1')]/input")).click();  //contains( WHAT , VALUE )
		
		List<WebElement> cb=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle'][1]"));
		
		System.out.println(cb.size());
		
		for(WebElement x:cb)
		{
			if(x.isDisplayed() && !(x.getText()).equalsIgnoreCase("choice 1"))  //selects all elements that match condition
			{
				System.out.println(x.getText());
				x.click();
			}
		}
	}
	
}
