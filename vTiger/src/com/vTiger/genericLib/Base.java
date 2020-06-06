package com.vTiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTiger.ObjectRepo.Home;
import com.vTiger.ObjectRepo.Login;

public class Base 
{
	public FileLib flib = new FileLib();
	public WebDriver driver;
	public static WebDriver staticDriver;
	public Login login;
	public Home home;
	@BeforeClass
	public void configBC()
	{
		if(flib.getPropertyKeyValue("browser").equals("chrome"))
		{
			System.out.println("Chrome is Launching");
			driver = new ChromeDriver();
			staticDriver = driver;

		}
		else if(flib.getPropertyKeyValue("browser").equals("firefox"))
		{
			System.out.println("Firefox is Launching");
			driver = new FirefoxDriver();
			staticDriver = driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(flib.getPropertyKeyValue("url"));
	}
	
	@BeforeMethod
	public void configBM()
	{
		login = PageFactory.initElements(driver, Login.class);
		login.login(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	
	@AfterMethod
	public void configAM()
	{
		home = PageFactory.initElements(driver, Home.class);
		home.signOut(driver);
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
}
