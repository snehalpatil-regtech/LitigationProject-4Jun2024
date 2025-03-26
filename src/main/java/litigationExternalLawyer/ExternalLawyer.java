package litigationExternalLawyer;

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

import litigationCompanyAdmin.MethodsPOM;


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
		
		test.log(LogStatus.PASS, "Test Passed = Verify chrome browser.");
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
	

@Test(priority = 1)
		void NoticeOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice - Open Count Verification");
			
			
			MethodPOM.NoticeOpen(driver, test, workbook, "Performer");
			
			
			extent.endTest(test);
			extent.flush();
		}

@Test(priority =2)
	void NoticeWithExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice With Existing Data verification");
		MethodPOM.NoticeWithExistingData(driver, test,workbook);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =3)
	void NoticeWithInvalidData() throws InterruptedException, IOException
	{
			test = extent.startTest("Notice With Invalid Data verification");


			MethodPOM.NoticeWithInvalidData(driver, test, workbook);

			extent.endTest(test);
			extent.flush();
	}

@Test(priority =4)
	void NoticeWithTwoMandatoryData() throws InterruptedException, IOException
	{
     	test = extent.startTest("Notice With Two Mandatory Fields verification");


     	MethodPOM.NoticeWithTwoMandatoryData(driver, test, workbook);

     	extent.endTest(test);
     	extent.flush();
	}

@Test(priority =5) 
	void NoticeWithEmptyFields() throws InterruptedException, IOException
	{
	     test = extent.startTest("Notice With Empty Fields verification");


	     MethodPOM.NoticeWithEmptyFields(driver, test);

	     extent.endTest(test);
	     extent.flush();
	}

@Test(priority =6)
	void NoticeClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Summary -Clear button verification");


		MethodPOM.NoticeClearBtn(driver, test);

		extent.endTest(test);
		extent.flush();
	}

@Test(priority =7)
void NoticeSendMailWithDoc() throws InterruptedException, IOException
{
	     test = extent.startTest("Notice Summary-Send Mail With Document verification");
	
	
	     MethodPOM.NoticeSendMailWithDoc(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
}

@Test(priority =8)
void NoticeSendMailWithDocInvalidFields() throws InterruptedException, IOException
{
    test = extent.startTest(" Notice Summary -Send Mail With Document Invalid Fields verification");


    MethodPOM.NoticeSendMailWithDocInvalidFields(driver, test);

    extent.endTest(test);
    extent.flush();
}
@Test(priority =9)
	void NoticeSendMailWithDocEmptyFields() throws InterruptedException, IOException
	{
	     test = extent.startTest("Notice Summary -Send Mail With Document Empty Fields verification");
	
	
	     MethodPOM.NoticeSendMailWithDocEmptyFields(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
	}
 
//@Test(priority =10)
 	void NoticeUserAssignment() throws InterruptedException, IOException
	{
	     test = extent.startTest("Notice User Assignment  verification");
	
        MethodPOM.NoticeUserAssignment(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
	}
@Test(priority =11)
	void NoticeDeleteUserAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Delete User Assignment  verification");
	
		MethodPOM.NoticeDeleteUserAssignment(driver, test);

		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 12)
		void CaseOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("Case - Open Count Verification");
			
			
			MethodPOM.CaseOpen(driver, test, workbook, "Performer");
			
			extent.endTest(test);
			extent.flush();
		}

@Test(priority =13)
	void CaseExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Existing Data verification");
	
	
		MethodPOM.CaseExistingData(driver, test, workbook);
	
		extent.endTest(test);
		extent.flush();
	}	

@Test(priority =14)
	void CaseWithInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Invalid Data verification");
	
	
		MethodPOM.CaseWithInvalidData(driver, test, workbook);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =15)
	void CaseWithTwoFieldsData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Two Manadatory fields verification");
	
	
		MethodPOM.CaseWithTwoFieldsData(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =16)
	void CaseWithEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Empty fields verification");
	
	
		MethodPOM.CaseWithEmptyFields(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
	
//@Test(priority =17)
	void CaseUserAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("Case User Assignment verification");
		
		
			MethodPOM.CaseUserAssignment(driver, test);
		
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =18)
		void CaseUserAssignmentDelete() throws InterruptedException, IOException
		{
			test = extent.startTest("Case User Assignment Delete Icon  verification");

			
			MethodPOM.CaseUserAssignmentDelete(driver, test);

			extent.endTest(test);
			extent.flush();
		}
