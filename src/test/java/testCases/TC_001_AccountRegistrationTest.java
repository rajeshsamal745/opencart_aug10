package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regressiom","Master"})
	void test_account_Registration() {
		logger.debug("application logs....");
		logger.info("*****Starting TC_001_AccountRegistrationTest******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Acccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toLowerCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		logger.info("Clicked on continue");
		regpage.clickContinue();
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected Message");
		}
		catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("*****Finished TC_001_AccountRegistrationTest******");
	}
}
