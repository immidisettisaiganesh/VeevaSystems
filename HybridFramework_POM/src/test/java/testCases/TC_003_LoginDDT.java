package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	// since we have dataprovider in another class we sholuld provide class name
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= "DataDrivern")
	public void verify_LoginDDT(String email, String password, String exp) {

		logger.info("***Starting of Test--TC003_LoginDDT***");
		// Home Page
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			logger.info("opened home page");
			hp.clickMyAccount();

			logger.info("clicked on login");
			hp.clickLogin();

			// Login
			LoginPage log = new LoginPage(driver);
			logger.info("Entered the data");
			log.setEmail(email); // Login it does not work random dynamic data....
			log.setPassword(password);
			log.login();

			// My Account

			/*
			 * valid email and pass and test pass = test pass invalid email and pass login
			 * fail = test pass valid email and pass login fail = test pass invalid email
			 * and pass login pass = test fail
			 *
			 */
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetPage = myacc.verifyTitle();
			
			LogoutPage lout=new LogoutPage(driver);
			
			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage) {
					myacc.logout();
					lout.logout();
					logger.info("logging out");

					Assert.assertTrue(true);
					
				} else {
					Assert.fail();
				}
			} else {
				if (targetPage) {
					myacc.logout();
					lout.logout();

					Assert.fail();
				} else {
					Assert.assertFalse(false);
				}
			}

		} catch (Exception e) {
			Assert.fail();
			logger.info("**login Failed***");
		}
		logger.info("**Test--TC003_LoginDDT Finished***");
	}
}
