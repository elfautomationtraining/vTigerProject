package com.vTiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class Utility 
{
	
	
	public static Actions act = new Actions(Base.staticDriver);
	
	
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param result
	 */
	public static void takeScreenShot(WebDriver driver, ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		Date d = new Date();
		int day = d.getDay();
		String[] dAry = d.toString().split(" ");
		String month = dAry[1];
		String year = dAry[5];
		String time = dAry[3].replaceAll(":", "-");
		System.out.println("./Screenshot/"+methodName+"_"+day+"_"+month+"_"+year+"_"+time+".PNG");
		
		EventFiringWebDriver efw = new EventFiringWebDriver(Base.staticDriver);
//		TakesScreenshot ts = (TakesScreenshot)Base.staticDriver;
		File src = efw.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+methodName+"_"+day+"_"+month+"_"+year+"_"+time+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		act.moveToElement(element).perform();
	}
	
	public static void dragAndDrop(WebElement source, WebElement target)
	{
		act.dragAndDrop(source, target).perform();
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
}
