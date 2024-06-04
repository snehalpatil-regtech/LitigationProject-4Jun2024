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
import login.BasePage;
import cfo.OverduePOM;


public class CFO extends BasePage{
	
		//public static WebDriver driver = null;		//WebDriver instance created
		//public static WebElement upload = null;		//WebElement to get upload button
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;				//Instance created for tests
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		public static List<WebElement> elementsList = null;
		
//		public static XSSFSheet ReadExcel() throws IOException
//		{
//			//String workingDir = System.getProperty("user.dir");
//			fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx");
//			
//			workbook = new XSSFWorkbook(fis);
//			sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
//			return sheet;
//		}
		
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
		
			/*XSSFSheet sheet = ReadExcel();
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
			
			driver = login.Login.UserLogin(uname,password,"cfo");		//Method of Login class to login user.*/
			
			initialization("cfo-diy",2);
			

		}
		

		
// @Test(priority = 2)
			void DashBoardFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("All Filters verification");
				
				Thread.sleep(3000);
				CFOMethod.DashBoardFilter( test, "Cfo-");
				
				extent.endTest(test);
				extent.flush();
			}
			
			

	/*		@Test(priority =1)
		    	void NoticeOpen() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Notice - Open Count verification");
		    		
		    		
		    		CFOMethod.NoticeOpen(test);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		 @Test(priority =2)
		 	void NoticeWithExistingData() throws InterruptedException, IOException
		 	{
		 		test = extent.startTest("Notice With Existing Data verification");
		 		
		 		
		 		CFOMethod.NoticeWithExistingData( test);
		 		
		 		extent.endTest(test);
		 		extent.flush();
		 	}
			
		 @Test(priority =3)
		     void NoticeWithInvalidData() throws InterruptedException, IOException
		    {
			     test = extent.startTest("Notice With Invalid Data verification");
			
			
			      CFOMethod.NoticeWithInvalidData( test, workbook);
			
			     extent.endTest(test);
			     extent.flush();
		   }
		 @Test(priority =4)
		   void NoticeWithTwoMandatoryData() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice With Two Mandatory Fields verification");
			
			
			      CFOMethod.NoticeWithTwoMandatoryData( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		 @Test(priority =5) 
		   void NoticeWithEmptyFields() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice With Empty Fields verification");
			
			
			      CFOMethod.NoticeWithEmptyFields( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }

		@Test(priority =6)
		   void NoticeClearBtn() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice Summary -Clear button verification");
			
			
			      CFOMethod.NoticeClearBtn( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		@Test(priority =7)
		   void NoticeSendMailWithDoc() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice Summary-Send Mail With Document verification");
			
			
			      CFOMethod.NoticeSendMailWithDoc( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		@Test(priority =8)
		   void NoticeSendMailWithDocInvalidFields() throws InterruptedException, IOException
		  {
			     test = extent.startTest(" Notice Summary -Send Mail With Document Invalid Fields verification");
			
			
			      CFOMethod.NoticeSendMailWithDocInvalidFields( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		@Test(priority =9)
		   void NoticeSendMailWithDocEmptyFields() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice Summary -Send Mail With Document Empty Fields verification");
			
			
			      CFOMethod.NoticeSendMailWithDocEmptyFields( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		// @Test(priority =10)
		   void NoticeUserAssignment() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice User Assignment  verification");
			
			
			      CFOMethod.NoticeUserAssignment( test,workbook);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		// @Test(priority =11)
		   void NoticeUserAssignmentDelete() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Notice User Assignment Delete Icon  verification");
			
			
			      CFOMethod.NoticeUserAssignmentDelete( test,workbook);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		   
		@Test(priority =12)
			void LinkNotice() throws InterruptedException, IOException
			{
				test = extent.startTest("Link Notice Verification");
				
				
				CFOMethod.LinkDocument( test, workbook, "Notice");
				
				extent.endTest(test);
				extent.flush();
			}
		   
		 @Test(priority =13)
		   void LinkNoticeViewIcon() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Linked notice view icon  verification");
			
			
			      CFOMethod.LinkNoticeViewIcon( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		@Test(priority =14)
		   void LinkNoticeDeleteIcon() throws InterruptedException, IOException
		  {
			     test = extent.startTest("Linked notice Delete icon  verification");
			
			
			      CFOMethod.LinkNoticeDeleteIcon( test);
			
			     extent.endTest(test);
			     extent.flush();
		 }
		
		@Test(priority = 15)
    	void NoticeDocument() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Document verification");
    		
    		
    		CFOMethod.NoticeDocument( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
		
		@Test(priority = 16)
    	void NoticeDocViewandDownload() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Summary - Document view and download  verification");
    		//test.log(LogStatus.INFO, "Test Initiated");
    		
    		CFOMethod.NoticeDocViewandDownload( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
		
@Test(priority = 17)
	void NoticeDocumentEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document with empty fields verification");
		
		
		CFOMethod.NoticeDocumentEmptyFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 18)
	void NoticeWithoutUploadDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Without Upload Document verification");
		
		
		CFOMethod.NoticeWithoutUploadDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 18)
	void NoticeDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Search Fields verification");
		
		
		CFOMethod.NoticeDocumentSearchFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 19)
	void NoticeDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share with Invaid data verification");
		
		
		CFOMethod.NoticeDocumentShareInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 20)
	void NoticeDocumentShareWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share without data verification");
		
		
		CFOMethod.NoticeDocumentShareWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 21)
	void NoticeDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share close button verification");
		
		
		CFOMethod.NoticeDocumentShareCloseBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
@Test(priority = 22)
    	void NoticeTaskActivity() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice TaskActivtiy verification");
    		
    		
    		CFOMethod.TaskActivtity( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
@Test(priority = 23)
	void TaskActivtityDeleteResponse() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Delete Response verification");
		
		
		CFOMethod.TaskActivtityDeleteResponse( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 24)
	void TaskActivtityExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy with existing data verification");
		
		
		CFOMethod.TaskActivtityExistingData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =25)
	void TaskActivtityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Without data verification");
		
		
		CFOMethod.TaskActivtityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 26)
	void TaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Response Without data verification");
		
		
		CFOMethod.TaskActivtityResponseWithoutStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
@Test(priority = 27)
	void TaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy  Response clear button verification");
		
		
		CFOMethod.TaskActivtityResponseClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =28)
    	void NoticeResponse() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Response verification");
    		
    		
    		CFOMethod.Response( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
	@Test(priority =29)
	void ResponseExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Existing Data verification");
		
		
		CFOMethod.ResponseExistingData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =30)
	void NoticeResponseWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Without data verification");
		
		
		CFOMethod.ResponseWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =31)
	void ResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Response Clear button verification");
		
		
		CFOMethod.ResponseClearBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}
    	
	@Test(priority = 32)
    	void NoticePayment() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Payment verification");
    		
    		
    		CFOMethod.PaymentLog(test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
	@Test(priority = 33)
	void PaymentLogwithExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Payment with existing data verification");
		
		
		CFOMethod.PaymentLogwithExistingData(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 34)
	void PaymentLogwithInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Payment with Invalid data verification");
		
		
		CFOMethod.PaymentLogwithInvalidData(test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 35)
	void NoticePaymentWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Payment Without data verification");
		
		
		CFOMethod.PaymentLogWithoutData(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 36)
    	void NoticeExternalLawyer() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Lawyer verification");
    		
    		CFOMethod.ExternalLawyer( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
    	@Test(priority = 37)
    	void ExternalLawyerWithoutRating() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice External Lawyer without rating verification");
    		
    		CFOMethod.ExternalLawyerWithoutRating( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
	@Test(priority = 38)
	void CriteriaExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Existing Data verification");
		
		CFOMethod.CriteriaExistingData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 39)
	void CriteriaInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Invalid Data verification");
		
		CFOMethod.CriteriaInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 40)
	void CriteriaWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Criteria Without Data verification");
		
		CFOMethod.CriteriaWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
  	
	@Test(priority = 41)
    	void NoticeAuditLog() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Audit Log verification");
    	
    		
    		CFOMethod.AuditLog( test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}		
		  
		@Test(priority =42)
		     	void CaseOpen() throws InterruptedException, IOException
		     	{
		     		test = extent.startTest("Case - Open Count verification");
		     		
		     		
		     		CFOMethod.CaseOpen( test);
		     		
		     		extent.endTest(test);
		     		extent.flush();
		     	}
		 @Test(priority =43)
		 	void CaseExistingData() throws InterruptedException, IOException
		 	{
		 		test = extent.startTest("Case with Existing Data verification");
		 		
		 		
		 		CFOMethod.CaseExistingData( test);
		 		
		 		extent.endTest(test);
		 		extent.flush();
		 	}
		@Test(priority =44)
		 	void CaseWithInvalidData() throws InterruptedException, IOException
		 	{
		 		test = extent.startTest("Case with Invalid Data verification");
		 		
		 		
		 		CFOMethod.CaseWithInvalidData( test);
		 		
		 		extent.endTest(test);
		 		extent.flush();
		 	}
		@Test(priority =45)
		   	void CaseWithTwoFieldsData() throws InterruptedException, IOException
		   	{
		   		test = extent.startTest("Case with Two Manadatory fields verification");
		   		
		   		
		   		CFOMethod.CaseWithTwoFieldsData( test);
		   		
		   		extent.endTest(test);
		   		extent.flush();
		   	}
		 @Test(priority =46)
		   	void CaseWithEmptyFields() throws InterruptedException, IOException
		   	{
		   		test = extent.startTest("Case with Empty fields verification");
		   		
		   		
		   		CFOMethod.CaseWithEmptyFields( test);
		   		
		   		extent.endTest(test);
		   		extent.flush();
		   	}
		@Test(priority =47)
		   	void CaseWithClearBtn() throws InterruptedException, IOException
		   	{
		   		test = extent.startTest("Case Summary - Clear button verification");
		   		
		   		
		   		CFOMethod.CaseWithClearBtn( test);
		   		
		   		extent.endTest(test);
		   		extent.flush();
		   	}
		  
		// @Test(priority =48)
		   	void CaseUserAssignment() throws InterruptedException, IOException
		   	{
		   		test = extent.startTest("Case User Assignment verification");
		   		
		   		
		   		CFOMethod.CaseUserAssignment( test,workbook);
		   		
		   		extent.endTest(test);
		   		extent.flush();
		   	}
	//	@Test(priority =49)
		    void CaseUserAssignmentDelete() throws InterruptedException, IOException
		   {
		 	     test = extent.startTest("Case User Assignment Delete Icon  verification");
		 	
		 	
		 	      CFOMethod.CaseUserAssignmentDelete( test);
		 	
		 	     extent.endTest(test);
		 	     extent.flush();
		  }
		
		@Test(priority = 50)
		void LinkCase() throws InterruptedException, IOException
		{
			test = extent.startTest("Link Case Verification");
		
			
			CFOMethod.LinkDocument( test, workbook, "Case");
		
		extent.endTest(test);
			extent.flush();
		}
	
 @Test(priority =51)
	   void LinkCaseViewIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case view icon  verification");
		
		
		      CFOMethod.LinkCaseViewIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
 @Test(priority =52)
	   void LinkCaseDeleteIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case delete icon  verification");
		
		
		      CFOMethod.LinkCaseDeleteIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
 

	@Test(priority =53)
	    	void CaseDocument() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Document Tab");
	    		
	    		
	    		CFOMethod.Document( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority = 54)
			void CaseWithoutUploadDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Without Upload Document verification");
				
				
				CFOMethod.CaseWithoutUploadDocument( test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 55)
		void CaseDocumentEmptyFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Document with empty fields verification");
			
			
			CFOMethod.CaseDocumentEmptyFields( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 56)
		void CaseDocumentSearchFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Document Search Fields verification");
			
			
			CFOMethod.CaseDocumentSearchFields( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 57)
		void CaseDocumentShareInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Document Share with Invalid data verification");
			
			
			CFOMethod.CaseDocumentShareInvalidData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =58)
		void CaseDocumentShareWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Document Share without data verification");
			
			
			CFOMethod.CaseDocumentShareWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 59)
		void CaseDocumentShareCloseBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Document Share close button verification");
			
			
			CFOMethod.CaseDocumentShareCloseBtn( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	 @Test(priority =60)
		    void CaseSendMailWithDoc() throws InterruptedException, IOException
		   {
		 	     test = extent.startTest("Case Summary-Send Mail With Document verification");
		 	
		 	
		 	      CFOMethod.CaseSendMailWithDoc( test);
		 	
		 	     extent.endTest(test);
		 	     extent.flush();
		  }
		    
		    @Test(priority =61)
		    void CaseSendMailWithDocInvalidFields() throws InterruptedException, IOException
		   {
		 	     test = extent.startTest("Case  Summary-Send Mail With Document Invalid Fields verification");
		 	
		 	
		 	      CFOMethod.CaseSendMailWithDocInvalidFields( test);
		 	
		 	     extent.endTest(test);
		 	     extent.flush();
		  }
	   @Test(priority =62)
		    void CaseSendMailWithDocEmptyFields() throws InterruptedException, IOException
		   {
		 	     test = extent.startTest("Case Summarys -Send Mail With Document Empty Fields verification");
		 	
		 	
		 	      CFOMethod.CaseSendMailWithDocEmptyFields( test);
		 	
		 	     extent.endTest(test);
		 	     extent.flush();
		  }
		    
		@Test(priority =63)
	    	void CaseTaskActivity() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Task/Activty Tab");
	    		
	    		
	    		CFOMethod.TaskActivity1( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
			
	@Test(priority = 64)
				void CaseTaskActivityWithoutData() throws InterruptedException, IOException
				{
					test = extent.startTest("Case Task/Activtiy Without data verification");
					
					
					CFOMethod.CaseTaskActivityWithoutData( test);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority =65)
	    	void CaseTaskActivitywithExistingData() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Task/Activty with existing data");
	    		
	    		
	    		CFOMethod.CaseTaskActivitywithExistingData( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
			
		 @Test(priority = 66)
				void CaseTaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
				{
					test = extent.startTest("Case Task/Activtiy Response Without data verification");
					
					
					CFOMethod.CaseTaskActivtityResponseWithoutStatus( test);
					
					extent.endTest(test);
					extent.flush();
				}
			 
	@Test(priority =67)
				void CaseTaskActivtityResponseClearBtn() throws InterruptedException, IOException
				{
					test = extent.startTest("Case Task/Activtiy  Response clear button verification");
					
					
					CFOMethod.CaseTaskActivtityResponseClearBtn( test);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority =68)
	    	void CaseHearingcfo() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - CaseHearing Tab");
	    		
	    		
	    		CFOMethod.CaseHearing( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	/*@Test(priority =69)
		void CaseExistingHearingDate() throws InterruptedException, IOException
		{
			test = extent.startTest("Case with Existing Hearing Date Verification");
			
			
			CFOMethod. CaseExistingHearingDate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	  @Test(priority= 70)
	  void CaseWithoutHearingData() throws InterruptedException, IOException
	  {
		test = extent.startTest("Case without hearing data Verification");
		
		
		CFOMethod.CaseHearingWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	  }
	@Test(priority =71)
	   void CaseHearingInvalidDate() throws InterruptedException, IOException
	   {
	 	test = extent.startTest("Case Invalid Hearing Date Verification");
	 	
	 	
	 	CFOMethod.CaseHearingInvalidDate( test);
	 	
	 	extent.endTest(test);
	 	extent.flush();
	   }
	 @Test(priority =71)
	   void CaseHearingClearBtn() throws InterruptedException, IOException
	   {
	 	test = extent.startTest("Case heraing clear button Verification");
	 	
	 	
	 	CFOMethod.CaseHearingClearBtn( test);
	 	
	 	extent.endTest(test);
	 	extent.flush();
	   }
	@Test(priority =72)
	    	void CaseOrder() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Case Order Tab");
	    	
	    		
	    		CFOMethod.CaseOrder( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =73)
		void CaseOrderExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Order with Duplicate data");

		
			CFOMethod.CaseOrderwithExistingData( test);
		
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority =74)
		void CaseOrderWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Without data Order tab");

		
			CFOMethod.CaseOrderWithoutData( test);
		
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority =75)
		void CaseOrderwithClearBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Order with clear button");

		
			CFOMethod.CaseOrderwithClearBtn( test);
		
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =76)
	    	void CaseStatusPayment() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Status/Payment Tab");
	    		
	    		
	    		CFOMethod.StatusPayment( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =77)
	    	void StatusPaymentExistingdata() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case Status/Payment with duplicate data ");
	    		
	    		
	    		CFOMethod.StatusPaymentExistingdata( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =78)
	void StatusPaymentwithInvaliddata() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment with Invalid data ");
		
		
		CFOMethod.StatusPaymentwithInvaliddata( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =79)
	    	void StatusPaymentWithoutdata() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case Status/Payment without data ");
	    		
	    		
	    		CFOMethod.StatusPaymentWithoutdata( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
			
	    	@Ignore
			@Test(priority =120)
	    	void CaseStatusAppealtoNextCourtTwoMandatoryfields() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case Status -Enter Two manadatory fields click on Appeal to Next Court");
	    		
	    		
	    		CFOMethod.CaseStatusAppealtoNextCourtTwoMandatoryfields( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	    	
		@Test(priority =80)
	    	void CaseStatusAppealtoNextCourt() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case Status Appeal to Next Court");
	    		
	    		
	    		CFOMethod.CaseStatusAppealtoNextCourt( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =81)
	    	void CaseStatuswithEmptyFields() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case Status With Empty Fields");
	    		
	    		
	    		CFOMethod.CaseStatuswithEmptyFields( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =82)
	    	void CaseExternalLawyerRating() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - External Lawyer Rating");
	    		
	    		
	    		CFOMethod.CaseExternalLawyer( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	    	@Test(priority =83)
	    	void CaseExternalLawyerWitoutRating() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - External Lawyer Without Rating");
	    		
	    		
	    		CFOMethod.CaseExternalLawyerWitoutRating( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	@Test(priority =84)
		void CaseExternalLawyerCriteria() throws InterruptedException, IOException
		{
			test = extent.startTest("Case - External Lawyer Rating -Add New Criteria ");
			
			
			CFOMethod.CaseExternalLawyerCriteria( test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	 @Test(priority = 85)
		void CaseExistingCriteria() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Criteria Existing Data verification");
			
			CFOMethod.CaseExistingCriteria( test);
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 86)
		void CaseCriteriaInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Criteria Invalid Data verification");
			
			CFOMethod.CaseCriteriaInvalidData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 87)
		void CaseCriteriaWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Criteria Without Data verification");
			
			CFOMethod.CaseCriteriaWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =88)
	    	void CaseAuditLog() throws InterruptedException, IOException
	    	{
	    		test = extent.startTest("Case - Audit Log Tab");
	    		
	    		
	    		CFOMethod.Auditlog( test);
	    		
	    		extent.endTest(test);
	    		extent.flush();
	    	}
	    
		@Test(priority =89)
		    			void TaskOpen() throws InterruptedException, IOException
		    			{
		    				test = extent.startTest("Task - Open Count verification");
		    				
		    				
		    				CFOMethod.TaskOpen( test);
		    				
		    				extent.endTest(test);
		    				extent.flush();
		    			}
		 @Test(priority = 90)
					void TaskwithExistingData() throws InterruptedException, IOException
					{
						test = extent.startTest("Task With existing data verification");
						
						
						CFOMethod.TaskwithExistingData( test);
						
						extent.endTest(test);
						extent.flush();
					
					}
		 @Test(priority =91)
		    			void TaskwithTwoManadatoryFields() throws InterruptedException, IOException
		    			{
		    				test = extent.startTest("Task With Two manadatory fields verification");
		    				
		    				
		    				CFOMethod.TaskwithTwoManadatoryFields( test);
		    				
		    				extent.endTest(test);
		    				extent.flush();
		    			}
		  @Test(priority = 92)
					void TaskwithoutData() throws InterruptedException, IOException
					{
						test = extent.startTest("Task Without  data verification");
						
						
						CFOMethod.TaskwithoutData( test);
						
						extent.endTest(test);
						extent.flush();
					}
		   @Test(priority =93)
					void TaskwithClearBtn() throws InterruptedException, IOException
					{
						test = extent.startTest("Task Clear button verification");
						
						
						CFOMethod.TaskwithClearBtn( test);
						
						extent.endTest(test);
						extent.flush();
					}
		 @Test(priority = 94)
					void TaskDelete() throws InterruptedException, IOException
					{
						test = extent.startTest("Task Delete verification");
						
						
						CFOMethod.TaskDelete( test);
						
						extent.endTest(test);
						extent.flush();
					}
	@Test(priority = 95)
		    	void NoticeClosed() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Notice - Closed Count verification");
		    		
		    		
		    		CFOMethod.NoticeClosed( test, workbook, "Company Admin");
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority = 96)
		    	void CaseClose() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Case - Closed Count verification");
		    		
		    		
		    		CFOMethod.CaseClosed( test, workbook);
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
			   
		@Test(priority =97)
		    	void CloseNotice() throws InterruptedException, IOException
		    	{
		    		test = extent.startTest("Close Notice Count verification");
		    		
		    		CFOMethod.CloseNoticeCase( test,"Notice");
		    		
		    		extent.endTest(test);
		    		extent.flush();
		    	}
		@Test(priority = 98)
					void CloseCase() throws InterruptedException, IOException
					{
					test = extent.startTest("Close Case Count Verification");
						
						
						CFOMethod.CloseNoticeCase( test,"Case");
						
					extent.endTest(test);
						extent.flush();
					}
			  
		@Test(priority = 99)
					void TaskClosed() throws InterruptedException, IOException
					{
						test = extent.startTest("Task - Closed Count verification");
						
						
						CFOMethod.TaskClosed( test, workbook, "CFO");
						
						extent.endTest(test);
						extent.flush();
					}
		
		@Test(priority = 100)
				void WorkspaceFilter() throws InterruptedException, IOException
				{
					test = extent.startTest("My Workspace = Notice = Multiple  Filters verification");
					
					
					CFOMethod.WorkspaceNoticeFilter( test);
					
					extent.endTest(test);
					extent.flush();
				}
			
		 @Test(priority = 101)
				void WorkspaceCaseFilter() throws InterruptedException, IOException
				{
					test = extent.startTest("My Workspace = Case = Multiple  Filters verification");
					
					
					CFOMethod.WorkspaceCaseFilter( test);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority = 102)
			void WorkspaceTaskFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace = Task = Multiple  Filters verification");
				
				
				CFOMethod.WorkspaceTaskFilter( test);
				
				extent.endTest(test);
				extent.flush();
			}
		
		@Test(priority = 103)
		void AdvancedSearch() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace-Advanced Search verification");
			
			
			CFOMethod.AdvancedSearchWorkspace( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 104)
		void CaseHearing() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Hearing Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOMethod.CaseHearing( test,"Performer","Case Hearing-");
			
			extent.endTest(test);
			extent.flush();
		}
	
	
@Test(priority = 105)
	void WorkspaceCaseHearingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace = Case Hearing = Search box  Filter verification");
		
		
		CFOMethod.WorkspaceCaseHearingFilter( test,"A/Bita Pharma Company");
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 0)
		void HearingCalender() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Hearing Calender verification");
		
			
			CFOMethod.HearingCalender( test,"Performer","Cfo");
			
			extent.endTest(test);
			extent.flush();
		}*/

		

