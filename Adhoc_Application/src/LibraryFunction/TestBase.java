package LibraryFunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageObjectClass.pageObjects;
<<<<<<< HEAD

//import stadium.pageObjects;

//import stadium.ObjectMap;
//import stadium.Uiactions.properties;

//import stadium.ObjectMap;

//import Defect_Report.ObjectMap;



	public class TestBase extends pageObjects
	{
		protected static String ReferenceNumber;
		public static WebDriver driver;
		public static ExtentReports report;
		//public static ExtentTest logger;
		public static ExtentTest  logger = new ExtentTest("", "");  
		
		
	    //public static WebDriver driver=",";
	    public static Properties prop = new Properties();
	    public static String titleName =null;
	    //public static ExtentTest logger;
	    //public static ExtentReports report;
	    public WebDriver IEWebdriver()
=======
public class TestBase extends pageObjects
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
		{
<<<<<<< HEAD
	    	System.setProperty("webdriver.ie.driver",System.getProperty("user.home")+"\\IEDriverServer.exe");
	    	 driver=new InternetExplorerDriver();
			//ChromeOptions options = new ChromeOptions();
			//options.setExperimentalOption("useAutomationExtension", false);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			FileInputStream fis = null;
			
			try
			{
				fis = new FileInputStream(System.getProperty("user.dir")+"\\datadriven.properties");
				
				prop.load(fis);
				//
			} 
			catch (IOException e)
			{
			
				e.printStackTrace();
			}
			driver.get(prop.getProperty("Adhoc_ApplicationURL"));
				return driver;
		}
=======
			protected static String ReferenceNumber;
			public static WebDriver driver;
			public static ExtentReports report;
			//public static ExtentTest logger;
			public static ExtentTest  logger = new ExtentTest("", "");  
		    //public static WebDriver driver=",";
			public static Properties prop = null;
			public static String titleName =null;
			//public static ExtentTest logger;
			//public static ExtentReports report;
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
	    
/*public WebDriver IEWebdriver() throws IOException
	{
	   	System.setProperty("webdriver.ie.driver","C:\\SWD\\IEDriverServer.exe");
	   	driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		FileInputStream fis = null;
			System.out.println("Before Invoke");
			
			//return driver;
			fis = new FileInputStream("H:\\Git\\Adhoc_Application\\datadriven.properties");	
			prop.load(fis);
			driver.get(prop.getProperty("AdhocApplicationURL"));
			System.out.println("Invoke");
			return null;
			
	 }*/
			 public static  WebDriver IEWebdriver()
				{
			    	System.setProperty("webdriver.ie.driver","C:\\SWD\\IEDriverServer.exe");
			    	//System.setProperty("webdriver.chrome.driver", "H:\\SWD\\chromedriver.exe");
			    	 /* 	ChromeOptions options = new ChromeOptions();
			    	options.addArguments("no-sandbox");
			    	options.addArguments("disable-extensions");
			    	options.addArguments("--allow-running-insecure-content");
		            options.addArguments("--disable-extensions");
		            options.setExperimentalOption("useAutomationExtension", false);
		            options.addArguments("--disable-web-security");
		            options.addArguments("--acceptSslCerts");
		            options.addArguments("--acceptInsecureCerts");
		            options.setAcceptInsecureCerts(true);*/
			    	//driver = new ChromeDriver(options);
			    	driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					
					FileInputStream fis = null;
					
					try
					{
						fis = new FileInputStream("C:\\SWD\\LTD Application\\datadriven.properties");
						
						prop.load(fis);
					} 
					catch (IOException e)
					{
					
						e.printStackTrace();
					}
					driver.get(prop.getProperty("LTD"));
						return driver;
				}
			    
public static void createReport()
	    {
	    	try	{
	    		//String filename="src/target/report.html";
	    		String filename="H:\\SWD\\Selenium\\Reports\\Adhoc_Regression_Testing_Report.html";
	    		report= new ExtentReports(filename);
	    		}
	    		catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
public static void Steplogs(String Stepname)
		{
			try{
			logger=report.startTest(Stepname);
				}
			catch(Exception e){
				}
		}
public static void savereport() throws InterruptedException
		{
			try{
			report.endTest(logger);
			Thread.sleep(1000);
			report.flush(); 
		}catch(Exception e){
			}
		}
public enum properties
		{
		DISPLAYED,VISIBLE;
		}
public static boolean ValidateObject(String UIName, String objectTechName, String PropertyToBeVerified) throws Exception
	{
		boolean ActualPropertyValue = false;
		String prop=PropertyToBeVerified.toUpperCase();
		try{
		switch (properties.valueOf(prop)){
		case DISPLAYED:
		ActualPropertyValue = driver.findElement(ObjectMap.getLocator(objectTechName)).isDisplayed();
		break; 
		case VISIBLE: 
		ActualPropertyValue = driver.findElement(ObjectMap.getLocator(objectTechName)).isEnabled();
		break;
		default: break;}
		}
		catch(Exception e){
		if(ActualPropertyValue==false){
		logger.log(LogStatus.FAIL, UIName+" is not "+PropertyToBeVerified+" --Stopped Execution");
		captureEvidence(UIName);
		savereport();
		//throw new UserDefinedException("<<< Unable to Find " + UIName + " >>> " + e.getMessage());
		Assert.assertTrue(false);
		
		}
			}
			if(ActualPropertyValue==true)
			{
			logger.log(LogStatus.PASS, UIName+" is "+PropertyToBeVerified);
			captureEvidence(UIName);
			return true; 
			}
			return false;
	}
public  WebDriver Chrome()
		{
	       	System.setProperty("webdriver.chrome.driver", "H:\\SWD\\chromedriver.exe");
	      	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("no-sandbox");
	    	options.addArguments("disable-extensions");
	    	options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-web-security");
            options.addArguments("--acceptSslCerts");
            options.addArguments("--acceptInsecureCerts");
            options.setAcceptInsecureCerts(true);
	    	driver = new ChromeDriver(options);
	    	driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			FileInputStream fis = null;	
			try
			{
				fis = new FileInputStream("C:\\SWD\\LTD Application\\datadriven.properties");
				
				prop.load(fis);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			driver.get(prop.getProperty("LTD"));
				return driver;
		}
public static WebDriver browser(String strURL ) throws Exception
	    {
	    boolean browserFound= true;     
	    System.setProperty("webdriver.ie.driver","C:\\SWD\\IEDriverServer.exe");
	    driver=new InternetExplorerDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    logger.log(LogStatus.INFO, "IE Browser opened Successfully");
	    if (browserFound) {
	    driver.manage().window().maximize();
	    driver.get(strURL);
	    return driver;
	    }else{
	    logger.log(LogStatus.FAIL, "Browser not opened");
	    return null;
	    }
	    }
public static void click(String UIName, String objTechName) throws Exception
		{
			try
		       {
		    WebDriverWait wait = new WebDriverWait(driver, 350); 
		    WebElement elementToClick = driver.findElement(ObjectMap.getLocator(objTechName));
		    wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
		    elementToClick.click(); 
		    logger.log(LogStatus.PASS, UIName+"  clicked successfully");   	   
		       }
		    catch(NullPointerException e)
		      {
		      logger.log(LogStatus.FAIL," Error in clicking the object"+UIName);
		      }
		}
public static void input(String UIName, String objTechName, String data) throws Exception{
            try{    
            WebDriverWait wait = new WebDriverWait(driver, 300);
            WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(data);
            logger.log(LogStatus.PASS, UIName +"Text entered successfully");
            captureEvidence(UIName);
            }
            catch(Exception e)               
            {
           logger.log(LogStatus.FAIL, UIName+" Text entered failed");
            }
            }
public static void PopUp() throws Exception
		{
		  	try
		      {
		     Robot robot = new Robot();
		     Thread.sleep(2000);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.delay(1000);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		      }
		     catch (AWTException e)
		      {
		     e.printStackTrace();
		      }		     
		}
public static void ApprovePopOk() throws Exception
		{
		   try
		   	{
			 Robot robot = new Robot();
			 Thread.sleep(2000);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(2000);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 robot.delay(1000);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(1000);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 robot.delay(1000);                               
			 }
		   catch (AWTException e)
		   	{
			   e.printStackTrace();
			}
		  }
public static void Checkbox(String UIName, String objectTechName) throws Exception
	{
	WebElement checkbox = driver.findElement(ObjectMap.getLocator(objectTechName));
	int count = checkbox.findElements(By.tagName("input")).size();
	for (int i = 0; i<count; i++ )
		{
		if(checkbox.findElement(By.xpath("//*[@id='dataGrid']")).isEnabled())
		checkbox.findElements(By.tagName("input")).get(i).click();
		logger.log(LogStatus.PASS, UIName+" is Clicked");
		}
	}
public static String captureEvidence(String fieldname) throws Exception{
			try{
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			DateFormat date2 = new SimpleDateFormat("yyyy_MM_dd");
		//	String strimage = "C:\\Users\\cc306473\\Desktop\\selenium\\reports"+"/"+dateFormat.format(date)+"/"+fieldname+dateFormat.format(date)+".png";
			String strimage = "H:\\SWD\\Selenium\\reports"+"/"+date2.format(date)+"/"+fieldname+dateFormat.format(date)+".png";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(strimage));
			return strimage;
			}catch(Exception e){
			logger.log(LogStatus.INFO, "Unable to Capture Screenshot");
			}
			return null;
			}
public static void iframeswitch() throws InterruptedException
		{
		driver.switchTo().frame("ctl00_ctl00_MasterContent_MainContent_00af7f416cd14561a1579ad8e3b69133");					 
		Thread.sleep(2000);	
		}
public static void select(String UIName, String objTechName, String data) throws Exception{
	try{
		final Select selectBox = new Select(driver.findElement(ObjectMap.getLocator(objTechName)));
		selectBox.selectByVisibleText(data);
		logger.log(LogStatus.PASS, UIName+" Dropdown selected successfully");
		}
		catch(Exception e){	 
		}
	}
public static void Product_Count(String UIName) throws Exception
	{
	int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size(); 
	for (int i = 2;i<=Count;i++) 
	 	{
		 final String ProductCount = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+i+"]/td/a")).getText();
		 System.out.println(ProductCount);
	 	}
		logger.log(LogStatus.PASS, UIName+" is Clicked");
		captureEvidence(UIName);
	}
