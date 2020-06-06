package com.vTiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the methods to read external file link Properties and Excel
 * @author Manjunath M N
 */
public class FileLib 
{
	/**
	 * This method will return the Value associated with Key
	 * @param key
	 * @return String
	 */
	public String getPropertyKeyValue(String key)
	{
		Properties prop = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./src\\com\\vTiger\\testData\\commonData.properties");
			prop = new Properties();
			prop.load(ip);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	/**
	 * This method will return the value present in specified row and cell
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum)
	{
		Sheet sh = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./src\\com\\vTiger\\testData\\testData.xlsx");
			Workbook wb = WorkbookFactory.create(ip);
			sh = wb.getSheet(sheetName);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	
	/**
	 * This method return the data present in specified sheet in the form of Object[][]
	 * @param sheetName
	 * @return Object[][]
	 */
	public Object[][] readAllDataFromExcel(String sheetName)
	{
		Sheet sh = null;
		Object[][] data = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./src\\com\\vTiger\\testData\\testData.xlsx");
			Workbook wb = WorkbookFactory.create(ip);
			sh = wb.getSheet(sheetName);
			
			int rowNum = sh.getLastRowNum();
			int cellNum = sh.getRow(0).getLastCellNum();
			data = new Object[rowNum][cellNum];
			
			for(int i=0;i<rowNum;i++)
			{
				for(int j=0;j<cellNum;j++)
				{
					data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	
}
