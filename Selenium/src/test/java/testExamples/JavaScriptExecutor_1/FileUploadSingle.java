package testExamples.JavaScriptExecutor_1;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadSingle {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String f1="C:\\Users\\I. Sai Ganesh\\Desktop\\Project_final\\controllers.txt";
		
		driver.findElement(By.xpath("//input[@id=\'singleFileInput\']")).sendKeys(f1);
		driver.findElement(By.xpath("//button[text()=\"Upload Single File\"]")).click();
		
		String upload=driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText();
		
		if(upload.contains("controllers.txt"))
		{
			System.out.println("Sucessfuly uploaded");
		}
		else
		{
			System.out.println("upload failed");
		}
	}
	
}
