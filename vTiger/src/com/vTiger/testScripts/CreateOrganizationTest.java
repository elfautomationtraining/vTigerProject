package com.vTiger.testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vTiger.genericLib.Base;

@Listeners(com.vTiger.genericLib.ListenerImp.class)
public class CreateOrganizationTest extends Base 
{
	
	@Test
	public void createOrganizationTest()
	{
		String orgName = flib.readDataFromExcel("Organizations", 1, 0);
		driver.findElement(By.linkText("Organizations")).click();
		
		Reporter.log("Clicked on Organization Link",true);
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("Clicked on Create Organization",true);
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Reporter.log("Entered Organization Name",true);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		Reporter.log("Clicked on Save Button",true);
		
		//verify the organization is created
		String actOrgName = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		//String expOrgName = orgName;
		Assert.assertTrue(actOrgName.contains(orgName));
		Reporter.log("Organization is created Successfully", true);
		
	}
}
