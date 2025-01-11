package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class BagsPage extends BaseClass{
	
	public BagsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyBagsPageTitle() {
		return driver.getTitle();
	}
}
