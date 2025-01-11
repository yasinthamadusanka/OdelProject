package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class SignUpPage extends BaseClass{
	
	@FindBy(xpath="//img[@alt='IMG-LOGO']")
	WebElement signUpPageLogo;
	
	@FindBy(xpath="//div[@class='head-title']")
	WebElement signUpPageTitle;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password ?']")
    WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@class='welcome_text']")
    WebElement welcomeText;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySignUpPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpPageLogo() {
		return signUpPageLogo.isDisplayed();
	}
	
	public HomePage clickOnLoginPageLogo() {
		signUpPageLogo.click();
		return new HomePage();
	}
	
	public LoginPage clickOnSignUpPageButton() {
		loginBtn.click();
		return new LoginPage();
	} 
	
	public boolean verifyForgotPasswordLink() {
        return forgotPasswordLink.isDisplayed();
    }
	
	public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
	
	public boolean verifyWelcomeTextDisplay() {
		return welcomeText.isDisplayed();
	}
	
}
