package litigationFE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import litigationAdditionalOwner.performerPOM;
import login.BasePage;
import cfo.OverduePOM;

public class FeMethod extends BasePage {
	
	 private static List<WebElement> elementsList = null;
	    public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		public static XSSFSheet sheet1 = null;		//Sheet variable


//		public static void progress(WebDriver driver) throws InterruptedException
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 180);
//			try
//			{
//				Thread.sleep(300);
//				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
//			}
//			catch(Exception e)
//			{
//				
//			}
//		}
		
		public static void DashBoardFilter(ExtentTest test, String type) throws InterruptedException
		{
			
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	       	js.executeScript("window.scrollBy(0,600)");
	       	
	       	Thread.sleep(5000);
			performerPOM.clickDashboardLocFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardLocFilter1().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardNoticeFilter().click();
			
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
			
			Thread.sleep(500);
			OverduePOM.clickDashboard().click();
			
			test.log(LogStatus.PASS,"DashBoard Filter Work Successfully");
			
		}
	public static void CaseNoticeStageGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	       	js.executeScript("window.scrollBy(0,800)");
			
	       	Thread.sleep(2000);
		
	       	int	open = Integer.parseInt(performerPOM.clickCaseNoticeStageHearingGraph().getText());	//Reading Notice Open count.
		    performerPOM.clickCaseNoticeStageHearingGraph().click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			
		/*	Thread.sleep(3000);
			performerPOM.clickLocationFilter().click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1().click();
			
			Thread.sleep(5000);
			performerPOM.clickLocationFilter3().click();
			
			Thread.sleep(5000);
			performerPOM.clickCaseNotice().click();
			
			Thread.sleep(5000);
			performerPOM.selectCaseNotice().click();
			
			Thread.sleep(5000);
			performerPOM.clickStatusFilter().click();
			
			Thread.sleep(5000);
			performerPOM.selectstatusFiltercfo().click();
			
			Thread.sleep(5000);
			performerPOM.clickDepartmentFilter().click();
			
			Thread.sleep(5000);
			performerPOM.selectDepartmentFilter2().click();
			
			Thread.sleep(5000);
			performerPOM.clickCaseNoticeType1().click();
			
			Thread.sleep(5000);
			performerPOM.selectCaseNoticeType2().click();
			
			Thread.sleep(5000);
			performerPOM.clickRiskFilter().click();
			

			Thread.sleep(5000);
			performerPOM.selectRiskFilter2cfo().click();
			
//			Thread.sleep(5000);
//			performerPOM.clickAgeFilter().click();
//			
//			Thread.sleep(5000);
//			performerPOM.selectAgeFiltercfo().click();
			
			Thread.sleep(5000);
			performerPOM.clickCategoryFilter().click();
			
			
			Thread.sleep(5000);
			performerPOM.selectCategoryFilter2().click();
			
			Thread.sleep(5000);
			performerPOM.clickStageFilter().click();
			
			Thread.sleep(5000);
			performerPOM.selectStageFilter2().click(); */
			
			
			
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(1000);
			CFOcountPOM.readTotalItems1().click();
			String item1 = CFOcountPOM.readTotalItems1().getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	   }	
	public static void CaseNoticeTypeGraph(ExtentTest test, String type) throws InterruptedException, IOException
	{
		
//		Thread.sleep(3000);
//		performerPOM.CaseNoticeTypeSummaryGraph1(driver).click();
		
		
		
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
       	js.executeScript("window.scrollBy(0,1000)");
		
       	Thread.sleep(2000);
	
       	int	open = Integer.parseInt(performerPOM.CaseNoticeTypeOutwardPlaintiff().getText());	//Reading Notice Open count.
	    performerPOM.CaseNoticeTypeOutwardPlaintiff().click();						//Clicking on 'Open' notice
	    
	    
	    Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
		
		Thread.sleep(10000);
		CFOcountPOM.readTotalItems1().click();
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = 0;
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
		   item = CFOcountPOM.readTotalItems1().getText();
			bits = item.split(" ");								//Splitting the String
		   compliancesCount = bits[bits.length - 2];
		}
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			count1 = 0;
		}
		else
		{
			count1 = Integer.parseInt(compliancesCount);
		}
		
		if(open == count1)
		{
			test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
			test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
			test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
       	
    
		Thread.sleep(5000);
		performerPOM.CaseNoticeTypeViewGraph().click();
		
		Thread.sleep(5000);
		performerPOM.CaseNoticeTypeclosePopupGraph().click();
		
		
	/*	Thread.sleep(3000);
		performerPOM.clickLocationFilter().click();
		
		Thread.sleep(3000);
		performerPOM.clickLocationFilter1().click();
		
		Thread.sleep(3000);
		performerPOM.clickLocationFilter3().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice().click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNotice().click();
		
		Thread.sleep(4000);
		performerPOM.clickStatusFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectstatusFiltercfo().click();
		
		Thread.sleep(4000);
		performerPOM.clickDepartmentFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectDepartmentFilter2().click();
		
		Thread.sleep(4000);
		performerPOM.clickCaseNoticeType1().click();
		
		Thread.sleep(4000);
		performerPOM.selectCaseNoticeType2().click();
		
		Thread.sleep(4000);
		performerPOM.clickRiskFilter().click();
		

		Thread.sleep(4000);
		performerPOM.selectRiskFilter2cfo().click();
		
//		Thread.sleep(5000);
//		performerPOM.clickAgeFilter().click();
//		
//		Thread.sleep(5000);
//		performerPOM.selectAgeFiltercfo().click();
		
		Thread.sleep(4000);
		performerPOM.clickCategoryFilter().click();
		
		
		Thread.sleep(4000);
		performerPOM.selectCategoryFilter2().click();
		
		Thread.sleep(4000);
		performerPOM.clickStageFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectStageFilter2().click(); */
		
		
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		
		
		Thread.sleep(10000);
		CFOcountPOM.readTotalItems1().click();
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count2 = Integer.parseInt(compliancesCount1);
		
	    try
		{
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("window.scrollBy(0,1000)");
		
	
		Thread.sleep(100);
		File dir = new File("C://Users//Admin//Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
		Thread.sleep(5500);
		File dir1 = new File("C://Users//Admin//Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(100);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			int no = sheet.getLastRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			fis.close();
			
			if(count2 == records)
			{
				test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
			}
			else
			{
				test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		

		Thread.sleep(7000);
		performerPOM.clearButton().click();
		
		
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(2000);
		performerPOM.caseNoticeSummaryGraphClose().click();
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
   }	
	public static void RiskSummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
	
	{
		
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
       	js.executeScript("window.scrollBy(0,1500)");
		
       	Thread.sleep(2000);
	
      	int	open = Integer.parseInt(performerPOM.RiskSummaryHigh().getText());	//Reading Notice Open count.
	    performerPOM.RiskSummaryHigh().click();						//Clicking on 'Open' notice
	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
		
		Thread.sleep(10000);
		CFOcountPOM.readTotalItems1().click();
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = 0;
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
		   item = CFOcountPOM.readTotalItems1().getText();
			bits = item.split(" ");								//Splitting the String
		   compliancesCount = bits[bits.length - 2];
		}
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			count1 = 0;
		}
		else
		{
			count1 = Integer.parseInt(compliancesCount);
		}
		
		if(open == count1)
		{
			test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
			test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
			test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
		}
       	
    	
		Thread.sleep(5000);
		performerPOM.CaseNoticeTypeViewGraph().click();
		
		Thread.sleep(5000);
		performerPOM.CaseNoticeTypeclosePopupGraph().click();
		
	/*	Thread.sleep(3000);
		performerPOM.clickLocationFilter().click();
		
		Thread.sleep(3000);
		performerPOM.clickLocationFilter1().click();
		
		Thread.sleep(3000);
		performerPOM.clickLocationFilter3().click();
		
		Thread.sleep(3000);
		performerPOM.clickCaseNotice().click();
		
		Thread.sleep(3000);
		performerPOM.selectCaseNotice().click();
		
		Thread.sleep(4000);
		performerPOM.clickStatusFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectstatusFiltercfo().click();
		
		Thread.sleep(4000);
		performerPOM.clickDepartmentFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectDepartmentFilter2().click();
		
		Thread.sleep(4000);
		performerPOM.clickCaseNoticeType1().click();
		
		Thread.sleep(4000);
		performerPOM.selectCaseNoticeType2().click();
		
		Thread.sleep(4000);
		performerPOM.clickRiskFilter().click();
		

		Thread.sleep(4000);
		performerPOM.selectRiskFilter2cfo().click();
		
//		Thread.sleep(5000);
//		performerPOM.clickAgeFilter().click();
//		
//		Thread.sleep(5000);
//		performerPOM.selectAgeFiltercfo().click();
		
		Thread.sleep(4000);
		performerPOM.clickCategoryFilter().click();
		
		
		Thread.sleep(4000);
		performerPOM.selectCategoryFilter2().click();
		
		Thread.sleep(4000);
		performerPOM.clickStageFilter().click();
		
		Thread.sleep(4000);
		performerPOM.selectStageFilter2().click(); */
		

		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		
		
		Thread.sleep(10000);
		CFOcountPOM.readTotalItems1().click();
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count2 = Integer.parseInt(compliancesCount1);
		
	    try
		{
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			
		}
		js.executeScript("window.scrollBy(0,1000)");
		
	
		Thread.sleep(100);
		File dir = new File("C://Users//Admin//Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
		
		Thread.sleep(5500);
		File dir1 = new File("C://Users//Admin//Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(100);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			int no = sheet.getLastRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			fis.close();
			
			if(count2 == records)
			{
				test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
			}
			else
			{
				test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		

		Thread.sleep(7000);
		performerPOM.clearButton().click();
		
		
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(2000);
		performerPOM.caseNoticeSummaryGraphClose().click();
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
	}
	 public static void DepartmentSummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	       	js.executeScript("window.scrollBy(0,1500)");
			
	       	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.DepartmentSummaryGraph1().getText());	//Reading Notice Open count.
		    performerPOM.DepartmentSummaryGraph1().click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
		/*	Thread.sleep(3000);
			performerPOM.clickLocationFilter().click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1().click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3().click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice().click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice().click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFiltercfo().click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2().click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1().click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2().click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter().click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2cfo().click();
			
//			Thread.sleep(5000);
//			performerPOM.clickAgeFilter().click();
//			
//			Thread.sleep(7000);
//			performerPOM.selectAgeFiltercfo().click();
			
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter().click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2().click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2().click(); */
			
			
			
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
		
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item1 = CFOcountPOM.readTotalItems1().getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
			
		}
	 public static void LocationSummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	js.executeScript("window.scrollBy(0,1800)");
			
	      	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.LocationSummaryGraph().getText());	//Reading Notice Open count.
		    performerPOM.LocationSummaryGraph().click();						//Clicking on 'Open' notice
		
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
			   item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
			   compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				count1 = 0;
			}
			else
			{
				count1 = Integer.parseInt(compliancesCount);
			}
			
			if(open == count1)
			{
				test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
		/*	Thread.sleep(3000);
			performerPOM.clickLocationFilter().click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter1().click();
			
			Thread.sleep(3000);
			performerPOM.clickLocationFilter3().click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice().click();
			
			Thread.sleep(3000);
			performerPOM.selectCaseNotice().click();
			
			Thread.sleep(4000);
			performerPOM.clickStatusFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectstatusFiltercfo().click();
			
			Thread.sleep(4000);
			performerPOM.clickDepartmentFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectDepartmentFilter2().click();
			
			Thread.sleep(4000);
			performerPOM.clickCaseNoticeType1().click();
			
			Thread.sleep(4000);
			performerPOM.selectCaseNoticeType2().click();
			
			Thread.sleep(4000);
			performerPOM.clickRiskFilter().click();
			

			Thread.sleep(4000);
			performerPOM.selectRiskFilter2cfo().click();
			
//			Thread.sleep(5000);
//			performerPOM.clickAgeFilter().click();
//			
//			Thread.sleep(5000);
//			performerPOM.selectAgeFiltercfo().click();
		
			Thread.sleep(4000);
			performerPOM.clickCategoryFilter().click();
			
			
			Thread.sleep(4000);
			performerPOM.selectCategoryFilter2().click();
			
			Thread.sleep(4000);
			performerPOM.clickStageFilter().click();
			
			Thread.sleep(4000);
			performerPOM.selectStageFilter2().click(); */
			
		
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item1 = CFOcountPOM.readTotalItems1().getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			
		    try
			{
				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			}
			catch(Exception e)
			{
				
			}
			js.executeScript("window.scrollBy(0,1000)");
			
		
			Thread.sleep(100);
			File dir = new File("C://Users//Admin//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C://Users//Admin//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(100);
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				
				int no = sheet.getLastRowNum();
				Row row = sheet.getRow(no);
				Cell c1 = row.getCell(0);
				int records =(int) c1.getNumericCellValue();
				fis.close();
				
				if(count2 == records)
				{
					test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	}
	  public static void CategorySummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
			{
				
				WebDriverWait wait=new WebDriverWait(getDriver(),20);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		      	js.executeScript("window.scrollBy(0,2000)");
				
		      	Thread.sleep(2000);
			
		      	int	open = Integer.parseInt(performerPOM.CategorySummaryGraph().getText());	//Reading Notice Open count.
			    performerPOM.CategorySummaryGraph().click();						//Clicking on 'Open' notice
			
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
				
				Thread.sleep(10000);
				CFOcountPOM.readTotalItems1().click();
				String item = CFOcountPOM.readTotalItems1().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2000);
				   item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");								//Splitting the String
				   compliancesCount = bits[bits.length - 2];
				}
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					count1 = 0;
				}
				else
				{
					count1 = Integer.parseInt(compliancesCount);
				}
				
				if(open == count1)
				{
					test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
				else
				{
					test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
		      	
		      	
				
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,1000)");
				
				
				
				Thread.sleep(2000);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(2000);
				performerPOM.clickCaseNoticeStageHearingExport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(5000);
				performerPOM.CaseNoticeTypeViewGraph().click();
				
				Thread.sleep(5000);
				performerPOM.CaseNoticeTypeclosePopupGraph().click();
				
			/*	Thread.sleep(3000);
				performerPOM.clickLocationFilter().click();
				
				Thread.sleep(3000);
				performerPOM.clickLocationFilter1().click();
				
				Thread.sleep(3000);
				performerPOM.clickLocationFilter3().click();
				
				Thread.sleep(3000);
				performerPOM.clickCaseNotice().click();
				
				Thread.sleep(3000);
				performerPOM.selectCaseNotice().click();
				
				Thread.sleep(4000);
				performerPOM.clickStatusFilter().click();
				
				Thread.sleep(4000);
				performerPOM.selectstatusFiltercfo().click();
				
				Thread.sleep(4000);
				performerPOM.clickDepartmentFilter().click();
				
				Thread.sleep(4000);
				performerPOM.selectDepartmentFilter2().click();
				
				Thread.sleep(4000);
				performerPOM.clickCaseNoticeType1().click();
				
				Thread.sleep(4000);
				performerPOM.selectCaseNoticeType2().click();
				
				Thread.sleep(4000);
				performerPOM.clickRiskFilter().click();
				

				Thread.sleep(4000);
				performerPOM.selectRiskFilter2cfo().click();
				
//				Thread.sleep(5000);
//				performerPOM.clickAgeFilter().click();
//				
//				Thread.sleep(5000);
//				performerPOM.selectAgeFiltercfo().click();
				
				Thread.sleep(4000);
				performerPOM.clickCategoryFilter().click();
				
				
				Thread.sleep(4000);
				performerPOM.selectCategoryFilter2().click();
				
				Thread.sleep(4000);
				performerPOM.clickStageFilter().click();
				
				Thread.sleep(4000);
				performerPOM.selectStageFilter2().click(); */
				
				
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				
				js.executeScript("window.scrollBy(0,1000)");
				
				
				
				Thread.sleep(10000);
				CFOcountPOM.readTotalItems1().click();
				String item1 = CFOcountPOM.readTotalItems1().getText();
				String[] bits1 = item1.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				
			    try
				{
					performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
				}
				catch(Exception e)
				{
					
				}
				js.executeScript("window.scrollBy(0,1000)");
				
			
				Thread.sleep(100);
				File dir = new File("C://Users//Admin//Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(250);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(5500);
				File dir1 = new File("C://Users//Admin//Downloads");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				if(dirContents.length < allFilesNew.length)
				{
					
					
					File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
				    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
				    {
				       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
				       {
				           lastModifiedFile = allFilesNew[i];
				       }
				    }
					
					Thread.sleep(100);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					
					int no = sheet.getLastRowNum();
					Row row = sheet.getRow(no);
					Cell c1 = row.getCell(0);
					int records =(int) c1.getNumericCellValue();
					fis.close();
					
					if(count2 == records)
					{
						test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
					}
					else
					{
						test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
				}
				

				Thread.sleep(7000);
				performerPOM.clearButton().click();
				
				
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				performerPOM.caseNoticeSummaryGraphClose().click();
				
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
			}

}
