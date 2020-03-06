package com.syntax.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test(groups="smoke")
	public void loginToOrangeHRM() {
		logger = report.createTest("Positive login");
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		logger.info("Logging in with valid credentials");
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "06I@PjFbgM");
		CommonMethods.click(login.btnLogin);
		
	}
	
	@Test(groups="smoke")
	public void doLogin() {
		logger = report.createTest("Login verification 2");
		LoginPage login=new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		logger.info("Verifying dashboard text is displayed");
		HomePage home=new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();
		
		//Assert.assertTrue(isDisplayed);
		Assert.assertTrue(false);
		logger.pass("Successfully logged in");
	}

	@Test(groups="regression")
	public void negativeLogin() {
		LoginPage login=new LoginPage();
		
		login.login("admins", "test");
		String errorText=login.message.getText();
		
		AssertJUnit.assertEquals(errorText, "Invalid Credentials");
	}
}