@Test(priority = 2)
	void CaseNoticeTypeGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Notice Filter  = Case Notice Type Graph Count Verification");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	js.executeScript("window.scrollBy(0,900)");
	 	
	 	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();
	  
	   	 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 
		 Thread.sleep(5000);
		int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPlaintiff().getText());	//Reading Notice Open count.
		int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendantNotice().getText());	//Reading Notice Open count.
		int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerNotice().getText());	//Reading Notice Open count.
		int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentNotice().getText());	//Reading Notice Open count.
		int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantNotice().getText());	//Reading Notice Open count.
		int	Complainanat = Integer.parseInt(performerPOM.CaseNoticeTypeComplainantNotice().getText());	//Reading Notice Open count.
		int	Defendant = Integer.parseInt(performerPOM.CaseNoticeTypeDefendantNotice().getText());	//Reading Notice Open count.
		int	Plaintiff = Integer.parseInt(performerPOM.CaseNoticeTypePlaintiffNotice().getText());	//Reading Notice Open count.
		
		
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Outward/Plaintiff Type",OutwardPlaintiff);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Inward/Defendent Type",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Petitioner Type",Petitioner);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Respondent Type",Respondent);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Applicant Type",Applicant);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Complianant Type",Complainanat);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Defendant Type",Defendant);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph( test,"Plaintiff Type",Plaintiff);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 3)
		void CaseNoticeTypeFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Notice type summary graph Filter Verification");
			
			
			Thread.sleep(3000);
			CFOMethod.CaseNoticeTypeFilter( test,"CaseNoticeTypeSummaryGraph");
			extent.endTest(test);
			extent.flush();
		}
		
