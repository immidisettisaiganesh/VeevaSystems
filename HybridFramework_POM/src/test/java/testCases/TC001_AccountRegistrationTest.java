package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
		
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****Started Test--TC001_AccountRegistrationTest***");
		
		HomePage pg=new HomePage(driver);
		logger.info("****loaded driver***");
		
		try {
		pg.clickMyAccount();
		logger.info("****clicked on myaccount***");

		pg.clickRegister();		
		logger.info("****clicked on register***");
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("****Redirected to account registration page***");

		arp.setFirstName(randomStr().toUpperCase());
		logger.info("****Setted first name***");

		arp.setLastName(randomStr().toUpperCase());
		logger.info("****Setted last name***");

		arp.setEmail(randomStr()+"@gmail.com");
		logger.info("****Setted email***");

		arp.setTelephone(randomNum());
		logger.info("****Setted telephone***");
	
		String password=randomPass();
		arp.setPassword(password);
		logger.info("****Setted password***");

		arp.setConformPass(password);
		logger.info("****Setted conform password***");

		arp.hasNotSubscribed();
		logger.info("****clicked on no at subcribed***");

		arp.setPrivacyPolicy();
		logger.info("****checked privacypolicy***");

		arp.submit();
		logger.info("****Submitted the data...***");
		
		if(arp.getConformationMSG().equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");	
			logger.debug("Debug logger");
			
			Assert.assertTrue(false);
		}
		}catch(Exception e) {
			Assert.fail();
		
		}
		
		logger.info("****finished Test--TC001_AccountRegistrationTest***");

	}
	
}
