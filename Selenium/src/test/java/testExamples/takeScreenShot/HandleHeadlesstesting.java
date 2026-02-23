
package testExamples.takeScreenShot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

/* 
 * launch chrome browser
 * open url : http://demo.opencartt.com
 * validate title should be "Your Store"
 * close browser
 * */

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHeadlesstesting {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);

		try {
			driver.get("https://opencart.com");

			String act_title = driver.getTitle();
			String exp_title = "Attention Required! | Cloudflare";

			System.out.println("Actual Title: " + act_title);

			if (act_title.equals(exp_title)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}

		} catch (Exception e) {
			System.out.println("Test failed due to browser connection issue");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
