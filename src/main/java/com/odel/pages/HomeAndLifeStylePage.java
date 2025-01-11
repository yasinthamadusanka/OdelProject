package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class HomeAndLifeStylePage extends BaseClass{
	
	public HomeAndLifeStylePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomeAndLifeStylePageTitle() {
		return driver.getTitle();
	}
}