@Test(priority =17)
	void CaseWithClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Summary - Clear button verification");
	
	
		MethodPOM.CaseWithClearBtn(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 18)
		void CloseNotice() throws InterruptedException, IOException
		{
			test = extent.startTest("Close Notice Count Verification");
		
		
			MethodPOM.CloseNoticeCase(driver, test, workbook,"Notice","Lawyer ABCD");
				extent.endTest(test);
			extent.flush();
		}
@Test(priority = 19)
		void CloseCase() throws InterruptedException, IOException
		{
		test = extent.startTest("Close Case Count Verification");
			
			
		MethodPOM.CloseNoticeCase(driver, test, workbook,"Case","Lawyer ABCD");
			
		extent.endTest(test);
			extent.flush();
		}
@Test(priority = 20)
		void LinkNotice() throws InterruptedException, IOException
		{
			test = extent.startTest("Link Notice Verification");
			
			
			MethodPOM.LinkDocument(driver, test, workbook, "Notice");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =21)
	void LinkNoticeViewIcon() throws InterruptedException, IOException
	{
	     test = extent.startTest("Linked notice view icon  verification");
	
	

	 	MethodPOM.LinkNoticeViewIcon(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
	}
@Test(priority=22)
  void LinkNoticeDeleteIcon() throws InterruptedException, IOException
	{
	     test = extent.startTest("Linked notice Delete icon  verification");
	
	

	 	MethodPOM.LinkNoticeDeleteIcon(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
	}
@Test(priority = 23)
void LinkCase() throws InterruptedException, IOException
{
	test = extent.startTest("Link Case Verification");

	
	MethodPOM.LinkDocument(driver, test, workbook, "Case");

	extent.endTest(test);
	extent.flush();
}

@Test(priority =24)
   void LinkCaseViewIcon() throws InterruptedException, IOException
  {
	     test = extent.startTest("Linked case view icon  verification");
	
	
	     MethodPOM.LinkCaseViewIcon(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
 }
@Test(priority =25)
   void LinkCaseDeleteIcon() throws InterruptedException, IOException
  {
	     test = extent.startTest("Linked case delete icon  verification");
	
	
	     MethodPOM.LinkCaseDeleteIcon(driver, test);
	
	     extent.endTest(test);
	     extent.flush();
 }
@Test(priority = 26)
		void NoticeClosed() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice - Closed Count Verification");
	
			
			MethodsPOM.NoticeClosed(driver, test, workbook, "Performer");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 27)
		void CaseClose() throws InterruptedException, IOException
		{
			test = extent.startTest("Case - Closed Count Verification");
	
			
			MethodsPOM.CaseClosed(driver, test, workbook, "Performer");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 28)
		void TaskOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Open Count Verification");
			
			MethodPOM.TaskOpen(driver, test, workbook, "Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 29)
		void TaskwithExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Task With existing data verification");
			
			
			MethodPOM.TaskWithExistingData(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority =30)
	     			void TaskwithTwoManadatoryFields() throws InterruptedException, IOException
	     			{
	     				test = extent.startTest("Task With Two manadatory fields verification");
	     				
	     				
	     				MethodPOM.TaskWithTwoMandatoryFields(driver, test, workbook);
	     				
	     				extent.endTest(test);
	     				extent.flush();
	     			}
	    @Test(priority = 31)
	 			void TaskwithoutData() throws InterruptedException, IOException
	 			{
	 				test = extent.startTest("Task Without  data verification");
	 				
	 				
	 				MethodPOM.TaskwithoutData(driver, test);
	 				
	 				extent.endTest(test);
	 				extent.flush();
	 			}
	 			
	 		 @Test(priority = 32)
	 			void TaskDelete() throws InterruptedException, IOException
	 			{
	 				test = extent.startTest("Task Delete verification");
	 				
	 				
	 				MethodPOM.TaskDelete(driver, test);
	 				
	 				extent.endTest(test);
	 				extent.flush();
	 			}
	 	 @Test(priority =33 )
	 			void TaskwithClearBtn() throws InterruptedException, IOException
	 			{
	 				test = extent.startTest("Task with clear button verification");
	 				
	 				
	 				MethodPOM.TaskwithClearBtn(driver, test);
	 				
	 				extent.endTest(test);
	 				extent.flush();
	 			}

	 		 @Test(priority =36 )
	 		 void TaskShowDetailesClearBtn() throws InterruptedException, IOException
	 		 {
	 			 test = extent.startTest("Individual Task-Show Detailes Icon - clear button verification");
		
		
	 			 MethodPOM.TaskShowDetailesClearBtn(driver, test);
		
	 			 extent.endTest(test);
	 			 extent.flush();
	 		 }
	 		 
		
	@Test(priority = 29)
		void TaskClosed() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Closed Count Verification");
			
			
			MethodPOM.TaskClosed(driver, test, workbook, "Performer");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 30)
		void NoticeDocViewandDownload() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document verification");
			
			
			MethodPOM.NoticeDocViewandDownload(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
  @Test(priority = 31)
	void NoticeDocumentTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document verification");
		
		
		MethodPOM.NoticeDocument(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 32)
	void NoticeWithoutUploadDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Without Upload Document verification");
		
		
		MethodPOM.NoticeWithoutUploadDocument(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 32)
	void NoticeDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Search Fields verification");
		
		
		MethodPOM.NoticeDocumentSearchFields(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 34)
	void NoticeDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share with Invaid data verification");
		
		
		MethodPOM.NoticeDocumentShareInvalidData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =35)
		void NoticeDocumentShareWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share without data verification");
	
			
			MethodPOM.NoticeDocumentShareWithoutData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority = 36)
	void NoticeDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share close button verification");
		
		
		MethodPOM.NoticeDocumentShareCloseBtn(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 37)
void NoticeTaskActivityTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activity verification");
	
	
	MethodPOM.TaskActivtity(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =38)
	void TaskActivtityDeleteResponse() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Delete Response verification");
		
		
		MethodPOM.TaskActivtityDeleteResponse(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

//@Test(priority =39)
	void TaskActivtityExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy with existing data verification");
		
		
		MethodPOM.TaskActivtityExistingData(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =40)
	void TaskActivtityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Without data verification");
		
		
		MethodPOM.TaskActivtityWithoutData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =41)
	void TaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Response Without data verification");
		
		
		MethodPOM.TaskActivtityResponseWithoutStatus(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 42)
	void TaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy  Response clear button verification");
		
		
		MethodPOM.TaskActivtityResponseClearBtn(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 43)
void NoticeResponseTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response tab verification");
	
	
	MethodPOM.Response(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =44)
void ResponseExistingData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Existing Data verification");


	MethodPOM.ResponseExistingData(driver, test,workbook);

	extent.endTest(test);
	extent.flush();
}

