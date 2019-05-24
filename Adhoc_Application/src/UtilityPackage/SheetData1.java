/*
	 * This excel Utility will return object [][] 
	 * Search with Sheet name 
	 * return all the data in the sheet in a row wise 
	 * 
	 */


package UtilityPackage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SheetData1 {

	 static Workbook workbook_Name;
     static Sheet sheet_Name = null;
     
     public static Object [][] getData(String sheetName) {
		
		FileInputStream fis = null;
       
		try
			{
			fis = new FileInputStream(System.getProperty("user.home")+"\\Desktop\\Ban\\Automation\\Project\\Stadium_APR\\Stadium_testData.xlsx");//Test data sheet path to be given
			}
		catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
		
		
	try
		{
		workbook_Name=WorkbookFactory.create(fis);
		}
	catch (InvalidFormatException e)
	{
	e.printStackTrace();
	}
	catch (IOException e)
	{
	e.printStackTrace();
	}

		sheet_Name = workbook_Name.getSheet(sheetName);
		Object[][] return_Data = new Object[sheet_Name.getLastRowNum()][sheet_Name.getRow(0).getLastCellNum()];
		
		
		for(int i=0; i<sheet_Name.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet_Name.getRow(0).getLastCellNum(); j++) 
			{
			return_Data[i][j] = sheet_Name.getRow(i+1).getCell(j).toString();
			
			}
		}
		return return_Data;
		
	}
	}