@Test(priority = 4)
			void CaseNoticeStageGraph() throws InterruptedException, IOException
			{
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,900)");
				
				Thread.sleep(5000);
				performerPOM.clickDashboardCaseNoticeFilter().click();
			
				Thread.sleep(5000);
				performerPOM.clickDashboardNoticeFilter().click();
		  
		   	
				Thread.sleep(5000);
				performerPOM.clickDashboardApplyBtn().click();
				
				

				 String StageName =performerPOM.StageName().getText();
	    		 test = extent.startTest("Select Notice Filter ="+StageName+"stage - Case Notice Stage Graph Count Verification");
				
				CFOMethod.CaseNoticeStageGraph( test,"cfo -");
				
				extent.endTest(test);
				extent.flush();
			}
			
///@Test(priority = 5)
			void CaseNoticeStageFilter() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Notice stage summary graph Filter Verification");
				
				
				Thread.sleep(3000);
				CFOMethod.CaseNoticeTypeFilter( test,"CaseNoticeStageHearingGraph");
				
				extent.endTest(test);
				extent.flush();
			}
	        

@Test(priority =4)
		void RiskSummaryGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Select Notice Filter = Risk Graph Count Verification");
			
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
          
           	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			 Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,950)");
			

         	Thread.sleep(2000);
		    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh().getText());	//Reading Notice Open count.
	    	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium().getText());	//Reading Notice Open count.
	    	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow().getText());	//Reading Notice Open count.
	    	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable().getText());	//Reading Notice Open count.
	    	
			
	    	Thread.sleep(3000);
			CFOMethod.RiskSummaryGraph( test,"High Risk",HighRisk);
			Thread.sleep(3000);
			CFOMethod.RiskSummaryGraph( test,"Medium Risk",MediumRisk);
			Thread.sleep(3000);
			CFOMethod.RiskSummaryGraph( test,"Low Risk",LowRisk);
			Thread.sleep(3000);
			CFOMethod.RiskSummaryGraph( test,"Not Applicable Risk",NotApplicableRisk);
			
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
		
			extent.endTest(test);
			extent.flush();
		}
