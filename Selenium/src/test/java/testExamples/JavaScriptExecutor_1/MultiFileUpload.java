package testExamples.JavaScriptExecutor_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFileUpload {
		
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String f1="C:\\Users\\I. Sai Ganesh\\Desktop\\Project_final\\controllers.txt";
		String f2="C:\\Users\\I. Sai Ganesh\\Desktop\\Project_final\\controllers2.txt";

		//Multiple files upload
		driver.findElement(By.xpath("//input[@id='multipleFilesInput']")).sendKeys(f1+"\n"+f2);
		driver.findElement(By.xpath("//button[text()=\'Upload Multiple Files\']")).click();
		
	}
	
}
