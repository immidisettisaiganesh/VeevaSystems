package VeevaAssignment.AutomationTest_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UtilTest{
	
	WebDriver driver;

	public UtilTest(WebDriver driver) {
		this.driver=driver;
	}
	
	By txt_uname=By.xpath("//input[@name='username']");
	By txt_pass=By.xpath("//input[@name='password']");
	By btn_login=By.xpath("//button[@type='submit']");
	
	public void setName(String Name)
	{
		driver.findElement(txt_uname).sendKeys(Name);
	}
	
	public void setPassword(String pass)
	{
		driver.findElement(txt_pass).sendKeys(pass);
	}
	
	public void click()
	{
		driver.findElement(btn_login).click();
	}
	
}