//@Test(priority =5)
		void RiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk summary graph Filter Verification");
			
			
			Thread.sleep(3000);
			CFOMethod.CaseNoticeTypeFilter( test,"RiskSummaryHigh");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 6)
        void DepartmentSummaryGraph() throws InterruptedException, IOException
        {
        	JavascriptExecutor js = (JavascriptExecutor) getDriver();
    		js.executeScript("window.scrollBy(0,800)");
        
    		Thread.sleep(5000);
    		performerPOM.clickDashboardCaseNoticeFilter().click();
    	
    		Thread.sleep(5000);
    		performerPOM.clickDashboardNoticeFilter().click();
      
       	
    		Thread.sleep(5000);
    		performerPOM.clickDashboardApplyBtn().click();
     	
    		 js.executeScript("window.scrollBy(0,950)");
    	
    		 String DeptName =performerPOM.DepartName().getText();
    		 test = extent.startTest("Select Notice Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
    		
	      
	       Thread.sleep(3000);
	       CFOMethod.DepartmentSummaryGraph( test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
//@Test(priority = 7)
		void DeptSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Department summary graph Filter Verification");
			
			
			Thread.sleep(3000);
			CFOMethod.CaseNoticeTypeFilter( test,"DepartmentSummaryGraph");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 8)
        void LocationSummaryGraph() throws InterruptedException, IOException
        {
        	
        	
        	JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,800)");
			
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
          
           	
		   Thread.sleep(5000);
		   performerPOM.clickDashboardApplyBtn().click();
		   
		   js.executeScript("window.scrollBy(0,1400)");
        	
        	  String LocationName =performerPOM.LocationName().getText();
      		test = extent.startTest("Select Notice Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
      		
	      
	       Thread.sleep(3000);
	       CFOMethod.LocationSummaryGraph( test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
//@Test(priority =9)
		void LocationSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Location summary graph Filter Verification");
			
			
			Thread.sleep(3000);
			CFOMethod.CaseNoticeTypeFilter( test,"LocationSummaryGraph");
			
			extent.endTest(test);
			extent.flush();
		}
       
@Test(priority = 10)
        void CategorySummaryGraph() throws InterruptedException, IOException
        {
        	JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,800)");
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
          
           	
			Thread.sleep(5000);
			performerPOM.clickDashboardApplyBtn().click();
			
		   	js.executeScript("window.scrollBy(0,1700)");
        	
        	
        	
        	Thread.sleep(2000);
      		String CategoryName =performerPOM.CategoryName().getText();
        	test = extent.startTest("Select Notice Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
	      
	       Thread.sleep(3000);
	       CFOMethod.CategorySummaryGraph( test,"cfo -");
	
	       extent.endTest(test);
	       extent.flush();
        }
        
    
//@Test(priority =11)
		void CategorySummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Category summary graph Filter Verification");
			
			
			Thread.sleep(3000);
			CFOMethod.CaseNoticeTypeFilter( test,"CategorySummaryGraph");
			
			extent.endTest(test);
			extent.flush();
		}
       



		@Test(priority =11)
void InwardDefendantAgeingGraph() throws InterruptedException, IOException
{
     test = extent.startTest("Select Notice Filter =Less than a year  = Ageing Graph Count Verification");
     
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
   
    	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			 Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,3700)");
			Thread.sleep(3000);
		    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA().getText());	//Reading Notice Open count.
	    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeAgeing().getText());	//Reading Notice Open count.
	    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA().getText());	//Reading Notice Open count.
	    	int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA().getText());	//Reading Notice Open count.
	    	int	Defendant = Integer.parseInt(performerPOM.clickDefendantNoticeCA().getText());	//Reading Notice Open count.
			
	    	Thread.sleep(3000);
	    	CFOMethod.InwardDefendantAgeingGraph( test,"Inward/Defendent",InwardDefendent);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph( test,"Outward/Plaintiff",OutwardPlaintiff);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph( test,"Petitioner",Petitioner);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph( test,"Respondent",Respondent);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph( test,"Defendant",Defendant);
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
}

    
 //@Test(priority = 13)
   void AgeingGraphFilter() throws InterruptedException, IOException
	{
	 test = extent.startTest("Less than a year  = Ageing Graph filter Verification");
     
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
     	js.executeScript("window.scrollBy(0,800)");
     	
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3700)");
		
		
	 	Thread.sleep(3000);
	 	CFOMethod.AgeingGraphFilter( test,"Inward/Defendent");
	 	Thread.sleep(3000);
	 	CFOMethod.AgeingGraphFilter( test,"Complainant");
		//Thread.sleep(3000);
	 	//CFOMethod.AgeingGraphFilter( test,"Applicant");
		Thread.sleep(3000);
		CFOMethod.AgeingGraphFilter( test,"Outward/Plaintiff");
		Thread.sleep(3000);
		CFOMethod.AgeingGraphFilter( test,"Petitioner");
		Thread.sleep(3000);
		CFOMethod.AgeingGraphFilter( test,"Respondent");
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
		extent.endTest(test);
		extent.flush();

	}
    
 @Test(priority = 116)
 void AgeingGraph1to2years() throws InterruptedException, IOException
 {
    		test = extent.startTest("Select Notice Filter =1 to 2 years = Ageing Graph Count Verification");
    
    		JavascriptExecutor js = (JavascriptExecutor) getDriver();
         	js.executeScript("window.scrollBy(0,800)");
  		Thread.sleep(5000);
  		performerPOM.clickDashboardCaseNoticeFilter().click();
 	
 		Thread.sleep(5000);
 		performerPOM.clickDashboardNoticeFilter().click();

 	
 		Thread.sleep(5000);
 		performerPOM.clickDashboardApplyBtn().click();
    
 		js.executeScript("window.scrollBy(0,3700)");
 		Thread.sleep(5000);
 		int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA1To2Years().getText());	//Reading Notice Open count.
 		int Complainant = Integer.parseInt(performerPOM.clickComplianantNoticeCA1To2Years().getText());	//Reading Notice Open count.
 	    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA1to2().getText());	//Reading Notice Open count.
 	    int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA1To2Years().getText());	//Reading Notice Open count.
 	    int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA1To2Years().getText());	//Reading Notice Open count.
 	    int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA1To2Years().getText());	//Reading Notice Open count.
   	
 	    
 	    
 	    Thread.sleep(3000);
 	   CFOMethod.AgeingGraph1to2years( test,"Applicant",Applicant);
   		Thread.sleep(3000);
   		CFOMethod.AgeingGraph1to2years( test,"Complainant",Complainant);
   		Thread.sleep(3000);
   		CFOMethod.AgeingGraph1to2years( test,"Inward/Defendent",InwardDefendent);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph1to2years( test,"Outward/Plaintiff",OutwardPlaintiff);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph1to2years( test,"Petitioner",Petitioner);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph1to2years( test,"Respondent",Respondent);
 		
 		Thread.sleep(3000);
 		OverduePOM.clickDashboard().click();
   
 		extent.endTest(test);
 		extent.flush();
 }

