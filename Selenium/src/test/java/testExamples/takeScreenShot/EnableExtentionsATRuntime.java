package testExamples.takeScreenShot;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtentionsATRuntime {
	
	public static void main(String args[])
	{
		ChromeOptions options=new ChromeOptions();
		
		//CRXfile to add the extentions from crx downloader extention
		File ext=new File(System.getProperty("user.dir")+"\\crxfiles\\AdBlocker.crx");
		options.addExtensions(ext);
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://youtube.com");
   
	}
	
}