public static void Generate(String UIName) throws Exception
	{
	int GeneCount = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
	 for (int k = 7;k<=GeneCount;k++) 
	 {
	WebElement GenerateButton =driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+k+"]/td[11]/a"));
	String isDisabled = GenerateButton.getAttribute("disabled");
		{
	if (isDisabled==null || isDisabled.equals("disabled"))
		{
	Thread.sleep(1000);
	GenerateButton.click();
		}	
		}
		}
	}
public static void Generate_Contract(String UIName) throws Exception
	{
		{
		int GeneCount = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
		 for (int k = 2;k<=GeneCount;k++) 
		{
		 WebElement GenerateButton =driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+k+"]/td[11]"));
		 String isDisabled = GenerateButton.getAttribute("disabled");
		{
			try {
				if (isDisabled==null || isDisabled.equals("disabled"))
							{
				Thread.sleep(2000);
				GenerateButton.click();
							}
				} catch (NullPointerException e) 
				{
				}		
				}
				}
		 }
	}
public static void Team_Leader_Approval_TB(String UIName) throws Exception
	{
	List<WebElement> Checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));	 
	for(int i1=0;i1<Checkbox.size();i1++)
	{
		String isdisabled=Checkbox.get(i1).getAttribute("disabled");
		try {
			if (isdisabled==null || isdisabled.equals("disabled"))
			{	
			Checkbox.get(i1).click();
			}
		} catch (NullPointerException e) 
		{	
		}
<<<<<<< HEAD



}
}
	
	
	
	
	
	
	
		
		public static void SelectedAlign() throws Exception
		{
			WebElement checkbox = driver.findElement(By.xpath(".//*[@id='dataGrid']//tbody/tr[2]/td[1]"));	  
			System.out.println(checkbox);
		    int count = checkbox.findElements(By.tagName("input")).size();
		    System.out.println(count);
		    
		    int sum=0;
		    for (int j = 0; j<count; j++ ) 
			  {
			  	   
			  	 if(checkbox.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]")).isEnabled())
			  	   	{
			  	 sum=sum+j;
			  	   
			  	   	}
			  	 System.out.println(sum);
			  }
		    
		    for (int i = 0; i<sum; i++ ) 
		  {
		  	   
		  	 if(checkbox.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+i+"]/td[1]")).isEnabled())
		  	   	{
		  	   checkbox.findElements(By.tagName("input")).get(i).click();
		  	   
		  	   	}
		  	 
		  }

		}
		
		/*Cashman Functions*/
		
		public static void cashman_persel(String UIName, String objTechName,String data) throws Exception
		{
			
			 int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
			 System.out.println("Count");
			 
			 if (Count>=1)
			 {
				 WebDriverWait wait = new WebDriverWait(driver, 300);
				 WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
		         wait.until(ExpectedConditions.visibilityOf(element));
		         element.clear();
		         element.sendKeys(data);
				 driver.findElement(By.name("dataGrid$ctl02$Selected_for_percentage_increase")).click();
				 Thread.sleep(1000);
				 driver.findElement(By.name("applyPercentageSelected")).click();
				 
			 }else
			 {
				return;
				 
			 }
		}
		
		
		public static void cashman_Alignsel(String UIName, String objTechName, String data) throws Exception
		{
			
			 int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
			 
			 if (Count>=1)
			 {
				 final Select selectBox1 = new Select(driver.findElement(ObjectMap.getLocator(objTechName)));
				 selectBox1.selectByVisibleText(data);
				 driver.findElement(By.name("dataGrid$ctl03$Selected_for_alignment")).click();
				 driver.findElement(By.name("alignButton")).sendKeys("");
				 driver.findElement(By.name("alignButton")).click();
				 
			 }else
			 {
				return;
				 
			 }
			
		}
		
		public static void cashman_Reset() throws Exception
		{
			
			 int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
			 
			 if (Count>=2)
			 {
				driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[4]/td[5]/a")).click();
			 }else
			 {
				return;
				 
			 }
			 //TestBase.click("CashMan_Save", pageObjects.SaveCashmgt);
		}
		
		public static void includeletter_CashMgmt() throws InterruptedException 
		{
			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			for (int j = 2; j <= Count; j++)
			{
				boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j +"]/td[4]/input"))
						.isSelected();

				if (!checked) 
				{

					driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[4]/input")).click();

				}

			}
			//TestBase.click("CashMan_Save", pageObjects.SaveCashmgt);
		}

		
		public static void includeletter_NBB_AVS_TI_ACB_CPS(String UIName) throws Exception 
		{
			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			for (int j = 2; j <= Count; j++)
			{
				boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[3]/input"))
						.isSelected();

				if (!checked) 
				{

					driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[" + j + "]/td[3]/input")).click();
					captureEvidence(UIName);
				}
				
			}
			
		}


		
		
		public static void Select_Product(String UIName) throws Exception 
		{
			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();
			
			for (int j = 7; j <= Count-1; j++)
			{
				System.out.println("No of count on Select_product on TB Queue Leader"+j);
				boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]/input")).isSelected();

				if (!checked) 
				{

					driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]/input")).click();
					captureEvidence(UIName);
					
				}
				
			}
			
		}

		
		/*ACB Function*/
		
		
		public static void ACB_Persel(String UIName, String objTechName, String data) throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) {
				WebDriverWait wait = new WebDriverWait(driver, 300);
				WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(data);
				driver.findElement(By.name("dataGrid$ctl02$%_Increase")).click();
				driver.findElement(By.name("applyIncrease")).click();

			} else {
				return;

			}

		}

		public static void ACB_PerALL(String UIName, String objTechName, String data) throws Exception 
		{

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 300);
				WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(data);
				driver.findElement(By.name("applyIncreaseAll")).click();

			} 
			else {
				
				return;

				}
		}

		public static void ACB_Alignsel(String UIName, String objTechName, String data) throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) {
				final Select selectBox1 = new Select(driver.findElement(ObjectMap.getLocator(objTechName)));
				selectBox1.selectByVisibleText(data);
				driver.findElement(By.name("dataGrid$ctl03$Align_user_code")).click();
				driver.findElement(By.name("alignSelected")).sendKeys("");
				driver.findElement(By.name("alignSelected")).click();

			} else {
				return;

			}

		}

		public static void ACB_Reset() throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 2) {
				driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[4]/td[4]/a")).click();
			} else {
				return;

			}

		}
		
		public static void includACB() throws InterruptedException {
			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			for (int j = 2; j <= Count; j++) {
				boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[" + j + "]/td[3]/input"))
						.isSelected();

				if (!checked) {

					driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[" + j + "]/td[3]/input")).click();

				}

			}

		}
		
		
		
		
		
		
		
		/*CPS functions*/
		

		public static void CPS_Persel(String UIName, String objTechName, String data) throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) {
				WebDriverWait wait = new WebDriverWait(driver, 300);
				WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(data);
				driver.findElement(By.name("dataGrid$ctl02$%_Increase")).click();
				driver.findElement(By.name("applySubIncrease")).click();

			} else {
				return;

			}

		}

		public static void CPS_PerALL(String UIName, String objTechName, String data) throws Exception 
		{

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 300);
				WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(data);
				driver.findElement(By.name("applySubIncreaseAll")).click();

			} 
			else {
				
				return;

				}
		}

		public static void CPS_Alignsel(String UIName, String objTechName, String data) throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 1) {
				final Select selectBox1 = new Select(driver.findElement(ObjectMap.getLocator(objTechName)));
				selectBox1.selectByVisibleText(data);
				driver.findElement(By.name("dataGrid$ctl03$Align_user_code")).click();
				driver.findElement(By.name("alignSelected")).sendKeys("");
				driver.findElement(By.name("alignSelected")).click();

			} else {
				return;

			}

		}

		public static void CPS_Reset() throws Exception {

			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			if (Count >= 2) {
				driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[4]/td[4]")).click();
			} else {
				return;

			}

		}
		
	
			public static void cashman_AlignAll(String UIName, String objTechName, String data) throws Exception {

					int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

					if (Count >= 1) {
						final Select selectBox1 = new Select(driver.findElement(ObjectMap.getLocator(objTechName)));
						selectBox1.selectByVisibleText(data);
						driver.findElement(By.name("alignAllButton")).sendKeys("");
						driver.findElement(By.name("alignAllButton")).click();

					} else {
						return;

					}

				} 
			 

		
		public static void includCPS() throws InterruptedException {
			int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();

			for (int j = 2; j <= Count; j++) {
				boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[" + j + "]/td[3]/input"))
						.isSelected();

				if (!checked) {

					driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr[" + j + "]/td[3]/input")).click();

				}

			}

		}	


		
		
		
		public static String isEnabled(String UIName, String objectTechName)
		{
			try
			{
				//System.out.println(driver.findElement(ObjectMap.getLocator(objectTechName)).getText());
				driver.findElement(ObjectMap.getLocator(objectTechName)).getText().equals("No data to display.");
				//.isEnabled();
				//driver.findElement(By.xpath("")).isEnabled();
				System.out.println("inside loop");
				return "true";
			
			}
			catch (Exception e)
			{return "false";
			}
			}

		
		
		public void writeDatatoExcel(List<String> input) throws IOException 
		{
		       FileInputStream FiS = new FileInputStream("C:\\SWD\\LTD Application\\LTD.xlsx");
		       XSSFWorkbook wb =  new XSSFWorkbook(FiS);
		       XSSFSheet sheet = wb.getSheet("Status");
		       
		                    



		for(int a = 0; a < input.size(); a++)
		       {
		              String Description = input.get(a).split(",")[0];
		              String Status = input.get(a).split(",")[1];
		              
		            
		              XSSFRow row = sheet.createRow(a+1);
		              row.createCell(0).setCellValue(Description);
		              row.createCell(1).setCellValue(Status);
		            


		       }
		FileOutputStream FOS = new FileOutputStream("C:\\SWD\\LTD Application\\LTD.xlsx");
		wb.write(FOS);
		       
		FOS.close();
		//wb.close();
		
		       
		}

		
		
