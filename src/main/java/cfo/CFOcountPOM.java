package cfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;
import cfo.OverduePOM;

public class CFOcountPOM extends BasePage
{
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement categories = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;		//WebElement variable created for 'Compliances' read and click
	private static WebElement compliancesItomsCount = null;		//WebElement variable created for reading Items count after Compliances click
	private static WebElement users = null;						//WebElement variable created for 'Users' read and click
	private static WebElement penalty = null;					//WebElement variable created for 'Penalty' read and click
	private static List<WebElement> interestList = null;		//WebElement variable created for reading each interest.
	private static List<WebElement> penaltyList = null;			//WebElement variable created for reading each interest.
	private static WebElement nextPage = null;					//WebElement variable created for clicking on next page arrow.
	private static WebElement piechart = null;					//WebElement variable created for piechart elements. 
	private static List<WebElement> select = null;				//WebElement variable created for piechart elements.
	private static WebElement bargraph = null;					//WebElement variable created for bargraph elements.
	private static WebElement risksummary = null;				//WebElement variable created for Risk Summary elements.
	private static WebElement refresh = null;					//WebElement variable created for Refreshing web page.
	private static WebElement department = null;				//WebElement variable created for Department Summary elements. 
	private static WebElement penlatysummary = null;			//WebElement variable created for Penalty Summary elements.
	private static WebElement Internal = null;					//WebElement variable created for Internal Compliances Dashboard.
	private static WebElement grading = null;					//WebElement variable created for Grading Report elements.
	private static List<WebElement> totalRecords = null; 		//WebElement variable created for calculating total records displayed in Grading Report 
	private static WebElement calendar = null;					//WebElement variable created for Grading Report elements.
	private static WebElement reports = null;					//WebElement variable created for Reports elements.
	private static List<WebElement> menus = null; 				//WebElement variable created for sub menu elements.
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	private static List<WebElement> elementsList2 = null;
	
