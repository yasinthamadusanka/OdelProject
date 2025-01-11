package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class NewCollectionPage extends BaseClass{
	public NewCollectionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyNewCollectionPageTitle() {
		return driver.getTitle();
	}
}
