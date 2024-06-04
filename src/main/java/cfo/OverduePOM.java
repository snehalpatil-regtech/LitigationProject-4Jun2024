package cfo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver();
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriver()Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import login.BasePage;

public class OverduePOM extends BasePage
{
	private static WebElement msg = null;				//WebElement variable created for popup message button
	private static WebElement overdue = null;			//WebElement variable created for Statutory Overdue click
	private static WebElement statutoryAction = null;	//WebElement variable created for clicking on Action Image
	private static WebElement review = null;			//WebElement variable created for clicking on Action Image
	private static WebElement dropdown = null;			//WebElement variable created for Compliance Status dropdown box
	private static WebElement upload = null;			//WebElement variable created for uploading file
	private static WebElement date = null;				//WebElement variable created for selecting date
	private static WebElement value = null;				//WebElement variable created for inserting value in textbox
	private static WebElement selectDate = null;		//WebElement variable created for selecting date from second row and fifth column
	private static WebElement dashboard = null;			//WebElement variable created for clicking on dashboard
	private static WebElement submit = null;			//WebElement variable created for Submit button click
	private static WebElement lastMonth = null;			//WebElement variable created for clicking on arrow on calendar which shows last month
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting action button from multiple action buttons
	private static WebElement msgElement = null;			//WebElement variable created for checking Message after action button click in Internal Overdue
	private static WebElement close = null;					//WebElement variable created for closing window of internal compliance if disabled submit button 
	private static WebElement nextPage = null;				//WebElement variable created for clicking on next page arrow (if compliance without message notfound)
	private static WebElement statutoryChecklist = null;	//WebElement variable created for uploading file
	private static List<WebElement> checkboxesList = null;	//WebElement list created for selecting action button from multiple action buttons
	private static WebElement checklistSubmit = null;		//WebElement variable created for clicking on Submit button.
	private static WebElement checklistNotApplicable = null;	//WebElement variable created for clicking on Not Applicable button through Check boxes.
	private static WebElement actionNotApplicable = null;	//WebElement variable created for clicking on Not Applicable button through action button.
	private static WebElement internalChecklist = null;		//WebElement variable created for uploading file
	private static WebElement activatedEvents = null;	//WebElement list created for selecting date text box from multiple date text boxes
	private static WebElement assignedEvents = null;	//WebElement variable created for clicking on Assigned Events value.
	private static List<WebElement> checkboxes = null;	//WebElement list created for selecting action button from multiple action buttons
	private static List<WebElement> textboxes = null;	//WebElement list created for selecting text box from multiple text boxes
	private static List<WebElement> dates = null;		//WebElement list created for selecting date text box from multiple date text boxes
	private static List<WebElement> viewEvent = null;	//WebElement list created for clicking on View Event from multiple View Events
	private static WebElement closeView = null;			//WebElement variable created to close opened View Event
	private static List<WebElement> activate = null;	//WebElement list created for clicking 'Activate Button' image from multiple buttons
	private static WebElement save = null;				//WebElement variable created to click on save button.
	private static WebElement performer = null;			//WebElement variable created to click on Performer dropdown.
	private static WebElement reviewer = null;			//WebElement variable created to click on Reviewer dropdown.
	private static WebElement approver = null;			//WebElement variable created to click on Approver dropdown.
	private static WebElement checkbox = null;			//WebElement variable created to click on checkbox to select all checkboxes.
	
	
	public static WebElement closeMessage()					//Method for closing Message Popup
	{
		msg = getDriver().findElement(By.xpath("//*[@id='divNotification']/div/div/div[1]/button"));
		return msg;
	}
	
