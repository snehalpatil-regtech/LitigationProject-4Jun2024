package litigationAdditionalOwner;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import login.BasePage;
import cfo.OverduePOM;

public class MethodPOM1 extends BasePage {
	
	
    private static List<WebElement> elementsList = null;
    public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable



	
//	public static XSSFSheet ReadExcel() throws IOException
//	{
//		//String workingDir = System.getProperty("user.dir");
//		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\ComplianceLatest\\TestData\\LitigationSheet.xlsx");
//		
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
//		return sheet;
//	}
	
	public static void AdvancedSearchReport(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		
		Thread.sleep(8000);
        performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
        
        
//        Thread.sleep(500);
//        performerPOM.clickExcelReport1(driver).click();
//        test.log(LogStatus.PASS, "Usage Report downloaded successfully.");
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
		Thread.sleep(8000);
		
		performerPOM.AdvancedSearchReports().click();
		
	//-------------------------------------------Notice--------------------------------------------------
		
		Thread.sleep(8000);
		performerPOM.startDate().sendKeys("05/10/2022");
		
		Thread.sleep(8000);
		performerPOM.endDate().sendKeys("05/12/2023");
		
		Thread.sleep(8000);
		performerPOM.clickApplyButton().click();
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"div[id='grid1'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=2000");
		
		
		
        By locator = By.xpath("(//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1'])[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(8000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(8000);
	    JavascriptExecutor jse=(JavascriptExecutor)getDriver();
	    jse.executeScript("arguments[0].click();", ViewButton);
	
		
		
//		Thread.sleep(2000);
//		performerPOM.viewNoticeDetails1(driver).click();
		test.log(LogStatus.PASS, "Show details notice popup open successfully.");
		
		
		Thread.sleep(8000);
		performerPOM.Actionclosepopup().click();
		
		Thread.sleep(8000);
		By locator1 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
			
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(8000);
			
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		
		jse.executeScript("arguments[0].click();", ViewButton1);
		
		
//		Thread.sleep(2000);
//		performerPOM.showResponseDetailIcon1(driver).click();
		test.log(LogStatus.PASS, "Show response details notice popup open successfully.");
		
		Thread.sleep(8000);
		performerPOM.Actionclosepopup().click(); 
		
		Thread.sleep(8000);
		performerPOM.clickExportAdavanced().click();
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
	//-------------------------------------------Case--------------------------------------------------
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
		
	    Thread.sleep(8000);
		performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
		Thread.sleep(8000);
		performerPOM.selectTypeCase1().click();
		
	
		js.executeScript("window.scrollBy(0,800)");
		js.executeScript("document.querySelector(\"div[id='grid1'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		
		Thread.sleep(8000);
		By locator2 = By.xpath("//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1']");
			
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
		Thread.sleep(8000);
			
		WebElement ViewButton2 = getDriver().findElement(locator2);	
		Thread.sleep(8000);
	 
	    jse.executeScript("arguments[0].click();", ViewButton2);
		
//		Thread.sleep(3000);
//		performerPOM.viewNoticeDetails().click();
	    
	    
		test.log(LogStatus.PASS, "Show details case popup open successfully.");
		
		Thread.sleep(8000);
		performerPOM.Actionclosepopup().click();
		
		Thread.sleep(8000);
		By locator3 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
		 wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(8000);
		WebElement ViewButton3 = getDriver().findElement(locator3);	
		Thread.sleep(8000);
	  
	    js.executeScript("arguments[0].click();", ViewButton3);
		
//		Thread.sleep(3000);
//		performerPOM.showResponseDetailIcon(driver).click();
	    
		test.log(LogStatus.PASS, "Show Hearing details Case popup open successfully.");
		
		Thread.sleep(8000);
		performerPOM.Actionclosepopup().click();
		
		Thread.sleep(8000);
		performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
	//-------------------------------------------Task--------------------------------------------------
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad(driver)));	//Wait until records table gets visible.
		
		
		Thread.sleep(10000);
		performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
		Thread.sleep(10000);
		performerPOM.selectTypeTask1().click();
		
		
		Thread.sleep(8000);
		By locator4 = By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']");
			
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator4));
		Thread.sleep(8000);
			
		WebElement ViewButton4 = getDriver().findElement(locator4);	
		Thread.sleep(8000);
		
	    jse.executeScript("arguments[0].click();", ViewButton4);
		
		//Thread.sleep(3000);
		//performerPOM.viewTaskDetails().click();	
		test.log(LogStatus.PASS, "Show details Task popup open successfully.");
		
		Thread.sleep(8000);
		performerPOM.ActioncloseTaskpopup().click();
		
		
		Thread.sleep(8000);
		performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
		Thread.sleep(8000);
		OverduePOM.clickDashboard().click();
	}
	
	
	public static void DashBoardFilter(ExtentTest test, String type) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
       	js.executeScript("window.scrollBy(0,800)");
       	
       	Thread.sleep(5000);
		performerPOM.clickDashboardLocFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardLocFilter1().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardCaseNoticeFilter().click();
		
