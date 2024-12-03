package litigationManagement;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.MethodsPOM;
import litigationAdditionalOwner.performerPOM;
import performer.OverduePOM;


public class CFO {
	
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
			fis = new FileInputStream("E:\\Litigation-Project 10 April2024\\TestData\\LitigationSheet.xlsx");
			
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(5);					//Retrieving second sheet of Workbook
			return sheet;
		}
		
		@BeforeTest
	
		void setBrowser() throws Exception
		{
			String workingDir = System.getProperty("user.dir");
			extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCFO.html",true);
			test = extent.startTest("Litigation Logging In - CFO");
			
			
			test.log(LogStatus.PASS, "Test Passed = Verify chrome Browser");
			extent.endTest(test);
			extent.flush();
		}
		
		
		@BeforeMethod
	
		void Login() throws Exception
		{
		
			XSSFSheet sheet = ReadExcel();
			Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
			
			login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
			
			
			Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
			Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
			String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
			
			Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
			Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
			String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
			
			driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
			

		}
		

		
	// @Test(priority = 2)
				void DashBoardFilter() throws InterruptedException, IOException
				{
					test = extent.startTest("All Filters verification");
					
					Thread.sleep(3000);
					CFOMethod.DashBoardFilter(driver, test, "Cfo-");
					
					extent.endTest(test);
					extent.flush();
				}
				
				
	
		/*@Test(priority =1)
			    	void NoticeOpen() throws InterruptedException, IOException
			    	{
			    		test = extent.startTest("Notice - Open Count verification");
			    		
			    		
			    		CFOMethod.NoticeOpen(driver, test, workbook, "CFO -");
			    		
			    		extent.endTest(test);
			    		extent.flush();
			    	}
			 @Test(priority =2)
			 	void NoticeWithExistingData() throws InterruptedException, IOException
			 	{
			 		test = extent.startTest("Notice With Existing Data verification");
			 		
			 		
			 		CFOMethod.NoticeWithExistingData(driver, test, workbook);
			 		
			 		extent.endTest(test);
			 		extent.flush();
			 	}
				
			 @Test(priority =3)
			     void NoticeWithInvalidData() throws InterruptedException, IOException
			    {
				     test = extent.startTest("Notice With Invalid Data verification");
				
				
				      CFOMethod.NoticeWithInvalidData(driver, test, workbook);
				
				     extent.endTest(test);
				     extent.flush();
			   }
			 @Test(priority =4)
			   void NoticeWithTwoMandatoryData() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice With Two Mandatory Fields verification");
				
				
				      CFOMethod.NoticeWithTwoMandatoryData(driver, test, workbook);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			 @Test(priority =5) 
			   void NoticeWithEmptyFields() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice With Empty Fields verification");
				
				
				      CFOMethod.NoticeWithEmptyFields(driver, test, workbook);
				
				     extent.endTest(test);
				     extent.flush();
			 }
	
			@Test(priority =6)
			   void NoticeClearBtn() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice Summary -Clear button verification");
				
				
				      CFOMethod.NoticeClearBtn(driver, test, workbook);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			@Test(priority =7)
			   void NoticeSendMailWithDoc() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice Summary-Send Mail With Document verification");
				
				
				      CFOMethod.NoticeSendMailWithDoc(driver, test);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			@Test(priority =8)
			   void NoticeSendMailWithDocInvalidFields() throws InterruptedException, IOException
			  {
				     test = extent.startTest(" Notice Summary -Send Mail With Document Invalid Fields verification");
				
				
				      CFOMethod.NoticeSendMailWithDocInvalidFields(driver, test);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			@Test(priority =9)
			   void NoticeSendMailWithDocEmptyFields() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice Summary -Send Mail With Document Empty Fields verification");
				
				
				      CFOMethod.NoticeSendMailWithDocEmptyFields(driver, test);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			// @Test(priority =10)
			   void NoticeUserAssignment() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice User Assignment  verification");
				
				
				      CFOMethod.NoticeUserAssignment(driver, test,workbook);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			// @Test(priority =11)
			   void NoticeUserAssignmentDelete() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Notice User Assignment Delete Icon  verification");
				
				
				      CFOMethod.NoticeUserAssignmentDelete(driver, test,workbook);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			   
			@Test(priority =12)
				void LinkNotice() throws InterruptedException, IOException
				{
					test = extent.startTest("Link Notice Verification");
					
					
					CFOMethod.LinkDocument(driver, test, workbook, "Notice");
					
					extent.endTest(test);
					extent.flush();
				}
			   
			 @Test(priority =13)
			   void LinkNoticeViewIcon() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Linked notice view icon  verification");
				
				
				      CFOMethod.LinkNoticeViewIcon(driver, test);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			@Test(priority =14)
			   void LinkNoticeDeleteIcon() throws InterruptedException, IOException
			  {
				     test = extent.startTest("Linked notice Delete icon  verification");
				
				
				      CFOMethod.LinkNoticeDeleteIcon(driver, test);
				
				     extent.endTest(test);
				     extent.flush();
			 }
			
			@Test(priority = 15)
	    	void NoticeDocument() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Document verification");
	    		
	    		
	    		CFOMethod.NoticeDocument(driver, test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
			
			@Test(priority = 16)
	    	void NoticeDocViewandDownload() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Summary - Document view and download  verification");
	    		//test.log(LogStatus.INFO, "Test Initiated");
	    		
	    		CFOMethod.NoticeDocViewandDownload(driver, test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
			
	@Test(priority = 17)
		void NoticeDocumentEmptyFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document with empty fields verification");
			
			
			CFOMethod.NoticeDocumentEmptyFields(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 18)
		void NoticeWithoutUploadDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Without Upload Document verification");
			
			
			CFOMethod.NoticeWithoutUploadDocument(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 19)
		void NoticeDocumentSearchFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Search Fields verification");
			
			
			CFOMethod.NoticeDocumentSearchFields(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 20)
		void NoticeDocumentShareInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share with Invaid data verification");
			
			
			CFOMethod.NoticeDocumentShareInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}*/
	@Test(priority =21)
		void NoticeDocumentShareWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share without data verification");
			
			
			CFOMethod.NoticeDocumentShareWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =22)
		void NoticeDocumentShareCloseBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share close button verification");
			
			
			CFOMethod.NoticeDocumentShareCloseBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
	@Test(priority = 22)
	    	void NoticeTaskActivity() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice TaskActivtiy verification");
	    		
	    		
	    		CFOMethod.TaskActivtity(driver, test,workbook);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority = 23)
		void TaskActivtityDeleteResponse() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activtiy Delete Response verification");
			
			
			CFOMethod.TaskActivtityDeleteResponse(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 24)
		void TaskActivtityExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activtiy with existing data verification");
			
			
			CFOMethod.TaskActivtityExistingData(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =25)
		void TaskActivtityWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activtiy Without data verification");
			
			
			CFOMethod.TaskActivtityWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 26)
		void TaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activtiy Response Without data verification");
			
			
			CFOMethod.TaskActivtityResponseWithoutStatus(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	 
	@Test(priority = 27)
		void TaskActivtityResponseClearBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Task/Activtiy  Response clear button verification");
			
			
			CFOMethod.TaskActivtityResponseClearBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =28)
	    	void NoticeResponse() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Response verification");
	    		
	    		
	    		CFOMethod.Response(driver, test,workbook);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
		@Test(priority =29)
		void ResponseExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Response Existing Data verification");
			
			
			CFOMethod.ResponseExistingData(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =30)
		void NoticeResponseWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Response Without data verification");
			
			
			CFOMethod.ResponseWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =31)
		void ResponseClearBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Response Clear button verification");
			
			
			CFOMethod.ResponseClearBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	    	
		@Test(priority = 32)
	    	void NoticePayment() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Payment verification");
	    		
	    		
	    		CFOMethod.PaymentLog(driver,test,workbook);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
		@Test(priority = 33)
		void PaymentLogwithExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Payment with existing data verification");
			
			
			CFOMethod.PaymentLogwithExistingData(driver,test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 34)
		void PaymentLogwithInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Payment with Invalid data verification");
			
			
			CFOMethod.PaymentLogwithInvalidData(driver,test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 35)
		void NoticePaymentWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Payment Without data verification");
			
			
			CFOMethod.PaymentLogWithoutData(driver,test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 36)
	    	void NoticeExternalLawyer() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Lawyer verification");
	    		
	    		CFOMethod.ExternalLawyer(driver, test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	    	@Test(priority = 37)
	    	void ExternalLawyerWithoutRating() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice External Lawyer without rating verification");
	    		
	    		CFOMethod.ExternalLawyerWithoutRating(driver, test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
		@Test(priority = 38)
		void CriteriaExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Criteria Existing Data verification");
			
			CFOMethod.CriteriaExistingData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 39)
		void CriteriaInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Criteria Invalid Data verification");
			
			CFOMethod.CriteriaInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 40)
		void CriteriaWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Criteria Without Data verification");
			
			CFOMethod.CriteriaWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	  	
		@Test(priority = 41)
	    	void NoticeAuditLog() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Notice Audit Log verification");
	    	
	    		
	    		CFOMethod.AuditLog(driver, test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}		
			  
			@Test(priority =42)
			     	void CaseOpen() throws InterruptedException, IOException
			     	{
			     		test = extent.startTest("Case - Open Count verification");
			     		
			     		
			     		CFOMethod.CaseOpen(driver, test, workbook, "CFO -");
			     		
			     		extent.endTest(test);
			     		extent.flush();
			     	}
			 @Test(priority =43)
			 	void CaseExistingData() throws InterruptedException, IOException
			 	{
			 		test = extent.startTest("Case with Existing Data verification");
			 		
			 		
			 		CFOMethod.CaseExistingData(driver, test, workbook);
			 		
			 		extent.endTest(test);
			 		extent.flush();
			 	}
			@Test(priority =44)
			 	void CaseWithInvalidData() throws InterruptedException, IOException
			 	{
			 		test = extent.startTest("Case with Invalid Data verification");
			 		
			 		
			 		CFOMethod.CaseWithInvalidData(driver, test, workbook);
			 		
			 		extent.endTest(test);
			 		extent.flush();
			 	}
			@Test(priority =45)
			   	void CaseWithTwoFieldsData() throws InterruptedException, IOException
			   	{
			   		test = extent.startTest("Case with Two Manadatory fields verification");
			   		
			   		
			   		CFOMethod.CaseWithTwoFieldsData(driver, test);
			   		
			   		extent.endTest(test);
			   		extent.flush();
			   	}
			 @Test(priority =46)
			   	void CaseWithEmptyFields() throws InterruptedException, IOException
			   	{
			   		test = extent.startTest("Case with Empty fields verification");
			   		
			   		
			   		CFOMethod.CaseWithEmptyFields(driver, test);
			   		
			   		extent.endTest(test);
			   		extent.flush();
			   	}
			@Test(priority =47)
			   	void CaseWithClearBtn() throws InterruptedException, IOException
			   	{
			   		test = extent.startTest("Case Summary - Clear button verification");
			   		
			   		
			   		CFOMethod.CaseWithClearBtn(driver, test);
			   		
			   		extent.endTest(test);
			   		extent.flush();
			   	}
			  
			// @Test(priority =48)
			   	void CaseUserAssignment() throws InterruptedException, IOException
			   	{
			   		test = extent.startTest("Case User Assignment verification");
			   		
			   		
			   		CFOMethod.CaseUserAssignment(driver, test,workbook);
			   		
			   		extent.endTest(test);
			   		extent.flush();
			   	}
		//	@Test(priority =49)
			    void CaseUserAssignmentDelete() throws InterruptedException, IOException
			   {
			 	     test = extent.startTest("Case User Assignment Delete Icon  verification");
			 	
			 	
			 	      CFOMethod.CaseUserAssignmentDelete(driver, test);
			 	
			 	     extent.endTest(test);
			 	     extent.flush();
			  }
			
			@Test(priority = 50)
			void LinkCase() throws InterruptedException, IOException
			{
				test = extent.startTest("Link Case Verification");
			
				
				CFOMethod.LinkDocument(driver, test, workbook, "Case");
			
			extent.endTest(test);
				extent.flush();
			}
		
	 @Test(priority =51)
		   void LinkCaseViewIcon() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Linked case view icon  verification");
			
			
			      CFOMethod.LinkCaseViewIcon(driver, test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
	 @Test(priority =52)
		   void LinkCaseDeleteIcon() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Linked case delete icon  verification");
			
			
			      CFOMethod.LinkCaseDeleteIcon(driver, test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
	 
	
		@Test(priority =53)
		    	void CaseDocument() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Document Tab");
		    		
		    		
		    		CFOMethod.Document(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority = 54)
				void CaseWithoutUploadDocument() throws InterruptedException, IOException
				{
					test = extent.startTest("Case Without Upload Document verification");
					
					
					CFOMethod.CaseWithoutUploadDocument(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
			@Test(priority = 55)
			void CaseDocumentEmptyFields() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document with empty fields verification");
				
				
				CFOMethod.CaseDocumentEmptyFields(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 56)
			void CaseDocumentSearchFields() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document Search Fields verification");
				
				
				CFOMethod.CaseDocumentSearchFields(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 57)
			void CaseDocumentShareInvalidData() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document Share with Invalid data verification");
				
				
				CFOMethod.CaseDocumentShareInvalidData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority =58)
			void CaseDocumentShareWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document Share without data verification");
				
				
				CFOMethod.CaseDocumentShareWithoutData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority = 59)
			void CaseDocumentShareCloseBtn() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document Share close button verification");
				
				
				CFOMethod.CaseDocumentShareCloseBtn(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		 @Test(priority =60)
			    void CaseSendMailWithDoc() throws InterruptedException, IOException
			   {
			 	     test = extent.startTest("Case Summary-Send Mail With Document verification");
			 	
			 	
			 	      CFOMethod.CaseSendMailWithDoc(driver, test);
			 	
			 	     extent.endTest(test);
			 	     extent.flush();
			  }
			    
			    @Test(priority =61)
			    void CaseSendMailWithDocInvalidFields() throws InterruptedException, IOException
			   {
			 	     test = extent.startTest("Case  Summary-Send Mail With Document Invalid Fields verification");
			 	
			 	
			 	      CFOMethod.CaseSendMailWithDocInvalidFields(driver, test);
			 	
			 	     extent.endTest(test);
			 	     extent.flush();
			  }
		   @Test(priority =62)
			    void CaseSendMailWithDocEmptyFields() throws InterruptedException, IOException
			   {
			 	     test = extent.startTest("Case Summarys -Send Mail With Document Empty Fields verification");
			 	
			 	
			 	      CFOMethod.CaseSendMailWithDocEmptyFields(driver, test);
			 	
			 	     extent.endTest(test);
			 	     extent.flush();
			  }
			    
			@Test(priority =63)
		    	void CaseTaskActivity() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Task/Activity Tab");
		    		
		    		
		    		CFOMethod.TaskActivity1(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
				
		@Test(priority = 64)
					void CaseTaskActivityWithoutData() throws InterruptedException, IOException
					{
						test = extent.startTest("Case Task/Activtiy Without data verification");
						
						
						CFOMethod.CaseTaskActivityWithoutData(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority =65)
		    	void CaseTaskActivitywithExistingData() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Task/Activity with existing data");
		    		
		    		
		    		CFOMethod.CaseTaskActivitywithExistingData(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
				
			 @Test(priority = 66)
					void CaseTaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
					{
						test = extent.startTest("Case Task/Activity Response Without data verification");
						
						
						CFOMethod.CaseTaskActivtityResponseWithoutStatus(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
				 
		@Test(priority =67)
					void CaseTaskActivtityResponseClearBtn() throws InterruptedException, IOException
					{
						test = extent.startTest("Case Task/Activtiy  Response clear button verification");
						
						
						CFOMethod.CaseTaskActivtityResponseClearBtn(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority =68)
		    	void CaseHearingcfo() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - CaseHearing Tab");
		    		
		    		
		    		CFOMethod.CaseHearing(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =69)
			void CaseExistingHearingDate() throws InterruptedException, IOException
			{
				test = extent.startTest("Case with Existing Hearing Date Verification");
				
				
				CFOMethod.CaseExistingHearingData(driver, test,workbook);
				
				extent.endTest(test);
				extent.flush();
			}
			
		  @Test(priority= 70)
		  void CaseWithoutHearingData() throws InterruptedException, IOException
		  {
			test = extent.startTest("Case without hearing data Verification");
			
			
			CFOMethod.CaseHearingWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		  }
		@Test(priority =71)
		   void CaseHearingInvalidDate() throws InterruptedException, IOException
		   {
		 	test = extent.startTest("Case Invalid Hearing Date Verification");
		 	
		 	
		 	CFOMethod.CaseHearingInvalidDate(driver, test,workbook);
		 	
		 	extent.endTest(test);
		 	extent.flush();
		   }
		 @Test(priority =71)
		   void CaseHearingClearBtn() throws InterruptedException, IOException
		   {
		 	test = extent.startTest("Case heraing clear button Verification");
		 	
		 	
		 	CFOMethod.CaseHearingClearBtn(driver, test,workbook);
		 	
		 	extent.endTest(test);
		 	extent.flush();
		   }
		@Test(priority =72)
		    	void CaseOrder() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Case Order Tab");
		    	
		    		
		    		CFOMethod.CaseOrder(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =73)
			void CaseOrderExistingData() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Order with Duplicate data");
	
			
				CFOMethod.CaseOrderwithExistingData(driver, test,workbook);
			
				extent.endTest(test);
				extent.flush();
			}
	
		@Test(priority =74)
			void CaseOrderWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Without data Order tab");
	
			
				CFOMethod.CaseOrderWithoutData(driver, test);
			
				extent.endTest(test);
				extent.flush();
			}
	
		@Test(priority =75)
			void CaseOrderwithClearBtn() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Order with clear button");
	
			
				CFOMethod.CaseOrderwithClearBtn(driver, test);
			
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority =76)
		    	void CaseStatusPayment() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Status/Payment Tab");
		    		
		    		
		    		CFOMethod.StatusPayment(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =77)
		    	void StatusPaymentExistingdata() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case Status/Payment with duplicate data ");
		    		
		    		
		    		CFOMethod.StatusPaymentExistingdata(driver, test,workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =78)
		void StatusPaymentwithInvaliddata() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Status/Payment with Invalid data ");
			
			
			CFOMethod.StatusPaymentwithInvaliddata(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =79)
		    	void StatusPaymentWithoutdata() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case Status/Payment without data ");
		    		
		    		
		    		CFOMethod.StatusPaymentWithoutdata(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
				
		    	@Ignore
				@Test(priority =80)
		    	void CaseStatusAppealtoNextCourtTwoMandatoryfields() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case Status -Enter Two manadatory fields click on Appeal to Next Court");
		    		
		    		
		    		CFOMethod.CaseStatusAppealtoNextCourtTwoMandatoryfields(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		    	
			//@Test(priority =80)
		    	void CaseStatusAppealtoNextCourt() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case Status Appeal to Next Court");
		    		
		    		
		    		CFOMethod.CaseStatusAppealtoNextCourt(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =81)
		    	void CaseStatuswithEmptyFields() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case Status With Empty Fields");
		    		
		    		
		    		CFOMethod.CaseStatuswithEmptyFields(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =82)
		    	void CaseExternalLawyerRating() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - External Lawyer Rating");
		    		
		    		
		    		CFOMethod.CaseExternalLawyer(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		    	@Test(priority =83)
		    	void CaseExternalLawyerWitoutRating() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - External Lawyer Without Rating");
		    		
		    		
		    		CFOMethod.CaseExternalLawyerWitoutRating(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority =84)
			void CaseExternalLawyerCriteria() throws InterruptedException, IOException
			{
				test = extent.startTest("Case - External Lawyer Rating -Add New Criteria ");
				
				
				CFOMethod.CaseExternalLawyerCriteria(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		   
		 @Test(priority = 85)
			void CaseExistingCriteria() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Criteria Existing Data verification");
				
				CFOMethod.CaseExistingCriteria(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		 @Test(priority = 86)
			void CaseCriteriaInvalidData() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Criteria Invalid Data verification");
				
				CFOMethod.CaseCriteriaInvalidData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 87)
			void CaseCriteriaWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Criteria Without Data verification");
				
				CFOMethod.CaseCriteriaWithoutData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority =88)
		    	void CaseAuditLog() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Audit Log Tab");
		    		
		    		
		    		CFOMethod.Auditlog(driver, test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		
		
		
		
				@Test(priority =89)
				void NoticeClosedDoc() throws InterruptedException, IOException
				{
					test = extent.startTest("Close Notice Document verification");
					
					CFOMethod.NoticeClosedDoc(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
				@Test(priority = 90)
				void NoticeClosedWithoutDoc() throws InterruptedException, IOException
				{
					test = extent.startTest("Close Notice Without Document verification");
					
					CFOMethod.NoticeClosedWithoutDoc(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
				
				
				@Test(priority = 91)
				void CaseClosedDoc() throws InterruptedException, IOException
				{
					test = extent.startTest("Close Case Document verification");
					
					CFOMethod.CaseClosedDoc(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
				
				
				@Test(priority = 92)
				void CaseClosedWithoutDoc() throws InterruptedException, IOException
				{
					test = extent.startTest("Close Case Without Document verification");
					
					CFOMethod.CaseClosedWithoutDoc(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
		 
		    
			@Test(priority =93)
			    			void TaskOpen() throws InterruptedException, IOException
			    			{
			    				test = extent.startTest("Task - Open Count verification");
			    				
			    				
			    				CFOMethod.TaskOpen(driver, test, workbook, "CFO");
			    				
			    				extent.endTest(test);
			    				extent.flush();
			    			}
			 @Test(priority = 94)
						void TaskwithExistingData() throws InterruptedException, IOException
						{
							test = extent.startTest("Task With existing data verification");
							
							
							CFOMethod.TaskwithExistingData(driver, test, workbook);
							
							extent.endTest(test);
							extent.flush();
						
						}
			 @Test(priority =95)
			    			void TaskwithTwoManadatoryFields() throws InterruptedException, IOException
			    			{
			    				test = extent.startTest("Task With Two manadatory fields verification");
			    				
			    				
			    				CFOMethod.TaskwithTwoManadatoryFields(driver, test, workbook);
			    				
			    				extent.endTest(test);
			    				extent.flush();
			    			}
			  @Test(priority = 96)
						void TaskwithoutData() throws InterruptedException, IOException
						{
							test = extent.startTest("Task Without  data verification");
							
							
							CFOMethod.TaskwithoutData(driver, test);
							
							extent.endTest(test);
							extent.flush();
						}
			   @Test(priority =97)
						void TaskwithClearBtn() throws InterruptedException, IOException
						{
							test = extent.startTest("Task Clear button verification");
							
							
							CFOMethod.TaskwithClearBtn(driver, test);
							
							extent.endTest(test);
							extent.flush();
						}
			 @Test(priority = 98)
						void TaskDelete() throws InterruptedException, IOException
						{
							test = extent.startTest("Task Delete verification");
							
							
							CFOMethod.TaskDelete(driver, test);
							
							extent.endTest(test);
							extent.flush();
						}
		@Test(priority = 99)
			    	void NoticeClosed() throws InterruptedException, IOException
			    	{
			    		test = extent.startTest("Notice - Closed Count verification");
			    		
			    		
			    		CFOMethod.NoticeClosed(driver, test, workbook, "Company Admin");
			    		
			    		extent.endTest(test);
			    		extent.flush();
			    	}
			@Test(priority = 100)
			    	void CaseClose() throws InterruptedException, IOException
			    	{
			    		test = extent.startTest("Case - Closed Count verification");
			    		
			    		
			    		CFOMethod.CaseClosed(driver, test);
			    		
			    		extent.endTest(test);
			    		extent.flush();
			    	}
				   
			@Test(priority =101)
			    	void CloseNotice() throws InterruptedException, IOException
			    	{
			    		test = extent.startTest("Close Notice Count verification");
			    		
			    		CFOMethod.CloseNoticeCase(driver, test, workbook,"Notice");
			    		
			    		extent.endTest(test);
			    		extent.flush();
			    	}
			@Test(priority = 102)
						void CloseCase() throws InterruptedException, IOException
						{
						test = extent.startTest("Close Case Count Verification");
							
							
							CFOMethod.CloseNoticeCase(driver, test, workbook,"Case");
							
						extent.endTest(test);
							extent.flush();
						}
				  
			@Test(priority = 103)
						void TaskClosed() throws InterruptedException, IOException
						{
							test = extent.startTest("Task - Closed Count verification");
							
							
							CFOMethod.TaskClosed(driver, test, workbook, "CFO");
							
							extent.endTest(test);
							extent.flush();
						}
			
			@Test(priority = 104)
					void WorkspaceFilter() throws InterruptedException, IOException
					{
						test = extent.startTest("My Workspace = Notice = Multiple  Filters verification");
						
						
						CFOMethod.WorkspaceNoticeFilter(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
				
			 @Test(priority =105)
					void WorkspaceCaseFilter() throws InterruptedException, IOException
					{
						test = extent.startTest("My Workspace = Case = Multiple  Filters verification");
						
						
						CFOMethod.WorkspaceCaseFilter(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority = 106)
				void WorkspaceTaskFilter() throws InterruptedException, IOException
				{
					test = extent.startTest("My Workspace = Task = Multiple  Filters verification");
					
					
					CFOMethod.WorkspaceTaskFilter(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
			
			@Test(priority = 107)
			void AdvancedSearch() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace-Advanced Search verification");
				
				
				CFOMethod.AdvancedSearchWorkspace(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 108)
			void CaseHearing() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Hearing Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				CFOMethod.CaseHearing(driver, test,"Performer","Case Hearing-");
				
				extent.endTest(test);
				extent.flush();
			}
		
		
	@Test(priority = 109)
		void WorkspaceCaseHearingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace = Case Hearing = Search box  Filter verification");
			
			
			CFOMethod.WorkspaceCaseHearingFilter(driver, test,"Branch Mumbai");
			
			extent.endTest(test);
			extent.flush();
		}
			
		@Test(priority =110)
			void HearingCalender() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest("Hearing Calender verification");
			
				
				CFOMethod.HearingCalender(driver, test,"Performer","Cfo");
				
				extent.endTest(test);
				extent.flush();
			}
	
			
	
@Test(priority = 111)
void CaseNoticeTypeGraph() throws InterruptedException, IOException
{
	test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Case/Notice Type Summary graph");
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();
  
   	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	 
	 Thread.sleep(5000);
	int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPlaintiff(driver).getText());	//Reading Notice Open count.
	int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendantNotice(driver).getText());	//Reading Notice Open count.
	int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerNotice(driver).getText());	//Reading Notice Open count.
	int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentNotice(driver).getText());	//Reading Notice Open count.
	int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantNotice(driver).getText());	//Reading Notice Open count.
	int	Complainanat = Integer.parseInt(performerPOM.CaseNoticeTypeComplainantNotice(driver).getText());	//Reading Notice Open count.
	//int	Defendant = Integer.parseInt(performerPOM.CaseNoticeTypeDefendantNotice(driver).getText());	//Reading Notice Open count.
	int	Plaintiff = Integer.parseInt(performerPOM.CaseNoticeTypePlaintiffNotice(driver).getText());	//Reading Notice Open count.
	
	
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph(driver, test,"Outward/Plaintiff Type",OutwardPlaintiff);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph(driver,  test,"Inward/Defendent Type",InwardDefendent);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph( driver, test,"Petitioner Type",Petitioner);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph( driver, test,"Respondent Type",Respondent);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph( driver, test,"Applicant Type",Applicant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph(driver,  test,"Complianant Type",Complainanat);
	//Thread.sleep(3000);
	//CFOMethod.CaseNoticeTypeGraph(driver,  test,"Defendant Type",Defendant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph(driver,  test,"Plaintiff Type",Plaintiff);
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 112)
void CaseNoticeTypeFilter() throws InterruptedException, IOException
{
	
	test = extent.startTest("Case Notice type summary graph Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeFilter(driver, test,"CaseNoticeTypeSummaryGraph");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 113)
void CaseNoticeStageGraph() throws InterruptedException, IOException
{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,900)");
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();

	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();

	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();
	
	js.executeScript("window.scrollBy(0,850)");

	 String StageName =performerPOM.StageName(driver).getText();
	 test = extent.startTest("Select Notice from Notice/Case Filter :- "+StageName+" Stage :-  to verify count of Case/Notice Stage Summary graph");
	
	CFOMethod.CaseNoticeStageGraph(driver, test,"cfo -");
	
	extent.endTest(test);
	extent.flush();
}
 @Test(priority = 114)
	void CaseNoticeStageFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Case Notice Stage summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.CaseNoticeStageFilter(driver, test,"CaseNoticeStageSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}


@Test(priority =115)
void RiskSummaryGraph() throws InterruptedException, IOException
{
	test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Risk Summary graph");
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,800)");
 	
 	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();
  
   	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	 Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,950)");
	

 	Thread.sleep(2000);
    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh(driver).getText());	//Reading Notice Open count.
	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium(driver).getText());	//Reading Notice Open count.
	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow(driver).getText());	//Reading Notice Open count.
	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable(driver).getText());	//Reading Notice Open count.
	
	
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph(driver, test,"High Risk",HighRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph(driver, test,"Medium Risk",MediumRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph(driver, test,"Low Risk",LowRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph(driver, test,"Not Applicable Risk",NotApplicableRisk);
	
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();

	extent.endTest(test);
	extent.flush();
}

 @Test(priority = 116)
	void RiskSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Risk summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.RiskSummaryGraphFilter(driver, test,"RiskSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}
@Test(priority = 117)
void DepartmentSummaryGraph() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");

	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();

	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();

	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();
	
	 js.executeScript("window.scrollBy(0,950)");

	 String DeptName =performerPOM.DepartName(driver).getText();
	 test = extent.startTest("Select Notice from Notice/Case Filter :- "+DeptName+" Dept :-  to verify count of Department Summary graph");
	
  
   Thread.sleep(3000);
   CFOMethod.DepartmentSummaryGraph(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}

 @Test(priority = 118)
	void DepartmentSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 test = extent.startTest("Department summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.DepartmentSummaryGraphFilter(driver, test,"DepartmentSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}

@Test(priority =119)
void LocationSummaryGraph() throws InterruptedException, IOException
{
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();
  
   	
   Thread.sleep(5000);
   performerPOM.clickDashboardApplyBtn(driver).click();
   
   js.executeScript("window.scrollBy(0,1400)");
	
	  String LocationName =performerPOM.LocationName(driver).getText();
		test = extent.startTest("Select Notice from Notice/Case Filter :- "+LocationName+" Location :-  to verify count of Location Summary graph");
		
  
   Thread.sleep(3000);
   CFOMethod.LocationSummaryGraph(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}

 @Test(priority =120)
	void LocationSummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 	test = extent.startTest("Location summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.LocationSummaryGraphFilter(driver, test,"LocationSummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}


@Test(priority = 121)
void CategorySummaryGraph() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();
  
   	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();
	
   	js.executeScript("window.scrollBy(0,1700)");
	
	
	
	Thread.sleep(2000);
		//String CategoryName =performerPOM.CategoryName(driver).getText();
	//test = extent.startTest("Select Notice type Filter :-"+CategoryName+" Category - To check Category Summary Graph Count Verification");
	test = extent.startTest("Select Notice from Notice/Case Filter :- Company Law Category :-  to verify count of Category Summary graph");
	
   Thread.sleep(3000);
   CFOMethod.CategorySummaryGraph(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}
 @Test(priority =122)
	void CategorySummaryGraphFilter() throws InterruptedException, IOException
	{
	 
	 	test = extent.startTest("Category summary graph Filter Verification");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	
	 	Thread.sleep(3000);
		CFOMethod.CategorySummaryGraphFilter(driver, test,"CategorySummaryHigh");
		
		
		extent.endTest(test);
		extent.flush();
	 	
	 	
	}





@Test(priority = 123)
void InwardDefendantAgeingGraph() throws InterruptedException, IOException
{
 		test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph");
 
 		JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter(driver).click();

	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn(driver).click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,3700)");
		
		
		Thread.sleep(3000);
		int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA(driver).getText());	//Reading Notice Open count.
    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeAgeing(driver).getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA(driver).getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA(driver).getText());	//Reading Notice Open count.
    	//int	Defendant = Integer.parseInt(performerPOM.clickDefendantNoticeCA(driver).getText());	//Reading Notice Open count.
		
    	Thread.sleep(3000);
    	CFOMethod.InwardDefendantAgeingGraph(driver, test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.InwardDefendantAgeingGraph(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		CFOMethod.InwardDefendantAgeingGraph(driver, test,"Petitioner",Petitioner);
		Thread.sleep(3000);
		CFOMethod.InwardDefendantAgeingGraph(driver, test,"Respondent",Respondent);
		//Thread.sleep(3000);
		//CFOMethod.InwardDefendantAgeingGraph(driver, test,"Defendant",Defendant);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();

		extent.endTest(test);
		extent.flush();
}


@Test(priority =124)
void LessThanYearGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Less Than Year graph Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
	CFOMethod.LessThanYearGraphFilter(driver, test,"LessThanYear");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}
@Test(priority =125)

void AgeingGraph1to2years() throws InterruptedException, IOException
{
		test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");

		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();

	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();


	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();

	js.executeScript("window.scrollBy(0,3700)");
	Thread.sleep(5000);
	int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA1To2Years(driver).getText());	//Reading Notice Open count.
	int Complainant = Integer.parseInt(performerPOM.clickComplianantNoticeCA1To2Years(driver).getText());	//Reading Notice Open count.
    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA1to2(driver).getText());	//Reading Notice Open count.
    int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA1To2Years(driver).getText());	//Reading Notice Open count.
    int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA1To2Years(driver).getText());	//Reading Notice Open count.
   // int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA1To2Years(driver).getText());	//Reading Notice Open count.
	
    
    
    Thread.sleep(3000);
   CFOMethod.AgeingGraph1to2years(driver, test,"Applicant",Applicant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2years(driver, test,"Complainant",Complainant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2years(driver, test,"Inward/Defendent",InwardDefendent);
	Thread.sleep(3000);
	CFOMethod.AgeingGraph1to2years(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
	Thread.sleep(3000);
	CFOMethod.AgeingGraph1to2years(driver, test,"Petitioner",Petitioner);
	//Thread.sleep(3000);
	//CFOMethod.AgeingGraph1to2years(driver, test,"Respondent",Respondent);
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();

	extent.endTest(test);
	extent.flush();
}

@Test(priority =128)
void AgeingGraph1to2yearsGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph 1to2years Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
	CFOMethod.Ageing1To2YearGraphFilter(driver, test,"AgeingGraph1to2yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}



@Test(priority =127)
void AgeingGraph2to3years() throws InterruptedException, IOException
{
	test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");

	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();


	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	
	 js.executeScript("window.scrollBy(0,4000)");
	 Thread.sleep(5000);
   
	 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA2to3(driver).getText());	//Reading Notice Open count.
	 int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA2to3(driver).getText());	//Reading Notice Open count.
	 int OutwardPlainftiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA2to3(driver).getText());	//Reading Notice Open count.
	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA2to3(driver).getText());	//Reading Notice Open count.
	 int Plaintiff = Integer.parseInt(performerPOM.clickPlaintiffNoticeCA2to3(driver).getText());	//Reading Notice Open count.
	 
    Thread.sleep(3000);
    CFOMethod.AgeingGraph2to3years(driver, test,"Inward/Defendent",InwardDefendent);
	Thread.sleep(3000);
	CFOMethod.AgeingGraph2to3years(driver,  test,"Applicant",Applicant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3years(driver,  test,"Outward/Plaintiff",OutwardPlainftiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3years(driver,  test,"Petitioner",Petitioner);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3years(driver,  test,"Plaintiff",Plaintiff);

	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();

	extent.endTest(test);
	extent.flush();
}	

@Test(priority =127)
void AgeingGraph2to3yearsGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph 2to3years Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
	CFOMethod.Ageing2To3YearGraphFilter(driver, test,"AgeingGraph2to3yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}
@Test(priority = 143)
void AgeingGraphMorethan3years() throws InterruptedException, IOException
{
test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");

	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardNoticeFilter(driver).click();


	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	 Thread.sleep(3000);
	 js.executeScript("window.scrollBy(0,3870)");
	 Thread.sleep(3000);
	 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentMorethan3years(driver).getText());	//Reading Notice Open count.
	 int Complainant = Integer.parseInt(performerPOM.clickComplainantMorethan3years(driver).getText());	//Reading Notice Open count.
	 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffMorethan3years(driver).getText());	//Reading Notice Open count.
	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerMorethan3years(driver).getText());	//Reading Notice Open count.
	 int Respondent = Integer.parseInt(performerPOM.clickRespondentMorethan3years(driver).getText());	//Reading Notice Open count.
	 
	 Thread.sleep(3000);
	 CFOMethod.AgeingGraphMorethan3years(driver, test,"Inward/Defendent",InwardDefendent);
	 CFOMethod.AgeingGraphMorethan3years(driver, test,"Complainant",Complainant);
	 CFOMethod.AgeingGraphMorethan3years(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
	 CFOMethod.AgeingGraphMorethan3years(driver, test,"Petitioner",Petitioner);
	 CFOMethod.AgeingGraphMorethan3years(driver, test,"Respondent",Respondent);
	 
	  Thread.sleep(3000);
	 OverduePOM.clickDashboard(driver).click();

	 extent.endTest(test);
	 extent.flush();
}	

@Test(priority =129)
void AgeingMoreThanYearGraphFilter() throws InterruptedException, IOException
{
 
 	test = extent.startTest("Ageing Graph More Than 3 Filter Verification");
	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,900)");
 	
 	
 	Thread.sleep(3000);
	CFOMethod.AgeingMoreThanYearGraphFilter(driver, test,"AgeingGraphMoreThan3yearsGraph");
	
	
	extent.endTest(test);
	extent.flush();
 	
 	
}

@Test(priority =130)
void CaseNoticeTypeGraph1() throws InterruptedException, IOException
{
	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Case/Notice Summary graph");
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,850)");

    Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter(driver).click();

	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	  js.executeScript("window.scrollBy(0,50)");
	 Thread.sleep(5000);
	
	int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendentCase(driver).getText());	//Reading Notice Open count.
	int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantCase(driver).getText());	//Reading Notice Open count.
	int	Appellant = Integer.parseInt(performerPOM.CaseNoticeTypeAppleantCase(driver).getText());	//Reading Notice Open count.
	int	Complianant = Integer.parseInt(performerPOM.CaseNoticeTypeComplianantCase(driver).getText());	//Reading Notice Open count.
	int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerCase(driver).getText());	//Reading Notice Open count.
	int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPalintiffCaseGraph(driver).getText());	//Reading Notice Open count.
	int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentCase(driver).getText());	//Reading Notice Open count.

	
    Thread.sleep(3000);
    CFOMethod.CaseNoticeTypeGraph1(driver, test,"Inward/Defendent Type",InwardDefendent);
    Thread.sleep(3000);
    CFOMethod.CaseNoticeTypeGraph1(driver, test,"Applicant",Applicant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Appellant",Appellant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Complianant",Complianant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Outward/Plaintiff Type",OutwardPlaintiff);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Respondent",Respondent);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1(driver, test,"Respondent",Respondent);
	
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 132)
void CaseNoticeStageGraph1() throws InterruptedException, IOException
   { 
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,800)");
  	
	   Thread.sleep(5000);
	   performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardCaseFilter(driver).click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardApplyBtn(driver).click();
	
	   js.executeScript("window.scrollBy(0,500)");
	
	   Thread.sleep(3000);
	   String StageName =performerPOM.CaseStageName(driver).getText();
		test = extent.startTest("Select Case from Notice/Case Filter :- "+StageName+" Stage:- To verify count of Case/Notice Summary graph");
 	
		Thread.sleep(3000);
		CFOMethod.CaseNoticeStageGraph1(driver, test,"cfo -");
 	
		extent.endTest(test);
		extent.flush();
   }
@Test(priority = 133)
void RiskSummaryGraph1() throws InterruptedException, IOException
{
	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Risk Summary graph");
    
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
 	
 	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter(driver).click();
  
   	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn(driver).click();
	 Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,950)");
	
    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh(driver).getText());	//Reading Notice Open count.
	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium(driver).getText());	//Reading Notice Open count.
	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow(driver).getText());	//Reading Notice Open count.
	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable(driver).getText());	//Reading Notice Open count.
	
	
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph1(driver, test,"High Risk",HighRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph1(driver, test,"Medium Risk",MediumRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph1(driver, test,"Low Risk",LowRisk);
	Thread.sleep(3000);
	CFOMethod.RiskSummaryGraph1(driver, test,"Not Applicable Risk",NotApplicableRisk);

	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 134)
 void DepartmentSummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");

	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();

	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter(driver).click();

	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();
	
	 js.executeScript("window.scrollBy(0,950)");

//	 String DeptName =performerPOM.DepartName(driver).getText();
//	 test = extent.startTest("Select Case type Filter :- "+DeptName+" Department - To check Department Summary Graph Count Verification");
	 test = extent.startTest("Select Case from Notice/Case Filter :-HR Department:- To verify count of Department Summary graph");
	  
	 
   Thread.sleep(3000);
   CFOMethod.DepartmentSummaryGraph1(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}
@Test(priority = 135)
void LocationSummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter(driver).click();
  
   	
   Thread.sleep(5000);
   performerPOM.clickDashboardApplyBtn(driver).click();
   
   js.executeScript("window.scrollBy(0,1300)");
	
//	  String LocationName =performerPOM.LocationName(driver).getText();
//		test = extent.startTest("Select Case type Filter :- "+LocationName+" Location :- To check Location Summary Graph Count Verification");
		test = extent.startTest("Select Case from Notice/Case Filter :- A Pvt Ltd Location:- To verify count of Location Summary graph");
  
   Thread.sleep(3000);
   CFOMethod.LocationSummaryGraph1(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}


@Test(priority = 136)
   void CategorySummaryGraph1() throws InterruptedException, IOException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter(driver).click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter(driver).click();
  
   	
	Thread.sleep(5000);
	performerPOM.clickDashboardApplyBtn(driver).click();
	
   	js.executeScript("window.scrollBy(0,1700)");
	
	
	
	Thread.sleep(2000);
//		String CategoryName =performerPOM.CategoryName(driver).getText();
//	test = extent.startTest("Select Case type Filter :- "+CategoryName+" Category :- To check Category Summary Graph Count Verification");
	test = extent.startTest("Select Case from Notice/Case Filter :-Civil Category:- To verify count of category Summary graph");
	
   Thread.sleep(3000);
   CFOMethod.CategorySummaryGraph1(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}

@Test(priority =137)
void ExpensesCaseGraph() throws InterruptedException, IOException
{
   test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense case wise graph");
  
   Thread.sleep(3000);
   CFOMethod.ExpensesCaseGraph( driver,test,"cfo -");

   extent.endTest(test);
   extent.flush();
}
@Test(priority =138)
void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
{
   test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense category wise graph");
  
   Thread.sleep(3000);
   CFOMethod.ExpensesCategoryWiseCaseGraph(driver, test,"cfo -");

   extent.endTest(test);
   extent.flush();
}
@Test(priority =139)
void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
{
test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense counsel wise graph");

Thread.sleep(3000);
CFOMethod.ExpensesCounselWiseCaseGraph( driver,test,"cfo -");

extent.endTest(test);
extent.flush();
}
@Test(priority =140)
void UtilizedBudgetGraph() throws InterruptedException, IOException
{
test = extent.startTest("Select Case from Notice/Case Filter to verify count of Utilized budget graph");

Thread.sleep(3000);
CFOMethod.UtilizedBudgetGraph(driver, test,"cfo -");

extent.endTest(test);
extent.flush();
}
@Test(priority =141)
void AgeingGraph() throws InterruptedException, IOException
{
			test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph");
     
     		JavascriptExecutor js = (JavascriptExecutor) driver;
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter(driver).click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter(driver).click();
   
    	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn(driver).click();
			 Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,3700)");
			 Thread.sleep(3000);
			 
			 int Applicant = Integer.parseInt(performerPOM.clickApplicantLessThanYearCase(driver).getText());	//Reading Notice Open count.
			 int Complainant = Integer.parseInt(performerPOM.clickComplainantLessThanYearCase(driver).getText());	//Reading Notice Open count.
			 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentLessThanYearCase(driver).getText());	//Reading Notice Open count.
			 int Appellant = Integer.parseInt(performerPOM.clickAppellantLessThanYearCase(driver).getText());	//Reading Notice Open count.
			 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffLessthanyearCase(driver).getText());	//Reading Notice Open count.
	    	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerLeassThanYearCase(driver).getText());	//Reading Notice Open count.
	    	 int Respondent = Integer.parseInt(performerPOM.clickRespondentLessThanYearCase(driver).getText());	//Reading Notice Open count.
	    	
			
	    	 
	    	 Thread.sleep(3000);
	    	 CFOMethod.AgeingGraphLessThanYear(driver, test,"Applicant",Applicant);
		    Thread.sleep(3000);
		    CFOMethod.AgeingGraphLessThanYear(driver, test,"Complainant",Complainant);
	    	Thread.sleep(3000);
	    	CFOMethod.AgeingGraphLessThanYear(driver, test,"Inward/Defendent",InwardDefendent);
	    	Thread.sleep(3000);
	    	CFOMethod.AgeingGraphLessThanYear(driver, test,"Appellant",Appellant);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear(driver, test,"Petitioner",Petitioner);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear(driver, test,"Respondent",Respondent);
			
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
    
			extent.endTest(test);
			extent.flush();
}

