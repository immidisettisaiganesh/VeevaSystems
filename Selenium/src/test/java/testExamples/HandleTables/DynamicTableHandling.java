package testExamples.HandleTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableHandling {

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		List<WebElement> l = driver.findElements(By.xpath("//table[@id='example']/thead//th"));

//		System.out.println(l.size());
		for (WebElement x : l) {
			System.out.print(x.getText() + "	");
		}
		System.out.println();

		List<WebElement>pages = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
		
		for(int k=2;k<=pages.size()-1;k++) 
		{
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+k+"]/a")).click();
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
			for (int i = 1; i <= rows.size(); i++) 
			{
				for (int j = 1; j <= 6; j++) 
				{
					System.out.print(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[" + j + "]")).getText() + "	");
				}
				System.out.println();
			}
		}
		
	}

}
