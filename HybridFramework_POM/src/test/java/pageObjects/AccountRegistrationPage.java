package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstName;
	
	public void setFirstName(String fname) {
		txt_firstName.sendKeys(fname);
	}
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastName;
	
	public void setLastName(String lname) {
		txt_lastName.sendKeys(lname);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	public void setTelephone(String phn) {
		txt_telephone.sendKeys(phn);
	}
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	public void setPassword(String pass) {
		txt_password.sendKeys(pass);
	}
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_password_conform;
	
	public void setConformPass(String cfmPass) {
		txt_password_conform.sendKeys(cfmPass);
	}
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement btn_subscribe_yes;
	
	public void hasSubcribe() {
		btn_subscribe_yes.click();
	}
	
	@FindBy(xpath="//label[normalize-space()='No']")
	WebElement btn_subscribe_no;
	
	public void hasNotSubscribed() {
		btn_subscribe_no.click();
	}
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_privacypolicy;
	
	public void setPrivacyPolicy() {
		chk_privacypolicy.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	public void submit() {
		btn_continue.submit();
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement conformationMsg;
	
	public String getConformationMSG() {
		try {
			return(conformationMsg.getText());
		}catch(Exception e) {
			return "e.getMessage()";
		}
	}
}