//		Thread.sleep(5000);
//		performerPOM.clickDashboardCaseNoticeFilter1(driver).click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardTypeFilter().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardTypeFilter1().click();
		
		Thread.sleep(5000);
		performerPOM.clickDashboardDeptFilter().click();
			
		Thread.sleep(6000);
		performerPOM.clickDashboardDeptFilter1().click();
		
		Thread.sleep(6000);
		performerPOM.clickDashboardstatusFilter().click();
		
		Thread.sleep(6000);
		performerPOM.clickDashboardstatusFilter1().click();
		
        Thread.sleep(6000);
		performerPOM.clickDashboardRiskFilter().click();
		
        Thread.sleep(6000);
		performerPOM.clickDashboardRiskFilter1().click();
		
	    Thread.sleep(5000);
		performerPOM.clickDashboardApplyBtn().click();
		
	    Thread.sleep(5000);
		performerPOM.clickDashboardClearBtn().click();
		
		test.log(LogStatus.PASS,"DashBoard Filter Work Successfully");
		
		}
	public static void WorkspaceFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		Thread.sleep(3000);
		performerPOM.clickMyWorkspace().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice1().click();
		
		  Thread.sleep(3000);
			performerPOM.clicklocationFilter().click();
			Thread.sleep(3000);
			performerPOM.clickExpand().click();
			Thread.sleep(3000);
	       String locationtext =performerPOM.SelectLocationDoceNonAdmin().getText();
	       Thread.sleep(3000);
	       performerPOM. SelectLocationDoceNonAdmin().click();
	       
	       
          Thread.sleep(500);
	       performerPOM.clickDepartmentFilterWorkspace().click();
	       Thread.sleep(500);
	       String DeptText = performerPOM.selectDepartmentFilterDocNonAdmin().getText();
	       Thread.sleep(500);
	       performerPOM. selectDepartmentFilterDocNonAdmin().click();
	       				        
	       Thread.sleep(500);
	       performerPOM.clickTypeFilter().click();
	       Thread.sleep(500);
	       String Typetext = performerPOM.SelectTypeFilterCA().getText();
	       Thread.sleep(500);
	       performerPOM.SelectTypeFilterCA().click();
	           
	       
	        List<String> li=new ArrayList<String>();
	        li.add(locationtext);
	         li.add(DeptText);
	         li.add(Typetext);
	        
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("Dept");
			filter.add("Type");
			
			
			 Thread.sleep(500);
			 performerPOM.clickTrignle().click();
		     Thread.sleep(500);
		     performerPOM.clickCol().click();

		     
		     By dept = By.xpath("(//span[@class='k-link k-menu-link'][normalize-space()='Department'])[1]");
            wait.until(ExpectedConditions.presenceOfElementLocated(dept));
		     Thread.sleep(4000);
            WebElement ViewButton = getDriver().findElement(dept);	
			
			 js.executeScript("arguments[0].click();", ViewButton);
		     Thread.sleep(500);
			 performerPOM.clickTrignle().click(); 
			
			
			js.executeScript("window.scrollBy(0,250)");	
			Thread.sleep(4000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			List<WebElement> Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[14]"));
			List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(entitycol);
					}
				
				   else if(i==1)
				   {
					 raw.addAll(Dept);
				   }
				   else if(i==2)
				   {
					   raw.addAll(Type);
				   }
				  
							
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
					{
						
						if(i==2)
						{
							if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
							{
							  pass.add(text.get(l));
							}
							else
							{
								 fail.add(text.get(l));
							}
						}
							
						
						else
						{
							
						
							if(text.get(l).equals(li.get(i)))
							{
						
						
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
					}
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
			
		}
	public static void CaseWorkspaceFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		Thread.sleep(3000);
		performerPOM.clickMyWorkspace().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice1().click();
		
		 Thread.sleep(1000);
		 wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		Thread.sleep(3000);
		performerPOM.clickTypeDropdown().click();
		
		Thread.sleep(3000);
		performerPOM.selectTypeNotice().click();
		
		  Thread.sleep(3000);
			performerPOM.clicklocationFilter().click();
			Thread.sleep(3000);
			performerPOM.clickExpand().click();
			Thread.sleep(3000);
	       String locationtext =performerPOM.SelectLocationCase().getText();
	       Thread.sleep(3000);
	       performerPOM. SelectLocationCase().click();
	       
	       
          Thread.sleep(500);
	       performerPOM.clickDepartmentFilterWorkspace().click();
	       Thread.sleep(500);
	       String DeptText = performerPOM.selectDepartmentFilterDocNonAdmin().getText();
	       Thread.sleep(500);
	       performerPOM. selectDepartmentFilterDocNonAdmin().click();
	       				        
	       Thread.sleep(500);
	       performerPOM.clickTypeFilter().click();
	       Thread.sleep(500);
	       String Typetext = performerPOM.SelectTypeFilterCA().getText();
	       Thread.sleep(500);
	       performerPOM.SelectTypeFilterCA().click();
	           
	       
	        List<String> li=new ArrayList<String>();
	        li.add(locationtext);
	         li.add(DeptText);
	         li.add(Typetext);
	        
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("Dept");
			filter.add("Type");
			
			
			 Thread.sleep(500);
			 performerPOM.clickTrignle().click();
		     Thread.sleep(500);
		     performerPOM.clickCol().click();

		     
		     By dept = By.xpath("(//span[@class='k-link k-menu-link'][normalize-space()='Department'])[1]");
            wait.until(ExpectedConditions.presenceOfElementLocated(dept));
		     Thread.sleep(4000);
            WebElement ViewButton = getDriver().findElement(dept);	
			 js.executeScript("arguments[0].click();", ViewButton);
		     Thread.sleep(500);
			 performerPOM.clickTrignle().click(); 
			
			
			js.executeScript("window.scrollBy(0,300)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			List<WebElement> Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[14]"));
			List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(entitycol);
					}
				
				   else if(i==1)
				   {
					 raw.addAll(Dept);
				   }
				   else if(i==2)
				   {
					   raw.addAll(Type);
				   }
				  
							
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
					{
						
						if(i==2)
						{
							if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
							{
							  pass.add(text.get(l));
							}
							else
							{
								 fail.add(text.get(l));
							}
						}
							
						
						else
						{
							
						
							if(text.get(l).equals(li.get(i)))
							{
						
						
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
					}
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
			
		}
	public static void WorkspaceTaskFilter(ExtentTest test) throws InterruptedException
	{
		
		 JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(3000);
		performerPOM.clickMyWorkspace().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice1().click();
		
		Thread.sleep(3000);
		performerPOM.clickTypeDropdown().click();
		
		Thread.sleep(3000);
		performerPOM.selectTypeTask().click();
		

		  Thread.sleep(3000);
			performerPOM.clickTaskLocFilter().click();
			Thread.sleep(3000);
			performerPOM.clickExpand().click();
			Thread.sleep(3000);
	       String locationtext =performerPOM.SelectLocationDoceNonAdmin().getText();
	       Thread.sleep(3000);
	       performerPOM. SelectLocationDoceNonAdmin().click();
	       
	       
           Thread.sleep(500);
	       performerPOM.clickTaskPriorityFilter().click();
	       Thread.sleep(500);
	       String priorityText = performerPOM.SelectTaskPriorityFilter().getText();
	       Thread.sleep(500);
	       performerPOM. SelectTaskPriorityFilter().click();
	       				        
	       Thread.sleep(500);
	       performerPOM.clickTaskStatusFilter().click();
	       Thread.sleep(500);
	       String Statustext = performerPOM.SelectTaskStatusFilter().getText();
	       Thread.sleep(500);
	       performerPOM.SelectTaskStatusFilter().click();
	           
	       
	        List<String> li=new ArrayList<String>();
	     
	         li.add(priorityText);
	         li.add(Statustext);
	        
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("priority");
			filter.add("Status");
			 
			js.executeScript("window.scrollBy(0,200)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			List<WebElement> Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
			//List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(Prioritycol);
					}
				
				   else if(i==1)
				   {
					 raw.addAll(Status);
				   }
				 
							
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
					{
						
						if(i==1)
						{
							if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
							{
							  pass.add(text.get(l));
							}
							else
							{
								 fail.add(text.get(l));
							}
						}
						else
						{
							
						
					if(text.get(l).equals(li.get(i)))
						{
						
						
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
					}
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
		
}
	
	public static void WorkspaceCaseHearingFilter(ExtentTest test,String type) throws InterruptedException
	{
		
		 JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(3000);
		performerPOM.clickMyWorkspace().click();
		Thread.sleep(3000);
		performerPOM.clickCaseHearing1().click();
		
		Thread.sleep(3000);
		performerPOM.clickSearchFilter().sendKeys(type,Keys.ENTER);
		
	      List<String> li=new ArrayList<String>();
	        
	       
	        li.add(type);
	       
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Location");	
			
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
	
			List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@id='gridPendingUpdation']/div[2]/table/tbody/tr/td[1]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


			 if(i==0)
					{
						raw.addAll(typecol);
					}
				
					
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

				for(int l=0;l<text.size();l++)
				 {
						
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					   {
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

					   }
				  }
						
				             
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 	test.log(LogStatus.PASS,  " Search box working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
			 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
		}
		
	public static void DocumentNoticeFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
	
		 performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
		 performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
		 
		 Thread.sleep(3000);
			performerPOM.clickTypeDropdown().click();
			Thread.sleep(3000);
			performerPOM.selectTypeNotice().click();
	
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
	
	
		
	
		Thread.sleep(3000);
		performerPOM.clickDocStatusFilter().click();
		Thread.sleep(3000);
		String Statustext =performerPOM.selectDocStatusFilter().getText();
		Thread.sleep(3000);
		performerPOM. selectDocStatusFilter().click();
   

		Thread.sleep(3000);
		performerPOM.clickDocTypeFilter().click();
		Thread.sleep(3000);
		String typetext =performerPOM.SelectTypeFilterCA().getText();
		Thread.sleep(3000);
		performerPOM. SelectTypeFilterCA().click();
     
     
     
  
		Thread.sleep(3000);
		performerPOM.clickDocLocFilter().click();
		Thread.sleep(3000);
		performerPOM.clickExpand().click();
		Thread.sleep(3000);
		String locationtext =performerPOM.SelectLocationCase().getText();
		Thread.sleep(3000);
		performerPOM. SelectLocationCase().click();
		Thread.sleep(3000);
		performerPOM.clickDocLocFilter().click();
       
	    List<String> li=new ArrayList<String>();
         li.add(Statustext);
         li.add(typetext);
         li.add(locationtext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Status");
		filter.add("Type");
		filter.add("Loaction");
	
		 
		  By Tringle = By.xpath("//span[@class='k-icon k-i-more-vertical']");
          wait.until(ExpectedConditions.presenceOfElementLocated(Tringle));
		  Thread.sleep(4000);
          WebElement ViewButton = getDriver().findElement(Tringle);	
		  
		  js.executeScript("arguments[0].click();", ViewButton);
	     
		 Thread.sleep(3000);
	     performerPOM.clickCol().click();

	     
	     By dept = By.xpath("//input[@data-field='Status']");
         wait.until(ExpectedConditions.presenceOfElementLocated(dept));
	     Thread.sleep(4000);
         WebElement ViewButton1 = getDriver().findElement(dept);	
		
		 js.executeScript("arguments[0].click();", ViewButton1);
	    
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);

		CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItems1().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[13]"));
		List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
		List<WebElement> Location=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++)
		{
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					
					raw.addAll(statuscol);
				}
			
			   else if(i==1)
			   {
				 raw.addAll(Type);
			   }
			   else if(i==2)
			   {
				   raw.addAll(Location);
			   }
			  		
				for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
				  if(i==1)
					 {
						if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					 }
				  
				  
					else
				
					{
						
						if(text.get(l).equals(li.get(i)))
						{
					
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

				    }
				 }
				}
		 
//				for(String Fal : fail)
//				{
//					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
//				}	
				for(String Pas : pass)
				{
					test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
				}
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
		
		
			}
		}
			else 
			{
				test.log(LogStatus.PASS,"No records found");	
			}
	}

	
	
	public static void DocumentCaseFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		
		performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
		performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
		
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
		

		Thread.sleep(3000);
		performerPOM.clickDocStatusFilter().click();
		Thread.sleep(3000);
        String Statustext =performerPOM.selectDocStatusFilter1().getText();
        Thread.sleep(3000);
         performerPOM. selectDocStatusFilter1().click();
       
	
         Thread.sleep(3000);
		performerPOM.clickDocTypeFilter().click();
		Thread.sleep(3000);
	    String typetext =performerPOM.selectDocTypeFilter().getText();
	    Thread.sleep(3000);
	     performerPOM. selectDocTypeFilter().click();
         
         
         
      
		  Thread.sleep(3000);
			performerPOM.clickDocLocFilter().click();
			Thread.sleep(3000);
			performerPOM.clickExpand().click();
			Thread.sleep(3000);
	       String locationtext =performerPOM.SelectLocationCase().getText();
	       Thread.sleep(3000);
	       performerPOM. SelectLocationCase().click();
	       Thread.sleep(3000);
			performerPOM.clickDocLocFilter().click();
	       
	        List<String> li=new ArrayList<String>();
	         li.add(Statustext);
	         li.add(typetext);
	         li.add(locationtext);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Status");
			filter.add("Type");
			filter.add("Loaction");
			
			
			// Thread.sleep(3000);
			 //performerPOM.clickTrignle(driver).click();
			 
			  By Tringle = By.xpath("//span[@class='k-icon k-i-more-vertical']");
                 wait.until(ExpectedConditions.presenceOfElementLocated(Tringle));
			     Thread.sleep(4000);
                 WebElement ViewButton = getDriver().findElement(Tringle);	
				
				 js.executeScript("arguments[0].click();", ViewButton);
		     
				 Thread.sleep(3000);
		     performerPOM.clickCol().click();

		     
		     By dept = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Status']");
             wait.until(ExpectedConditions.presenceOfElementLocated(dept));
		     Thread.sleep(4000);
             WebElement ViewButton1 = getDriver().findElement(dept);	
			
			 js.executeScript("arguments[0].click();", ViewButton1);
		    
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
			List<WebElement> Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
			List<WebElement> Location=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			
			   else if(i==1)
			   {
				 raw.addAll(Type);
			   }
			   else if(i==2)
			   {
				   raw.addAll(Location);
			   }
			 
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}

				 if(i==1)
					{
						if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
				}
		 
