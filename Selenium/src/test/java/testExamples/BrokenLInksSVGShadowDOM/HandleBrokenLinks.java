package testExamples.BrokenLInksSVGShadowDOM;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> el=driver.findElements(By.xpath("//a"));
		System.out.println("total links are :"+el.size());
		int brokenLinks=0;											// Brokenlink are link that donot have any resource in the server
		
		for(WebElement x:el)
		{
			String href=x.getAttribute("href");
			if(href.isEmpty() || href.equals(null))
			{
				System.out.println("Doesn't contain the href attribute");
				continue;
			}
			
			try{
				
				URL linkurl=new URL(href);
				HttpURLConnection con=(HttpURLConnection) linkurl.openConnection();
				if(con.getResponseCode()>=400)
				{
					System.out.println(href+"==> Broken connection");
					brokenLinks++;
				}else
				{
					System.out.println(href+"==> Connection is not broken");
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		System.out.println("Total broken links are "+brokenLinks);
	}

}