=======
>>>>>>> branch 'master' of https://github.com/karthikeyansudhanandhan/Adhoc_Test.git
	}
	}
public static void SelectedAlign() throws Exception
	{
	WebElement checkbox = driver.findElement(By.xpath(".//*[@id='dataGrid']//tbody/tr[2]/td[1]"));	 
	int count = checkbox.findElements(By.tagName("input")).size();
	int sum=0;
	for (int j = 0; j<count; j++ ) 
	{
	if(checkbox.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]")).isEnabled())
 	{
	sum=sum+j;  	   
	}
 	}    
	for (int i = 0; i<sum; i++ ) 
	{	  	   
	if(checkbox.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+i+"]/td[1]")).isEnabled())
	{
	checkbox.findElements(By.tagName("input")).get(i).click();	   
	}	 
	}
	}
public static void Select_Product(String UIName) throws Exception 
	{
	int Count = driver.findElements(By.xpath(".//*[@id='dataGrid']/tbody/tr")).size();			
	for (int j = 7; j <= Count-1; j++)
	{
	boolean checked = driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]/input")).isSelected();
	if (!checked) 
	{
		driver.findElement(By.xpath(".//*[@id='dataGrid']/tbody/tr["+j+"]/td[1]/input")).click();					
	}		
	}
	}
public static String isEnabled(String UIName, String objectTechName)
	{
		try
	{				
	driver.findElement(ObjectMap.getLocator(objectTechName)).getText().equals("No data to display.");
	return "true";	
	}
	catch (Exception e)
	{return "false";
	}
	}
}
		
	
	

