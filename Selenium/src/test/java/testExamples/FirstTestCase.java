
package testExamples;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

/* 
 * launch chrome browser
 * open url : http://demo.opencartt.com
 * validate title should be "Your Store"
 * close browser
 * */

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://opencart.com");

			String act_title = driver.getTitle();
			String exp_title = "Your Store";

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
