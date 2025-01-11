package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class KidsPage extends BaseClass{
	public KidsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyKidsPageTitle() {
		return driver.getTitle();
	}
}
