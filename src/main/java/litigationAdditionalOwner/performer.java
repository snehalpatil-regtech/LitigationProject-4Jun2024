package litigationAdditionalOwner;

import java.awt.AWTException;
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

import litigationManagement.CFOMethod;
import login.BasePage;




public class performer  extends BasePage
{
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
	public static String XmlFilePath = "E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx";
	
//	public static XSSFSheet ReadExcel() throws IOException
//	{
//		
//		fis = new FileInputStream(performer.XmlFilePath);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(0);                        //Retrieving second sheet of Workbook
//		return sheet;
//	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{   
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationPerformer.html",true);
		test = extent.startTest("Litigation Logging In - Non Admin");
		test.log(LogStatus.PASS, "Test Passed = Verify firefox browser.");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod()
	void Login() throws InterruptedException, IOException
	{
     
//		XSSFSheet sheet = ReadExcel();
//		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
//		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
//		
//		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
//		
//
//		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
//		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
//		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
//		
//		
//		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
//		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
//		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
//		System.out.println(password);
//		
//		driver = login.Login.UserLogin(uname,password, "Litigation");     //Method of Login class to login user Performer.
		
		initialization("Litigation",0);

	}
	
	/*@Test(priority = 1)
	void NoticeOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice - Open Count Verification");
		
		
		MethodsPOM.NoticeOpen( test, workbook, "Performer");
		
		//test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
  
@Test(priority =3)
		void NoticeWithExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice With Existing Data verification");
		   MethodsPOM.NoticeWithExistingData( test,workbook);
		  extent.endTest(test);
			extent.flush();
		}
	
@Test(priority =4)
   void NoticeWithInvalidData() throws InterruptedException, IOException
  {
	     test = extent.startTest("Notice With Invalid Data verification");
	
	
	     MethodsPOM.NoticeWithInvalidData( test, workbook);
	
	     extent.endTest(test);
	     extent.flush();
 }
	 
@Test(priority =5)
	   void NoticeWithTwoMandatoryData() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Notice With Two Mandatory Fields verification");
		
		
		     MethodsPOM.NoticeWithTwoMandatoryData( test, workbook);
		
		     extent.endTest(test);
		     extent.flush();
	 }
	 
@Test(priority =6) 
	   void NoticeWithEmptyFields() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Notice With Empty Fields verification");
		
		
		     MethodsPOM.NoticeWithEmptyFields( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }

@Test(priority =7)
	void NoticeClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Summary -Clear button verification");
	
	
		MethodsPOM.NoticeClearBtn( test);
	
	     extent.endTest(test);
	     extent.flush();
	}
	@Test(priority =8)
	 void NoticeSendMailWithDoc() throws InterruptedException, IOException
	{
		     test = extent.startTest("Notice Summary-Send Mail With Document verification");
		
		
		     MethodsPOM.NoticeSendMailWithDoc( test);
		
		     extent.endTest(test);
		     extent.flush();
	}
	 
@Test(priority =9)
	 void NoticeSendMailWithDocInvalidFields() throws InterruptedException, IOException
	 {
	     test = extent.startTest(" Notice Summary -Send Mail With Document Invalid Fields verification");


	     MethodsPOM.NoticeSendMailWithDocInvalidFields( test);

	     extent.endTest(test);
	     extent.flush();
	 }
	@Test(priority =10)
		void NoticeSendMailWithDocEmptyFields() throws InterruptedException, IOException
		{
		     test = extent.startTest("Notice Summary -Send Mail With Document Empty Fields verification");
		
		
		     MethodsPOM.NoticeSendMailWithDocEmptyFields( test);
		
		     extent.endTest(test);
		     extent.flush();
		}
	  
//@Test(priority =11)
	  	void NoticeUserAssignment() throws InterruptedException, IOException
	 	{
		     test = extent.startTest("Notice User Assignment  verification");
		
	         MethodsPOM.NoticeUserAssignment( test);
		
		     extent.endTest(test);
		     extent.flush();
	 	}
//@Test(priority =12)
	void NoticeDeleteUserAssignment() throws InterruptedException, IOException
	{
     test = extent.startTest("Notice Delete User Assignment  verification");

     MethodsPOM.NoticeDeleteUserAssignment( test);

     extent.endTest(test);
     extent.flush();
	}

@Test(priority =13)
	void CaseOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - Open Count Verification");
		
		MethodsPOM.CaseOpen( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =14)
		void CaseExistingData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case with Existing Data verification");
			
			
			MethodsPOM.CaseExistingData( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	 
@Test(priority =15)
		void CaseWithInvalidData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case with Invalid Data verification");
			
			
			MethodsPOM.CaseWithInvalidData( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =16)
		void CaseWithTwoFieldsData() throws InterruptedException, IOException
		{
			test = extent.startTest("Case with Two Manadatory fields verification");
			
			
			MethodsPOM.CaseWithTwoFieldsData( test);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =17)
		void CaseWithEmptyFields() throws InterruptedException, IOException
		{
			test = extent.startTest("Case with Empty fields verification");
			
			
			MethodsPOM.CaseWithEmptyFields( test);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =18)
		void CaseWithClearBtn() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Summary - Clear button verification");
			
			
			MethodsPOM.CaseWithClearBtn( test);
			
			extent.endTest(test);
			extent.flush();
		}

//@Test(priority =19)
void CaseUserAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Case User Assignment verification");
	
	
		MethodsPOM.CaseUserAssignment( test,workbook);
	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =20)
	void CaseUserAssignmentDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Case User Assignment Delete Icon  verification");

		
		MethodsPOM.CaseUserAssignmentDelete( test);

		extent.endTest(test);
		extent.flush();
	}*/
	
	
@Test(priority =0)
		void CloseNotice() throws InterruptedException, IOException
		{
		test = extent.startTest("Close Notice Count Verification");
		MethodsPOM.CloseNoticeCase(test,"Notice","performer a");
		extent.endTest(test);
		extent.flush();
		}

/*@Test(priority = 21)
		void CloseCase() throws InterruptedException, IOException
		{
		test = extent.startTest("Close Case Count Verification");
			
			MethodsPOM.CloseNoticeCase( test, workbook,"Case","performer a");
			
		extent.endTest(test);
			extent.flush();
		}

	@Test(priority = 21)
	void LinkNotice() throws InterruptedException, IOException
	{
		test = extent.startTest("Link Notice Verification");
		
		
		MethodsPOM.LinkDocument( test, workbook, "Notice");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =22)
		void LinkNoticeViewIcon() throws InterruptedException, IOException
		{
		     test = extent.startTest("Linked notice view icon  verification");
		
		

		 	MethodsPOM.LinkNoticeViewIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
		}
@Test(priority=23)
	  void LinkNoticeDeleteIcon() throws InterruptedException, IOException
		{
		     test = extent.startTest("Linked notice Delete icon  verification");
		
		

		 	MethodsPOM.LinkNoticeDeleteIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
		}
@Test(priority = 24)
	void LinkCase() throws InterruptedException, IOException
	{
		test = extent.startTest("Link Case Verification");

		
		MethodsPOM.LinkDocument( test, workbook, "Case");
	
	extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =25)
	   void LinkCaseViewIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case view icon  verification");
		
		
		     MethodsPOM.LinkCaseViewIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	  }
	@Test(priority =26)
	   void LinkCaseDeleteIcon() throws InterruptedException, IOException
	  {
		     test = extent.startTest("Linked case delete icon  verification");
		
		
		     MethodsPOM.LinkCaseDeleteIcon( test);
		
		     extent.endTest(test);
		     extent.flush();
	 }
	
	
@Test(priority = 27)
	void NoticeClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice - Closed Count Verification");
		
		
		MethodsPOM.NoticeClosed( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 28)
	void CaseClose() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - Closed Count Verification");
	
		
		MethodsPOM.CaseClosed( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	

	
@Test(priority = 29)
 	void NoticeDocumentTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Notice Document verification");
 		
 		
 		MethodsPOM.NoticeDocument( test);
 		
 		extent.endTest(test);
 		extent.flush();
	}
@Test(priority = 30)
	void NoticeWithoutUploadDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Without Upload Document verification");
		
		
		MethodsPOM.NoticeWithoutUploadDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 31)
	void NoticeDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Search Fields verification");
		
		
		MethodsPOM.NoticeDocumentSearchFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 32)
	void NoticeDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share with Invalid data verification");
		
		
		MethodsPOM.NoticeDocumentShareInvalidData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =33)
		void NoticeDocumentShareWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("Notice Document Share without data verification");
	
			
			MethodsPOM.NoticeDocumentShareWithoutData( test);
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority = 34)
	void NoticeDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Document Share close button verification");
		
		
		MethodsPOM.NoticeDocumentShareCloseBtn( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 35)
void NoticeTaskActivityTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activity verification");
	
	
	MethodsPOM.TaskActivtity( test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority =36)
	void TaskActivtityExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy with existing data verification");
		
		
		MethodsPOM.TaskActivtityExistingData( test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =37)
	void TaskActivtityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Task/Activtiy Without data verification");
		
		
		MethodsPOM.TaskActivtityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =38)
void TaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activtiy Response Without data verification");
	
	
	MethodsPOM.TaskActivtityResponseWithoutStatus( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 39)
void TaskActivtityResponseClearBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activtiy  Response clear button verification");
	
	
	MethodsPOM.TaskActivtityResponseClearBtn( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =40)
void TaskActivtityDeleteResponse() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Task/Activtiy Delete Response verification");
	
	
	MethodsPOM.TaskActivtityDeleteResponse( test);
	
	extent.endTest(test);
	extent.flush();
}



@Test(priority = 41)
void NoticeResponseTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response tab verification");
	
	
	MethodsPOM.Response( test,workbook);
	
	extent.endTest(test);
	extent.flush();
}*/

@Test(priority =2)
void ResponseExistingData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Existing Data verification");


