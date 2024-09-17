package CriticalTestCases;

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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import litigationAdditionalOwner.performerPOM;
import litigationManagement.CFOMethod;
import performer.OverduePOM;

public class MgmtGraph 
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
		
		
		test.log(LogStatus.PASS, "Test Passed = Verify Open Chrome Browser");
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
		
		
		Row row1 = sheet.getRow(132);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(133);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
		
	}
	
	
	
	
	@Test(priority = 1)
	void CaseNoticeTypeGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Notice Filter  = Case Notice Type Graph Count Verification");
		
		
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
		int	Defendant = Integer.parseInt(performerPOM.CaseNoticeTypeDefendantNotice(driver).getText());	//Reading Notice Open count.
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
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph(driver,  test,"Defendant Type",Defendant);
		Thread.sleep(3000);
		CFOMethod.CaseNoticeTypeGraph(driver,  test,"Plaintiff Type",Plaintiff);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
	
// @Test(priority = 1)
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

	@Test(priority = 2)
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
		 test = extent.startTest("Select Notice Filter ="+StageName+"stage - Case Notice Stage Graph Count Verification");
		
		CFOMethod.CaseNoticeStageGraph(driver, test,"cfo -");
		
		extent.endTest(test);
		extent.flush();
	}
//	 @Test(priority = 3)
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


	@Test(priority =4)
	void RiskSummaryGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Notice Filter = Risk Graph Count Verification");
		
		
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
	
//	 @Test(priority = 5)
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
	@Test(priority = 6)
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
		 test = extent.startTest("Select Notice Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
		
      
       Thread.sleep(3000);
       CFOMethod.DepartmentSummaryGraph(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
	
//	 @Test(priority = 7)
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

	@Test(priority = 8)
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
  		test = extent.startTest("Select Notice Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
  		
      
       Thread.sleep(3000);
       CFOMethod.LocationSummaryGraph(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
	
//	 @Test(priority =9)
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


@Test(priority = 10)
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
  		String CategoryName =performerPOM.CategoryName(driver).getText();
    	test = extent.startTest("Select Notice Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.CategorySummaryGraph(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
//	 @Test(priority =11)
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





@Test(priority = 12)
void InwardDefendantAgeingGraph() throws InterruptedException, IOException
{
     		test = extent.startTest("Select Notice Filter =Less than a year  = Ageing Graph Count Verification");
     
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
	    	int	Defendant = Integer.parseInt(performerPOM.clickDefendantNoticeCA(driver).getText());	//Reading Notice Open count.
			
	    	Thread.sleep(3000);
	    	CFOMethod.InwardDefendantAgeingGraph(driver, test,"Inward/Defendent",InwardDefendent);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph(driver, test,"Petitioner",Petitioner);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph(driver, test,"Respondent",Respondent);
			Thread.sleep(3000);
			CFOMethod.InwardDefendantAgeingGraph(driver, test,"Defendant",Defendant);
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard(driver).click();
    
			extent.endTest(test);
			extent.flush();
}


//	@Test(priority =13)
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
@Test(priority =31)

void AgeingGraph1to2years() throws InterruptedException, IOException
{
   		test = extent.startTest("Select Notice Filter =1 to 2 years = Ageing Graph Count Verification");
   
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

//	@Test(priority =32)
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



@Test(priority =33)
void AgeingGraph2to3years() throws InterruptedException, IOException
{
  	test = extent.startTest("Select Notice Filter =2 to 3 years = Ageing Graph Count Verification");
 
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

//	@Test(priority =34)
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
@Test(priority = 35)
void AgeingGraphMorethan3years() throws InterruptedException, IOException
{
    test = extent.startTest("Select Notice Filter =More than 3 years = Ageing Graph Count Verification");
 
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

//	@Test(priority =36)
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

	@Test(priority =37)
	void CaseNoticeTypeGraph1() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Case Filter  = Case Notice Type Graph Count Verification");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,850)");

	    Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseFilter(driver).click();

		
		 Thread.sleep(5000);
		 performerPOM.clickDashboardApplyBtn(driver).click();
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
	@Test(priority = 38)
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
			test = extent.startTest("Select Case Filter = "+StageName+" Stage = Case Notice Stage Graph Count Verification");
	 	
			Thread.sleep(3000);
			CFOMethod.CaseNoticeStageGraph1(driver, test,"cfo -");
	 	
			extent.endTest(test);
			extent.flush();
	   }
@Test(priority = 39)
	void RiskSummaryGraph1() throws InterruptedException, IOException
	{
		test = extent.startTest("Select Case Filter = Risk Graph Count Verification");
        
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
	
	@Test(priority = 40)
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
	
		 String DeptName =performerPOM.DepartName(driver).getText();
		 test = extent.startTest("Select Case Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.DepartmentSummaryGraph1(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
	@Test(priority = 41)
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
    	
    	  String LocationName =performerPOM.LocationName(driver).getText();
  		test = extent.startTest("Select Case Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
  		
      
       Thread.sleep(3000);
       CFOMethod.LocationSummaryGraph1(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
	
	
	@Test(priority = 42)
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
  		String CategoryName =performerPOM.CategoryName(driver).getText();
    	test = extent.startTest("Select Case Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.CategorySummaryGraph1(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
	
//	@Test(priority =43)
    void ExpensesCaseGraph() throws InterruptedException, IOException
    {
       test = extent.startTest("Select Case Filter = Expenses Case-Wise Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.ExpensesCaseGraph( driver,test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
//@Test(priority =44)
    void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
    {
       test = extent.startTest("Select Case Filter = Cables Category -Expenses Category Wise Graph Count Verification");
      
       Thread.sleep(3000);
       CFOMethod.ExpensesCategoryWiseCaseGraph(driver, test,"cfo -");

       extent.endTest(test);
       extent.flush();
    }
//@Test(priority =45)
 void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
 {
    test = extent.startTest("Select Case Filter -Expenses Counsel Wise Graph Count Verification");
   
    Thread.sleep(3000);
    CFOMethod.ExpensesCounselWiseCaseGraph( driver,test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }
//@Test(priority =46)
 void UtilizedBudgetGraph() throws InterruptedException, IOException
 {
    test = extent.startTest("Select Case Filter -Utilized budget Graph Count Verification");
   
    Thread.sleep(3000);
    CFOMethod.UtilizedBudgetGraph(driver, test,"cfo -");

    extent.endTest(test);
    extent.flush();
 }
	@Test(priority =47)
	void AgeingGraph() throws InterruptedException, IOException
	{
				test = extent.startTest("Select Case Filter =Less than a year  = Ageing Graph Count Verification");
	     
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

	@Test(priority =48)
	void AgeingGraph1to2yearsCase() throws InterruptedException, IOException
	{
	     	test = extent.startTest("Select Case Filter =1 to 2 years = Ageing Graph Count Verification");
	     
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


	@Test(priority =49)
	void AgeingGraph2to3yearsCase() throws InterruptedException, IOException
	{
	     	test = extent.startTest("Select Case Filter =2 to 3 years = Ageing Graph Count Verification");
	     
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
	@Test(priority =50)
	void AgeingGraphMoreThan3yearsCase() throws InterruptedException, IOException
	{
	     test = extent.startTest("Select Case Filter =More than 3 years = Ageing Graph Count Verification");
	     
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
	
	@AfterMethod
	 
	 void Close()
	 {
		 driver.close(); 
	 }



}