@Test(priority =45)
void NoticeResponseWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Without data verification");

	MethodPOM.ResponseWithoutData(driver, test);
    extent.endTest(test);
	extent.flush();
}	

@Test(priority =46)
void ResponseClearBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Clear button verification");
	MethodPOM.ResponseClearBtn(driver, test);
     extent.endTest(test);
     extent.flush();
}



@Test(priority = 47)
void NoticePaymentLogTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice PaymentLog tab verification");
	
	
	MethodsPOM.PaymentLog(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 48)
void PaymentLogwithExistingData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment with existing data verification");
	MethodsPOM.PaymentLogExistingData(driver,test);
   extent.endTest(test);
    extent.flush();
}

@Test(priority = 49)
void PaymentLogwithInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment with Invalid data verification");
	
	
	MethodPOM.PaymentLogwithInvalidData(driver,test);
	
	extent.endTest(test);
	extent.flush();
}



@Test(priority = 49)
void NoticePaymentWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment Without data verification");


	MethodPOM.PaymentLogWithoutData(driver,test,workbook);

	extent.endTest(test);
	extent.flush();
}




@Test(priority = 50)
	void NoticeAuditLogTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice AuditLog tab verification");
	
	
		MethodPOM.AuditLog(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 51)
			void CaseDocumentTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Document verification");
				
				
				MethodsPOM.Document(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}	
	
	@Test(priority = 52)
 	void CaseWithoutUploadDocument() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Document -Without Upload File verification");
 		
 		
 		MethodPOM.CaseWithoutUploadDocument(driver, test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
	
@Test(priority =53)
	void CaseDocumentEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document with empty fields verification");
		
		
		MethodPOM.CaseDocumentEmptyFields(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =54)
	void CaseDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Search Fields verification");
		
		
		MethodPOM.CaseDocumentSearchFields(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =55)
	void CaseDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share with Invaid data verification");
		
		
		MethodPOM.CaseDocumentShareInvalidData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =56)
	void CaseDocumentShareWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share without data verification");
		
		
		MethodPOM.CaseDocumentShareWithoutData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =57)
	void CaseDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share close button verification");
		
		
		MethodPOM.CaseDocumentShareCloseBtn(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
 @Test(priority =58)
    void CaseSendMailWithDoc() throws InterruptedException, IOException
   {
 	     test = extent.startTest("Case Summary-Send Mail With Document verification");
 	
 	    MethodPOM.CaseSendMailWithDoc(driver, test);
 	
 	     extent.endTest(test);
 	     extent.flush();
  }
 @Test(priority =59)
	    void CaseSendMailWithDocInvalidFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Document Invalid Fields verification");
	 	
	 	
	 	    MethodPOM.CaseSendMailWithDocInvalidFields(driver, test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }
@Test(priority =60)
	    void CaseSendMailWithEmptyFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Empty Fields verification");
	 	
	 	
	 	    MethodPOM.CaseSendMailWithEmptyFields(driver, test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }
	
 	 
 @Test(priority = 61)
			void CaseTaskActivityTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Task/Activity verification");
		
				
				MethodPOM.TaskActivity1(driver, test,workbook,"Performer");
				
				extent.endTest(test);
				extent.flush();
			}
 