	MethodsPOM.ResponseExistingData( test,workbook);

	extent.endTest(test);
	extent.flush();
}

@Test(priority =3)
void NoticeResponseWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Without data verification");

	MethodsPOM.ResponseWithoutData(test);
    extent.endTest(test);
	extent.flush();
}	

/*@Test(priority =44)
void ResponseClearBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response Clear button verification");
	MethodsPOM.ResponseClearBtn( test);
     extent.endTest(test);
     extent.flush();
}



@Test(priority = 45)
void NoticePaymentLogTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice PaymentLog tab verification");
	
	
	MethodsPOM.PaymentLog(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 46)
void PaymentLogwithExistingData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment with existing data verification");
	MethodsPOM.PaymentLogExistingData(test);
   extent.endTest(test);
    extent.flush();
}
@Test(priority = 47)
void PaymentLogwithInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment with Invalid data verification");
	
	
	MethodsPOM.PaymentLogwithInvalidData(test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 48)
void NoticePaymentWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment Without data verification");


	MethodsPOM.PaymentLogWithoutData(test,workbook);

	extent.endTest(test);
	extent.flush();
}

@Test(priority = 49)
void NoticeExternalLawyerTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice ExternalLawyerRating tab verification");
	
	
	MethodsPOM.ExternalLawyerRating( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 50)
void ExternalLawyerWithoutRating() throws InterruptedException, IOException
{
	test = extent.startTest("Notice External Lawyer without rating verification");
	
	MethodsPOM.ExternalLawyerWithoutRating(test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =51)
void CriteriaInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Criteria Invalid Data verification");
	
	MethodsPOM.CriteriaInvalidData( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 52)
void CriteriaExistingData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Criteria Existing Data verification");
	
	MethodsPOM.CriteriaExistingData(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =53)
void CriteriaWithoutData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Criteria Without Data verification");
	
	MethodsPOM.CriteriaWithoutData(test);
	
	extent.endTest(test);
	extent.flush();
}




@Test(priority = 54)
void NoticeAuditLogTab() throws InterruptedException, IOException
{
	test = extent.startTest("Notice AuditLog tab verification");
	
	
	MethodsPOM.AuditLog(test);
	
	extent.endTest(test);
	extent.flush();
}
	
@Test(priority = 55)
	void NoticeDocViewandDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Summary Document verification");
	
		
		MethodsPOM.NoticeDocViewandDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =56)
	void CaseDocumentTab() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document verification");
		
		
		MethodsPOM.Document(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 57)
 	void CaseWithoutUploadDocument() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Document -Without Upload File verification");
 		
 		
 		MethodsPOM.CaseWithoutUploadDocument(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
	
@Test(priority =58)
	void CaseDocumentEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document with empty fields verification");
		
		
		MethodsPOM.CaseDocumentEmptyFields(test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =59)
	void CaseDocumentSearchFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Search Fields verification");
		
		
		MethodsPOM.CaseDocumentSearchFields(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =60)
	void CaseDocumentShareInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share with Invalid data verification");
		
		
		MethodsPOM.CaseDocumentShareInvalidData(test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =61)
	void CaseDocumentShareWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share without data verification");
		
		
		MethodsPOM.CaseDocumentShareWithoutData(test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =4)
	void CaseDocumentShareCloseBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Document Share close button verification");
		
		
		MethodsPOM.CaseDocumentShareCloseBtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
 @Test(priority =63)
    void CaseSendMailWithDoc() throws InterruptedException, IOException
   {
 	     test = extent.startTest("Case Summary-Send Mail With Document verification");
 	
 	    MethodsPOM.CaseSendMailWithDoc(test);
 	
 	     extent.endTest(test);
 	     extent.flush();
  }
 @Test(priority =64)
	    void CaseSendMailWithDocInvalidFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Document Invalid Fields verification");
	 	
	 	
	 	    MethodsPOM.CaseSendMailWithDocInvalidFields(test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }
@Test(priority =65)
	    void CaseSendMailWithEmptyFields() throws InterruptedException, IOException
	   {
	 	     test = extent.startTest("Case  Summary-Send Mail With Empty Fields verification");
	 	
	 	
	 	    MethodsPOM.CaseSendMailWithEmptyFields(test);
	 	
	 	     extent.endTest(test);
	 	     extent.flush();
	  }
@Test(priority = 66)
 	void CaseTaskActivityTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Task/Activity verification");
 		
 		
 		MethodsPOM.TaskActivity1( test,"Performer");
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
@Test(priority = 67)
	void CaseTaskActivityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy Without data verification");
		
		
		MethodsPOM.CaseTaskActivityWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
 
*/
 
