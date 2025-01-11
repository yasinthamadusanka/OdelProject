package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class WomenPage extends BaseClass{
	@FindBy(xpath="//div[@class='col-12 category-block-title']//a[contains(text(),'WOMEN')]")
	WebElement womenLabel;
	
	public WomenPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyWomenLabel() {
		return womenLabel.isDisplayed();
	}
}
