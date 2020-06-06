package com.vTiger.testScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.Base;

@Listeners(com.vTiger.genericLib.ListenerImp.class)
public class createProductTest extends Base
{
	@DataProvider
	public Object[][] readData()
	{
		return flib.readAllDataFromExcel("Products");
	}
	
	@Test(dataProvider="readData")
	public void createproductTest(String pID, String pName)
	{
		String productName = "Laptop";
		String vendorName = "HP";
		driver.findElement(By.linkText("Products")).click();
		Reporter.log("CLicked on Products Link",true);
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Reporter.log("Clicked on Create Product Image",true);
		driver.findElement(By.name("productname")).sendKeys(productName);
		Reporter.log("Entered Product Name",true);
		
//		driver.findElement(By.xpath("//input[@name='vendor_name']/..//img")).click();
//		Reporter.log("CLicked on Add Vendor Image",true);
//		
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> i = windows.iterator();
//		String pid = i.next();
//		String cid = i.next();
//		
//		driver.switchTo().window(cid);
//		driver.findElement(By.linkText(vendorName)).click();
//		Reporter.log("Selected the vendor",true);
//		driver.switchTo().window(pid);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Clicked on Save Button",true);
		
		//verify the Product is created
		String actProductName = driver.findElement(By.xpath("//span[contains(text(),'Product Information')]")).getText();
		Assert.assertTrue(actProductName.contains(productName));
		Reporter.log("Product is created Successfully", true);
	}
}
