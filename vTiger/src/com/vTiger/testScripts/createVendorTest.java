package com.vTiger.testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.Base;
import com.vTiger.genericLib.Utility;

@Listeners(com.vTiger.genericLib.ListenerImp.class)
public class createVendorTest extends Base
{
	
	@DataProvider
	public Object[][] giveData()
	{
		return flib.readAllDataFromExcel("Vendors");
	}
	
	@Test(dataProvider="giveData")
	public void vendorCreateTest(String vendorName, String email, String phone, String glAcc, String website, String street, String poBox, String city, String state, String postalCode, String country, String description)
	{
		Utility.moveToElement(driver, driver.findElement(By.linkText("More")));
		driver.findElement(By.linkText("Vendors")).click();
		Reporter.log("Clicked on vendor link", true);
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		Reporter.log("Clicked on Create Vendor Link", true);
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		Reporter.log("Entered vendor Name --> "+vendorName, true);
		
		driver.findElement(By.name("email")).sendKeys(email);
		Reporter.log("Entered Email --> "+email,true);
		
		driver.findElement(By.name("phone")).sendKeys(phone);
		Reporter.log("Entered Phone --> "+phone,true);
		
		Utility.selectByValue(driver.findElement(By.name("glacct")), glAcc);
		Reporter.log("Selected --> "+ glAcc,true);
		
		driver.findElement(By.name("website")).sendKeys(website);
		Reporter.log("Entered WebSite --> "+website,true);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Clicked on Save Button", true);

		//verify the vendor is created
		String actVendorName = driver.findElement(By.xpath("//span[contains(text(),'Vendor Information')]")).getText();
		Assert.assertTrue(actVendorName.contains(vendorName));
		Reporter.log("Vendor is created Successfully", true);

	}
}