//@Test(priority = 23)
    void AgeingGraph1TO2YearrFilter() throws InterruptedException, IOException
 	{
 	   test = extent.startTest(" 1 to 2 year Ageing graph = Multiple filter Verification");
       JavascriptExecutor js = (JavascriptExecutor) getDriver();
      	js.executeScript("window.scrollBy(0,800)");
      	
 		 Thread.sleep(3000);
 		js.executeScript("window.scrollBy(0,3700)");
 		
 		
 	 	//Thread.sleep(3000);
 	 	//CFOMethod.AgeingGraph1to2Filter( test,"Complianant");
 	 	Thread.sleep(3000);
 	 	CFOMethod.AgeingGraph1to2Filter( test,"Inward/Defendent");
 		Thread.sleep(3000);
 	 	CFOMethod.AgeingGraph1to2Filter( test,"Outward/Plaintiff");
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph1to2Filter( test,"Respondent");
 		
 		
 		
 		Thread.sleep(3000);
 		OverduePOM.clickDashboard().click();
     
 		extent.endTest(test);
 		extent.flush();

 	}

@Test(priority =118)
void AgeingGraph2to3years() throws InterruptedException, IOException
{
  	test = extent.startTest("Select Notice Filter =2 to 3 years = Ageing Graph Count Verification");
 
   	JavascriptExecutor js = (JavascriptExecutor) getDriver();
 		js.executeScript("window.scrollBy(0,800)");
 	
 		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		 js.executeScript("window.scrollBy(0,4000)");
		 Thread.sleep(5000);
	   
		 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Applicant = Integer.parseInt(performerPOM.clickApplicantNoticeCA2to3().getText());	//Reading Notice Open count.
		 int OutwardPlainftiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerNoticeCA2to3().getText());	//Reading Notice Open count.
		 int Plaintiff = Integer.parseInt(performerPOM.clickPlaintiffNoticeCA2to3().getText());	//Reading Notice Open count.
		 
	    Thread.sleep(3000);
	    CFOMethod.AgeingGraph2to3years( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3years( test,"Applicant",Applicant);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph2to3years( test,"OutwardPlainftiff",OutwardPlainftiff);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph2to3years( test,"Petitioner",Petitioner);
 		Thread.sleep(3000);
 		CFOMethod.AgeingGraph2to3years( test,"Plaintiff",Plaintiff);
	
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();

		extent.endTest(test);
		extent.flush();
}	

//@Test(priority =25)
	void TwoToThreeYearAgeingGraphFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("2 to 3 Year Ageing graph Filter Verification");
		
		
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeFilter( test,"2to3YearAgeingGraph");
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 120)
void AgeingGraphMorethan3years() throws InterruptedException, IOException
 {
     test = extent.startTest("Select Notice Filter =More than 3 years = Ageing Graph Count Verification");
  
     	JavascriptExecutor js = (JavascriptExecutor) getDriver();
  		js.executeScript("window.scrollBy(0,800)");
  	
  		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardNoticeFilter().click();

 	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,3800)");
		 Thread.sleep(3000);
		 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentMorethan3years().getText());	//Reading Notice Open count.
		 int Complainant = Integer.parseInt(performerPOM.clickComplainantMorethan3years().getText());	//Reading Notice Open count.
		 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffMorethan3years().getText());	//Reading Notice Open count.
		 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerMorethan3years().getText());	//Reading Notice Open count.
		 int Respondent = Integer.parseInt(performerPOM.clickRespondentMorethan3years().getText());	//Reading Notice Open count.
		 
		 Thread.sleep(3000);
		 CFOMethod.AgeingGraphMorethan3years( test,"Inward/Defendent",InwardDefendent);
		 CFOMethod.AgeingGraphMorethan3years( test,"Complainant",Complainant);
		 CFOMethod.AgeingGraphMorethan3years( test,"Outward/Plaintiff",OutwardPlaintiff);
		 CFOMethod.AgeingGraphMorethan3years( test,"Petitioner",Petitioner);
		 CFOMethod.AgeingGraphMorethan3years( test,"Respondent",Respondent);
		 
		  Thread.sleep(3000);
		 OverduePOM.clickDashboard().click();
 
		 extent.endTest(test);
		 extent.flush();
}	
  
 
@Test(priority =26)
void CaseNoticeTypeGraph1() throws InterruptedException, IOException
{
	test = extent.startTest("Select Case Filter  = Case Notice Type Graph Count Verification");
	
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("window.scrollBy(0,850)");

    Thread.sleep(5000);
	performerPOM.clickDashboardCaseNoticeFilter().click();
	
	Thread.sleep(5000);
	performerPOM.clickDashboardCaseFilter().click();

	
	 Thread.sleep(5000);
	 performerPOM.clickDashboardApplyBtn().click();
	 Thread.sleep(5000);
	
	int	InwardDefendent = Integer.parseInt(performerPOM.CaseNoticeTypeInwardDefendentCase().getText());	//Reading Notice Open count.
	int	Applicant = Integer.parseInt(performerPOM.CaseNoticeTypeApplicantCase().getText());	//Reading Notice Open count.
	int	Appellant = Integer.parseInt(performerPOM.CaseNoticeTypeAppleantCase().getText());	//Reading Notice Open count.
	int	Complianant = Integer.parseInt(performerPOM.CaseNoticeTypeComplianantCase().getText());	//Reading Notice Open count.
	int	Petitioner = Integer.parseInt(performerPOM.CaseNoticeTypePetitionerCase().getText());	//Reading Notice Open count.
	int	OutwardPlaintiff = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPalintiffCaseGraph().getText());	//Reading Notice Open count.
	int	Respondent = Integer.parseInt(performerPOM.CaseNoticeTypeRespondentCase().getText());	//Reading Notice Open count.

	
    Thread.sleep(3000);
    CFOMethod.CaseNoticeTypeGraph1( test,"Inward/Defendent Type",InwardDefendent);
    Thread.sleep(3000);
    CFOMethod.CaseNoticeTypeGraph1( test,"Applicant",Applicant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Appellant",Appellant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Complianant",Complianant);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Outward/Plaintiff Type",OutwardPlaintiff);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Respondent",Respondent);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Petitioner",Petitioner);
	Thread.sleep(3000);
	CFOMethod.CaseNoticeTypeGraph1( test,"Respondent",Respondent);
	
	
	Thread.sleep(3000);
	OverduePOM.clickDashboard().click();
	
	extent.endTest(test);
	extent.flush();
}
   