@Test(priority =142)
void AgeingGraph1to2yearsCase() throws InterruptedException, IOException
{
     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(1 to 2 year) Summary graph");
     
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter(driver).click();
		
		Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn(driver).click();
		
		 js.executeScript("window.scrollBy(0,3700)");
		 Thread.sleep(3000);
	    int	Complianant = Integer.parseInt(performerPOM.clickComplianant1to2yearCase(driver).getText());	//Reading Notice Open count.
    	int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardOutward1to2yearsCase(driver).getText());	//Reading Notice Open count.
    	int	Appleant = Integer.parseInt(performerPOM.clickAppleant1to2YearCase(driver).getText());	//Reading Notice Open count.
    	int	Outwardplaintiff = Integer.parseInt(performerPOM.clickOutwardplaintiff1toyearCase(driver).getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitioner1toyearCase(driver).getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent1toyearCase(driver).getText());	//Reading Notice Open count.
    	
    	Thread.sleep(3000);
    	CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Complianant",Complianant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Appleant",Appleant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Outward/plaintiff",Outwardplaintiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Petitioner",Petitioner);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase(driver,test,"Respondent",Respondent);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
    
      extent.endTest(test);
      extent.flush();
 }


@Test(priority =146)
void AgeingGraph2to3yearsCase() throws InterruptedException, IOException
{
     	test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(2 to 3 year) Summary graph");
     
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter(driver).click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn(driver).click();
		
		js.executeScript("window.scrollBy(0,3850)");
		 Thread.sleep(3000);
	    int	Applicant = Integer.parseInt(performerPOM.clickApplicant2to3yearCase(driver).getText());	//Reading Notice Open count.
    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiff2To3YearCase(driver).getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent2To3YearCase(driver).getText());	//Reading Notice Open count.
    
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase(driver, test,"Applicant",Applicant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase(driver, test,"Respondent",Respondent);
		
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
    
		extent.endTest(test);
		extent.flush();
 }
