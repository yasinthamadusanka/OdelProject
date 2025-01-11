package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class UniSexPage extends BaseClass{
	
	@FindBy(xpath="//div[@class='col-12 category-block-title']//a[contains(text(),'UNISEX')]")
	WebElement uniSexLabel;
	
	public UniSexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUniSexLabel() {
		return uniSexLabel.isDisplayed();
	}
}
