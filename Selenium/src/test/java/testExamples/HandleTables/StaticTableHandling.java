package testExamples.HandleTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableHandling {

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://practicetestautomation.com/practice-test-table/");
		
		// retrive all the rows of a table :
		List<WebElement> trow = driver.findElements(By.xpath("//table[@id='courses_table']/tbody//tr"));
		System.out.println("Number of rows are :" + trow.size());

		List<WebElement> tcol = driver.findElements(By.xpath("//table[@id='courses_table']/thead//th"));
		System.out.println("Nuber of columns are :" + tcol.size());

		//Reading data from a specific row and coloumn eg=4th row 3rd coloumn
		String data4_3=driver.findElement(By.xpath("//table[@id='courses_table']/tbody//tr[1]/td[3]")).getText();
		System.out.println(data4_3);
		
		//read data from all rows and coloumns
		for(WebElement x:tcol)                              //coloum names
		{
			System.out.print(x.getText()+"		");
		}
		System.out.println();	
		for(int i=1;i<=trow.size();i++)
		{
			for(int j=1;j<tcol.size();j++)
			{
				String data=driver.findElement(By.xpath("//table[@id='courses_table']/tbody//tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data+"\t");
			}
			System.out.println();	
		}
	}

}