@Test(priority =147)
void AgeingGraphMoreThan3yearsCase() throws InterruptedException, IOException
{
     test = extent.startTest("Select Case from Notice/Case Filter to verify count of Ageing(more than 3 year) Summary graph");
     
     JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter(driver).click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn(driver).click();
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3850)");
		
	    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentCAMoreThan3yearsCase(driver).getText());	//Reading Notice Open count.
    	int	Appleant = Integer.parseInt(performerPOM.clickAppleantCaseCAMoreThan3years(driver).getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerCaseCAMoreThan3years(driver).getText());	//Reading Notice Open count.

		
    	Thread.sleep(3000);
    	CFOMethod.AgeingGraphMoreThan3yearsCase(driver, test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.AgeingGraphMoreThan3yearsCase(driver, test,"Appleant",Appleant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraphMoreThan3yearsCase(driver, test,"Petitioner",Petitioner);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
    
      extent.endTest(test);
      extent.flush();
 }
	  
	
	  
	
	@Test(priority = 146)
				void MyDocument() throws InterruptedException, IOException
				{
					test = extent.startTest("My Document-Download and View Document");
				
					
					CFOMethod.MyDocument(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	
	
			//@Test(priority =147)
			void ClosedCaseDoc() throws InterruptedException, IOException
			{
				test = extent.startTest("Closed case document verification");
						 	
				CFOMethod.ClosedCaseDoc(driver, test);
				extent.endTest(test);
			     extent.flush();
			}
			//@Test(priority = 148)
			void ClosedNoticeDoc() throws InterruptedException, IOException
			{
			test = extent.startTest("Closed notice document verification");
					 	
			CFOMethod.ClosedNoticeDoc(driver, test);
			extent.endTest(test);
			 extent.flush();
			}
		
	@Test(priority = 149)
		void ShareCaseDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Case Document Verification");
		
			
			CFOMethod.ShareCaseDocument(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 150)
		void ShareNoticeDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Notice Document Verification");
		
			
			CFOMethod.ShareNoticeDocument(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =151)
		void ShareTaskDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Task Document Verification");
		
			
			CFOMethod.ShareTaskDocument(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 158)
	void AdvancedSearchDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document(Advanced search) -Download and View Document");
		
		
		CFOMethod.AdvancedSearchDocument(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 159)
	void AdvancedSearchShareCaseDocument() throws InterruptedException, IOException
	{
	test = extent.startTest("My Document-Advance search-Share Case Document Verification");
	
	
	CFOMethod.AdvancedSearchShareCaseDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
	}
	@Test(priority =160)
		void AdvancedSearchShareNoticeDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Advance search-Share Notice Document Verification");
		
			
			CFOMethod.AdvancedSearchShareNoticeDocument(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	
			//@Test(priority =161)
			void AdvancedSearchClosedNoticeDoc() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advanced search- Closed notice document verification");
						 	
				CFOMethod.AdvancedSearchClosedNoticeDoc(driver, test);
				extent.endTest(test);
			     extent.flush();
			}
			//@Test(priority = 162)
			void AdvancedSearchClosedCaseDoc() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advanced search- Closed case document verification");
						 	
				CFOMethod.AdvancedSearchClosedCaseDoc(driver, test);
				extent.endTest(test);
			     extent.flush();
			}
	@Test(priority =163)
		void AdvancedSearchShareTaskDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Advance search-Share Task Document Verification");
		
			
			CFOMethod.AdvancedSearchShareTaskDocument(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 164) 		//Sever is blocking and not allowing to upload the file.
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest(" Critical Document Verification");
		
		CFOMethod.CriticalDocuments(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 165) 		//Sever is blocking and not allowing to upload the file.
	void CriticalDocuments1() throws InterruptedException, IOException
	{
		test = extent.startTest(" Critical Document Verification");
		
		CFOMethod.CriticalDocuments1(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 166)
	void DocumentFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" My Document = Notice = Multiple  Filters verification");
	
		
		CFOMethod.DocumentNoticeFilter(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 167)
	void DocumentCaseFilter() throws InterruptedException, IOException
	{
	test = extent.startTest(" My Document = Case = Multiple  Filters verification");
	
	
	CFOMethod.DocumentCaseFilter(driver, test);
	
	extent.endTest(test);
	extent.flush();
	}
	@Test(priority =168)
	void DocumentTaskFilter() throws InterruptedException, IOException
	{
	test = extent.startTest(" My Document = Task = Multiple  Filters verification");
	
	
	CFOMethod.DocumentTaskFilter(driver, test);
	
	extent.endTest(test);
	extent.flush();
	}
	
	@Test(priority = 169)
					void MyReports() throws InterruptedException, IOException
					{
						test = extent.startTest("Reports -excel count verification");
						
						CFOMethod.MyReports(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		        
		@Test(priority = 170)
					void MoreReports() throws InterruptedException, IOException
					{
						test = extent.startTest("More Report-Reports excel  verification");
						
						
						CFOMethod.MoreReport(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
	
		@Test(priority = 171)
			void AdvancedSearchreport() throws InterruptedException, IOException
			{
				test = extent.startTest("My Report- Advanced search verification");
			
				
				CFOMethod.AdvancedSearchReport(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		// @Test(priority =172)
			void ReportNoticeFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("My Report = Notice =  Filters verification");
				
				
				CFOMethod.ReportNoticeFilter(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	//@Test(priority = 0)
		void ReportCaseFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report = Case =  Filters verification");
			
			
			CFOMethod.ReportCaseFilter(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
//	@Test(priority =174)
		void ReportTaskFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report = Task =  Filters verification");
			
			
			CFOMethod.ReportTaskFilter(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	
				
					
	@Test(priority =175)
					void MyReminder() throws InterruptedException, IOException
					{
						test = extent.startTest("My Reminder verification");
						
						CFOMethod.MyReminder(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority =176)
		void ReminderWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reminder Without data verification");
			
			CFOMethod.ReminderWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
					
		 @Test(priority = 177)
					void ImportUtility() throws InterruptedException, IOException
					{
						test = extent.startTest("Import Utility verification");
						
						
						CFOMethod.ImportUtility(driver,test);
						extent.endTest(test);
						extent.flush();
					}
		 @Test(priority = 178)
			void ImportUtilityWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Upload Empty File Import Utility verification");
				
				
				CFOMethod.ImportUtilityWithoutData(driver,test);
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 179)
			void ImportUtilityInvalidData() throws InterruptedException, IOException
			{
				test = extent.startTest("Enter Invalid data in Upload File Import Utility verification");
				
				
				CFOMethod.ImportUtilityInvalidData(driver,test);
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 180)
			void ImportUtilityTwoManadtoryFileds() throws InterruptedException, IOException
			{
				test = extent.startTest("Enter Two Manadtory fields in Upload File Import Utility verification");
				
				
				CFOMethod.ImportUtilityTwoManadtoryFileds(driver,test);
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 181)
		void CaseUpdationImportUtility() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Updation Import Utility verification");
			
			
			CFOMethod.CaseUpdationImportUtility(driver,test);
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 182)
		void CaseUpdationUploadEmtyFile() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Updation -Empty File Import Utility verification");
			
			
			CFOMethod.CaseUpdationUploadEmtyFile(driver,test);
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 183)
		void CaseUpdationUploadInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Updation -Invalid Data Import Utility verification");
			
			
			CFOMethod.CaseUpdationUploadInvalidData(driver,test);
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 184)
		void CaseUpdationUploadInvalidFile() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Updation -Invalid File Import Utility verification");
			
			
			CFOMethod.CaseUpdationUploadInvalidFile(driver,test);
			extent.endTest(test);
			extent.flush();
		}
	 
	@Test(priority = 185)
		void NoticeUpdation() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Updation Import Utility verification");
			
			
			CFOMethod.NoticeUpdation(driver,test);
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 186)
	void NoticeUpdationUploadEmtyFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation-Empty File Import Utility verification");
		
		
		CFOMethod.NoticeUpdationUploadEmtyFile(driver,test);
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 187)
	void NoticeUpdationUploadInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation -Invalid Data Import Utility verification");
		
		
		CFOMethod.NoticeUpdationUploadInvalidData(driver,test);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 188)
	void NoticeUpdationUploadInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation -Invalid File Import Utility verification");
		
		
		CFOMethod.NoticeUpdationUploadInvalidFile(driver,test);
		extent.endTest(test);
		extent.flush();
	}
	
	
		
		
			@Test(priority = 189)
				void Masters() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Legal Entity  verification");
						
						CFOMethod.LegalEntity(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority = 190)
			void MastersLegalEntity() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Legal Entity Without data verification");
					
					CFOMethod.LegalEntityWithoutData(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
			@Test(priority =191)
			void MastersLegalEntity1() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Legal Entity Invalid data verification");
					
					CFOMethod.LegalEntityInvalidData(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority =192)
			void MastersLegalEntity2() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Legal Entity Two Manadatory Fields verification");
					
					CFOMethod.LegalEntityTwoManadatoryFields(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
			@Test(priority =192)
					void MastersLegalEntity3() throws InterruptedException, IOException
						{
							test = extent.startTest("Masters - Legal Entity Close Button verification");
							
							CFOMethod.LegalEntityCloseButton(driver, test);
							
							extent.endTest(test);
							extent.flush();
						}
			@Test(priority =193)
			void UnitEntity() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Add Unit Entity verification");
					
					CFOMethod.AddUnitType(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority = 194)
					void Masters1() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Law Firm verification");
						
						
						CFOMethod.LawFirm(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority =195)
		void MastersLawFirm() throws InterruptedException, IOException
		{
			test = extent.startTest("Law Firm Masters - Enter Without Data verification");
			
			
			CFOMethod.LawFirmWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =196)
		void MastersLawFirm1() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Law Firm Invalid Data verification");
			
			
			CFOMethod.LawFirmInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =197)
		void MastersLawFirm2() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Law Firm Two Manadtory fields verification");
			
			
			CFOMethod.LawFirmTwoManadatoryFields(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =198)
		void MastersLawFirm3() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Law Firm Close button verification");
			
			
			CFOMethod.LawFirmCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 199)
		void LawyerWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Lawyer  - Enter Without Data verification");
			
			
			CFOMethod.LawyerWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =200)
		void LawyerInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Lawyer  - Enter Invalid Data verification");
			
			
			CFOMethod.LawyerInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 201)
		void LawyerTwoManadatoryFileds() throws InterruptedException, IOException
		{
			test = extent.startTest("Lawyer  - Enter Two Manadatory fields verification");
			
			
			CFOMethod.LawyerTwoManadatoryFileds(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 202)
		void LawyerCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Lawyer  - Enter close button verification");
			
			
			CFOMethod.LawyerCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 203)
					void Masters2() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - 	User  verification");
						
						
						CFOMethod.User(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
	@Test(priority = 204)
		void UserWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("User Master-  without data verification");
			
			
			CFOMethod.UserWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 205)
		void UserInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("User Master-  Invalid data verification");
			
			
			CFOMethod.UserInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =206)
		void UserTwoManadatoryFields() throws InterruptedException, IOException
		{
			test = extent.startTest("User Master- Two manadatory fields verification");
			
			
			CFOMethod.UserTwoManadatoryFields(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =207)
		void UserCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("User Master- Close Button  verification");
			
			
			CFOMethod.UserCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 208)
					void Masters3() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Opponent  verification");
						
						
						CFOMethod.Opponent(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		
	
		@Test(priority =209)
					void OpponentWithoutData() throws InterruptedException, IOException
					{
						test = extent.startTest("Opponent Masters -Without Data verification");
						
						
						CFOMethod.OpponentWithoutData(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority =210)
		void OpponentInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Opponent Masters -Invalid Data verification");
			
			
			CFOMethod.OpponentInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 211)
		void OpponentCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Opponent Masters -Close button verification");
			
			
			CFOMethod.OpponentCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
					
		@Test(priority = 212)
					void Masters4() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Court  verification");
						
						
						CFOMethod.Court(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority = 213)
		void CourtWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Court Master- Without enter Data verification");
			
			
			CFOMethod.CourtWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 214)
		void CourtInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Court Master- Enter Invalid Data verification");
			
			
			CFOMethod.CourtInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 215)
		void CourtTwomanadatoryFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Court Master- Enter Two Manadtory Fields verification");
			
			
			CFOMethod.CourtTwomanadatoryFields(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =216)
		void CourtCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Court Master- Close button verification");
			
			
			CFOMethod.CourtCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 217)
					void Masters5() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Case/NoticeType  verification");
						
						
						CFOMethod.CaseNoticeType(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority = 218)
		void CaseNoticeTypeWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case/NoticeType Master -Without Enter Data  verification");
			
			
			CFOMethod.CaseNoticeTypeWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 219)
		void CaseNoticeTypeInvaliData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case/NoticeType Master - Enter Invalid Data  verification");
			
			
			CFOMethod.CaseNoticeTypeInvaliData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 220)
		void CaseNoticeTypeCloseBuuton() throws InterruptedException, IOException
		{
			test = extent.startTest("Case/NoticeType Master - Close Button  verification");
			
			
			CFOMethod.CaseNoticeTypeCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 221)
					void Masters6() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Payment Type  verification");
						
						
						CFOMethod.PaymentType(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
	 
	 @Test(priority = 222)
	          void PaymentTypeWithouData() throws InterruptedException, IOException
	         {
		         test = extent.startTest("Payment Type Master- Without Enter Data  verification");
		 
		
		          CFOMethod.PaymentTypeWithoutData(driver, test);
		
		          extent.endTest(test);
		          extent.flush();
	         }
	    @Test(priority = 223)
	    void PaymentTypeInvalidData() throws InterruptedException, IOException
	   {
	       test = extent.startTest("Payment Type Master-Enter Invalid Data  verification");
	
	
	        CFOMethod.PaymentTypeInvalidData(driver, test);
	
	        extent.endTest(test);
	        extent.flush();
	   }
	   @Test(priority = 224)
	    void PaymentTypeCloseButton() throws InterruptedException, IOException
	   {
	       test = extent.startTest("Payment Type Master-Close button verification");
	
	
	        CFOMethod.PaymentTypeCloseButton(driver, test);
	
	        extent.endTest(test);
	        extent.flush();
	   }
	
		@Test(priority =225)
					void Masters7() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Custom Parameter  verification");
					
						
						CFOMethod.customParameter(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority = 226)
		void customParameterWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Custom Parameter Master -Without Enter Data  verification");
		
			
			CFOMethod.customParameterWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority = 227)
		void customParameterInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Custom Parameter Master -Enter Invalid Data verification");
		
			
			CFOMethod.customParameterInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 228)
		void customParameterCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Custom Parameter Master -Close  button  verification");
		
			
			CFOMethod.customParameterCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 229)
					void Masters8() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Case Stage  verification");
					
						
						CFOMethod.CaseStage(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
	@Test(priority = 230)
		void CaseStageWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Stage Masters - Without Enter Data  verification");
		
			
			CFOMethod.CaseStageWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 231)
		void CaseStageInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Stage Masters - Enter Invalid Data  verification");
		
			
			CFOMethod.CaseStageInvalidData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 232)
		void CaseStageCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Stage Masters - Close Button verification");
		
			
			CFOMethod.CaseStageCloseButton(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
			@Test(priority = 233)
					void Masters9() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Document Type  verification");
						
						
						CFOMethod.DocumentType(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority = 234)
			void DocumentTypeWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Document Type Masters-Without data  verification");
				
				
				CFOMethod.DocumentTypeWithoutData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority =235)
			void DocumentTypeInvalidData() throws InterruptedException, IOException
			{
				test = extent.startTest("Document Type Masters-Enter Invalid Data verification");
				
				
				CFOMethod.DocumentTypeInvalidData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 236)
			void DocumentTypeCloseButton() throws InterruptedException, IOException
			{
				test = extent.startTest("Document Type Masters-Close button verification");
				
				
				CFOMethod.DocumentTypeCloseButton(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority = 237)
					void Masters10() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Rating Criteria  verification");
					
						
						CFOMethod.RatingCriteria(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority = 238)
			void RatingCriteriaWithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Rating Criteria Masters-Without Enter Data  verification");
			
				
				CFOMethod.RatingCriteriaWithoutData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 239)
			void RatingCriteriaInvalidData() throws InterruptedException, IOException
			{
				test = extent.startTest("Rating Criteria Masters-Enter Invalid Data  verification");
			
				
				CFOMethod.RatingCriteriaInvalidData(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}		
		@Test(priority =240)
			void RatingCriteriaCloseButton() throws InterruptedException, IOException
			{
				test = extent.startTest("Rating Criteria Master-Close button verification");
			
				
				CFOMethod.RatingCriteriaCloseButton(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}		
		@Test(priority = 241)
					void Masters12() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Notice Stage  verification");
						
						
						CFOMethod.NoticeStage(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}
			@Test(priority = 242)
					void Masters11() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - UserReassignment  verification");
						
						
						CFOMethod.UserReassignment(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority = 243)
					void Masters13() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Mail Authorization  verification");
						
						CFOMethod.MailAuthorization(driver,test);
						
						extent.endTest(test);
						extent.flush();
					}
	
					
					
			//@Test(priority = 245)
					void Draft() throws InterruptedException, IOException
					{
						test = extent.startTest("Draft Count verification");
						//test.log(LogStatus.INFO, "Test Initiated");
						
						CFOMethod.Draft(driver, test);
						
						extent.endTest(test);
						extent.flush();
					}
				

			
 
	

			 @AfterMethod
					 
					 void Close()
					 {
						 driver.close(); 
					 }

		

		


	
//			@AfterTest()	
//			
//			void chromeclose() throws InterruptedException
//			{
//				Thread.sleep(5000);
//			  driver.close();
//			}

}
