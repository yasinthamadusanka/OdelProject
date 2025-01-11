package com.odel.test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.LoginPage;
import com.odel.pages.SignUpPage;
import com.odel.utilities.TestUtil;

public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	String sheetName = "credentials";
	
	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	private void navigateToLoginPage() {
        homePage.clickOnAccountCircleLogin();
    }
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		navigateToLoginPage();
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login | Odel.lk","Login page title not matched");
	}
	
	@Test(priority=2)
	public void verifyLoginPageLabelTest() {
		navigateToLoginPage();
		Assert.assertTrue(loginPage.verifyLoginPageLabel(),"Login label is missing");
	}
	
	@Test(priority=3)
	public void verifyLoginPageLogoClickTest() {
		navigateToLoginPage();
		homePage = loginPage.clickOnLoginPageLogo();
		Assert.assertNotNull(homePage, "Failed to navigate to Home page");
	}
	
	@Test(priority=4)
	public void welcomeTextDisplayTest() {
		navigateToLoginPage();
		Assert.assertTrue(loginPage.verifyLoginPageWelcomeTextDisplay(),"Message is not display");
	}
	
	@Test(priority=5)
	public void verifySignUpPageButtonClickTest() {
		navigateToLoginPage();
		signUpPage = loginPage.clickOnSignUpPageButton();
		Assert.assertNotNull(signUpPage, "Failed to navigate to Sign Up page");
	}
	
	@Test(priority=6)
	public void verifyLoginPageBackButtonClickTest() {
		navigateToLoginPage();
		Assert.assertNotNull(homePage, "Failed to navigate to Home page");
	}
	
	@Test(priority=7)
	public void passwordMaskingTest() {
		navigateToLoginPage();
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password is not masked");
    }
	
	@Test(priority = 8)
    public void forgotPasswordLinkTest() {
		navigateToLoginPage();
        Assert.assertTrue(loginPage.verifyForgotPasswordLink(), "Forgot Password link is not displayed");
        loginPage.clickForgotPasswordLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("forgot"), "Forgot Password page URL is incorrect");
    }
	
	@Test(priority = 9, dataProvider = "getTestData")
	public void verifyLoginCredentials(String scenario, String username, String password) {
		navigateToLoginPage();
		homePage = loginPage.login(username, password);
		if(scenario.equals("bothcorrect")) {
			Assert.assertTrue(homePage.verifyAccountLinkDisplay(),"Login not Successfully");
		}else if(scenario.equals("bothwrong")) {
			Assert.assertTrue(
				    loginPage.getErrorMessage().equals("Email could not be found.") || 
				    loginPage.getErrorMessage().equals("Invalid CSRF token."),
				    "Error message is not as expected"
				);
		}else if(scenario.equals("correctusername")) {
			Assert.assertTrue(
				    loginPage.getErrorMessage().equals("Error: Invalid user credentials") || 
				    loginPage.getErrorMessage().equals("Invalid CSRF token."),
				    "Error message is not as expected"
				);
		}else {
			Assert.assertTrue(
				    loginPage.getErrorMessage().equals("Email could not be found.") || 
				    loginPage.getErrorMessage().equals("Invalid CSRF token."),
				    "Error message is not as expected"
				);
		}
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
}
