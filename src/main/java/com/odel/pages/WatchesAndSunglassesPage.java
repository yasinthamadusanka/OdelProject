package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class WatchesAndSunglassesPage extends BaseClass{
	
	public WatchesAndSunglassesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyWatchesAndSunglassesPageTitle() {
		return driver.getTitle();
	}

}
