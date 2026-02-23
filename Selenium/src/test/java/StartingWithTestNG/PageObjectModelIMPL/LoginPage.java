package StartingWithTestNG.PageObjectModelIMPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By txt_username_loc = By.xpath("//input[@name='username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	//Action Methods --n locators=n action methods
	public void setUserName(String name) {
		driver.findElement(txt_username_loc).sendKeys(name);
	}
	
	public void setPassword(String pass) {
		driver.findElement(txt_password_loc).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();
	}
}
