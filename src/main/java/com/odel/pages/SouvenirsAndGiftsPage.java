package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class SouvenirsAndGiftsPage extends BaseClass{
	
	public SouvenirsAndGiftsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySouvenirsAndGiftsPageTitle() {
		return driver.getTitle();
	}
}