@Test(priority = 62)
	void CaseTaskActivityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy Without data verification");
		
		
		MethodPOM.CaseTaskActivityWithoutData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 64)
	void CaseTaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy Response Without data verification");
		
		
		MethodPOM.CaseTaskActivtityResponseWithoutStatus(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =65)
	void CaseTaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy  Response clear button verification");
		
		
		MethodPOM.CaseTaskActivtityResponseClearBtn(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
 
	@Test(priority = 66)
			void CaseHearingTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Hearing verification");
			
				
				MethodPOM.CaseHearing(driver, test,workbook);
				
				extent.endTest(test);
				extent.flush();
			}
		
		
	 	
		 @Test(priority= 68)
	 	  void CaseWithoutHearingData() throws InterruptedException, IOException
	 	  {
	 		test = extent.startTest("Case without hearing data Verification");
	 		
	 		
	 		MethodPOM.CaseHearingWithoutData(driver, test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	  }
	 	 
	 @Test(priority =69)
	 	   void CaseHearingInvalidDate() throws InterruptedException, IOException
	 	   {
	 	 	test = extent.startTest("Case Invalid Hearing Date Verification");
	 	 	
	 	 	
	 	 	MethodPOM.CaseHearingInvalidDate(driver, test);
	 	 	
	 	 	extent.endTest(test);
	 	 	extent.flush();
	 	   }
		@Test(priority =70)
	 	   void CaseHearingClearBtn() throws InterruptedException, IOException
	 	   {
	 	 	test = extent.startTest("Case heraing clear button Verification");
	 	 	
	 	 	
	 	 	MethodPOM.CaseHearingClearBtn(driver, test);
	 	 	
	 	 	extent.endTest(test);
	 	 	extent.flush();
	 	   }
		
	@Test(priority = 71)
			void CaseOrderTab() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Order verification");
				
				
				MethodPOM.CaseOrder(driver, test,workbook,"Performer");
				
				extent.endTest(test);
				extent.flush();
			}
		
		@Test(priority =72)
 		void CaseOrderExistingData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("To check validation message displayed  for case order with existing data");

 		
 			MethodPOM.CaseOrderWithExistingData(driver, test,workbook);
 		
 			extent.endTest(test);
 			extent.flush();
 		}
 @Test(priority =73)
		void CaseOrderWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("To check validation message displayed  for case order without data");

		
			MethodPOM.CaseOrderWithoutData(driver, test);
		
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =74)
	void CaseOrderwithClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Order with clear button");

	
		MethodPOM.CaseOrderwithClearBtn(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 75)
	void CaseAdvocateBillTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Case advocate bill verification");
			
		MethodPOM.AdvocateBill(driver, test);
				
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 76)
	void StatusPayment() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment verification");
			
				
		MethodsPOM.StatusPayment(driver, test,workbook);
				
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 77)
 	void StatusPaymentWithExistingData() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Status/Payment with existing data verification");
 	
 		
 		MethodsPOM.StatusPaymentWithExistingData(driver, test,workbook);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority =78)
	void StatusPaymentWithoutdata() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment without data ");
		
		
		MethodsPOM.StatusPaymentWithoutdata(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =79)
