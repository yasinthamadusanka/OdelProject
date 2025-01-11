package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class SportsPage extends BaseClass{
	
	public SportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySportsPageTitle() {
		return driver.getTitle();
	}
}
