package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btn_continue;
	
	public void logout() {
		btn_continue.click();
	}
}
