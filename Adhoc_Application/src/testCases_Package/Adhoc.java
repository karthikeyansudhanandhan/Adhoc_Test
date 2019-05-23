package testCases_Package;

/*import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
*/
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryFunction.TestBase;
import pageObjectClass.pageObjects;

public class Adhoc extends TestBase  {
	
	@BeforeClass
	public void LTD() throws Exception
	{
		System.out.println("Before class");
		IEWebdriver();
		
		//createReport();
	}
	
	@AfterClass
	public void Save() throws Exception
	{
		System.out.println("After class");
		//savereport();
		
	}
	
	@Test
	public void LoginSetup() throws Exception
	{
		System.out.println("Test");
	}
	
}