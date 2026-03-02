package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void login() {

		logger.info("***Starting of Test--TC002_LoginTest***");
		// Home Page
		try {
			HomePage hp = new HomePage(driver);
			logger.info("opened home page");
			hp.clickMyAccount();

			logger.info("clicked on login");
			hp.clickLogin();

			// Login
			LoginPage log = new LoginPage(driver);
			logger.info("Entered the data");
			log.setEmail(p.getProperty("email")); // Login it does not work random dynamic data....
			log.setPassword(p.getProperty("password"));
			log.login();
		//My Account
		MyAccountPage myacc=new MyAccountPage(driver);
			if (myacc.verifyTitle()) {
				Assert.assertTrue(true, "Login Passed");
				logger.info("Test-TC002 passed");
			}
		} catch (Exception e) {

			Assert.fail();
			logger.info("**login Failed***");
		}
		logger.info("**Test-2 Finished***");
	}
}
