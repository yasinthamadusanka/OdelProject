package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class JewelleryPage extends BaseClass{
	
	public JewelleryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyJewelleryPageTitle() {
		return driver.getTitle();
	}
}
