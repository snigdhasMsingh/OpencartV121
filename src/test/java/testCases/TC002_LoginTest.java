package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_Login()
	{
		logger.info("************Starting TC002_LoginTest************");
		logger.debug("Capturing Application Debug Lags.......");
		
		try
		{
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account....");
		hp.clickLogin();
		logger.info("Clicked on Login....");
		
		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email2"));
		logger.info("Enter valid Email....");
		
		lp.setPassword(p.getProperty("password2"));
		logger.info("Enter valid password....");
		
		lp.clickLogin();
		logger.info("Clicked on Login button....");
		
		// My Account Page
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.doesMyAccountPageExist();
		
		Assert.assertTrue(targetPage);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("************TC002_LoginTest Ends************");
	}

}
