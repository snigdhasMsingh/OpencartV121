package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider ="LoginData", dataProviderClass= DataProviders.class, groups = "DataDriven")// 2nd parameter required as the Data provider method is in another class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("************Starting TC003_LoginDDT*************");
		
		// Home page
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// Login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		// My Account page
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.doesMyAccountPageExist();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				ap.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				ap.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		} catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("************Finished TC003_LoginDDT*************");
				
	}
}
