package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class MenPage extends BaseClass{
	
	public MenPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyMenPageTitle() {
		return driver.getTitle();
	}
}
