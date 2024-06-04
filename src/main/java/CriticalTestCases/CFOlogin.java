package CriticalTestCases;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.OverduePOM;
import litigationAdditionalOwner.performerPOM;
import litigationManagement.CFOMethod;
import login.BasePage;


public class CFOlogin extends BasePage
{
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
//	public static XSSFSheet ReadExcel() throws IOException
//	{
//		//String workingDir = System.getProperty("user.dir");
//		fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx");
//		
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
//		return sheet;
//	}
	
	@BeforeTest

	void setBrowser() throws Exception
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCFO.html",true);
		test = extent.startTest("Litigation Logging In - CFO");
		
		
		test.log(LogStatus.PASS, "Test Passed = Verify Open Chrome Browser");
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
		
		//login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"cfo");		//Method of Login class to login user.*/
		
		initialization("cfo-diy",2);
	}
	

 /*@Test(priority =1)
   	void NoticeOpen() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notice - Open Count verification");
   		
   		
   		CFOMethod.NoticeOpen(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

@Test(priority =2)
    	void CaseOpen() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Open Count verification");
    		
    		
    		CFOMethod.CaseOpen(test);
    		
    		extent.endTest(test);
    		extent.flush();
    	}

@Test(priority =3)
    			void TaskOpen() throws InterruptedException, IOException
    			{
    				test = extent.startTest("Task - Open Count verification");
    				
    				
    				CFOMethod.TaskOpen(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
  
			
		 @Test(priority = 4)
			void TaskDelete() throws InterruptedException, IOException
			{
				test = extent.startTest("Task Delete verification");
				
				
				CFOMethod.TaskDelete(test);
				
				extent.endTest(test);
				extent.flush();
			}
   	
 @Test(priority = 5)
    	void NoticeClosed() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice - Closed Count verification");
    		
    		
    		CFOMethod.NoticeClosed( test, workbook, "Company Admin");
    		
    		extent.endTest(test);
    		extent.flush();
    	}
@Test(priority = 6)
    	void CaseClose() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Case - Closed Count verification");
    		
    		
    		CFOMethod.CaseClosed( test, workbook);
    		
    		extent.endTest(test);
    		extent.flush();
    	}
	

	 	
	   
@Test(priority = 7)
    	void CloseNotice() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Close Notice Count verification");
    		
    		CFOMethod.CloseNoticeCase( test, "Notice");
    		
    		extent.endTest(test);
    		extent.flush();
    	}
@Test(priority = 8)
			void CloseCase() throws InterruptedException, IOException
			{
			test = extent.startTest("Close Case Count Verification");
				
				
				CFOMethod.CloseNoticeCase( test,"Case");
				
			extent.endTest(test);
				extent.flush();
			}
	  
@Test(priority = 9)
			void TaskClosed() throws InterruptedException, IOException
			{
				test = extent.startTest("Task - Closed Count verification");
				
				
				CFOMethod.TaskClosed(test, workbook, "CFO");
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 10)
void ClosedTask() throws InterruptedException, IOException
{
	test = extent.startTest(" Closed Task Count verification");
	
	
	CFOMethod.CloseNoticeCase(test, "Task");
	
	extent.endTest(test);
	extent.flush();
}

	@Test(priority = 11)
    	void NoticeDocument() throws InterruptedException, IOException
    	{
    		test = extent.startTest("Notice Document verification");
    		
    		
    		CFOMethod.NoticeDocument( test);
    		
    		extent.endTest(test);
    		extent.flush();

    	}
 
	@Test(priority =12)
	void NoticeTaskActivity() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice TaskActivtiy verification");
		
		
		CFOMethod.TaskActivtity(test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =13)
void NoticeResponse() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Response verification");
	
	
	CFOMethod.Response( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =14)
void NoticePayment() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Payment verification");
	
	
	CFOMethod.PaymentLog(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 15)
void NoticeExternalLawyer() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Lawyer verification");
	
	CFOMethod.ExternalLawyer( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 16)
void NoticeAuditLog() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Audit Log verification");

	
	CFOMethod.AuditLog( test);
	
	extent.endTest(test);
	extent.flush();
}		
@Test(priority =17)
void CaseDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Case - Document Tab");
	
	
	CFOMethod.Document( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =18)
void CaseTaskActivity() throws InterruptedException, IOException
{
	test = extent.startTest("Case - Task/Activty Tab");
	
	
	CFOMethod.TaskActivity1( test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority =19)
	void CaseHearingcfo() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - CaseHearing Tab");
		
		
		CFOMethod.CaseHearing( test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority =20)
void CaseOrder() throws InterruptedException, IOException
{
	test = extent.startTest("Case - Case Order Tab");

	
	CFOMethod.CaseOrder( test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =21)
void CaseStatusPayment() throws InterruptedException, IOException
{
	test = extent.startTest("Case - Status/Payment Tab");
	
	
	CFOMethod.StatusPayment( test);
	
	extent.endTest(test);
	extent.flush();
}

	@Test(priority =22)
	void CaseExternalLawyerRating() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - External Lawyer Rating");
		
		
		CFOMethod.CaseExternalLawyer( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =23)
	void CaseAuditLog() throws InterruptedException, IOException
	{
		test = extent.startTest("Case - Audit Log Tab");
		
		
		CFOMethod.Auditlog( test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 23)
void CaseHearing() throws InterruptedException, IOException
{
	test = extent.startTest("Case Hearing Count Verification");


	CFOMethod.CaseHearing( test,"Performer","Case Hearing-");

	extent.endTest(test);
	extent.flush();
}
@Test(priority = 23)
void HearingCalender() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Hearing Calender verification");

	
	CFOMethod.HearingCalender(test,"Performer","Cfo");
	
	extent.endTest(test);
	extent.flush();
}*/
	@Test(priority = 24)
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

	@Test(priority = 25)
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
	


	@Test(priority =26)
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
	@Test(priority = 27)
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

	@Test(priority = 28)
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


	@Test(priority = 29)
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
    





