package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(name = "_username")
	WebElement username;
	
	@FindBy(name = "_password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='IMG-LOGO']")
	WebElement loginPageLogo;
	
	@FindBy(xpath="//div[@class='head-title']")
	WebElement loginPageTitle;
	
	@FindBy(xpath="//img[@alt='back']")
	WebElement loginPageBackButton;
	
	@FindBy(xpath="//a[normalize-space()='SignUp']")
	WebElement signupBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password ?']")
    WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@class='error-text']")
    WebElement errorMessage;
	
	@FindBy(css = ".error-text")
	WebElement errorTextElement;
	
	@FindBy(xpath = "//div[@class='welcome_text']")
	WebElement welcomeText;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLoginPageLogo() {
		return loginPageLogo.isDisplayed();
	}
	
	public boolean verifyLoginPageWelcomeTextDisplay() {
		return welcomeText.isDisplayed();
	}
	
	
	public HomePage clickOnLoginPageLogo() {
		loginPageLogo.click();
		return new HomePage();
	}
	
	public boolean verifyForgotPasswordLink() {
        return forgotPasswordLink.isDisplayed();
    }
	
	public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
	
	public void enterCredentials(String em, String pa) {
		this.username.clear();
        this.username.sendKeys(em);
        this.password.clear();
        this.password.sendKeys(pa);
    }
	
	public void clickLoginButton() {
        loginBtn.click();
    }
	

    public String getErrorMessage() {
        return errorTextElement.getText();
    }
    
    public boolean isPasswordMasked() {
    	return "password".equals(password.getDomProperty("type"));
    }
	
	public HomePage clickOnLoginPageBackButton() {
		loginPageBackButton.click();
		return new HomePage();
	}
	
	public boolean verifyLoginPageLabel() {
		return loginPageTitle.isDisplayed();
	}
	
	public SignUpPage clickOnSignUpPageButton() {
		signupBtn.click();
		return new SignUpPage();
	} 
	
	public HomePage login(String em, String pa) {
		enterCredentials(em, pa);
        clickLoginButton();
        
        return new HomePage();
	}
	
	
}