	public static WebElement clickStatutoryOverdue()		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divOverduePREOcount']"));
		return overdue;
	}
	
	public static WebElement readPendingReviewStatutory()	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerPendingforReviewPREOcount']"));
		return review;
	}
	
	public static WebElement clickStatutoryAction()			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[2]/td[17]/a"));
		return statutoryAction;
	}
	
	public static List<WebElement> clickStatutoryActionButton()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static List<WebElement> ActionButtons()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement selectStatutoryDropdown()		//Method to search dropdown box
	{
		dropdown = getDriver().findElement(By.xpath("//select[@id='ddlStatus']"));
		return dropdown;
	}
	
	public static WebElement complianceDocLink()
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='TxtworkingdocumentlnkStatutory']"));
		return dropdown;
	}
	
	public static WebElement buttonAddLink()
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='UploadlinkWorkingfileStatutory']"));
		return dropdown;
	}
	
	public static WebElement fileUploadStatutory()			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//input[@name='fuSampleFile']"));
		return upload;
	}
	
	public static WebElement fileUploadStatutory1()			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//input[@id='FileUpload1']"));
		return upload;
	}
	
	public static WebElement selectDateStatutory()			//Method to search Date Box
	{
		date = getDriver().findElement(By.xpath("//*[@id='tbxDate']"));
		return date;
	}
	
	public static WebElement valueSystem()					//Method to search text box
	{
		value = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerSystem']"));
		return value;
	}
	
	public static WebElement valueReturn()					//Method to search text box
	{
		value = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerReturn']"));
		return value;
	}
	
	public static WebElement remark()						//Method created to search text area 
	{
		value = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks']"));
		return value;
	}
	
	public static WebElement clickComplianceSubmit()		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//input[@value ='Submit']"));
		return submit;
	}
	
	public static WebElement clickDashboard()				//Method to search Dashboard Link
	{
		dashboard = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
		return dashboard;
	}
	
	public static WebElement clickAdvancedSearch()
	{
		dashboard = getDriver().findElement(By.xpath("//*[@id = 'AdavanceSearch']"));
		return dashboard;
	}
	
	public static WebElement clickInternalOverdue()			//Method for clicking on Internal Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divOverdueInternalPREOcount']"));
		return overdue;
	}
	
	public static WebElement readPendingReviewInternal()	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPerformerPendingforRevieweInternalPREOcount']"));
		return review;
	}
	
	public static List<WebElement> clickActionButtonList() 	//Method to get list of action buttons on web page
	{
		elementsList = getDriver().findElements(By.xpath("//*[@role='button'][@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement msgCheck()						//Method to check message -"Compliance related task is not yet completed."
	{
		msgElement = getDriver().findElement(By.xpath("//span[@id='lbltaskinternal']"));
		return msgElement;
	}
	
	public static WebElement closeCompliance()				//Method to close compliance popup.
	{
		close = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer']/div/div/div[1]/button"));
		return close;
	}
	
	public static WebElement selectInternalDropdown()		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//select[@id='ddlStatus2']"));
		return dropdown;
	}
	
	public static WebElement complianceDocLinkInternal()
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='TxtCompliancedocumentlnk']"));
		return dropdown;
	}
	
	public static WebElement buttonAddLinkInternal()
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='UploadlinkCompliancefile']"));
		return dropdown;
	}
	
	public static WebElement fileUploadInternal()			//Method to search Choose File button.
	{
		upload = getDriver().findElement(By.xpath("//*[@id='fuSampleFile2']"));
		return upload;
	}
	
	public static WebElement selectDateInternal()			//Method to search Date box
	{
		date = getDriver().findElement(By.xpath("//input[@id='tbxDate2']"));
		return date;
	}
	
	public static WebElement selectDate()					//Method to click on date at second row and fourth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a"));
		return selectDate;
	}
	
	public static WebElement selectDate2()					//Method to click on date at second row and fifth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a"));
		return selectDate;
	}
	
	public static WebElement selectDate3()					//Method to click on date at second row and fifth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a"));
		return selectDate;
	}
	
	public static WebElement selectLastMonth()				//Method to click on arrow which shows last month
	{
		lastMonth = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"));
		return lastMonth;
	}
	
	public static WebElement loadNextPage()					//Method to search the forward arrow to load next page records 
	{
		nextPage = getDriver().findElement(By.xpath("//div[@id='grid']/div[5]/a[3]/span"));
		return nextPage;
	}
	
	public static WebElement clickStatutoryChecklist()		//Method to click on Statutory Checklist value
	{
		statutoryChecklist = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPerformerChecklistPREOcount']"));
		return statutoryChecklist;
	}
	
	public static List<WebElement> readCalendarCompType()			//Method to check type compliance displayed
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]"));
		return elementsList;
	}
	
	public static List<WebElement> readCalendarCompType1()			//Method to check type compliance displayed
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		return elementsList;
	}
	
	public static List<WebElement> clickCheckboxesList() 	//Method to get list of action buttons on web page
	{
		checkboxesList = getDriver().findElements(By.xpath("//input[@id='sel_chkbx']"));
		return checkboxesList;
	}
	
	public static WebElement clickSubmit()					//Method to search Submit button.
	{
		checklistSubmit = getDriver().findElement(By.xpath("//*[@id='dvbtnSubmit']"));
		return checklistSubmit;
	}
	
	public static WebElement clickCheckboxesNotApplicable()	//Method to click on 'Not Applicable' button after clicking multiple check boxes. (Independent of Statutory or Internal)
	{
		checklistNotApplicable = getDriver().findElement(By.xpath("//button[@id='dvbtnNotApplicableSubmit']"));
		return checklistNotApplicable;
	}
	
	public static List<WebElement> clickStatutoryChecklistAction()	//Method to click on Action button. (Independent of Statutory or Internal)
	{
		elementsList = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit3']"));
		return elementsList;
	}
	
	public static WebElement clickActionNotApplicable()	//Method to click on 'Not Applicable' button through action button.
	{
		actionNotApplicable = getDriver().findElement(By.xpath("//input[@value='Not Applicable']"));
		return actionNotApplicable;
	}
	
	public static WebElement statutoryComplianceDoc()
	{
		checkbox = getDriver().findElement(By.xpath("//input[@name = 'TxtChecklistDocument']"));
		return checkbox;
	}
	
	public static WebElement statutoryAddLinkButton()
	{
		checkbox = getDriver().findElement(By.xpath("//input[@name = 'Uploadlingchecklistfile']"));
		return checkbox;
	}
	
	public static WebElement clickInternalChecklist()	//Method to click on Internal Checklist value
	{
		internalChecklist = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPerformerChecklistInternalPREOcount']"));
		return internalChecklist;
	}
	
	public static WebElement readActivatedEvents()		//Method to click on Internal Checklist value
	{
		activatedEvents = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divActivatedEventPREOcount']"));
		return activatedEvents;
	}
	
	public static WebElement clickAssignedEvents()		//Method to click on Internal Checklist value
	{
		assignedEvents = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divAssignedEventPREOcount']"));
		return assignedEvents;
	}
	
	public static List<WebElement> clickCheckBoxes()	//Method to search multiple check boxes for CheckList count
	{
		checkboxes = getDriver().findElements(By.xpath("//label[@class='k-checkbox-label k-no-text']"));
		return checkboxes;
	}
	
	public static List<WebElement> clickTextBoxes()		//Method to search multiple text boxes for CheckList count
	{
		textboxes = getDriver().findElements(By.xpath("//input[@type='text'][@class='k-textbox']"));
		return textboxes;
	}
	
	public static List<WebElement> clickDates()			//Method to search multiple date textboxes
	{
		dates = getDriver().findElements(By.xpath("//input[@type='date'][@class='k-textbox']"));
		return dates;
	}
	
	public static List<WebElement> viewEvent()			//Method to search multuple 'View' button image
	{
		viewEvent = getDriver().findElements(By.xpath("//a[@class = 'k-button k-button-icontext ob-overview k-grid-edit1']"));
		return viewEvent;
	}
	
	public static WebElement closeViewEvent()			//Method to search 'Back' button of opened view.
	{
		closeView = getDriver().findElement(By.xpath("//a[@class='k-button k-bare k-button-icon k-window-action']"));
		return closeView;
	}
	
	public static List<WebElement> clickActivate()		//Method to search multiple Activate buttons.
	{
		activate = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return activate;
	}
	
	public static WebElement clickSave()				//Method to search Save button.
	{
		save = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_btnAllSavechk']"));
		return save;
	}
	
	public static WebElement clickAssigneCompliance()	//Method to search 'Assign Compliance' button
	{
		msgElement = getDriver().findElement(By.xpath("//input[@value='Assign Compliance']"));
		return msgElement;
	}
	
	public static WebElement selectPerformer()			//Method to search dropdown to select performer user
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterPerformer']"));
		return performer;
	}
	
	public static WebElement selectReviewer()			//Method to search dropdown to select reviewer user
	{
		reviewer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterReviewer']"));
		return reviewer;
	}
	
	public static WebElement selectApprover()			//Method to search dropdown to select approver user
	{
		approver = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterApprover']"));
		return approver;
	}
	
	public static WebElement selectDate1()				//Method to search date text box.
	{
		date = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_tbxStartDate']"));
		return date;
	}
	
	public static WebElement selectEvent()				//Method to search dropdown to select Event
	{
		date = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlEvent']"));
		return date;
	}
	
	public static WebElement clickSave1()				//Method to search Save button.
	{
		save = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_SaveComplianceList']"));
		return save;
	}
	
	public static WebElement clickCheckbox()			//Method to search checkbox of Select all.
	{
		checkbox = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_gvComplianceListAssign_chkComplianceCheck']"));
		return checkbox;
	}
	
	public static WebElement clickMyWorkspace()			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenuLic']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickMyWorkspace1()			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@onclick='CheckProduct();']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickCompliance()			//Searching Compliance element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='LiComplist']"));
		return performer;
	}
	
	public static WebElement clickUserDropDown()		//Searching dropdown to select User
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[1]"));
		return performer;
	}
	
	public static WebElement clickPerformer()			//Selecting performer in User Dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[1]"));
		return performer;
	}
	
	public static WebElement selectType()			//Searching Overdue type dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[2]"));
		return performer;
	}
	
	public static WebElement clickStatutory()			//Searching 'Statutory' sub menu of dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-list k-reset'])[1]/li[1]"));
		return performer;
	}
	
	public static WebElement clickInternal()			//Searching 'Statutory' sub menu of dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-list k-reset'])[1]/li[2]"));
		return performer;
	}
	
	public static WebElement selectStatus()				//Searching Status dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[3]"));
		return performer;
	}
	
	public static WebElement clickOverdue()				//Searching 'Overdue' sub menu status of dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[3]"));				//(//*[@class='k-list-scroller'])[2]/ul/li[3]
		return performer;
	}
	
	public static WebElement clickUser()				//Searching User dropdown.
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-dropdown-wrap k-state-default k-state-hover']"));
		return performer;
	}
	
	public static WebElement clickMonthDropDown()		//Searching Month dropdown
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return performer;
	}
	
	public static List<WebElement> clickCalenderAction()		//Searching action button on form near to calendar
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement clickMyReminder()			//Searching 'My Reminder' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftremindersmenu']"));
		return performer;
	}
	
	public static WebElement clickAddNew()				//Searching 'Add New' button to add reminder
	{
		performer = getDriver().findElement(By.xpath("//*[@value='Add New']"));
		return performer;
	}
	
	public static WebElement clickAddNewReminder()		//Searching 'Add New' button to add reminder
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'Addnew']"));
		return performer;
	}
	
	public static WebElement selectComplianceType()		//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlComType']"));
		return performer;
	}
	
	public static WebElement selectComplianceType1()	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id='ddlComType_chosen']"));
		return performer;
	}
	
	public static WebElement selectInternalType()		//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ddlComType_chosen']/div/ul/li[2]"));
		return performer;
	}
	
	public static WebElement selectLocation()			//Searching 'Location' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlBranch']"));
		return performer;
	}
	
	public static WebElement clickLocation()			//Searching 'Location' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id='ddlBranch_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectLocation1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ddlBranch_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement selectCompliance()			//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlCompliance']"));
		return performer;
	}
	
	public static WebElement clickCompliance1()			//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id = 'ddlCompliance_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectCompliance1()			//Searching 'Compliance' drop down
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id = 'ddlCompliance_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement selectRole()				//Searching 'Role' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlRole']"));
		return performer;
	}
	
	public static WebElement clickRole()
	{
		performer = getDriver().findElement(By.xpath("//div[@id = 'ddlRole_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectRole1()
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id = 'ddlRole_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickDate()				//Searching 'Date' input box
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxDate']"));
		return performer;
	}
	
	public static WebElement clickSaveButton()			//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//input[@value='Save']"));
		return performer;
	}
	public static WebElement clickUpdateButton()			//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//input[@value='Update']"));
		return performer;
	}
		
	public static WebElement selectNextMonth()			//Method to click on arrow which shows last month
	{
		lastMonth = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span"));
		return lastMonth;
	}
	
	public static WebElement readReminder()				//Searching total reminders count
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return performer;
	}
	
	public static WebElement readReminder1()				//Searching total reminders count
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecordTask']"));
		return performer;
	}
	
	public static WebElement readReminderMsg()			//Searching after Save Message in My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li"));
		return performer;
	}
	
	public static WebElement readReminderMsg1()			//Searching after Save Message in My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ValidationSummary1']/ul/li"));
		return performer;
	}
	
	public static WebElement closeReminder()			//Method to close compliance popup.
	{
		close = getDriver().findElement(By.xpath("//*[@class='close']"));
		return close;
	}
	
	public static WebElement selectInternal()			//Searching 'Internal' compliance for My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDocType']"));
		return performer;
	}
	
	public static WebElement clickComplianceType()
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-multiselect-wrap k-floatwrap'])[2]"));
		return performer;
	}
	
	public static WebElement clickInternalCheckbox()
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[2]"));
		return performer;
	}
	
	public static WebElement clickStatutoryCheckbox()
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[1]"));
		return performer;
	}
	
	public static WebElement clickMyDocuments()			//Searching 'My Documents'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return performer;
	}
	
	public static WebElement clickCriticalDocuments()	//Searching 'Critical Document' under My Documents
	{
		performer = getDriver().findElement(By.xpath("//*[@id='DocumentShareListNew']"));
		return performer;
	}
	
	public static WebElement clickNew()					//Searching '+New' folder element
	{
		performer = getDriver().findElement(By.xpath("//*[@id='menu1']"));
		return performer;
	}
	
	public static WebElement clickNewFolder()			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAddNewFolder']"));
		return performer;
	}
	
	public static WebElement clickIsUniversal()			//Searching Input box to write folder name
	{
		performer = getDriver().findElement(By.xpath("//input[@id = 'ContentPlaceHolder1_chkIsUnivers']"));
		return performer;
	}
	
	public static WebElement writeFolderName()			//Searching Input box to write folder name
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']"));
		return performer;
	}
	
	public static WebElement clickCreate()				//Searching 'Create' button after writing folder name
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_btnCreateFolder1']"));
		return performer;
	}
	public static WebElement clickCreate1()				//Searching 'Create' button after writing folder name
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_btnCreateFolder']"));
		return performer;
	}
	
	public static WebElement readFolderMsg()			//Searching Message after creating folder.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']/ul/li"));
		return performer;
	}
	
	public static WebElement closeFolderPoppup()		//Closing Create folder pop up.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenNewFolderPopup']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement readFolderName()		//Searching first folder name
	{
		performer = getDriver().findElement(By.xpath("(//*[@align='left'])[1]"));
		return performer;
	}
	
	public static WebElement clickShareFolder()			//Searching Share Folder image
	{
		performer = getDriver().findElement(By.xpath("//*[@class='sharedrive']"));
		return performer;
	}
	
	public static WebElement clickPeople()				//Searching People input box 
	{
		performer = getDriver().findElement(By.xpath("//div[@id='divOpenPermissionPopup']//button[@title='None selected']"));
		return performer;
	}
	
	public static WebElement clickSearchPeople()		//Searching 'Search People' input box
	{
		performer = getDriver().findElement(By.xpath("//div[@class='btn-group open']//input[@placeholder='Type to Search for User..']"));
		return performer;
	}
	
	public static WebElement clickPeopleCheckBox()		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("(//label[@class='checkbox'][normalize-space()='CFO Finance'])[2]"));
		return performer;
	}
	public static WebElement clickPeopleCheckBoxSubFolder()		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("(//label[@class='checkbox'][normalize-space()='CFO Finance'])"));
		return performer;
	}
	public static WebElement clickpopup()		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]/div[1]/div"));
		return performer;
	}
	public static WebElement clickPeopleCheckBox1()		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("(//label[@class='checkbox'][normalize-space()='Akshay jadhav'])[2]"));
		return performer;
	}
	
	public static WebElement clickLabel()				//Searching label to click on it.
	{
		performer = getDriver().findElement(By.xpath("//*[@class='modal-header-custom']"));
		return performer;
	}
	
	public static WebElement clickDone()				//Searching 'Done' button
	{
		performer = getDriver().findElement(By.xpath("//*[@value='Share']"));
		return performer;
	}
	
	public static WebElement checkShared()				//Searching share file button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']"));
		return performer;
	}
	
	public static WebElement closeSharePoppup()			//Searching close share file poppup button.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement clickNewFile()				//Searching New File button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAddNewDocument']"));
		return performer;
	}
	
	public static WebElement uploadNewFile()			//Searching upload New File button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ContractFileUpload']"));
		return performer;
	}
	
	public static WebElement clickUploadDocument()		//Searching upload document button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnUploadDoc']"));
		return performer;
	}
	
	public static WebElement clickUserRole()			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[1]"));
		return performer;
	}
	
	public static List<WebElement> selectUserRole()		//Selecting third option 'Revise Compliance'
	{
		viewEvent = getDriver().findElements(By.xpath("//*[@id='dropdownlistUserRole-list']/div[2]/ul/li"));
		return viewEvent;
	}
	
	public static WebElement clickMoreActions()			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[5]"));
		return performer;
	}
	
	public static WebElement clickMoreActions1()			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[4]"));
		return performer;
	}
	
	public static List<WebElement> selectAction()		//Selecting third option 'Revise Compliance'
	{
		viewEvent = getDriver().findElements(By.xpath("//*[@id='dropdownlistMoreLink-list']/div[2]/ul/li"));
		return viewEvent;
	}
	
	public static WebElement clickAction()				//Searching first action button
	{
		performer = getDriver().findElement(By.xpath("(//a[contains(@id,'ContentPlaceHolder1_grdRviseCompliances_lnkReviseCompliances')])[1]"));
		return performer;
	}
	
	public static WebElement clickRemark()				//Searching 'Remark' textarea.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxRemarks']"));
		return performer;
	}
	
	public static WebElement upload1()					//Searching upload button in action
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_fuSampleFile']"));
		return performer;
	}
	
	public static WebElement clickInterest()			//Searching Interest input box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtInterest']"));
		return performer;
	}
	
	public static WebElement clickPenalty()				//Searching Penalty input box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtPenalty']"));
		return performer;
	}
	
	public static WebElement clickTaskAction()			//Clicking on action button (edit image)
	{
		performer = getDriver().findElement(By.xpath("(//input[contains(@id,'ContentPlaceHolder1_grdTaskPerformer_btnChangeStatus')])[1]"));
		return performer;
	}
	
	public static WebElement TaskUpload()				//Searching Upload button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='fuTaskDoc']"));
		return performer;
	}
	
	public static WebElement clickStatutoryRejected()	//Searching Statutory Reject value to click 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedPREOcount']"));
		return performer;
	}
	
	public static WebElement clickInternalRejected()	//Searching Internal Reject value to click
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedInternalPREOcount']"));
		return performer;
	}
	
	public static WebElement clickInternalRemark()		//Searching Remark text area.
	{
		performer = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks2']"));
		return performer;
	}
	
	public static WebElement clickMoreLink()			//Searching 'More Link' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddTaskDetails']"));
		return performer;
	}
	
	public static WebElement clickTaskDetails()			//Searching 'Task Details' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddTask']"));
		return performer;
	}
	
	public static WebElement clickAddNew1()				//Searching 'Add New' button.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return performer;
	}
	
	public static WebElement clickActFilter()			//Searching 'Act Filter' drop down.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAct']"));
		return performer;
	}
	
	public static WebElement clickComplianceDropDown()	//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompliance']"));
		return performer;
	}
	
	public static WebElement clickTaskTitle()			//Searching 'Task Title' text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtTaskTitle']"));
		return performer;
	}
	
	public static WebElement clickDescription()			//Searching 'Description' TextArea
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDescription']"));
		return performer;
	}
	
	public static WebElement clickDueDay()				//Searching Due Day text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDueDays']"));
		return performer;
	}
	
	public static WebElement clickTaskType()			//Searching Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAllTaskType']"));
		return performer;
	}
	
	public static WebElement clickSubTaskType()			//Searching Sub Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlSubTaskType']"));
		return performer;
	}
	
	public static WebElement clickIsAfter()				//Searching Is After/Before drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlIsAfter']"));
		return performer;
	}
	
	public static WebElement clickConditionCheckbox()	//Searching Condition CheckBox 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ChkIsTaskConditional']"));
		return performer;
	}
	
	public static WebElement clickConditionalMessage()	//Searching Condition CheckBox 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtConditionalMessage']"));
		return performer;
	}
	
	public static WebElement clickYesMsg()				//Searching Yes Message box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtYesMessage']"));
		return performer;
	}
	
	public static WebElement clickNoMsg()				//Searching No Message box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtNoMessage']"));
		return performer;
	}
	
	public static WebElement SampleFormUpload()
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_fuSampleFile']"));
		return performer;
	}
	
	public static WebElement taskSavedMsg()				//Searching element of Successful Save of task.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl03']"));
		return performer;
	}
	
	public static WebElement closeUpdateTasks()			//Searching cross to close the form
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement closeUpdateTasks1()			//Searching cross to close the form
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAssignmentDetailsDialog']/div/div/div[1]/button"));
		return performer;
	}
	
	public static List<WebElement> deleteTask()			//Searching element to delete the added task 
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_grdTask_lbtDelete')]"));
		return elementsList;
	}
	
	public static WebElement deleteMsg()				//Searching the msg element of Successful deletion
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl01']"));
		return performer;
	}
	
	public static List<WebElement> clickSubTask()		//Searching all subtask elements.
	{
		elementsList = getDriver().findElements(By.linkText("sub-tasks"));
		return elementsList;
	}
	
	public static WebElement clickAddNew2()				//Searching add new in Sub Task
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddSubTask']"));
		return performer;
	}
	
	public static WebElement selectAllCheckbox1()		//Searching 'Select All' checkbox in sub task
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rptTask_TaskSelectAll']"));
		return performer;
	}
	
	public static WebElement OK()						//Searching OK button
	{
		performer = getDriver().findElement(By.xpath("//*[@value='Ok']"));
		return performer;
	}
	
	public static WebElement clickTaskMapping()			//Searching 'Task Mapping' text box in Sub Task.
	{
		performer = getDriver().findElement(By.xpath("//*[@value='< Select Task >']"));
		return performer;
	}
	
	public static List<WebElement> clickAssignTask()	//Searching all Assign task buttons.
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_grdTask_LinkButton3')]"));
		return elementsList;
	}
	
	public static WebElement clickComplianceLocation()	//Searching Compliance Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return performer;
	}
	
	public static WebElement clickReportingLocation()	//Searching Reporting Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocationTask']"));
		return performer;
	}
	
	public static List<WebElement> clickSubLoacations()	//Searching Sub Loactions
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_tvFilterLocationTaskt')]"));
		return elementsList;
	}
	
	public static WebElement clickStartDate()			//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxStartDate']"));
		return performer;
	}
	
	public static WebElement clickStartDate1()			//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtStartDate']"));
		return performer;
	}
	
	public static WebElement clickEndDate()				//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtEndDate']"));
		return performer;
	}
	
	public static WebElement clickSelectPerformer()		//Searching Performers drop down
	{
		performer = getDriver().findElement(By.xpath("//div[contains(@id,'ContentPlaceHolder1_ddlPerformer')]"));
		return performer;
	}
	
	public static WebElement clickSelectReviewer()		//Searching reviewers drop down
	{
		performer = getDriver().findElement(By.xpath("//div[contains(@id,'ContentPlaceHolder1_ddlReviewer')]"));
		return performer;
	}
	
	public static WebElement checkRecordsTable()		//Searching assigned data table
	{
		performer = getDriver().findElement(By.xpath("//*[@class='clsROWgrid']"));
		return performer;
	}
	
	public static WebElement checkRecordsTable1()		//Searching assigned data table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_GrdAssigment']/tbody/tr[2]"));
		return performer;
	}
	
	public static WebElement clickSearchedUser1()		//Searching searched user
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-option-array-index='1'])[1]"));
		return performer;
	}
	
	public static WebElement clickSearchedUser2()		//Searching searched user
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-option-array-index='1'])[2]"));
		return performer;
	}
	
	public static WebElement clickSaveButton1()			//Searching Save button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSaveTaskAssignment']"));
		return performer;
	}
	
	public static WebElement SelectCheckBox()			//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn2CheckBox']"));
		return performer;
	}
	
	public static WebElement clickMainTaskLink()		//Searching Main Task link to go back from Sub Task
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_dlBreadcrumb']"));
		return performer;
	}
	
	public static WebElement clickInternaRadioButton()	//Searching radio button for Internal Tasks
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoInternal']"));
		return performer;
	}
	
	public static WebElement clickInternalCompliance()	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlInternalCompliance']"));
		return performer;
	}
	
	public static WebElement selectAllCheckbox()		//Searching 'Select All' checkbox
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdGstMappedCompliance_chkComplianceAll']"));
		return performer;
	}
	
	public static WebElement selectNewPerformer()		//Searching new Performer drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsers']"));
		return performer;
	}
	
	public static WebElement selectNewReviewer()		//Searching new Reviewer drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsers']"));
		return performer;
	}
	
	public static WebElement selectNewEventOwner()		//Searching new Event Owner drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewEventOwnerUsers']"));
		return performer;
	}
	
	public static WebElement progressGIF()				//Searching Progress GIF Loading image
	{
		performer = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return performer;
	}
	
	public static WebElement readMsgLeave()				//Searching Message after Save
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_VDS']"));
		return performer;
	}
	
	public static WebElement closeLeave()				//Searching cross to close window
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divLeaveDialog']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement clickUpcomingStatutory()	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divupcomingPREOcount']"));
		return performer;
	}
	
	public static WebElement clickUpcomingInternal()	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divupcomingInternalPREOcount']"));
		return performer;
	}
	
	public static WebElement checkTable()				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']"));
		return performer;
	}
	
	public static List<WebElement> readStatus()			//Searching all Upcoming status
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[8]"));
		return elementsList;
	}
	
	public static WebElement fileUploadUpcoming()		//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='FileUpload1']"));
		return upload;
	}
	
	public static WebElement clickShow()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return performer;
	}
	
	public static WebElement ClickTaskCreation()		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liTaskCreation']"));
		return performer;
	}
	
	public static WebElement clickMyWorkspace2()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'leftworkspacemenuLic']/a"));
		return performer;
	}
	
	public static WebElement ComplianceDocumentLink	()				//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_TxtComplianceDocument']"));
		return performer;
	}
	
	public static WebElement PenaltyRemark()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_txtremark']"));
		return performer;
	}
	
	public static WebElement sletre()					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletlere()				//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletre()					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement sledtre()					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletldere()				//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletdre()					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