	public static WebElement clickCategories()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divFunctionCount']"));
		return categories;
	}
	
	public static WebElement readCompliances()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement readCompliancesInternal()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_divUniqueCompliancesCount']"));
		return compliances;
	}
	
	public static List<WebElement> readCompliancesList()	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = getDriver().findElements(By.xpath("//*[contains(@onclick,'openpopup')]"));
		return compliancesList;
	}
	
	public static WebElement closeCategories()				//Closing Categories pop up.
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
		return categories;
	}
	
	public static WebElement closePopup()				//Closing Categories pop up.
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divGRreports']/div/div/div[1]/button"));
		return categories;
	}
	
	public static WebElement closeCategories_Compliances()	//Closing Compliances pop up opened within Categories pup up.
	{
		categories = getDriver().findElement(By.xpath("//div[@id='divApiOverView']/div/div/div[1]/button"));
		return categories;
	}
	
	public static WebElement readCompliancesItems()			//Method for read total items in Compliances.
	{
		compliancesItomsCount = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return compliancesItomsCount;
	}
	
	public static WebElement clickUsersCount()				//Method to search 'Users' image link to click on 
	{
		users = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divUsersCount']"));
		return users;
	}
	
	public static WebElement readUsersCount()				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@id='grid']/div[5]/span"));
		return users;
	}
	
	public static WebElement readUsersCount1()				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return users;
	}
	
	public static WebElement readUsersCount2()				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@class = 'k-pager-info k-label']"));
		return users;
	}
	
	public static WebElement readPenaltyCount()				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPenalty']"));
		return penalty;
	}
	
	public static WebElement clickInterest()
	{
		penalty = getDriver().findElement(By.xpath("//li[@id='liGraph']"));
		return penalty;
	}
	
	public static List<WebElement> readInterest()			//Method to read all interests in Penalty.
	{
		interestList = getDriver().findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return interestList;
	}
	
	public static List<WebElement> readPenalty()			//Method to read all penalties in Penalty.
	{
		penaltyList = getDriver().findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return penaltyList;
	}
	
	public static WebElement loadGrid()
	{
		penalty = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']"));
		return penalty;
	}
	
	public static WebElement ClearButton()
	{
		penalty = getDriver().findElement(By.xpath("//*[@id = 'ClearfilterMain']"));
		return penalty;
	}
	
	public static WebElement clickNextPage()				//Method to search next page arrow button.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/a[3]/span"));
		return nextPage;
	}
	
	public static List<WebElement> checkTotalIndexes()				//Method to search next page arrow button.
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class = 'k-pager-numbers k-reset']/li"));
		return elementsList;
	}
	
	public static WebElement clickNextPage1()				//Method to search next page arrow button.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@title='Go to the next page']"));
		return nextPage;
	}
	
	public static WebElement readTotalItems()				//Method to read all items in Penalty click.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return nextPage;
	}
	
	public static WebElement clickNotCompleted()			//Method to search Not Completed count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotCompletedInternal()			//Method to search Not Completed count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickAfterDueDate()			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayed()			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayedInternal()			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickInTime()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedTimely()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedTimelyInternal()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicable()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicableInternal()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement readCritical()						//Method to read High risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		return piechart;
	}
	
	public static WebElement readHigh()					//Method to read Medium risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return piechart;
	}
	
	public static WebElement readMedium()						//Method to read Low risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
		return piechart;
	}
	
	public static WebElement readLow()						//Method to read Low risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
		return piechart;
	}
	
	public static List<WebElement> selectDropdown()			//Method to search drop downs in Not Completed click
	{
		select = getDriver().findElements(By.xpath("//*[@class='k-multiselect-wrap k-floatwrap']"));
		return select;
	}
	
	public static WebElement selectFirst()					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//*[contains(text(),'BITA Consulting Private Limited')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement selectFirst1()					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//*[contains(text(),'ABCD Pvt Ltd')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement selectfirst()
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='k-in k-state-selected']"));
		return piechart;
	}
	
	public static WebElement readTotalItems1()				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return piechart;
	}
	public static WebElement readTotalItems2()				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[2]"));
		return piechart;
	}
	public static WebElement readcalenderCount()				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return piechart;
	}
	
	
	public static WebElement clickBack1()
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[2]"));
		return piechart;
	}
	
	public static WebElement clickLabourCritical()			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[5]"));
		return bargraph;
	}
	
	public static WebElement clickLabourHigh()				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[11]"));
		return bargraph;
	}
	
	public static WebElement clickLabourMedium()			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[17]"));
		return bargraph;
	}
	
	public static WebElement clickLabourMedium1()			//Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[15]"));
		return bargraph;
	}
	
	public static WebElement clickLabourLow()				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[23]"));
		return bargraph;
	}
	
	public static WebElement clickLabourLow1()				//Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return bargraph;
	}
	
	public static WebElement clickBarInTime()				//Method to search Labour In Time compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedTimely()				//Method to search Labour In Time compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarAfterDueDate()			//Method to search Labour After Due Date compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedDelayed()			//Method to search Labour After Due Date compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotCompleted()			//Method to search Labour Not Completed compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotApplicable()			//Method to search Labour Not Completed compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return bargraph;
	}
	
	public static WebElement clickBack()					//Method to search Back button of Completion Status Bar Graph
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[3]"));
		return bargraph;
	}
	
	public static WebElement clickView()					//Method to search View button of document to view
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement closeDocument()				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		return bargraph;
	}
	
	public static WebElement downloadDocument()				//Method to search download button of first document. 
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-download k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement clickRiskCriticalNotCompleted()	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalClosedDelayed()	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalClosedTimely()	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompleted()	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighAfterDueDate()	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayed()	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighInTime()			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedTimely()			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompleted()	//Method to search 'Medium Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumAfterDueDate()	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayed()	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumInTime()		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedTimely()		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowNotCompleted()		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowAfterDueDate()		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayed()		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowInTime()			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimely()			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;
	}
	
	public static WebElement clickRefresh()					//Method to search 'Refresh' button on the web page.
	{
		refresh = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_btnRefresh1']"));
		return refresh;
	}
	
	public static WebElement clickDepartmentHighHuman()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	public static WebElement clickAdminNotComplInternal()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[53]"));
		return department;
	}
	
	public static WebElement clickBTRNotComplInternal()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[56]"));
		return department;
	}
	
	public static WebElement clickDSSNotComplInternal()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[57]"));
		return department;
	}
	
	public static WebElement clickHumanClosedDelayed()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	public static WebElement clickHumanClosedTimely()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return department;
	}
	
	public static WebElement clickHumanOverdue()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[41]"));
		return department;
	}
	
	public static WebElement clickHumanPendingReview()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[47]"));
		return department;
	}
	
	public static WebElement clickHumanNotApplicable()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[53]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman1()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[32]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman2()		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman()	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman1()	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[41]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman2()	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[29]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman()		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman1()		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[50]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman2()		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[33]"));
		return department;
	}
	
	public static WebElement clickDepartmentInTime()		//Method to search 'In Time' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return department;
	}
	
	public static WebElement clickDepartmentAfterDueDate()	//Method to search 'After Due Date' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return department;
	}
	
	public static WebElement clickDepartmentNotCompleted()	//Method to search 'Not Completed' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return department;
	}
	
	public static WebElement clickDepartmentBack()			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[5]"));
		return department;
	}
	
	public static WebElement clickPenaltyCritical()		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[27]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHigh()		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[31]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril()		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[27]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril1()		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[58]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril2()		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMedium()		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[35]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril()		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril1()		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[60]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril2()		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLow()			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril()			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril1()			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[62]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril2()			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[42]"));
		return penlatysummary;
	}
	
	public static WebElement selectInternal()				//Method to search Dropdown box to click on Internal in filters
	{
		Internal = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlStatus']"));
		return Internal;
	}
	
	public static WebElement clickApply()					//Method to search Apply button after clicking on Internal in filters dropdown
	{
		Internal = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnTopSearch']"));
		return Internal;
	}
	
	public static WebElement clickBSEHighInternal()			//Searching 'High' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return Internal;
	}
	
	public static WebElement clickBSEMediumInternal()		//Searching 'Medium' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return Internal;
	}
	
	public static WebElement clickBSELowInternal()			//Searching 'Low' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[10]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccHigh()		//Searching 'High' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[22]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccMedium()		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccLow()		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return Internal;
	}
	
	public static List<WebElement> readCategoriesList()		//Method to read all interests in Penalty.
	{
		interestList = getDriver().findElements(By.xpath("//*[@onclick='window.parent.fCompliancesRahul();']"));
		return interestList;
	}
	
	public static List<WebElement> clickExpandGrading()				//Method to search second red box of Grading Report
	{
		interestList = getDriver().findElements(By.xpath("//*[@class='tree-icon tree-closed']"));
		return interestList;
	}
	
	public static WebElement clickRedGrading()				//Method to search second red box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating3'])[2]"));
		return grading;
	}
	
	public static WebElement clickYellowGrading()			//Method to search first yellow box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating2'])[1]"));
		return grading;
	}
	
	public static WebElement clickGreenGrading()			//Method to search first green box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating1'])[1]"));
		return grading;
	}
	
	public static WebElement clickDropdown()				//Searching dropdown in Grading Report
	{
		grading = getDriver().findElement(By.xpath("//select[@name='ddlPageSize']"));
		return grading;
	}
	
	public static WebElement readTotalPagesGrading()		//Searching total pages count element
	{
		grading = getDriver().findElement(By.xpath("//span[@id='lTotalCount']"));
		return grading;
	}
	
	public static WebElement clickNextArrow()				//Searching next page arrow button in Grading Report
	{
		grading = getDriver().findElement(By.xpath("//input[@id='lBNext']"));
		return grading;
	}
	
	public static List<WebElement> countRecordsGrading()	//Searching all serial numbers to count total records. 
	{
		totalRecords = getDriver().findElements(By.xpath("//*[@align='center']"));
		return totalRecords;
	}
	
	public static WebElement clickDetailsGrading()			//Searching 'Details' link to click
	{
		grading = getDriver().findElement(By.xpath("//a[@id='lnkDetails']"));
		return grading;
	}
	
	public static WebElement clickGraphGrading()			//Searching all values inside each bar of graph.
	{
		grading = getDriver().findElement(By.xpath("//li[@id='liGraph']"));
		return grading;
	}
	
	public static List<WebElement> readGraphCount()			//Searching all the values inside each bar.
	{
		totalRecords = getDriver().findElements(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined ']"));
		return totalRecords; 
	}
	
	public static WebElement readDateComliance()			//Searching the cornered value of the Red date
	{
		calendar = getDriver().findElement(By.xpath("(//*[@class='badge badge-warning overdue'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar()			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("(//div[@class='day sat past active'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar2()			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("(//*[@data-day='1'])[1]"));
		return calendar;
	}
	
	public static WebElement clickCalendarProgress()			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("//*[@id='imgcaldate']"));
		return calendar;
	}
	
	public static List<WebElement> clickDateCalendar1()		//CLicking the date on the calendar(first date of Red colour)
	{
		elementsList = getDriver().findElements(By.xpath("(//*[@style='background-color: rgb(255, 0, 0);'])[1]"));
		return elementsList;
	}
	
	public static WebElement clickAllChecklist()			//Searching "All(Including Checklist)" radio button
	{
		calendar = getDriver().findElement(By.xpath("//label[@for='ContentPlaceHolder1_rdbcalender_1']"));
		return calendar;
	}
	
	public static WebElement clickReports()					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return reports;
	}
	
	public static WebElement clickDetailedReport()			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return reports;
	}
	
	public static WebElement clickComplianceDropDown()		//Searching the Compliance drop down
	{
		reports = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[2]"));
		return reports;
	}
	
	public static List<WebElement> selectComplianceMenus()	//Searching all sub menus of Compliance Dropdown
	{
		menus = getDriver().findElements(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li"));
		return menus;
	}
	
	public static WebElement clickMonthDropDown()			//Searching Month dropdown
	{
		reports = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return reports;
	}
	
	public static WebElement clickAllMonths()				//Selecting 'All' for  Month Dropdown
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownlistTypePastdata_listbox']/li[5]"));
		return reports;
	}
	
	public static WebElement selectDropDownMenu()			//Searching Expanding arrow under dropdown box
	{
		reports = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]"));
		return reports;
	}
	
	public static WebElement selectMenu()					//Searching the 18th checkbox to select
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[18]"));
		return reports;
	}
	
	public static WebElement selectMenu1()					//Searching the 15th checkbox to select
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));
		return reports;
	}
	
	public static WebElement clickLastPageArrow()			//Method to search arrow button to get last page
	{
		reports = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-arrow-end-right']"));
		return reports;
	}
	
	public static WebElement clickExportImage()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='export']"));
		return reports;
	}
	
	public static WebElement clickAssignmentReport()		//Searching 'Assignment Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport1']"));
		return reports;
	}
	
	public static WebElement clickDropDown1()				//Searching Entity DropDown in Assignment Report
	{
		reports = getDriver().findElement(By.xpath("//*[@class='txtbox']"));
		return reports;
	}
	
	public static WebElement clickEntity()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/div"));
		return reports;
	}
	
	public static WebElement clickExpand()
	{
		reports = getDriver().findElement(By.xpath("//*[@data-role='treeview']/ul/li/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType()				//Searching Entity DropDown in Assignment Report
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType2()
	{
		reports = getDriver().findElement(By.xpath("(//*[@id='example']/div[1]/div/div)[1]"));
		return reports;
	}
	
	public static List<WebElement> clickType2()
	{
		menus = getDriver().findElements(By.xpath("//div[@class = 'k-widget k-treeview']/ul/li"));
		return menus;
	}
	
	public static List<WebElement> clickSubMenu()			//Searching first menu in Entity DropDown in Assignment Report
	{
		menus = getDriver().findElements(By.xpath("//*[@class='ContentPlaceHolder1_tvFilterLocation_2']"));
		return menus;
	}
	
	public static List<WebElement> clickDropDown2()			//Searching for dropdown of 'No of Records' and 'Compliances'
	{
		menus = getDriver().findElements(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return menus;
	}
	
	public static WebElement clickShowDropDown()		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return reports;
	}
	
	public static WebElement clickAllDropDown()		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_ddlStatus']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu1()		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt1']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu2()		//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt2']"));
		return reports;
	}
	
	public static WebElement clickApply1()					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Apply']"));
		return reports;
	}
	
	public static WebElement clickApply3()					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSearchPenalty']"));
		return reports;
	}
	
	public static WebElement readTotalPages() 				//Method to search Total pages count string
	{
		reports = getDriver().findElement(By.xpath("//span[@id='ContentPlaceHolder1_lTotalCount']"));
		return reports;
	}
	
	public static WebElement readTotalPages1() 				//Method to search Total pages count string
	{
		reports = getDriver().findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return reports;
	}
	
	public static WebElement clickNextButton()				//Method to click on 'Next Button' arrow
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_lBNext']"));
		return reports;
	}
	
	public static WebElement clickExport1()					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
		return reports;
	}
	
	public static WebElement clickExportExcel()					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return reports;
	}
	
	public static WebElement clickUsageReport()				//Searching 'Usage Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport2']"));
		return reports;
	}
	
	public static WebElement clickStartDate()				//Searching Start Date input box
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtStartDate']"));
		return reports;
	}
	
	public static WebElement clickEndDate()					//Searching End Date input box
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtEndDate']"));
		return reports;
	}
	
	public static WebElement clickExport()					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Export To Excel']"));
		return reports;
	}
	
	public static WebElement clickAuditReport()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Auditreport']"));
		return reports;
	}
	
	public static WebElement clickEntityDropdown()
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return reports;
	}
	
	public static WebElement clickExportReport()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddNew']"));
		return reports;
	}
	
	public static List<WebElement> getVendorNames()
	{
		menus = getDriver().findElements(By.xpath("//*[@data-placement='bottom']"));
		return menus;
	}
	
	public static WebElement clickInternalSubmenu3()	//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt7']"));
		return reports;
	}
	
	public static WebElement clickAllYear()			//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rbFinancialYearFunctionSummery_2']"));
		return reports;
	}
	
	public static WebElement waitProgress()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/div/div[1]"));
		return reports;
	}
	
	public static WebElement selectInternal1()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickType()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports; 
	}
	
	public static WebElement selectType1()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickFirstEntity()
	{
		reports = getDriver().findElement(By.xpath("//*[contains(@id,'tv_active')]/div/span[2]/span"));
		return reports; 
	}
	
	public static WebElement clickPenaltyYear()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFinancialYear']"));
		return reports; 
	}
	
	public static WebElement clickYear()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlYearGrading']"));
		return reports; 
	}
	
	public static WebElement clickApply2()
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnGradingSearch']"));
		return reports; 
	}
	
	public static WebElement clickComplianceType()
	{
		reports = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownlistComplianceType_listbox']"));
		return reports; 
	}
	
	public static WebElement selectTypeInternal()
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return reports; 
	}
	
	public static WebElement selectMonth()
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[3]"));
		return reports; 
	}
	
	public static WebElement clickTpes1()
	{
		reports = getDriver().findElement(By.xpath(""));
		return reports; 
	}
	
	public static WebElement clickTyeps1()
	{
		reports = getDriver().findElement(By.xpath(""));
		return reports; 
	}
	
	/*public static void CountGrading( ExtentTest test, String Risk) throws InterruptedException, IOException
	{
		WebDriver wait = new WebDriver()Wait(getDriver(), 60);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Switching to iFrame.
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='k-grid-content k-auto-scrollable']")));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,400)");
		Actions action = new Actions(getDriver());
		action.moveToElement(CFOcountPOM.readTotalItems1(getDriver())).click().perform();		//clicking on total pages count to scroll window down
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems1(getDriver()).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		for(int i = 0; i <= 3; i++)
		{
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				Thread.sleep(2500);
				s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		int count = Integer.parseInt(itomsCount);
		js.executeScript("window.scrollBy(0,-300)");
		
		File dir = new File("//home//ashitosh-avantis//Downloads//");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("//home//ashitosh-avantis//Downloads//");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, Risk+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, "Total records count displayed on grid matches with the number of records in the Excel Report.");
				test.log(LogStatus.INFO, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.PASS, "Total records count displayed on grid doesn't matches with the number of records in the Excel Report.");
				test.log(LogStatus.INFO, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.PASS, Risk+" :- File didn't downloaded successfully.");
		}
		
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closePopup(getDriver()).click();
	}
	
	public static void CountPenalty( ExtentTest test, int valuePenalty) throws InterruptedException
	{
		int interest = 0;					//Variable created for reading Interest
		int penalty1 = 0;						//Variable created for reading Penalty
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 2000 px.
		CFOcountPOM.clickNextPage1(getDriver()).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItems1(getDriver()).click();
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		int count = 0;
		int loop = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If items not found
		{
			for(int i = 0; i < 4; i++)
			{
				Thread.sleep(2000);
				s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();
				bits = s1.split(" ");									//Splitting the String
				itomsCount = bits[bits.length - 2];
				if(!itomsCount.equalsIgnoreCase("to"))					//If not items found
				{
					break;
				}
			}
		}
		count = Integer.parseInt(itomsCount);
		loop = count / 10;									//Dividing by 10, as total number of items in a list is 10
		
		int n2 = 0;
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList2 = CFOcountPOM.readPenalty(getDriver());			//Searching all values of Penalty
			n2 = elementsList2.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1(getDriver()).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(50);			
			for(int i = 0; i < n2; i++)
			{
				action.moveToElement(elementsList2.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList2.get(i).getText());	//Reading each Compliance value.
				penalty1 = penalty1 + j;										//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1(getDriver()).isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItems1(getDriver()).click();				//Clicking to escape unwanted tooltips
				CFOcountPOM.clickNextPage1(getDriver()).click();
			}
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(1000,0)");						//Scrolling Up window by 2000 px.
		CFOcountPOM.clickInterest(getDriver()).click();						//Clicking on 'Interest' link/menu.
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
		
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.loadGrid(getDriver())));	//Wait until the Interest Values displays
		Thread.sleep(100);
		CFOcountPOM.ClearButton(getDriver()).sendKeys(Keys.PAGE_DOWN);
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2000 px.
		
		Thread.sleep(1000);
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList1 = CFOcountPOM.readInterest(getDriver());			//Searching all values of Interest 
			int n1 = elementsList1.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1(getDriver()).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(100);
			for(int i = 0; i < n1; i++)
			{
				action.moveToElement(elementsList1.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList1.get(i).getText());	//Reading each Compliance value.
				interest = interest + j;									//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1(getDriver()).isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItems1(getDriver()).click();				//Clicking to escape unwanted tool tips
				CFOcountPOM.clickNextPage1(getDriver()).click();
			}
		}
		
		CFOcountPOM.clickNextPage1(getDriver()).sendKeys(Keys.PAGE_UP);
		getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
		getDriver().switchTo().parentFrame();								//Switching back to main parent frame.
		Thread.sleep(500);
		CFOcountPOM.closeCategories(getDriver()).click();					//Closing the 'Penalty' pop up.
		
		int total = interest + penalty1;
		
		if(total == valuePenalty)
		{
			test.log(LogStatus.PASS, "'Penalty' count matches to sum. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Penalty' count doesn't matches. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
	}
	
 	public static void GraphCount( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(getDriver()).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(getDriver()).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(getDriver()).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(getDriver()).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 50);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		try
		{
			elementsList = CFOcountPOM.selectDropdown(getDriver());				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
			Actions action = new Actions(getDriver());
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst(getDriver())).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1(getDriver())).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItems1(getDriver()).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(getDriver()).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories(getDriver()).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.INFO, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.INFO, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void BarGraphCount( ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely(getDriver()).click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed(getDriver()).click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted(getDriver()).click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable(getDriver()).click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 50);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Actions action = new Actions(getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		
		elementsList = CFOcountPOM.selectDropdown(getDriver());				//It is a dropdown but don't have Select tag.
		elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectFirst(getDriver())).click().build().perform();	//Selecting first option of the drop down.
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItems1(getDriver()).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories(getDriver()).click();					//Closing the In Time compliance window.
		
		if(count == ComplianceCount)
		{
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void RiskGraphCount( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 60);
		Actions action = new Actions(getDriver());
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		}
		catch(Exception e)
		{
			
		}
		
		elementsList = CFOcountPOM.selectDropdown(getDriver());				//It is a dropdown but don't have Select tag.
		elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
		if(Complaince.equalsIgnoreCase("Internal"))
		{
			action.moveToElement(CFOcountPOM.selectFirst1(getDriver())).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
		}
		else
		{
			action.moveToElement(CFOcountPOM.selectFirst(getDriver())).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING)
		}
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItems1(getDriver()).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories(getDriver()).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void DetailedReport(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 60);
	    
		Thread.sleep(500);
		clickReports(getDriver()).click();					//Clicking on 'My Reports'
		Thread.sleep(500);
		clickDetailedReport(getDriver()).click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickUserDropDown(getDriver())));
		OverduePOM.clickUserDropDown(getDriver()).click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickPerformer(getDriver()).click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Actions action = new Actions(getDriver());
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectMonth(getDriver())).click().perform();		//Clicking on Months drop down.
		Thread.sleep(500);
		action.moveToElement(clickAllMonths(getDriver())).click().perform();		//Select 'All' from drop down.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		DetailedCompliances(test,getDriver(),0,"Statutory");
		DetailedCompliances(test,getDriver(),1,"Internal");
		DetailedCompliances(test,getDriver(),2,"Event Based");
		DetailedCompliances(test,getDriver(),3,"Statutory Checklist");
		DetailedCompliances(test,getDriver(),4,"Internal Checklist");
		DetailedCompliances(test,getDriver(),5,"Event Based Checklist");
		DetailedCompliances(test,getDriver(),6,"All Types");
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(getDriver()).click();
	}
	
	public static void DetailedCompliances(ExtentTest test,  int i, String Compliance) throws InterruptedException, IOException
	{
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 40);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-1000)");				//Scrolling window up.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(clickComplianceDropDown(getDriver())));
		clickComplianceDropDown(getDriver()).click();		//Clicking on Compliance drop down.
		Thread.sleep(500);
		menus = selectComplianceMenus(getDriver());			//Getting menus list
		menus.get(i).click();							//Selecting ith menu
		
		Thread.sleep(500);
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		}
		catch(Exception e)
		{
			
		}
		
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		
		if(bits.length - 2 < 2)
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();	//Reading the total items count in String
			bits = s1.split(" ");								//Splitting the String
			itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		}
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.INFO, "No records found for '"+Compliance+"'.");
			getDriver().navigate().refresh();
		}
		else
		{
			js.executeScript("window.scrollBy(0,-1000)");					//Scrolling down window by 2600 px.
			String file = "//home//ashitosh-avantis//Downloads//Detailed Report .xlsx";
			Detailed(getDriver(), file, Compliance, test);
		}
	}
	
	public static void Detailed( String file, String compliance, ExtentTest test) throws InterruptedException, IOException
	{
		File dir = new File("C://Users//jiya//Downloads//");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(getDriver()).click();			//Exporting (Downloading) file
		
		Thread.sleep(4000);
		File dir1 = new File("C://Users//jiya//Downloads//");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, compliance+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2600 px.
			
			if(compliance.equalsIgnoreCase("Statutory CheckList"))
				Thread.sleep(1500);
			else
				Thread.sleep(500);
			CFOcountPOM.readTotalItems1(getDriver()).click();				//clicking on Total items count to scroll down.
			
			String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();	//Reading the total items count in String
			String[] bits = s1.split(" ");								//Splitting the String
			String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
			int count;
			if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
			{
				count = 0;
			}
			else
			{
				count = Integer.parseInt(itomsCount);
			}
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, compliance + " :- No of Records in sheet matches to the number of items.");
				test.log(LogStatus.INFO, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " :- No of Records in sheet doesn't matches to the number of items.");
				test.log(LogStatus.INFO, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, compliance+" :- File does not downloaded.");
		}
	}
	
	public static void AssignmentReport(ExtentTest test, ) throws InterruptedException, IOException
	{
		WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 30);
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports(getDriver())));
		CFOcountPOM.clickReports(getDriver()).click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport(getDriver()).click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		selectType2(getDriver()).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(getDriver());
		elementsList.get(1).click();
		
		String file = "C://Users//jiya//Downloads//StatutoryReport.xlsx";
		String compliance = "Statutory";
		Assignment(getDriver(), test, file, compliance);
		
		//------------------------------------- Event Based ------------------------------------
		
		selectType2(getDriver()).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(getDriver());
		elementsList.get(1).click();					//Unselecting preselected 'Statutory' checkbox
		elementsList.get(3).click();					//Selecting 'Event Based' checkbox.
				
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress(getDriver());
				
		file = "C://Users//jiya//Downloads//InternalReport.xlsx";
		compliance = "Event Based";
		Assignment(getDriver(), test, file, compliance);
		
		//------------------------------------- Internal ------------------------------------
		
		selectType2(getDriver()).click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2(getDriver());
		elementsList.get(3).click();					//Unselecting preselected 'Event Based' checkbox
		elementsList.get(4).click();					//Selecting 'Internal' checkbox.
		
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress(getDriver());
		
		file = "C://Users//jiya//Downloads//InternalReport.xlsx";
		compliance = "Internal";
		Assignment(getDriver(), test, file, compliance);
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard(getDriver()).click();
	}
	
	public static void Assignment( ExtentTest test, String file, String compliance) throws InterruptedException, IOException
	{
		Thread.sleep(500);
		litigationAdditionalOwner.MethodsPOM.progress();
		
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) get;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2600 px.
		
		Thread.sleep(500);
		CFOcountPOM.readTotalPages1(getDriver()).click();					//CLicking on Total Pages value to scroll down
		
		String s1 = CFOcountPOM.readTotalPages1(getDriver()).getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		int TotalRecords;
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.INFO, compliance+" does not have any records to download.");
		}
		else
		{
			TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2600 px.
			
			File dir = new File("C://Users//jiya//Downloads//");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportExcel().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C://Users//jiya//Downloads//");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, compliance +" :- File downloaded successfully.");	
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(500);
				fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
				Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
				c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
				FileOutputStream fos = new FileOutputStream(lastModifiedFile);
				workbook.write(fos);
				fos.close();
				
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				
				if(SheetRecords == TotalRecords)
				{
					test.log(LogStatus.PASS, compliance+" :- No of records displayed = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
				}
				else
				{
					test.log(LogStatus.FAIL, compliance+" :- No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.INFO, compliance +" :- File does not downloaded.");
			}
		}
	}*/
}
