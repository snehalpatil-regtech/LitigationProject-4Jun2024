package CriticalTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.MethodsPOM;
import litigationExternalLawyer.MethodPOM;
import litigationManagement.CFOMethod;

public class ExternalLawyer
{
	
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
	
		fis = new FileInputStream("D:\\Litigation-Project 10 April2024\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
	
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(6);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationExternalLawyer.html",true);
		test = extent.startTest("Litigation Logging In - External Lawyer");
		
		test.log(LogStatus.PASS, "Test Passed = Verify Chrome browser.");
		test.log(LogStatus.PASS, "URL = https://login.teamleaseregtech.com/Login.aspx");
		test.log(LogStatus.PASS, "Login =lawyer@avantis.info");
		test.log(LogStatus.PASS, "Password = admin@123");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@BeforeMethod

	void Login() throws InterruptedException, IOException
	{
		
	
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
		
	}
	

@Test(priority = 0)
		void NoticeOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice - Open Count Verification");
			
			
			MethodPOM.NoticeOpen(driver, test, workbook, "Performer");
			
			
			extent.endTest(test);
			extent.flush();
		}



@Test(priority =1)
			void CaseOpen() throws InterruptedException, IOException
			{
				test = extent.startTest("Case - Open Count Verification");
				
				
				MethodPOM.CaseOpen(driver, test, workbook, "Performer");
				
				extent.endTest(test);
				extent.flush();
			}


@Test(priority = 2)
				void CloseNotice() throws InterruptedException, IOException
				{
					test = extent.startTest("Close Notice Count Verification");
				
				
					MethodPOM.CloseNoticeCase(driver, test, workbook,"Notice","External Lawyer");
						extent.endTest(test);
					extent.flush();
				}
@Test(priority = 3)
				void CloseCase() throws InterruptedException, IOException
				{
				test = extent.startTest("Close Case Count Verification");
					
					
				MethodPOM.CloseNoticeCase(driver, test, workbook,"Case","External Lawyer");
					
				extent.endTest(test);
					extent.flush();
				}

@Test(priority = 4)
				void NoticeClosed() throws InterruptedException, IOException
				{
					test = extent.startTest("Notice - Closed Count Verification");
			
					
					CFOMethod.NoticeClosed(driver, test, workbook, "Performer");
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 5)
				void CaseClose() throws InterruptedException, IOException
				{
					test = extent.startTest("Case - Closed Count Verification");
			
					

					CFOMethod.CaseClosed(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 6)
				void TaskOpen() throws InterruptedException, IOException
				{
					test = extent.startTest("Task - Open Count Verification");
					
					MethodPOM.TaskOpen(driver, test, workbook, "Performer");
					
					extent.endTest(test);
					extent.flush();
				}
		
		 			
		 @Test(priority = 7)
		 			void TaskDelete() throws InterruptedException, IOException
		 			{
		 				test = extent.startTest("Task Delete verification");
		 				
		 				
		 				MethodPOM.TaskDelete(driver, test);
		 				
		 				extent.endTest(test);
		 				extent.flush();
		 			}
				
			@Test(priority = 8)
				void TaskClosed() throws InterruptedException, IOException
				{
					test = extent.startTest("Task - Closed Count Verification");
					
					
					MethodPOM.TaskClosed(driver, test, workbook, "Performer");
					
					extent.endTest(test);
					extent.flush();
				}
			
			
			@Test(priority =9)
 			void ClosedTask() throws InterruptedException, IOException
 			{
 				test = extent.startTest(" Closed Task Count verification");
 				
 				
 				MethodsPOM.CloseNoticeCase(driver, test, workbook, "Task","External Lawyer");
 				
 				extent.endTest(test);
 				extent.flush();
 			}
	
		  @Test(priority = 10)
			void NoticeDocumentTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Notice Document verification");
				
				
				MethodPOM.NoticeDocument(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
	

	@Test(priority =12)
		void NoticeTaskActivityTab() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activity verification");
			
			
			MethodPOM.TaskActivtity(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	//@Test(priority =0)
	void TaskActivtityDeleteResponse() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Delete Response verification");
		
		
		MethodPOM.TaskActivtityDeleteResponse(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

		@Test(priority = 13)
			void NoticeResponseTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Notice Response tab verification");
				
				
				MethodPOM.Response(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}

	
	@Test(priority = 14)
			void NoticePaymentLogTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Notice PaymentLog tab verification");
				
				
				MethodPOM.PaymentLog(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}

	

		@Test(priority =15)
				void NoticeAuditLogTab() throws InterruptedException, IOException
				{
					test = extent.startTest("Notice AuditLog tab verification");
				
				
					MethodPOM.AuditLog(driver, test);
				
					extent.endTest(test);
					extent.flush();
			}
		@Test(priority = 16)
						void CaseDocumentTab() throws InterruptedException, IOException
						{
							test = extent.startTest("Case Document verification");
							
							
							MethodPOM.Document(driver, test);
							
							extent.endTest(test);
							extent.flush();
						}
	
			 	 
			 @Test(priority = 17)
						void CaseTaskActivityTab() throws InterruptedException, IOException
						{
							test = extent.startTest("Case Task/Activity verification");
					
							
							MethodPOM.TaskActivity1(driver, test,workbook,"Performer");
							
							extent.endTest(test);
							extent.flush();
						}
			 
		
				@Test(priority = 18)
				void CaseHearingTab() throws InterruptedException, IOException
				{
					test = extent.startTest("Case Hearing verification");
				
					
					MethodPOM.CaseHearing(driver, test,workbook);
					
					extent.endTest(test);
					extent.flush();
				}
			
		
			@Test(priority = 19)
			void CaseOrderTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Order verification");
				
				
				MethodPOM.CaseOrder(driver, test,workbook,"Performer");
				
				extent.endTest(test);
				extent.flush();
			}
		

// @Test(priority = 66)
	void CaseAdvocateBillTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Case advocate bill verification");
			
		MethodPOM.AdvocateBill(driver, test);
				
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =20)
	void StatusPayment() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment verification");
			
				
		MethodPOM.StatusPayment(driver, test,workbook);
				
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 21)
			void Auditlog() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Audit Log verification");
	
				
				MethodPOM.Auditlog(driver,test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	 @Test(priority = 22)
	 	void MyDocument() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest("My Document-Download and View Document");
	 	
	 		
	 		MethodPOM.MyDocument(driver, test, workbook);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}



@Test(priority = 23)
void MyReports() throws InterruptedException, IOException
{
	test = extent.startTest("Reports excel count verification");
	
	
	MethodPOM.MyReports(driver, test, workbook, "Performer");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 24)
void MoreReports() throws InterruptedException, IOException
{
	test = extent.startTest("More Report-Reports excel  verification");
	
	
	MethodPOM.MoreReport(driver, test, "Company Admin");
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 25)
void MyReminder() throws InterruptedException, IOException
{
	test = extent.startTest("My Reminder verification");

	
	MethodPOM.MyReminder(driver, test, workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 26)
void ImportUtility() throws InterruptedException, IOException
{
	test = extent.startTest("Import Utility verification");
	
	
	MethodPOM.ImportUtility(driver,test);
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 27)
void CaseUpdationImportUtility() throws InterruptedException, IOException
{
	test = extent.startTest("Case Updation Import Utility verification");
	
	
	CFOMethod.CaseUpdationImportUtility(driver,test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 28)
void NoticeUpdation() throws InterruptedException, IOException
{
test = extent.startTest("Notice Updation Import Utility verification");


CFOMethod.NoticeUpdation(driver,test);
extent.endTest(test);
extent.flush();
}



//@Test(priority = 83)
void CaseAdvocateBill() throws InterruptedException, IOException
{
	test = extent.startTest("Advocate bill verification");
	
	
	MethodPOM.AdvocateBillTab(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@AfterMethod

void Close()
{
	 driver.close(); 
}
}

