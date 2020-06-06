package com.vTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vTiger.genericLib.Utility;

public class Home 
{
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;


	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//Business Method to logout from Application
	public void signOut(WebDriver driver)
	{
		Utility.moveToElement(driver, userIcon);
		signOutLink.click();
	}
	
	
}