@Test(priority = 5)
	void CaseTaskActivtityResponseWithoutStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activitiy Response Without data verification");
		
		
		MethodsPOM.CaseTaskActivtityResponseWithoutStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =6)
	void CaseTaskActivtityResponseClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Task/Activtiy  Response clear button verification");
		
		
		MethodsPOM.CaseTaskActivtityResponseClearBtn(test);
		
		extent.endTest(test);
		extent.flush();
	}

/*@Test(priority =71)
void CaseTaskActivtityDeleteResponse() throws InterruptedException, IOException
{
	test = extent.startTest("Case Task/Activtiy Delete Response verification");
	
	
	MethodsPOM.CaseTaskActivtityDeleteResponse( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 71)
 	void CaseHearingTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Hearing verification");
 		
 		
 		MethodsPOM.CaseHearing( test,workbook);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
	//@Test(priority =72)
	void CaseExistingHearingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case with Existing Hearing Date Verification");
		
		
		MethodsPOM.CaseExistingHearingData( test);
		
		extent.endTest(test);
		extent.flush();
	}
 	
	 @Test(priority= 73)
 	  void CaseWithoutHearingData() throws InterruptedException, IOException
 	  {
 		test = extent.startTest("Case without hearing data Verification");
 		
 		
 		MethodsPOM.CaseHearingWithoutData( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	  }
 	 
 @Test(priority =74)
 	   void CaseHearingInvalidDate() throws InterruptedException, IOException
 	   {
 	 	test = extent.startTest("Case Invalid Hearing Date Verification");
 	 	
 	 	
 	 	MethodsPOM.CaseHearingInvalidDate( test);
 	 	
 	 	extent.endTest(test);
 	 	extent.flush();
 	   }
	@Test(priority =75)
 	   void CaseHearingClearBtn() throws InterruptedException, IOException
 	   {
 	 	test = extent.startTest("Case heraing clear button Verification");
 	 	
 	 	
 	 	MethodsPOM.CaseHearingClearBtn( test);
 	 	
 	 	extent.endTest(test);
 	 	extent.flush();
 	   }
	@Test(priority = 76)
 	void CaseOrderTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Order verification");
 		
 		
 		MethodsPOM.CaseOrder( test,workbook,"Performer");
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
@Test(priority =77)
 		void CaseOrderExistingData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("To check validation message displayed  for case order with existing data");

 		
 			MethodsPOM.CaseOrderWithExistingData( test,workbook);
 		
 			extent.endTest(test);
 			extent.flush();
 		}
 @Test(priority =78)
		void CaseOrderWithoutData() throws InterruptedException, IOException
		{
			test = extent.startTest("To check validation message displayed  for case order without data");

		
			MethodsPOM.CaseOrderWithoutData( test);
		
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =79)
	void CaseOrderwithClearBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Order with clear button");

	
		MethodsPOM.CaseOrderwithClearBtn( test);
	
		extent.endTest(test);
		extent.flush();
	}

	//@Test(priority = 80)
 	void CaseAdvocateBillTab() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case advocate bill verification");
 	
 		
 		MethodsPOM.AdvocateBill( test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority = 80)
 	void StatusPayment() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Status/Payment verification");
 	
 		
 		MethodsPOM.StatusPayment( test,workbook);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
@Test(priority = 81)
 	void StatusPaymentWithExistingData() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Status/Payment with existing data verification");
 	
 		
 		MethodsPOM.StatusPaymentWithExistingData( test,workbook);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
@Test(priority =82)
	void StatusPaymentWithoutdata() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status/Payment without data ");
		
		
		MethodsPOM.StatusPaymentWithoutdata( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =83)
void StatusPaymentwithInvaliddata() throws InterruptedException, IOException
{
	test = extent.startTest("Case Status/Payment with Invalid data ");
	
	
	MethodsPOM.StatusPaymentwithInvaliddata( test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
 	
@Test(priority =84)
	void CaseStatusAppealtoNextCourt() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status Appeal to Next Court");
		
		
		MethodsPOM.CaseStatusAppealtoNextCourt( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =85)
	void CaseStatuswithEmptyFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Status With Empty Fields");
		
		MethodsPOM.CaseStatuswithEmptyFields( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 86)
 	void ExternalLawyer() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case External Lawyer verification");
 		
 		
 		MethodsPOM.ExternalLawyer( test,1);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	@Test(priority =87)
	void CaseExternalLawyerWitoutRating() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - External Lawyer Without Rating");
		
		
		MethodsPOM.CaseExternalLawyerWitoutRating( test);
		
		extent.endTest(test);
		extent.flush();
	}
 	
	@Test(priority =88)
 		void CaseExternalLawyerCriteria() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case - External Lawyer Rating -Add New Criteria ");
 			
 			
 			MethodsPOM.CaseExternalLawyerCriteria(test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}*/
 	
  @Test(priority = 7)
 	void CaseExistingCriteria() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Case Criteria Existing Data verification");
 		
 		MethodsPOM.CaseExistingCriteria(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
 	
 	@Test(priority =8)
 		void CaseCriteriaInvalidData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case Criteria Invalid Data verification");
 			
 			MethodsPOM.CaseCriteriaInvalidData( test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 	
/*	@Test(priority =91)
 		void CaseCriteriaWithoutData() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Case Criteria Without Data verification");
 			
 			MethodsPOM.CaseCriteriaWithoutData(test);
 			
 			extent.endTest(test);
 			extent.flush();
 		}
	@Test(priority = 92)
	void Auditlog() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Audit Log verification");
		
		
		MethodsPOM.Auditlog(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 93)
	void TaskOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Open Count Verification");
	
		
		MethodsPOM.TaskOpen( test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 94)
	void TaskwithExistingData() throws InterruptedException, IOException
	{
		test = extent.startTest("Task With existing data verification");
		
		
		MethodsPOM.TaskWithExistingData(test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =95)
	void TaskwithTwoManadatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Task With Two manadatory fields verification");
		
		
		MethodsPOM.TaskWithTwoMandatoryFields(test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
 
@Test(priority =96)
			void TaskwithoutData() throws InterruptedException, IOException
			{
				test = extent.startTest("Task Without  data verification");
				
				
				MethodsPOM.TaskwithoutData( test);
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority =97)
			void TaskwithClearBtn() throws InterruptedException, IOException
			{
				test = extent.startTest("Task Clear button verification");
				
				
				MethodsPOM.TaskwithClearBtn( test);
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority =98)
void TaskShowDetailesClearBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Task-Show Detailes Icon -Clear button verification");
	
	
	MethodsPOM.TaskShowDetailesClearBtn( test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 99)
void TaskDelete() throws InterruptedException, IOException
{
	test = extent.startTest("Task Delete verification");
	
	
	MethodsPOM.TaskDelete( test);
	
	extent.endTest(test);
	extent.flush();
}
	
	@Test(priority = 100)
	void TaskClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Closed Count Verification");
		
		
		MethodsPOM.TaskClosed( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 101)
		void ClosedTask() throws InterruptedException, IOException
		{
			test = extent.startTest(" Closed Task Count verification");
			
			
			MethodsPOM.CloseNoticeCase( test, "Task","performer a");
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 102)
	void WorkspaceFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - Notice - Multiple Filters verification");
		
		
		MethodPOM1.WorkspaceFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 103)
	void CaseWorkspaceFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - Case - Multiple Filters verification");
		
		
		MethodPOM1.CaseWorkspaceFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =104)
	void WorkspaceTaskFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - Task - Multiple Filters verification");
		
		
		MethodPOM1.WorkspaceTaskFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 105)
	void WorkspaceCaseHearingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace = Case Hearing = Search box  Filter verification");
		
		
		CFOMethod.WorkspaceCaseHearingFilter(test,"ABC Mall, Thane");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 106)
	void AdvancedSearchworkspace() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace(Advanced Search)verification");
	
		
		MethodPOM1.AdvancedSearchWorkspace(test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 106)
	void MyDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("Download and View Document Verification");
		
		
		MethodsPOM.MyDocument( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 108)
	void ShareCaseDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Share Case Document Verification");
	
		
		MethodsPOM.ShareCaseDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
@Test(priority = 109)
		void ShareNoticeDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Notice Document Verification");
		
			MethodsPOM.ShareNoticeDocument( test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =110)
		void ShareTaskDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("My Document-Share Task Document Verification");
		
			
			MethodsPOM.ShareTaskDocument(test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority =111)
	void DocumentNoticeFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document Tab - Notice - Multiple Filters verification");
		
		
		MethodPOM1.DocumentNoticeFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 112)
	void DocumentCaseFilter() throws InterruptedException, IOException
	{
	test = extent.startTest(" My Document = Case = Multiple  Filters verification");
	
	
	MethodPOM1.DocumentCaseFilter(test);
	
	extent.endTest(test);
	extent.flush();
	}
	
	@Test(priority = 113)
	void DocumentTaskFilter() throws InterruptedException, IOException
	{
	test = extent.startTest(" My Document = Task = Multiple  Filters verification");
	
	
	MethodPOM1.DocumentTaskFilter( test);
	
	extent.endTest(test);
	extent.flush();
	}
	@Test(priority = 114)
	void AdvancedSearchDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document(Advanced search)Verification");
	
		
		MethodsPOM.AdvancedSearchDocument(test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 115)
	void AdvancedSearchShareCaseDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Advance search-Share Case Document Verification");
	
		
		MethodsPOM.AdvancedSearchShareCaseDocument( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =116)
			void AdvancedSearchShareNoticeDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advance search-Share Notice Document Verification");
			
				
				MethodsPOM.AdvancedSearchShareNoticeDocument( test);
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority =117)
			void AdvancedSearchShareTaskDocument() throws InterruptedException, IOException
			{
				test = extent.startTest("My Document-Advance search-Share Task Document Verification");
			
				
				MethodsPOM.AdvancedSearchShareTaskDocument( test);
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 118) 		//Sever is blocking and not allowing to upload the file.
			void CriticalDocuments() throws InterruptedException, IOException
			{
				test = extent.startTest(" Critical Document Verification");
				
				MethodsPOM.CriticalDocuments( test);
				
				extent.endTest(test);
				extent.flush();
			}
			
	@Test(priority = 119) 		//Sever is blocking and not allowing to upload the file.
			void CriticalDocuments1() throws InterruptedException, IOException
			{
				test = extent.startTest(" Critical Document Verification");
				
				MethodsPOM.CriticalDocuments1( test);
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 120)
    void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports excel count verification");

		
		MethodsPOM.MyReports( test, workbook, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 121)
	void MoreReports() throws InterruptedException, IOException
	{
		test = extent.startTest("More Report-Reports excel  verification");
		
		
		MethodsPOM.MoreReport( test, "Company Admin");
		
		extent.endTest(test);
		extent.flush();
	}
	
 
	 @Test(priority = 122)
		void ReportFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Notice - Multiple Filters verification");
			
			MethodPOM1.ReportFilter( test);
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 123)
	void ReportCaseFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Case - Multiple Filters verification");
		
		MethodPOM1.ReportCaseFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =124)
	void ReportTaskFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report = Task =  Filters verification");
		
		
		MethodPOM1.ReportTaskFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 125)
		void AdvancedSearch() throws InterruptedException, IOException
		{
			test = extent.startTest(" My Reports(Advanced Search) -  verification");
			
			
			MethodPOM1.AdvancedSearchReport( test, "Company Admin");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 126)
	void MyReminder() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder verification");
	
		
		MethodsPOM.MyReminder( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority= 127)
	void ReminderWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder Without data verification");
		
		MethodsPOM.ReminderWithoutData( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 128)
	void ImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Import Utility verification");

		
		MethodsPOM.ImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 129)
	void ImportUtilityWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Upload Empty File Import Utility verification");
		
		
		MethodsPOM.ImportUtilityWithoutData(test);
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 130)
	void ImportUtilityInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Enter Invalid data in Upload File Import Utility verification");
		
		
		MethodsPOM.ImportUtilityInvalidData(test);
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 131)
	void ImportUtilityTwoManadtoryFileds() throws InterruptedException, IOException
	{
		test = extent.startTest("Enter Two Manadtory fields in Upload File Import Utility verification");
		
		
		MethodsPOM.ImportUtilityTwoManadtoryFileds(test);
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 132)
	void CaseUpdationImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation Import Utility verification");
		
		
		MethodsPOM.CaseUpdationImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 133)
	void CaseUpdationUploadEmtyFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Empty File Import Utility verification");
		
		
		MethodsPOM.CaseUpdationUploadEmtyFile(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 134)
	void CaseUpdationUploadInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid Data Import Utility verification");
		
		MethodsPOM.CaseUpdationUploadInvalidData(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 135)
	void CaseUpdationUploadInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation -Invalid File Import Utility verification");
		
		
		MethodsPOM.CaseUpdationUploadInvalidFile(test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 136)
	void NoticeUpdation() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice Updation Import Utility verification");
		
		
		MethodsPOM.NoticeUpdation(test);
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 137)
void NoticeUpdationUploadEmtyFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation-Empty File Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadEmtyFile(test);
	extent.endTest(test);
	extent.flush();
}
@Test(priority =138)
void NoticeUpdationUploadInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid Data Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadInvalidData(test);
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 139)
void NoticeUpdationUploadInvalidFile() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation -Invalid File Import Utility verification");
	
	
	MethodsPOM.NoticeUpdationUploadInvalidFile(test);
	extent.endTest(test);
	extent.flush();
}
*/
		
	
	
	


	
	
	
	
	
	//@Test(priority = 2)
		void AdvocateBill() throws InterruptedException, IOException
		{
			test = extent.startTest("Advocate bill verification");
			
			
			MethodsPOM.AdvocateBillTab( test);
			
			extent.endTest(test);
			extent.flush();
		}
	//@Test(priority = 3)
		void AdvocateBill1() throws InterruptedException, IOException
		{
			test = extent.startTest("Approver Assignment Log verification");
			
			MethodsPOM.ApproverAssignmentLog( test);
			
			extent.endTest(test);
			extent.flush();
		}
//@Test(priority = 114)
				void HearingCalender() throws InterruptedException, IOException, AWTException
				{
					test = extent.startTest("Case Hearing Calender Verification");
				
					
					MethodsPOM.HearingCalender( test,"Performer","Company admin");
					
					extent.endTest(test);
					extent.flush();
				}
	//@Test(priority = 115)
		void CaseHearing() throws InterruptedException, IOException
		{
			test = extent.startTest("Case Hearing Count Verification");
			
			
			MethodsPOM.CaseHearing( test,"Performer","Company admin");
			
			extent.endTest(test);
			extent.flush();
		}
/*@Test(priority = 40)
	void CustomerMgmt() throws InterruptedException, IOException
	{
		test = extent.startTest("City-Customer Management verification");
	
		
		MethodPOM1.CustomerMgmt( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 41)
	void CustomerMgmtCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("Customer Mgmt Customer-Customer Management verification");

		
		MethodPOM1.CustomerMgmtCustomer( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 42)
	void CustomerMgmtPlanVisit() throws InterruptedException, IOException
	{
		test = extent.startTest("Customer Mgmt Plan Visit-Customer Management verification");
	
		
		MethodPOM1.CustomerMgmtPalnVisit( test);
		
		extent.endTest(test);
		extent.flush();
	}	
//	@Test(priority = 43)
	void UpdateCommitmentsafterremarks() throws InterruptedException, IOException
	{
		test = extent.startTest("Update Commitments after remarks-Customer Management verification");

		
		MethodPOM1.UpdateCommitmentsafterremarks( test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority = 44)
	void UpdateCommitmentsStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("Update Commitments Status - Customer Management verification");
	
		
		MethodPOM1.UpdateCommitmentsStatus( test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority = 45)
	void Report() throws InterruptedException, IOException
	{
		test = extent.startTest("Report-Customer Management verification");
	
		
		MethodPOM1.Report( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	






		
		@AfterMethod
		
		void Close()
		{
		  driver.close();
		}
	
}
	
	