void StatusPaymentwithInvaliddata() throws InterruptedException, IOException
{
	test = extent.startTest("Case Status/Payment with Invalid data ");
	
	
	MethodsPOM.StatusPaymentwithInvaliddata(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =79)
	void CaseStatuswithEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status With Empty Fields");
	
	
		MethodsPOM.CaseStatuswithEmptyFields(driver, test);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 80)
			void Auditlog() throws InterruptedException, IOException
			{
				test = extent.startTest("Case Audit Log verification");
	
				
				MethodPOM.Auditlog(driver,test);
				
				extent.endTest(test);
				extent.flush();
			}




			@Test(priority =81)
			void NoticeClosedDoc() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Notice Document verification");
			
			MethodPOM.NoticeClosedDoc(driver, test);
			
			extent.endTest(test);
			extent.flush();
			}
			@Test(priority = 82)
			void NoticeClosedWithoutDoc() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Notice Without Document verification");
			
			MethodPOM.NoticeClosedWithoutDoc(driver, test);
			
			extent.endTest(test);
			extent.flush();
			}
			
			
			@Test(priority = 83)
			void CaseClosedDoc() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Case Document verification");
			
			MethodPOM.CaseClosedDoc(driver, test);
			
			extent.endTest(test);
			extent.flush();
			}
			
			
			@Test(priority = 84)
			void CaseClosedWithoutDoc() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Case Without Document verification");
			
			MethodPOM.CaseClosedWithoutDoc(driver, test);
			
			extent.endTest(test);
			extent.flush();
			}
	@Test(priority = 94)
			void AdvancedSearchworkspace() throws InterruptedException, IOException
			{
				test = extent.startTest("Advanced Search Reports excel  verification");
				
				
				MethodPOM1.AdvancedSearchWorkspace(driver, test, "Performer");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 95)
			void MyDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("Download and View Document");
			
				
				MethodsPOM.MyDocument(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
	
	//@Test(priority = 96)
	void ClosedCaseDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Closed case document verification");
				 	
		MethodPOM.ClosedCaseDoc(driver, test);
		extent.endTest(test);
	     extent.flush();
	}
	//@Test(priority = 97)
	void ClosedNoticeDoc() throws InterruptedException, IOException
	{
	test = extent.startTest("Closed notice document verification");
			 	
	MethodPOM.ClosedNoticeDoc(driver, test);
	extent.endTest(test);
	 extent.flush();
	}
	@Test(priority = 98)
			void AdvancedSearchDoc() throws InterruptedException, IOException
			{
				test = extent.startTest("Advanced search -Download and View Document");
				
				
				MethodsPOM.AdvancedSearchDocument(driver, test,"Performer");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 99)
		void AdvancedSearchShareCaseDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Advance search-Share Case Document Verification");
		
			
			MethodsPOM.AdvancedSearchShareCaseDocument(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =100)
				void AdvancedSearchShareNoticeDocument() throws InterruptedException, IOException
				{
					test = extent.startTest("My Document-Advance search-Share Notice Document Verification");
				
					
					MethodPOM.AdvancedSearchShareNoticeDocument(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
	@Test(priority =101)
				void AdvancedSearchShareTaskDocument() throws InterruptedException, IOException
				{
					test = extent.startTest("My Document-Advance search-Share Task Document Verification");
				
					
					MethodPOM.AdvancedSearchShareTaskDocument(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
	
//	@Test(priority =102)
	void AdvancedSearchClosedNoticeDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advanced search- Closed notice document verification");
				 	
		MethodPOM.AdvancedSearchClosedNoticeDoc(driver, test);
		extent.endTest(test);
	     extent.flush();
	}
	//@Test(priority = 103)
	void AdvancedSearchClosedCaseDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advanced search- Closed case document verification");
				 	
		MethodPOM.AdvancedSearchClosedCaseDoc(driver, test);
		extent.endTest(test);
	     extent.flush();
	}
		@Test(priority = 104) 		//Sever is blocking and not allowing to upload the file.
				void CriticalDocuments() throws InterruptedException, IOException
				{
					test = extent.startTest(" Critical Document Verification");
					
					MethodsPOM.CriticalDocuments(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}
				
		@Test(priority = 105) 		//Sever is blocking and not allowing to upload the file.
				void CriticalDocuments1() throws InterruptedException, IOException
				{
					test = extent.startTest(" Critical Document Verification");
					
					MethodsPOM.CriticalDocuments1(driver, test);
					
					extent.endTest(test);
					extent.flush();
				}

@Test(priority = 106)
		    void MyReports() throws InterruptedException, IOException
			{
				test = extent.startTest("Reports excel count verification");
				
				
				MethodPOM.MyReports(driver, test, workbook, "Performer");
				
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 107)
			void MoreReports() throws InterruptedException, IOException
			{
				test = extent.startTest("More Report-Reports excel  verification");
				
				
				MethodPOM.MoreReport(driver, test, "Company Admin");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 108)
			void AdvancedSearch() throws InterruptedException, IOException
			{
				test = extent.startTest("Advanced SearchReports excel  verification");
				
				
				MethodPOM1.AdvancedSearchReport(driver, test, "Company Admin");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 109)
			void MyReminder() throws InterruptedException, IOException
			{
				test = extent.startTest("My Reminder verification");
			
				
				MethodsPOM.MyReminder(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority =110)
	void ReminderWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder Without data verification");
		
		MethodPOM.ReminderWithoutData(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 111)
			void ImportUtility() throws InterruptedException, IOException
			{
				test = extent.startTest("Import Utility verification");
				
				
				MethodPOM.ImportUtility(driver,test);
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 112)
		   void ImportUtilityWithoutData() throws InterruptedException, IOException
		   {
		   	test = extent.startTest("Upload Empty File Import Utility verification");
		   	
		   	
		   	MethodPOM.ImportUtilityWithoutData(driver,test);
		   	extent.endTest(test);
		   	extent.flush();
		   }

   @Test(priority = 113)
		   void ImportUtilityInvalidData() throws InterruptedException, IOException
		   {
		   	test = extent.startTest("Enter Invalid data in Upload File Import Utility verification");
		   	
		   	
		   	MethodPOM.ImportUtilityInvalidData(driver,test);
		   	extent.endTest(test);
		   	extent.flush();
		   }

   @Test(priority = 114)
		   void ImportUtilityTwoManadtoryFileds() throws InterruptedException, IOException
		   {
		   	test = extent.startTest("Enter Two Manadtory fields in Upload File Import Utility verification");
		   	
		   	
		   	MethodPOM.ImportUtilityTwoManadtoryFileds(driver,test);
		   	extent.endTest(test);
		   	extent.flush();
		   }
 @Test(priority = 115)
	void CaseUpdationImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation Import Utility verification");
		
		
		MethodPOM.CaseUpdationImportUtility(driver,test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 116)
	void CaseUpdationUploadEmtyFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Empty File Import Utility verification");
		
		
		MethodPOM.CaseUpdationUploadEmtyFile(driver,test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 117)
	void CaseUpdationUploadInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid Data Import Utility verification");
		
		MethodPOM.CaseUpdationUploadInvalidData(driver,test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 118)
	void CaseUpdationUploadInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid File Import Utility verification");
		
		
		MethodPOM.CaseUpdationUploadInvalidFile(driver,test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 119)
	void NoticeUpdation() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation Import Utility verification");
		
		
		MethodPOM.NoticeUpdation(driver,test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 120)
void NoticeUpdationUploadEmtyFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation-Empty File Import Utility verification");
	
	
	MethodPOM.NoticeUpdationUploadEmtyFile(driver,test);
	extent.endTest(test);
	extent.flush();
}
@Test(priority =121)
void NoticeUpdationUploadInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid Data Import Utility verification");
	
	
	MethodPOM.NoticeUpdationUploadInvalidData(driver,test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 122)
void NoticeUpdationUploadInvalidFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid File Import Utility verification");
	
	
	MethodPOM.NoticeUpdationUploadInvalidFile(driver,test);
	extent.endTest(test);
	extent.flush();
}
		   
		    
	//@Test(priority = 98)
			void CaseAdvocateBill() throws InterruptedException, IOException
			{
				test = extent.startTest("Advocate bill verification");
				
				
				MethodPOM.AdvocateBillTab(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
	//   @Test(priority = 99)
			void CaseAdvocateBill1() throws InterruptedException, IOException
			{
				test = extent.startTest("Advocate bill verification");
			
				
				MethodPOM.ApproverAssignmentLog(driver, test);
				
				extent.endTest(test);
				extent.flush();
			}
//@Test(priority = 123)
	 		void WorkspaceFilter() throws InterruptedException, IOException
	 		{
	 			test = extent.startTest("My Workspace - Notice - Multiple Filters verification");
	 			
	 			
	 			MethodPOM1.WorkspaceFilter(driver, test);
	 			
	 			extent.endTest(test);
	 			extent.flush();
	 		}
//@Test(priority = 124)
	 void CaseWorkspaceFilter() throws InterruptedException, IOException
	 {
	 	test = extent.startTest("My Workspace - Case - Multiple Filters verification");
	 	
	 	
	 	MethodPOM1.CaseWorkspaceFilter(driver, test);
	 	
	 	extent.endTest(test);
	 	extent.flush();
	 }
//@Test(priority = 125)
	 void WorkspaceTaskFilter() throws InterruptedException, IOException
	 {
	 	test = extent.startTest("My Workspace - Task - Multiple Filters verification");
	 	
	 	
	 	MethodPOM1.WorkspaceTaskFilter(driver, test);
	 	
	 	extent.endTest(test);
	 	extent.flush();
	 }



//	@Test(priority = 126)
	 		void DocumentNoticeFilter() throws InterruptedException, IOException
	 		{
	 			test = extent.startTest("My Document Tab - Notice - Multiple Filters verification");
	 			
	 			
	 			MethodPOM1.DocumentNoticeFilter(driver, test);
	 			
	 			extent.endTest(test);
	 			extent.flush();
	 		}
//@Test(priority = 127)
	 	void DocumentCaseFilter() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest(" My Document = Case = Multiple  Filters verification");
	 	
	 		
	 		MethodPOM1.DocumentCaseFilter(driver, test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}
// @Test(priority = 128)
 	void DocumentTaskFilter() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest(" My Document = Task = Multiple  Filters verification");
	 	
	 		
	 		MethodPOM1.DocumentTaskFilter(driver, test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}
	// @Test(priority =129)
	 		void ReportFilter() throws InterruptedException, IOException
	 		{
	 			test = extent.startTest("My Report - Notice - Multiple Filters verification");
	 			
	 			MethodPOM1.ReportFilter(driver, test);
	 			
	 			extent.endTest(test);
	 			extent.flush();
	 		}
	//@Test(priority = 130)
	 	void ReportCaseFilter() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest("My Report - Case - Multiple Filters verification");
	 		
	 		MethodPOM1.ReportCaseFilter(driver, test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}
	  
//	 @Test(priority =131)
	 	void ReportTaskFilter() throws InterruptedException, IOException
	 	{
	 		test = extent.startTest("My Report = Task =  Filters verification");
	 		
	 		
	 		MethodPOM1.ReportTaskFilter(driver, test);
	 		
	 		extent.endTest(test);
	 		extent.flush();
	 	}
			
			@AfterMethod
			
			void Close()
			{
			  driver.close();
			}
}
