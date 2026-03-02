package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//h2[normalize-space()='My Account'])[1]")	
	WebElement title;

	public boolean verifyTitle() {
		if (title.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnklogout;
	
	public void logout() {
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", lnklogout);
	}
	
}
