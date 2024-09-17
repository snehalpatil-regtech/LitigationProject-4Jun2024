package performer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import reviewer.ReMethodsPOM;

public class OverdueCount
{
	public static WebDriver driver = null;			//WebDriver instance created
	public static WebElement upload = null;			//WebElement to get upload button
	public static ExtentReports extent;				//Instance created for report file
	public static ExtentTest test;					//Instance created for tests
	public int overdueStatutory;					//Variable to get old Statutory Overdue
	public int reviewStatutory;						//Variable to get old Statutory Review
	public int newOverdueStatutory;					//Variable to get new Statutory Overdue
	public int newReviewStatutory;					//Variable to get new Statutory Review
	public int overdueInternal;						//Variable to get old Internal Overdue
	public int reviewInternal;						//Variable to get old Internal Review
	public int newOverdueInternal;					//Variable to get new Internal Overdue
	public int newReviewInternal;					//Variable to get new Internal Review
	public static List<WebElement> elementsList = null;		//Variable to get list of action buttons
	public static List<WebElement> checkboxesList = null;	//Variable to get list of check boxes
	public static List<WebElement> elementsList1 = null;	//Variable to get list of text boxes
	public static FileInputStream fis = null;		//File input stream variable
	public static XSSFWorkbook workbook = null;		//Excel sheet workbook variable
	public static XSSFSheet sheet = null;			//Sheet variable
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//PerformerResults.html",true);
		test = extent.startTest("Verify Browser Opening");
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
		test = extent.startTest("Loging In - Performer");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"Overdue");		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	public static void message(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage(driver)));
			if(OverduePOM.closeMessage(driver).isDisplayed())	//If Compliance Updation message popped up,
			{
				OverduePOM.closeMessage(driver).click();		//then close the message.
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	//@Test(priority = 2)
	void DashboardStatutoryOverdue() throws InterruptedException
	{
		test = extent.startTest("Dashboard Statutory Overdue Value Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		test.log(LogStatus.INFO, "***********Statutory Overdue************ ");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue(driver)));
		
		String string_overdueStatutory = OverduePOM.clickStatutoryOverdue(driver).getText();		//Storing old value of Statutory overdue.
		overdueStatutory = Integer.parseInt(string_overdueStatutory);
		String string_reviewStatutory = OverduePOM.readPendingReviewStatutory(driver).getText();	//Storing old value of Pending Review.
		reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		OverduePOM.clickStatutoryOverdue(driver).click();				//Clicking on Statutory overdue.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress(driver);
		
		MethodsPOM.StatutoryOverdue(driver);							//Calling method of Statutory Overdue
		
		Thread.sleep(1000);		
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems1(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems1(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(compliancesCount);
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard(driver).click();						//Clicking on Dashboard link. 
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickStatutoryOverdue(driver)));
		
		String string_overdueStatutoryNew = OverduePOM.clickStatutoryOverdue(driver).getText();		//Storing old value of Statutory overdue.
		newOverdueStatutory = Integer.parseInt(string_overdueStatutoryNew);
		String string_reviewStatutoryNew = OverduePOM.readPendingReviewStatutory(driver).getText();	//Storing old value of Pending Review.
		newReviewStatutory = Integer.parseInt(string_reviewStatutoryNew);
		
		if(overdueStatutory > newOverdueStatutory && reviewStatutory < newReviewStatutory)
		{
			test.log(LogStatus.PASS, "Stautory 'Overudue' value decremented and Statutory 'Pending For Reveiew' value increamented");
			test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+". Old Pending for Review Count = "+reviewStatutory+ " | New Pending for Riview Count = "+newReviewStatutory);
		}
		else
		{
			if(overdueStatutory > newOverdueStatutory)
			{
				test.log(LogStatus.PASS, "Stautory 'Overudue' value decremented on Dashboard");
				test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+".");
			}
			else
			{
				test.log(LogStatus.FAIL, "Stautory 'Overudue' value didn't decremented");
				test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+". Old Pending for Review Count = "+reviewStatutory+ " | New Pending for Riview Count = "+newReviewStatutory);
			}
			if(reviewStatutory < newReviewStatutory)
			{
				test.log(LogStatus.PASS, "Statutory 'Pending For Reveiew' value incremented");
				test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewStatutory+" | New Pending for Riview Count = "+newReviewStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "Statutory 'Pending For Reveiew' value didn't incremented");
				test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewStatutory+" | New Pending for Riview Count = "+newReviewStatutory);
			}
		}
		if(count == newOverdueStatutory)
		{
			test.log(LogStatus.PASS, "Number of compliances matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.INFO, "No of Compliances in the grid = "+count+" | Dashboard Statutory Overdue Count = "+newOverdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.INFO, "No of Compliances in the grid = "+count+" | Dashboard Statutory Overdue Count = "+newOverdueStatutory);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 3)
	void DashboardInternalOverdue() throws InterruptedException
	{
		test = extent.startTest("Dashboard Internal Overdue Value Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		test.log(LogStatus.INFO, "***********Internal Overdue************ ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		String string_internalOverdue = OverduePOM.clickInternalOverdue(driver).getText();		//Storing old value of Statutory overdue.
		overdueInternal = Integer.parseInt(string_internalOverdue);
		String string_internalReview = OverduePOM.readPendingReviewInternal(driver).getText();	//Storing old value of Pending Review.
		reviewInternal = Integer.parseInt(string_internalReview);
		
		OverduePOM.clickInternalOverdue(driver).click();				//Clicking on Internal Overdue value.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress(driver);
		
		Thread.sleep(1000);		
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.xpath("//*[@id='grid']"));		//Searching grid/kendo.
		
		Thread.sleep(500);
		MethodsPOM.InternalOverdue(driver);							//Calling InternalOverdue() method.
		
		Thread.sleep(1000);		
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems1(driver).click();
		Thread.sleep(500);
		String item1 = CFOcountPOM.readTotalItems1(driver).getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount1);
		
		Thread.sleep(500);
		OverduePOM.clickDashboard(driver).click();						//Clicking on Dashboard link. 
		
		String string_newInternalOverdue = OverduePOM.clickInternalOverdue(driver).getText();		//Storing old value of Statutory overdue.
		newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
		String string_newInternalReview = OverduePOM.readPendingReviewInternal(driver).getText();	//Storing old value of Pending Review.
		newReviewInternal = Integer.parseInt(string_newInternalReview);
		
		if(newOverdueInternal < overdueInternal && newReviewInternal > reviewInternal)
		{
			test.log(LogStatus.PASS, "Internal 'Overudue' value decremented and Internal 'Pending For Reveiew' value increamented");
			test.log(LogStatus.INFO, "Old Internal Count = "+overdueInternal+" | New Internal Count = "+newOverdueInternal+". Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
		}
		else
		{
			if(newOverdueInternal < overdueInternal)
			{
				test.log(LogStatus.PASS, "Internal 'Overudue' value decremented on Dashboard");
				test.log(LogStatus.INFO, "Old Internal Overdue Count = "+overdueInternal+" | New Internal Overdue Count = "+newOverdueInternal);
			}
			else
			{
				test.log(LogStatus.FAIL, "Internal 'Overudue' value didn't decremented");
				test.log(LogStatus.INFO, "Old Internal Overdue Count = "+overdueInternal+" | New Internal Overdue Count = "+newOverdueInternal);
			}
			if(newReviewInternal > reviewInternal)
			{
				test.log(LogStatus.PASS, "Internal 'Pending For Reveiew' value incremented");
				test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
			}
			else
			{
				test.log(LogStatus.FAIL, "Internal 'Pending For Reveiew' value didn't incremented");
				test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
			}
		}
		if(count1 == newOverdueInternal)
		{
			test.log(LogStatus.PASS, "Number of compliances matches to Dashboard Internal Overdue Count.");
			test.log(LogStatus.INFO, "No of Compliances in the grid = "+count1+" | Dashboard Internal Overdue Count = "+newOverdueInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of compliances does not matches to Internal Overdue Count.");
			test.log(LogStatus.INFO, "No of Compliances in the grid = "+count1+" | Dashboard Internal Overdue Count = "+newOverdueInternal);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 4)
	void StatutoryChecklistCheckbox() throws InterruptedException
	{
		test = extent.startTest("Statutory Checklist Count Through Checkbox");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.StatutoryCheckListCheckbox(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 5)
	void StatutoryChecklistAction() throws InterruptedException
	{
		test = extent.startTest("Statutory Checklist Count Through Action");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.StatutoryCheckListAction(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 6)
	void InternalCheckListCheckbox() throws InterruptedException
	{
		test = extent.startTest("Internal Checklist Count Through Checkbox");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.InternalCheckListCheckbox(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 7)
	void InternalCheckListAction() throws InterruptedException
	{
		test = extent.startTest("Internal Checklist Count Through Action");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.InternalCheckListAction(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 8)
	void DashboardRejectStatutory() throws InterruptedException
	{
		test = extent.startTest("Statutory Rejected Compliance Count - Dashboard");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.DashboardRejected(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 9)
	void DashboardRejectInternal() throws InterruptedException
	{
		test = extent.startTest("Internal Rejected Compliance Count - Dashboard");
		test.log(LogStatus.INFO, "Test Initiated");
				
		MethodsPOM.DashboardRejected(driver, test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 10)
	void AssignedEventsSingle() throws InterruptedException
	{
		test = extent.startTest("Activated Events Count using Activate button");
		test.log(LogStatus.INFO, "Test Initiated");

		Thread.sleep(2000);
		int oldActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents(driver).getText());	//Storing old Activated Events value
		
		Thread.sleep(1000);
		OverduePOM.clickAssignedEvents(driver).click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(1000);
		elementsList1 = OverduePOM.viewEvent(driver);
		elementsList1.get(0).click();									//Clicking on View Event button
		
		Thread.sleep(2000);
		OverduePOM.closeViewEvent(driver).click();						//Closing the View Event
		
		Thread.sleep(1000);
		elementsList = OverduePOM.clickCheckBoxes(driver);
		elementsList.get(1).click();									//Clicking on first check box (Actually second on form)
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickTextBoxes(driver);
		elementsList1.get(1).sendKeys("Automation Testing");			//Writing in first text box
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickDates(driver);
		elementsList1.get(0).sendKeys("07/07/2021");						//Clicking on first date (Actually second on form)
		
		//Thread.sleep(500);
		//OverduePOM.selectDate(driver).click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(1000);
		elementsList1 = OverduePOM.clickActivate(driver);
		elementsList1.get(0).click();									//Clicking on first Activate button image
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress(driver);
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard(driver).click();						//Clicking on Dashboard
		Thread.sleep(2000);
		int newActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents(driver).getText());	//Storing new Activated Events value
		
		if(newActivatedEventValue > oldActivatedEventValue)
		{
			test.log(LogStatus.PASS, "Activated Events count incremented. Old value = " +oldActivatedEventValue+" New Value = "+ newActivatedEventValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 11)
	void AssignedEventsMultiple() throws InterruptedException
	{
		test = extent.startTest("Activated Events Count using Save button");
		test.log(LogStatus.INFO, "Test Initiated");

		Thread.sleep(2000);
		int oldActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents(driver).getText());	//Storing old Activated Events value
		
		Thread.sleep(1000);
		OverduePOM.clickAssignedEvents(driver).click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(1000);
		elementsList = OverduePOM.clickCheckBoxes(driver);
		elementsList.get(1).click();									//Clicking on first check box (Actually second on form)
		elementsList.get(2).click();									//Clicking on second check box (Actually third on form)
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickTextBoxes(driver);
		elementsList1.get(0).sendKeys("Automation Testing1");			//Writing in first text box
		elementsList1.get(1).sendKeys("Automation Testing2");			//Writing in second text box
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickDates(driver);
		elementsList1.get(1).click();									//Clicking on first date (Actually second on form)
		Thread.sleep(500);
		OverduePOM.selectDate(driver).click(); 							//Selecting date - second row and fifth column date from calendar
		
		elementsList1.get(2).click();									//Clicking on second date (Actually second on form)
		Thread.sleep(500);
		OverduePOM.selectDate(driver).click(); 							//Selecting date - second row and fifth column date from calendar
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)"," ");
		
		Thread.sleep(1000);
		OverduePOM.clickSave(driver).click();							//Clicking on Save button.
		
		Thread.sleep(2000);
		WebElement button = null;
		try
		{
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,1500)"," ");
			button = OverduePOM.clickAssigneCompliance(driver);			//Checking if the 'Assign Compliance' button is present
		}
		catch(Exception e)
		{
			
		}
		
		if(button != null)												//If button is present
		{
			OverduePOM.clickAssigneCompliance(driver).click();			//CLicking on the 'Assign Compliance' button
			
			Thread.sleep(2000);
			OverduePOM.selectPerformer(driver).click();
			Select dropdown1 = new Select(OverduePOM.selectPerformer(driver));	//Selecting performer dropdown 
			dropdown1.selectByVisibleText("performer a");						//Selecting performer
			
			Thread.sleep(700);
			Select dropdown2 = new Select(OverduePOM.selectReviewer(driver));	//Selecting reviewer dropdown
			dropdown2.selectByVisibleText("reviewer b");						//Selecting reviewer
			
			Thread.sleep(700);
			Select dropdown3 = new Select(OverduePOM.selectApprover(driver));	//Selecting approver dropdown
			dropdown3.selectByVisibleText("App App");							//Selecting approver
			
			Thread.sleep(700);
			OverduePOM.selectDate1(driver).click();								//Clicking on calendar
			Thread.sleep(500);
			OverduePOM.selectDate(driver).click();								//Selecting date of second row and fifth column
			
			Thread.sleep(700);
			Select dropdown4 = new Select(OverduePOM.selectEvent(driver));		//Selecting Event dropdown
			dropdown4.selectByIndex(2);											//Selecting Event
			
			Thread.sleep(700);
			OverduePOM.clickCheckbox(driver).click();							//Clicking on Select all checkbox
			
			Thread.sleep(2000);
			OverduePOM.clickSave1(driver).click();								//Clicking on 'Save' button of compliance assign prosess
			
			Thread.sleep(2000);
			OverduePOM.clickSave(driver).click();								//Clicking on Save button of Compliance Activate process.
		}
		
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard(driver).click();								//Clicking on Dashboard.
		Thread.sleep(2000);
		int newActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents(driver).getText());	//Storing new Activated Events value
		
		if(newActivatedEventValue > oldActivatedEventValue)
		{
			test.log(LogStatus.PASS, "Activated Events count incremented. Old value = " +oldActivatedEventValue+" New Value = "+ newActivatedEventValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 12)
	void Upcoming_ComplianceStatutory() throws InterruptedException
	{
		test = extent.startTest("Statutory Upcoming Compliance Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.UpcomingCompliance(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 13)
	void Upcoming_ComplianceInternal() throws InterruptedException
	{
		test = extent.startTest("Internal Upcoming Compliance Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.UpcomingCompliance(driver, test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 14)
	void WorkspaceOverdueStatutory() throws InterruptedException
	{
		test = extent.startTest("My Workspace - Statutory Overdue Value Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.WorkspaceOverdueStatutory(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 15)
	void WorkspaceOverdueInternal() throws InterruptedException
	{
		test = extent.startTest("My Workspace - Internal Overdue Value Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.WorkspaceOverdueInternal(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void DetailedReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.DetailedReport(test, driver, "performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report count verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.AssignmentReport(test, driver);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 18) 		//Sever is blocking and not allowing to upload the file.
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		OverduePOM.CriticalDocuments(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		OverduePOM.MyReminder(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void MyReminderInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Internal Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
				
		OverduePOM.MyReminder(driver, test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void ComplianceCalender() throws InterruptedException
	{
		test = extent.startTest("My Compliance Calender Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.MyCalendarCompliance(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void ReviseCompliance() throws InterruptedException
	{
		test = extent.startTest("Revise Compliance Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		//OverduePOM.ReviseCompliance(driver, test, 2);	//2 for 'Revised Compliance' from 'More Actions' drop down.
		
		OverduePOM.ReviseCompliance(driver, test, 1);	//1 for 'Update Penalty' from 'More Actions' drop down.
		
		OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void ReassignUser() throws InterruptedException
	{
		test = extent.startTest("Reassign User Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		ReMethodsPOM.ReassignPerformer(driver, test);
				
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 23)		//Sever is blocking and not allowing to upload the file.
	void ComplianceUpdateTask() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.UpdateTask(driver, test, workbook, "Statutory");
		
		MethodsPOM.UpdateTask(driver, test, workbook, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 24)		//Removed from application.
	void ComplianceUpdateLeave() throws InterruptedException
	{
		//Removed from application.
		test = extent.startTest("My Workspace - 'Update Leave' verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		MethodsPOM.UpdateLeave(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@AfterTest
	void Closing() throws InterruptedException
	{
		//Thread.sleep(1000);
		//driver.close();
	}
}