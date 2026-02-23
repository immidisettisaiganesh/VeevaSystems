package testExamples.HandleDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownHandling {

	public static void main(String args[]) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicitWait
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountry = new Select(element);
		
		//to select object from drop down by (visible text , object , index)
		
		//drpCountry.deSelectByContainsVisibleText("France");  //case sensitive
		//drpCountry.selectByValue("japan");           		   //when value attribute present at html tag
		drpCountry.selectByIndex(2);	 			//uk 2 index i.e 3rd position  index at decleration in tag from 0 to n-1
		
		List<WebElement> options =drpCountry.getOptions();
		System.out.println("There are "+options.size()+" options to select they are :");

		for(WebElement x:options)
		{
			System.out.println(x.getText());
		}
		 
	}
	
}
