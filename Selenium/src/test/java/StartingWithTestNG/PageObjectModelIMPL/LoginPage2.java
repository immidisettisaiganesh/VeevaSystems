package StartingWithTestNG.PageObjectModelIMPL;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	WebDriver driver;

	// Constructor
	public LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	
//	@FindBy(xpath = "//input[@name='username']")	// OR
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	WebElement txt_username_loc;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password_loc;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_login_loc;
	
	@FindBy(tagName = "a")
	List<WebElement> links;

	// Action Methods --n locators=n action methods
	public void setUserName(String name) {
		txt_username_loc.sendKeys(name);
	}

	public void setPassword(String pass) {
		txt_password_loc.sendKeys(pass);
	}

	public void clickLogin() {
		btn_login_loc.click();
	}
}