//				for(String Fal : fail)
//				{
//					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
//				}	
				for(String Pas : pass)
				{
					test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
				}
					text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
		
		
			}
			}
			else 
			{
				test.log(LogStatus.PASS,"No records found");	
			}
		}
	
	public static void DocumentTaskFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
	
		 performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
		performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
	
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
	
	
		  Thread.sleep(3000);
		  performerPOM.clickTypeDropdown().click();
		  Thread.sleep(3000);
		  performerPOM.selectTypeTask().click();
	
           Thread.sleep(500);
	       performerPOM.clickDocTaskPriorityFilter().click();
	       Thread.sleep(500);
	       String priorityText = performerPOM.SelectTaskPriorityFilter().getText();
	       Thread.sleep(500);
	       performerPOM. SelectTaskPriorityFilter().click();
	       				        
	       Thread.sleep(500);
	       performerPOM.clickDocStatusFilter().click();
	       Thread.sleep(500);
	       String Statustext = performerPOM.selectDocStatusFilter().getText();
	       Thread.sleep(500);
	       performerPOM.selectDocStatusFilter().click();
	           
	       
	        List<String> li=new ArrayList<String>();
	       
	         li.add(priorityText);
	         li.add(Statustext);
	        
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
		
			filter.add("priority");
			filter.add("Status");
			 
			js.executeScript("window.scrollBy(0,200)");	
			Thread.sleep(3000);
			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[9]"));
			List<WebElement> Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
			
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(Prioritycol);
					}
				
				   else if(i==1)
				   {
					 raw.addAll(Status);
				   }
				 
							
					
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
							if(i==1)
							{
								if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
								{
								  pass.add(text.get(l));
								}
								else
								{
									 fail.add(text.get(l));
								}
							}
							else
							{
								
							
						if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
						}
				
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
			
	}
	
	public static void ReportFilter(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
	
			js.executeScript("window.scrollBy(0,-150)");	
		
	
         Thread.sleep(8000);
		performerPOM.clickReportDeptFilter().click();
		Thread.sleep(8000);
	    String depttext =performerPOM.selectDepartmentFilterDocNonAdmin().getText();
	    Thread.sleep(8000);
	     performerPOM.selectDepartmentFilterDocNonAdmin().click();
         
	     Thread.sleep(8000);
			performerPOM.clickReportTypeFilter().click();
			Thread.sleep(8000);
		    String typetext =performerPOM.SelectTypeFilterCA().getText();
		    Thread.sleep(8000);
		     performerPOM. SelectTypeFilterCA().click();
	         
         
         
      
		    Thread.sleep(8000);
			performerPOM.clickReportLocFilter().click();
			Thread.sleep(8000);
			performerPOM.clickExpand().click();
			Thread.sleep(8000);
	       String locationtext =performerPOM.SelectLocationCase().getText();
	       
	       Thread.sleep(8000);
	       performerPOM. SelectLocationCase().click();
	      
			Thread.sleep(8000);
			performerPOM.clickReportFYFilter().click();
			Thread.sleep(8000);
		    String FYtext =performerPOM.selectReportFYFilterCA().getText();
		    Thread.sleep(8000);
		     performerPOM. selectReportFYFilterCA().click();
	       
	        List<String> li=new ArrayList<String>();
	     
	         li.add(depttext);
	         li.add(typetext);
	         li.add(locationtext);
	         li.add(FYtext);
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Dept");
			filter.add("Type");
			filter.add("Loaction");
			filter.add("FY");
		
			js.executeScript("window.scrollBy(0,200)");	
			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(8000);

			if(!s.equalsIgnoreCase("No items to display"))
			{
			Thread.sleep(8000);
		
			
			List<WebElement> deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
			List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
			List<WebElement> Locationcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			List<WebElement> FYcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
			
			js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=400");
			
			Thread.sleep(8000);
            for(int i=0; i<li.size(); i++)
			{
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


					 if(i==0)
					{
						raw.addAll(deptcol);
					}
				   else if(i==1)
				   {
					 raw.addAll(typecol);
				   }
				   else if(i==2)
				   {
					   raw.addAll(Locationcol);
				   }
				   else if(i==3)
				   {
					   Thread.sleep(8000);
					   js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
					   raw.addAll(FYcol);
				   }
							
					 for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
							
							
							 if(i==1)
							{
								if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
								{
								  pass.add(text.get(l));
								}
								else
								{
									 fail.add(text.get(l));
								}
							}
							else
							{
								
							
						if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
						}
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}
				else 
				{
					test.log(LogStatus.PASS,"No records found");	
				}
		}
	
	 
	 public static void ReportCaseFilter(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			
		
				js.executeScript("window.scrollBy(0,-150)");	
				
				Thread.sleep(8000);
				performerPOM.clickTypeDropdown().click();
				Thread.sleep(8000);
				performerPOM.selectTypeNotice().click();
				
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			Thread.sleep(8000);
			performerPOM.clickReportStatusFilter().click();
			Thread.sleep(8000);
	        String Statustext =performerPOM.selectReportStatusFilter().getText();
	        Thread.sleep(8000);
	         performerPOM. selectReportStatusFilter().click();
	       
		
	         Thread.sleep(8000);
			performerPOM.clickReportDeptFilter().click();
			Thread.sleep(8000);
		    String depttext =performerPOM.selectReportCaseDeptFilter1().getText();
		    Thread.sleep(8000);
		     performerPOM.selectReportCaseDeptFilter1().click();
	         
		     Thread.sleep(8000);
				performerPOM.clickReportTypeFilter().click();
				Thread.sleep(8000);
			    String typetext =performerPOM.SelectTypeFilterCA().getText();
			    Thread.sleep(8000);
			     performerPOM. SelectTypeFilterCA().click();
		         
	         
	         
	      
			    Thread.sleep(8000);
				performerPOM.clickReportLocFilter().click();
				Thread.sleep(8000);
				performerPOM.clickExpand().click();
				Thread.sleep(8000);
		       String locationtext =performerPOM.SelectLocationCase().getText();
		       Thread.sleep(8000);
		       performerPOM. SelectLocationCase().click();
		      
				Thread.sleep(8000);
				performerPOM.clickReportFYFilter().click();
				Thread.sleep(8000);
			    String FYtext =performerPOM.selectReportFYFilter().getText();
			    Thread.sleep(8000);
			     performerPOM. selectReportFYFilter().click();
		       
		        List<String> li=new ArrayList<String>();
		         li.add(Statustext);
		         li.add(depttext);
		         li.add(typetext);
		         li.add(locationtext);
		         li.add(FYtext);
		        
				List<String> filter=new ArrayList<String>();	
				filter.add("Status");
				filter.add("Dept");
				filter.add("Type");
				filter.add("Loaction");
				filter.add("FY");
			
				js.executeScript("window.scrollBy(0,300)");
				Thread.sleep(8000);
				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(8000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(8000);
			
				List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]"));
				List<WebElement> deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
				List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
				List<WebElement> Locationcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				List<WebElement> FYcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
				Thread.sleep(8000);
				js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");
				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(statuscol);
						}
						else if(i==1)
						{
							raw.addAll(deptcol);
						}
					   else if(i==2)
					   {
						 raw.addAll(typecol);
					   }
					   else if(i==3)
					   {
						   raw.addAll(Locationcol);
					   }
					   else if(i==4)
					   {
						   Thread.sleep(5000);
						   js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
						   raw.addAll(FYcol);
					   }
								
						for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
							if(i==0)
							{
								if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
								{
								  pass.add(text.get(l));
								}
								else
								{
									 fail.add(text.get(l));
								}
							}
							
							else if(i==2)
							{
								if(text.get(l).equalsIgnoreCase("Inward")||text.get(l).equalsIgnoreCase("Defendant"))
								{
								  pass.add(text.get(l));
								}
								else
								{
									 fail.add(text.get(l));
								}
							}
							else
							{
								
							
						if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
						}
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}
				else 
				{
					test.log(LogStatus.PASS,"No records found");	
				}
		}
	 
		public static void ReportTaskFilter(ExtentTest test) throws InterruptedException
		{
			
				WebDriverWait wait = new WebDriverWait(getDriver(), 10);
					Thread.sleep(500);
				JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				Thread.sleep(8000);
				performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
			
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			
				
				js.executeScript("window.scrollBy(0,-150)");	
		
				Thread.sleep(8000);
				performerPOM.clickTypeDropdown().click();
				Thread.sleep(8000);
				performerPOM.selectTypeTask().click();
			

		       
				Thread.sleep(8000);
				performerPOM.clickTaskPriorityFilter().click();
				Thread.sleep(8000);
				String priorityText = performerPOM.SelectTaskPriorityFilter().getText();
				Thread.sleep(8000);
				performerPOM. SelectTaskPriorityFilter().click();
		       				        
				Thread.sleep(8000);
				performerPOM.clickTaskStatusFilter().click();
				Thread.sleep(8000);
				String Statustext = performerPOM.SelectTaskStatusFilter().getText();
				Thread.sleep(8000);
				performerPOM.SelectTaskStatusFilter().click();
		           
		       
			    List<String> li=new ArrayList<String>();
		       //li.add(locationtext);
		         li.add(priorityText);
		         li.add(Statustext);
		        
		        Thread.sleep(8000);
		        
				List<String> filter=new ArrayList<String>();	
				//filter.add("Location");
				filter.add("priority");
				filter.add("Status");
				 
				js.executeScript("window.scrollBy(0,200)");	
				Thread.sleep(8000);
				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(8000);

				if(!s.equalsIgnoreCase("No items to display"))
				{
				Thread.sleep(8000);
			
				List<WebElement> Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				List<WebElement> Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
				
				
				Thread.sleep(8000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(Prioritycol);
						}
					
					   else if(i==1)
					   {
						 raw.addAll(Status);
					   }
					 
								
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
						{
							
							if(i==1)
							{
								if(text.get(l).equalsIgnoreCase("Open")||text.get(l).equalsIgnoreCase("Pending"))
								{
								  pass.add(text.get(l));
								}
								else
								{
									 fail.add(text.get(l));
								}
							}
							else
							{
								
							
						if(text.get(l).equals(li.get(i)))
							{
							
							
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
						}
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}else {
					test.log(LogStatus.PASS,"No records found");	
				}
			
	}
	 
	public static void AdvancedSearchWorkspace(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),60);
 		
		
		Thread.sleep(3000);
		performerPOM.clickMyWorkspace().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice1().click();
	
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
//		Thread.sleep(5000);
//		performerPOM.clickcategory().click();
//		
//		Thread.sleep(5000);
//		performerPOM.clickcategory2().click();
		
		
		if(performerPOM.clearButton().isEnabled())
  		{
			Thread.sleep(5000);
  			performerPOM.clearButton().click();
  			test.log(LogStatus.PASS, "Clear button working successfully");
  		}
  		else
  		{
  			test.log(LogStatus.FAIL, "Clear button not working successfully");
  		}
		
		Thread.sleep(5000);
		
		performerPOM.AdvancedSearchReports().click();
		
	//-------------------------------------------Notice--------------------------------------------------
		
		Thread.sleep(4000);
		performerPOM.startDate().sendKeys("05/10/2022");
		
		Thread.sleep(4000);
		performerPOM.endDate().sendKeys("05/12/2023");
		
		Thread.sleep(4000);
		performerPOM.clickApplyButton().click();
		
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
		
		
		Thread.sleep(5000);
		performerPOM.clickExportAdavanced().click();
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
		
		Thread.sleep(4000);
		performerPOM.clickeditButton().click();
		
		test.log(LogStatus.PASS,"edit notice details icon open successfully");
		
		
		Thread.sleep(5000);
		performerPOM.Actionclosepopup().click();
		
		
	/*	Thread.sleep(4000);
		performerPOM.clickdeleteButton().click();
		
		  Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();	
	        
	        Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        
	        		
	        // Accepting alert		
	        alert.accept();		*/
	      //-------------------------------------------Case--------------------------------------------------
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			Thread.sleep(4000);
			performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
			Thread.sleep(4000);
			performerPOM.selectTypeCase1().click();
			
			Thread.sleep(3000);
			performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
		
			Thread.sleep(4000);
			performerPOM.clickeditButton().click();
			
			test.log(LogStatus.PASS,"edit case details icon open successfully");
			
			
			Thread.sleep(5000);
			performerPOM.Actionclosepopup().click();
			
			
	/*		Thread.sleep(4000);
			performerPOM.clickdeleteButton().click();
			
			  Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = driver.switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1= driver.switchTo().alert().getText();	
		        
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);	
		        
		        		
		        // Accepting alert		
		        alert1.accept();	*/
		        
          //-------------------------------------------Task--------------------------------------------------
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
			
			
			Thread.sleep(3000);
			performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
			Thread.sleep(3000);
			performerPOM.selectTypeTask1().click();
			
			Thread.sleep(3000);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(3000);
			performerPOM.viewTaskDetails1().click();	
			test.log(LogStatus.PASS, "Show details Task popup open successfully.");
			
			Thread.sleep(3000);
			performerPOM.ActioncloseTaskpopup().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
		        
	}
	
	public static void CustomerMgmt(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		Thread.sleep(2000);
	    performerPOM.clickCustomerMgmt().click();
	    Thread.sleep(2000);
	    performerPOM. clickCustomerMgmtCity().click();
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtAdd().click();
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtCBU().click();
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtCBUdropdown().click();
	   Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtZone().click();
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtZonedropdown().get(1).click();
	    Thread.sleep(4000);
	    performerPOM.clickCustomerMgmtRegion().click();
	 
	    By locator = By.xpath("//*[@id='ddlRegion_listbox']/li");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
	    jse.executeScript("arguments[0].click();", ViewButton);
	    performerPOM.clickCustomerMgmtRegion().click();
		
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtTerritory().click();
	   // Thread.sleep(3000);
	    //performerPOM.clickCustomerMgmtTerritorydropdown(driver).get(0).click();
	    
	     By locator1 = By.xpath("//*[@id='ddlTerritory_listbox']/li");
	     wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
	  	 Thread.sleep(4000);
	  	 WebElement ViewButton1 = getDriver().findElement(locator1);	
	  	 Thread.sleep(3000);
	  	 JavascriptExecutor jse1=(JavascriptExecutor)getDriver();
		 jse.executeScript("arguments[0].click();", ViewButton1);
		 Thread.sleep(3000);
		 
	  	 performerPOM.clickCustomerMgmtTerritory().click();
	  	    
	      Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtCityname().sendKeys("Agra");
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtSave().click();
	    try
	    {
	    	 
	 	    
	 	   Thread.sleep(5000);
      	   // Capturing alert message.    
              String alertMessage1= getDriver().switchTo().alert().getText();	
               Thread.sleep(3000);
              test.log(LogStatus.PASS, alertMessage1);
            // Accepting alert		
              getDriver().switchTo().alert().accept();	
              Thread.sleep(4000);
      	     performerPOM.clickCustomerMgmtClose2().click();
      	     Thread.sleep(4000);
	    }
         catch(Exception e)
         {
        	 Thread.sleep(3000);
 	 	    performerPOM.clickCustomerMgmtOk().click();
 	 	  test.log(LogStatus.PASS, "City Added Successfully");
         }
	    
	   

	/*    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtEdit().click();
	    performerPOM.clickCustomerMgmtCityname().clear();
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtCityname().sendKeys("Aaurngabad");
	    Thread.sleep(3000);
	    performerPOM.clickCustomerMgmtSave().click();
//	    Thread.sleep(3000);
//	    performerPOM.clickCustomerMgmtok().click();
	    
	    Thread.sleep(6000);
	    By locator2 = By.xpath("/html/body/div[27]/div[3]/button");        //clickUploadfile
		    wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
		  	Thread.sleep(4000);
		  	WebElement ViewButton2 = getDriver().findElement(locator2);	
		  	Thread.sleep(3000);
		  	JavascriptExecutor jse2=(JavascriptExecutor)getDriver();
		  	Thread.sleep(3000);
		    jse2.executeScript("arguments[0].click();", ViewButton2);

	    
	    test.log(LogStatus.PASS, "City Updated Successfully");*/
	    
//	    Thread.sleep(3000);
//	    performerPOM.clickCustomerMgmtDelete().click();
//	    
//	    Thread.sleep(5000);
//	   // Capturing alert message.    
//        String alertMessage1= getDriver().switchTo().alert().getText();	
//         Thread.sleep(3000);
//        test.log(LogStatus.PASS, alertMessage1);
//      // Accepting alert		
//        getDriver().switchTo().alert().accept();	
//        
//        Thread.sleep(5000);
//     // Capturing alert message.    
//        String alertMessage= getDriver().switchTo().alert().getText();	
//         Thread.sleep(3000);
//        test.log(LogStatus.PASS, alertMessage);
//      // Accepting alert		
//        getDriver().switchTo().alert().accept();	
	    
//	    Thread.sleep(3000);
//	    performerPOM.clickCustomerMgmtCustomer().click();
//	    Thread.sleep(3000);
//	    performerPOM.clickCustomerMgmtCBUFilter().click();
//	    Thread.sleep(3000);
//	    performerPOM.clickCustomerMgmtCBUFilter1().click();
	    
	   
	}
	public static void CustomerMgmtCustomer(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		 Thread.sleep(2000);
		    performerPOM.clickCustomerMgmt().click();
		  Thread.sleep(4000);
		    performerPOM.clickCustomerMgmtCustomer().click();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerMgmtAdd().click();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerName().sendKeys("Amol");
		    Thread.sleep(3000);
		    performerPOM.clickCustomerID().sendKeys("030");
		    Thread.sleep(3000);
		    performerPOM.clickSPOCName().sendKeys("Shiv");
		    Thread.sleep(3000);
		    performerPOM.clickEmailID().sendKeys("shiv@yahoo.com");
		    Thread.sleep(3000);
		    performerPOM.clickMobNo().sendKeys("0000080000");
		     Thread.sleep(3000);
		    performerPOM.clickWhatsappNo().sendKeys("1234078900");
		    Thread.sleep(3000);
		    performerPOM.clickCity1().click();
		    Thread.sleep(3000);
		    performerPOM.selectCity1().click();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerMgmtSave().click();
		    
		    try
		    {
		    	 
		 	    
		 	   Thread.sleep(5000);
	      	   // Capturing alert message.    
	              String alertMessage1= getDriver().switchTo().alert().getText();	
	               Thread.sleep(3000);
	              test.log(LogStatus.PASS, alertMessage1);
	            // Accepting alert		
	              getDriver().switchTo().alert().accept();	
	              Thread.sleep(5000);
	      	     performerPOM.clickCustomerMgmtClose().click();
	      	     Thread.sleep(4000);
		    }
	         catch(Exception e)
	         {
	        	 Thread.sleep(3000);
	 	 	    performerPOM.clickCustomerMgmtOk().click();
	 	 	  test.log(LogStatus.PASS, "Customer Added Successfully");
	         }
		    
		    Thread.sleep(3000);
		    performerPOM.clickCustomerMgmtEdit1().click();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerID().clear();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerID().sendKeys("330");
		    Thread.sleep(3000);
		    performerPOM.clickCity1().click();
		    Thread.sleep(3000);
		    performerPOM.selectCity1().click();
		    Thread.sleep(3000);
		    performerPOM.clickCustomerMgmtSave().click();
//		    Thread.sleep(5000);
//		    performerPOM.clickCustomerMgmtok().click();
		    
		    Thread.sleep(6000);
		    By locator = By.xpath("(//button[@class='k-button k-primary'])[1]");        //clickUploadfile
 		    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 		  	Thread.sleep(4000);
 		  	WebElement ViewButton = getDriver().findElement(locator);	
 		  	Thread.sleep(3000);
 		  	JavascriptExecutor jse=(JavascriptExecutor)getDriver();
 		  	Thread.sleep(3000);
 		    jse.executeScript("arguments[0].click();", ViewButton);
 		    
		    Thread.sleep(3000);
		    test.log(LogStatus.PASS, "Customer Updated Successfully");
//		    Thread.sleep(3000);
//		    performerPOM.clickCustomerMgmtDelete1().click();
//
//		    Thread.sleep(5000);
//		   // Capturing alert message.    
//	        String alertMessage1= getDrivr().switchTo().alert().getText();	
//	         Thread.sleep(3000);
//	        test.log(LogStatus.PASS, alertMessage1);
//	      // Accepting alert		
//	        getDriver().switchTo().alert().accept();	
//	        
//	        Thread.sleep(5000);	
//	     // Capturing alert message.    
//	        String alertMessage= getDriver().switchTo().alert().getText();	
//	         Thread.sleep(3000);
//	        test.log(LogStatus.PASS, alertMessage);
//	      // Accepting alert		
//	        getDriver().switchTo().alert().accept();	
	        
	        Thread.sleep(6000);
		    performerPOM.clickCustomerUpload().click();
		    
		    Thread.sleep(6000);
		    performerPOM.clickChooseFile();

		    Thread.sleep(6000);
		    By locator1 = By.xpath("//*[@id='btnFileUploadForCustomer']");        //clickUploadfile
 		    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
 		  	Thread.sleep(4000);
 		  	WebElement ViewButton1 = getDriver().findElement(locator1);	
 		  	Thread.sleep(3000);
 		  	JavascriptExecutor js1=(JavascriptExecutor)getDriver();
 		  	Thread.sleep(3000);
 		    jse.executeScript("arguments[0].click();", ViewButton1);
 		   //jse.executeScript("arguments[0].click();", ViewButton);
 		   
// 		  Thread.sleep(2000);
//		  performerPOM.clickCustomerUpload().click();
		    
		    try
		    {
		 	    
		 	   Thread.sleep(5000);
	      	   // Capturing alert message.    
	              String alertMessage2= getDriver().switchTo().alert().getText();	
	               Thread.sleep(3000);
	              test.log(LogStatus.PASS, alertMessage2);
	            // Accepting alert		
	              getDriver().switchTo().alert().accept();	
	              Thread.sleep(4000);
	      	   
		    }
	         catch(Exception e)
	         {
	        	 Thread.sleep(2000);
	   		  performerPOM.clickCustomerUpload().click();
	        	 Thread.sleep(3000);
	 		    performerPOM.clickCustomerErrotfile().click();
	 		   test.log(LogStatus.FAIL, "Download Error File");
	 	 	 Thread.sleep(4000);
     	     performerPOM.clickCustomerMgmtClose().click();
	         }
		      
		    Thread.sleep(3000);
		    performerPOM.clickCustomerUploadOutStanding().click();
		    
		    Thread.sleep(3000);
		    performerPOM.clickChooseFile1();
		    
		    Thread.sleep(3000);
		    performerPOM.clickUploadfile1().click();
		    try
		    {
		 	    
		 	   Thread.sleep(5000);
	      	   // Capturing alert message.    
	              String alertMessage2= getDriver().switchTo().alert().getText();	
	               Thread.sleep(3000);
	              test.log(LogStatus.PASS, alertMessage2);
	            // Accepting alert		
	              getDriver().switchTo().alert().accept();	
	              Thread.sleep(4000);
	      	   
		    }
	         catch(Exception e)
	         {
	        	
	   		   Thread.sleep(3000);
		       performerPOM.clickPlanVisitErrotfile().click();
	 	 	  test.log(LogStatus.FAIL, "Download Error File");
	 	 	 Thread.sleep(4000);
    	     performerPOM.clickCustomerMgmtClose1().click();
	         }
		    
		   
	}
	public static void CustomerMgmtPalnVisit(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		 Thread.sleep(2000);
		    performerPOM.clickCustomerMgmt().click();
	     
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisit().click();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitAdd().click();
		    
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitcustomaerid().click();
		    Thread.sleep(2000);
		    performerPOM.selectPlanVisitcustomaerid().click();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitcustomaerid().click();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitdate().clear();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitdate().sendKeys("16-02-2023");
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitremark().sendKeys("Ok");
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitsubmit().click();
		    
		    Thread.sleep(5000);
			   // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		         Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		      // Accepting alert		
		        getDriver().switchTo().alert().accept();	
		        Thread.sleep(3000);
	 	 	    performerPOM.clickCustomerMgmtOk().click();
	 	 	  test.log(LogStatus.PASS, "Plan Visit Successfully Added");
	 	 	  Thread.sleep(3000);
	 	 	   performerPOM.startDate().sendKeys("01-02-2023");
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.endDate().sendKeys("28-02-2023");
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickPlanVisityear().clear();
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickPlanVisityear().sendKeys("2023",Keys.ENTER);
	 	 	 Thread.sleep(3000);
	 	 	  performerPOM.clickPlanVisitedit().click();
	 	 	performerPOM.clickPlanVisitedit().click();
	 	 	 performerPOM.clickPlanVisitremark().clear();
	 	 	 Thread.sleep(2000);
		    performerPOM.clickPlanVisitremark().sendKeys("Ok");
			    Thread.sleep(2000);
			    performerPOM.clickPlanVisitsubmit().click();
			    
			    Thread.sleep(5000);
				   // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			         Thread.sleep(3000);
			        test.log(LogStatus.PASS, alertMessage);
			      // Accepting alert		
			        getDriver().switchTo().alert().accept();	
//			        Thread.sleep(3000);
//		 	 	    performerPOM.clickCustomerMgmtok(driver).click();
		 	 	    
		 		    By locator3 = By.xpath("/html/body/div[32]/div[3]/button");
		 		    wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		 		  	Thread.sleep(4000);
		 		  	WebElement ViewButton3 = getDriver().findElement(locator3);	
		 		  	Thread.sleep(3000);
		 		  	JavascriptExecutor jse2=(JavascriptExecutor)driver;
		 		    jse2.executeScript("arguments[0].click();", ViewButton3);
		 		   jse2.executeScript("arguments[0].click();", ViewButton3);
		 		   
		 		  test.log(LogStatus.PASS, "Plan Visit Successfully Updated");
		 		   
		 		 /* Thread.sleep(2000);
				    performerPOM.clickPlanVisitdelete(driver).click();
				    Thread.sleep(5000);
					   // Capturing alert message.    
				        String alertMessage2= driver.switchTo().alert().getText();	
				         Thread.sleep(3000);
				        test.log(LogStatus.PASS, alertMessage2);
				      // Accepting alert		
				        driver.switchTo().alert().accept();	
				        Thread.sleep(2000);
					    performerPOM.clickPlanVisitOverdueVisit(driver).click();*/
	 	 	 
	}
	public static void UpdateCommitmentsafterremarks(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		 Thread.sleep(2000);
		    performerPOM.clickCustomerMgmt().click();
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommitmentsafterremarks().click();

		    Thread.sleep(2000);
		    performerPOM.clickEditPendingVisit().click();
		    Thread.sleep(2000);
		    performerPOM.clickAddNewRecord().click();
		    Thread.sleep(2000);
		    performerPOM.clickScheduleDate().clear();
		    Thread.sleep(2000);
		    performerPOM.clickScheduleDate().sendKeys("05-Feb-2023");
		    
            Thread.sleep(2000);
		    performerPOM.clickAmount2().sendKeys("20000",Keys.ENTER);
		    Thread.sleep(2000);
		    performerPOM.clickFollowupDate().clear();
		    Thread.sleep(2000);
		    performerPOM.clickFollowupDate().sendKeys("07-Feb-2023",Keys.ENTER);
		    Thread.sleep(2000);
		    performerPOM.clickUpdate().click();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitremark().sendKeys("Ok");
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitsubmit().click();
		    Thread.sleep(5000);
			   // Capturing alert message.    
		        String alertMessage2= getDriver().switchTo().alert().getText();	
		         Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage2);
		      // Accepting alert		
		        getDriver().switchTo().alert().accept();	
		        Thread.sleep(2000);
		        

	        	 Thread.sleep(3000);
	 	 	    performerPOM.clickCustomerMgmtOk().click();
	 	 	    
	 	 	  test.log(LogStatus.PASS, "Visit Details Updated Successfully");
	 	 	  
	 	 /*	 Thread.sleep(2000);
			 performerPOM.clickDelete().click();
			 // Capturing alert message.    
		        String alertMessage= getDriver().switchTo().alert().getText();	
		         Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage);
		      // Accepting alert		
		        getDriver().switchTo().alert().accept();	
		     // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		         Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage1);
		      // Accepting alert		
		        getDriver().switchTo().alert().accept();	
	 	 	  
	 	 	Thread.sleep(2000);
		    performerPOM.clickUpdatedVisit().click();
		    Thread.sleep(2000);
		    performerPOM.clickEditUpdatedVisit().click();
		    Thread.sleep(2000);
		    performerPOM.clickAddNewRecord().click();
		    Thread.sleep(2000);
		    performerPOM.clickEdit().click();
		    Thread.sleep(4000);
		    performerPOM.clickScheduleDate1().click();;
		    Thread.sleep(4000);
		    performerPOM.clickScheduleDate2().click();
            Thread.sleep(2000);
		    performerPOM.clickAmount2().sendKeys("20000",Keys.ENTER);
		    Thread.sleep(2000);
		    performerPOM.clickFollowupDate().clear();
		    Thread.sleep(2000);
		    performerPOM.clickFollowupDate().sendKeys("07-Feb-2023",Keys.ENTER);
		    Thread.sleep(2000);
		    performerPOM.clickUpdate().click();
		    Thread.sleep(2000);
		    performerPOM.clickPlanVisitsubmit().click();
		    Thread.sleep(5000);
			   // Capturing alert message.    
		        String alertMessage= getDriver().switchTo().alert().getText();	
		         Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage);
		      // Accepting alert		
		        getDriver().switchTo().alert().accept();	
		        Thread.sleep(2000);
		        

	        	 Thread.sleep(3000);
	 	 	    performerPOM.clickCustomerMgmtOk().click();
	 	 	  test.log(LogStatus.PASS, "Visit Details Successfully Updated");*/
		    
	}
	public static void UpdateCommitmentsStatus(ExtentTest test) throws InterruptedException
	{
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			Thread.sleep(2000);
		    performerPOM.clickCustomerMgmt().click();
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommitmentsStatus().click();
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommitmentsStatusEdit().click();
		    Thread.sleep(2000);
		    performerPOM.clickAddNewRecords().click();
		    Thread.sleep(2000);
		    performerPOM.clickCommitDate().sendKeys("01-Feb-2023",Keys.ENTER);
		    
		    Thread.sleep(2000);
		    performerPOM.clickCommitAmount().sendKeys("20000");
		    Thread.sleep(2000);
		    performerPOM.clickRecieptDate().sendKeys("05-Feb-2023");
		    Thread.sleep(2000);
		    performerPOM.clickRecieptDateAmount().sendKeys("10000");
		    Thread.sleep(2000);
		    performerPOM.clickCommitRemark().sendKeys("ok");
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommit().click();
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommitedit().click();
		    Thread.sleep(2000);
		    performerPOM.clickCommitRemark().clear();
		    Thread.sleep(2000);
		    performerPOM.clickCommitRemark().sendKeys("ok");
		    Thread.sleep(2000);
		    performerPOM.clickUpdateCommit().click();
		    Thread.sleep(2000);
		    performerPOM.clickSendReminder().click();
		    
		    Thread.sleep(2000);
		 // Capturing alert message.    
	        String alertMessage= getDriver().switchTo().alert().getText();	
	         Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage);
	      // Accepting alert		
	        getDriver().switchTo().alert().accept();
	        
	        Thread.sleep(2000);
		    performerPOM.clickStopReminder().click();
		    Thread.sleep(2000);
		    // Capturing alert message.    
	        String alertMessage1= getDriver().switchTo().alert().getText();	
	         Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage1);
	      // Accepting alert		
	        getDriver().switchTo().alert().accept();
	        
	        Thread.sleep(2000);
		    performerPOM.clickDelete1().click();
		    
		    // Capturing alert message.    
	        String alertMessage2= getDriver().switchTo().alert().getText();	
	         Thread.sleep(3000);
	        test.log(LogStatus.PASS, alertMessage2);
	      // Accepting alert		
	        getDriver().switchTo().alert().accept();
	        Thread.sleep(2000);
		    performerPOM.clickclosePopuopCommitments().click();
	}
	public static void Report(ExtentTest test) throws InterruptedException
	{
		
		 Thread.sleep(2000);
		    performerPOM.clickCustomerMgmt().click();
		    Thread.sleep(2000);
		    performerPOM.clickReports().click();
		    
		    Thread.sleep(3000);
	 	 	   performerPOM.startDate().sendKeys("01-02-2023");
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.endDate().sendKeys("28-02-2023");
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickPlanVisityear().clear();
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickPlanVisityear().sendKeys("2023",Keys.ENTER);

	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickSchedulesReport().click();
	 	 	   
	 	 	   
//	 	 	   String Data=performerPOM.clickNoRecordFound().getText();
//	 	 	   
//	 	 	   if(!performerPOM.clickNoRecordFound(driver).isDisplayed())
//	 	 	   {
//	 	 		 test.log(LogStatus.PASS, "Data should be displayed");
//	 	 	   }
//	 	 	   else
//	 	 	   {
//	 	 		 test.log(LogStatus.FAIL, "Message Displayed " + Data );
//	 	 	   }
	 	 	   
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickNoRecordFound().click();
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickCommitmentReport().click();
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickAuditLogReport().click();
	 	 	 Thread.sleep(3000);
	 	 	   performerPOM.clickExportAuditLogReport().click();
	 	 	   
	 	 	 test.log(LogStatus.PASS, "File Download succssfully");
	 	 	   
	 	 	   
	
	}
	
   
 
}


