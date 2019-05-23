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
<<<<<<< HEAD
		createReport();
		System.out.println("Report");
		
=======
		System.out.println("Before class");
		//createReport();
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
	}
	
	@AfterClass
	public void Save() throws Exception
	{
		System.out.println("After class");
		//savereport();
		
	}
	
	@Test
<<<<<<< HEAD
public void LoginSetup() throws Exception
=======
	public void LoginSetup() throws Exception
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
	{
<<<<<<< HEAD
		
		File sheet2 = new File("C:\\SWD\\LTD Application\\LTD.xlsx");
		FileInputStream incident = new FileInputStream(sheet2);
		XSSFWorkbook wb=new XSSFWorkbook(incident);
		XSSFSheet Sheet2 = wb.getSheetAt(0);
		Thread.sleep(2000);
		//test
		IEWebdriver();
		TestBase.Steplogs("Adhoc Application");
		for (int i=1;i<=Sheet2.getLastRowNum();i++)
		{
		/*XSSFRow rownumber = Sheet2.getRow(i);
		
		XSSFCell Drawee=rownumber.getCell(15);
		String DraweeID =Drawee .toString();
		*/
		}
		}
	 }
		
	




	



	


=======
		System.out.println("Test");
	}
	
}
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