@Test(priority = 30)
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



@Test(priority =31)

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
	   // int	Respondent = Integer.parseInt(performerPOM.clickRespondentNoticeCA1To2Years().getText());	//Reading Notice Open count.
  	
	    
	    
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
		//Thread.sleep(3000);
		//CFOMethod.AgeingGraph1to2years( test,"Respondent",Respondent);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
  
		extent.endTest(test);
		extent.flush();
}



@Test(priority = 32)
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
@Test(priority = 33)
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
		 js.executeScript("window.scrollBy(0,3850)");
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

	@Test(priority =34)
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
	@Test(priority = 35)
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
	@Test(priority = 36)
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
	
	@Test(priority = 37)
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
	@Test(priority = 38)
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
	
	
	@Test(priority = 39)
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
	@Test(priority =40)
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





	@Test(priority =41)
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


	@Test(priority =42)
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
	@Test(priority =43)
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
			js.executeScript("window.scrollBy(0,3850)");
			
		    int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentCAMoreThan3yearsCase().getText());	//Reading Notice Open count.
	    	int	Appleant = Integer.parseInt(performerPOM.clickAppleantCaseCAMoreThan3years().getText());	//Reading Notice Open count.
	    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitionerCaseCAMoreThan3years().getText());	//Reading Notice Open count.

			
	    	Thread.sleep(3000);
	    	CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Inward/Defendent",InwardDefendent);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Appleant",Appleant);
			Thread.sleep(3000);
			CFOMethod.AgeingGraphMoreThan3yearsCase( test,"Petitioner",Petitioner);
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
	    
	      extent.endTest(test);
	      extent.flush();
	 }

	        

/*@Test(priority = 50)
	void MyDocument() throws InterruptedException, IOException
	{
		test = extent.startTest("My Document-Download and View Document");
	
		
		CFOMethod.MyDocument( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	

@Test(priority = 51)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports -excel count verification");
		
		CFOMethod.MyReports( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 52)
	void MoreReports() throws InterruptedException, IOException
	{
		test = extent.startTest("More Report-Reports excel  verification");
		
		
		CFOMethod.MoreReport( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority =53)
	void MyReminder() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder verification");
		
		CFOMethod.MyReminder( test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}

	
@Test(priority = 54)
	void ImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Import Utility verification");
		
		
		CFOMethod.ImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 55)
	void CaseUpdationImportUtility() throws InterruptedException, IOException
	{
		test = extent.startTest("Case Updation Import Utility verification");
		
		
		CFOMethod.CaseUpdationImportUtility(test);
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 56)
void NoticeUpdation() throws InterruptedException, IOException
{
	test = extent.startTest("Notice Updation Import Utility verification");
	
	
	CFOMethod.NoticeUpdation(test);
	extent.endTest(test);
	extent.flush();
}
 
	
	
	@Test(priority = 57)
		void Masters() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Legal Entity  verification");
				
				CFOMethod.LegalEntity( test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	
@Test(priority = 58)
		void Masters1() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Law Firm verification");
			
			
			CFOMethod.LawFirm( test);
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority = 59)
	void Masters2() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - 	User  verification");
	
	
		CFOMethod.User( test);
	
		extent.endTest(test);
			extent.flush();
	}
	
	@Test(priority = 60)
	void Masters3() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Opponent  verification");
		
		
		CFOMethod.Opponent( test);
		
		extent.endTest(test);
		extent.flush();
	}



	@Test(priority = 61)
	void Masters4() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Court  verification");
	
	
		CFOMethod.Court( test);
	
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 62)
	void Masters5() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Case/NoticeType  verification");
	
	
		CFOMethod.CaseNoticeType( test);
	
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 63)
	void Masters6() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Payment Type  verification");
	
	
		CFOMethod.PaymentType( test);
	
		extent.endTest(test);
		extent.flush();
	}


	@Test(priority =64)
	void Masters7() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Custom Parameter  verification");

	
		CFOMethod.customParameter( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void Masters8() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Case Stage  verification");

	
		CFOMethod.CaseStage( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 66)
	void Masters9() throws InterruptedException, IOException
	{
	test = extent.startTest("Masters - Document Type  verification");
	
	
	CFOMethod.DocumentType( test);
	
	extent.endTest(test);
	extent.flush();
	}

	@Test(priority = 67)
	void Masters10() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Rating Criteria  verification");

	
		CFOMethod.RatingCriteria( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 68)
	void Masters12() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Notice Stage  verification");
	
	
		CFOMethod.NoticeStage( test);
	
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 69)
	void Masters11() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - UserReassignment  verification");
	
	
		CFOMethod.UserReassignment( test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 70)
	void Masters13() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Mail Authorization  verification");
	
		CFOMethod.MailAuthorization(test);
	
		extent.endTest(test);
		extent.flush();
	}*/

	
	
	
	 @AfterMethod
	 
	 void Close()
	 {
		 closeBrowser();
	 }


	


}
