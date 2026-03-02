package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	
	public void setPassword(String pass) {
		txt_password.sendKeys(pass);
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_login;
	
	public void login() {
		btn_login.click();
	}
	
	public String conformMsg() {
		String msg=driver.getTitle();
		return msg;
	}
}
