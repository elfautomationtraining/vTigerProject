package com.vTiger.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//access permission
	//getter methods
	public WebElement getUserNameTF()
	{
		return userNameTF;
	}

	public WebElement getPasswordTF() 
	{
		return passwordTF;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	//Business Logic
	public void login(String userName, String password)
	{
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
