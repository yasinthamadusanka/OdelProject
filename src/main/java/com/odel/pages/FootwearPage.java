package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class FootwearPage extends BaseClass{
	
	public FootwearPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyFootwearPageTitle() {
		return driver.getTitle();
	}
}
