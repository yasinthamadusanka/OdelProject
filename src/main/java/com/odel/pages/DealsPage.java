package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class DealsPage extends BaseClass{
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDealsPageTitle() {
		return driver.getTitle();
	}
}