@Test(priority = 27)
   void CaseNoticeStageGraph1() throws InterruptedException, IOException
   { 
	   JavascriptExecutor js = (JavascriptExecutor) getDriver();
	   js.executeScript("window.scrollBy(0,800)");
  	
	   Thread.sleep(5000);
	   performerPOM.clickDashboardCaseNoticeFilter().click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardCaseFilter().click();
	
	   Thread.sleep(3000);
	   performerPOM.clickDashboardApplyBtn().click();
	
	   js.executeScript("window.scrollBy(0,500)");
	
	   Thread.sleep(3000);
	   String StageName =performerPOM.CaseStageName().getText();
		test = extent.startTest("Select Case Filter = "+StageName+" Stage = Case Notice Stage Graph Count Verification");
 	
		Thread.sleep(3000);
		CFOMethod.CaseNoticeStageGraph1( test,"cfo -");
 	
		extent.endTest(test);
		extent.flush();
   }
    
@Test(priority = 28)
	void RiskSummaryGraph1() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Case Filter = Risk Graph Count Verification");
        
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
      
       	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,950)");
		
	    int	HighRisk = Integer.parseInt(performerPOM.RiskSummaryHigh().getText());	//Reading Notice Open count.
    	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium().getText());	//Reading Notice Open count.
    	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLow().getText());	//Reading Notice Open count.
    	//int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable().getText());	//Reading Notice Open count.
    	
		
    	Thread.sleep(3000);
		CFOMethod.RiskSummaryGraph1( test,"High Risk",HighRisk);
		Thread.sleep(3000);
		CFOMethod.RiskSummaryGraph1( test,"Medium Risk",MediumRisk);
		Thread.sleep(3000);
		CFOMethod.RiskSummaryGraph1( test,"Low Risk",LowRisk);
		//Thread.sleep(3000);
		//CFOMethod.RiskSummaryGraph1( test,"Not Applicable Risk",NotApplicableRisk);
	
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
    
