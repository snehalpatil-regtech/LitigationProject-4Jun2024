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

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import litigationAdditionalOwner.performerPOM;
import litigationCompanyAdmin.MethodsPOM;
import litigationManagement.CFOMethod;
import performer.OverduePOM;


public class CompanyAdminLogin

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
			sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
			return sheet;
		}
		
		@BeforeTest
		void setBrowser() throws InterruptedException, IOException
		{
			String workingDir = System.getProperty("user.dir");
			extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LitigationCompanyAdmin.html",true);
			test = extent.startTest("Litigation Logging In - Company Admin");
			test.log(LogStatus.PASS, "Test Passed = Verify Chrome browser.");
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
			Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
			String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
			
			Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
			Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
			String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
			
			driver = login.Login.UserLogin(uname,password,"company");		//Method of Login class to login user.
			
		}

		
	
					
		@Test(priority =0)
				 	void NoticeOpen() throws InterruptedException, IOException
				 	{
				 		test = extent.startTest("Notice - Open Count Verification");
				 		
				 		
				 		MethodsPOM.NoticeOpen(driver, test, workbook, "Performer");
				 		
				 		test.log(LogStatus.PASS, "Test Passed.");
				 		extent.endTest(test);
				 		extent.flush();
				 	}
			
					 @Test(priority =1)
					     	void CaseOpen() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Case - Open Count verification");
					     		
					     		
					     		MethodsPOM.CaseOpen(driver, test, workbook, "CFO -");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					
				
					 @Test(priority =2)
					     			void TaskOpen() throws InterruptedException, IOException
					     			{
					     				test = extent.startTest("Task - Open Count verification");
					     				
					     				
					     				MethodsPOM.TaskOpen(driver, test, workbook, "CFO");
					     				
					     				extent.endTest(test);
					     				extent.flush();
					     			}
			
					 		 @Test(priority = 3)
					 			void TaskDelete() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest("Task Delete verification");
					 				
					 				
					 				MethodsPOM.TaskDelete(driver, test);
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
					    	
					 @Test(priority = 4)
					     	void NoticeClosed() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Notice - Closed Count verification");
					     		
					     		
					     		MethodsPOM.NoticeClosed(driver, test, workbook, "Performer");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					@Test(priority =5)
						void CaseClose() throws InterruptedException, IOException
						{
							test = extent.startTest("Case - Closed Count Verification");
							
							MethodsPOM.CaseClosed(driver, test, workbook, "Performer");
							
							extent.endTest(test);
							extent.flush();
						}
					 	
				
					 	   
					 @Test(priority =6)
					     	void CloseNotice() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Close Notice Count verification");
					     		
					     		MethodsPOM.CloseNoticeCase(driver, test, workbook,"Notice","company admin");
					     		
					     		extent.endTest(test);
					     		extent.flush();
					     	}
					
					 
				 @Test(priority = 7)
				 void CloseCase() throws InterruptedException, IOException
					{
					 	test = extent.startTest("Close Case Count Verification");
					 				
					 	MethodsPOM.CloseNoticeCase(driver, test, workbook,"Case","company admin");
					 				
					 	extent.endTest(test);
					 	extent.flush();
					 }
				 
				
					 @Test(priority = 8)
					 			void TaskClosed() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest("Task - Closed Count verification");
					 				
					 				
					 				MethodsPOM.TaskClosed(driver, test, workbook, "CFO");
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
					 			@Test(priority = 9)
					 			void ClosedTask() throws InterruptedException, IOException
					 			{
					 				test = extent.startTest(" Closed Task Count verification");
					 				
					 				
					 				MethodsPOM.CloseNoticeCase(driver, test, workbook, "Task","company admin");
					 				
					 				extent.endTest(test);
					 				extent.flush();
					 			}
				 	@Test(priority = 10)
					     	void NoticeDocument() throws InterruptedException, IOException
					     	{
					     		test = extent.startTest("Notice Document verification");
					     		
					     		
					     		MethodsPOM.NoticeDocument(driver, test);
					     		
					     		extent.endTest(test);
					     		extent.flush();

					     	}
					
					 	@Test(priority = 11)
					 	void NoticeTaskActivity() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Notice TaskActivtiy verification");
					 		
					 		
					 		MethodsPOM.TaskActivtity(driver, test,workbook);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 //@Test(priority = 12)
					 void TaskActivtityDeleteResponse() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Task/Activtiy Delete Response verification");
					 	
					 	
					 	MethodsPOM.TaskActivtityDeleteResponse(driver, test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
				
					 @Test(priority =13)
					 void NoticeResponse() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Response verification");
					 	
					 	
					 	MethodsPOM.Response(driver, test,workbook);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
					
					 @Test(priority = 14)
					 void NoticePayment() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Payment verification");
					 	
					 	
					 	MethodsPOM.PaymentLog(driver,test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
					
					 @Test(priority = 14)
					 void NoticeExternalLawyer() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Lawyer verification");
					 	
					 	MethodsPOM.ExternalLawyerRating(driver, test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
				
					
					 @Test(priority = 15)
					 void NoticeAuditLog() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Notice Audit Log verification");

					 	
					 	MethodsPOM.AuditLog(driver, test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }		
					 @Test(priority =16)
					 void CaseDocument() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case - Document Tab");
					 	
					 	
					 	MethodsPOM.Document(driver, test);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
			
					@Test(priority = 17)
					 	void CaseTaskActivityTab() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case Task/Activity verification");
					 		
					 		
					 		MethodsPOM.TaskActivity1(driver, test,workbook,"Performer");
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}

			
					 	@Test(priority =18)
					 	void CaseHearingcfo() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case - CaseHearing Tab");
					 		
					 		
					 		MethodsPOM.CaseHearing(driver, test,workbook);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					
					
					@Test(priority = 19)
					 	void CaseOrderTab() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case Order verification");
					 		
					 		
					 		MethodsPOM.CaseOrder(driver, test,workbook,"Performer");
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
				 @Test(priority =20)
					 void CaseStatusPayment() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case - Status/Payment Tab");
					 	
					 	
					 	MethodsPOM.StatusPayment(driver, test,workbook);
					 	
					 	extent.endTest(test);
					 	extent.flush();
					 }
			
						@Test(priority =21)
					 	void ExternalLawyer() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case External Lawyer verification");
					 		
					 		
					 		MethodsPOM.ExternalLawyer(driver, test,1);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
					 @Test(priority =22)
					 	void CaseAuditLog() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Case - Audit Log Tab");
					 		
					 		
					 		MethodsPOM.Auditlog(driver, test);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 @Test(priority = 23)
						void HearingCalender() throws InterruptedException, IOException, AWTException
						{
							test = extent.startTest("Case Hearing Calender Verification");
							
							
							MethodsPOM.HearingCalender(driver, test,"Performer","Company admin");
							
							extent.endTest(test);
							extent.flush();
						}
					 @Test(priority = 24)
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
							MethodsPOM.CaseNoticeTypeGraph(driver, test,"Outward/Plaintiff Type",OutwardPlaintiff);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(driver,  test,"Inward/Defendent Type",InwardDefendent);
							Thread.sleep(4000);
							MethodsPOM.CaseNoticeTypeGraph( driver, test,"Petitioner Type",Petitioner);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph( driver, test,"Respondent Type",Respondent);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph( driver, test,"Applicant Type",Applicant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(driver,  test,"Complianant Type",Complainanat);
							//Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeGraph(driver,  test,"Defendant Type",Defendant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph(driver,  test,"Plaintiff Type",Plaintiff);
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();
							
							extent.endTest(test);
							extent.flush();
						}
						
					//  @Test(priority = 25)
						void CaseNoticeTypeFilter() throws InterruptedException, IOException
						{
							JavascriptExecutor js = (JavascriptExecutor) driver;
						 	js.executeScript("window.scrollBy(0,900)");
						 	
							//Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"CaseNoticeTypeSummaryGraph");
							//Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeFilter(driver, test,"CaseNoticeStageHearingGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"RiskSummaryHigh");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"DepartmentSummaryGraph");
							//Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"LocationSummaryGraph");
						//	Thread.sleep(3000);
							//MethodsPOM.CaseNoticeTypeFilter(driver, test,"CategorySummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"LessThanSummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"1To2YearSummaryGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"2to3YearAgeingGraph");
						//	Thread.sleep(3000);
						//	MethodsPOM.CaseNoticeTypeFilter(driver, test,"MoreThan3YearAgeingGraph");

							
							test = extent.startTest("Case Notice type summary graph Filter Verification");
							extent.endTest(test);
							extent.flush();
						}

						@Test(priority = 26)
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
							
							MethodsPOM.CaseNoticeStageGraph(driver, test,"cfo -");
							
							extent.endTest(test);
							extent.flush();
						}
						


						@Test(priority =27)
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
							MethodsPOM.RiskSummaryGraph(driver, test,"High Risk",HighRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph(driver, test,"Medium Risk",MediumRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph(driver, test,"Low Risk",LowRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph(driver, test,"Not Applicable Risk",NotApplicableRisk);
							
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();
						
							extent.endTest(test);
							extent.flush();
						}
						@Test(priority = 28)
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
					       MethodsPOM.DepartmentSummaryGraph(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }

						@Test(priority = 29)
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
					       MethodsPOM.LocationSummaryGraph(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }


						@Test(priority = 30)
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
					    	//test = extent.startTest("Select notice type filter ="+CategoryName+" Category -To check Category Summary Graph Count Verification");
					    	test = extent.startTest("Select Notice from Notice/Case Filter :- Company Law Category :-  to verify count of Category Summary graph");
					    	
					       Thread.sleep(3000);
					       MethodsPOM.CategorySummaryGraph(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
					    





					@Test(priority = 31)
					void InwardDefendantAgeingGraph() throws InterruptedException, IOException
					{
					     test = extent.startTest("Select Notice from Notice/Case Filter to verify count of Ageing(Less than year) Summary graph\"");
					     
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
						    //	int	Defendant = Integer.parseInt(performerPOM.clickDefendantNoticeCA(driver).getText());	//Reading Notice Open count.
								
						    	Thread.sleep(3000);
						    	MethodsPOM.InwardDefendantAgeingGraph(driver, test,"Inward/Defendent",InwardDefendent);
								Thread.sleep(3000);
								MethodsPOM.InwardDefendantAgeingGraph(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
								Thread.sleep(3000);
								MethodsPOM.InwardDefendantAgeingGraph(driver, test,"Petitioner",Petitioner);
								Thread.sleep(3000);
								MethodsPOM.InwardDefendantAgeingGraph(driver, test,"Respondent",Respondent);
								//Thread.sleep(3000);
								//MethodsPOM.InwardDefendantAgeingGraph(driver, test,"Defendant",Defendant);
								
								Thread.sleep(3000);
								OverduePOM.clickDashboard(driver).click();
					    
					      extent.endTest(test);
					      extent.flush();
					}



					@Test(priority =32)

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
						   MethodsPOM.AgeingGraph1to2years(driver, test,"Applicant",Applicant);
					  		Thread.sleep(3000);
					  		MethodsPOM.AgeingGraph1to2years(driver, test,"Complainant",Complainant);
					  		Thread.sleep(3000);
					  		MethodsPOM.AgeingGraph1to2years(driver, test,"Inward/Defendent",InwardDefendent);
							Thread.sleep(3000);
							MethodsPOM.AgeingGraph1to2years(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
							Thread.sleep(3000);
							MethodsPOM.AgeingGraph1to2years(driver, test,"Petitioner",Petitioner);
							//Thread.sleep(3000);
							//MethodsPOM.AgeingGraph1to2years(driver, test,"Respondent",Respondent);
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();
					  
							extent.endTest(test);
							extent.flush();
					}



					@Test(priority = 33)
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
						    MethodsPOM.AgeingGraph2to3years(driver, test,"Inward/Defendent",InwardDefendent);
							Thread.sleep(3000);
							MethodsPOM.AgeingGraph2to3years(driver,  test,"Applicant",Applicant);
					 		Thread.sleep(3000);
					 		MethodsPOM.AgeingGraph2to3years(driver,  test,"OutwardPlainftiff",OutwardPlainftiff);
					 		Thread.sleep(3000);
					 		MethodsPOM.AgeingGraph2to3years(driver,  test,"Petitioner",Petitioner);
					 		Thread.sleep(3000);
					 		MethodsPOM.AgeingGraph2to3years(driver,  test,"Plaintiff",Plaintiff);
						
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();

							extent.endTest(test);
							extent.flush();
					}	
					@Test(priority = 34)
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
							 js.executeScript("window.scrollBy(0,3850)");
							 Thread.sleep(3000);
							 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentMorethan3years(driver).getText());	//Reading Notice Open count.
							 int Complainant = Integer.parseInt(performerPOM.clickComplainantMorethan3years(driver).getText());	//Reading Notice Open count.
							 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffMorethan3years(driver).getText());	//Reading Notice Open count.
							 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerMorethan3years(driver).getText());	//Reading Notice Open count.
							 int Respondent = Integer.parseInt(performerPOM.clickRespondentMorethan3years(driver).getText());	//Reading Notice Open count.
							 
							 Thread.sleep(3000);
							 MethodsPOM.AgeingGraphMorethan3years(driver, test,"Inward/Defendent",InwardDefendent);
							 MethodsPOM.AgeingGraphMorethan3years(driver, test,"Complainant",Complainant);
							 MethodsPOM.AgeingGraphMorethan3years(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
							 MethodsPOM.AgeingGraphMorethan3years(driver, test,"Petitioner",Petitioner);
							 MethodsPOM.AgeingGraphMorethan3years(driver, test,"Respondent",Respondent);
							 
							  Thread.sleep(3000);
							 OverduePOM.clickDashboard(driver).click();

							 extent.endTest(test);
							 extent.flush();
					}	

						@Test(priority =35)
						void CaseNoticeTypeGraph1() throws InterruptedException, IOException
						{
							test = extent.startTest("Select Case from Notice/Case Filter to verify count of Case/Notice Summary graph");
							
							
							JavascriptExecutor js = (JavascriptExecutor) driver;
						    js.executeScript("window.scrollBy(0,900)");

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
						    MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Inward/Defendent Type",InwardDefendent);
						    Thread.sleep(3000);
						    MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Applicant",Applicant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Appellant",Appellant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Complianant",Complianant);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Petitioner",Petitioner);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Outward/Plaintiff Type",OutwardPlaintiff);
							Thread.sleep(3000);
							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Respondent",Respondent);