/*	public static void MyReminder(, ExtentTest test, String compliance) throws InterruptedException
	{
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 60);
		WebgetDriver()Wait wait1 = new WebgetDriver()Wait(getDriver(), 120);
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickMyReminder(getDriver())));
		//Actions action = new Actions(getDriver());
		//action.moveToElement(clickMyReminder(getDriver())).click().perform();	//Clicking on 'My Reminder'
		clickMyReminder(getDriver()).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(clickComplianceType(getDriver())));
		clickComplianceType(getDriver()).click();
		Thread.sleep(500);
		if(compliance.equalsIgnoreCase("Internal"))
		{
			clickInternalCheckbox(getDriver()).click();
		}
		else
		{
			clickStatutoryCheckbox(getDriver()).click();
		}
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getgetDriver()();
		js.executeScript("window.scrollBy(0,1000)");
		
		wait1.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.readTotalItems1()));
		CFOcountPOM.readTotalItems1().click();
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");							//Splitting the String
		String remindersCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		for(int i = 0; i <= 1; i++)
		{
			if(remindersCount.equalsIgnoreCase("to"))
			{
				js.executeScript("window.scrollBy(0,1000)");
				try
				{			//Waiting till the grid's second row's fifth column data gets clickable.
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[5]")));
				}
				catch(Exception e)
				{
					
				}
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");									//Splitting the String
				remindersCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		
		int count = Integer.parseInt(remindersCount);				//Reading number of records.
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(500);
		clickAddNewReminder(getDriver()).click();								//Clicking on 'Add New' button 
		
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		wait.until(ExpectedConditions.visibilityOf(selectComplianceType1(getDriver())));
		
		if(compliance.equalsIgnoreCase("Internal"))
		{
			selectComplianceType1(getDriver()).click();				//Clicking on 'Compliance Type' drop down 
			Thread.sleep(500);
			selectInternalType(getDriver()).click();					//Clicking on 'Internal' menu.
			Thread.sleep(1500);
		}
		
		Thread.sleep(1000);
		clickLocation(getDriver()).click();							//Clicking on 'Location' drop down
		Thread.sleep(500);
		elementsList = selectLocation1(getDriver());
		elementsList.get(2).click();							//Selecting third menu from drop down.
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(clickCompliance1(getDriver())));
		clickCompliance1(getDriver()).click();						//Clicking on 'Compliance' drop down
		elementsList = selectCompliance1(getDriver());
		elementsList.get(1).click();							//Selecting second menu from drop down.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		clickRole(getDriver()).click();								//Clicking on 'Role' drop down.
		elementsList = selectRole1(getDriver());
		elementsList.get(1).click();							//Selecting second menu from drop down.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		selectDateStatutory(getDriver()).click();					//Clicking on 'Date' input box
		Thread.sleep(300);
		selectNextMonth(getDriver()).click();						//Clicking on Next month arrow on calendar
		Thread.sleep(300);
		selectDate(getDriver()).click();								//Clicking on date at second row and fourth column
		
		Thread.sleep(500);
		clickSaveButton(getDriver()).click();						//Clicking 'Save' button.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		String actualMsg = readReminderMsg1(getDriver()).getText();	//Reading Message after Save
		String expectedMsg1 = "Reminder Saved Sucessfully.";	//Expected message
		
		getDriver().switchTo().parentFrame();
		closeReminder(getDriver()).click();							//Closing the Reminder popped window
		
		test.log(LogStatus.INFO, actualMsg);
		
		Thread.sleep(1000);
		getDriver().navigate().refresh();
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOf(clickComplianceType(getDriver())));
		wait.until(ExpectedConditions.elementToBeClickable(clickComplianceType(getDriver())));
		clickComplianceType(getDriver()).click();
		Thread.sleep(500);
		if(compliance.equalsIgnoreCase("Internal"))
		{
			clickInternalCheckbox(getDriver()).click();
		}
		else
		{
			clickStatutoryCheckbox(getDriver()).click();
		}
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
				
		js.executeScript("window.scrollBy(0,1000)");
		
		wait1.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.readTotalItems1()));
		CFOcountPOM.readTotalItems1().click();
		item = CFOcountPOM.readTotalItems1().getText();
		bits = item.split(" ");							//Splitting the String
		remindersCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		for(int i = 0; i <= 1; i++)
		{
			if(remindersCount.equalsIgnoreCase("to"))
			{
				js.executeScript("window.scrollBy(0,1000)");
				try
				{			//Waiting till the grid's second row's fifth column data gets clickable.
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[5]")));
				}
				catch(Exception e)
				{
					
				}
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");									//Splitting the String
				remindersCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		
		int count1 = Integer.parseInt(remindersCount);				//Reading number of records.
		
		if(actualMsg.equalsIgnoreCase(expectedMsg1))
		{
			if(count < count1)
			{
				test.log(LogStatus.PASS, compliance + " - Reminder count updated. Old count = "+count+" New count = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " - Reminder count doesn't updated. Old count = "+count+" New count = "+count1);
			}
		}
		else
		{
			if(count == count1)
			{
				test.log(LogStatus.PASS, compliance + " - Reminder count doesn't updated. Old count = "+count+" New count = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " - Reminder count updated. Old count = "+count+" New count = "+count1);
			}
		}
		Thread.sleep(500);
		OverduePOM.clickDashboard(getDriver()).click();
	}
	
	public static void CriticalDocuments(, ExtentTest test) throws InterruptedException
	{
		Thread.sleep(1000);
		clickMyDocuments(getDriver()).click();					//Clicking on 'My Documents'
		
		Thread.sleep(500);
		clickCriticalDocuments(getDriver()).click();				//Clicking on 'Critical Documents'
		
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
		
		Thread.sleep(500);
		String name = readFolderName(getDriver()).getText();		//Reading the folder name to create new folder.
		
		String folder = name+"T"; 
		
		clickNew(getDriver()).click();							//Clicking on '+New' button.
		
		Thread.sleep(300);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		clickNewFolder(getDriver()).click();						//Clicking on 'New Folder'
		
		Thread.sleep(300);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(300);
		clickIsUniversal(getDriver()).click();
		
		Thread.sleep(300);
		writeFolderName(getDriver()).sendKeys(folder);			//Writing Folder name.
		
		Thread.sleep(500);
		clickCreate(getDriver()).click();						//Clicking on create button.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		String msg = getDriver().switchTo().alert().getText();
		test.log(LogStatus.INFO, msg);
		Thread.sleep(300);
		getDriver().switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		name = readFolderName(getDriver()).getText();				//Reading the folder name we had created
		
		if(folder.equalsIgnoreCase(name))
		{
			test.log(LogStatus.PASS, "Created folder '"+folder+"' displayed in the records.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Created folder '"+folder+"' doesn't displayed in the records.");
		}
		
		Thread.sleep(500);
		readFolderName(getDriver()).click();						//Clicking on folder name we had created.
		Thread.sleep(500);
		readFolderName(getDriver()).click();						//Clicking on folder name we had created.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNew(getDriver())));
		clickNew(getDriver()).click();							//Clicking on 'New'
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		//Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNewFile(getDriver())));
		clickNewFile(getDriver()).click();						//CLicking on 'New File'
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		String workingDir = System.getProperty("user.dir");
		uploadNewFile(getDriver()).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickUploadDocument(getDriver())));
		clickUploadDocument(getDriver()).click();				//Clicking on 'Upload Document'
		
		Thread.sleep(100);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		if(readFolderName(getDriver()).isDisplayed())			//Checking if file got created or not.
			test.log(LogStatus.PASS, "Uploaded file displayed.");
		else
			test.log(LogStatus.PASS, "Uploaded file does not displayed.");
		
		readFolderName(getDriver()).click();						//Clicking on file we had uploaded.
				
		Thread.sleep(500);
		clickShareFolder(getDriver()).click();					//Clicking on Share Folder image.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickPeople(getDriver())));
		clickPeople(getDriver()).click();						//Clicking on People drop down 
		clickSearchPeople(getDriver()).click();					//Clicking on Search People drop down.
		
		Thread.sleep(500);
		clickSearchPeople(getDriver()).sendKeys("amol");			//Writing user name to search for
		
		Thread.sleep(500);
		clickPeopleCheckBox(getDriver()).click();				//Clicking on label to get out from people search box
		
		Thread.sleep(500);
		clickDone(getDriver()).click();							//Clicking on 'Done' to share folder.
		
		Thread.sleep(500);
		readFolderName(getDriver()).click();						//Clicking on file name we had uploaded.
		
		Thread.sleep(500);
		clickShareFolder(getDriver()).click();					//Clicking on Share File image.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
		
		//Thread.sleep(1000);
		if(checkShared(getDriver()).isDisplayed())				//Checking if folder gor shared or not.
			test.log(LogStatus.PASS, "Uploaded file shared.");
		else
			test.log(LogStatus.PASS, "Uploaded file does not shared.");
		
		Thread.sleep(500);
		closeSharePoppup(getDriver()).click();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(getDriver())));
		OverduePOM.clickDashboard(getDriver()).click();			//Clicking on Dashboard
	}

	public static void ReviseCompliance(, ExtentTest test, int no) throws InterruptedException
	{
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 60);
		
		Thread.sleep(1500);
		Actions action = new Actions(getDriver());
		//action.moveToElement(clickMyWorkspace1(getDriver())).click().perform();
		clickMyWorkspace(getDriver()).click();				//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		clickCompliance(getDriver()).click();				//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		clickMoreActions(getDriver()).click();				//Clicking on 'More Actions' drop down.
		Thread.sleep(300);
		elementsList = selectAction(getDriver());			//Clicking on drop down option
		elementsList.get(no).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(readReminder(getDriver())));
		
		int complianceCount = Integer.parseInt(readReminder(getDriver()).getText());		//Reading total number of compliances before action
				
		String compliance = null;
		if(no == 1)
		{
			compliance = "Update Penalty";
			
			action.moveToElement(clickAction(getDriver())).click().perform();
			
			Thread.sleep(1000);
			clickInterest(getDriver()).sendKeys("100");
			
			Thread.sleep(500);
			clickPenalty(getDriver()).sendKeys("50000");
			
			Thread.sleep(500);
			PenaltyRemark(getDriver()).sendKeys("Automation Testing");
			
			Thread.sleep(500);
		}
		if(no == 2)
		{
			compliance = "Revised Compliance";
			action.moveToElement(clickAction(getDriver())).click().perform();
			
			Thread.sleep(1500);
			wait.until(ExpectedConditions.elementToBeClickable(clickDate(getDriver())));
			clickDate(getDriver()).click();								//Clicking on Revise Date.
			
			Thread.sleep(500);
			selectLastMonth(getDriver()).click();
			Thread.sleep(700);
			selectDate(getDriver()).click();								//Selecting second row fourth date.
			
			Thread.sleep(500);
			clickRemark(getDriver()).sendKeys("Automation Testing");		//Sending remark to Text area.
			
			Thread.sleep(500);
			ComplianceDocumentLink(getDriver()).sendKeys("www.google.com");
			
			Thread.sleep(500);
			String workingDir = System.getProperty("user.dir");			
			upload1(getDriver()).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(clickSaveButton(getDriver())));
		clickSaveButton(getDriver()).click();							//Clicking on save button
		
		Thread.sleep(1000);
		int complianceCountNew = Integer.parseInt(readReminder(getDriver()).getText());		//Reading total number of compliances after action
		
		if(complianceCountNew < complianceCount)
			test.log(LogStatus.PASS, compliance + " - Compliances count decreased. Old count = "+complianceCount+" | New count = "+complianceCountNew);
		else
			test.log(LogStatus.FAIL, compliance + " - Compliances count doesn't decreased. Old count = "+complianceCount+" | New count = "+complianceCountNew);
	}*/
}