@Test(priority = 29)
    void DepartmentSummaryGraph1() throws InterruptedException, IOException
    {
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)");
    
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
	
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
  
   	
		Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
 	
		 js.executeScript("window.scrollBy(0,950)");
	
		 String DeptName =performerPOM.DepartName().getText();
		 test = extent.startTest("Select Case Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.DepartmentSummaryGraph1( test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
    
@Test(priority = 30)
    void LocationSummaryGraph1() throws InterruptedException, IOException
    {
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)");
		
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
      
       	
	   Thread.sleep(5000);
	   performerPOM.clickDashboardApplyBtn().click();
	   
	   js.executeScript("window.scrollBy(0,1300)");
    	
    	  String LocationName =performerPOM.LocationName().getText();
  		test = extent.startTest("Select Case Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
  		
      
       Thread.sleep(3000);
       CFOMethod.LocationSummaryGraph1( test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
    
    
@Test(priority = 31)
    void CategorySummaryGraph1() throws InterruptedException, IOException
    {
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
      
       	
		Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
		
	   	js.executeScript("window.scrollBy(0,1700)");
    	
    	
    	
    	Thread.sleep(2000);
  		String CategoryName =performerPOM.CategoryName().getText();
    	test = extent.startTest("Select Case Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.CategorySummaryGraph1( test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
@Test(priority =32)
    void ExpensesCaseGraph() throws InterruptedException, IOException
    {
       test = extent.startTest("Select Case Filter = Expenses Case-Wise Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.ExpensesCaseGraph( test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
@Test(priority =33)
    void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
    {
       test = extent.startTest("Select Case Filter = Cables Category -Expenses Category Wise Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.ExpensesCategoryWiseCaseGraph( test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
@Test(priority =34)
 void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
 {
    test = extent.startTest("Select Case Filter -Expenses Counsel Wise Graph Count Verification");
   
    Thread.sleep(3000);
    CFOMethod.ExpensesCounselWiseCaseGraph( test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }
@Test(priority =35)
 void UtilizedBudgetGraph() throws InterruptedException, IOException
 {
    test = extent.startTest("Select Case Filter -Utilized budget Graph Count Verification");
   
    Thread.sleep(3000);
    CFOMethod.UtilizedBudgetGraph( test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }

@Test(priority =36)
void AgeingGraph() throws InterruptedException, IOException
{
     test = extent.startTest("Select Case Filter =Less than a year  = Ageing Graph Count Verification");
     
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
   
    	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			 Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,3700)");
			 Thread.sleep(3000);
			 
			 int Applicant = Integer.parseInt(performerPOM.clickApplicantLessThanYearCase().getText());	//Reading Notice Open count.
			 int Complainant = Integer.parseInt(performerPOM.clickComplainantLessThanYearCase().getText());	//Reading Notice Open count.
			 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentLessThanYearCase().getText());	//Reading Notice Open count.
			 int Appellant = Integer.parseInt(performerPOM.clickAppellantLessThanYearCase().getText());	//Reading Notice Open count.
			 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffLessthanyearCase().getText());	//Reading Notice Open count.
	    	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerLeassThanYearCase().getText());	//Reading Notice Open count.
	    	 int Respondent = Integer.parseInt(performerPOM.clickRespondentLessThanYearCase().getText());	//Reading Notice Open count.
	    	
			
	    	 
	    	 Thread.sleep(3000);
	    	 CFOMethod.AgeingGraphLessThanYear( test,"Applicant",Applicant);
		    Thread.sleep(3000);
		    CFOMethod.AgeingGraphLessThanYear( test,"Complainant",Complainant);
	    	Thread.sleep(3000);
	    	CFOMethod.AgeingGraphLessThanYear( test,"Inward/Defendent",InwardDefendent);
	    	Thread.sleep(3000);
	    	CFOMethod.AgeingGraphLessThanYear( test,"Appellant",Appellant);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear( test,"Outward/Plaintiff",OutwardPlaintiff);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear( test,"Petitioner",Petitioner);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphLessThanYear( test,"Respondent",Respondent);
			
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
    
			extent.endTest(test);
			extent.flush();
}





@Test(priority =135)
void AgeingGraph1to2yearsCase() throws InterruptedException, IOException
{
     	test = extent.startTest("Select Case Filter =1 to 2 years = Ageing Graph Count Verification");
     
     	JavascriptExecutor js = (JavascriptExecutor) getDriver();
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
		
		Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		 js.executeScript("window.scrollBy(0,3700)");
		 Thread.sleep(3000);
	    int	Complianant = Integer.parseInt(performerPOM.clickComplianant1to2yearCase().getText());	//Reading Notice Open count.
    	int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardOutward1to2yearsCase().getText());	//Reading Notice Open count.
    	int	Appleant = Integer.parseInt(performerPOM.clickAppleant1to2YearCase().getText());	//Reading Notice Open count.
    	int	Outwardplaintiff = Integer.parseInt(performerPOM.clickOutwardplaintiff1toyearCase().getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitioner1toyearCase().getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent1toyearCase().getText());	//Reading Notice Open count.
    	
    	Thread.sleep(3000);
    	CFOMethod.AgeingGraph1to2yearsCase( test,"Complianant",Complianant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase( test,"Appleant",Appleant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase( test,"Outward/plaintiff",Outwardplaintiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase( test,"Petitioner",Petitioner);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph1to2yearsCase( test,"Respondent",Respondent);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
 }

@Test(priority =137)
void AgeingGraph2to3yearsCase() throws InterruptedException, IOException
{
     test = extent.startTest("Select Case Filter =2 to 3 years = Ageing Graph Count Verification");
     
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		
		js.executeScript("window.scrollBy(0,3850)");
		 Thread.sleep(3000);
	    int	Applicant = Integer.parseInt(performerPOM.clickApplicant2to3yearCase().getText());	//Reading Notice Open count.
    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiff2To3YearCase().getText());	//Reading Notice Open count.
    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent2To3YearCase().getText());	//Reading Notice Open count.
    
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase( test,"Applicant",Applicant);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase( test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraph2to3yearsCase( test,"Respondent",Respondent);
		
		
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
 }

@Test(priority =139)
void AgeingGraphMoreThan3yearsCase() throws InterruptedException, IOException
{
     test = extent.startTest("Select Case Filter =More than 3 years = Ageing Graph Count Verification");
     
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
     	js.executeScript("window.scrollBy(0,800)");
     	
     	Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter().click();
   
    	
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn().click();
		 Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3800)");
		
	    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentCAMoreThan3yearsCase().getText());	//Reading Notice Open count.
    	int	OutwardPlaintiff = Integer.parseInt(performerPOM.clickAppleantCaseCAMoreThan3years().getText());	//Reading Notice Open count.
    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerCaseCAMoreThan3years().getText());	//Reading Notice Open count.

		
    	Thread.sleep(3000);
    	CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Inward/Defendent",InwardDefendent);
		Thread.sleep(3000);
		CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Outward/Plaintiff",OutwardPlaintiff);
		Thread.sleep(3000);
		CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Petitioner",Petitioner);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
    
      extent.endTest(test);
      extent.flush();
 }

        
  

  

@Test(priority = 129)
			void MyDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Download and View Document");
			
				
				CFOMethod.MyDocument( test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
		
@Test(priority = 130)
	void ShareCaseDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Share Case Document Verification");
	
		
		CFOMethod.ShareCaseDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 131)
	void ShareNoticeDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Share Notice Document Verification");
	
		
		CFOMethod.ShareNoticeDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =132)
	void ShareTaskDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Share Task Document Verification");
	
		
		CFOMethod.ShareTaskDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 133)
void AdvancedSearchDoc() throws InterruptedException, IOException
{
	test = extent.startTest("My Document(Advanced search) -Download and View Document");
	
	
	CFOMethod.AdvancedSearchDocument( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 134)
void AdvancedSearchShareCaseDocument() throws InterruptedException, IOException
{
test = extent.startTest("My Document-Advance search-Share Case Document Verification");


CFOMethod.AdvancedSearchShareCaseDocument( test);

extent.endTest(test);
extent.flush();
}
@Test(priority =135)
	void AdvancedSearchShareNoticeDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advance search-Share Notice Document Verification");
	
		
		CFOMethod.AdvancedSearchShareNoticeDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =136)
	void AdvancedSearchShareTaskDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advance search-Share Task Document Verification");
	
		
		CFOMethod.AdvancedSearchShareTaskDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 137) 		//Sever is blocking and not allowing to upload the file.
void CriticalDocuments() throws InterruptedException, IOException
{
	test = extent.startTest(" Critical Document Verification");
	
	CFOMethod.CriticalDocuments( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 138) 		//Sever is blocking and not allowing to upload the file.
void CriticalDocuments1() throws InterruptedException, IOException
{
	test = extent.startTest(" Critical Document Verification");
	
	CFOMethod.CriticalDocuments1( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 139)
void DocumentFilter() throws InterruptedException, IOException
{
	test = extent.startTest(" My Document = Notice = Multiple  Filters verification");

	
	CFOMethod.DocumentNoticeFilter( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 140)
void DocumentCaseFilter() throws InterruptedException, IOException
{
test = extent.startTest(" My Document = Case = Multiple  Filters verification");


CFOMethod.DocumentCaseFilter( test);

extent.endTest(test);
extent.flush();
}
@Test(priority = 141)
void DocumentTaskFilter() throws InterruptedException, IOException
{
test = extent.startTest(" My Document = Task = Multiple  Filters verification");


CFOMethod.DocumentTaskFilter( test);

extent.endTest(test);
extent.flush();
}

@Test(priority = 142)
				void MyReports() throws InterruptedException, IOException
				{
					test = extent.startTest("Reports -excel count verification");
					
					CFOMethod.MyReports( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	        
	@Test(priority = 143)
				void MoreReports() throws InterruptedException, IOException
				{
					test = extent.startTest("More Report-Reports excel  verification");
					
					
					CFOMethod.MoreReport( test);
					
					extent.endTest(test);
					extent.flush();
				}

	@Test(priority = 144)
		void AdvancedSearchreport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report- Advanced search verification");
		
			
			CFOMethod.AdvancedSearchReport( test);
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority =145)
		void ReportNoticeFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report = Notice =  Filters verification");
			
			
			CFOMethod.ReportNoticeFilter( test);
			
			extent.endTest(test);
			extent.flush();
		}

@Test(priority = 146)
	void ReportCaseFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report = Case =  Filters verification");
		
		
		CFOMethod.ReportCaseFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =147)
	void ReportTaskFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report = Task =  Filters verification");
		
		
		CFOMethod.ReportTaskFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}

			
				
@Test(priority =148)
				void MyReminder() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reminder verification");
					
					CFOMethod.MyReminder( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority =149)
	void ReminderWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder Without data verification");
		
		CFOMethod.ReminderWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
				
	 @Test(priority = 150)
				void ImportUtility() throws InterruptedException, IOException
				{
					test = extent.startTest("Import Utility verification");
					
					
					CFOMethod.ImportUtility(test);
					extent.endTest(test);
					extent.flush();
				}
	 @Test(priority = 151)
		void ImportUtilityWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Upload Empty File Import Utility verification");
			
			
			CFOMethod.ImportUtilityWithoutData(test);
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 152)
		void ImportUtilityInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Enter Invalid data in Upload File Import Utility verification");
			
			
			CFOMethod.ImportUtilityInvalidData(test);
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 153)
		void ImportUtilityTwoManadtoryFileds() throws InterruptedException, IOException
		{
			test = extent.startTest("Enter Two Manadtory fields in Upload File Import Utility verification");
			
			
			CFOMethod.ImportUtilityTwoManadtoryFileds(test);
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 154)
	void CaseUpdationImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation Import Utility verification");
		
		
		CFOMethod.CaseUpdationImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 155)
	void CaseUpdationUploadEmtyFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Empty File Import Utility verification");
		
		
		CFOMethod.CaseUpdationUploadEmtyFile(test);
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 156)
	void CaseUpdationUploadInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid Data Import Utility verification");
		
		
		CFOMethod.CaseUpdationUploadInvalidData(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 157)
	void CaseUpdationUploadInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid File Import Utility verification");
		
		
		CFOMethod.CaseUpdationUploadInvalidFile(test);
		extent.endTest(test);
		extent.flush();
	}
 
@Test(priority = 158)
	void NoticeUpdation() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation Import Utility verification");
		
		
		CFOMethod.NoticeUpdation(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 159)
void NoticeUpdationUploadEmtyFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation-Empty File Import Utility verification");
	
	
	CFOMethod.NoticeUpdationUploadEmtyFile(test);
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 160)
void NoticeUpdationUploadInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid Data Import Utility verification");
	
	
	CFOMethod.NoticeUpdationUploadInvalidData(test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 161)
void NoticeUpdationUploadInvalidFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid File Import Utility verification");
	
	
	CFOMethod.NoticeUpdationUploadInvalidFile(test);
	extent.endTest(test);
	extent.flush();
}


	
	
		/*@Test(priority = 149)
			void Masters() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Legal Entity  verification");
					
					CFOMethod.LegalEntity( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority = 150)
		void MastersLegalEntity() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Legal Entity Without data verification");
				
				CFOMethod.LegalEntityWithoutData( test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority =151)
		void MastersLegalEntity1() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Legal Entity Invalid data verification");
				
				CFOMethod.LegalEntityInvalidData( test);
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority =152)
		void MastersLegalEntity2() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Legal Entity Two Manadatory Fields verification");
				
				CFOMethod.LegalEntityTwoManadatoryFields( test);
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority =153)
				void MastersLegalEntity3() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Legal Entity Close Button verification");
						
						CFOMethod.LegalEntityCloseButton( test);
						
						extent.endTest(test);
						extent.flush();
					}
		@Test(priority =154)
		void UnitEntity() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Add Unit Entity verification");
				
				CFOMethod.AddUnitType( test);
				
				extent.endTest(test);
				extent.flush();
			}
	//@Test(priority = 155)
				void Masters1() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Law Firm verification");
					
					
					CFOMethod.LawFirm( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority =156)
	void MastersLawFirm() throws InterruptedException, IOException
	{
		test = extent.startTest("Law Firm Masters - Enter Without Data verification");
		
		
		CFOMethod.LawFirmWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =157)
	void MastersLawFirm1() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Law Firm Invalid Data verification");
		
		
		CFOMethod.LawFirmInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =158)
	void MastersLawFirm2() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Law Firm Two Manadtory fields verification");
		
		
		CFOMethod.LawFirmTwoManadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =159)
	void MastersLawFirm3() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Law Firm Close button verification");
		
		
		CFOMethod.LawFirmCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 160)
	void LawyerWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Lawyer  - Enter Without Data verification");
		
		
		CFOMethod.LawyerWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =161)
	void LawyerInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Lawyer  - Enter Invalid Data verification");
		
		
		CFOMethod.LawyerInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 162)
	void LawyerTwoManadatoryFileds() throws InterruptedException, IOException
	{
		test = extent.startTest("Lawyer  - Enter Two Manadatory fields verification");
		
		
		CFOMethod.LawyerTwoManadatoryFileds( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 163)
	void LawyerCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Lawyer  - Enter close button verification");
		
		
		CFOMethod.LawyerCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority = 164)
				void Masters2() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - 	User  verification");
					
					
					CFOMethod.User( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
@Test(priority = 165)
	void UserWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master-  without data verification");
		
		
		CFOMethod.UserWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 166)
	void UserInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master-  Invalid data verification");
		
		
		CFOMethod.UserInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =167)
	void UserTwoManadatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master- Two manadatory fields verification");
		
		
		CFOMethod.UserTwoManadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =168)
	void UserCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("User Master- Close Button  verification");
		
		
		CFOMethod.UserCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 169)
				void Masters3() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Opponent  verification");
					
					
					CFOMethod.Opponent( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	

	@Test(priority =170)
				void OpponentWithoutData() throws InterruptedException, IOException
				{
					test = extent.startTest("Opponent Masters -Without Data verification");
					
					
					CFOMethod.OpponentWithoutData( test);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority =171)
	void OpponentInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Opponent Masters -Invalid Data verification");
		
		
		CFOMethod.OpponentInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 172)
	void OpponentCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Opponent Masters -Close button verification");
		
		
		CFOMethod.OpponentCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
				
//	@Test(priority = 173)
				void Masters4() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Court  verification");
					
					
					CFOMethod.Court( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 174)
	void CourtWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Without enter Data verification");
		
		
		CFOMethod.CourtWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 175)
	void CourtInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Enter Invalid Data verification");
		
		
		CFOMethod.CourtInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 176)
	void CourtTwomanadatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Enter Two Manadtory Fields verification");
		
		
		CFOMethod.CourtTwomanadatoryFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =177)
	void CourtCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Court Master- Close button verification");
		
		
		CFOMethod.CourtCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 178)
				void Masters5() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Case/NoticeType  verification");
					
					
					CFOMethod.CaseNoticeType( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 179)
	void CaseNoticeTypeWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master -Without Enter Data  verification");
		
		
		CFOMethod.CaseNoticeTypeWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 180)
	void CaseNoticeTypeInvaliData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master - Enter Invalid Data  verification");
		
		
		CFOMethod.CaseNoticeTypeInvaliData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 181)
	void CaseNoticeTypeCloseBuuton() throws InterruptedException, IOException
	{
		test = extent.startTest("Case/NoticeType Master - Close Button  verification");
		
		
		CFOMethod.CaseNoticeTypeCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
//  @Test(priority = 182)
				void Masters6() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Payment Type  verification");
					
					
					CFOMethod.PaymentType( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
 
 @Test(priority = 183)
          void PaymentTypeWithouData() throws InterruptedException, IOException
         {
	         test = extent.startTest("Payment Type Master- Without Enter Data  verification");
	 
	
	          CFOMethod.PaymentTypeWithoutData( test);
	
	          extent.endTest(test);
	          extent.flush();
         }
    @Test(priority = 184)
    void PaymentTypeInvalidData() throws InterruptedException, IOException
   {
       test = extent.startTest("Payment Type Master-Enter Invalid Data  verification");


        CFOMethod.PaymentTypeInvalidData( test);

        extent.endTest(test);
        extent.flush();
   }
   @Test(priority = 185)
    void PaymentTypeCloseButton() throws InterruptedException, IOException
   {
       test = extent.startTest("Payment Type Master-Close button verification");


        CFOMethod.PaymentTypeCloseButton( test);

        extent.endTest(test);
        extent.flush();
   }

	//@Test(priority =186)
				void Masters7() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Custom Parameter  verification");
				
					
					CFOMethod.customParameter( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 187)
	void customParameterWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Without Enter Data  verification");
	
		
		CFOMethod.customParameterWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority = 188)
	void customParameterInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Enter Invalid Data verification");
	
		
		CFOMethod.customParameterInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 189)
	void customParameterCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Custom Parameter Master -Close  button  verification");
	
		
		CFOMethod.customParameterCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 190)
				void Masters8() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Case Stage  verification");
				
					
					CFOMethod.CaseStage( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
@Test(priority = 191)
	void CaseStageWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Without Enter Data  verification");
	
		
		CFOMethod.CaseStageWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 192)
	void CaseStageInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Enter Invalid Data  verification");
	
		
		CFOMethod.CaseStageInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 193)
	void CaseStageCloseButton() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Stage Masters - Close Button verification");
	
		
		CFOMethod.CaseStageCloseButton( test);
		
		extent.endTest(test);
		extent.flush();
	}
	//	@Test(priority = 194)
				void Masters9() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Document Type  verification");
					
					
					CFOMethod.DocumentType( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
		@Test(priority = 195)
		void DocumentTypeWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Document Type Masters-Without data  verification");
			
			
			CFOMethod.DocumentTypeWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority =196)
		void DocumentTypeInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Document Type Masters-Enter Invalid Data verification");
			
			
			CFOMethod.DocumentTypeInvalidData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 197)
		void DocumentTypeCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Document Type Masters-Close button verification");
			
			
			CFOMethod.DocumentTypeCloseButton( test);
			
			extent.endTest(test);
			extent.flush();
		}
	//	@Test(priority = 198)
				void Masters10() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Rating Criteria  verification");
				
					
					CFOMethod.RatingCriteria( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority = 199)
		void RatingCriteriaWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Rating Criteria Masters-Without Enter Data  verification");
		
			
			CFOMethod.RatingCriteriaWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 200)
		void RatingCriteriaInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Rating Criteria Masters-Enter Invalid Data  verification");
		
			
			CFOMethod.RatingCriteriaInvalidData( test);
			
			extent.endTest(test);
			extent.flush();
		}		
	@Test(priority =201)
		void RatingCriteriaCloseButton() throws InterruptedException, IOException
		{
			test = extent.startTest("Rating Criteria Master-Close button verification");
		
			
			CFOMethod.RatingCriteriaCloseButton( test);
			
			extent.endTest(test);
			extent.flush();
		}		
//	@Test(priority = 202)
				void Masters12() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Notice Stage  verification");
					
					
					CFOMethod.NoticeStage( test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
//		@Test(priority = 203)
				void Masters11() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - UserReassignment  verification");
					
					
					CFOMethod.UserReassignment( test);
					
					extent.endTest(test);
					extent.flush();
				}
//	@Test(priority = 204)
				void Masters13() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - Mail Authorization  verification");
					
					CFOMethod.MailAuthorization(test);
					
					extent.endTest(test);
					extent.flush();
				}

				
				
		//@Test(priority = 74)
				void Draft() throws InterruptedException, IOException
				{
					test = extent.startTest("Draft Count verification");
					//test.log(LogStatus.INFO, "Test Initiated");
					
					CFOMethod.Draft( test);
					
					extent.endTest(test);
					extent.flush();
				}*/
				

			
 
	

			 @AfterMethod
					 
					 void Close()
					 {
						 getDriver().close(); 
					 }

		

		


	
//			@AfterTest()	
//			
//			void chromeclose() throws InterruptedException
//			{
//				Thread.sleep(5000);
//			  driver.close();
//			}

}