//							Thread.sleep(3000);
//							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Petitioner",Petitioner);
//							Thread.sleep(3000);
//							MethodsPOM.CaseNoticeTypeGraph1(driver, test,"Respondent",Respondent);
							
							
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();
							
							extent.endTest(test);
							extent.flush();
						}
						@Test(priority = 36)
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
							   String StageName =performerPOM.CaseStageName1(driver).getText();
								test = extent.startTest("Select Case from Notice/Case Filter :- "+StageName+" Stage:- To verify count of Case/Notice Summary graph");
						 	
								Thread.sleep(3000);
								MethodsPOM.CaseNoticeStageGraph1(driver, test,"cfo -");
						 	
								extent.endTest(test);
								extent.flush();
						   }
						@Test(priority = 37)
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
					    	int	MediumRisk = Integer.parseInt(performerPOM.RiskSummaryMedium1(driver).getText());	//Reading Notice Open count.
					    	int	LowRisk = Integer.parseInt(performerPOM.RiskSummaryLowCA(driver).getText());	//Reading Notice Open count.
					    	int	NotApplicableRisk = Integer.parseInt(performerPOM.RiskSummaryNotApplicable(driver).getText());	//Reading Notice Open count.
					    	
							
					    	Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph1(driver, test,"High Risk",HighRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph1(driver, test,"Medium Risk",MediumRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph1(driver, test,"Low Risk",LowRisk);
							Thread.sleep(3000);
							MethodsPOM.RiskSummaryGraph1(driver, test,"Not Applicable Risk",NotApplicableRisk);
						
							Thread.sleep(3000);
							OverduePOM.clickDashboard(driver).click();
							
							extent.endTest(test);
							extent.flush();
						}
						
						@Test(priority = 38)
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
							 Thread.sleep(3000);
							js.executeScript("window.scrollBy(0,950)");
						
							 String DeptName =performerPOM.DepartName(driver).getText();
							 //test = extent.startTest("Select Case Filter ="+DeptName+" Department - Department Summary Graph Count Verification");
							 test = extent.startTest("Select Case from Notice/Case Filter :-HR Department:- To verify count of Department Summary graph");
					       Thread.sleep(3000);
					       MethodsPOM.DepartmentSummaryGraph1(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						@Test(priority = 39)
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
					    	
//					    	  String LocationName =performerPOM.LocationName(driver).getText();
//					  		test = extent.startTest("Select Case Filter = "+LocationName+" Location- Location Summary Graph Count Verification");
					  		test = extent.startTest("Select Case from Notice/Case Filter :- A Pvt Ltd Location:- To verify count of Location Summary graph");
					      
					       Thread.sleep(3000);
					       MethodsPOM.LocationSummaryGraph1(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						
						
						@Test(priority = 40)
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
					  		//String CategoryName =performerPOM.CategoryName(driver).getText();
					    	//test = extent.startTest("Select Case Filter ="+CategoryName+" Category - Category Summary Graph Count Verification");
					    	test = extent.startTest("Select Case from Notice/Case Filter :-CNType Category:- To verify count of category Summary graph");
					    	
					       Thread.sleep(3000);
					       MethodsPOM.CategorySummaryGraph1(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
						
					//	@Test(priority =40)
					    void ExpensesCaseGraph() throws InterruptedException, IOException
					    {
					       test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense case wise graph");
					      
					       Thread.sleep(3000);
					       MethodsPOM.ExpensesCaseGraph( driver,test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
				//	@Test(priority =41)
					    void ExpensesCategoryWiseCaseGraph() throws InterruptedException, IOException
					    {
					       test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense category wise graph");
					      
					       Thread.sleep(3000);
					       MethodsPOM.ExpensesCategoryWiseCaseGraph(driver, test,"cfo -");

					       extent.endTest(test);
					       extent.flush();
					    }
				//	@Test(priority =42)
					 void ExpensesCounselWiseCaseGraph() throws InterruptedException, IOException
					 {
					    test = extent.startTest("Select Case from Notice/Case Filter to verify count of Expense counsel wise graph");
					   
					    Thread.sleep(3000);
					    MethodsPOM.ExpensesCounselWiseCaseGraph( driver,test,"cfo -");

					    extent.endTest(test);
					    extent.flush();
					 }
				//	@Test(priority =43)
					 void UtilizedBudgetGraph() throws InterruptedException, IOException
					 {
					    test = extent.startTest("Select Case from Notice/Case Filter to verify count of Utilized budget graph");
					   
					    Thread.sleep(3000);
					    MethodsPOM.UtilizedBudgetGraph(driver, test,"cfo -");

					    extent.endTest(test);
					    extent.flush();
					 }
						@Test(priority =45)
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
									 
									 int Applicant = Integer.parseInt(performerPOM.clickApplicantLessThanYearCaseCA(driver).getText());	//Reading Notice Open count.
									 int Complainant = Integer.parseInt(performerPOM.clickComplainantLessThanYearCaseCA(driver).getText());	//Reading Notice Open count.
									 int InwardDefendent = Integer.parseInt(performerPOM.clickInwardDefendentLessThanYearCase(driver).getText());	//Reading Notice Open count.
									 int Appellant = Integer.parseInt(performerPOM.clickAppellantLessThanYearCase(driver).getText());	//Reading Notice Open count.
									 int OutwardPlaintiff = Integer.parseInt(performerPOM.clickOutwardPlaintiffLessthanyearCase(driver).getText());	//Reading Notice Open count.
							    	 int Petitioner = Integer.parseInt(performerPOM.clickPetitionerLeassThanYearCase(driver).getText());	//Reading Notice Open count.
							    	 int Respondent = Integer.parseInt(performerPOM.clickRespondentLessThanYearCase(driver).getText());	//Reading Notice Open count.
							    	
									
							    	 
							    	 Thread.sleep(3000);
							    	 MethodsPOM.AgeingGraphLessThanYear(driver, test,"Applicant",Applicant);
								    Thread.sleep(3000);
								    MethodsPOM.AgeingGraphLessThanYear(driver, test,"Complainant",Complainant);
							    	Thread.sleep(3000);
							    	MethodsPOM.AgeingGraphLessThanYear(driver, test,"Inward/Defendent",InwardDefendent);
							    	Thread.sleep(3000);
							    	MethodsPOM.AgeingGraphLessThanYear(driver, test,"Appellant",Appellant);
									Thread.sleep(3000);
									MethodsPOM.AgeingGraphLessThanYear(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
									Thread.sleep(3000);
									MethodsPOM.AgeingGraphLessThanYear(driver, test,"Petitioner",Petitioner);
									Thread.sleep(3000);
									MethodsPOM.AgeingGraphLessThanYear(driver, test,"Respondent",Respondent);
									
									
									Thread.sleep(3000);
									OverduePOM.clickDashboard(driver).click();
						    
									extent.endTest(test);
									extent.flush();
						}

						@Test(priority =45)
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
							    int	Complianant = Integer.parseInt(performerPOM.clickComplianant1to2yearCaseCA(driver).getText());	//Reading Notice Open count.
						    	int	InwardDefendent = Integer.parseInt(performerPOM.clickInwardOutward1to2yearsCaseCA(driver).getText());	//Reading Notice Open count.
						    	int	Appleant = Integer.parseInt(performerPOM.clickAppleant1to2YearCase(driver).getText());	//Reading Notice Open count.
						    	int	Outwardplaintiff = Integer.parseInt(performerPOM.clickOutwardplaintiff1toyearCase(driver).getText());	//Reading Notice Open count.
						    	int	Petitioner = Integer.parseInt(performerPOM.clickPetitioner1toyearCase(driver).getText());	//Reading Notice Open count.
						    	int	Respondent = Integer.parseInt(performerPOM.clickRespondent1toyearCase(driver).getText());	//Reading Notice Open count.
						    	
						    	Thread.sleep(3000);
						    	MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Complianant",Complianant);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Inward/Defendent",InwardDefendent);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Appleant",Appleant);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Outward/plaintiff",Outwardplaintiff);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Petitioner",Petitioner);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph1to2yearsCase(driver,test,"Respondent",Respondent);
								
								Thread.sleep(3000);
								OverduePOM.clickDashboard(driver).click();
						    
						      extent.endTest(test);
						      extent.flush();
						 }


						@Test(priority =46)
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
								MethodsPOM.AgeingGraph2to3yearsCase(driver, test,"Applicant",Applicant);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph2to3yearsCase(driver, test,"Outward/Plaintiff",OutwardPlaintiff);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraph2to3yearsCase(driver, test,"Respondent",Respondent);
								
								
								
								Thread.sleep(3000);
								OverduePOM.clickDashboard(driver).click();
						    
								extent.endTest(test);
								extent.flush();
						 }
						@Test(priority =47)
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
						    	MethodsPOM.AgeingGraphMoreThan3yearsCase(driver, test,"Inward/Defendent",InwardDefendent);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraphMoreThan3yearsCase(driver, test,"Appleant",Appleant);
								Thread.sleep(3000);
								MethodsPOM.AgeingGraphMoreThan3yearsCase(driver, test,"Petitioner",Petitioner);
								
								Thread.sleep(3000);
								OverduePOM.clickDashboard(driver).click();
						    
						      extent.endTest(test);
						      extent.flush();
						 }
					 @Test(priority = 48)
					 	void MyDocument() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("My Document-Download and View Document");
					 	
					 		
					 		MethodsPOM.MyDocument(driver, test, workbook, "Performer");
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
				
					 
				
						@Test(priority = 49)
						void MyReports() throws InterruptedException, IOException
						{
							test = extent.startTest("Reports -excel count verification");
							
							
							MethodsPOM.MyReports(driver, test, workbook, "Company Admin");
							
							extent.endTest(test);
							extent.flush();
						}
					  
					@Test(priority = 50)
						void MoreReports() throws InterruptedException, IOException
						{
							test = extent.startTest("More Report-Reports excel  verification");
							
							
							MethodsPOM.MoreReport(driver, test, "Company Admin");
							
							extent.endTest(test);
							extent.flush();
						}
				 @Test(priority =51)
					 	void MyReminder() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("My Reminder verification");
					 		
					 		MethodsPOM.MyReminder(driver, test, workbook);
					 		
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 	
					 @Test(priority = 52)
					 	void ImportUtility() throws InterruptedException, IOException
					 	{
					 		test = extent.startTest("Import Utility verification");
					 		
					 		
					 		MethodsPOM.ImportUtility(driver,test);
					 		extent.endTest(test);
					 		extent.flush();
					 	}
					 
					 @Test(priority = 53)
					 void CaseUpdationImportUtility() throws InterruptedException, IOException
					 {
					 	test = extent.startTest("Case Updation Import Utility verification");
					 	
					 	
					 	CFOMethod.CaseUpdationImportUtility(driver,test);
					 	extent.endTest(test);
					 	extent.flush();
					 }

					 @Test(priority = 54)
					 void NoticeUpdation() throws InterruptedException, IOException
					 {
					 test = extent.startTest("Notice Updation Import Utility verification");


					 CFOMethod.NoticeUpdation(driver,test);
					 extent.endTest(test);
					 extent.flush();
					 }
					
					 @Test(priority = 55)
						void Masters() throws InterruptedException, IOException
						{
							test = extent.startTest("Masters - Legal Entity  verification");
							
							
							MethodsPOM.LegalEntity(driver, test, workbook);
							
							extent.endTest(test);
							extent.flush();
						}
				
					@Test(priority = 56)
					void Masters1() throws InterruptedException, IOException
					{
						test = extent.startTest("Masters - Law Firm verification");
						
						
						MethodsPOM.LawFirm(driver, test, workbook);
						
						extent.endTest(test);
						extent.flush();
					}

			
				@Test(priority = 57)
				void Masters2() throws InterruptedException, IOException
				{
					test = extent.startTest("Masters - 	User  verification");
					
					MethodsPOM.User(driver, test, workbook);
					
					extent.endTest(test);
					extent.flush();
				}
				

		@Test(priority = 58)
			void Masters3() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Opponent  verification");
				
				
				MethodsPOM.Opponent(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}

		
		  @Test(priority = 59)
			void Masters4() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Court  verification");
				
				MethodsPOM.Court(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
		 
		 
	
			@Test(priority = 60)
			void Masters5() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Case/NoticeType  verification");
				
				
				MethodsPOM.CaseNoticeType(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
			
			
		
	@Test(priority = 61)
			void Masters6() throws InterruptedException, IOException
			{
				test = extent.startTest("Masters - Payment Type  verification");
				
				
				MethodsPOM.PaymentType(driver, test, workbook);
				
				extent.endTest(test);
				extent.flush();
			}
		
		
@Test(priority = 62)
		void Masters7() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Custom Parameter  verification");
			
			
			MethodsPOM.customParameter(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}

	
	 	@Test(priority = 63)
		void Masters8() throws InterruptedException, IOException
		{
			test = extent.startTest("Masters - Case Stage  verification");
			
			
			MethodsPOM.CaseStage(driver, test, workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		
	
	@Test(priority = 64)
	void Masters9() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Document Type  verification");
		
		
		MethodsPOM.DocumentType(driver, test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 65)
	void Masters10() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Rating Criteria  verification");
		
		
		MethodsPOM.RatingCriteria(driver, test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	

			
	@Test(priority = 66)
	void Masters11() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Masters - PageAuthorization   verification");
		
		
		MethodsPOM.PageAuthorization(driver, test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 67)
	void AnnualBudget() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - Annual Budget verification");
		
		
		MethodsPOM.AnnualBudget(driver, test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}

//@Test(priority = 68)
void UpdateAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Update Annual Budget verification");
	
	
	MethodsPOM.UpdateAnnualBudget(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 69)
void DeleteAnnualBudget() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Delete Annual Budget verification");
	
	
	MethodsPOM.DeleteAnnualBudget(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority =70)
void Masters12() throws InterruptedException, IOException
{
	test = extent.startTest("Masters - Advocate Bill Approver  verification");
	
	
	MethodsPOM.AdvocateBillApprover(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 71)
void Masters13() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - UserReassignment  verification");

	MethodsPOM.UserReassignment(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority =72)
void Masters14() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - Notice Stage  verification");
	
	
	MethodsPOM.NoticeStage(driver, test, workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 73)
void Masters15() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Masters - Mail Authorization  verification");
	
	
	MethodsPOM.MailAuthorization(driver,test);
	
	extent.endTest(test);
	extent.flush();
}
@AfterMethod

void Close()
{
	 driver.close(); 
}				 	
	
	

}
