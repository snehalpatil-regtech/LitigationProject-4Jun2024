package litigationFE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationManagement.CFOMethod;

public class FE {

	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\ComplianceLatest\\TestData\\LitigationSheet.xlsx");
	
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(10);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationFE.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Litigation Logging In - fe");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"fe");		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 2)
		void DashBoardFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("All Filters verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(3000);
		    FeMethod.DashBoardFilter(driver, test, "fe-");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 3)
		void CaseNoticeStageGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Notice Stage Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(3000);
			FeMethod.CaseNoticeStageGraph(driver, test,"fe -");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 4)
		void CaseNoticeTypeGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Notice Type Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(3000);
			FeMethod.CaseNoticeTypeGraph(driver, test,"fe -");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 5)
		void RiskSummaryGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Graph Count Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			Thread.sleep(3000);
			FeMethod.RiskSummaryGraph(driver, test,"fe -");
			
			extent.endTest(test);
			extent.flush();
		}
//		  @Test(priority = 6)
	        void DepartmentSummaryGraph() throws InterruptedException, IOException
	        {
		       test = extent.startTest("Department Graph Count Verification");
		       test.log(LogStatus.INFO, "Test Initiated");
		       Thread.sleep(3000);
		       FeMethod.DepartmentSummaryGraph(driver, test,"fe -");
		
		       extent.endTest(test);
		       extent.flush();
	        }
//	       @Test(priority = 7)
	        void LocationSummaryGraph() throws InterruptedException, IOException
	        {
		       test = extent.startTest("Location Graph Count Verification");
		       test.log(LogStatus.INFO, "Test Initiated");
		       Thread.sleep(3000);
		       FeMethod.LocationSummaryGraph(driver, test,"fe -");
		
		       extent.endTest(test);
		       extent.flush();
	        }
	       
//	      @Test(priority = 8)
	        void CategorySummaryGraph() throws InterruptedException, IOException
	        {
		       test = extent.startTest("Category Graph Count Verification");
		       test.log(LogStatus.INFO, "Test Initiated");
		       Thread.sleep(3000);
		       FeMethod.CategorySummaryGraph(driver, test,"fe -");
		
		       extent.endTest(test);
		       extent.flush();
	        }

	
	
	
	
}
