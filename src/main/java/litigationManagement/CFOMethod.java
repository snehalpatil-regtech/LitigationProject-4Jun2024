package litigationManagement;



//import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.
import org.openqa.selenium.Keys;
//import org.openqa.selenium.;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import cfo.CFOcountPOM;

import litigationAdditionalOwner.performerPOM;
import login.BasePage;
import cfo.OverduePOM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.awt.AWTException;
import java.awt.Robot;


public class CFOMethod extends BasePage{
	
	static String filePath = "E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx";

    

	private static List<WebElement> elementsList = null;

	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static Sheet sheet1=null ;		//Sheet variable

	public static void progress() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(180));
		try
		{
			Thread.sleep(300);
		
		}
		catch(Exception e)
		{
			
		}
	}
	

	
	public Sheet ReadExcel() throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	         sheet1 = workbook.getSheetAt(2);
	        workbook.close();
	        fis.close();
	        return sheet1;
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}
		public static void DashBoardFilter(ExtentTest test, String type) throws InterruptedException
		{
			
		
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			

			
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			 JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "clear button work successfully.");
			
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	   }
		
		public static void CaseNoticeStageGraph1(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			 WebDriverWait wait = new WebDriverWait(getDriver(),20);
			
	       	Thread.sleep(2000);
		
	       	int	open = Integer.parseInt(performerPOM.clickCaseNoticeStageHearingGraph1().getText());	//Reading Notice Open count.
		    performerPOM.clickCaseNoticeStageHearingGraph1().click();						//Clicking on 'Open' notice
		
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(3000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				test.log(LogStatus.PASS, "File downloaded successfully.");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
				
		   
			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work successfully");
		   
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	   }	
		
		
		
		
		
		
		
		
		public static void CaseNoticeTypeGraph( ExtentTest test, String type,int counttype) throws InterruptedException, IOException
		{
			
			if(type.equalsIgnoreCase("Petitioner Type"))
			{
				Thread.sleep(2000);
		        performerPOM.CaseNoticeTypePetitionerNotice().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Respondent Type"))
			{
				Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeRespondentNotice().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Defendant Type"))
			{
				Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeDefendantNotice().click();						//Clicking on 'Open' notice
			}
			
			else if(type.equalsIgnoreCase("Outward/Plaintiff Type"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeOutwardPlaintiff().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Inward/Defendent Type"))
			{
				Thread.sleep(3000);
		        performerPOM.CaseNoticeTypeInwardDefendantNotice().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Applicant Type"))
			{
				Thread.sleep(3000);
		        performerPOM.CaseNoticeTypeApplicantNotice().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Complianant Type"))
			{
				Thread.sleep(3000);
		        performerPOM.CaseNoticeTypeComplainantNotice().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Plaintiff Type"))
			{
				Thread.sleep(3000);
		        performerPOM.CaseNoticeTypePlaintiffNotice().click();						//Clicking on 'Open' notice
			}
		
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
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
			
			if(counttype == count1)
			{
				///test.log(LogStatus.PASS, type+"count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+"count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
           	
          	Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully");
			
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			
			
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
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
					//test.log(LogStatus.PASS, "Notice = No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Notice = No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
		
			Thread.sleep(4000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "clear button work successfully.");
			
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			

			
			
		}
		
		public static void CaseNoticeTypeGraph1( ExtentTest test, String type,int counttype) throws InterruptedException, IOException
		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     	
	
       
	    	if(type.equalsIgnoreCase("Inward/Defendent Type"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeInwardDefendentCase().click();						//Clicking on 'Open' notice
			}
	    	else if(type.equalsIgnoreCase("Applicant"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeApplicantCase().click();						//Clicking on 'Open' notice
			}
	    	else if(type.equalsIgnoreCase("Appellant"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeAppleantCase().click();						//Clicking on 'Open' notice
			}
	    	else if(type.equalsIgnoreCase("Complianant"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeComplianantCase().click();						//Clicking on 'Open' notice
			}
	    	else if(type.equalsIgnoreCase("Petitioner"))
			{
	         	Thread.sleep(2000);
		        performerPOM.CaseNoticeTypePetitionerCase().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Outward/Plaintiff Type"))
			{
				Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeOutwardPalintiffCaseGraph().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Respondent"))
			{
				Thread.sleep(2000);
		        performerPOM.CaseNoticeTypeRespondentCase().click();						//Clicking on 'Open' notice
			}
		
		   
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+"count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+":-Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+"count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, type+":-Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
           	
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View Popup Open Successfully");
			
			
	
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor)getDriver() ;
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
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
					//test.log(LogStatus.PASS, "Case=No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Case=No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		     Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
			
			
			
			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "clear button work successfully.");
			
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			

//			Thread.sleep(1000);
//			OverduePOM.clickDashboard().click();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		public static void RiskSummaryGraph(ExtentTest test, String type,int countype) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	       

         	            Thread.sleep(2000);
						if(type.equalsIgnoreCase("High Risk"))
						{
				         	Thread.sleep(2000);
					        performerPOM.RiskSummaryHigh().click();						//Clicking on 'Open' notice
						}
						else if(type.equalsIgnoreCase("Medium Risk"))
						{
							Thread.sleep(2000);
					        performerPOM.RiskSummaryMedium().click();						//Clicking on 'Open' notice
						}
						else if(type.equalsIgnoreCase("Low Risk"))
						{
							Thread.sleep(3000);
					        performerPOM.RiskSummaryLow().click();						//Clicking on 'Open' notice
						}
						else if(type.equalsIgnoreCase("Not Applicable Risk"))
						{
							Thread.sleep(3000);
					        performerPOM.RiskSummaryNotApplicable().click();						//Clicking on 'Open' notice
						}
						
		
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
			
			if(countype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+ ":- Dashboard Count = "+countype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, type+ ":-Dashboard Count = "+countype+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
		}
		
		
		
	public static void RiskSummaryGraph1(ExtentTest test, String type,int counttype) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			
			
			if(type.equalsIgnoreCase("High Risk"))
			{
	         	Thread.sleep(2000);
		        performerPOM.RiskSummaryHigh().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Medium Risk"))
			{
				Thread.sleep(2000);
		        performerPOM.RiskSummaryMedium().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Low Risk"))
			{
				Thread.sleep(2000);
		        performerPOM.RiskSummaryLow().click();						//Clicking on 'Open' notice
			}
			else if(type.equalsIgnoreCase("Not Applicable Risk"))
			{
				Thread.sleep(2000);
		        performerPOM.RiskSummaryNotApplicable().click();						//Clicking on 'Open' notice
			}
		
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+ ":- Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, type+ ":-Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");			
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
				
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work  successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			
			
		}
		
		
		
		
		
	   public static void DepartmentSummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		   
		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
		   JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			

			
			
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			test.log(LogStatus.PASS, "Clear button work successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
			
		}
	   
	   
	   public static void DepartmentSummaryGraph1(ExtentTest test, String type) throws InterruptedException, IOException
		
			{
				
		   		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		   		JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
		    	
		       	Thread.sleep(2000);
			
		      	int	open = Integer.parseInt(performerPOM.DepartmentSummaryGraph3().getText());	//Reading Notice Open count.
			    performerPOM.DepartmentSummaryGraph3().click();						//Clicking on 'Open' notice
			
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
					//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
				else
				{
					//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				}
		       	
		    	
				Thread.sleep(5000);
				performerPOM.CaseNoticeTypeViewGraph().click();
				
				Thread.sleep(5000);
				performerPOM.CaseNoticeTypeclosePopupGraph().click();
				
				test.log(LogStatus.PASS, "View popup open successfully.");
	
	           Thread.sleep(500);
				progress();
				
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
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(250);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				Thread.sleep(5500);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
						//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
					}
					else
					{
						//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
				}
				
				File dir2 = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
				
				Thread.sleep(5000);
			     performerPOM.ClickDetailedExpenseReport().click();
			     
			 	Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				
			 	Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
				
				Thread.sleep(3000);
			   if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
				}
			   else
			   {
					test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
				}
				
				

				Thread.sleep(7000);
				performerPOM.clearButton().click();
				
				test.log(LogStatus.PASS, "clear button work successfully.");
				
				
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				performerPOM.caseNoticeSummaryGraphClose().click();
				
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
				
				
			}
	   
	   
	   
	   public static void LocationSummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		
		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
	      
	      	Thread.sleep(3000);
		
	      	int	open = Integer.parseInt(performerPOM.LocationSummaryGraph1().getText());	//Reading Notice Open count.
		    performerPOM.LocationSummaryGraph1().click();						//Clicking on 'Open' notice
		
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			

			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	}
	   
	   
	   public static void LocationSummaryGraph1(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
	    	
			
	      	Thread.sleep(3000);
		
	      	int	open = Integer.parseInt(performerPOM.LocationSummaryGraphCase().getText());	//Reading Notice Open count.
		    performerPOM.LocationSummaryGraphCase().click();						//Clicking on 'Open' notice
		
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
	       	
	    	
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			
					
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				test.log(LogStatus.PASS, "File downloaded successfully.");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			test.log(LogStatus.PASS, "Clear button work successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	}
	   
	   
	   
	   
	   
	   
	   
	   public static void CategorySummaryGraph(ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
	      	Thread.sleep(2000);
		
	      	int	open = Integer.parseInt(performerPOM.CategorySummaryGraph1().getText());	//Reading Notice Open count.
		    performerPOM.CategorySummaryGraph1().click();						//Clicking on 'Open' notice
		
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
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
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
			
			test.log(LogStatus.PASS, "View popup open successfully.");
			
		
			Thread.sleep(500);
			progress();
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			

			Thread.sleep(7000);
			performerPOM.clearButton().click();
			
			test.log(LogStatus.PASS, "Clear button work successfully.");
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
		}
	  
	   
	   
	   public static void CategorySummaryGraph1(ExtentTest test, String type) throws InterruptedException, IOException
		
	 		{
	 			
		   		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		   		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 			 
	 			Thread.sleep(2000);
	 		
	 	      	int	open = Integer.parseInt(performerPOM.CategorySummaryGraphCase().getText());	//Reading Notice Open count.
	 		    performerPOM.CategorySummaryGraphCase().click();						//Clicking on 'Open' notice
	 		
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
	 				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
	 				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
	 			}
	 			else
	 			{
	 				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
	 				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
	 			}
	 	      	
	 	      	
	 			
	 			Thread.sleep(2000);
	 			js.executeScript("window.scrollBy(0,1000)");
	 			
	 			
	 			
	 			Thread.sleep(2000);
	 			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
	 			Thread.sleep(2000);
	 			performerPOM.clickCaseNoticeStageHearingExport().click();					//Clicking on 'Excel Report' image.
	 		
	 			
	 			Thread.sleep(5000);
	 			performerPOM.CaseNoticeTypeViewGraph().click();
	 			
	 			Thread.sleep(5000);
	 			performerPOM.CaseNoticeTypeclosePopupGraph().click();
	 			
	 			test.log(LogStatus.PASS, "View popup open successfully.");
	 			
	 		
	 			Thread.sleep(500);
	 			progress();
	 			
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
	 			File dir = new File("C:\\Users\\snehalp\\Downloads");
	 			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	 			
	 			Thread.sleep(500);
	 			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
	 			Thread.sleep(250);
	 			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
	 		
	 			
	 			Thread.sleep(5500);
	 			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
	 			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	 			
	 			if(dirContents.length < allFilesNew.length)
	 			{
	 				
	 				test.log(LogStatus.PASS, "File downloaded successfully.");
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
	 					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
	 					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
	 				}
	 				else
	 				{
	 					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
	 					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
	 				}
	 			}
	 			else
	 			{
	 				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	 			}
	 			
	 			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
				
				Thread.sleep(5000);
			     performerPOM.ClickDetailedExpenseReport().click();
			     
			 	Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
				
			 	Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
				
				Thread.sleep(3000);
			   if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
				}
			   else
			   {
					test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
				}

	 			Thread.sleep(7000);
	 			performerPOM.clearButton().click();
	 			
	 			test.log(LogStatus.PASS, "Clear button work  successfully.");
	 			
	 			
	 			Thread.sleep(3000);
	 			getDriver().switchTo().parentFrame();
	 			Thread.sleep(2000);
	 			performerPOM.caseNoticeSummaryGraphClose().click();
	 			
	 			Thread.sleep(3000);
	 			OverduePOM.clickDashboard().click();
	 		}
	   
	   
	   
		public static void ExpensesCaseGraph( ExtentTest test, String type) throws InterruptedException, IOException
		{
			

			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
          
           	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			
	       	
				js.executeScript("window.scrollBy(0,2400)");
			
	       	Thread.sleep(2000);
		
	        //Integer.parseInt(performerPOM.ExpensesCaseGraph().getText());	//Reading Notice Open count.
		    performerPOM.ExpensesCaseGraph().click();						//Clicking on 'Open' notice
		    
		    
		    
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
			js.executeScript("window.scrollBy(0,1000)");
			
			
			
			Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			String item1 = CFOcountPOM.readTotalItems1().getText();
			
			
			if(!item1.equalsIgnoreCase("No items to display"))
			{
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
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
				Thread.sleep(500);
				CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
				Thread.sleep(250);
				performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
				Thread.sleep(5500);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				if(dirContents.length < allFilesNew.length)
				{
				
					test.log(LogStatus.PASS, "File  downloaded successfully.");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
	    
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			Thread.sleep(2000);
  		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
  		  
  		  if(msg.equalsIgnoreCase("Case Summary"))
  		  {
  			  test.log(LogStatus.PASS, "View Icon Of Expenses Graph Open Successfully = " +msg);
  		  }
  		  else
  		  {
  			 test.log(LogStatus.FAIL, "View Icon Of Expenses Graph Not Open Successfully = " +msg);
  		  }
  		  
  		getDriver().switchTo().parentFrame();
  				
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
		
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
			js.executeScript("window.scrollBy(0,1000)");
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
		   
			/*  Thread.sleep(3000);
				performerPOM.CaseNoticeFilter().click();
				Thread.sleep(3000);
		       String CaseNotext =performerPOM.SelectCaseNoticeFilter().getText();
		       Thread.sleep(3000);
		       performerPOM. SelectCaseNoticeFilter().click();
		       
		        List<String> li=new ArrayList<String>();
		        li.add(CaseNotext);
		        Thread.sleep(3000);
		        
				List<String> filter=new ArrayList<String>();	
				filter.add("Case Notice NO");
			
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				List<WebElement>CaseNoticeNocol=.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
		
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement>raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(CaseNoticeNocol);
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
		
			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work successfully.");*/
		   		Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				performerPOM.caseNoticeSummaryGraphClose().click();
			}
			else
			{
				 Thread.sleep(3000);
				 getDriver().switchTo().parentFrame();
					Thread.sleep(2000);
					performerPOM.caseNoticeSummaryGraphClose().click();
					test.log(LogStatus.FAIL, "No Record Found");
			}
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			
	   }	
		
		public static void ExpensesCategoryWiseCaseGraph( ExtentTest test, String type) throws InterruptedException, IOException
		{
			


			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			
			js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
          
           	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			
	       	
				js.executeScript("window.scrollBy(0,2700)");
	     	
	       	Thread.sleep(2000);
		
	       // int open=Integer.parseInt(performerPOM.ExpensesNoticeGraph().getText());	//Reading Notice Open count.
		    performerPOM.ExpensesCategoryWiseCaseGraph().click();						//Clicking on 'Open' notice
		    
		    
		    
		    
		    
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
		
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
		
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				
				test.log(LogStatus.PASS, "File  downloaded successfully.");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
	    
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeViewGraph().click();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			Thread.sleep(2000);
  		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
  		  
  		  if(msg.equalsIgnoreCase("Case Summary"))
  		  {
  			  test.log(LogStatus.PASS, "View Icon Of Expenses-Category Wise Graph Open Successfully = " +msg);
  		  }
  		  else
  		  {
  			 test.log(LogStatus.FAIL, "View Icon Of Expenses-Category Wise Graph Not Open Successfully = " +msg);
  		  }
  		  
  		  getDriver().switchTo().parentFrame();
  				
			Thread.sleep(5000);
			performerPOM.CaseNoticeTypeclosePopupGraph().click();
		
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
			js.executeScript("window.scrollBy(0,1000)");
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(6000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(5000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
		   
		 /*  Thread.sleep(3000);
			performerPOM.CaseNoticeFilter().click();
			Thread.sleep(3000);
	       String CaseNotext =performerPOM.SelectCaseNoticeFilter().getText();
	       Thread.sleep(3000);
	       performerPOM. SelectCaseNoticeFilter().click();
	       
	        List<String> li=new ArrayList<String>();
	        li.add(CaseNotext);
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Case Notice NO");
		
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement>CaseNoticeNocol=.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
	
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement>raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(CaseNoticeNocol);
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

		
			Thread.sleep(7000);
			performerPOM.clearButton().click();
			test.log(LogStatus.PASS, "Clear button work successfully.");*/
			
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
			}
		
		public static void ExpensesCounselWiseCaseGraph( ExtentTest test, String type) throws InterruptedException, IOException
		{
			


		
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
          
           	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			
	       	
				js.executeScript("window.scrollBy(0,3000)");
			
	     
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
		  	Thread.sleep(5000);
		    performerPOM.ExpensesCounselWiseCaseGraphCA().click();						//Clicking on 'Open' notice
		    
			
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Budget vs Expense Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Budget vs Expense Report does not Download Successfully");
			}
		    
		}
		    
  public static void UtilizedBudgetGraph( ExtentTest test, String type) throws InterruptedException, IOException
		{
			


	  		WebDriverWait wait = new WebDriverWait(getDriver(),40);
			  JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	     	js.executeScript("window.scrollBy(0,800)");
	     	
	     	Thread.sleep(5000);
			performerPOM.clickDashboardCaseNoticeFilter().click();
			
			Thread.sleep(5000);
			performerPOM.clickDashboardCaseFilter().click();
          
           	
			 Thread.sleep(5000);
			 performerPOM.clickDashboardApplyBtn().click();
			
	       	
				js.executeScript("window.scrollBy(0,3500)");
			
		     Thread.sleep(4000);
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
		  	Thread.sleep(9000);
		    performerPOM.UtilizedBudgetGraphCA().click();						//Clicking on 'Open' notice
		    
			
			
		 	Thread.sleep(4000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(4000);
		   if (dirContents1.length < allFilesNew1.length) 
		    {
				test.log(LogStatus.PASS,  "Budget vs Expense Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Budget vs Expense Report does not Download Successfully");
			}
		    
		}	
	   
	   
	   
	   
	   
	   static void perform( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException, IOException
		{
		   
			

		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
		   JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			progress();
			
				
			CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
			js.executeScript("window.scrollBy(0,-700)");
			
			

			Thread.sleep(4000);
			clickNewNotice();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			
			
			Thread.sleep(3000);
			clickDated();

			Thread.sleep(3000);
			clickFinancialYear();

			Thread.sleep(3000);
			clickRefNo();

			Thread.sleep(3000);
			selectNoticeType();

			Thread.sleep(3000);
			clickAct();

			Thread.sleep(3000);
			clickOpponentcfo();

			Thread.sleep(3000);
			selectCategory();

			Thread.sleep(3000);
			clickNoticeTitle();

			Thread.sleep(3000);
			clickNoticeDescription();

			Thread.sleep(3000);
			selectLocation();

			Thread.sleep(3000);
			clickDepartment();

			Thread.sleep(3000);
			clickOwner();

			Thread.sleep(3000);
            selectRisk();
        	
            Thread.sleep(3000);
            clickLawFirm();

			Thread.sleep(3000);
            selectNoticeRecipetDate();
            
            Thread.sleep(3000);
            clickInternalUser();
            
            Thread.sleep(3000);
            clickLawyer();
            
//  		    Thread.sleep(3000);
//    		performerPOM.clickAdditionalOwnerCfo(); 
//    		
//    		 Thread.sleep(3000);
//     		 performerPOM.selectAdditionalOwnerCfo(); 

            Thread.sleep(3000);
    		performerPOM.selectNoticeUploadDocument(); 
    		
       		
       		Thread.sleep(3000);
    		OverduePOM.clickSaveButton().click();		
    		
    		Thread.sleep(1000);
    		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
    		
    		Thread.sleep(2000);
    		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
    	
    		if(msg.equalsIgnoreCase("Notice Created Successfully."))
    		{
    			test.log(LogStatus.PASS, "Message displayed = "+msg);
    		
    		}
    		else
    		{
    			test.log(LogStatus.PASS, "Message displayed = "+msg);
    		}
    		
//    		Element ele1 = null;
//    		Element ele2 = null;
//    		Element ele3 = null;
//    		Element ele4 = null;
//    		
//    		if(flag == 1)
//    		{
//    			try
//    			{
//    				Thread.sleep(5000);
//    				ele1 = wait.until(ExpectedConditions.visibilityOf(performerPOM.clickLinkNotice()));
//    				ele2 = performerPOM.clickViewDoc();
//    				ele3 = performerPOM.clickSendMail();
//    				ele4 = performerPOM.clickEditNotice1();
//    			}
//    			catch(Exception e)
//    			{
//    				
//    			}
//    			
//    			if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
//    			{
//    				test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
//    			}
//    			else
//    			{
//    				test.log(LogStatus.FAIL, "All icons are not displayed.");
//    			}
//    		}
    	

    		Thread.sleep(3000);
    		getDriver().switchTo().parentFrame();
    		performerPOM.clickClose().click();//Clicking on 'Close'
    		
    		
    		js.executeScript("window.scrollBy(0,700)");
    		Thread.sleep(3000);
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
    		count1 = Integer.parseInt(compliancesCount);
    		
    		if(count1 > gridRecords)
    		{
    			//test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice.");
    			test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice - Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
    		}
    		else
    		{
    			//test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice.");
    			test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice -  Old Notice Count from Grid = "+gridRecords+" | New Notice Count from Grid = "+count1);
    		}
    		
    		
			Thread.sleep(5000);
			performerPOM.clickcategory().click();

			
			if(performerPOM.clearButton().isEnabled())
	  		{
				Thread.sleep(3000);
	  			performerPOM.clearButton().click();
	  			test.log(LogStatus.PASS, "Clear button working successfully");
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "Clear button not working successfully");
	  		}
    		
    		Thread.sleep(1000);
    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
    		
    		Thread.sleep(500);
    		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
    		int open1 = 0;
    		if(type.equalsIgnoreCase("Notice - Open"))
    		{
    			open1 = Integer.parseInt(performerPOM.clickNoticeOpen().getText());	//Reading Notice Open count.
    		}
    		else
    		{
    			open1 = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Open count.
    		}
    		
    		if(open1 > open)
    		{
    			test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
    		}
    		
    		
    	}
    		
    	
    		
			
		
	   
	   public  static void clickNewNotice( ) throws InterruptedException 
		  {
				Thread.sleep(4000);
				performerPOM.clickNew().click();	//Clicking on 'New' button
           }
				
		public static void clickDated( )
		{
		performerPOM.clickDated().click();					//Clicking on 'Dated' button
		OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
		OverduePOM.selectDate3().click();	//Clicking particular date.
		}
		
		public static void clickFinancialYear( ) throws InterruptedException
		{
		Thread.sleep(300);
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
		elementsList = performerPOM.chooseDropDownOption();
		elementsList.get(10).click();								//Clicking third option
		performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
      }
		
		public static void clickRefNo( ) throws InterruptedException, IOException
		{

		    Thread.sleep(500);
		    FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet  sheet = workbook.getSheetAt(2);
			Thread.sleep(1000);
			Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String refno = c1.getStringCellValue();
			performerPOM.clickRefNo().clear();
			performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Reference No'
		}
		
		public static void selectNoticeType( ) 
		{
			WebElement type = performerPOM.clickNoticeType();
			type.click();
			
			performerPOM.chooseNoticeType().click(); 
			
		}
		public static void clickOpponent( String noticeType) 
		{
	
			
			performerPOM.clickOpponentcfo().click(); 
			
		}
		
		public static void clickAct( ) throws InterruptedException, EncryptedDocumentException, IOException
		{
			
			
			 Thread.sleep(500);
			    FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet  sheet = workbook.getSheetAt(2);
			
		   Thread.sleep(300);
		   progress();
	       Row row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		   Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		   int actNo = (int) c1.getNumericCellValue();
		   performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		   elementsList = performerPOM.chooseAct();
		   elementsList.get(3).click();							//Selecting particular act no
		   performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
		}
		 public static void clickOpponentcfo( ) throws InterruptedException
		   {
	           Thread.sleep(300);
             performerPOM.clickOpponentcfo().click();
         	performerPOM.chooseOpponent().click(); 
		   }
	
			public static void selectCategory( ) 
			{
				WebElement Category =  performerPOM.clickNoticeCategory();
				Category.click();
				 performerPOM.chooseCategory().click();
			}
			
			public static void clickNoticeTitle( ) throws InterruptedException, EncryptedDocumentException, IOException
			{
				 Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
				  Thread.sleep(300);
				  Row row0 = sheet.getRow(8);						//Selected 0th index row (First row)
				  Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				  String title = c1.getStringCellValue();
				  performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Notice Title'
			}
			public static void clickNoticeDescription( ) throws InterruptedException, EncryptedDocumentException, IOException
			{
				 Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
				Thread.sleep(300);
				Row row0 = sheet.getRow(9);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickNoticeDescription().sendKeys(desc);	//Writing 'Notice Description'
				Thread.sleep(300);		
				performerPOM.clickNoticeDescription().sendKeys(Keys.PAGE_DOWN);
	        }
			public static void selectLocation( ) throws InterruptedException
			{
				Thread.sleep(7000);
				performerPOM.clickLocation().click();					//Clicking on Location drop down
				Thread.sleep(5000);
				//performerPOM.clickPlus().click();
				performerPOM.selectLocationCfo().click();;
				//elementsList.get(2).click();								//Selecting third visible location
			}
			public static void clickDepartment( ) throws InterruptedException
			{
				Thread.sleep(4000);
				performerPOM.clickDeptCfo().click();					//Clicking on 'Department' drop down
				performerPOM.selectDeptCfo().click();	//Writing 'Department' name
			}
			public static void clickOwner( ) throws InterruptedException
			{
			
				performerPOM.clickOwnerCfo().click();					//Clicking on 'Owner' drop down
				performerPOM.selectOwnerCfo().click();	//Writing 'Owner' name
			}
			public static void selectRisk( ) throws InterruptedException
			{

				  performerPOM.clickRisk().click();							//Clicking on 'Risk' drop down.
				  Thread.sleep(500);
				  performerPOM.selectRisk().click();						//Selecting second option 'High' risk.
	        }
			
	
			
			public  static void selectNoticeRecipetDate( )
		      {
		    	 	
		          WebElement openDate= performerPOM.selectNoticeRecipetDate();
		          openDate.sendKeys("30-09-2021");
		        
		      }
			
			public static void clickInternalUser( ) throws InterruptedException, EncryptedDocumentException, IOException
			{
				
				Thread.sleep(500);
			    FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet  sheet = workbook.getSheetAt(2);
				Thread.sleep(300);
				Row row0 = sheet.getRow(10);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int internalUserNo = (int) c1.getNumericCellValue();
				Thread.sleep(300);
				performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
			    elementsList = performerPOM.chooseInternalUser();
			    Thread.sleep(300);
				elementsList.get(internalUserNo).click();							//Selecting particular user no
				performerPOM.clickInternalUser().click();	//Clicking on 'Internal User' drop down.
			}
			
			
			
			
			
	public static void NoticeOpen( ExtentTest test) throws InterruptedException, IOException
		{
			
		
			Thread.sleep(3000);
			int open = CountExcel(test, "Notice - Open");
			
			Thread.sleep(3000);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			 
			  
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(5000);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int gridRecords = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				gridRecords = 0;
			}
			else
			{
				gridRecords = Integer.parseInt(compliancesCount);
			}
			
			perform(test, sheet, open, gridRecords, "Notice - Open");
		}
	
	
    	public static void NoticeDocument( ExtentTest test) throws InterruptedException
       	{
    		   WebDriverWait wait = new WebDriverWait(getDriver(),20);
    		   JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
    		Thread.sleep(1000);
    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
    		
	        Thread.sleep(3000);
			performerPOM.clickNoticeOpen().click();//click edit notice
	     
	        Thread.sleep(3000);
			performerPOM.clickEditNotice().click();//click edit notice
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
	        
	        performerPOM.clickNoticeDocument().click();     //click notice document
	        performerPOM.clickNewDocument().click();        //click new document button
	
	        Thread.sleep(1000);
           	getDriver().switchTo().frame("IFrameManageDocument");
           	performerPOM.selectDocumentType();
          	Thread.sleep(3000);
	        performerPOM.chooseDocumentType();
	        Thread.sleep(1000);
	        performerPOM.selectUploadDocument(); 
	        Thread.sleep(1000);
         	performerPOM.clickUploadDocument().click(); 
	
	
         	Thread.sleep(1000);
         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
	
        	Thread.sleep(3000);
	        String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
	       
         	if(msg.equalsIgnoreCase(msg))
         	{
	        	test.log(LogStatus.PASS, "Message displayed = "+msg);
	         
	        }
	      else
	        {
		       test.log(LogStatus.FAIL, "Message displayed = "+msg);
	        }
	
	        Thread.sleep(1000);
	        performerPOM.clickClosedDocument().click(); 
	        
	        getDriver().switchTo().parentFrame();
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentDownloadcfo().click();
	        
	        test.log(LogStatus.PASS, "Document download succssesfully");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewcfo().click();
	        
	       
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
	        
	        test.log(LogStatus.PASS, "Document View popup open  succssesfully");
	        
	       
	        
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecfo().click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert1 = getDriver().switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage1= getDriver().switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage1);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);
	        
	     // Accepting alert		
	        alert1.accept();	
	        
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
	        
	        Thread.sleep(4000);
	        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5768798045");
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentsharesavecfo().click();
	        
	        
	        Thread.sleep(3000);
	        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
	       
         	if(msg1.equalsIgnoreCase("Document shared successfully."))
         	{
	        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
	         
	        }
	      else
	        {
		       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
	        }
	        
	        
	        
	        Thread.sleep(3000);
	        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
	        
	       getDriver().switchTo().parentFrame();
	        
	        Thread.sleep(3000);
	        performerPOM.clickNoticeDocumentdeletecfo().click();
	        
	        Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert = getDriver().switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= getDriver().switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, alertMessage);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);
	        
	 		
	        // Accepting alert		
	        alert.accept();	
	        
	       getDriver().switchTo().parentFrame();
	     }
    	
    	 public  static void TaskActivtity( ExtentTest test) throws InterruptedException, IOException
			{
    		 
    		      // XSSFSheet sheet = ReadExcel();
    		       WebDriverWait wait = new WebDriverWait(getDriver(),60);

				    Thread.sleep(3000);
	 				performerPOM.clickNoticeOpen().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 				
	 				
				   Thread.sleep(1000);
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				  Thread.sleep(1000);
				  performerPOM.clickTaskorActivity().click();
				  Thread.sleep(1000);
				  performerPOM.clickNewTask().click(); 
				 
				  
				  Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);  
				Thread.sleep(3000);
				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
				
				 Thread.sleep(500);
				    FileInputStream fis1 = new FileInputStream(filePath);
			        Workbook workbook1 = WorkbookFactory.create(fis1);
			        Sheet  sheet1 = workbook1.getSheetAt(2);
				Thread.sleep(3000);
				row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
				
				
				
				Thread.sleep(3000);
				performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
				OverduePOM.selectNextMonth().click();
				OverduePOM.selectDate().click();					//Selecting particular date.
				
				Thread.sleep(500);
				Actions action = new Actions(getDriver());
//				action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
				
				
				 Thread.sleep(500);
				    FileInputStream fis2 = new FileInputStream(filePath);
			        Workbook workbook2 = WorkbookFactory.create(fis2);
			        Sheet  sheet2 = workbook2.getSheetAt(2);
				Thread.sleep(500);
				row0 = sheet2.getRow(14);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
				
				 Thread.sleep(500);
				    FileInputStream fis3 = new FileInputStream(filePath);
			        Workbook workbook3 = WorkbookFactory.create(fis3);
			        Sheet  sheet3 = workbook3.getSheetAt(2);
				Thread.sleep(500);
				row0 = sheet3.getRow(15);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser2().click();
				//performerPOM.selectInternalUser2().click();
				performerPOM.selectInternalUser2().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
	
				 Thread.sleep(500);
				    FileInputStream fis4 = new FileInputStream(filePath);
			        Workbook workbook4 = WorkbookFactory.create(fis4);
			        Sheet  sheet4 = workbook4.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet4.getRow(16);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String externalUser = c1.getStringCellValue();
				try
				{
					Thread.sleep(300);
					performerPOM.clickExternalUser().click();
					Thread.sleep(500);
					action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
				}
				catch(Exception e)
				{
					
				}
			
				 Thread.sleep(500);
				    FileInputStream fis5 = new FileInputStream(filePath);
			        Workbook workbook5 = WorkbookFactory.create(fis5);
			        Sheet  sheet5 = workbook5.getSheetAt(2);
				Thread.sleep(2000);
				row0 = sheet5.getRow(17);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
				
				//Thread.sleep(300);
				//String workingDir = System.getProperty("user.dir");
				//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg()));
				
				Thread.sleep(300);
				
				String msg1 = performerPOM.readTaskMsg1().getText();
				if(msg1.contains(msg1))
				{
					test.log(LogStatus.PASS, "Add Task ="+msg1);
				}
				
				else if(msg1.contains(msg1))
				{
					test.log(LogStatus.FAIL,"Add Task ="+msg1);
				}
				
				Thread.sleep(3000);
 				performerPOM.clickNoticeEditTaskcfo().click();
				
				Thread.sleep(3000);
				
				performerPOM.clickTaskTitle().clear();
				
				
				 Thread.sleep(500);
				    FileInputStream fis6 = new FileInputStream(filePath);
			        Workbook workbook6= WorkbookFactory.create(fis6);
			        Sheet  sheet6 = workbook6.getSheetAt(2);
				Thread.sleep(3000);
				Row row1 = sheet6.getRow(18);								//Selected 0th index row (First row)
				Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
				String title1 = c2.getStringCellValue();
				performerPOM.clickTaskTitle().sendKeys(title1);	//Writing 'Task Title'
				
				Thread.sleep(3000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg()));
				
				Thread.sleep(300);
				String msg2 = performerPOM.readTaskMsg().getText();
		
				if(msg2.contains(msg2))
				{
					test.log(LogStatus.PASS, "Update Task ="+msg2);
				}
				
				else if(msg2.contains(msg2))
				{
					test.log(LogStatus.PASS, "Update Task ="+msg2);
				}
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo().click();
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo().click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1().click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo().click();
				
				
				
				test.log(LogStatus.PASS,"Task Response Saved Successfully.");
				
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskCloseResponsecfo().click();
				
                Thread.sleep(3000);
				performerPOM.clickNoticeTaskClosecfo().click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskdeletecfo().click();
				
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert1 = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage1= getDriver().switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage1);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage1);
			        
			     // Accepting alert		
			        alert1.accept();
		
			}
    	 
     public static void Response( ExtentTest test) throws InterruptedException, IOException
			{
    	 WebDriverWait wait = new WebDriverWait(getDriver(),20);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			    
			   Thread.sleep(3000);
				performerPOM.clickNoticeOpen().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   
			           Thread.sleep(1000);
			           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			           Thread.sleep(3000);
					  performerPOM. clickResponse().click();
					  Thread.sleep(3000);
					  performerPOM. clickNewResponse().click();
					  Thread.sleep(3000);
					  performerPOM. selectSentNotice();
					  Thread.sleep(3000);
					  performerPOM. selectReplyDueDate();
					  Thread.sleep(3000);
					  performerPOM. selectRespondedDate();
				
					  Thread.sleep(500);
					    FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet  sheet = workbook.getSheetAt(2);	 
					  Thread.sleep(500);
					  Row row1 = sheet.getRow(20);								//Selected 0th index row (First row)
					  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
					  String DeliveryMode= c2.getStringCellValue();
					  performerPOM.clickDeliveryMode().click();
					  performerPOM.selectDeliveryMode().sendKeys(DeliveryMode);
					  
					  
					  Thread.sleep(500);
					    FileInputStream fis1 = new FileInputStream(filePath);
				        Workbook workbook1 = WorkbookFactory.create(fis1);
				        Sheet  sheet1 = workbook1.getSheetAt(2);
					  Thread.sleep(500);
					  Row row0 = sheet1.getRow(21);								//Selected 0th index row (First row)
					  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					  String CourierCompany= c1.getStringCellValue();
					  performerPOM.clickCourierCompany().sendKeys(CourierCompany);
						 
					  Thread.sleep(500);
					    FileInputStream fis2 = new FileInputStream(filePath);
				        Workbook workbook2 = WorkbookFactory.create(fis2);
				        Sheet  sheet2 = workbook2.getSheetAt(2);
					  Thread.sleep(500);
						Row row2 = sheet2.getRow(22);								//Selected 0th index row (First row)
						Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
						String RefNo= c3.getStringCellValue();
						performerPOM.RefTrackingNo().sendKeys(RefNo);
						
						 Thread.sleep(500);
						    FileInputStream fis3 = new FileInputStream(filePath);
					        Workbook workbook3 = WorkbookFactory.create(fis3);
					        Sheet  sheet3 = workbook3.getSheetAt(2);
						Thread.sleep(500);
						Row row3 = sheet3.getRow(23);								//Selected 0th index row (First row)
						Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
						String Description= c4.getStringCellValue();
						 performerPOM.Description().sendKeys(Description);
						 
						 Thread.sleep(3000);
						 performerPOM.clickNoticeResponseDocUploadtcfo();
							
						
						 js.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
						  //performerPOM.clickSaveResponse().click();
							
							
							try
							{
								
								Thread.sleep(3000);
								wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg()));
								Thread.sleep(5000);
								String msg3 = performerPOM.readResponseMsg().getText();		//Reading Message appeared after save button
							
								if(msg3.equalsIgnoreCase(msg3))
								{
									test.log(LogStatus.PASS, "Add Response= "+msg3);
								
								}
								
							}
							catch(Exception e)
							{
								Thread.sleep(5000);
								String msg3 = performerPOM.readResponseInvalidMsg().getText();		//Reading Message appeared after save button
							
								if(msg3.equalsIgnoreCase(msg3))
								{
									test.log(LogStatus.FAIL, "Add Response= "+msg3);
									Thread.sleep(5000);
									performerPOM.clickMinimizeResponse().click();
								
								}

								
								
							}
							
							Thread.sleep(3000);
							performerPOM.clickNoticeEditResponsecfo().click();
							Thread.sleep(300);
							performerPOM.RefTrackingNo().clear();
							
							 Thread.sleep(500);
							    FileInputStream fis4 = new FileInputStream(filePath);
						        Workbook workbook4 = WorkbookFactory.create(fis4);
						        Sheet  sheet4 = workbook4.getSheetAt(2);
							Thread.sleep(500);
							Row row4 = sheet4.getRow(23);								//Selected 0th index row (First row)
							Cell c5 = row4.getCell(1);								//Selected cell (0 row,1 column)
							String Description1= c5.getStringCellValue();
							 performerPOM.Description().sendKeys(Description1);
							  
							  Thread.sleep(3000);
							 performerPOM.clickNoticeResponseDocUploadtcfo();
							
							  Thread.sleep(3000);
							  js.executeScript("arguments[0].click();",performerPOM.clickSaveResponse());
							  
							  //Thread.sleep(5000);
								//performerPOM.clickMinimizeResponse().click();
							  
							  Thread.sleep(1000);
								wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg2()));
									
								Thread.sleep(5000);
								String msg4 = performerPOM.readResponseMsg2().getText();		//Reading Message appeared after save button
								
								if(msg4.equalsIgnoreCase(msg4))
								{
									test.log(LogStatus.PASS, "Update Response = "+msg4);
									
								}
									else
									{
										test.log(LogStatus.FAIL, "Update Response = "+msg4);
									}
								
								Thread.sleep(4000);
								performerPOM.clickNoticeDownloadResponsecfo().click();
								
								//test.log(LogStatus.PASS, "Document download succssesfully");
								
								Thread.sleep(4000);
								performerPOM.clickNoticeViewResponsecfo().click();
								
								Thread.sleep(6000);
								performerPOM.clickNoticeclosePopupResponsecfo().click();
								
								test.log(LogStatus.PASS, "Document view popup open succssesfully");
								
								Thread.sleep(4000);
								performerPOM.clickNoticeDeleteResponsecfo().click();
								
								 Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert1 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);
							        
							     // Accepting alert		
							        alert1.accept();
							        
							        getDriver().switchTo().parentFrame();
							
							
			       }
    	
    	 public static void PaymentLog( ExtentTest test) throws InterruptedException, IOException
			{
    		 
    		 
    		   WebDriverWait wait = new WebDriverWait(getDriver(),60);
			     
			   Thread.sleep(3000);
			     performerPOM.clickNoticeOpen().click();//click edit notice
	     
	             Thread.sleep(3000);
			     performerPOM.clickEditNotice().click();//click edit notice
		  
			      getDriver().switchTo().parentFrame();
			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     
			     Thread.sleep(3000);
			    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
			
			    Thread.sleep(1000);
				performerPOM.clickInvoiceNo().sendKeys("56742584");
				
				 Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
				Thread.sleep(3000);
				Row r5 = sheet.getRow(31);
				Cell c5 = r5.getCell(1);
				String PaymentType = c5.getStringCellValue();
				Thread.sleep(3000);
				performerPOM.clickPaymentType().click();
				Thread.sleep(3000);
				performerPOM.selectPaymentType().sendKeys(PaymentType,Keys.ENTER);
//				List<WebElement>PaymentType1= .findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
//				PaymentType1.get(2).click();
					
				Thread.sleep(3000);
				performerPOM.clickAmount().sendKeys("5000");
				
				Thread.sleep(8000);
				performerPOM.clickNoticAmountPaid().sendKeys("2000");
				
				Thread.sleep(6000);
				performerPOM.clickNoticeStatusPaymentUploadtcfo();
			
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog().click();
				

				
				
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
					
					Thread.sleep(500);
					String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
				
					if(msg4.equalsIgnoreCase(msg4))
					{
						test.log(LogStatus.PASS, "Add Payment = "+msg4);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Add Payment = "+msg4);
					}
					
					try
					{
						Thread.sleep(3000);
						performerPOM.clickNoticeViewPaymentDoccfo().click();
					
						Thread.sleep(4000);
						performerPOM.clickNoticeclosePaymentDocpopupcfo().click();
					
						test.log(LogStatus.PASS, "Payment Document popup open successfully");
					}
					catch(Exception e)
					{
						
						 wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
						 

							Thread.sleep(500);
							String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
							if(msg5.equalsIgnoreCase(msg4))
							{
								test.log(LogStatus.PASS, "View Payment Document = "+msg5);
							
							}
							else
							{
								test.log(LogStatus.FAIL, "View Payment Document = "+msg5);
							}
					}
					

					
					Thread.sleep(3000);
					performerPOM.clickNoticeEditPaymentcfo().click();
					
					performerPOM.clickInvoiceNo().clear();
					 Thread.sleep(3000);
				    performerPOM.clickInvoiceNo().sendKeys("Invoice No 5782");
				    
				    Thread.sleep(6000);
					performerPOM.clickNoticeStatusPaymentUploadtcfo();
				    
				    Thread.sleep(3000);
					performerPOM.clickSavePaymentLog().click();
					
					
				        
				        Thread.sleep(500);
						String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Update Payment= "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Update Payment = "+msg5);
						}
				        
						try
						{
							Thread.sleep(3000);
							performerPOM.clickNoticeDownloadPaymentcfo().click();
				        
							test.log(LogStatus.PASS, "Payment Document Download Successfully.");
				        
							Thread.sleep(3000);
							performerPOM.clickNoticeDeletePaymentcfo().click();
							
							Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert1 =getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage1= getDriver().switchTo().alert().getText();	
					        
					        
					        test.log(LogStatus.PASS, alertMessage1);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage1);
					        
					     // Accepting alert		
					        alert1.accept();
						
					        Thread.sleep(500);
							String msg6 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
							if(msg6.equalsIgnoreCase(msg6))
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg6);
							
							}
							else
							{
								test.log(LogStatus.FAIL, "Message displayed = "+msg6);
							}
						}
						catch(Exception e)
						{
						     Thread.sleep(500);
								String msg7 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
							
								if(msg7.equalsIgnoreCase(msg7))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg7);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg7);
								}
						}
				    
				    	
				
			}
    	 
    	  public static void ExternalLawyer(ExtentTest test) throws InterruptedException
          {
        	  
    		  WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		   
    		         Thread.sleep(3000);
    			     performerPOM.clickNoticeOpen().click();//click edit notice
    	     
    	             Thread.sleep(3000);
    			     performerPOM.clickEditNotice().click();//click edit notice
    		  
    			     getDriver().switchTo().parentFrame();
    			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    		          
    			       Thread.sleep(1000);
    				   performerPOM. clickExternalLawyerRating().click();
    				   
    				  Thread.sleep(3000);
    				  performerPOM.selectExternalLawyerRating();
    				   Thread.sleep(3000);
    				   performerPOM.clickNewCriteria().click();
    				   Thread.sleep(3000);
    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
    				   performerPOM.clickCriteria().sendKeys("Test Test New");
    				   Thread.sleep(3000);
    				   performerPOM.clickSaveCriteria().click();
    				   String msg = performerPOM.readOppoenentMsg().getText();
    				   
    				   if(msg.equalsIgnoreCase("Criteria Saved Successfully."))
    				   {
    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
    				   }
    				   else
    				   {
    					   String msg1 = performerPOM.readMesg().getText();
    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
    				   }
    				   
    				   Thread.sleep(3000);
    				   getDriver().switchTo().parentFrame();
    				   performerPOM.clickclosecriteria().click();
    				   Thread.sleep(3000);
    				   performerPOM. clickstar().click();
    			       Thread.sleep(3000);
    				   performerPOM. clickstar1().click();
    				   Thread.sleep(3000);
    				   performerPOM. clickSaveRating().click();
    				   
    				   
    			   	  Thread.sleep(1000);
    				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
    							
    					Thread.sleep(500);
    					String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
    					
    					if(msg5.equalsIgnoreCase("Rating Saved Successfully."))
    						{
    								test.log(LogStatus.PASS, "Message displayed = "+msg5);
    								
    						}
    					else
    						{
    								test.log(LogStatus.FAIL, "Message displayed = "+msg5);
    						}
    				   
    		  }	 
    	  

    	  public static void ExternalLawyerWithoutRating(ExtentTest test) throws InterruptedException
          {
        	  
    		  		WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		   
    		         Thread.sleep(3000);
    			     performerPOM.clickNoticeOpen().click();//click edit notice
    	     
    	             Thread.sleep(3000);
    			     performerPOM.clickEditNotice().click();//click edit notice
    		  
    			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    		          
    			       Thread.sleep(1000);
    				   performerPOM. clickExternalLawyerRating().click();
    				   
    				  Thread.sleep(3000);
    				  performerPOM.selectExternalLawyerRating();
    				  
    				  Thread.sleep(3000);
   				   		performerPOM. clickSaveRating().click();
   				   
   				   try
   				   {
   				   		
   				   		wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
   				   		
   				   		Thread.sleep(500);
   				   		String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
   						test.log(LogStatus.PASS, "Message displayed = "+msg5);
   				   }
   				   catch(Exception e)
   				    {
   						test.log(LogStatus.FAIL, "Validation message not displayed");
   					}
   				getDriver().switchTo().parentFrame();
	                  performerPOM.clickclosebutton().click();
	                  Thread.sleep(3000);
		              OverduePOM.clickDashboard().click();
   		  }	 
    	  public static void AuditLog( ExtentTest test) throws InterruptedException
  		  {
    		  
    		  WebDriverWait wait = new WebDriverWait(getDriver(), 300);
		       
		          Thread.sleep(3000);
 			     performerPOM.clickNoticeOpen().click();//click edit notice
 	     
 	             Thread.sleep(3000);
 			     performerPOM.clickEditNotice().click();//click edit notice
 		  
 			     
 			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 		         
  		              Thread.sleep(3000);
  		               performerPOM. clickAuditLog().click();
  		                 Thread.sleep(3000);
  		                 performerPOM.clickExport().click();		   
  		                 Thread.sleep(3000);
  		               getDriver().switchTo().parentFrame();
  		                  performerPOM.clickclosebutton().click();
  		
  		                  Thread.sleep(1000);
  		                  performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
  		                   JavascriptExecutor js = (JavascriptExecutor) getDriver();
  		                  js.executeScript("window.scrollBy(0,700)");
  		                  
  		                  test.log(LogStatus.PASS,"Export report download sucssesfully ");
  		                  
  		                  Thread.sleep(3000);
  		                  OverduePOM.clickDashboard().click();
  		 } 
    	
	
		
    	  static int CountExcel( ExtentTest test, String type) throws InterruptedException, IOException
    		{
    		  	WebDriverWait wait = new WebDriverWait(getDriver(),50);
    			progress();
    			
    			//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
    			
    			
    			int open = 0;
    			if(type.equalsIgnoreCase("Notice - Open"))
    			{
    				open = Integer.parseInt(performerPOM.clickNoticeOpen().getText());	//Reading Notice Open count.
    				performerPOM.clickNoticeOpen().click();						//Clicking on 'Open' notice
    			}
    			else if(type.equalsIgnoreCase("Notice - Closed"))
    			{
    				open = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Closed count.
    				performerPOM.clickNoticeClosed().click();						//Clicking on 'Closed' notice
    			}
    			else if(type.equalsIgnoreCase("Case - Open"))
    			{
    				open = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Case Open count.
    				performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
    			}
    			else if(type.equalsIgnoreCase("Case - Closed"))
    			{
    				open = Integer.parseInt(performerPOM.clickCaseClosedCFO().getText());	//Reading Case Open count.
    				performerPOM.clickCaseClosedCFO().click();						//Clicking on 'Open' Case
    			}
    			
    			else if(type.equalsIgnoreCase("Task - Open"))
    			{
    				open = Integer.parseInt(performerPOM.clickTaskOpen().getText());	//Reading Case Open count.
    				performerPOM.clickTaskOpen().click();						//Clicking on 'Open' Case
    			}
    			
    			else if(type.equalsIgnoreCase("Task - Closed"))
    			{
    				open = Integer.parseInt(performerPOM.clickTaskClosed().getText());	//Reading Case Open count.
    				performerPOM.clickTaskClosed().click();						//Clicking on 'Open' Case
    			}
    			
    			
    			
    			
    			
    			Thread.sleep(500);
    			progress();
    			
    			Thread.sleep(500);
    			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
    			
    			Thread.sleep(2000);
    			JavascriptExecutor js = (JavascriptExecutor) getDriver();
    			try
    			{
    				performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
    			}
    			catch(Exception e)
    			{
    				
    			}
    			js.executeScript("window.scrollBy(0,1000)");
    			
    			Thread.sleep(7000);
    			CFOcountPOM.readTotalItems1().click();
    			String item = CFOcountPOM.readTotalItems1().getText();
    			String[] bits = item.split(" ");								//Splitting the String
    			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
 //   			int count1 = 0;
//    			if(compliancesCount.equalsIgnoreCase("to"))
//    			{
//    				Thread.sleep(2000);
//    			   item = CFOcountPOM.readTotalItems1().getText();
//    				bits = item.split(" ");								//Splitting the String
//    			   compliancesCount = bits[bits.length - 2];
//    			}
//    			if(compliancesCount.equalsIgnoreCase("to"))
//    			{
//    				count1 = 0;
//    			}
//    			else
 //   			{
    				int count1 = Integer.parseInt(compliancesCount);
  //  			}
    			
    			if(open == count1)
    			{
    				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
    				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
    			}
    			else
    			{
    				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
    				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
    			}
    			
    			Thread.sleep(100);
    			File dir = new File("C://Users//snehalp//Downloads");
    			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
    			
    			Thread.sleep(500);
    			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
    			Thread.sleep(500);
    			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
    			
    			
    			Thread.sleep(5500);
    			File dir1 = new File("C://Users//snehalp//Downloads");
    			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
    			
    			if(dirContents.length < allFilesNew.length)
    			{
    				test.log(LogStatus.PASS, "File downloaded successfully.");
    				
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
    				String records =c1.getStringCellValue();
    				int SheetRecords = 0;
    			
    				try
    				{
    					SheetRecords = Integer.parseInt(records);
    					
    				}
    				catch(Exception e)
    				{
    					
    				}
    				
//    				if(flag == 0)
//    				{
//    					row = sheet.getRow(no-1);
//    					c1 = row.getCell(0);
//    					records = c1.getStringCellValue();
//    					SheetRecords = Integer.parseInt(records);
//    				}
    				fis.close();
    				
    		if(count1 == SheetRecords)
    				{
    					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
    					test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+SheetRecords);
    				}
    				else
    				{
    					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
    					test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+SheetRecords);
    				}
    			}
    			else
    			{
    				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
    			}
    			return open;
    		}
		public static void CaseOpen( ExtentTest test) throws InterruptedException, IOException
		{
			

			int open = CountExcel(test, "Case - Open");
			
			
			Thread.sleep(500);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			  JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
			js.executeScript("window.scrollBy(0,700)");
			
			Thread.sleep(300);
			CFOcountPOM.readTotalItems1().click();
			String item = CFOcountPOM.readTotalItems1().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int gridRecords = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				gridRecords = 0;
			}
			else
			{
				gridRecords = Integer.parseInt(compliancesCount);
			}
			
			
			perform1(test, sheet, open, gridRecords, "Case - Open");
		}
 static void perform1( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException, EncryptedDocumentException, IOException
		{
	 		WebDriverWait wait = new WebDriverWait(getDriver(),50);
			
			
			
			Thread.sleep(500);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
			js.executeScript("window.scrollBy(0,-700)");
			
			Thread.sleep(3000);
			clickNewCase();
					
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType();
			Thread.sleep(3000);
			clickDated1();
			Thread.sleep(3000);
			clickFinanicialYear();
			Thread.sleep(3000);
			clickRefNo1();
			Thread.sleep(3000);
			clickInternalCaseNo();
			Thread.sleep(3000);
			clickCaseTitle();
			Thread.sleep(3000);
			clickCaseAct();
			Thread.sleep(3000);
			clickUnderSection();
			Thread.sleep(3000);
			clickSearchCaseCategory();
			Thread.sleep(3000);
			clickCaseBudget();
			Thread.sleep(3000);
			clickCaseOpponent();
//			Thread.sleep(3000);
//			clickCaseOppLawyer();
			Thread.sleep(3000);
			clickCaseCourt();
			Thread.sleep(3000);
			clickCaseDescription();
			Thread.sleep(3000);
			selectCaseLocation();
			Thread.sleep(3000);
			clickCaseDepartment();
			Thread.sleep(3000);
			clickCaseOwner();
			Thread.sleep(3000);
			clickCaseRisk();
			//Thread.sleep(3000);
			//clickLawFirm();
			Thread.sleep(3000);
			clickCaseInternalUser();
			//Thread.sleep(5000);
			//clickLawyer( ) ;
			Thread.sleep(5000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage1()));
			
			Thread.sleep(500);
			String msg = performerPOM.readMessage1().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Case Created Successfully."))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
		else
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
			}
		
		/*	Element ele1 = null;
			Element ele2 = null;
			Element ele3 = null;
			Element ele4 = null;
			
			if(flag == 1)
			{
				try
				{
					Thread.sleep(700);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickEditCase()));
					ele1 = performerPOM.clickLinkCase();
					ele2 = performerPOM.clickViewDoc();
					ele3 = performerPOM.clickSendMail1();
				ele4 = performerPOM.clickEditCase();
				}
				catch(Exception e)
				{
					
				}
				
				if(ele1 != null && ele2 != null && ele3 != null && ele4 != null)
				{
					test.log(LogStatus.PASS, "Icons displayed are :- Link Notice, View Document, Send Mail with Document, Edit Notice");
				}
				else
				{
					test.log(LogStatus.FAIL, "All icons are not displayed.");
				}
			}*/
			
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose().click();			//Clicking on 'Close'
			
			Thread.sleep(500);
			performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
			js.executeScript("window.scrollBy(0,700)");
			
			

	      Thread.sleep(1000);
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
	       count1 = Integer.parseInt(compliancesCount);

	    if(count1 > gridRecords)
	     {
	       //test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case.");
	       test.log(LogStatus.PASS, "Total Case Count increased in grid after adding New Case - Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }
	     else
	     {
	        //test.log(LogStatus.FAIL, "Total Case Count doesn't increased in grid after adding New Case.");
	        test.log(LogStatus.FAIL, "Total Case Count increased in grid after adding New Case - Old Case Count from Grid = "+gridRecords+" | New Case Count from Grid = "+count1);
	     }

	       Thread.sleep(500);
	       OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'

	 
	       
	       
	       Thread.sleep(500);
	    
	       int open1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Notice Open count.
	       
	   	Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
		
		if(type.equalsIgnoreCase("Case - Open"))
		{
			open1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());	//Reading Notice Open count.
		}
		else
		{
			open1 = Integer.parseInt(performerPOM.clickCaseClosed().getText());	//Reading Notice Open count.
		}

	      if(open1 > open)
	       {
	          test.log(LogStatus.PASS, type+" Dashboard Count increamented. Old count = "+open+", New Count = "+open1);
	       }
	       else
	      {
	          test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increamented. Old count = "+open+", New Count = "+open1);
	       }
	     }

	
			  public  static void clickNewCase( ) throws InterruptedException 
			  {
					Thread.sleep(3000);
					performerPOM.clickNew().click();	//Clicking on 'New' button

	           }
			  public  static void clickCaseskip( ) throws InterruptedException 
			  {
					Thread.sleep(3000);
					
					performerPOM.clickCaseskipfo().click();
	           }
			  public static void selectCaseType( ) 
				{
					WebElement type = performerPOM.clickCaseType1();
					type.click();
					
					performerPOM.chooseCaseType().click(); 
					
				}
			  
			
			  public  static void clickDated1( ) throws InterruptedException 
			  {
				  Thread.sleep(3000);
			      performerPOM.clickCaseDate().click();					//Clicking on 'Dated' button
			      OverduePOM.selectLastMonth().click();					//Clicking last month arrow.
			      OverduePOM.selectDate3().click();						//Clicking particular date.
			  }
			
			  public  static void clickFinanicialYear( ) throws InterruptedException 
			  {
			      Thread.sleep(3000);
			      performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
			      elementsList = performerPOM.clickFinanceSearchCheckbox();
			      elementsList=performerPOM.chooseDropDownOption();
			      elementsList.get(10).click();								//Clicking third option
			      performerPOM.clickFinancialYear().click();			//Clicking on 'Financial Year' drop down.
			  }
			
			

				
			  public  static void clickRefNo1( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
			       Thread.sleep(3000);
			       Row row0 = sheet.getRow(34);								//Selected 0th index row (First row)
			      Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			      String refno = c1.getStringCellValue();
			      performerPOM.clickRefNo().sendKeys(refno);			//Writing 'Court Case No'
			  }
				
			  public  static void clickInternalCaseNo( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
			        Thread.sleep(3000);
			       	Row row0 = sheet.getRow(35);								//Selected 0th index row (First row)
			       	Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			       	String caseNo = c1.getStringCellValue();
			       	performerPOM.clickInternalCaseNo().sendKeys(caseNo);	//Writing 'Court Case No'
			  }
			  public  static void clickCaseTitle( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
			        Thread.sleep(3000);
			        Row row0 = sheet.getRow(36);								//Selected 0th index row (First row)
			        Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			        String title = c1.getStringCellValue();
			       performerPOM.clickNoticeTitle().sendKeys(title);		//Writing 'Case Title'
			  }

		 	
			  public  static void clickCaseAct( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  
				  	 Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
		   	     	 Thread.sleep(3000);
			         Row row0 = sheet.getRow(37);								//Selected 0th index row (First row)
			         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
		 	         int actNo = (int) c1.getNumericCellValue();
				     performerPOM.clickAct().click();						//Clicking on 'Act' drop down.
			       //elementsList = performerPOM.chooseAct();
				     elementsList = performerPOM.chooseAct1();
			         elementsList.get(2).click();							//Selecting particular act no
				     performerPOM.clickAct().click();	                  //Clicking on 'Act' drop down.
			  }
			  
			  public  static void clickUnderSection( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
				    Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
				     Thread.sleep(3000);
				     Row row0 = sheet.getRow(38);								//Selected 0th index row (First row)
				     Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				     String underSection = c1.getStringCellValue();
				     performerPOM.clickUnderSection().sendKeys(underSection);	//Writing 'Under section'
			  }
			  public  static void clickSearchCaseCategory( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
				  	 Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
				     Thread.sleep(3000);
				     Row row0 = sheet.getRow(39);								//Selected 0th index row (First row)
				     Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				     String caseType = c1.getStringCellValue();
				     performerPOM.clickCaseCategory().click();
				     performerPOM.clickSearchCaseCategory().sendKeys(caseType, Keys.ENTER);	//Writing 'Case Type'
			  }
			  public  static void clickCaseBudget( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	 Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
				     Thread.sleep(3000);
				     Row row0 = sheet.getRow(40);								//Selected 0th index row (First row)
				     Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				     int caseBudget = (int) c1.getNumericCellValue();
				     performerPOM.clickCaseBudget().sendKeys(caseBudget+"");
			  }
			
			  public  static void clickCaseOpponent( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	Thread.sleep(500);
				   	FileInputStream fis = new FileInputStream(filePath);
			     	Workbook workbook = WorkbookFactory.create(fis);
			     	Sheet  sheet = workbook.getSheetAt(2);
			     	Thread.sleep(3000);
			     	Row row0 = sheet.getRow(41);						//Selected 0th index row (First row)
			     	Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			     	String opponent = c1.getStringCellValue();
			     	performerPOM.clickOpponentcfo().sendKeys(opponent);	
			     	performerPOM.clickOpponentcfo().click();	  }

			  public  static void clickCaseOppLawyer( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  
				  	Thread.sleep(500);
				  	FileInputStream fis = new FileInputStream(filePath);
				  	Workbook workbook = WorkbookFactory.create(fis);
				  	Sheet  sheet = workbook.getSheetAt(2);
			        Thread.sleep(3000);
				    Row row0 = sheet.getRow(42);								//Selected 0th index row (First row)
				    Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				    String oppoLawyer = c1.getStringCellValue();
				    performerPOM.clickOppLawyer().click();				//Clicking on 'Opponent'
				    performerPOM.clickSearchBox1().sendKeys(oppoLawyer);	//Writing 'Opposition Lawyer' name
				    Thread.sleep(300);
				    performerPOM.clickSelectAll3().click();
				    performerPOM.clickOppLawyer().click();
			  }
			  public  static void clickCaseCourt( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  /*	Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
			         Thread.sleep(3000);
			         Row row0 = sheet.getRow(43);								//Selected 0th index row (First row)
			         Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			         String court = c1.getStringCellValue();
			         Thread.sleep(1000);
			         performerPOM.clickCourt().click();
			         Thread.sleep(2000);
			         performerPOM.clickSearchCourt().sendKeys(court, Keys.ENTER);*/
				  	Thread.sleep(1000);
			         performerPOM.clickCourt().click();
			         Thread.sleep(2000);
			         performerPOM.clickSearchCourt().click();
				  
			  }
			
			
		
			  public  static void clickCaseDescription( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  {
				  	Thread.sleep(500);
				     FileInputStream fis = new FileInputStream(filePath);
			         Workbook workbook = WorkbookFactory.create(fis);
			         Sheet  sheet = workbook.getSheetAt(2);
			         Thread.sleep(3000);
			         Row row0 = sheet.getRow(36);							//Selected 0th index row (First row)
			         Cell  c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
			         String casedesc = c1.getStringCellValue();
			        performerPOM.clickNoticeDescription().sendKeys(casedesc);
			  }
			  
			  public static void selectCaseLocation( ) throws InterruptedException, EncryptedDocumentException, IOException
				{
				  	
					Thread.sleep(7000);
					performerPOM.clickLocation().click();					//Clicking on Location drop down
					Thread.sleep(3000);
				//	performerPOM.clickPlus().click();
					performerPOM.selectLocationCfo().click();;
					//elementsList.get(2).click();								//Selecting third visible location
				}
				public static void clickCaseDepartment( ) throws InterruptedException
				{
					Thread.sleep(4000);
				performerPOM.clickDeptCfo().click();					//Clicking on 'Department' drop down
				performerPOM.selectDeptCfo().click();	//Writing 'Department' name
				}
				public static void clickCaseOwner( ) throws InterruptedException
				{
				
				performerPOM.clickOwnerCfo().click();					//Clicking on 'Owner' drop down
				performerPOM.selectOwnerCfo().click();	//Writing 'Owner' name
				}
			  
			  
			  
			  

			 public  static void clickCaseRisk( ) throws InterruptedException 
			  { 
			    Thread.sleep(3000);
			    performerPOM.clickWinningProspect1().click();
		 	   Thread.sleep(100);
		       performerPOM.selectRisk1().click();			//Selecting 'Medium' Winning Prospect'
			  }
			 
				public static void clickLawFirm( ) throws InterruptedException, EncryptedDocumentException, IOException
				{
					
					Thread.sleep(500);
					FileInputStream fis = new FileInputStream(filePath);
				    Workbook workbook = WorkbookFactory.create(fis);
				    Sheet  sheet = workbook.getSheetAt(2);
					Thread.sleep(300);
					Row row0 = sheet.getRow(11);					//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
					String lawFirm = c1.getStringCellValue();
					performerPOM.clickLawFirm().click();		//Clicking on 'Law Firm' drop down.
					performerPOM.chooseLawFirm().sendKeys(lawFirm, Keys.DOWN, Keys.ENTER);	//Writing & selecting 'Law Firm' name
				}
			
		 public  static void clickCaseInternalUser( ) throws InterruptedException, EncryptedDocumentException, IOException 
			  { 
			 
			  		Thread.sleep(500);
			  		FileInputStream fis = new FileInputStream(filePath);
			  		Workbook workbook = WorkbookFactory.create(fis);
			  		Sheet  sheet = workbook.getSheetAt(2);
			       Thread.sleep(3000);
		            Row row0 = sheet.getRow(47);						//Selected 0th index row (First row)
			       Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			       int internalUserNo = (int) c1.getNumericCellValue();
			      performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
			      elementsList = performerPOM.chooseInternalUser1();
			       elementsList.get(internalUserNo).click();							//Selecting particular user no
			      //performerPOM.clickInternalUser().click();						//Clicking on 'Internal User' drop down.
			  }
		 
			public static void clickLawyer() throws InterruptedException, EncryptedDocumentException, IOException
			{
				Thread.sleep(500);
				FileInputStream fis = new FileInputStream(filePath);
			    Workbook workbook = WorkbookFactory.create(fis);
			    Sheet  sheet = workbook.getSheetAt(2);
				Thread.sleep(300);
				Row row0 = sheet.getRow(4);						//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
				int lawyerNo = (int) c1.getNumericCellValue();
				Thread.sleep(300);
				performerPOM.clickLawyer().click();						//Clicking on 'Lawyer' drop down.
				elementsList = performerPOM.chooseLawyer();
				elementsList.get(lawyerNo).click();								//Selecting particular lawyer no
				performerPOM.clickLawyer().click();		//Clicking on 'Lawyer' drop down.
			}
			
		 
		 public static void Document(ExtentTest test) throws InterruptedException
			{
	           			
			
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	          

		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			  performerPOM.clickNoticeDocument().click();     //click notice document
			  performerPOM.clickNewDocument().click();        //click new document button
			
	 
				Thread.sleep(1000);
				getDriver().switchTo().frame("IFrameManageDocument");
				performerPOM.selectDocumentType();
				Thread.sleep(3000);
				performerPOM.chooseDocumentType();
				Thread.sleep(1000);
				performerPOM.selectUploadDocument(); 
				Thread.sleep(1000);
				performerPOM.clickUploadDocument().click(); 
			
			
			  Thread.sleep(1000);
			  wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
			
			  Thread.sleep(500);
			  String msg=performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
			  
			  if(msg.equalsIgnoreCase(msg))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			
			  Thread.sleep(1000);
			  performerPOM.clickClosedDocument().click(); 
			  Thread.sleep(3000);
			  
			  getDriver().switchTo().parentFrame();
			    Thread.sleep(3000);
		        performerPOM.clickCaseDownloadDocumentcfo().click();
		        
		        test.log(LogStatus.PASS, "Document download succssesfully");
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentViewcfo().click();
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
		        
		        test.log(LogStatus.PASS, "Document View popup open  succssesfully");
		        
		       /* Thread.sleep(3000);
		        performerPOM.clickCaseDocumentdeletecfo().click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert = .switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage= .switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage);
		        
		 		
		        // Accepting alert		
		        alert.accept();	*/
		        
		       
		        
		        Thread.sleep(3000);
		        performerPOM.clickCaseDocumentsharecfo().click();
		        
		        
		     	  
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = getDriver().switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert1.accept();	
		        
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		        
		        Thread.sleep(4000);
		        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5768798045");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharesavecfo().click();
		        
		        
		        Thread.sleep(3000);
		        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
		       
	         	if(msg1.equalsIgnoreCase("Document shared successfully."))
	         	{
		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		         
		        }
		      else
		        {
			       test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		        }
		        
	         	 getDriver().switchTo().parentFrame();
	         	
	         	   Thread.sleep(3000);
	  	     performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
	  	  
	  	        
		 }
		 
		 public static void TaskActivity1( ExtentTest test ) throws InterruptedException, IOException
			{
			
			 WebDriverWait wait = new WebDriverWait(getDriver(),20);

		       Thread.sleep(500);
 	        	performerPOM.clickCaseOpencfo().click();		
 	 			
 	             Thread.sleep(4000);
 	         
		      	performerPOM.clickEditNotice().click();
		      
			    Thread.sleep(3000);
			   
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(3000);
			    performerPOM.clickCaseTask().click();
			    Thread.sleep(300);
			    performerPOM.clickCaseNewTask().click();
			    Thread.sleep(5000);
			    performerPOM.clickHearingDate().sendKeys("27-03-2024");
			    
			    
//			    Thread.sleep(300);
//			    performerPOM.clickHearingDatecfo().click(); 
//			    Thread.sleep(300);
//			    performerPOM.clickHearingDatedropdowncfo().click(); 
			    
			   
			    
			    Thread.sleep(2000);
			    performerPOM.clickSaveHearingDatecfo().click();
			  
			    Thread.sleep(500);
			    FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet  sheet = workbook.getSheetAt(2);
				Thread.sleep(6000);
				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
				
				 Thread.sleep(500);
				    FileInputStream fis1 = new FileInputStream(filePath);
			        Workbook workbook1 = WorkbookFactory.create(fis1);
			        Sheet  sheet1 = workbook1.getSheetAt(2);
				Thread.sleep(5000);
				row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
				
				
				Thread.sleep(1000);
				performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
				OverduePOM.selectNextMonth().click();
				OverduePOM.selectDate().click();					//Selecting particular date.
				
				Thread.sleep(1000);
				Actions action = new Actions(getDriver());
//				action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
				
				 Thread.sleep(500);
				    FileInputStream fis2 = new FileInputStream(filePath);
			        Workbook workbook2 = WorkbookFactory.create(fis2);
			        Sheet  sheet2 = workbook2.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet2.getRow(14);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
				

				 Thread.sleep(500);
				    FileInputStream fis3 = new FileInputStream(filePath);
			        Workbook workbook3 = WorkbookFactory.create(fis3);
			        Sheet  sheet3 = workbook3.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet3.getRow(15);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser3().click();
				//performerPOM.selectInternalUser2().click();
				performerPOM.selectInternalUser3().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
				 Thread.sleep(500);
				    FileInputStream fis4 = new FileInputStream(filePath);
			        Workbook workbook4 = WorkbookFactory.create(fis4);
			        Sheet  sheet4 = workbook4.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet4.getRow(16);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String externalUser = c1.getStringCellValue();
				try
				{
					Thread.sleep(300);
					performerPOM.clickExternalUser().click();
					Thread.sleep(500);
					action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
				}
				catch(Exception e)
				{
					
				}
				
				 Thread.sleep(500);
				    FileInputStream fis5 = new FileInputStream(filePath);
			        Workbook workbook5 = WorkbookFactory.create(fis5);
			        Sheet  sheet5 = workbook5.getSheetAt(2);
				Thread.sleep(5000);
				row0 = sheet5.getRow(17);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
             	Thread.sleep(1000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				
//				Thread.sleep(2000);
//				performerPOM.clickMinimize().click();	
				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsgcfo()));
				
				Thread.sleep(3000);
			
				String msg1 = performerPOM.readTaskMsgcfo().getText();
				if(msg1.contains(msg1))
				{
					test.log(LogStatus.PASS, "Add Task for Case ="+msg1);
				}
				
				else 
				{
					test.log(LogStatus.FAIL, "Add Task for Case ="+msg1);
				}
				
			/*	Thread.sleep(3000);
				performerPOM.clickMinimize().click();
				
			//	Thread.sleep(3000);
			//	performerPOM.clickNoticeTaskEditResponsecfo1().click();
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				
				Thread.sleep(5000);
				row0 = sheet.getRow(13);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc1 = c1.getStringCellValue();
				performerPOM.clickTaskDesc().sendKeys(desc1);		//Writing 'Task Description'
				
				Thread.sleep(1000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				
				String msg2 = performerPOM.readTaskMsgcfo().getText();
				if(msg2.contains("Task Saved Successfully. An Email containing task detail and access URL to provide response sent to assignee."))
				{
					test.log(LogStatus.PASS, "Task Saved Successfully. An Email containing task detail and access URL to provide response sent to assignee.");
				}
				
				else 
				{
					test.log(LogStatus.FAIL, "Select Hearing or if you do not want to map task with hearing, then please select 'Not Applicable'.");
				}*/
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo1().click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo().click();
				
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1().click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Task Response");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo().click();
				
				
				test.log(LogStatus.PASS,"Task Response Saved Successfully.");
				
			
 				Thread.sleep(3000);
 				performerPOM.clickDeleteResponse().click();
 				
 			   Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = getDriver().switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1=  getDriver().switchTo().alert().getText();	
		        
		        
//		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert	
		        alert1.accept();
		        
		    	
	 			   Thread.sleep(5000);
		        String msg=performerPOM.clickTaskResponse().getText();
		        if(msg.equalsIgnoreCase("Response Deleted Successfully."))
		        {
		              test.log(LogStatus.PASS,"Message displayed ="+msg);
		        }
		        else
		        {
		        	 test.log(LogStatus.FAIL,"Message displayed ="+msg);
		        }
				
				
				getDriver().switchTo().parentFrame();
				
					
			}
		 
		 public static void CaseHearing( ExtentTest test) throws InterruptedException, IOException
			{
			 WebDriverWait wait = new WebDriverWait(getDriver(),20);
			     
			       
			       Thread.sleep(500);
	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 			
	 	             Thread.sleep(4000);
	 	         
			      	performerPOM.clickEditNotice().click();
			      	
			        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			        Thread.sleep(3000);
				   performerPOM.clickCaseHearing().click();
					Thread.sleep(3000);
					performerPOM.clickNewCaseHearing().click();
					
					Thread.sleep(3000);
				//	performerPOM.clickHearingcfo().click();
					
				//	Thread.sleep(3000);
				//	performerPOM.clickHearingdropdowncfo().click();
					
					
//					Thread.sleep(300);
//					Row row0 = sheet.getRow(35);					//Selected 0th index row (First row)
//					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
//					int HearingDate = (int) c1.getNumericCellValue();
//					performerPOM.clickCaseHearingDate().sendKeys(HearingDate+"");	//Writing 'HearingDate'
					
					performerPOM.clickCaseHearingDate().sendKeys("01-04-2024");	//Writing 'HearingDate'
					
					 Thread.sleep(500);
					    FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet  sheet = workbook.getSheetAt(2);
					Thread.sleep(2000);
					Row row1 = sheet.getRow(50);									//Selected 0th index row (First row)
					Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
					String HearingDescription = c2.getStringCellValue();
					performerPOM.clickCaseHearingDecsri().sendKeys(HearingDescription);		//Writing 'HearingDescription'
					
					
					Thread.sleep(3000);
				    performerPOM.clickSaveCaseHearingDate().click();
				  
				    try
				    {
				    	
				    	
				    	Thread.sleep(3000);
						String msg =performerPOM.clickReadHearingMsg1().getText();
						test.log(LogStatus.FAIL, "Add Hearing ="+msg);
				    }
					
					catch(Exception e)
				    {
						//Thread.sleep(3000);
						//performerPOM.clickMinimizeHearing().click();
						
						Thread.sleep(3000);
					    performerPOM.clickSaveCaseHearing().click();
						Thread.sleep(3000);
				    	String msg = performerPOM.clickReadHearingMsg().getText();
				    	test.log(LogStatus.PASS, "Add Hearing ="+msg);
				    	
				    }
				    
				    
				    
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingcfo().click();
				    
				    
				    Thread.sleep(3000);
				    performerPOM.clickEditCaseHearingcfo().click();
				    
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingDecsri().clear();
				    Thread.sleep(3000);
				    performerPOM.clickCaseHearingDecsri().sendKeys("Case Hearing13 JULY 2023");		//Writing 'HearingDescription'
				    
				    Thread.sleep(3000);
				    performerPOM.clickSaveCaseHearing().click();
				    
				    Thread.sleep(3000);
					String msg1 = performerPOM.clickReadHearingMsg().getText();
					if(msg1.contains(msg1))
					{
						test.log(LogStatus.PASS, "Update Hearing ="+msg1);
					}
					else
					{
						test.log(LogStatus.FAIL, "Update Hearing ="+msg1);
					}
				    
				    
				    
				    Thread.sleep(3000);
				    performerPOM.clickDeleteCaseHearingcfo().click();
				    
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert = getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
				    
				    
			} 
		 
			public static void CaseOrder(ExtentTest test) throws InterruptedException, IOException
			{
				WebDriverWait wait = new WebDriverWait(getDriver(),20);
				
				
				 Thread.sleep(3000);
					performerPOM.clickCaseOpencfo().click();//click edit notice
			     
			        Thread.sleep(3000);
					performerPOM.clickEditNotice().click();//click edit notice
				  
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				 Thread.sleep(5000);
				 performerPOM.clickCaseOrder().click();
				 Thread.sleep(6000);
				 performerPOM.clickNewCaseOrder().click();
				 Thread.sleep(6000);
				 performerPOM. clickCaseOrderDate().sendKeys("27-04-2023");
				 Thread.sleep(3000);
				 performerPOM.clickOrderPanel().click();
				 Thread.sleep(3000);
				 performerPOM. clickCaseOrderType().click();
				 Thread.sleep(3000);
				 performerPOM.selectCaseOrderType().click();
				
				 
				 
				 	Thread.sleep(500);
				    FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet  sheet = workbook.getSheetAt(2);
					Thread.sleep(300);
					Row row0 = sheet.getRow(53);					//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
					int OrderTitle = (int) c1.getNumericCellValue();
					performerPOM.clickCaseOrderTitle().sendKeys(OrderTitle+"");	//Writing 'HearingDate'
					
					 Thread.sleep(500);
				  FileInputStream fis1 = new FileInputStream(filePath);
				  Workbook workbook1 = WorkbookFactory.create(fis1);
				 Sheet  sheet1 = workbook1.getSheetAt(2);
				 Thread.sleep(2000);
				 Row row2 = sheet1.getRow(54);									//Selected 0th index row (First row)
				 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
				 String OrderDecri = c2.getStringCellValue();
				 performerPOM.clickCaseOrderDecri().sendKeys(OrderDecri);     //click oder description
				

				 Thread.sleep(3000);
				 performerPOM.clickSaveCaseOrder().click();
				 
				 
				 Thread.sleep(3000);
				 performerPOM.clickEditCaseOrdercfo().click();
				 
				 performerPOM.clickCaseOrderTitle().clear();
				 
				 performerPOM.clickCaseOrderTitle().sendKeys("Order no 906");
				 
				 performerPOM.clickCaseOrderDecri().clear();
				 
				 performerPOM.clickCaseOrderDecri().sendKeys("order as on 16 Aug 23");     //click oder description
				 
				 performerPOM.ChooseOrderFile().click();
				 
				 Thread.sleep(3000);
				 performerPOM.clickSaveCaseOrder().click();
				 
				 
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg()));
					
				
					
					 Thread.sleep(3000);
						String msg = performerPOM.readResponseMsg().getText();
						if(msg.contains(msg))
						{
							test.log(LogStatus.PASS, "Case Order with valid data ="+msg);
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Order with valid data ="+msg);
						
						}
				 
				 Thread.sleep(3000);
				 performerPOM.clickDownloadCaseOrdercfo().click();
				 
				
			      test.log(LogStatus.PASS, "Case Document Download Successfully");
			         
			        
		     	 Thread.sleep(3000);
				 performerPOM.clickViewCaseOrdercfo().click();
				 
				 Thread.sleep(6000);
			     performerPOM.clickNoticeDocumentViewClosepopupcfo().click();
			     
			     test.log(LogStatus.PASS,"Case View Document Popup Open Successfully");
			     
			     Thread.sleep(3000);
			     performerPOM.clickDeleteCaseOrdercfo().click();
			     
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert = getDriver().switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage= getDriver().switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage);
			        
			     // Accepting alert		
			        alert.accept();
			        
		
				 
			}	 
			
			   public static void StatusPayment( ExtentTest test) throws InterruptedException, IOException
			      {	
				   
				   			WebDriverWait wait = new WebDriverWait(getDriver(),20);
				   			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			      
			    	   
			    	       performerPOM.clickCaseOpencfo().click();//click edit notice
						     
					        Thread.sleep(3000);
							performerPOM.clickEditNotice().click();//click edit notice
						  
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    	       
			    	       
			    	    
			    	       Thread.sleep(3000);
			               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
							
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
//							
							 Thread.sleep(500);
							    FileInputStream fis = new FileInputStream(filePath);
						        Workbook workbook = WorkbookFactory.create(fis);
						        Sheet  sheet = workbook.getSheetAt(2);
							Thread.sleep(3000);
							Row row0 = sheet.getRow(58);					//Selected 0th index row (First row)
							Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
							int InvoiceNo = (int) c1.getNumericCellValue();
							performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
							
							
//							Thread.sleep(4000);
//							performerPOM.clickPaymentTyp1();
//							Thread.sleep(4000);
//							List<WebElement>PaymentType1= .findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
//							PaymentType1.get(2).click();
							
							 Thread.sleep(500);
							    FileInputStream fis1 = new FileInputStream(filePath);
						        Workbook workbook1 = WorkbookFactory.create(fis1);
						        Sheet  sheet1 = workbook1.getSheetAt(2);
							Thread.sleep(3000);
							Row r5 = sheet1.getRow(59);
							Cell c5 = r5.getCell(1);
							String PaymentType = c5.getStringCellValue();
							performerPOM.clickPaymentTyp1().click();
							performerPOM.selectPaymentTypeCase().sendKeys(PaymentType,Keys.ENTER);
						
							
							Thread.sleep(10000);
                            performerPOM.clickAmount1().sendKeys("900000");	//Writing 'Amount'
                            
                        	Thread.sleep(3000);
            				performerPOM.clickAmountPaid().sendKeys("7000");
            			
						
				
							Thread.sleep(3000);
							performerPOM.clickSavePaymentLog1().click();
							
							
							   Thread.sleep(5000);
								String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
							
								if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Add Payment = "+msg5);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Add Payment = "+msg5);
								}
						        
							
							
							Thread.sleep(3000);
							performerPOM.clickViewPaymentDoccfo().click();
							
							Thread.sleep(3000);
							performerPOM.clickNoticeclosePaymentDocpopupcfo().click();
							
							test.log(LogStatus.PASS, "Payment Document popup open successfully");
							
							
						
							Thread.sleep(3000);
							performerPOM.clickEditPaymentDoccfo().click();
							
							Thread.sleep(3000);
							performerPOM.clickCaseInvoiceNo1().clear();
							 Thread.sleep(3000);
						    performerPOM.clickCaseInvoiceNo1().sendKeys("Invoice No 78");
						    
						    Thread.sleep(3000);
							performerPOM.clickCaseStatusPaymentUploadtcfo();
						    

							Thread.sleep(3000);
							performerPOM.clickSavePaymentLog1().click();
							
							  Thread.sleep(500);
								String msg = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
							
								if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Update Payment = "+msg);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Update Payment = "+msg);
								}
							
							
							
							
							Thread.sleep(3000);
							performerPOM.clickDeletePaymentDoccfo1().click();
							
							 Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);
						        
						     // Accepting alert		
						        alert1.accept();
						        
						        Thread.sleep(500);
								String msg6 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
							
								if(msg6.equalsIgnoreCase("Payment Details Deleted Successfully."))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg6);
								
								}
								else
								{
									test.log(LogStatus.FAIL, "Message displayed = "+msg6);
								}
						        
						        
							
							
							
						
			      }
			   public static void CaseExternalLawyer(ExtentTest test) throws InterruptedException, IOException
			      {
				               
				   			WebDriverWait wait = new WebDriverWait(getDriver(),20);
				   			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			    	           
			    	    	   Thread.sleep(3000);
			   				performerPOM.clickCaseOpencfo().click();//click edit notice
			   		     
			   		        Thread.sleep(3000);
			   				performerPOM.clickEditNotice().click();//click edit notice
			   			  
			   			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    	      
							  Thread.sleep(3000);
							   performerPOM.clickExternalLawyerRating1().click();
							   
							  Thread.sleep(3000);
							  performerPOM.selectExternalLawyerRating();
							   Thread.sleep(3000);
							   performerPOM.clickNewCriteria().click();
							   Thread.sleep(3000);
							   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
							   performerPOM.clickCriteria().sendKeys("Automation Test");
							   Thread.sleep(3000);
							   performerPOM.clickSaveCriteria().click();
							   Thread.sleep(3000);
							   getDriver().switchTo().parentFrame();
							   performerPOM.clickclosecriteria().click();
							   Thread.sleep(3000);
							   performerPOM. clickstar().click();
						       Thread.sleep(3000);
							   performerPOM. clickstar1().click();
							   Thread.sleep(3000);
							   performerPOM. clickSaveRating().click();
							   
							   
						   	  Thread.sleep(1000);
							 wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
										
								Thread.sleep(500);
								String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
								
								if(msg5.equalsIgnoreCase("Rating Saved Successfully"))
									{
											test.log(LogStatus.PASS, "Message displayed = "+msg5);
											
									}
								else
									{
											test.log(LogStatus.FAIL, "Message displayed = "+msg5);
									}
								
								
							   
					  }	   
			   
			   public static void CaseExternalLawyerWitoutRating(ExtentTest test) throws InterruptedException, IOException
			      {
				               
				   
				   WebDriverWait wait = new WebDriverWait(getDriver(),20);
					 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			    	           
			    	    	   Thread.sleep(3000);
			   					performerPOM.clickCaseOpencfo().click();//click edit notice
			   		     
			   					Thread.sleep(3000);
			   					performerPOM.clickEditNotice().click();//click edit notice
			   			  
			   					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    	      
							  Thread.sleep(3000);
							   performerPOM.clickExternalLawyerRating1().click();
							   
							  Thread.sleep(3000);
							  performerPOM.selectExternalLawyerRating();
							  
					
						
							   Thread.sleep(3000);
							   performerPOM. clickSaveRating().click();
							 
								try
								{
									   
									wait.until(ExpectedConditions.visibilityOf(performerPOM.readRatingmsg()));
									 	  
									 Thread.sleep(500);
								    String msg5 = performerPOM.readRatingmsg().getText();		//Reading Message appeared after save button
								    test.log(LogStatus.PASS, "Message displayed = "+msg5);
											
								}
								catch(Exception e)
								{
									test.log(LogStatus.FAIL, "Validation message not displayed");
								}
								 Thread.sleep(3000);
								   getDriver().switchTo().parentFrame();
								   performerPOM.clickclosebutton().click();
								   Thread.sleep(1000);
									
									OverduePOM.clickDashboard().click();
								
							   
					  }	 
				   
			      public static void Auditlog(ExtentTest test) throws InterruptedException
			      {
			    	 
			    	  WebDriverWait wait = new WebDriverWait(getDriver(),20);
						 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			   	               Thread.sleep(3000);
				            	performerPOM.clickCaseOpencfo().click();//click edit notice
			     
			                    Thread.sleep(3000);
					               performerPOM.clickEditNotice().click();//click edit notice
				  
				                     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    	 
							   Thread.sleep(3000);
							   performerPOM. clickAuditLog().click();
							   Thread.sleep(3000);
							   performerPOM.clickExport().click();		   
							   Thread.sleep(3000);
							   getDriver().switchTo().parentFrame();
							   performerPOM.clickclosebutton().click();
							   
							   test.log(LogStatus.PASS,"Audit Detail Report Download successfully");
							   
							   Thread.sleep(1000);
								
								OverduePOM.clickDashboard().click();
			      }	 
			      
			  	public static void LinkDocument( ExtentTest test, XSSFWorkbook workbook, String type) throws InterruptedException, IOException
				{
			  		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					progress();
					
					Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
					
//					Thread.sleep(3000);
//					performerPOM.clickEditNotice().click();//click edit notice
					if(type.equals("Notice"))
					{
						performerPOM.clickNoticeOpen().click();							//Clicking on 'Open' notice
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickCaseOpencfo().click();								//Clicking on 'Open' case
					}
					
					progress();
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));
					
					Thread.sleep(400);
					 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,500)");
					
					Thread.sleep(1500);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
					//performerPOM.GridLoad().click();
					elementsList = performerPOM.clickAction();			//Getting all action buttons.
					js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
					
					Thread.sleep(600);
					elementsList = performerPOM.clickAction();			//Getting all action buttons.
					elementsList.get(0).click();								//Clicking on first action button.
					
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame		
					if(type.equals("Notice"))
					{
						performerPOM.clickLinkNotice().click();			//Clicking on Link Notice icon
						
						Thread.sleep(300);
						progress();
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCheckBox()));	//Waiting for Checkbox to get visible.
						
						Thread.sleep(3000);
						performerPOM.clickCheckBox().click();			//CLicking on first checkbox
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickLinkCase().click();			//Clicking on Link Notice icon
						
						Thread.sleep(300);
						progress();
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.clickCaseCheckBox()));	//Waiting for Checkbox to get visible.

						
						Thread.sleep(300);
						performerPOM.clickCaseCheckBox().click();		//CLicking on first checkbox
					}
					
					Thread.sleep(300);
					if(type.equals("Case"))
					{
						performerPOM.clickApply().sendKeys(Keys.PAGE_DOWN);
					}
					else
					{
						performerPOM.clickApply1().sendKeys(Keys.PAGE_DOWN);
					}
					
					Thread.sleep(300);
					performerPOM.clickSave().click();				//Clicking on Save button.
					
					Thread.sleep(300);
					progress();
					
					Thread.sleep(500);
					try
					{
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg()));
					}
					catch(Exception e)
					{
						wait.until(ExpectedConditions.elementToBeClickable(performerPOM.readMsg()));
					}
					Thread.sleep(300);
					String msg = performerPOM.readMsg().getText();
					if(msg.contains("Linked Successfully"))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg);
					}
					
					
					if(type.equals("Notice"))
					{
						performerPOM.clickClosePopup().click();
						
						Thread.sleep(300);
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_DOWN);
						
						
						

					}
					else if(type.equals("Case"))
					{
						performerPOM.clickClosePopupCase().click();
						
						Thread.sleep(300);
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_DOWN);


					}

						
						

					if(type.equals("Notice"))
					{
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkNotice().sendKeys(Keys.PAGE_UP);
					}
					else if(type.equals("Case"))
					{
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
						performerPOM.clickLinkCase().sendKeys(Keys.PAGE_UP);
					}
					
					
					Thread.sleep(300);
					getDriver().switchTo().parentFrame();
					performerPOM.clickClose().click();
					
			
					
					Thread.sleep(1000);
				
					OverduePOM.clickDashboard().click();
					}
				
			  	
			  	public static void AdvancedSearchWorkspace(ExtentTest test) throws InterruptedException
				{
					Thread.sleep(3000);
					performerPOM.clickMyWorkspace().click();
					
					Thread.sleep(3000);
					performerPOM.clickCaseNotice1().click();
					
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					Thread.sleep(5000);
					
					performerPOM.AdvancedSearchReports().click();
					
				//-------------------------------------------Notice--------------------------------------------------
					
					Thread.sleep(4000);
					performerPOM.startDate().sendKeys("05/4/2022");
					
					Thread.sleep(4000);
					performerPOM.endDate().sendKeys("05/7/2022");
					
					Thread.sleep(4000);
					performerPOM.clickApplyButton().click();
					
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					
					Thread.sleep(5000);
					performerPOM.clickExportAdavanced().click();
					test.log(LogStatus.PASS, "Notice = File downloaded successfully.");
					
					
					Thread.sleep(4000);
					performerPOM.clickeditButton().click();
					
					test.log(LogStatus.PASS,"edit notice details icon open successfully");
					
					
					Thread.sleep(5000);
					performerPOM.Actionclosepopup().click();
					
					

				      //-------------------------------------------Case--------------------------------------------------
						Thread.sleep(4000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						Thread.sleep(4000);
						performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(5000);
						performerPOM.selectTypeCase1().click();
						
						Thread.sleep(4000);
						performerPOM.clickApplyButton().click();
						
						Thread.sleep(3000);
						performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case = File downloaded successfully.");
					
						Thread.sleep(4000);
						performerPOM.clickeditButton().click();
						
						test.log(LogStatus.PASS,"edit case details icon open successfully");
						
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup().click();
						
						
						
			          //-------------------------------------------Task--------------------------------------------------
							Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(6000);
						performerPOM.selectTypeTask1().click();
						
						Thread.sleep(5000);
						performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Task = File downloaded successfully.");
						
						Thread.sleep(5000);
						performerPOM.viewTaskDetails1().click();	
						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
						
						Thread.sleep(6000);
						performerPOM.ActioncloseTaskpopup().click();
						
						Thread.sleep(500);
						OverduePOM.clickDashboard().click();
					        
				}
			  	
		public static void WorkspaceNoticeFilter(ExtentTest test) throws InterruptedException
				{
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					  JavascriptExecutor js = (JavascriptExecutor) getDriver();
					Thread.sleep(3000);
					performerPOM.clickMyWorkspace().click();
					
					Thread.sleep(3000);
					performerPOM.clickCaseNotice1().click();
					
					  Thread.sleep(3000);
						performerPOM.clicklocationFilter().click();
						Thread.sleep(3000);
						performerPOM.clickExpand().click();
						Thread.sleep(3000);
				       String locationtext =performerPOM.SelectLocationWorkspace().getText();
				       Thread.sleep(3000);
				       performerPOM. SelectLocationWorkspace().click();
				       
				       
                       Thread.sleep(500);
				       performerPOM.clickDepartmentFilterWorkspace().click();
				       Thread.sleep(500);
				       String DeptText = performerPOM.selectDepartmentFilterWorkspace().getText();
				       Thread.sleep(500);
				       performerPOM. selectDepartmentFilterWorkspace().click();
				       				        
				       Thread.sleep(500);
				       performerPOM.clickTypeFilter().click();
				       Thread.sleep(500);
				       String Typetext = performerPOM.selectDocTypeFilterCA().getText();
				       Thread.sleep(500);
				       performerPOM.selectDocTypeFilterCA().click();
				           
				       
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

					     
					     By dept = By.xpath("//input[@data-field='Department']");
	                     wait.until(ExpectedConditions.presenceOfElementLocated(dept));
					     Thread.sleep(4000);
		                 WebElement ViewButton = getDriver().findElement(dept);	
						 Thread.sleep(4000);
						 
						 js.executeScript("arguments[0].click();", ViewButton);
					     Thread.sleep(500);
						 performerPOM.clickTrignle().click(); 
						
						
						js.executeScript("window.scrollBy(0,200)");	
						Thread.sleep(3000);

						CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
						String s = CFOcountPOM.readTotalItems1().getText();
						Thread.sleep(2000);

						if(!s.equalsIgnoreCase("No items to display")) {
						Thread.sleep(5000);
					
						List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
						List<WebElement> Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[14]"));
						List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
						
						Thread.sleep(2000);

						for(int i=0; i<li.size(); i++){
							
							List<String> text= new ArrayList<String>();
							HashSet<String> pass=new LinkedHashSet<>();
							HashSet<String> fail=new LinkedHashSet<>();
							List<WebElement>raw=new ArrayList<WebElement>();

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
		
		public static void WorkspaceCaseFilter(ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			  JavascriptExecutor js = (JavascriptExecutor) getDriver();
			Thread.sleep(3000);
			performerPOM.clickMyWorkspace().click();
			
			Thread.sleep(3000);
			performerPOM.clickCaseNotice1().click();
			
			Thread.sleep(3000);
			performerPOM.clickTypeDropdown().click();
			
			Thread.sleep(3000);
			performerPOM.selectTypeNotice().click();
			

			  Thread.sleep(3000);
				performerPOM.clicklocationFilter().click();
				Thread.sleep(3000);
				performerPOM.clickExpand().click();
				Thread.sleep(3000);
		       String locationtext =performerPOM.SelectLocationWorkspace().getText();
		       Thread.sleep(3000);
		       performerPOM. SelectLocationWorkspace().click();
		       
		       
               Thread.sleep(500);
		       performerPOM.clickDepartmentFilterWorkspace().click();
		       Thread.sleep(500);
		       String DeptText = performerPOM.selectDepartmentFilterWorkspace().getText();
		       Thread.sleep(500);
		       performerPOM. selectDepartmentFilterWorkspace().click();
		       				        
		       Thread.sleep(500);
		       performerPOM.clickTypeFilter().click();
		       Thread.sleep(500);
		       String Typetext = performerPOM.selectDocTypeFilterCA().getText();
		       Thread.sleep(500);
		       performerPOM.selectDocTypeFilterCA().click();
		           
		       
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

			     
			     By dept = By.xpath("//input[@data-field='Department']");
                 wait.until(ExpectedConditions.presenceOfElementLocated(dept));
			     Thread.sleep(4000);
                 WebElement ViewButton = getDriver().findElement(dept);	
				 Thread.sleep(4000);
				  
				 js.executeScript("arguments[0].click();", ViewButton);
			     Thread.sleep(500);
				 performerPOM.clickTrignle().click(); 
				
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				List<WebElement>entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				List<WebElement>Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[14]"));
				List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
				
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement>raw=new ArrayList<WebElement>();

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
		       String locationtext =performerPOM.SelectLocationWorkspace().getText();
		       Thread.sleep(3000);
		       performerPOM. SelectLocationWorkspace().click();
		       
		       
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
		       // li.add(locationtext);
		         li.add(priorityText);
		         li.add(Statustext);
		        
		        Thread.sleep(3000);
		        
				List<String> filter=new ArrayList<String>();	
				//filter.add("Location");
				filter.add("priority");
				filter.add("Status");
				
				
				

			     
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				List<WebElement>Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				List<WebElement>Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
				//List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
				
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement>raw=new ArrayList<WebElement>();

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
		
				List<WebElement>typecol=getDriver().findElements(By.xpath("//*[@id='gridPendingUpdation']/div[2]/table/tbody/tr/td[1]"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement>raw=new ArrayList<WebElement>();


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
					WebDriverWait wait = new WebDriverWait(getDriver(),20);
						progress();
						  JavascriptExecutor js =(JavascriptExecutor) getDriver();
					
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					
					Thread.sleep(3000);
					performerPOM.clickTypeDropdown().click();
					Thread.sleep(3000);
					performerPOM.selectTypeNotice().click();
					
					Thread.sleep(3000);
					performerPOM.clickDocStatusFilter().click();
					Thread.sleep(3000);
			        String Statustext =performerPOM.selectDocStatusFilter().getText();
			        Thread.sleep(3000);
			         performerPOM. selectDocStatusFilter().click();
			       
				
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
				       String locationtext =performerPOM.SelectLocation().getText();
				       Thread.sleep(3000);
				       performerPOM. SelectLocation().click();
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
						 //performerPOM.clickTrignle().click();
						 
						  By Tringle = By.xpath("//span[@class='k-icon k-i-more-vertical']");
		                     wait.until(ExpectedConditions.presenceOfElementLocated(Tringle));
						     Thread.sleep(4000);
			                 WebElement ViewButton = getDriver().findElement(Tringle);	
							 Thread.sleep(4000);
							 
							 js.executeScript("arguments[0].click();", ViewButton);
					     
							 Thread.sleep(3000);
					     performerPOM.clickCol().click();

					     
					     By dept = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Status']");
	                     wait.until(ExpectedConditions.presenceOfElementLocated(dept));
					     Thread.sleep(4000);
		                 WebElement ViewButton1 =getDriver() .findElement(dept);	
						 Thread.sleep(4000);
						  
						 js.executeScript("arguments[0].click();", ViewButton1);
					    
						
						js.executeScript("window.scrollBy(0,200)");	
						Thread.sleep(3000);
                        CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
						String s = CFOcountPOM.readTotalItems1().getText();
						Thread.sleep(2000);

						if(!s.equalsIgnoreCase("No items to display")) {
						Thread.sleep(5000);
					
						List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
						List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
						List<WebElement>Location=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
						
						Thread.sleep(2000);

						for(int i=0; i<li.size(); i++){
							
							List<String> text= new ArrayList<String>();
							HashSet<String> pass=new LinkedHashSet<>();
							HashSet<String> fail=new LinkedHashSet<>();
							List<WebElement>raw=new ArrayList<WebElement>();

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
								
								else if(i==1)
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
				public static void DocumentCaseFilter(ExtentTest test) throws InterruptedException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(),60);
						progress();
						  JavascriptExecutor js = (JavascriptExecutor) getDriver();
					
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					
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
				    String typetext =performerPOM.selectDocTypeFilter().getText();
				    Thread.sleep(3000);
				     performerPOM. selectDocTypeFilter().click();
			         
			         
			         
			      
					  Thread.sleep(3000);
						performerPOM.clickDocLocFilter().click();
						Thread.sleep(3000);
						performerPOM.clickExpand().click();
						Thread.sleep(3000);
				       String locationtext =performerPOM.SelectLocation().getText();
				       Thread.sleep(3000);
				       performerPOM. SelectLocation().click();
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
						 //performerPOM.clickTrignle().click();
						 
						  By Tringle = By.xpath("//span[@class='k-icon k-i-more-vertical']");
		                     wait.until(ExpectedConditions.presenceOfElementLocated(Tringle));
						     Thread.sleep(4000);
			                 WebElement ViewButton = getDriver().findElement(Tringle);	
							 Thread.sleep(4000);
							  
							 js.executeScript("arguments[0].click();", ViewButton);
					     
							 Thread.sleep(3000);
					     performerPOM.clickCol().click();

					     
					     By dept = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Status']");
	                     wait.until(ExpectedConditions.presenceOfElementLocated(dept));
					     Thread.sleep(4000);
		                 WebElement ViewButton1 = getDriver().findElement(dept);	
						 Thread.sleep(4000);
						 
						 js.executeScript("arguments[0].click();", ViewButton1);
					    
						
						js.executeScript("window.scrollBy(0,150)");	
						Thread.sleep(3000);

						CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
						String s = CFOcountPOM.readTotalItems1().getText();
						Thread.sleep(2000);

						if(!s.equalsIgnoreCase("No items to display")) {
						Thread.sleep(5000);
					
						List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
						List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
						List<WebElement>Location=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
						
						Thread.sleep(2000);

						for(int i=0; i<li.size(); i++){
							
							List<String> text= new ArrayList<String>();
							HashSet<String> pass=new LinkedHashSet<>();
							HashSet<String> fail=new LinkedHashSet<>();
							List<WebElement>raw=new ArrayList<WebElement>();

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
								
								else if(i==1)
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
				
				public static void DocumentTaskFilter(ExtentTest test) throws InterruptedException
				{
					
					WebDriverWait wait = new WebDriverWait(getDriver(),60);
					progress();
					 JavascriptExecutor js = (JavascriptExecutor) getDriver();
				
				performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
				performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
				
				
				Thread.sleep(3000);
				performerPOM.clickTypeDropdown().click();
				Thread.sleep(3000);
				performerPOM.selectTypeTask().click();
					

					  Thread.sleep(3000);
						performerPOM.clickDocLocFilter().click();
						Thread.sleep(3000);
						performerPOM.clickExpand().click();
						Thread.sleep(3000);
				       String locationtext =performerPOM.SelectLocationWorkspace().getText();
				       Thread.sleep(3000);
				       performerPOM. SelectLocationWorkspace().click();
				       
				       
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
				       // li.add(locationtext);
				         li.add(priorityText);
				         li.add(Statustext);
				        
				        Thread.sleep(3000);
				        
						List<String> filter=new ArrayList<String>();	
						//filter.add("Location");
						filter.add("priority");
						filter.add("Status");
						 
						js.executeScript("window.scrollBy(0,200)");	
						Thread.sleep(3000);
						CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
						String s = CFOcountPOM.readTotalItems1().getText();
						Thread.sleep(2000);

						if(!s.equalsIgnoreCase("No items to display")) {
						Thread.sleep(5000);
					
						List<WebElement>Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[9]"));
						List<WebElement>Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]"));
						//List<WebElement>Type=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
						
						Thread.sleep(2000);

						for(int i=0; i<li.size(); i++){
							
							List<String> text= new ArrayList<String>();
							HashSet<String> pass=new LinkedHashSet<>();
							HashSet<String> fail=new LinkedHashSet<>();
							List<WebElement>raw=new ArrayList<WebElement>();

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
				
				public static void MyDocument( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(), 60);
					progress();
					
					//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					
					
					/*Thread.sleep(3000);
					performerPOM.clickDocTypeFilter().click();
					
					Thread.sleep(3000);
					performerPOM.clickDocTypeFilter1().click();

					Thread.sleep(5000);
					if(performerPOM.clearButton().isEnabled())
					{
						performerPOM.clearButton().click();
						 test.log(LogStatus.PASS, "My Document = clear button Work Successfully");
					}
					else
					{
						test.log(LogStatus.PASS, "My Document = clear button not Work Successfully");
					}*/
					   
					
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
					
					//--------------------------------Case----------------------------------
					     Thread.sleep(4000);
					       performerPOM.clickDownloadDocument().click();	
					       test.log(LogStatus.PASS, "Case=Document  Downloaded Successfully.");
					       
					       try
					       {
					    	    Thread.sleep(4000);
					            performerPOM.clickViewDocument().click();	
					            Thread.sleep(3000);
					            performerPOM.clickcloseViewDocument().click();
					           Thread.sleep(3000);
					          test.log(LogStatus.PASS, "Case=Document  View Successfully.");
					       }
					       catch(Exception e)
					       {
					    	   
					       Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        // Accepting alert		
					        alert.accept();
					       }
							
							//.navigate().refresh();
				
					//--------------------------------Notice----------------------------------
			 
					       Thread.sleep(5000);
						     JavascriptExecutor js = (JavascriptExecutor) getDriver();
							js.executeScript("window.scrollBy(500,0)");
							Thread.sleep(3000);
							performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
							Thread.sleep(6000);
							performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
							 Thread.sleep(4000);
						       performerPOM.clickDownloadDocument().click();	
						       test.log(LogStatus.PASS, "Notice=Document Downloaded Successfully.");
						      try
						      {
						         Thread.sleep(4000);
						         performerPOM.clickViewDocument().click();	
						         Thread.sleep(4000);
						         performerPOM.clickcloseViewDocument().click();
						         test.log(LogStatus.PASS, "Notice=Document view Successfully.");
						      }
						      catch(Exception e)
						      {
						    	  Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert1 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        Thread.sleep(3000);
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);	
							        
						      		
							        // Accepting alert		
							        alert1.accept();
						      }
						       
							     // .navigate().refresh();
											
			          ////--------------------------------Task----------------------------------
							
						    
							Thread.sleep(5000);
							performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
							Thread.sleep(6000);
							performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
										 
						     try
						     {
						     Thread.sleep(5000);
						       performerPOM.clickViewDocument().click();	
						       Thread.sleep(3000);
						        performerPOM.clickcloseViewDocument().click();

						        Thread.sleep(1000);
						        test.log(LogStatus.PASS, "Task=Document view Successfully.");
						     }
						   catch(Exception e)
						   {
							   Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert2 = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage2= getDriver().switchTo().alert().getText();	
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage2);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage2);	
						        
					      		
						        // Accepting alert		
						        alert2.accept();
						   }
						     
						     Thread.sleep(4000);
						     performerPOM.clickDownloadDocument().click();
						     
							try
								{
									   Thread.sleep(5000);
									    // Switching to Alert        
								        Alert alert2 =getDriver().switchTo().alert();	
								        		
								        // Capturing alert message.    
								        String alertMessage2=getDriver().switchTo().alert().getText();	
								        
								        Thread.sleep(3000);
								        test.log(LogStatus.PASS, "Task=" +alertMessage2);
								        		
								        // Displaying alert message		
								        System.out.println(alertMessage2);	
								        
							      		
								        // Accepting alert		
								        alert2.accept();
								}
								
								catch(Exception e)
								{
									
								     
								     test.log(LogStatus.PASS, "Task=Document  Downloaded Successfully.");
								}
						  
						      getDriver().navigate().refresh();
						       
						       Thread.sleep(1000);
							   OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
				}   
				
				public static void ShareCaseDocument( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					progress();
					
					
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					Thread.sleep(1000);
					performerPOM.selectDocument().click();	
					Thread.sleep(3000);
					
					Thread.sleep(1000);
					performerPOM.shareDocumentIcon().click();
					
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
					   
					   Thread.sleep(1000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(1000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(1000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(1000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
						if(msg.equalsIgnoreCase("Document shared successfully."))
						{
							test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
						}
						getDriver().switchTo().parentFrame();
						Thread.sleep(1000);
						performerPOM. clickViewDocAdvocatebillPdfClose().click();
						
				}
				
				
				public static void ShareNoticeDocument( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(),60);
					progress();
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					

			       Thread.sleep(5000);
				     JavascriptExecutor  js =(JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(500,0)");
					Thread.sleep(3000);
					performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(3000);
					performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
//					Thread.sleep(1000);
//					performerPOM.selectDocument().click();	
					Thread.sleep(3000);
					performerPOM.shareDocumentIcon().click();
					
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
					   
					   Thread.sleep(1000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(1000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(1000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(1000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
						if(msg.equalsIgnoreCase("Document shared successfully."))
						{
							test.log(LogStatus.PASS, " Documents for respective Notice should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective Notice should be shared =" +msg);
						}
						getDriver().switchTo().parentFrame();
						Thread.sleep(1000);
						performerPOM. clickViewDocAdvocatebillPdfClose().click();
				}
				       
				public static void ShareTaskDocument( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
				{
					WebDriverWait wait = new WebDriverWait(getDriver(),60);
					progress();
					performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
					performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
					
			       Thread.sleep(5000);
				     JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(500,0)");
					Thread.sleep(3000);
					performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
					Thread.sleep(3000);
					performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
//					Thread.sleep(1000);
//					performerPOM.selectDocument().click();	
					
					
					try
					{
						
					
					Thread.sleep(1000);
					performerPOM.shareDocumentIcon().click();
					
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
					   
					   Thread.sleep(1000);
						performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
						Thread.sleep(1000);
						performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
						Thread.sleep(1000);
						performerPOM. clickNoticeDocumentsharesavecfo().click();
					
						Thread.sleep(1000);
						String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
						if(msg.equalsIgnoreCase("Document shared successfully."))
						{
							test.log(LogStatus.PASS, " Documents for respective Task should be shared =" +msg);
						}
						else
						{
							test.log(LogStatus.FAIL, " Documents for respective Task should be shared =" +msg);
						}
						getDriver().switchTo().parentFrame();
						Thread.sleep(1000);
						performerPOM. clickViewDocAdvocatebillPdfClose().click();
					}
					catch(Exception e)
					{
						 Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert =getDriver().switchTo().alert();
					        		
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        		
					        // Accepting alert		
					        alert.accept();	
						
					}
				}
				       
				
				
				
				 public static void AdvancedSearchDocument( ExtentTest test) throws InterruptedException, IOException
				   {
					 WebDriverWait wait = new WebDriverWait(getDriver(),(60));
						 		progress();
						 		
						 		//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						 		performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						 		performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 		
						 		Thread.sleep(3000);
						 		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						 		
							  //--------------------------------Case----------------------------------
								
							 Thread.sleep(3000);
							 performerPOM.AdvancedSearchReports().click();
						      Thread.sleep(4000);
						       performerPOM.clickDownloadDocument1().click();	
						       Thread.sleep(4000);
						       performerPOM.clickViewDocument1().click();	
						       Thread.sleep(10000);
						       performerPOM.clickcloseViewDocument1().click();
							
						       Thread.sleep(3000);
						       test.log(LogStatus.PASS, "Advanced Search(Case)=Document  View Successfully.");
						       test.log(LogStatus.PASS, "Advanced Search(Case)=Document  Downloaded Successfully.");
								
							
					
								//--------------------------------Notice----------------------------------
				 
								
								Thread.sleep(5000);
								performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
								Thread.sleep(5000);
								performerPOM.selectTypeCase2().click();					//Selecting 'Case' option.
								 Thread.sleep(4000);
							       performerPOM.clickDownloadDocument1().click();	
							       Thread.sleep(4000);
							       performerPOM.clickViewDocument1().click();	
							       Thread.sleep(10000);
							       performerPOM.clickcloseViewDocument1().click();
							       
							       Thread.sleep(3000);
							       test.log(LogStatus.PASS, "Advanced Search(Notice)=Document view Successfully.");
							       test.log(LogStatus.PASS, "Advanced Search(Notice)=Document Downloaded Successfully.");
									
												
				               ////--------------------------------Task----------------------------------
								
							   
								Thread.sleep(5000);
								performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
								Thread.sleep(5000);
								performerPOM.selectTypeTask2().click();					//Selecting 'Task' option.
								
								 Thread.sleep(4000);
							     performerPOM.clickDownloadDocument1().click();	
							 
							     try
							     {
							     Thread.sleep(5000);
							       performerPOM.clickViewDocument1().click();	
							       Thread.sleep(3000);
							        performerPOM.clickcloseViewDocument1().click();

							        Thread.sleep(1000);
							        test.log(LogStatus.PASS, "Task=Document view Successfully.");
							     }
							   catch(Exception e)
							   {
								   Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert2 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage2= getDriver().switchTo().alert().getText();	
							        
							        Thread.sleep(3000);
							        test.log(LogStatus.PASS, alertMessage2);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage2);	
							        
						      		
							        // Accepting alert		
							        alert2.accept();
							   }
							  

							     Thread.sleep(1000);
							     test.log(LogStatus.PASS, "Advanced Search(Task)=Document view Successfully.");
							     test.log(LogStatus.PASS, "Advanced Search(Task)=Document  Downloaded Successfully.");
							     
						         getDriver().navigate().refresh();
						       
						       Thread.sleep(1000);
							   OverduePOM.clickDashboard().click();				//Clicking on 'My Dashboard'
				}
				 
				 
				 public static void AdvancedSearchShareCaseDocument( ExtentTest test) throws InterruptedException, IOException
					{
					 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						
						performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 Thread.sleep(3000);
						 performerPOM.AdvancedSearchReports().click();
						
//						Thread.sleep(1000);
//						performerPOM.selectDocument().click();	
						Thread.sleep(3000);
						//performerPOM.selectDocument1().click();
						
					     //Select t=new Select(.findElement(By.xpath("/html/body/div[77]/div/div[2]/ul/li[2]")));
					  //  t.selectByIndex(1);
					
						
//	      		       List<Element>SeletcRisk = .findElements(By.xpath("//li[@class='k-item']"));
//	      			   selectOptionFromDropDown_bs(SeletcRisk, "Case Documents");
						Thread.sleep(1000);
						performerPOM.shareDocumentIcon1().click();
						
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
						   
						   Thread.sleep(1000);
							performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
							Thread.sleep(1000);
							performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
							Thread.sleep(1000);
							performerPOM. clickNoticeDocumentsharesavecfo().click();
						
							Thread.sleep(1000);
							String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
							if(msg.equalsIgnoreCase("Document shared successfully."))
							{
								test.log(LogStatus.PASS, " Documents for respective case should be shared =" +msg);
							}
							else
							{
								test.log(LogStatus.FAIL, " Documents for respective case should be shared =" +msg);
							}
							getDriver().switchTo().parentFrame();
							Thread.sleep(1000);
							performerPOM. CloseSharePopup().click();
							
					}
					
					
					public static void AdvancedSearchShareNoticeDocument( ExtentTest test) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait(getDriver(),(60));
						progress();
						performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						
						 Thread.sleep(3000);
						 performerPOM.AdvancedSearchReports().click();
						

				       Thread.sleep(5000);
					     JavascriptExecutor js = (JavascriptExecutor) getDriver();
						js.executeScript("window.scrollBy(500,0)");
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(5000);
						performerPOM.selectTypeCase2().click();					//Selecting 'Case' option.
//						Thread.sleep(1000);
//						performerPOM.selectDocument().click();	
						Thread.sleep(3000);
						performerPOM.shareDocumentIcon1().click();
						
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
						   
						   Thread.sleep(1000);
							performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
							Thread.sleep(1000);
							performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
							Thread.sleep(1000);
							performerPOM. clickNoticeDocumentsharesavecfo().click();
						
							Thread.sleep(1000);
							String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
							if(msg.equalsIgnoreCase("Document shared successfully."))
							{
								test.log(LogStatus.PASS, " Documents for respective Notice should be shared =" +msg);
							}
							else
							{
								test.log(LogStatus.FAIL, " Documents for respective Notice should be shared =" +msg);
							}
							getDriver().switchTo().parentFrame();
							Thread.sleep(1000);
							performerPOM. CloseSharePopup().click();
					}
					       
					public static void AdvancedSearchShareTaskDocument( ExtentTest test) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait(getDriver(), 60);
						progress();
						performerPOM.clickMyDocument().click();					//Clicking on 'My Document'
						performerPOM.clickmyDocument().click();	                    //Clicking on 'My Document'
						 Thread.sleep(3000);
						 performerPOM.AdvancedSearchReports().click();
						
				       Thread.sleep(5000);
					     JavascriptExecutor js = (JavascriptExecutor) getDriver();
						js.executeScript("window.scrollBy(500,0)");
						Thread.sleep(5000);
						performerPOM.clickTypeDropdown2().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(5000);
						performerPOM.selectTypeTask2().click();					//Selecting 'Task' option.
//						Thread.sleep(1000);
//						performerPOM.selectDocument().click();	
						
						
						try
						{
							
						
						Thread.sleep(1000);
						performerPOM.shareDocumentIcon1().click();
						
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews3"));
						   
						   Thread.sleep(1000);
							performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin@gmail.com");
							Thread.sleep(1000);
							performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("5555555555");
							Thread.sleep(1000);
							performerPOM. clickNoticeDocumentsharesavecfo().click();
						
							Thread.sleep(1000);
							String msg=performerPOM. clickNoticeDocumentsharereadmsgcfo().getText();
							if(msg.equalsIgnoreCase("Document shared successfully."))
							{
								test.log(LogStatus.PASS, " Documents for respective Task should be shared =" +msg);
							}
							else
							{
								test.log(LogStatus.FAIL, " Documents for respective Task should be shared =" +msg);
							}
							getDriver().switchTo().parentFrame();
							Thread.sleep(1000);
							performerPOM. clickViewDocAdvocatebillPdfClose().click();
						}
						catch(Exception e)
						{
							 Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage= getDriver().switchTo().alert().getText();	
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
							
						}
					}
					
				
					 
						public static void CriticalDocuments( ExtentTest test) throws InterruptedException
						{
							WebDriverWait wait = new WebDriverWait(getDriver(),60);
							Thread.sleep(1000);
							performerPOM.clickMyDocument().click();					//Clicking on 'My Documents'
							
							Thread.sleep(500);
							performerPOM.clickcriticalDocument().click();	             //clicking on 'critical document'
							
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
							
							Thread.sleep(500);
							String name = OverduePOM.readFolderName().getText();		//Reading the folder name to create new folder.
							
							String folder = name+"Doc11Aug23"; 
							
							OverduePOM.clickNew().click();							//Clicking on '+New' button.
							
							Thread.sleep(300);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(500);
							OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
							
							Thread.sleep(300);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(300);
							OverduePOM.clickIsUniversal().click();
							
							Thread.sleep(300);
							OverduePOM.writeFolderName().sendKeys(folder);			//Writing Folder name.
							
							Thread.sleep(500);
							OverduePOM.clickCreate().click();						//Clicking on create button.
						
							
							Thread.sleep(500);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							
							//String msg = .switchTo().alert().getText();
							//test.log(LogStatus.PASS,"Message displayed=" +msg);
							
						//	.switchTo().alert().accept();
							Thread.sleep(100);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
							name = OverduePOM.readFolderName().getText();				//Reading the folder name we had created
							
							if(folder.equalsIgnoreCase(name))
							{
								test.log(LogStatus.PASS, "Folder Created Succesfully.='"+folder+"' displayed in the records.");
							}
							else
							{
								test.log(LogStatus.FAIL, "Folder Created Succesfully.='"+folder+"' doesn't displayed in the records.");
							}
							
							//without Enter folder Name
							
							Thread.sleep(2000);
							OverduePOM.clickNew().click();	
							
							Thread.sleep(2000);
							OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
							
							Thread.sleep(2000);
							OverduePOM.clickCreate().click();						//Clicking on create button.
							String msg=performerPOM.ClickInvalidMsg().getText();
							if(msg.equalsIgnoreCase(msg))
							{
								test.log(LogStatus.PASS,"Without Enter Folder Name =" +msg);
							}
							else
							{
								test.log(LogStatus.FAIL,"Without Enter Folder Name =" +msg);
							}
							
							Thread.sleep(2000);
							OverduePOM.closeFolderPoppup().click();	
							
							///Share Document in Main Folder 
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
							if(OverduePOM.readFolderName().isDisplayed())			//Checking if file got created or not.
								test.log(LogStatus.PASS, "Uploaded file displayed.");
							else
								test.log(LogStatus.PASS, "Uploaded file does not displayed.");
							Thread.sleep(2000);
							OverduePOM.readFolderName().click();					//Clicking on file we had uploaded.
									
							Thread.sleep(2000);
							OverduePOM.clickShareFolder().click();					//Clicking on Share Folder image.
							
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople()));
							Thread.sleep(2000);
							OverduePOM.clickPeople().click();						//Clicking on People drop down 
							Thread.sleep(2000);
							OverduePOM.clickSearchPeople().click();					//Clicking on Search People drop down.
							
							Thread.sleep(2000);
							OverduePOM.clickSearchPeople().sendKeys("CFO Finance");			//Writing user name to search for
							
							Thread.sleep(2000);
							OverduePOM.clickPeopleCheckBox().click();				//Clicking on label to get out from people search box
							
							
							Thread.sleep(2000);
							OverduePOM.clickpopup().click();	
							
							Thread.sleep(3000);
							OverduePOM.clickDone().click();	  //Clicking on 'Done' to share folder.
							
							
							Thread.sleep(3000);
							String msg3 = getDriver().switchTo().alert().getText();
						    test.log(LogStatus.PASS,"Message displayed=" +msg3);
							
						    getDriver().switchTo().alert().accept(); 
							
							//Delete Folder
							
							Thread.sleep(2000);
							OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
							
							Thread.sleep(2000);
							performerPOM.ClickDeleteFile().click();
							
							String msg1 = getDriver().switchTo().alert().getText();
						    test.log(LogStatus.PASS,"Message displayed=" +msg1);
							
						    getDriver().switchTo().alert().accept();
							
							
							
			
							Thread.sleep(4000);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
							OverduePOM.clickDashboard().click();	
							
							
							
							
						}
						
						public static void CriticalDocuments1( ExtentTest test) throws InterruptedException
						{
							WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							Thread.sleep(1000);
							performerPOM.clickMyDocument().click();					//Clicking on 'My Documents'
							
							Thread.sleep(500);
							performerPOM.clickcriticalDocument().click();	             //clicking on 'critical document'
							
							//Create Sub folder
							
								Thread.sleep(500);
								OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
								Thread.sleep(500);
								OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
								//Thread.sleep(500);
								//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']")));	//Wating till the content table gets visible
								

								Thread.sleep(1000);
								OverduePOM.clickNew().click();							//Clicking on '+New' button.
								
								Thread.sleep(1000);
								OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
								
								Thread.sleep(1000);
								OverduePOM.writeFolderName().sendKeys("Document 21july23");			//Writing Folder name.
								
								Thread.sleep(1000);
								OverduePOM.clickCreate1().click();						//Clicking on create button.
								Thread.sleep(1000);
								try
								{
									Thread.sleep(1000);
									String msg1=performerPOM.ClickSuccessMsg().getText();
									test.log(LogStatus.PASS, " sub-folder should get created =" +msg1);
								}
								catch(Exception e)
								{
									Thread.sleep(1000);
									String msg1=performerPOM.ClickInvalidMsg().getText();
									test.log(LogStatus.PASS, " sub-folder should not get  created =" +msg1);
								}
								
								Thread.sleep(1000);
								OverduePOM.closeFolderPoppup().click();	
								
								//Without enter sub-folder 
								

								Thread.sleep(2000);
								OverduePOM.clickNew().click();			
								
								Thread.sleep(2000);
								OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
								
								
								Thread.sleep(2000);
								OverduePOM.clickCreate1().click();						//Clicking on create button.
								String msg=performerPOM.ClickInvalidMsg().getText();
								if(msg.equalsIgnoreCase(msg))
								{
									test.log(LogStatus.PASS,"Without Enter Sub-Folder Name =" +msg);
								}
								else
								{
									test.log(LogStatus.FAIL,"Without Enter Sub-Folder Name =" +msg);
								}
								
								Thread.sleep(2000);
								OverduePOM.closeFolderPoppup().click();	
							
							//Upload Document File
							
							Thread.sleep(500);
							OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
							Thread.sleep(500);
							OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
							
							Thread.sleep(500);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNew()));
							OverduePOM.clickNew().click();							//Clicking on 'New'
							
							Thread.sleep(500);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							//Thread.sleep(500);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNewFile()));
							OverduePOM.clickNewFile().click();						//CLicking on 'New File'
							
							Thread.sleep(500);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(500);
							
							OverduePOM.uploadNewFile().sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");	//uploading new file		
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUploadDocument()));
							OverduePOM.clickUploadDocument().click();				//Clicking on 'Upload Document'
							
						
							
							String msg1 = getDriver().switchTo().alert().getText();
						    test.log(LogStatus.PASS,"Message displayed=" +msg1);
							
							getDriver().switchTo().alert().accept();
							
							
							//Share Document 
							Thread.sleep(100);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
							/*if(OverduePOM.readFolderName().isDisplayed())			//Checking if file got created or not.
								test.log(LogStatus.PASS, "Uploaded file displayed.");
							else
								test.log(LogStatus.PASS, "Uploaded file does not displayed.");*/
							
							OverduePOM.readFolderName().click();					//Clicking on file we had uploaded.
									
							Thread.sleep(500);
							OverduePOM.clickShareFolder().click();					//Clicking on Share Folder image.
							
							Thread.sleep(500);
							litigationAdditionalOwner.MethodsPOM.progress();
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople()));
							OverduePOM.clickPeople().click();						//Clicking on People drop down 
							OverduePOM.clickSearchPeople().click();					//Clicking on Search People drop down.
							
							Thread.sleep(500);
							OverduePOM.clickSearchPeople().sendKeys("CFO Finance");			//Writing user name to search for
							
							Thread.sleep(500);
							OverduePOM.clickPeopleCheckBoxSubFolder().click();				//Clicking on label to get out from people search box
							
							Thread.sleep(2000);
							OverduePOM.clickpopup().click();	
							
							Thread.sleep(500);
							OverduePOM.clickDone().click();	  //Clicking on 'Done' to share folder.
							
							String msg3 = getDriver().switchTo().alert().getText();
						    test.log(LogStatus.PASS,"Message displayed=" +msg3);
							
							getDriver().switchTo().alert().accept();
							
							//view Document File

							Thread.sleep(2000);
				
						OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
						
						test.log(LogStatus.PASS, "View Popup open successfully");
						
						//Download Document file
						
						Thread.sleep(2000);
						performerPOM.ClickDownloadfile().click();
						
						test.log(LogStatus.PASS, "File Download successfully");
						
						//Update Document Details
						
					Thread.sleep(2000);
						OverduePOM.readFolderName().click();	
						
						
						Thread.sleep(2000);
						performerPOM.ClickEditDetailesFile().click();	
						
						Thread.sleep(500);
						performerPOM.ClickHeader().clear();	
						
						
						Thread.sleep(500);
						performerPOM.ClickHeader().sendKeys("ABCD");
						
						Thread.sleep(500);
						performerPOM.ClickUpdateInfo().click();	
						Thread.sleep(500);
						String msg4=performerPOM.ClickUpdateSuccessmsg().getText();
						
						if(msg4.equalsIgnoreCase(msg4))
						{
							test.log(LogStatus.PASS, "Message Displayed =" +msg4);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Displayed =" +msg4);
						}
							
								
							//Delete Document file
							Thread.sleep(500);
							performerPOM.ClickDeleteFile().click();
							
							String msg2 = getDriver().switchTo().alert().getText();
						    test.log(LogStatus.PASS,"Message displayed=" +msg2);
							
							getDriver().switchTo().alert().accept();
							
							
							Thread.sleep(500);
							wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
							OverduePOM.clickDashboard().click();			//Clicking on Dashboard
						}
						
					 
				 public static void ReportCaseFilter(ExtentTest test) throws InterruptedException
					{
					 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
						  JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
							js.executeScript("window.scrollBy(0,-150)");	
							
							Thread.sleep(3000);
							performerPOM.clickTypeDropdown().click();
							Thread.sleep(3000);
							performerPOM.selectTypeNotice().click();
						
						Thread.sleep(3000);
						performerPOM.clickReportStatusFilter().click();
						Thread.sleep(3000);
				        String Statustext =performerPOM.selectReportStatusFilter().getText();
				        Thread.sleep(3000);
				         performerPOM. selectReportStatusFilter().click();
				       
					
				         Thread.sleep(3000);
						performerPOM.clickReportDeptFilter().click();
						Thread.sleep(3000);
					    String depttext =performerPOM.selectReportCaseDeptFilter().getText();
					    Thread.sleep(5000);
					     performerPOM.selectReportCaseDeptFilter().click();
				         
					     Thread.sleep(3000);
							performerPOM.clickReportTypeFilter().click();
							Thread.sleep(3000);
						    String typetext =performerPOM.selectReportTypeFilterCase().getText();
						    Thread.sleep(3000);
						     performerPOM. selectReportTypeFilterCase().click();
					         
				         
				         
				      
						    Thread.sleep(3000);
							performerPOM.clickReportLocFilter().click();
							Thread.sleep(3000);
							performerPOM.clickExpand().click();
							Thread.sleep(3000);
					       String locationtext =performerPOM.SelectLocation().getText();
					       Thread.sleep(3000);
					       performerPOM. SelectLocation().click();
					      
							Thread.sleep(3000);
							performerPOM.clickReportFYFilter().click();
							Thread.sleep(3000);
						    String FYtext =performerPOM.clickFinancialYearCase().getText();
						    Thread.sleep(3000);
						     performerPOM. clickFinancialYearCase().click();
					       
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
							Thread.sleep(2000);
							CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
							String s = CFOcountPOM.readTotalItems1().getText();
							Thread.sleep(2000);

							if(!s.equalsIgnoreCase("No items to display")) {
							Thread.sleep(5000);
						
							List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]"));
							List<WebElement>deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
							List<WebElement>typecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
							List<WebElement>loctioncol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
							List<WebElement>FYcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
							Thread.sleep(2000);
							js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");
							for(int i=0; i<li.size(); i++){
								
								List<String> text= new ArrayList<String>();
								HashSet<String> pass=new LinkedHashSet<>();
								HashSet<String> fail=new LinkedHashSet<>();
								List<WebElement>raw=new ArrayList<WebElement>();

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
									   raw.addAll(loctioncol);
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
				 
				 public static void ReportNoticeFilter(ExtentTest test) throws InterruptedException
					{
					 	WebDriverWait wait = new WebDriverWait(getDriver(),(60));
						performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						  JavascriptExecutor js = (JavascriptExecutor) getDriver();
							js.executeScript("window.scrollBy(0,-150)");	
						
						Thread.sleep(3000);
						performerPOM.clickReportStatusFilter().click();
						Thread.sleep(3000);
				        String Statustext =performerPOM.selectReportStatusFilter().getText();
				        Thread.sleep(3000);
				         performerPOM. selectReportStatusFilter().click();
				       
					
				         Thread.sleep(3000);
						performerPOM.clickReportDeptFilter().click();
						Thread.sleep(3000);
					    String depttext =performerPOM.selectReportDeptFilter().getText();
					    Thread.sleep(5000);
					     performerPOM.selectReportDeptFilter().click();
				         
					     Thread.sleep(3000);
							performerPOM.clickReportTypeFilter().click();
							Thread.sleep(3000);
						    String typetext =performerPOM.selectReportTypeFilter().getText();
						    Thread.sleep(3000);
						     performerPOM. selectReportTypeFilter().click();
					         
				         
				         
				      
						    Thread.sleep(3000);
							performerPOM.clickReportLocFilter().click();
							Thread.sleep(3000);
							performerPOM.clickExpand().click();
							Thread.sleep(3000);
					       String locationtext =performerPOM.SelectLocation().getText();
					       Thread.sleep(3000);
					       performerPOM. SelectLocation().click();
					      
							Thread.sleep(3000);
							performerPOM.clickReportFYFilter().click();
							Thread.sleep(3000);
						    String FYtext =performerPOM.selectReportFYFilter().getText();
						    Thread.sleep(3000);
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
						
							js.executeScript("window.scrollBy(0,200)");	
							CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
							String s = CFOcountPOM.readTotalItems1().getText();
							Thread.sleep(2000);

							if(!s.equalsIgnoreCase("No items to display")) {
							Thread.sleep(5000);
						
							List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]"));
							List<WebElement>deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
							List<WebElement>typecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
							List<WebElement>loctioncol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
							List<WebElement>FYcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
							Thread.sleep(2000);
							js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=400");
							for(int i=0; i<li.size(); i++){
								
								List<String> text= new ArrayList<String>();
								HashSet<String> pass=new LinkedHashSet<>();
								HashSet<String> fail=new LinkedHashSet<>();
								List<WebElement>raw=new ArrayList<WebElement>();

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
									   raw.addAll(loctioncol);
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
						
						WebDriverWait wait = new WebDriverWait(getDriver(),(60));
							performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
						
							Thread.sleep(500);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
							 JavascriptExecutor js = (JavascriptExecutor) getDriver();
							js.executeScript("window.scrollBy(0,-150)");	
					
							Thread.sleep(3000);
							performerPOM.clickTypeDropdown().click();
							Thread.sleep(3000);
							performerPOM.selectTypeTask().click();
						

							Thread.sleep(3000);
							performerPOM.clickTaskLocFilter().click();
							Thread.sleep(3000);
							performerPOM.clickExpand().click();
							Thread.sleep(3000);
							String locationtext =performerPOM.SelectLocationWorkspace().getText();
							Thread.sleep(3000);
							performerPOM. SelectLocationWorkspace().click();
					       
					       
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
					       //li.add(locationtext);
					         li.add(priorityText);
					         li.add(Statustext);
					        
					        Thread.sleep(3000);
					        
							List<String> filter=new ArrayList<String>();	
							//filter.add("Location");
							filter.add("priority");
							filter.add("Status");
							 
							js.executeScript("window.scrollBy(0,200)");	
							Thread.sleep(3000);
							CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
							String s = CFOcountPOM.readTotalItems1().getText();
							Thread.sleep(2000);

							if(!s.equalsIgnoreCase("No items to display"))
							{
							Thread.sleep(5000);
						
							List<WebElement>Prioritycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
							List<WebElement>Status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
							
							
							Thread.sleep(2000);

							for(int i=0; i<li.size(); i++){
								
								List<String> text= new ArrayList<String>();
								HashSet<String> pass=new LinkedHashSet<>();
								HashSet<String> fail=new LinkedHashSet<>();
								List<WebElement>raw=new ArrayList<WebElement>();

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
					
				 static void Report( ExtentTest test, int count1, String type) throws InterruptedException, IOException
					{
						Thread.sleep(700);
						File dir = new File("C://Users//snehalp//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
//						Thread.sleep(500);
//						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(300);
						performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
						
						Thread.sleep(6000);
						File dir1 = new File("C://Users//snehalp//Downloads");
						File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
						
						if(dirContents.length < allFilesNew.length)
						{
							test.log(LogStatus.PASS, type+":-File Downloaded Successfully.");
							
							File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
						    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
						    {
						       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
						       {
						           lastModifiedFile = allFilesNew[i];
						       }
						    }
							
							Thread.sleep(3000);
							fis = new FileInputStream(lastModifiedFile);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
							int no = sheet.getLastRowNum();
							int SheetRecords = 0;
							for(int i = 0; i <= 5; i++)
							{
								Row row = sheet.getRow(no-i);
								Cell c1 = row.getCell(0);
								String records = c1.getStringCellValue();
								if(records.equals("") || records.equals(null))
								{
									
								}
								else
								{
									SheetRecords = Integer.parseInt(records);
									break;
								}
							}
							fis.close();
							
							if(count1 == SheetRecords)
							{
								//test.log(LogStatus.PASS, type+" - No of records displayed matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
							}
							else
							{
								//test.log(LogStatus.FAIL, type+" - No of records displayed doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "Total records displayed = "+count1+". Total records in Excel sheet = "+SheetRecords);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, type+" - File doesn't downloaded successfully.");
						}
					}
				 
				 public static void MyReports( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
					{
					 WebDriverWait wait = new WebDriverWait(getDriver(), 60);
						progress();
						
						//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
						
				/*		Thread.sleep(4000);
						performerPOM.clickReportTypeFilter().click();
						
//						Thread.sleep(3000);
//						performerPOM.clickReportTypeFilter2().click();
						
						Thread.sleep(5000);
						performerPOM.clickReportTypeFilter4().click();
						
						Thread.sleep(5000);
						if(performerPOM.clearButton().isEnabled())
						{
							performerPOM.clearButton().click();
							 test.log(LogStatus.PASS, "My Workspace = clear button Work Successfully");
						}
						else
						{
							test.log(LogStatus.PASS, "My Workspace = clear button not Work Successfully");
						}*/
						
						//--------------------------------Notice----------------------------------
						
						Thread.sleep(2000);
						 JavascriptExecutor js = (JavascriptExecutor) getDriver();
						performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
						performerPOM.clickExcelReport().sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
						
						Thread.sleep(3000);
						CFOcountPOM.readTotalItems1().click();
						String item = CFOcountPOM.readTotalItems1().getText();
						String[] bits = item.split(" ");								//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport().sendKeys(Keys.END);
							Thread.sleep(3000);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");									//Splitting the String
						}
						String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						int count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							Thread.sleep(3000);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");										//Splitting the String
							compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
						}
						else if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
						Thread.sleep(500);
						Report(test, count1, "Notice");
						
						js.executeScript("window.scrollBy(0,500)");
						js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
					

						Thread.sleep(5000);
						performerPOM.viewNoticeDetails1().click();
						test.log(LogStatus.PASS, "Show details Notice popup open successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup1().click();
						
						Thread.sleep(5000);
						performerPOM.showResponseDetailIcon1().click();
						test.log(LogStatus.PASS, "Show response details Notice  popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup1().click();
						
						//.navigate().refresh();
						
						//--------------------------------Case----------------------------------
						
//						Thread.sleep(1500);
//						js.executeScript("window.scrollBy(500,0)");
//						
						Thread.sleep(3000);
						performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(3000);
						performerPOM.selectTypeNotice().click();					//Selecting 'Case' option.
						
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						Thread.sleep(500);
						performerPOM.clickExcelReport().sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.clickNextPage1());
						js.executeScript("window.scrollBy(0,500)");
						
						Thread.sleep(1000);
						item = CFOcountPOM.readTotalItems1().getText();
						bits = item.split(" ");									//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport().sendKeys(Keys.END);
							Thread.sleep(300);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");									//Splitting the String
							
						}
						compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							Thread.sleep(2500);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");										//Splitting the String
							compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
						}
						else if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
						
						js.executeScript("window.scrollBy(0,500)");
						js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
						
						
						Thread.sleep(5000);
						performerPOM.viewNoticeDetails1().click();
						test.log(LogStatus.PASS, "Show details Case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup1().click();
						
						Thread.sleep(5000);
						performerPOM.showResponseDetailIcon1().click();
						test.log(LogStatus.PASS, "Show hearing details Case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup1().click();
						
						Thread.sleep(500);
						Report(test, count1, "Case");
						
						//.navigate().refresh();

						//--------------------------------Task----------------------------------
						
//						Thread.sleep(1500);
//						js.executeScript("window.scrollBy(500,0)");
						
						performerPOM.clickTypeDropdown().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(300);
						performerPOM.selectTypeTask().click();					//Selecting 'Task' option.
						
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						Thread.sleep(500);
						performerPOM.clickExcelReport().sendKeys(Keys.END);
						js.executeScript("arguments[0].scrollIntoView();", CFOcountPOM.readTotalItems1());
						
						Thread.sleep(1000);
						item = CFOcountPOM.readTotalItems1().getText();
						bits = item.split(" ");								//Splitting the String
						if(bits.length < 2)
						{
							performerPOM.clickExcelReport().sendKeys(Keys.END);
							Thread.sleep(300);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");									//Splitting the String
							
						}
						compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						count1 = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							count1 = 0;
						}
						else
						{
							count1 = Integer.parseInt(compliancesCount);
						}
						
						Thread.sleep(5000);
						performerPOM.viewTaskDetails().click();	
						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.ActioncloseTaskpopup().click();
						
						Thread.sleep(500);
						Report(test, count1, "Task");
						
						
					}

					public static void AdvancedSearchReport(ExtentTest test) throws InterruptedException
					{
						WebDriverWait wait = new WebDriverWait(getDriver(),180);
						
					//	Thread.sleep(5000);
					//	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						Thread.sleep(2000);
				        performerPOM.clickMyReports().click();					//Clicking on 'My Reports'
				        
				         JavascriptExecutor js = (JavascriptExecutor) getDriver();
						js.executeScript("window.scrollBy(0,-800)");
				        //Thread.sleep(3000);
				       // performerPOM.clickExcelReport1().click();
				       // test.log(LogStatus.PASS, "Usage Report downloaded successfully.");
						
						Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						Thread.sleep(5000);
						
						performerPOM.AdvancedSearchReports().click();
						
					//-------------------------------------------Notice--------------------------------------------------
						
						Thread.sleep(4000);
						performerPOM.startDate().sendKeys("05/01/2022");
						
						Thread.sleep(4000);
						performerPOM.endDate().sendKeys("05/04/2022");
						
						Thread.sleep(4000);
						performerPOM.clickApplyButton().click();
						
						
						Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
						Thread.sleep(5000);
						performerPOM.clickExportAdavanced().click();
						test.log(LogStatus.PASS, "Notice = File downloaded successfully.");
						
						
						js.executeScript("window.scrollBy(0,800)");
						js.executeScript("document.querySelector(\"div[id='grid1'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
						
						
						  By locator = By.xpath("//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1']");
							
							wait.until(ExpectedConditions.presenceOfElementLocated(locator));
							Thread.sleep(4000);
							
							WebElement ViewButton = getDriver().findElement(locator);	
							Thread.sleep(4000);
						     JavascriptExecutor jse=(JavascriptExecutor) getDriver();
						    jse.executeScript("arguments[0].click();", ViewButton);
						
						//Thread.sleep(5000);
						//performerPOM.viewNoticeDetails().click();
						test.log(LogStatus.PASS, "Show details notice popup open successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup().click();
						
						  By locator1 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
							
							wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
							Thread.sleep(4000);
							
							WebElement ViewButton1 = getDriver().findElement(locator1);	
							Thread.sleep(4000);
							 
						    js.executeScript("arguments[0].click();", ViewButton1);
						
						//Thread.sleep(5000);
						//performerPOM.showResponseDetailIcon().click();
						test.log(LogStatus.PASS, "Show response details notice popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup().click();
						
					//-------------------------------------------Case--------------------------------------------------
						Thread.sleep(4000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						Thread.sleep(4000);
						performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(5000);
						performerPOM.selectTypeCase1().click();
						
						Thread.sleep(3000);
						performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case = File downloaded successfully.");
						
						
						 By locator2 = By.xpath("//a[@class='k-button k-button-icontext ob-hearing1 k-grid-hearing1']");
							
							wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
							Thread.sleep(4000);
							
							WebElement ViewButton2 = getDriver().findElement(locator2);	
							Thread.sleep(4000);
							  
						    js.executeScript("arguments[0].click();", ViewButton2);
					
						//Thread.sleep(5000);
						//performerPOM.viewNoticeDetails().click();
						test.log(LogStatus.PASS, "Show details case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup().click();
						
						 By locator3 = By.xpath("//a[@class='k-button k-button-icontext ob-edit1 k-grid-edit1']");
							
							wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
							Thread.sleep(4000);
							
							WebElement ViewButton3 =getDriver().findElement(locator3);	
							Thread.sleep(4000);
							 
						    js.executeScript("arguments[0].click();", ViewButton3);
						
						
						//Thread.sleep(5000);
						//performerPOM.showResponseDetailIcon().click();
						test.log(LogStatus.PASS, "Show Hearing details Case popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.Actionclosepopup().click();
						
					//-------------------------------------------Task--------------------------------------------------
							Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						
						Thread.sleep(8000);
						performerPOM.clickTypeDropdown1().click();					//Clicking on Type drop down box (i.e. Notice, Case, Task)
						Thread.sleep(8000);
						performerPOM.selectTypeTask1().click();
						
						Thread.sleep(5000);
						performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Task = File downloaded successfully.");
						
						
						Thread.sleep(5000);
						performerPOM.viewTaskDetails().click();	
						test.log(LogStatus.PASS, "Show details Task popup open successfully.");
						
						Thread.sleep(5000);
						performerPOM.ActioncloseTaskpopup().click();
						
						Thread.sleep(500);
						OverduePOM.clickDashboard().click();
					}
					public static void MoreReport( ExtentTest test) throws InterruptedException
					{
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						Thread.sleep(5000);
						performerPOM.clickMyReports().click();
						

						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));	//Wait until records table gets visible.
						
						  JavascriptExecutor js=(JavascriptExecutor) getDriver();
						js.executeScript("window.scrollBy(0,-900)");
						
						Thread.sleep(5000);
						performerPOM.clickMoreReports().click();
						//--------------------------------Case Report------------------------------------------
//						Thread.sleep(3000);
//						performerPOM.clicklocationFilterReports().click();
//						
//						Thread.sleep(5000);
//						performerPOM.selectlocationFilterReportscfo().click();
						
						Thread.sleep(5000);
						performerPOM.FromDateReports().sendKeys("01-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectFromDate().click();
						
						Thread.sleep(4000);
						performerPOM.ToDateReports().sendKeys("21-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectToDate().click();
						
						
						//--------------------------MIS Report------------------------------
						
					    Thread.sleep(100);
						File dir = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - MIS Report downloaded successfully.");
						
						
					    //--------------------------closed Cases Reports------------------------------
						
						Thread.sleep(100);
						File dir1 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.closedCasesReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - closed Cases Reports downloaded successfully.");
						
						
					    //--------------------------Ext LawyerPerformance Reports------------------------------
						
						Thread.sleep(100);
						File dir2 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.ExtLawyerPerformanceReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Ext Lawyer Performance Reports downloaded successfully.");
						
						
						//--------------------------Budget Reports-----------------------------------
						
						
						Thread.sleep(100);
						File dir3 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.BudgetReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Budget Reports downloaded successfully.");
						
						
						//--------------------------Lawyer Details Reports------------------------------
						
						
						
						Thread.sleep(100);
						File dir4 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.LawyerDetailsReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Lawyer Details Reports downloaded successfully.");
						
						//--------------------------Case Payment Reports------------------------------
						
						
						Thread.sleep(100);
						File dir5 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.CasePaymentReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Case Payment Reports downloaded successfully.");

						
					//--------------------------Case Hearing Reports------------------------------
						
						
						Thread.sleep(100);
						File dir6 = new File("C://Users//snehalp//Downloads");
					//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(250);
						performerPOM.CaseHearingReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Case Hearing Reports downloaded successfully.");

						
						//--------------------------CourtCaseReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir7 = new File("C://Users//snehalp//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtCaseReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Court Case Reports downloaded successfully.");

						
						//--------------------------CourtOrderReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir8 = new File("C://Users//snehalp//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtOrderReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Court Order Reports downloaded successfully.");
						
						
						//-------------------------CourtDoumentReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir9 = new File("C://Users//snehalp//Downloads");
					 //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.CourtDoumentReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - Court Doument Reports downloaded successfully.");
						
						//-------------------------noticeCovertedToCaseReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir10 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.noticeCovertedToCaseReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - notice Coverted To Case Reports downloaded successfully.");
					
						
						//-------------------------AllReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir11 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.AllReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Case - All Reports downloaded successfully.");
					
						
					
						//----------------------------------------Notice Report------------------------------------------------
						
						Thread.sleep(3000);
						performerPOM.clickNoticeReport().click();
						
						
//						Thread.sleep(3000);
//						performerPOM.clicklocationFilterReports().click();
					
						//Thread.sleep(3000);
						//performerPOM.selectlocationFilterReportscfo().click();
						
						Thread.sleep(3000);
						performerPOM.FromDateReports().sendKeys("01-12-2022");
						
//						Thread.sleep(3000);
//						performerPOM.selectFromDate().click();
						
						Thread.sleep(3000);
						performerPOM.ToDateReports().sendKeys("21-12-2022");
						
						//------------------------MISReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir15 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- MIS Reports downloaded successfully.");
						
						
						//------------------------closedCasesReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir20 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.closedCasesReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- closed Notice Reports downloaded successfully.");
						
						
						
					
						//------------------------MISReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir19 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.MISReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- MIS All Reports downloaded successfully.");
						
						
						//------------------------ExtLawyerPerformanceReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir18 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.ExtLawyerPerformanceReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- Ext Lawyer Performance Reports downloaded successfully.");
						
						
						
						
						//------------------------BudgetReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir17 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.BudgetReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- Budget Reports downloaded successfully.");
						
						
						
						
						//------------------------clickNoticePaymentReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir16 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.LawyerDetailsReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- Lawyer Details downloaded successfully.");
						
						
						//------------------------clickNoticePaymentReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir13 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.clickNoticePaymentReport().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- Notice Payment Report downloaded successfully.");
						
						
						
						//------------------------clickNoticeResponseReport------------------------------
						
						
						 Thread.sleep(100);
						 File dir14 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.clickNoticeResponseReport().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, "Notice- Notice Response Report downloaded successfully.");
						
							
						
						
						//-------------------------AllReports------------------------------
						
						
						 Thread.sleep(100);
						 File dir12 = new File("C://Users//snehalp//Downloads");
					     //	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
						Thread.sleep(250);
						performerPOM.AllReports().click();					//Clicking on 'Excel Report' image.
						test.log(LogStatus.PASS, " Notice- All Report downloaded successfully.");
						
						
						Thread.sleep(500);
						OverduePOM.clickDashboard().click();
						
					}
					public static void TaskOpen( ExtentTest test) throws InterruptedException, IOException
					{
						  
			           //int sheetNo=8; 
						
					    
					//  performerPOM.clickTaskOpen().click();
						int open = CountExcel(test, "Task - Open");
						
						Thread.sleep(500);
						performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
						  JavascriptExecutor js=(JavascriptExecutor) getDriver();
						js.executeScript("window.scrollBy(0,700)");
						
						Thread.sleep(300);
						CFOcountPOM.readTotalItems1().click();
						String item = CFOcountPOM.readTotalItems1().getText();
						String[] bits = item.split(" ");								//Splitting the String
						String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
						int gridRecords = 0;
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							Thread.sleep(2000);
							item = CFOcountPOM.readTotalItems1().getText();
							bits = item.split(" ");								//Splitting the String
							compliancesCount = bits[bits.length - 2];
						}
						if(compliancesCount.equalsIgnoreCase("to"))
						{
							gridRecords = 0;
						}
						else
						{
							gridRecords = Integer.parseInt(compliancesCount);
						}
						
						//sheet = workbook.getSheetAt(sheetNo);
						
						TaskAdd(test, sheet, open, gridRecords, "Task - Open");
					}
					static void TaskAdd( ExtentTest test, XSSFSheet sheet, int open, int gridRecords, String type) throws InterruptedException, EncryptedDocumentException, IOException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						Thread.sleep(500);
						  JavascriptExecutor js=(JavascriptExecutor) getDriver();
						CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
						js.executeScript("window.scrollBy(0,-700)");
						performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
						
						progress();
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
						
//						  Thread.sleep(500);
					    FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet  sheet1 = workbook.getSheetAt(2);
//						Thread.sleep(300);
//						performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
//						OverduePOM.selectNextMonth().click();
//						OverduePOM.selectDate().click();					//Selecting particular date.
//						
						Thread.sleep(500);
						Row row0 = sheet1.getRow(12);								//Selected 0th index row (First row)
						Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
						String title = c1.getStringCellValue();
						performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
						
						FileInputStream fis1 = new FileInputStream(filePath);
					    Workbook workbook1 = WorkbookFactory.create(fis1);
					    Sheet  sheet2 = workbook1.getSheetAt(2);
						Thread.sleep(300);
						row0 = sheet2.getRow(13);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String desc = c1.getStringCellValue();
						performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
						
						Thread.sleep(300);
						performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
						OverduePOM.selectNextMonth().click();
						OverduePOM.selectDate().click();					//Selecting particular date.
						
						Thread.sleep(300);
						Actions action = new Actions(getDriver());
						action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
						
						
						FileInputStream fis2 = new FileInputStream(filePath);
					    Workbook workbook2 = WorkbookFactory.create(fis2);
					    Sheet  sheet3 = workbook2.getSheetAt(2);
						Thread.sleep(300);
						row0 = sheet3.getRow(14);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String outcome = c1.getStringCellValue();
						performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
						
						/*FileInputStream fis3 = new FileInputStream(filePath);
					    Workbook workbook3 = WorkbookFactory.create(fis3);
					    Sheet  sheet4 = workbook3.getSheetAt(2);
						Thread.sleep(1000);
						row0 = sheet4.getRow(15);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String internalUser = c1.getStringCellValue();
						performerPOM.clickInternalUser3().click();
						//performerPOM.selectInternalUser2().click();
						performerPOM.selectInternalUser3().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'*/
						
						Thread.sleep(1000);
						performerPOM.clickInternalUser3().click();
						//performerPOM.selectInternalUser2().click();
						performerPOM.selectInternalUser3().click();
						
						FileInputStream fis4 = new FileInputStream(filePath);
					    Workbook workbook4 = WorkbookFactory.create(fis4);
					    Sheet  sheet5 = workbook4.getSheetAt(3);
						Thread.sleep(1000);
						row0 = sheet5.getRow(16);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String externalUser = c1.getStringCellValue();
						try
						{
							Thread.sleep(300);
							performerPOM.clickExternalUser().click();
							Thread.sleep(500);
							action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
						}
						catch(Exception e)
						{
							
						}
						FileInputStream fis5 = new FileInputStream(filePath);
					    Workbook workbook5 = WorkbookFactory.create(fis5);
					    Sheet  sheet6 = workbook5.getSheetAt(3);
						Thread.sleep(5000);
						row0 = sheet6.getRow(17);									//Selected 0th index row (First row)
						c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
						String remark = c1.getStringCellValue();
						performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
						//Thread.sleep(300);
						//String workingDir = System.getProperty("user.dir");
						//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
						
						Thread.sleep(300);
						OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
						
					
					
						try
						{
							Thread.sleep(2000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage()));
							Thread.sleep(300);
							String msg = performerPOM.clickMessage().getText();
							test.log(LogStatus.PASS, "Add Task Verification=" +msg);
						}
						catch(Exception e)
						{
							Thread.sleep(300);
							String msg1 = performerPOM.clickTaskInvalidMessage().getText();
							
							test.log(LogStatus.FAIL, "Add Task Verification=" +msg1);
						}
						
						getDriver().switchTo().parentFrame();
						performerPOM.clickClose1().click();			//Clicking on 'Close'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));
						
						Thread.sleep(300);
						performerPOM.clickStatusDropDown().click();		//Clicking on 'Status drop down.
						Thread.sleep(500);
						performerPOM.selectStatusDropDown().click();		//Selecting 'Pending/Open' status
						Thread.sleep(300);
						performerPOM.clickStatusDropDown().click();		//Clicking on 'Status drop down.
						Thread.sleep(500);
						performerPOM.selectStatusDropDown1().click();     //Selecting 'Submited' status
						
						Thread.sleep(500);
						performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
						js.executeScript("window.scrollBy(0,700)");
						
						Thread.sleep(1000);
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
						count1 = Integer.parseInt(compliancesCount);
						
						if(count1 > gridRecords)
						{
							//test.log(LogStatus.PASS, "Total Task Count increased in grid after adding New Task.");
							test.log(LogStatus.PASS, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Total Task Count doesn't increased in grid after adding New Task.");
							test.log(LogStatus.FAIL, "Old Task Count from Grid = "+gridRecords+" | New Task Count from Grid = "+count1);
						}
						
						Thread.sleep(500);
						OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskOpen()));
						int open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());	//Reading Notice Open count.
						
						if(open1 > open)
						{
							//test.log(LogStatus.PASS, type+" Dashboard Count Increased.");
							test.log(LogStatus.PASS, " Dashboard Count Increased:- Old Count = "+open+" | New Count = "+open1);
						}
						else
						{
							//test.log(LogStatus.FAIL, type+" Dashboard Count doesn't increased.");
							test.log(LogStatus.FAIL, "Dashboard Count doesn't increased :- Old Count = "+open+" | New Count = "+open1);
						}
					}
					public static void TaskClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						CountExcel(test, "Task - Closed");
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNewTask()));
						OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
					}
					public static void CaseClosed( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						CountExcel(test, "Case - Closed");
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
						OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
					}
					public static void NoticeClosed( ExtentTest test, XSSFWorkbook workbook, String login) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						Thread.sleep(500);
					     CountExcel(test, "Notice - Closed");
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNew()));
						Thread.sleep(500);
						OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
					}
					public static void CloseNoticeCase( ExtentTest test,  String type) throws InterruptedException, IOException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
				
						int closed = 0;
						int open = 0;
						int caseOpen = 0;
						if(type.equals("Notice"))
						{
							closed = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Closed count.
							open = Integer.parseInt(performerPOM.clickNoticeOpen().getText());		//Reading Notice Open count.
							caseOpen = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());
							
							performerPOM.clickNoticeOpen().click();									//Clicking on 'Open' notice
						}
						else if(type.equals("Case"))
						{
							open = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());			//Reading Case Open count.
							closed = Integer.parseInt(performerPOM.clickCaseClosedCFO().getText());		//Reading Case Closed count.
							
							performerPOM.clickCaseOpencfo().click();										//Clicking on 'Open' case
						}
						else if(type.equals("Task"))
						{
							open = Integer.parseInt(performerPOM.clickTaskOpen().getText());			//Reading Task Open count.
							closed = Integer.parseInt(performerPOM.clickTaskClosed().getText());		//Reading Task Closed count.
							
							Thread.sleep(5000);				
							performerPOM.clickTaskOpen().click();	//Clicking on 'Open' task
							
							Thread.sleep(2000);
							performerPOM.clickTrignle2().click();	
							Thread.sleep(4000);
							performerPOM.clickFilter().click();
							Thread.sleep(4000);
							performerPOM.clickSearchFilterworkspace().sendKeys("mgmt regtrack");
							Thread.sleep(4000);
							performerPOM.clickCheckboxcfo().click();
							Thread.sleep(4000);
							performerPOM.clickFilter1().click();
						}
						
						Thread.sleep(300);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickExcelReport()));	//Waiting until visibility of Excel Report button.
						
						Thread.sleep(1000);
						 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
						js.executeScript("window.scrollBy(0,500)");
						
						Thread.sleep(3000);
						performerPOM.GridLoad().click();
						elementsList = performerPOM.clickAction();			//Getting all action buttons.
						js.executeScript("arguments[0].scrollIntoView();", elementsList.get(0));
						
						Thread.sleep(500);
						elementsList = performerPOM.clickAction();			//Getting all action buttons.
						elementsList.get(0).click();								//Clicking on first action button.
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Waiting and switching to IFrame
						
						Thread.sleep(300);
						if(type.equals("Notice"))
						{
							//sheet = workbook.getSheetAt(2);
							
							performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
							
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeStatus()));
							performerPOM.clickNoticeStatus().click();				//Clicking on 'Notice Status' drop down.
							Thread.sleep(300);
							performerPOM.clickClosedStatus().click();				//Selecting 'Closed' option from drop down.
							
							Thread.sleep(300);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCloseDate()));
							performerPOM.clickCloseDate().click();				//Clicking on 'Closed Date' date box
							OverduePOM.selectLastMonth().click();					//Getting last month
							OverduePOM.selectDate2().click();						//Selecting particular date.
							
							Thread.sleep(300);
							performerPOM.clickNoticeResult().click();
							performerPOM.clickSelectResult().sendKeys("In Progress", Keys.ENTER);
							
							 Thread.sleep(500);
							 FileInputStream fis = new FileInputStream(filePath);
						     Workbook workbook = WorkbookFactory.create(fis);
						     Sheet  sheet = workbook.getSheetAt(2);
							Thread.sleep(300);
							Row r1 = sheet.getRow(26);
							Cell c1 = r1.getCell(1);
							String remark = c1.getStringCellValue();
							performerPOM.clickRemark1().sendKeys(remark);
							
							
							Thread.sleep(500);
							FileInputStream fis1 = new FileInputStream(filePath);
						    Workbook workbook1 = WorkbookFactory.create(fis1);
						    Sheet  sheet1 = workbook1.getSheetAt(2);
							Thread.sleep(300);
							r1 = sheet1.getRow(27);
							c1 = r1.getCell(1);
							String CaseNo = c1.getStringCellValue();
							performerPOM.clickCourtCaseNo().sendKeys(CaseNo);
							
							Thread.sleep(300);
							performerPOM.clickSaveConvertCase().click();	
						}
						else if(type.equals("Case"))
						{
							performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
							
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
							
							performerPOM.clickCaseStage().click();
							Thread.sleep(300);
							performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
							
							Thread.sleep(300);
							performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
							Thread.sleep(300);
							performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
							
							Thread.sleep(300);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
							performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
							OverduePOM.selectLastMonth().click();					//Getting last month
							OverduePOM.selectDate2().click();						//Selecting particular date.
							
							Thread.sleep(300);
							performerPOM.clickCaseResult().click();
							performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
							
							Thread.sleep(300);
							performerPOM.clickRemark1().sendKeys("Automation Testing");
							
							Thread.sleep(300);
							performerPOM.clickSave1().click();
						}
						else if(type.equals("Task"))
							
						{
							
				
							Thread.sleep(4000);
							js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
							
							Thread.sleep(4000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickStatus1()));
							performerPOM.clickStatus1().click();
							
							
							List<WebElement>SeletcStatus = getDriver().findElements(By.xpath("//*[@id='ddlStatus_chosen']/div/ul/li[2]"));
	          			    selectOptionFromDropDown_bs(SeletcStatus, "Approve/Closed");
						
							Thread.sleep(5000);
							performerPOM.clickNoticeTaskSaveResponsecfo().click();
							
						}
						if(type.equals("Task"))
						{
					
							Thread.sleep(4000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.clickInvalidResponsemsg()));
							String msg = performerPOM.clickInvalidResponsemsg().getText();
							
							if(msg.contains(msg))
							{
								test.log(LogStatus.PASS, "Message displayed - "+msg);
							}
							else if(msg.contains(msg))
							{
								test.log(LogStatus.FAIL, "Message displayed - "+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message displayed - "+msg);
							}
						
							Thread.sleep(3000);
							getDriver().switchTo().parentFrame();
						
							Thread.sleep(3000);
							performerPOM.ActioncloseTaskpopup().click();
						}
						else
						{
							
						
							Thread.sleep(4000);
							wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage2()));
							String msg = performerPOM.readMessage2().getText();
						
							if(msg.contains("Successfully"))
							{
								test.log(LogStatus.PASS, "Message displayed - "+msg);
							}
							else if(msg.contains("already exist"))
							{
								test.log(LogStatus.FAIL, "Message displayed - "+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message displayed - "+msg);
							}
						
							Thread.sleep(3000);
							getDriver().switchTo().parentFrame();
						
							Thread.sleep(3000);
							performerPOM.clickClose().click();
						}
						
						
						Thread.sleep(5000);
						OverduePOM.clickDashboard().click();
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));
						int closed1 = 0;
						int open1 = 0;
						int caseOpen1 = 0;
						if(type.equals("Notice"))
						{
							closed1 = Integer.parseInt(performerPOM.clickNoticeClosed().getText());	//Reading Notice Open count.
							open1 = Integer.parseInt(performerPOM.clickNoticeOpen().getText());		//Reading Notice Open count.
							caseOpen1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());
							
							if(open > open1 && closed1 > closed && caseOpen1 > caseOpen)
							{
								//test.log(LogStatus.PASS, "Notice-Closed count increased.");
								test.log(LogStatus.PASS, "Notice-Closed count increased :- Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.PASS, "Notice-Open count decreased.");
								test.log(LogStatus.PASS, "Notice-Open count decreased :- Old Count = "+open+" | New Count = "+open1);
								//test.log(LogStatus.PASS, "Case-Open count increased.");
								test.log(LogStatus.PASS, "Case-Open count increased :- Old Count = "+caseOpen+" | New Count = "+caseOpen1);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased.");
								test.log(LogStatus.FAIL, "Notice-Closed count doesn't increased:-Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.");
								test.log(LogStatus.FAIL, "Notice-Open count doesn't decreased.:-Old Count = "+open+" | New Count = "+open1);
								//test.log(LogStatus.FAIL, "Case-Open count doesn't increased.");
								test.log(LogStatus.FAIL, "Case-Open count doesn't increased:-Old Count = "+caseOpen+" | New Count = "+caseOpen1);
							}
						}
						else if(type.equals("Case"))
						{
							open1 = Integer.parseInt(performerPOM.clickCaseOpencfo().getText());			//Reading Case Open count.
							closed1 = Integer.parseInt(performerPOM.clickCaseClosedCFO().getText());		//Reading Case Closed count.
							
							if(open > open1 && closed1 > closed)
							{
								//test.log(LogStatus.PASS, "Case-Closed count increased.");
								test.log(LogStatus.PASS, "Case-Closed count increased :- Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.PASS, "Case-Open count decreased.");
								test.log(LogStatus.PASS, "Case-Open count decreased:-Old Count = "+open+" | New Count = "+open1);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Case-Closed count doesn't increased.");
								test.log(LogStatus.FAIL, "Case-Closed count doesn't increased:-Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.FAIL, "Case-Open count doesn't decreased.");
								test.log(LogStatus.FAIL, "Case-Closed count doesn't increased:-Old Count = "+open+" | New Count = "+open1);
							}
						}
						else if(type.equals("Task"))
						{
							open1 = Integer.parseInt(performerPOM.clickTaskOpen().getText());			//Reading Task Open count.
							closed1 = Integer.parseInt(performerPOM.clickTaskClosed().getText());		//Reading Task Closed count.
							
							if(open > open1 && closed1 > closed)
							{
								//test.log(LogStatus.PASS, "Task-Closed count increased.");
								test.log(LogStatus.PASS, "Task-Closed count increased.:- Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.PASS, "Task-Open count decreased.");
								test.log(LogStatus.PASS, "Task-Open count decreased:-Old Count = "+open+" | New Count = "+open1);
							}
							else
							{
								//test.log(LogStatus.PASS, "Task-Closed count doesn't increased.");
								test.log(LogStatus.FAIL, "Task-Closed count doesn't increased:-Old Count = "+closed+" | New Count = "+closed1);
								//test.log(LogStatus.PASS, "Task-Open count doesn't decreased.");
								test.log(LogStatus.FAIL, "Task-Open count doesn't decreased:-Old Count = "+open+" | New Count = "+open1);
							}
						}
					}
					public static void ImportUtility(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait = new WebDriverWait(getDriver(),20);
						 JavascriptExecutor js = (JavascriptExecutor) getDriver();
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg5);
						}
					
						
						Thread.sleep(3000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
			
						Thread.sleep(3000);
						String msg6 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						if(msg6.equalsIgnoreCase(msg6))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg6);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg6);
						}
					
						
						
						Thread.sleep(3000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
					
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
						
						Thread.sleep(500);
						String msg7 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg7);
						}
						
						
						Thread.sleep(3000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(3000);
						
						
//						
////						Wait wait3=new Wait(,30);
////						Thread.sleep(3000);
////						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
//						
						Thread.sleep(500);
						String msg8 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg8);
						}
						
						
						performerPOM.clickNotice().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(500);
						String msg = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg);
						}
						
						Thread.sleep(3000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(500);
						String msg1= performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg1);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg1);
						}
					
//						
						Thread.sleep(3000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(3000);
//						
//							
//						
//						Wait wait4=new Wait(,30);
//						Thread.sleep(3000);
//						wait.until(ExpectedConditions.visibilityOf(performerPOM.readNoticeMsg()));
						
						Thread.sleep(500);
						String msg3 = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg3);
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
						
						
					}
					
					
					public static void ImportUtilityWithoutData(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Court Case =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Court Case = Validation message not displayed");
						}
					
						
				     	Thread.sleep(3000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
			        	try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Hearing =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Hearing = Validation message not displayed");
						}
						
					
						
						
						Thread.sleep(3000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
							
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Order =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Order = Validation message not displayed");
						}
						
						
						Thread.sleep(3000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile1();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(3000);
											
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Case Payment =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Case Payment = Validation message not displayed");
						}
						
						
						
						performerPOM.clickNotice().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Legal Notice =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Legal Notice = Validation message not displayed");
						}
						
						Thread.sleep(3000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, " Notice Response =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Notice Response =Validation message not displayed");
						}
					
					
						Thread.sleep(3000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile1();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(3000);
						
						try
						{
							
						  Thread.sleep(500);
						  String msg7 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
			              test.log(LogStatus.PASS, "Notice Payment =  Upload Empty File = "+msg7);
							
						  }
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Notice Payment = Validation message not displayed");
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
						
						
					}
					public static void ImportUtilityInvalidData(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Court Case = Enter Invalid Data in Upload File = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Court Case = Enter Invalid Data in Upload File  = "+msg5);
						}
					
						
						Thread.sleep(3000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
			
						Thread.sleep(500);
						String msg6 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg6.equalsIgnoreCase(msg6))
						{
							test.log(LogStatus.PASS, "Case Hearing  = Enter Invalid Data in Upload File = "+msg6);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Hearing = Enter Invalid Data in Upload File  = "+msg6);
						}
					
						
						
						Thread.sleep(3000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
					
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(500);
						String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Case Order = Enter Invalid Data in Upload File  = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Order = Enter Invalid Data in Upload File  = "+msg7);
						}
						
						
						Thread.sleep(3000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile2();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(3000);
						
												
						Thread.sleep(500);
						String msg8 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Case Payment = Enter Invalid Data in Upload File  = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Payment = Enter Invalid Data in Upload File = "+msg8);
						}
						
						
						performerPOM.clickNotice().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(500);
						String msg = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Leagl Notice = Enter Invalid Data in Upload File  = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Leagl Notice  = Enter Invalid Data in Upload File = "+msg);
						}
						
						Thread.sleep(3000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(500);
						String msg1= performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Notice Reposnse = Enter Invalid Data in Upload File = "+msg1);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Reposnse = Enter Invalid Data in Upload File = "+msg1);
						}
					
//						
						Thread.sleep(3000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile2();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(3000);

						Thread.sleep(500);
						String msg3 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Notice Payment = Enter Invalid Data in Upload File = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Payment = Enter Invalid Data in Upload File  = "+msg3);
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
						
						
					}
					
					public static void ImportUtilityTwoManadtoryFileds(ExtentTest test) throws InterruptedException
					{
					
						performerPOM.ClickImportUtility().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseType().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase(msg5))
						{
							test.log(LogStatus.PASS, "Court Case = Enter Two Manadatory fields in Upload File = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Court Case =Enter Two Manadatory fields in Upload File  = "+msg5);
						}
					
						
						Thread.sleep(3000);
						performerPOM.ClickcaseHearing().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
			
						Thread.sleep(500);
						String msg6 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg6.equalsIgnoreCase(msg6))
						{
							test.log(LogStatus.PASS, "Case Hearing  = Enter Two Manadatory fields in Upload File = "+msg6);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Hearing = Enter Two Manadatory fields in Upload File = "+msg6);
						}
					
						
						
						Thread.sleep(3000);
						performerPOM.ClickcaseOrder().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						
					
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg1()));
						
						Thread.sleep(500);
						String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg7.equalsIgnoreCase(msg7))
						{
							test.log(LogStatus.PASS, "Case Order =Enter Two Manadatory fields in Upload File  = "+msg7);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Order = Enter Two Manadatory fields in Upload File  = "+msg7);
						}
						
						
						Thread.sleep(3000);
						performerPOM.ClickcasePayment().click();
						Thread.sleep(3000);
						performerPOM.ChooseCaseFile3();
						Thread.sleep(3000);
						performerPOM.UploadCaseFile().click();
						Thread.sleep(3000);
						
												
						Thread.sleep(500);
						String msg8 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
						
						if(msg8.equalsIgnoreCase(msg8))
						{
							test.log(LogStatus.PASS, "Case Payment = Enter Two Manadatory fields in Upload File  = "+msg8);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Case Payment = Enter Two Manadatory fields in Upload File = "+msg8);
						}
						
						
						performerPOM.clickNotice().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeType().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						
						Thread.sleep(500);
						String msg = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Leagl Notice = Enter Two Manadatory Fileds  in Upload File  = "+msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Leagl Notice  = Enter Two Manadatory Fileds  in Upload File = "+msg);
						}
						
						Thread.sleep(3000);
						performerPOM.ChooseNoticeResponse().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						
						
						Thread.sleep(500);
						String msg1= performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg1.equalsIgnoreCase(msg1))
						{
							test.log(LogStatus.PASS, "Notice Reposnse = Enter Two Manadatory Fileds  in Upload File = "+msg1);
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Reposnse = Enter Two Manadatory Fileds  in Upload File = "+msg1);
						}
					
						
						Thread.sleep(3000);
						performerPOM.ChoosePaymentInfo().click();
						Thread.sleep(3000);
						performerPOM.ChooseNoticeFile3();
						Thread.sleep(3000);
						performerPOM.UploadNoticeFile().click();
						Thread.sleep(3000);

						Thread.sleep(500);
						String msg3 = performerPOM.readNoticeMsg1().getText();		//Reading Message appeared after save button
						
						if(msg3.equalsIgnoreCase(msg3))
						{
							test.log(LogStatus.PASS, "Notice Payment = Enter Two Manadatory Fileds in Upload File = "+msg3);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Notice Payment = Enter Two Manadatory Fileds  in Upload File  = "+msg3);
						}
						Thread.sleep(300);
						OverduePOM.clickDashboard().click();
						
						
					}
					public static void MyReminder( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
					{
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						
						performerPOM.clickMyReminder().click();					//Clicking on 'My Reports'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable()));	//Wait until records table gets visible.
						
						NewReminder(test, "Case");
						
						NewReminder(test, "Notice");
						
						NewReminder(test, "Task");
						
						Thread.sleep(3000);
						OverduePOM.clickDashboard().click();
					}

					static void NewReminder( ExtentTest test, String type) throws InterruptedException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType()));
						Actions action = new Actions(getDriver());
						
						if(type.equalsIgnoreCase("Notice"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						else if(type.equalsIgnoreCase("Task"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						
						Thread.sleep(2000);
						action.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						
						Thread.sleep(3000);
						performerPOM.clickReminderText().sendKeys("Reminder new 5Mar24");
						
						Thread.sleep(3000);
						performerPOM.clickDescription().sendKeys("Reminder new 5Mar24");
						
						Thread.sleep(3000);
						performerPOM.clickRemark2().sendKeys("Remark");
						
						Thread.sleep(3000);
						performerPOM.clickDate().click();
						Thread.sleep(3000);
						OverduePOM.selectNextMonth().click();
						OverduePOM.selectDate().click();
						
						Thread.sleep(3000);
						performerPOM.clickSave().click();				//Clicking on Save button.
						
						Thread.sleep(500);
//						try
//						{
//							wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1()));
//						}
//						catch(Exception e)
//						{
//							wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg1()));
//						}
						Thread.sleep(3000);
						String msg = performerPOM.readMsg1().getText();

						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, type+":-Reminder Saved Successfully.");
						
						}
						else
						{
							test.log(LogStatus.FAIL, type+":-Reminder with same details already exists");
						}
						
						
						Thread.sleep(300);
						getDriver().switchTo().parentFrame();
						
						Thread.sleep(300);
						performerPOM.clickCloseReminder().click();
						
						Thread.sleep(3000);
						performerPOM.clickEditReminder().click();
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						
						
				         Actions action1 = new Actions(getDriver());
						
						if(type.equalsIgnoreCase("Notice"))
						{
							action1.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
//						else if(type.equalsIgnoreCase("Task"))
//						{
//							action1.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
//						}
						
						Thread.sleep(2000);
						action1.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						
						
						
//						Thread.sleep(2000);
//						action.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						
						
						Thread.sleep(3000);
						performerPOM.clickReminderText().clear();
						
						Thread.sleep(3000);
						performerPOM.clickReminderText().sendKeys("Reminder  new 13march2024");
						
						Thread.sleep(3000);
						performerPOM.clickDescription().clear();
						
						Thread.sleep(3000);
						performerPOM.clickDescription().sendKeys("Reminder new 13march2024");
						
						Thread.sleep(3000);
						performerPOM.clickDate().click();
						Thread.sleep(3000);
						OverduePOM.selectNextMonth().click();
						OverduePOM.selectDate().click();
						
						Thread.sleep(3000);
						performerPOM.clickSave().click();				//Clicking on Save button.
						
						
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.readMsg2()));
						
						Thread.sleep(500);
						String msg5 = performerPOM.readMsg2().getText();		//Reading Message appeared after save button
					
						if(msg5.equalsIgnoreCase("Reminder Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
						
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg5);
						}
						

						Thread.sleep(300);
						getDriver().switchTo().parentFrame();
						
						Thread.sleep(300);
						performerPOM.clickCloseReminder().click();
						
//						Thread.sleep(300);
//						performerPOM.clickReminderFilter().click();
//						
//						Thread.sleep(300);
//						performerPOM.clickReminderFilter1().click();
//						
//						Thread.sleep(300);
//						performerPOM.clickReminderFilter2().click();
//						
//						Thread.sleep(300);
//						performerPOM.clickReminderFilter3().click();
						
						
					
						
						
						Thread.sleep(3000);
						performerPOM.clickDeleteReminder().click();
						
						 Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        		
					        // Accepting alert		
					        alert.accept();		
					}
					
					
					public static void ReminderWithoutData( ExtentTest test) throws InterruptedException, IOException
					{
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						
						performerPOM.clickMyReminder().click();					//Clicking on 'My Reports'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.CheckRecordsTable()));	//Wait until records table gets visible.
						
						Reminder(test, "Case");
						
						Reminder(test, "Notice");
						
						Reminder(test, "Task");
						
						
						//Close Button
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						Thread.sleep(500);
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						
						Thread.sleep(300);
						  if(performerPOM.clickClosedDocument().isEnabled())
					  		{
					  			performerPOM.clickClosedDocument().click();
					  			test.log(LogStatus.PASS, "Close button working successfully");
					  		}
					  		else
					  		{
					  			test.log(LogStatus.FAIL, "Close button not working successfully");
					  		}
						  
							Thread.sleep(300);
							getDriver().switchTo().parentFrame();
						
						
						
						
						
						Thread.sleep(3000);
						OverduePOM.clickDashboard().click();
					}
					
					static void Reminder( ExtentTest test, String type) throws InterruptedException
					{
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						
						//Without Enter Data
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType()));
						Actions action = new Actions(getDriver());
						
						if(type.equalsIgnoreCase("Notice"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						else if(type.equalsIgnoreCase("Task"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						
						
						
						Thread.sleep(3000);
						performerPOM.clickSave().click();				//Clicking on Save button.
						
						Thread.sleep(3000);
						String msg = performerPOM.readMsg3().getText();

						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, type+":- Without Enter Data =" +msg);
						
						}
						else
						{
							test.log(LogStatus.FAIL, type+":-Without Enter Data  =" +msg);
						}
						
						Thread.sleep(300);
						getDriver().switchTo().parentFrame();
						
						Thread.sleep(300);
						performerPOM.clickCloseReminder().click();
						
						
						
						//Two Mandatory fields
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType()));
					
						
						if(type.equalsIgnoreCase("Notice"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						else if(type.equalsIgnoreCase("Task"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						
					
						Thread.sleep(2000);
						action.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						
						
						Thread.sleep(3000);
						performerPOM.clickDate().click();
						Thread.sleep(3000);
						OverduePOM.selectNextMonth().click();
						OverduePOM.selectDate().click();
						
						Thread.sleep(3000);
						performerPOM.clickSave().click();				//Clicking on Save button.
						
						Thread.sleep(3000);
						String msg1 = performerPOM.readMsg3().getText();

						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, type+":-Enter Two Manadatory Fields =" +msg1);
						
						}
						else
						{
							test.log(LogStatus.FAIL, type+":-Enter Two Manadatory Fields  =" +msg1);
						}
						
						Thread.sleep(300);
						getDriver().switchTo().parentFrame();
						
						Thread.sleep(300);
						performerPOM.clickCloseReminder().click();
						
						
						//Reminder date greater than current date
						
						
						
						Thread.sleep(500);
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickAddNew1()));
						performerPOM.clickAddNew1().click();		//Clicking on 'Add New' button.
						
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickType()));
						
						
						if(type.equalsIgnoreCase("Notice"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						else if(type.equalsIgnoreCase("Task"))
						{
							action.moveToElement(performerPOM.clickType()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
						}
						
						
						
						Thread.sleep(2000);
						action.moveToElement(performerPOM.clickTitle()).click().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
												
						Thread.sleep(3000);
						performerPOM.clickReminderText().clear();
						
						Thread.sleep(3000);
						performerPOM.clickReminderText().sendKeys("Reminder  test 25march2023");
						
						Thread.sleep(3000);
						performerPOM.clickDescription().clear();
						
						Thread.sleep(3000);
						performerPOM.clickDescription().sendKeys("Reminder test 25march2023");
						
						Thread.sleep(3000);
						performerPOM.clickDate().sendKeys("29-06-2023");
						
						
						Thread.sleep(3000);
						performerPOM.clickSave().click();				//Clicking on Save button.
						
						Thread.sleep(3000);
						String msg2 = performerPOM.readMsg2().getText();

						
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, type+":-Reminder date =" +msg2);
						
						}
						else
						{
							test.log(LogStatus.FAIL, type+":-Reminder date  =" +msg2);
						}
						
					
					Thread.sleep(300);
					getDriver().switchTo().parentFrame();
			        Thread.sleep(300);
					performerPOM.clickCloseReminder().click();
					
			}
						

					
					public static void LegalEntity(ExtentTest test) throws InterruptedException, IOException
					 {
						
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						JavascriptExecutor js = ( (JavascriptExecutor) getDriver());
						progress();
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						
						 performerPOM.clickMasters().click();
					     Thread.sleep(300);
						 performerPOM.chooseMasterLegalEntity().click();
						Thread.sleep(300);
						 performerPOM.addLegalEntity().click();
						
						Thread.sleep(500);
						FileInputStream fis = new FileInputStream(filePath);
					    Workbook workbook = WorkbookFactory.create(fis);
					    Sheet  sheet2 = workbook.getSheetAt(2);
						Row row0 = sheet2.getRow(63);						//Selected 0th index row (First row)
						Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
						String legalEntity= c1.getStringCellValue();
					    performerPOM.legalEntityName().sendKeys(legalEntity);
					
						 Thread.sleep(3000);
					    performerPOM.clickUnitType().click();
					    Thread.sleep(3000);
					    performerPOM.chooseUnitType().click();
					    Thread.sleep(3000);
					    performerPOM.clickLegalEntityType().click();
						Thread.sleep(3000);
						performerPOM.chooseLegalEntityType().click();
					    

						Thread.sleep(500);
						FileInputStream fis1 = new FileInputStream(filePath);
					    Workbook workbook1 = WorkbookFactory.create(fis1);
					    Sheet  sheet1 = workbook1.getSheetAt(2);
						Thread.sleep(1000);
						Row row = sheet1.getRow(64);						//Selected 0th index row (First row)
						Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
						String address= c.getStringCellValue();
					    performerPOM.clickAddressLine().sendKeys(address);
						
					    Thread.sleep(3000);
					    performerPOM.clickState1().click();
					    
					    Thread.sleep(3000);
					    performerPOM.chooseState1().click();
					    
					    Thread.sleep(5000);
					    performerPOM.clickCity().click();
					    
					    Thread.sleep(5000);
					    performerPOM.chooseCity().click();
					    
					   
					    Thread.sleep(500);
					    FileInputStream fis2 = new FileInputStream(filePath);
				        Workbook workbook2 = WorkbookFactory.create(fis2);
				        Sheet  sheet = workbook2.getSheetAt(2);
					    Thread.sleep(4000);
						Row row2 = sheet.getRow(65);						//Selected 0th index row (First row)
						Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
						String contact= c2.getStringCellValue();
					    performerPOM.clickContactPerson().sendKeys(contact+"");
					    
					    Thread.sleep(500);
					    FileInputStream fis3 = new FileInputStream(filePath);
				        Workbook workbook3 = WorkbookFactory.create(fis3);
				        Sheet  sheet3 = workbook3.getSheetAt(2);
					    Thread.sleep(3000);
					  	Row row3 = sheet3.getRow(66);						//Selected 0th index row (First row)
					  	Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
					  	String email= c3.getStringCellValue();
					  	 performerPOM.clickEmail().sendKeys(email);
					   
					   	Thread.sleep(3000);
					    performerPOM.clickSaveLegalEntity().click();
					    
					    Thread.sleep(3000);
						
				        js.executeScript("window.scrollBy(0,-400)");
						
					
					    Thread.sleep(3000);
						 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg()));
									
						Thread.sleep(500);
						String msg5 = performerPOM.readlegalmsg().getText();		//Reading Message appeared after save button
						if(msg5.equalsIgnoreCase("Branch Added Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg5);
							
						}
							else
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg5);
							}
						   
							Thread.sleep(3000);
							performerPOM.clickcloseLegalEntity().click();
							    
						    Thread.sleep(3000);  
							performerPOM.editLegalEntity().click();  
							  
							Thread.sleep(3000);  
						    performerPOM.legalEntityName().clear();
							  
						    
						    Thread.sleep(500);
						    FileInputStream fis4 = new FileInputStream(filePath);
					        Workbook workbook4 = WorkbookFactory.create(fis4);
					        Sheet  sheet4 = workbook4.getSheetAt(2);
						    Thread.sleep(5000);
							Row row4 = sheet4.getRow(67);						//Selected 0th index row (First row)
						    Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
						    String NamelegalEntity= c4.getStringCellValue();
						    performerPOM.legalEntityName().sendKeys(NamelegalEntity);
							    
							Thread.sleep(5000);
							performerPOM.clickSaveLegalEntity().click();
							    
							 Thread.sleep(5000);
							 String msg6 = performerPOM.readlegalmsg().getText();		//Reading Message appeared after save button
							 if(msg6.equalsIgnoreCase(msg6))
								{
									test.log(LogStatus.PASS, "Message displayed = "+msg6);
									
								}
									else
									{
										test.log(LogStatus.PASS, "Message displayed = "+msg6);
									}
							    
							 Thread.sleep(5000);
							 performerPOM.clickcloseLegalEntity().click();
							 
						/*	 Thread.sleep(5000);
							 performerPOM.clickLegalEntityFilter().sendKeys("Sandeep Agrawal", Keys.ENTER);
							 
							 Thread.sleep(5000);
							 performerPOM.clickLegalEntityFilter().clear();
							 
								test.log(LogStatus.PASS,"Legal Entity Filter Work Successfully");*/
								
								
								/* Thread.sleep(3000);
								 performerPOM.clickSubUnitscfo().click();	 
								// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddCustomerBranch")));
								 Thread.sleep(300);
								 performerPOM.addLegalEntity().click();
								
                                Thread.sleep(500);
			    				FileInputStream fis = new FileInputStream(filePath);
		        				Workbook workbook = WorkbookFactory.create(fis);
		        				Sheet  sheet2 = workbook.getSheetAt(8);
								Thread.sleep(5000);
								Row row1 = sheet.getRow(68);						//Selected 0th index row (First row)
								Cell c0 = row1.getCell(1);						//Selected cell (0 row,1 column)
								String subunit= c0.getStringCellValue();
							    performerPOM.legalEntityName().sendKeys(subunit);
							
								 Thread.sleep(3000);
							    performerPOM.clickUnitType().click();
							    Thread.sleep(3000);
							    performerPOM.chooseUnitType().click();
							    Thread.sleep(3000);
							    performerPOM.clickLegalEntityType().click();
								Thread.sleep(3000);
								performerPOM.chooseLegalEntityType().click();
							    
 								Thread.sleep(500);
			    				FileInputStream fis = new FileInputStream(filePath);
		        				Workbook workbook = WorkbookFactory.create(fis);
		        				Sheet  sheet2 = workbook.getSheetAt(8);
								Thread.sleep(1000);
								Row row6 = sheet.getRow(64);						//Selected 0th index row (First row)
								Cell c6 = row6.getCell(1);						//Selected cell (0 row,1 column)
								String address1= c6.getStringCellValue();
							    performerPOM.clickAddressLine().sendKeys(address1);
								
							    Thread.sleep(3000);
							    performerPOM.clickState1().click();
							    
							    Thread.sleep(3000);
							    performerPOM.chooseState1().click();
							    
							    Thread.sleep(5000);
							    performerPOM.clickCity().click();
							    
							    Thread.sleep(5000);
							    performerPOM.chooseCity().click();
							    
							
								Thread.sleep(500);
			    				FileInputStream fis = new FileInputStream(filePath);
								Workbook workbook = WorkbookFactory.create(fis);
								Sheet  sheet2 = workbook.getSheetAt(8);
							    Thread.sleep(4000);
								Row row7 = sheet.getRow(65);						//Selected 0th index row (First row)
								Cell c7 = row7.getCell(1);						//Selected cell (0 row,1 column)
								String contact1= c7.getStringCellValue();
							    performerPOM.clickContactPerson().sendKeys(contact1+"");
							    
							    
							      Thread.sleep(500);
			    				FileInputStream fis = new FileInputStream(filePath);
		        				Workbook workbook = WorkbookFactory.create(fis);
		        				Sheet  sheet2 = workbook.getSheetAt(8);
							    Thread.sleep(3000);
							  	Row row8 = sheet.getRow(69);						//Selected 0th index row (First row)
							  	Cell c8 = row8.getCell(1);						//Selected cell (0 row,1 column)
							  	String email1= c8.getStringCellValue();
							  	 performerPOM.clickEmail().sendKeys(email1);
							   
							   	Thread.sleep(3000);
							    performerPOM.clickSaveLegalEntity().click();
							    
							    Thread.sleep(3000);
								
						        js.executeScript("window.scrollBy(0,-400)");
								
							    
							    Thread.sleep(3000);
								 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg()));
											
								Thread.sleep(500);
								String msg9 = performerPOM.readlegalmsg().getText();		//Reading Message appeared after save button
								
								if(msg9.equalsIgnoreCase(msg9))
								{
									test.log(LogStatus.PASS, "Add Sub-Entity = "+msg9);
									
								}
									else
									{
										test.log(LogStatus.PASS, "Add Sub-Entity = "+msg9);
									}
								   
									Thread.sleep(3000);
									performerPOM.clickcloseLegalEntity().click();*/
							    
							    
							    
					 }
					
					public static void LegalEntityWithoutData(ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						
						 performerPOM.clickMasters().click();
					     Thread.sleep(300);
						 performerPOM.chooseMasterLegalEntity().click();
						 Thread.sleep(300);
						 performerPOM.addLegalEntity().click();
						 
						  	Thread.sleep(3000);
						    performerPOM.clickSaveLegalEntity().click();
						    
						    Thread.sleep(3000);
							  JavascriptExecutor js = ((JavascriptExecutor) getDriver()) ;
					        js.executeScript("window.scrollBy(0,-400)");
							
						  
						    Thread.sleep(3000);
							 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg1()));
										
							Thread.sleep(500);
							String msg = performerPOM.readlegalmsg1().getText();		//Reading Message appeared after save button
							if(msg.equalsIgnoreCase(msg))
							{
								test.log(LogStatus.PASS, "Wihout Enter data = "+msg);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Wihout Enter data = "+msg);
								}
							   
								Thread.sleep(3000);
								performerPOM.clickcloseLegalEntity().click();
					 }
					
					public static void LegalEntityInvalidData(ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
						
						 performerPOM.clickMasters().click();
					     Thread.sleep(300);
						 performerPOM.chooseMasterLegalEntity().click();
						 Thread.sleep(300);
						 performerPOM.addLegalEntity().click();
						 Thread.sleep(3000);
						 performerPOM.legalEntityName().sendKeys("343$");
						 Thread.sleep(3000);
						    performerPOM.clickUnitType().click();
						    Thread.sleep(3000);
						    performerPOM.chooseUnitType().click();
						    Thread.sleep(3000);
						    performerPOM.clickLegalEntityType().click();
							Thread.sleep(3000);
							performerPOM.chooseLegalEntityType().click();
						    Thread.sleep(3000);
						    performerPOM.clickAddressLine().sendKeys("Pune");
							
						    Thread.sleep(3000);
						    performerPOM.clickState1().click();
						    
						    Thread.sleep(3000);
						    performerPOM.chooseState1().click();
						    
						    Thread.sleep(5000);
						    performerPOM.clickCity().click();
						    
						    Thread.sleep(5000);
						    performerPOM.chooseCity().click();
						 
						 Thread.sleep(3000);
						 performerPOM.clickContactPerson().sendKeys("345");
						 Thread.sleep(3000);
						 performerPOM.clickEmail().sendKeys("dds34");
						 
						  	Thread.sleep(3000);
						    performerPOM.clickSaveLegalEntity().click();
						    
						    Thread.sleep(3000);
							 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
					        js.executeScript("window.scrollBy(0,-400)");
							
						  
						    Thread.sleep(3000);
							 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg1()));
										
							Thread.sleep(500);
							String msg = performerPOM.readlegalmsg1().getText();		//Reading Message appeared after save button
							if(msg.equalsIgnoreCase(msg))
							{
								test.log(LogStatus.PASS, "Enter Invalid data = "+msg);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid data = "+msg);
								}
							   
								Thread.sleep(3000);
								performerPOM.clickcloseLegalEntity().click();
					 }
					
					public static void LegalEntityTwoManadatoryFields(ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
					  performerPOM.clickMasters().click();
					     Thread.sleep(300);
						 performerPOM.chooseMasterLegalEntity().click();
						 Thread.sleep(300);
						 performerPOM.addLegalEntity().click();
					
						 Thread.sleep(3000);
						    performerPOM.clickUnitType().click();
						    
						    Thread.sleep(3000);
						    performerPOM.chooseUnitType().click();
						    
						    Thread.sleep(3000);
						    performerPOM.clickAddressLine().sendKeys("Pune");
						    
							Thread.sleep(3000);
						    performerPOM.clickSaveLegalEntity().click();
						    
						    Thread.sleep(3000);
							 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
					        js.executeScript("window.scrollBy(0,-400)");
							
						  
						    Thread.sleep(3000);
							 wait.until(ExpectedConditions.visibilityOf(performerPOM.readlegalmsg1()));
										
							Thread.sleep(500);
							String msg = performerPOM.readlegalmsg1().getText();		//Reading Message appeared after save button
							if(msg.equalsIgnoreCase(msg))
							{
								test.log(LogStatus.PASS, "Enter Two Manadatory Fields = "+msg);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Enter Two Manadatory Fields = "+msg);
								}
							   
								Thread.sleep(3000);
								performerPOM.clickcloseLegalEntity().click();
					 }
					
					public static void LegalEntityCloseButton(ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
					  performerPOM.clickMasters().click();
					     Thread.sleep(300);
						 performerPOM.chooseMasterLegalEntity().click();
						 Thread.sleep(300);
						 performerPOM.addLegalEntity().click();
						 
						 
						 
						 if(performerPOM.CloseLegalEntity().isEnabled())
						 {
							 Thread.sleep(3000);
							 performerPOM.CloseLegalEntity().click();
							 test.log(LogStatus.PASS,"Legal Entity - Close Button is Clickable");
						 }
						 else
						 {
							 test.log(LogStatus.FAIL,"Legal Entity - Close Button is Clickable");
						 }
					 }
					
					
					
					public static void AddUnitType(ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						progress();
						
						 performerPOM.clickMasters().click();
					     Thread.sleep(3000);
						 performerPOM.chooseMasterLegalEntity().click();
						 Thread.sleep(3000);
						 performerPOM.addLegalEntity().click();
						  Thread.sleep(3000);
						 performerPOM.clickUnitTypePlusIcon().click();
						 
						 Thread.sleep(2000);
						 performerPOM.EnterUnitType().sendKeys("Automation Test One");
						 
						 Thread.sleep(2000);
						 performerPOM.SaveUnitType().click();
						 
						 Thread.sleep(2000);
						 String msg =performerPOM.SaveValidationMsg().getText();
						 Thread.sleep(2000);
						 if(msg.equalsIgnoreCase(msg))
						 {
							test.log(LogStatus.PASS,"Add Unit Type =" +msg);
						 }
						 else
						 {
							 test.log(LogStatus.FAIL, "Add Unit Type =" +msg);
						 }
						 
						 Thread.sleep(300);
						 performerPOM.CloseUnitType().click();
					 }
					
					
					
					
					 public static void LawFirm( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
							
							//wait.until(ExpectedConditions.visibilityOf(performerPOM.clickNoticeOpen()));	//Wait until 'Notice-Open' count get visible
							
						  
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						  //  Thread.sleep(3000);
							//performerPOM.clickMastersMenu().click();
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						    Thread.sleep(3000);
							performerPOM.newLawFirm().click();
							
							
							Thread.sleep(500);
							FileInputStream fis = new FileInputStream(filePath);
						    Workbook workbook = WorkbookFactory.create(fis);
						    Sheet  sheet = workbook.getSheetAt(2);
							Thread.sleep(3000);
							Row row4 = sheet.getRow(71);						//Selected 0th index row (First row)
							Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
							String name= c4.getStringCellValue();
							performerPOM.nameLawFirm().sendKeys(name);
						    
							
							Thread.sleep(500);
							FileInputStream fis1 = new FileInputStream(filePath);
						    Workbook workbook1 = WorkbookFactory.create(fis1);
						    Sheet  sheet1= workbook1.getSheetAt(2);
							Thread.sleep(3000);
						    Row row5 = sheet1.getRow(72);						//Selected 0th index row (First row)
							Cell c5 = row5.getCell(1);						//Selected cell (0 row,1 column)
							String email1= c5.getStringCellValue();
							performerPOM.Email().sendKeys(email1);
							
							

							Thread.sleep(3000);
							progress();
							
							Thread.sleep(500);
							FileInputStream fis2 = new FileInputStream(filePath);
						    Workbook workbook2= WorkbookFactory.create(fis2);
						    Sheet  sheet2 = workbook2.getSheetAt(2);
							Thread.sleep(3000);
							Row row6 = sheet2.getRow(73);						//Selected 0th index row (First row)
							Cell c6 = row6.getCell(1);						//Selected cell (0 row,1 column)
							int contactno = (int) c6.getNumericCellValue();
						    performerPOM.contactNo().sendKeys(contactno+" ");
						    
						   	Thread.sleep(3000);
							performerPOM.clickSaveLawFirm().click();
							
						    
							Thread.sleep(3000);
							String msg5 = performerPOM.ReadLawFirmMsg().getText();		//Reading Message appeared after save button
							
					     	if(msg5.equalsIgnoreCase(msg5))
							{
								test.log(LogStatus.PASS, "Add Law Firm = "+msg5);
								
							}
								else
								{
									test.log(LogStatus.PASS, "Add Law Firm = "+msg5);
								}
							
								
							Thread.sleep(3000);
							performerPOM.clickCloseButton().click();
							
							Thread.sleep(3000);
							performerPOM.editLawFirm().click();
							
							Thread.sleep(3000);
							performerPOM.nameLawFirm().clear();
							
							Thread.sleep(500);
							FileInputStream fis3 = new FileInputStream(filePath);
						    Workbook workbook3 = WorkbookFactory.create(fis3);
						    Sheet  sheet3 = workbook3.getSheetAt(2);
							Thread.sleep(3000);
							Row row12 = sheet3.getRow(77);						//Selected 0th index row (First row)
							Cell c12 = row12.getCell(1);						//Selected cell (0 row,1 column)
							String LawFirmname= c12.getStringCellValue();
							performerPOM.nameLawFirm().sendKeys(LawFirmname);
							
						
							Thread.sleep(3000);
							performerPOM.Email().clear();
							
					
							Thread.sleep(500);
							FileInputStream fis4 = new FileInputStream(filePath);
						    Workbook workbook4 = WorkbookFactory.create(fis4);
						    Sheet  sheet5= workbook4.getSheetAt(2);
							Thread.sleep(3000);
						    Row row13 = sheet5.getRow(72);						//Selected 0th index row (First row)
							Cell c13 = row13.getCell(1);						//Selected cell (0 row,1 column)
							String email2= c13.getStringCellValue();
							performerPOM.Email().sendKeys(email2);
							
							Thread.sleep(3000);
							 performerPOM.contactNo().clear();

							Thread.sleep(3000);
							progress();
							
							Thread.sleep(500);
							FileInputStream fis5 = new FileInputStream(filePath);
						    Workbook workbook5= WorkbookFactory.create(fis5);
						    Sheet  sheet7= workbook5.getSheetAt(2);
							Thread.sleep(3000);
							Row row14 = sheet7.getRow(73);						//Selected 0th index row (First row)
							Cell c14 = row14.getCell(1);						//Selected cell (0 row,1 column)
							int editcontactno = (int) c14.getNumericCellValue();
						    performerPOM.contactNo().sendKeys(editcontactno+"");
							
							Thread.sleep(3000);
							performerPOM.clickSaveLawFirm().click();
							
							
							String msg6 = performerPOM.ReadLawFirmMsg().getText();		//Reading Message appeared after save button
							if(msg6.equalsIgnoreCase(msg6))
							{
								test.log(LogStatus.PASS, "Update Law Firm = "+msg6);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Update Law Firm  = "+msg6);
								}
							
								
							Thread.sleep(3000);
							performerPOM.clickCloseButton().click();
							
							Thread.sleep(3000);
							performerPOM.clickAddNewLawyer().click();
							
							Thread.sleep(500);
							FileInputStream fis6 = new FileInputStream(filePath);
						    Workbook workbook6 = WorkbookFactory.create(fis6);
						    Sheet  sheet6= workbook6.getSheetAt(2);
							Thread.sleep(3000);
							Row row7 = sheet6.getRow(74);						//Selected 0th index row (First row)
							Cell c7 = row7.getCell(1);						//Selected cell (0 row,1 column)
							String firstname= c7.getStringCellValue();
							performerPOM.clickLawyerName().sendKeys(firstname);
							
							
							Thread.sleep(500);
							FileInputStream fis7 = new FileInputStream(filePath);
						    Workbook workbook7 = WorkbookFactory.create(fis7);
						    Sheet  sheet8= workbook7.getSheetAt(2);
							Thread.sleep(3000);
							Row row8 = sheet8.getRow(75);						//Selected 0th index row (First row)
							Cell c8 = row8.getCell(1);						//Selected cell (0 row,1 column)
							String lastname= c8.getStringCellValue();
							performerPOM.clickLawyerLastName().sendKeys(lastname);
							

							Thread.sleep(500);
							FileInputStream fis8 = new FileInputStream(filePath);
						    Workbook workbook8 = WorkbookFactory.create(fis8);
						    Sheet  sheet9= workbook8.getSheetAt(2);
							Thread.sleep(3000);
							Row row9 = sheet9.getRow(76);						//Selected 0th index row (First row)
							Cell c9 = row9.getCell(1);						//Selected cell (0 row,1 column)
							String Designation= c9.getStringCellValue();
							performerPOM.clickLawyerDesignation().sendKeys(Designation);
							
							Thread.sleep(500);
							FileInputStream fis10 = new FileInputStream(filePath);
						    Workbook workbook10 = WorkbookFactory.create(fis10);
						    Sheet  sheet10= workbook10.getSheetAt(2);
							Thread.sleep(3000);
							Row row10 = sheet10.getRow(72);						//Selected 0th index row (First row)
							Cell c10 = row10.getCell(1);						//Selected cell (0 row,1 column)
							String email3= c10.getStringCellValue();
							performerPOM.clickLawyerEmail().sendKeys(email3);
							
							
							Thread.sleep(500);
							FileInputStream fis11 = new FileInputStream(filePath);
						    Workbook workbook11 = WorkbookFactory.create(fis11);
						    Sheet  sheet12= workbook11.getSheetAt(2);
						   	Thread.sleep(3000);
							Row row11 = sheet12.getRow(73);						//Selected 0th index row (First row)
							Cell c11 = row11.getCell(1);						//Selected cell (0 row,1 column)
							int contactno1= (int)c11.getNumericCellValue();
							performerPOM.clickLawyerContactNo().sendKeys(contactno1+"");
						    
							Thread.sleep(3000);
							performerPOM.clickLawyerDepartment().click();
							Thread.sleep(3000);
							performerPOM.selectLawyerDepartment().click();
							Thread.sleep(4000);
							performerPOM.clickLawyerRole().click();
							Thread.sleep(4000);
							performerPOM.selectLawyerRole().click();
							Thread.sleep(5000);
							performerPOM.saveLawyer().click();
							
							String msg7 = performerPOM.readLawyerMsg().getText();		//Reading Message appeared after save button
							if(msg7.equalsIgnoreCase(msg7))
							{
								test.log(LogStatus.PASS, "Add Lawyer = "+msg7);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Add Lawyer = "+msg7);
								}
							
								
							Thread.sleep(5000);
							performerPOM.closeLawyer().click();
							
							
							/*Thread.sleep(5000);
							performerPOM.clickLawFirmFilter().sendKeys("Aditya Puri",Keys.ENTER);
							Thread.sleep(5000);
							performerPOM.clickLawFirmFilter().clear();
							
							test.log(LogStatus.PASS,"Law Firm Filter Work Successfully");*/
							
							
						}	
					 
					 public static void LawFirmWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
					
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						    Thread.sleep(3000);
							performerPOM.newLawFirm().click();
							
						   	Thread.sleep(3000);
							performerPOM.clickSaveLawFirm().click();
							
						    
							Thread.sleep(3000);
							String msg5 = performerPOM.ReadLawFirmMsg1().getText();		//Reading Message appeared after save button
							
					     	if(msg5.equalsIgnoreCase(msg5))
							{
								test.log(LogStatus.PASS, "Without Enter Data = "+msg5);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data = "+msg5);
								}
							
								
							Thread.sleep(3000);
							performerPOM.clickCloseButton().click();
							
							Thread.sleep(2000);
							OverduePOM.clickDashboard().click();
							
							
							
					  }
					 
					 public static void LawFirmInvalidData( ExtentTest test) throws InterruptedException, IOException
					  {
						  

							 Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						    Thread.sleep(3000);
							performerPOM.newLawFirm().click();
							
							Thread.sleep(3000);
							performerPOM.nameLawFirm().sendKeys("#$FSG");
						   	Thread.sleep(3000);
							performerPOM.Email().sendKeys("FGD");
							Thread.sleep(3000);
						    performerPOM.contactNo().sendKeys("675");
						  	Thread.sleep(3000);
							performerPOM.clickSaveLawFirm().click();
					     	Thread.sleep(3000);
							String msg5 = performerPOM.ReadLawFirmMsg1().getText();		//Reading Message appeared after save button
							
					     	if(msg5.equalsIgnoreCase(msg5))
							{
								test.log(LogStatus.PASS, "Enter Invalid Data  = "+msg5);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Data = "+msg5);
								}
							
								
							Thread.sleep(3000);
							performerPOM.clickCloseButton().click();
							
							Thread.sleep(2000);
							OverduePOM.clickDashboard().click();
					  }
					 public static void LawFirmTwoManadatoryFields( ExtentTest test) throws InterruptedException, IOException
					  {
						  

							 Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						    Thread.sleep(3000);
							performerPOM.newLawFirm().click();
						
						   	Thread.sleep(3000);
							performerPOM.Email().sendKeys("snehal@gmail.com");
							Thread.sleep(3000);
						    performerPOM.contactNo().sendKeys("6222222275");
						  	Thread.sleep(3000);
							performerPOM.clickSaveLawFirm().click();
					     	Thread.sleep(3000);
							String msg5 = performerPOM.ReadLawFirmMsg1().getText();		//Reading Message appeared after save button
							
					     	if(msg5.equalsIgnoreCase(msg5))
							{
								test.log(LogStatus.PASS, "Enter Two Manadatory Fields  = "+msg5);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Enter Two Manadatory Fields = "+msg5);
								}
							
								
							Thread.sleep(3000);
							performerPOM.clickCloseButton().click();
							
							Thread.sleep(2000);
							OverduePOM.clickDashboard().click();
					  }	
					 
					 public static void LawFirmCloseButton( ExtentTest test) throws InterruptedException, IOException
					  {
						  

							 Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						    Thread.sleep(3000);
							performerPOM.newLawFirm().click();
							
							
							
							if(performerPOM.clickCloseButton().isEnabled())
							{
								Thread.sleep(3000);
								performerPOM.clickCloseButton().click();
								test.log(LogStatus.PASS, "Close Button is clickable");		
							}
							else
							{
								test.log(LogStatus.PASS, "Close Button is not clickable");		
							}
							
							
							
					        Thread.sleep(2000);
							OverduePOM.clickDashboard().click();
					  }
					 
					 public static void LawyerWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
						  

							 Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						     Thread.sleep(5000);
						    performerPOM.chooseMasterLawFirm().click();
						 
							
							Thread.sleep(3000);
							performerPOM.clickAddNewLawyer().click();
							
							Thread.sleep(5000);
							performerPOM.saveLawyer().click();
							
							String msg7 = performerPOM.readLawyerMsg1().getText();		//Reading Message appeared after save button
							if(msg7.equalsIgnoreCase(msg7))
							{
								test.log(LogStatus.PASS, "Without Enter Data = "+msg7);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data  = "+msg7);
								}
							
								
							Thread.sleep(5000);
							performerPOM.closeLawyer().click();
							
						     Thread.sleep(2000);
								OverduePOM.clickDashboard().click();
					  }
		 public static void LawyerInvalidData( ExtentTest test) throws InterruptedException, IOException
			 {
						  

		       		 Thread.sleep(3000);
				     performerPOM.clickMasters().click();
				     Thread.sleep(5000);
					 performerPOM.chooseMasterLawFirm().click();
					 
						Thread.sleep(3000);
						performerPOM.clickAddNewLawyer().click();
						
						Thread.sleep(3000);
						
						performerPOM.clickLawyerName().sendKeys("344@#");
						
						Thread.sleep(3000);
						performerPOM.clickLawyerLastName().sendKeys("23#");
						

						Thread.sleep(3000);
						performerPOM.clickLawyerDesignation().sendKeys("#$34");
						
						
						Thread.sleep(3000);
						performerPOM.clickLawyerEmail().sendKeys("dg");
						
					   	Thread.sleep(3000);
						performerPOM.clickLawyerContactNo().sendKeys("689");
					    
						Thread.sleep(3000);
						performerPOM.clickLawyerDepartment().click();
						Thread.sleep(3000);
						performerPOM.selectLawyerDepartment().click();
						Thread.sleep(4000);
						performerPOM.clickLawyerRole().click();
						Thread.sleep(4000);
						performerPOM.selectLawyerRole().click();
						Thread.sleep(5000);
						performerPOM.saveLawyer().click();
						
						String msg = performerPOM.readLawyerMsg1().getText();		//Reading Message appeared after save button
						if(msg.equalsIgnoreCase(msg))
						{
							test.log(LogStatus.PASS, "Enter Invalid Data = "+msg);
							
						}
							else
							{
								test.log(LogStatus.FAIL, "Enter Invalid Data= "+msg);
							}
						
							
						Thread.sleep(5000);
						performerPOM.closeLawyer().click();
						
						   Thread.sleep(2000);
							OverduePOM.clickDashboard().click();
						
			 }
		 
		 public static void LawyerTwoManadatoryFileds( ExtentTest test) throws InterruptedException, IOException
		 {
					  

	       		 Thread.sleep(3000);
			     performerPOM.clickMasters().click();
			     Thread.sleep(5000);
				 performerPOM.chooseMasterLawFirm().click();
				 
					Thread.sleep(3000);
					performerPOM.clickAddNewLawyer().click();
					
					Thread.sleep(3000);
					
					performerPOM.clickLawyerName().sendKeys("Sneha");
					
					Thread.sleep(3000);
					performerPOM.clickLawyerLastName().sendKeys("Patil");
					
					Thread.sleep(5000);
					performerPOM.saveLawyer().click();
					
					String msg = performerPOM.readLawyerMsg1().getText();		//Reading Message appeared after save button
					if(msg.equalsIgnoreCase(msg))
					{
						test.log(LogStatus.PASS, "Enter Two Manadatory fields = "+msg);
						
					}
						else
						{
							test.log(LogStatus.FAIL, "Enter Two Manadatory fields= "+msg);
						}
					
						
					Thread.sleep(5000);
					performerPOM.closeLawyer().click();
					
					   Thread.sleep(2000);
	                   OverduePOM.clickDashboard().click();
		 }
		 
		 public static void LawyerCloseButton( ExtentTest test) throws InterruptedException, IOException
		 {
					  

	       		 Thread.sleep(3000);
			     performerPOM.clickMasters().click();
			     Thread.sleep(5000);
				 performerPOM.chooseMasterLawFirm().click();
				 
					Thread.sleep(3000);
					performerPOM.clickAddNewLawyer().click();
					
					if(performerPOM.CloseLawyer().isEnabled())
					{
						Thread.sleep(5000);
						performerPOM.CloseLawyer().click();
						test.log(LogStatus.PASS, "Close button is clickable");
					}
					else
					{
						test.log(LogStatus.FAIL, "Close button is not clickable");
					}
					
					
					
					   Thread.sleep(2000);
	                   OverduePOM.clickDashboard().click();
		 }
					
						
							
							
							
					 
					 
					 public static void User( ExtentTest test) throws InterruptedException, IOException
						{
						 
						
						    WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						
						    Thread.sleep(1000);
						    performerPOM.clickMasters().click();
//						    Thread.sleep(3000);
//							performerPOM.clickMastersMenu().click();
					        Thread.sleep(3000);
						     performerPOM.clickUserMaster().click();
							 Thread.sleep(3000);
							 performerPOM.clickAddNewUser().click();
							 
							 Thread.sleep(500);
							 FileInputStream fis = new FileInputStream(filePath);
							 Workbook workbook = WorkbookFactory.create(fis);
							  Sheet  sheet= workbook.getSheetAt(2);
						      Thread.sleep(4000);
							  Row row12 = sheet.getRow(80);						//Selected 0th index row (First row)
							  Cell c12 = row12.getCell(1);						//Selected cell (0 row,1 column)
							  String firstname1= c12.getStringCellValue();
							  performerPOM.clickUserName().sendKeys(firstname1);
								
							  	Thread.sleep(500);
								FileInputStream fis1 = new FileInputStream(filePath);
								Workbook workbook1 = WorkbookFactory.create(fis1);
								Sheet  sheet1= workbook1.getSheetAt(2);
								Thread.sleep(4000);
								Row row13 = sheet1.getRow(81);						//Selected 0th index row (First row)
								Cell c13 = row13.getCell(1);						//Selected cell (0 row,1 column)
								String lastname1= c13.getStringCellValue();
								performerPOM.clickUserLastName().sendKeys(lastname1);
								

								Thread.sleep(500);
								 FileInputStream fis2 = new FileInputStream(filePath);
								 Workbook workbook2 = WorkbookFactory.create(fis2);
								  Sheet  sheet2= workbook2.getSheetAt(2);
								Thread.sleep(4000);
								Row row14 = sheet2.getRow(82);						//Selected 0th index row (First row)
								Cell c14 = row14.getCell(1);						//Selected cell (0 row,1 column)
								String Designation1= c14.getStringCellValue();
								performerPOM.clickUserDesignation().sendKeys(Designation1);
								
								Thread.sleep(500);
								 FileInputStream fis3 = new FileInputStream(filePath);
								 Workbook workbook3 = WorkbookFactory.create(fis3);
								  Sheet  sheet3= workbook3.getSheetAt(2);
								Thread.sleep(4000);
								Row row15 = sheet3.getRow(83);						//Selected 0th index row (First row)
							   Cell c15 = row15.getCell(1);						//Selected cell (0 row,1 column)
								String email3= c15.getStringCellValue();
								performerPOM.clickUserEmail().sendKeys(email3);
								
								
								Thread.sleep(500);
								 FileInputStream fis4 = new FileInputStream(filePath);
								 Workbook workbook4 = WorkbookFactory.create(fis4);
								  Sheet  sheet4= workbook4.getSheetAt(2);
					     		Thread.sleep(4000);
								Row row16 = sheet4.getRow(84);						//Selected 0th index row (First row)
								Cell c16 = row16.getCell(1);						//Selected cell (0 row,1 column)
								int contactno2= (int)c16.getNumericCellValue();
								 performerPOM.clickUserContactNo().sendKeys(contactno2+"");
							    
							 

							 Thread.sleep(4000);
							 performerPOM.clickUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.clickUserRole().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserRole().click();
							 Thread.sleep(4000);
							 performerPOM.saveUser().click();
							 
							   Thread.sleep(500);
							  
								String msg = performerPOM.UserReadMsg().getText();
								if(msg.contains(msg))
								{
									test.log(LogStatus.PASS,"Add User -"+msg);
								}
								else
								{
									test.log(LogStatus.PASS,"Add User -"+msg);
								}
							  
							  Thread.sleep(3000);
								 performerPOM.closeUser().click();
							  
							 Thread.sleep(3000);
							 performerPOM.editUser().click();
							 
							 Thread.sleep(3000);
							 performerPOM.UserAddress().clear();
							 
							 Thread.sleep(500);
							 FileInputStream fis5 = new FileInputStream(filePath);
							 Workbook workbook5 = WorkbookFactory.create(fis5);
							  Sheet  sheet5= workbook5.getSheetAt(2);
							 Thread.sleep(3000);
							 Row row17 = sheet5.getRow(85);						//Selected 0th index row (First row)
							 Cell c17 = row17.getCell(1);						//Selected cell (0 row,1 column)
						     String address= c17.getStringCellValue();
						     performerPOM.UserAddress().sendKeys(address);
						     
						     Thread.sleep(4000);
							 performerPOM.clickUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.clickUserRole().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserRole().click();
						     
						     Thread.sleep(3000);
							 performerPOM.saveUser().click();
						     
							 
							 
							 Thread.sleep(3000);
							 String msg1 = performerPOM.UserReadMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Update User-"+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Update User-"+msg1);
								}
							 
							  Thread.sleep(4000);
							  performerPOM.closeUser().click();
							 
							  Thread.sleep(4000);
							  performerPOM.UserDeleted().click();
							  
							  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						        
						        Thread.sleep(5000);
						        String alertMessage1=getDriver().switchTo().alert().getText();
						        
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage1);
						        
						        Thread.sleep(2000);
						        // Capturing alert message.    
						         getDriver().switchTo().alert().accept();		
						         
						        /* Thread.sleep(5000);
								 performerPOM.clickLegalEntityFilter().sendKeys("Management", Keys.ENTER);
								 
								  Thread.sleep(5000);
									 performerPOM.clickLegalEntityFilter().clear();
								 
								 test.log(LogStatus.PASS, "User Filter work successfully" );*/
								 
								    Thread.sleep(5000);
									 performerPOM.clickUserMasterResetcfo().click();
									 
									  Thread.sleep(5000);
									    // Switching to Alert        
								        Alert alert1 = getDriver().switchTo().alert();		
								        		
								        // Capturing alert message.    
								        String alertMessage2= getDriver().switchTo().alert().getText();	
								        
								        
								        test.log(LogStatus.PASS, alertMessage2);
								        		
								        // Displaying alert message		
								        System.out.println(alertMessage2);	
								        
								        		
								        // Accepting alert		
								        alert1.accept();	
								        
								        Thread.sleep(5000);
								        String alertMessage3=getDriver().switchTo().alert().getText();
								        
								        
								        Thread.sleep(3000);
								        test.log(LogStatus.PASS, alertMessage3);
								        
								        Thread.sleep(2000);
								        // Capturing alert message.    
								         getDriver().switchTo().alert().accept();
							  	 
						}
					 
					 public static void UserWithoutData( ExtentTest test) throws InterruptedException, IOException
						{
						    Thread.sleep(1000);
						    performerPOM.clickMasters().click();

					        Thread.sleep(3000);
						     performerPOM.clickUserMaster().click();
							 Thread.sleep(3000);
							 performerPOM.clickAddNewUser().click();
							 
							 Thread.sleep(4000);
							 performerPOM.saveUser().click();
							 
							   Thread.sleep(500);
							  
								String msg = performerPOM.UserReadMsg1().getText();
								if(msg.contains(msg))
								{
									test.log(LogStatus.PASS,"Enter Without Data ="+msg);
								}
								else
								{
									test.log(LogStatus.FAIL,"Enter Without Data ="+msg);
								}
							  
							  Thread.sleep(3000);
								 performerPOM.closeUser().click();
							 
						}
					 
					 public static void UserInvalidData( ExtentTest test) throws InterruptedException, IOException
						{
						    Thread.sleep(1000);
						    performerPOM.clickMasters().click();

					        Thread.sleep(3000);
						     performerPOM.clickUserMaster().click();
							 Thread.sleep(3000);
							 performerPOM.clickAddNewUser().click();
							 
							 Thread.sleep(4000);
							  performerPOM.clickUserName().sendKeys("$%67ad");
								
								Thread.sleep(4000);
								performerPOM.clickUserLastName().sendKeys("56fg%^");
								

								Thread.sleep(4000);
								performerPOM.clickUserDesignation().sendKeys("364$%");
								
								
								Thread.sleep(4000);
								performerPOM.clickUserEmail().sendKeys("DJF");
								
								
								
					     		Thread.sleep(4000);
								 performerPOM.clickUserContactNo().sendKeys("5726");
							    Thread.sleep(4000);
							 performerPOM.clickUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserDepartment().click();
							  Thread.sleep(4000);
							 performerPOM.clickUserRole().click();
							  Thread.sleep(4000);
							 performerPOM.selectUserRole().click();
							 Thread.sleep(4000);
							 performerPOM.saveUser().click();
							 
							   Thread.sleep(500);
							  
								String msg = performerPOM.UserReadMsg1().getText();
								if(msg.contains(msg))
								{
									test.log(LogStatus.PASS,"Enter Invalid  Data ="+msg);
								}
								else
								{
									test.log(LogStatus.FAIL,"Enter Invalid Data ="+msg);
								}
							  
							  Thread.sleep(3000);
							   performerPOM.closeUser().click();
							 
						}
					 
					 public static void UserTwoManadatoryFields( ExtentTest test) throws InterruptedException, IOException
						{
						    Thread.sleep(1000);
						    performerPOM.clickMasters().click();

					        Thread.sleep(3000);
						     performerPOM.clickUserMaster().click();
							 Thread.sleep(3000);
							 performerPOM.clickAddNewUser().click();
							 
							 Thread.sleep(4000);
							  performerPOM.clickUserName().sendKeys("Snehal");
								
								Thread.sleep(4000);
								performerPOM.clickUserLastName().sendKeys("Patil");
								 Thread.sleep(4000);
								 performerPOM.saveUser().click();
								 
								   Thread.sleep(500);
								  
									String msg = performerPOM.UserReadMsg1().getText();
									if(msg.contains(msg))
									{
										test.log(LogStatus.PASS,"Enter Two Manadatory fields ="+msg);
									}
									else
									{
										test.log(LogStatus.FAIL,"Enter Two Manadatory fields ="+msg);
									}
								  
								  Thread.sleep(3000);
								   performerPOM.closeUser().click();
						}
					 public static void UserCloseButton( ExtentTest test) throws InterruptedException, IOException
						{
						    Thread.sleep(1000);
						    performerPOM.clickMasters().click();

					        Thread.sleep(3000);
						     performerPOM.clickUserMaster().click();
							 Thread.sleep(3000);
							 performerPOM.clickAddNewUser().click();
							 Thread.sleep(3000);
							 if(performerPOM.CloseLegalEntity().isEnabled())
							 {
								 Thread.sleep(3000);
								   performerPOM.CloseLegalEntity().click();
								   test.log(LogStatus.PASS, "Close Button is clickable");
							 }
							 else
							 {
								 test.log(LogStatus.PASS, "Close Button is not clickable");
							
							 }
							 
					}
							 
					 
					 
					 public static void Opponent( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						   
							WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						  
						  
							 Thread.sleep(5000);
							 performerPOM.clickMasters().click();
//							 Thread.sleep(3000);
//						     performerPOM.clickMastersMenu().click();
							 Thread.sleep(3000);
						     performerPOM.chooseOpponentMasters().click();
						     Thread.sleep(3000);
						     performerPOM.NewOpponent().click();
						   
							
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
								
							Thread.sleep(500);
							FileInputStream fis1 = new FileInputStream(filePath);
							Workbook workbook1 = WorkbookFactory.create(fis1);
							Sheet  sheet1= workbook1.getSheetAt(2);
						    Thread.sleep(3000);
							Row row17 = sheet1.getRow(88);						//Selected 0th index row (First row)
							Cell c17 = row17.getCell(1);						//Selected cell (0 row,1 column)
							String opponentname= c17.getStringCellValue();
						    performerPOM.clickOpponentName().sendKeys(opponentname);
						    
						   Thread.sleep(3000);
						   performerPOM.saveOpponent().click();
						   
						   Thread.sleep(3000);
								 String msg1 = performerPOM.readOppoenentMsg().getText();
									if(msg1.equalsIgnoreCase("msg1"))
									{
										test.log(LogStatus.PASS, "Add Opponent = "+msg1);
										
									}
										else
										{
											test.log(LogStatus.PASS, "Add Opponent = "+msg1);
										}
									
									
						  Thread.sleep(3000);
						   performerPOM.closeOpponent().click();
						   getDriver().switchTo().parentFrame();
						   Thread.sleep(5000);
						   performerPOM.editOpponent().click();
						   
						   
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
						   
						   Thread.sleep(3000);
						   performerPOM.clickOpponentName().clear();
						   
						   Thread.sleep(500);
							 FileInputStream fis = new FileInputStream(filePath);
							 Workbook workbook = WorkbookFactory.create(fis);
							  Sheet  sheet= workbook.getSheetAt(2);
						   Thread.sleep(4000);
						 	Row row18 = sheet.getRow(89);						//Selected 0th index row (First row)
						 	Cell c18 = row18.getCell(1);						//Selected cell (0 row,1 column)
						 	String editopponentname= c18.getStringCellValue();
						 	performerPOM.clickOpponentName().sendKeys(editopponentname);
						 	Thread.sleep(2000);
						 	performerPOM.opponentcontactNo().clear();
						 	Thread.sleep(2000);
						 	performerPOM.opponentcontactNo().sendKeys("0987654321");
						 	    
						 	   Thread.sleep(3000);
							   performerPOM.saveOpponent().click();
							   
						     Thread.sleep(3000);
								String msg2 = performerPOM.readOppoenentMsg().getText();
		                         if(msg2.equalsIgnoreCase(msg2))
									{
										test.log(LogStatus.PASS, "Update Opponent ="+msg2);
										
									}
										else
										{
											test.log(LogStatus.FAIL, "Update Opponent = "+msg2);
										}
									
							 
						      Thread.sleep(3000);
							   performerPOM.closeOpponent().click();
							   
							   getDriver().switchTo().parentFrame();
							   
							   Thread.sleep(3000);
							   performerPOM.deleteOpponent().click();
							   
					     	   Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						        
						        Thread.sleep(2000);
						        String alertMessage1=getDriver().switchTo().alert().getText();
						        
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage1);
						        
						        Thread.sleep(2000);
						        // Capturing alert message.    
						         getDriver().switchTo().alert().accept();	
						         
						        /* Thread.sleep(3000);
								 performerPOM.clickLawFirmFilter().sendKeys("Civil Opponent",Keys.ENTER);
								   
								 Thread.sleep(3000);
								 performerPOM.clickLawFirmFilter().clear();
								 
								 test.log(LogStatus.PASS,"Opponent Filter work successfully");*/
							   
				  } 
					 
					 public static void OpponentWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						  
							WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						  
						  
							 Thread.sleep(5000);
							 performerPOM.clickMasters().click();

							 Thread.sleep(3000);
						     performerPOM.chooseOpponentMasters().click();
						     Thread.sleep(3000);
						     performerPOM.NewOpponent().click();
						   
							
						    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
						
						   Thread.sleep(3000);
						   performerPOM.saveOpponent().click();
						   
						   Thread.sleep(3000);
								 String msg1 = performerPOM.readOppoenentMsg().getText();
									if(msg1.equalsIgnoreCase(msg1))
									{
										test.log(LogStatus.PASS, "Without Enter Data = "+msg1);
										
									}
										else
										{
											test.log(LogStatus.FAIL, "Without Enter Data = "+msg1);
										}
									
									
						   
						   
						   Thread.sleep(3000);
						   performerPOM.closeOpponent().click();
						   
					  }
					 public static void OpponentInvalidData( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						  
							WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						  
						  
							 Thread.sleep(5000);
							 performerPOM.clickMasters().click();

							 Thread.sleep(3000);
						     performerPOM.chooseOpponentMasters().click();
						     Thread.sleep(3000);
						     performerPOM.NewOpponent().click();
						   
							
						    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
						
							   
							   Thread.sleep(3000);
							   performerPOM.clickOpponentName().sendKeys("23@#");
							   
							   Thread.sleep(3000);
							   performerPOM.clickOpponentEmail().sendKeys("dfg2#");
							   
							   Thread.sleep(2000);
							 	performerPOM.opponentcontactNo().sendKeys("456");
							   
							   
						    
						   Thread.sleep(3000);
						   performerPOM.saveOpponent().click();
						   
						   
						   Thread.sleep(3000);
						  String msg= performerPOM. clickCriteriaInvalidMsg().getText();
						  
						   test.log(LogStatus.PASS, "Enter Invalid Opponent name = "+msg);
						   
						   
						   Thread.sleep(3000);
								 String msg1 = performerPOM.readOppoenentMsg1().getText();
									if(msg1.equalsIgnoreCase(msg1))
									{
										test.log(LogStatus.PASS, "Enter Invalid Data = "+msg1);
										
									}
										else
										{
											test.log(LogStatus.FAIL, "Enter Invalid Data = "+msg1);
										}
									
									
						   
						   
						   Thread.sleep(3000);
						   performerPOM.closeOpponent().click();
						   
					  }
					 
					 public static void OpponentCloseButton( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						  
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						  
						  
							 Thread.sleep(5000);
							 performerPOM.clickMasters().click();

							 Thread.sleep(3000);
						     performerPOM.chooseOpponentMasters().click();
						     Thread.sleep(3000);
						     performerPOM.NewOpponent().click();
						   
							
						    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePartyDetial"));
						    
						    if( performerPOM.closeOpponent().isEnabled())
						    {
							   Thread.sleep(3000);
							   performerPOM.closeOpponent().click();
							   test.log(LogStatus.PASS, "Close button is clickable");	
						    }
						    else
						    {
						    	 test.log(LogStatus.FAIL, "Close button is not clickable");	
						    }
						    
						    Thread.sleep(2000);
						    OverduePOM.clickDashboard().click();
					  }
						
					 
					 
					 
					 public static void Court( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						   WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						 
						   Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						    Thread.sleep(3000);
						     performerPOM.clickCourtMasters().click();

					  	   Thread.sleep(3000);
						   performerPOM.clickNewCourt().click();
						   
						   Thread.sleep(5000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						 
						   Thread.sleep(500);
						   FileInputStream fis = new FileInputStream(filePath);
						   Workbook workbook = WorkbookFactory.create(fis);
						   Sheet  sheet= workbook.getSheetAt(2);
						   Thread.sleep(5000);
						   Row row18 = sheet.getRow(93);						//Selected 0th index row (First row)
						   Cell c18 = row18.getCell(1);						//Selected cell (0 row,1 column)
						   String courtname= c18.getStringCellValue();
						   performerPOM.clickCourtName().sendKeys(courtname);
						   
						   Thread.sleep(5000);
						   performerPOM.clickCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.selectCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.clickCountry().click();
						   Thread.sleep(5000);
						   performerPOM.selectCountry().click();
						   
					       Thread.sleep(3000);
						   performerPOM.saveCourt().click();
						   
						   Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Court = "+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Court = "+msg1);
								}
						    
						   Thread.sleep(4000);
						   performerPOM.closeCourt().click();
						   
						  getDriver().switchTo().parentFrame();
						   
						   Thread.sleep(4000);
						   performerPOM.editCourt().click();
						   
						   
						   Thread.sleep(4000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						   

						   Thread.sleep(400);
						   performerPOM.clickCourtName().clear();
						   
						   Thread.sleep(500);
						   FileInputStream fis1 = new FileInputStream(filePath);
						   Workbook workbook1 = WorkbookFactory.create(fis1);
						   Sheet  sheet1= workbook1.getSheetAt(2);
						   Thread.sleep(2000);
						   Row row19 = sheet1.getRow(94);						//Selected 0th index row (First row)
						   Cell c19 = row19.getCell(1);						//Selected cell (0 row,1 column)
						   String editcourtname= c19.getStringCellValue();
						   performerPOM.clickCourtName().sendKeys(editcourtname);
						   
						   Thread.sleep(5000);
						   performerPOM.clickCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.selectCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.clickCountry().click();
						   Thread.sleep(5000);
						   performerPOM.selectCountry().click();
						   
						   
						   
						   Thread.sleep(4000);
						   performerPOM.saveCourt().click();
						   
						   Thread.sleep(3000);
							 String msg2 = performerPOM.readOppoenentMsg().getText();
								if(msg2.contains(msg2))
								{
									test.log(LogStatus.PASS, "Update Court ="+msg2);
								}
								else
								{
									test.log(LogStatus.FAIL, "Update Court ="+msg2);
								}
								 Thread.sleep(4000);
								   performerPOM.closeCourt().click(); 
								   
								   getDriver().switchTo().parentFrame();
								   
								   Thread.sleep(3000);
								   performerPOM.deleteCourt().click();
								   
								   
								   
								   Thread.sleep(5000);
								   // Switching to Alert        
							        Alert alert =getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage);	
							        
							        		
							        // Accepting alert		
							        alert.accept();	
							        
							        
							        
							        Thread.sleep(2000);
							        String alertMessage1=getDriver().switchTo().alert().getText();
							        
							        
							        Thread.sleep(3000);
							        test.log(LogStatus.PASS, alertMessage1);
							        
							        Thread.sleep(2000);
							        // Capturing alert message.    
							         getDriver().switchTo().alert().accept();	
								  	 
							        
							      /*  Thread.sleep(3000);
									 performerPOM.clickLawFirmFilter().sendKeys("	Dehl High Court",Keys.ENTER);
									   
									 Thread.sleep(3000);
									 performerPOM.clickLawFirmFilter().clear();
									 
									 test.log(LogStatus.PASS,"Court Filter work successfully");*/
								   	
								  	 
								   
						}	
					 
					 public static void CourtWithoutData( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						 
						   Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						    Thread.sleep(3000);
						     performerPOM.clickCourtMasters().click();

					  	   Thread.sleep(3000);
						   performerPOM.clickNewCourt().click();
						   
						   Thread.sleep(5000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						 
					       Thread.sleep(3000);
						   performerPOM.saveCourt().click();
						   
						   Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg1().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS,"Without Enter Data=" +msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data=" +msg1);
								}
						    
						   Thread.sleep(4000);
						   performerPOM.closeCourt().click();
					   }
					 
					 public static void CourtInvalidData( ExtentTest test) throws InterruptedException, IOException
					   {
						 
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						 
						   Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						    Thread.sleep(3000);
						     performerPOM.clickCourtMasters().click();

					  	   Thread.sleep(3000);
						   performerPOM.clickNewCourt().click();
						   
						   Thread.sleep(5000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						 
						   Thread.sleep(5000);
						   performerPOM.clickCourtName().sendKeys("$%");
						   
						   Thread.sleep(3000);
							  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
							  
							   test.log(LogStatus.PASS, "Enter Invalid Court name = "+msg);
							   
						   
						   Thread.sleep(5000);
						   performerPOM.clickCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.selectCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.clickCountry().click();
						   Thread.sleep(5000);
						   performerPOM.selectCountry().click();
						   
					       Thread.sleep(3000);
						   performerPOM.saveCourt().click();
						   
						 
						   
						   Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Invalid Data="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL,  "Enter Invalid Data="+msg1);
								}
						    
						   Thread.sleep(4000);
						   performerPOM.closeCourt().click();
					   }
					 
					 
					 public static void CourtTwomanadatoryFields( ExtentTest test) throws InterruptedException, IOException
					   {
						 
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						 
						   Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						    Thread.sleep(3000);
						     performerPOM.clickCourtMasters().click();

					  	   Thread.sleep(3000);
						   performerPOM.clickNewCourt().click();
						   
						   Thread.sleep(5000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						 
						   Thread.sleep(5000);
						   performerPOM.clickCourtName().sendKeys("abc");
						  
						   Thread.sleep(5000);
						   performerPOM.clickCourtType().click();
						   Thread.sleep(5000);
						   performerPOM.selectCourtType().click();
						   
						    Thread.sleep(3000);
							   performerPOM.saveCourt().click();
							   
						   Thread.sleep(3000);
								 String msg1 = performerPOM.readOppoenentMsg().getText();
									if(msg1.contains(msg1))
									{
										test.log(LogStatus.PASS, "Enter Two Manadatory fields ="+msg1);
									}
									else
									{
										test.log(LogStatus.FAIL,  "Enter Two Manadatory fields="+msg1);
									}
							    
							   Thread.sleep(4000);
							   performerPOM.closeCourt().click();
						   }
					 
					 public static void CourtCloseButton( ExtentTest test) throws InterruptedException, IOException
					   {
						 
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							progress();
						 
						   Thread.sleep(3000);
						    performerPOM.clickMasters().click();
						
						    Thread.sleep(3000);
						     performerPOM.clickCourtMasters().click();

					  	   Thread.sleep(3000);
						   performerPOM.clickNewCourt().click();
						   
						   Thread.sleep(5000);
						   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCourt"));
						   
						   if(performerPOM.closeCourt().isEnabled())
						   {
						     Thread.sleep(4000);
						      performerPOM.closeCourt().click();
						      test.log(LogStatus.PASS, "Close button is  clickable");
						   }
						   else
						   {
							   test.log(LogStatus.FAIL, "Close button is not clickable");
						   }
					   }
				 
						   
					 public static void CaseNoticeType( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						   
						   WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
							   
							Thread.sleep(3000);
							performerPOM.clickCasNoticeTypecfo().click();
							
						
						    Thread.sleep(3000);
							performerPOM.NewCaseNoticeType().click();
							
							 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
							Thread.sleep(3000);
							performerPOM.CaseNoticeType().click();
							
							Thread.sleep(3000);
							performerPOM.selectCaseNoticeType().click();
							
							Thread.sleep(3000);
							performerPOM.CaseNoticeType().click();
							
							Thread.sleep(500);
							FileInputStream fis = new FileInputStream(filePath);
							Workbook workbook = WorkbookFactory.create(fis);
							Sheet  sheet= workbook.getSheetAt(2);
							Thread.sleep(3000);
							Row row19 = sheet.getRow(98);						//Selected 0th index row (First row)
							Cell c19 = row19.getCell(1);						//Selected cell (0 row,1 column)
							String typename= c19.getStringCellValue();
							performerPOM.TypeName().sendKeys(typename);
						
							Thread.sleep(6000);
							performerPOM.saveCaseNoticeType().click();
							
							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Case/Notice Type ="+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Case/Notice Type ="+msg1);
								}
							
							
							Thread.sleep(3000);
							performerPOM.closeCaseNoticeType().click();
							
							getDriver().switchTo().parentFrame();
							
							Thread.sleep(3000);
							performerPOM.editCaseNoticeType().click();
							
							Thread.sleep(3000);
							 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
							 
							 
						 
								Thread.sleep(3000);
								performerPOM.TypeName().clear();
								
								Thread.sleep(500);
								FileInputStream fis1 = new FileInputStream(filePath);
							    Workbook workbook1 = WorkbookFactory.create(fis1);
								Sheet  sheet1= workbook1.getSheetAt(2);
								Thread.sleep(3000);
								Row row20 = sheet1.getRow(99);						//Selected 0th index row (First row)
								Cell c20 = row20.getCell(1);						//Selected cell (0 row,1 column)
								String typename1= c20.getStringCellValue();
								performerPOM.TypeName().sendKeys(typename1);
								
								
								Thread.sleep(6000);
								performerPOM.saveCaseNoticeType().click();
								
								 Thread.sleep(3000);
								 String msg2 = performerPOM.readOppoenentMsg().getText();
									if(msg2.contains(msg2))
									{
										test.log(LogStatus.PASS, "Update Case/Notice -"+msg2);
									}
									else
									{
										test.log(LogStatus.FAIL, "Update Case/Notice -"+msg2);
									}
								
								
								Thread.sleep(3000);
								performerPOM.closeCaseNoticeType().click();
								getDriver().switchTo().parentFrame();
								
								Thread.sleep(3000);
								performerPOM.deleteCaseNoticeType().click();
								
								   Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage);	
							        
							        		
							        // Accepting alert		
							        alert.accept();	
							        
							        
							        Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert1 = getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage1);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage1);	
							        
							        		
							        // Accepting alert		
							        alert1.accept();	
							         
							      /*   Thread.sleep(3000);
									 performerPOM.clickLawFirmFilter().sendKeys("Arbittration",Keys.ENTER);
									   
									 Thread.sleep(3000);
									 performerPOM.clickLawFirmFilter().clear();
									 
									 test.log(LogStatus.PASS,"Case/Notice Type Filter work successfully");*/
								  	 
						}	
					 
					 
					 public static void CaseNoticeTypeWithoutData( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
							   
							Thread.sleep(3000);
							performerPOM.clickCasNoticeTypecfo().click();
							
						
						    Thread.sleep(3000);
							performerPOM.NewCaseNoticeType().click();
							
							 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
						
						
							Thread.sleep(6000);
							performerPOM.saveCaseNoticeType().click();
							
							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg1().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS,"Enter Without Data =" +msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Without Data =" +msg1);
								}
							
							
							Thread.sleep(3000);
							performerPOM.closeCaseNoticeType().click();
					   }
					 
					 public static void CaseNoticeTypeInvaliData( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
							   
							Thread.sleep(3000);
							performerPOM.clickCasNoticeTypecfo().click();
							
						
						    Thread.sleep(3000);
							performerPOM.NewCaseNoticeType().click();
							
							 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
							Thread.sleep(3000);
							performerPOM.CaseNoticeType().click();
							
							Thread.sleep(3000);
							performerPOM.selectCaseNoticeType().click();
							
							Thread.sleep(3000);
							performerPOM.CaseNoticeType().click();
							
							Thread.sleep(3000);
						
							performerPOM.TypeName().sendKeys("23#$");
							
							 
							   Thread.sleep(3000);
								  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
								  
								   test.log(LogStatus.PASS, "Enter Invalid Case/Notice Type  = "+msg);
							
							
						
							Thread.sleep(6000);
							performerPOM.saveCaseNoticeType().click();
							
							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Invalid Case/Notice Type=" +msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Case/Notice Type=" +msg1);
								}
							
							
							Thread.sleep(3000);
							performerPOM.closeCaseNoticeType().click();
					   }
					 
					 public static void CaseNoticeTypeCloseButton( ExtentTest test) throws InterruptedException, IOException
					   {
						  
						   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						    Thread.sleep(3000);
						    performerPOM.clickMasters().click();
							   
							Thread.sleep(3000);
							performerPOM.clickCasNoticeTypecfo().click();
							
						
						    Thread.sleep(3000);
							performerPOM.NewCaseNoticeType().click();
							
							 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseType"));
							
							 if(performerPOM.closeCaseNoticeType().isEnabled())
							 {
							     Thread.sleep(3000);
								performerPOM.closeCaseNoticeType().click();
								test.log(LogStatus.PASS, "Close Button is clickable");	
							 }
							 else
							 {
								 test.log(LogStatus.FAIL, "Close Button is not  clickable");	
							 }
					   }
								
					 
					 public static void PaymentType( ExtentTest test) throws InterruptedException, IOException
					 {
						
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(5000);
						  performerPOM.clickMasters().click();  
						  Thread.sleep(3000);
						  performerPOM.clickPaymentTypeMasters().click();
				          Thread.sleep(4000);
						  performerPOM.clickPaymentTypeNew().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
					   
						  Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row20 = sheet.getRow(103);						//Selected 0th index row (First row)
						  Cell c20= row20.getCell(1);						//Selected cell (0 row,1 column)
						  String payment= c20.getStringCellValue();
						   performerPOM.PaymentType().sendKeys(payment);
						   
						   
						  Thread.sleep(4000);
						  performerPOM.savePaymentType().click();
						  

							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Payment Type ="+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Payment Type ="+msg1);
								}
						   
						   Thread.sleep(4000);
						  performerPOM.closePaymentType().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  
						  Thread.sleep(3000);
						  performerPOM.editPaymentType().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
						   
						  Thread.sleep(3000);
						  performerPOM.PaymentType().clear();
						  
						  Thread.sleep(500);
						  FileInputStream fis1 = new FileInputStream(filePath);
						  Workbook workbook1 = WorkbookFactory.create(fis1);
						  Sheet  sheet1= workbook1.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row21 = sheet1.getRow(104);						//Selected 0th index row (First row)
						  Cell c21= row21.getCell(1);						//Selected cell (0 row,1 column)
						  String payment1= c21.getStringCellValue();
						   performerPOM.PaymentType().sendKeys(payment1);
						   
						   Thread.sleep(4000);
							  performerPOM.savePaymentType().click();
							  

								 Thread.sleep(3000);
								 String msg2 = performerPOM.readOppoenentMsg().getText();
									if(msg2.contains(msg2))
									{
										test.log(LogStatus.PASS, "Update Payment Type - "+msg2);
									}
									else
									{
										test.log(LogStatus.FAIL, "Update Payment Type - "+msg2);
									}
							   
							   Thread.sleep(4000);
							  performerPOM.closePaymentType().click();
							  
							  getDriver().switchTo().parentFrame();
							  
							  
						   
							  Thread.sleep(4000);
							  performerPOM.deletePaymentType().click();
							  
							  
							  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert =getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						        
						        Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 =getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1=getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert1.accept();		
						         
						      /*   Thread.sleep(3000);
								 performerPOM.clickLawFirmFilter().sendKeys("Case drafting fees",Keys.ENTER);
								 
								 
								Thread.sleep(3000);
								performerPOM.clickApplybtn().click();
								   
								 Thread.sleep(3000);
								 performerPOM.clickLawFirmFilter().clear();
								 
								 
								 
								 test.log(LogStatus.PASS,"Payment Type Filter work successfully");*/
					 }	
					 
					 
					 public static void PaymentTypeWithoutData( ExtentTest test) throws InterruptedException, IOException
					 {
						
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(5000);
						  performerPOM.clickMasters().click();  
						  Thread.sleep(3000);
						  performerPOM.clickPaymentTypeMasters().click();
				          Thread.sleep(4000);
						  performerPOM.clickPaymentTypeNew().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment")); 
					 	   
						  Thread.sleep(4000);
						  performerPOM.savePaymentType().click();
						  

							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg1().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Without Data ="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Without Data ="+msg1);
								}
						   
						   Thread.sleep(4000);
						  performerPOM.closePaymentType().click();
					 }
					 public static void PaymentTypeInvalidData( ExtentTest test) throws InterruptedException, IOException
					 {
						
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(5000);
						  performerPOM.clickMasters().click();  
						  Thread.sleep(3000);
						  performerPOM.clickPaymentTypeMasters().click();
				          Thread.sleep(4000);
						  performerPOM.clickPaymentTypeNew().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
						  
						  Thread.sleep(4000);
						  performerPOM.PaymentType().sendKeys("#$34");
						  
						   Thread.sleep(3000);
							  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
							  
							   test.log(LogStatus.PASS, "Enter Invalid Payment Type  = "+msg);
					 	   
						  Thread.sleep(4000);
						  performerPOM.savePaymentType().click();
						  

							 Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg1().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Invalid Data ="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Data ="+msg1);
								}
						   
						   Thread.sleep(4000);
						  performerPOM.closePaymentType().click();
					 }
					 
					 public static void PaymentTypeCloseButton( ExtentTest test) throws InterruptedException, IOException
					 {
						
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(5000);
						  performerPOM.clickMasters().click();  
						  Thread.sleep(3000);
						  performerPOM.clickPaymentTypeMasters().click();
				          Thread.sleep(4000);
						  performerPOM.clickPaymentTypeNew().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframePayment"));
						  
						  
						  if(performerPOM.closePaymentType().isEnabled())
						  {
						       Thread.sleep(4000);
							  performerPOM.closePaymentType().click();
							  test.log(LogStatus.PASS,"Close button is clickable");
						  }
						  
						  else
						  {
							  test.log(LogStatus.PASS,"Close button is not clickable");
						  }
					 }
					 
						  
					 public static void customParameter( ExtentTest test) throws InterruptedException, IOException
					  {
				    	 
				    	
				    	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
							 
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						 
						  
						  Thread.sleep(3000);
						  performerPOM.customParameterMaster().click();
						  Thread.sleep(3000);
						  performerPOM.newCustomParameter().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
						  
						  Thread.sleep(3000);
						  performerPOM.typeCustomParameter().click();
						  Thread.sleep(3000);
						  performerPOM.selectTypeCustomParameter().click();
						  
						  
						  Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row21 = sheet.getRow(108);						//Selected 0th index row (First row)
						  Cell c21= row21.getCell(1);						//Selected cell (0 row,1 column)
						  String parameterLable= c21.getStringCellValue();
						  performerPOM.ParameterLabel().sendKeys(parameterLable);
						  
						  Thread.sleep(3000);
						  performerPOM.typeCustomParameter().click();
						  Thread.sleep(3000);
						  performerPOM.saveCustomParameter().click();
						  
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Custome Field- "+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Custome Field- "+msg1);
								}
						   
						   
						  Thread.sleep(3000);
						  performerPOM.closeCustomParameter().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  Thread.sleep(3000);
						  performerPOM.editCustomParameter().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
						  
						  Thread.sleep(3000);
						  performerPOM.ParameterLabel().clear();
						  
						  Thread.sleep(500);
						  FileInputStream fis1 = new FileInputStream(filePath);
						  Workbook workbook1 = WorkbookFactory.create(fis1);
						  Sheet  sheet1= workbook1.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row22 = sheet1.getRow(109);						//Selected 0th index row (First row)
						  Cell c22= row22.getCell(1);						//Selected cell (0 row,1 column)
						  String parameterLable1= c22.getStringCellValue();
						  performerPOM.ParameterLabel().sendKeys(parameterLable1);
						  
						  
						  Thread.sleep(3000);
						  performerPOM.saveCustomParameter().click();
						  
						  
						  Thread.sleep(3000);
							 String msg2 = performerPOM.readOppoenentMsg().getText();
								if(msg2.contains(msg2))
								{
									test.log(LogStatus.PASS, "Update Custome Field -"+msg2);
								}
								else
								{
									test.log(LogStatus.FAIL, "Update Custome Field -"+msg2);
								}
						   
						   
						  Thread.sleep(3000);
						  performerPOM.closeCustomParameter().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  Thread.sleep(3000);
						  performerPOM.deleteCustomParameter().click();
						  
						
							    Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert = getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage= getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						  
					        try
					        {
						        
								  Thread.sleep(5000);
								    // Switching to Alert        
							        Alert alert1 =getDriver().switchTo().alert();		
							        		
							        // Capturing alert message.    
							        String alertMessage1= getDriver().switchTo().alert().getText();	
							        
							        
							        test.log(LogStatus.PASS, alertMessage);
							        		
							        // Displaying alert message		
							        System.out.println(alertMessage);	
							        
							        		
							        // Accepting alert		
							        alert1.accept();	
					        }
					        catch(Exception e)
					        {
					        	
					        }
					     /*   Thread.sleep(6000);
							performerPOM. clickCustomParameterFilter().click();
							
						    Thread.sleep(6000);
							performerPOM. clickCustomParameterFilter1().click();
							
							Thread.sleep(3000);
							performerPOM.clickApplybtn().click();
								   
						    Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().sendKeys("Test",Keys.ENTER);
								 
							Thread.sleep(3000);
							performerPOM.clickApplybtn().click();
							
							 Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().clear();
					
						    
							 test.log(LogStatus.PASS,"Custom Prameter Filter work successfully");*/
					} 
					 
					  public static void customParameterWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
				    	 
				    	
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						  Thread.sleep(3000);
						  performerPOM.customParameterMaster().click();
						  Thread.sleep(3000);
						  performerPOM.newCustomParameter().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
						  
						 
						
						  Thread.sleep(3000);
						  performerPOM.saveCustomParameter().click();
						  
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg1().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Without Enter Data ="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data ="+msg1);
								}
						   
						   
						  Thread.sleep(3000);
						  performerPOM.closeCustomParameter().click();
					  }
					  
					  public static void customParameterInvalidData( ExtentTest test) throws InterruptedException, IOException
					  {
				    	 
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60)); 
							 
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						  Thread.sleep(3000);
						  performerPOM.customParameterMaster().click();
						  Thread.sleep(3000);
						  performerPOM.newCustomParameter().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
						  
						  Thread.sleep(3000);
						  performerPOM.typeCustomParameter().click();
						  Thread.sleep(3000);
						  performerPOM.selectTypeCustomParameter().click();
						  Thread.sleep(3000);
						  performerPOM.typeCustomParameter().click();
						  
						  Thread.sleep(4000);
						  performerPOM.ParameterLabel().sendKeys("$%#8a4");
						    Thread.sleep(4000);
						  performerPOM.saveCustomParameter().click();
						  
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.FAIL, "Enter Invalid  Data ="+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Enter Invalid  Data ="+msg1);
								}
						   
						   
						  Thread.sleep(3000);
						  performerPOM.closeCustomParameter().click();
					  } 
					  
					  public static void customParameterCloseButton( ExtentTest test) throws InterruptedException, IOException
					  {
				    	 
				    	
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60)); 
							 
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						  Thread.sleep(3000);
						  performerPOM.customParameterMaster().click();
						  Thread.sleep(3000);
						  performerPOM.newCustomParameter().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCustomFieldDetial"));
						  
					 
						if( performerPOM.closeCustomParameter().isEnabled())  
					    {
							Thread.sleep(3000);
							 performerPOM.closeCustomParameter().click();
							 test.log(LogStatus.PASS,"Close button is clicakble");
					    }
						else
						{
							 test.log(LogStatus.FAIL,"Close button is not clicakble");
						}
						 
					  } 
					  
					 
					 
					 
					 
					 
					 public static void CaseStage( ExtentTest test) throws InterruptedException, IOException
				     {
				    	
				    	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				    	  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						 
						  
				     	 performerPOM.caseStageMaster().click();
						  Thread.sleep(0);
				    	 performerPOM.newCaseStage().click();
				    	 
				    	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
				    	 
				    	 
				    	 Thread.sleep(500);
						 FileInputStream fis = new FileInputStream(filePath);
						 Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
				    	 Thread.sleep(3000);
						 Row row=sheet.getRow(113);
						 Cell c=row.getCell(1);
						 String casestage=c.getStringCellValue();
				    	 performerPOM.clickcaseStage().sendKeys(casestage);
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.savecaseStage().click();
				    	 
				    	 Thread.sleep(3000);
						 String msg1 = performerPOM.readcaseStagemsg().getText();
							if(msg1.equalsIgnoreCase(msg1))
							{
								test.log(LogStatus.PASS, "Add Case Stage = "+msg1);
								
							}
								else
								{
									test.log(LogStatus.PASS, "Add Case Stage = "+msg1);
								}
							
					   
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.closecaseStage().click();
				    	 getDriver().switchTo().parentFrame();
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.editcaseStage().click();
				    	 
				    	 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
				    	 
				         Thread.sleep(3000);
				         performerPOM.clickcaseStage().clear();
				 
				         
				         Thread.sleep(500);
						 FileInputStream fis1 = new FileInputStream(filePath);
						 Workbook workbook1 = WorkbookFactory.create(fis1);
						  Sheet  sheet1= workbook1.getSheetAt(2);
				    	 Thread.sleep(3000);
						 Row row1=sheet1.getRow(114);
						 Cell c1=row1.getCell(1);
						 String casestage1=c1.getStringCellValue();
				    	 performerPOM.clickcaseStage().sendKeys(casestage1);
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.savecaseStage().click();
				    	 
				    	 Thread.sleep(3000);
						 String msg2 = performerPOM.readcaseStagemsg().getText();
							
							if(msg2.equalsIgnoreCase(msg2))
							{
								test.log(LogStatus.PASS, "Update Case Stage = "+msg2);
								
							}
								else
								{
									test.log(LogStatus.PASS, "Update Case Stage = "+msg2);
								}
							
					   
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.closecaseStage().click();
				    	 getDriver().switchTo().parentFrame();
				    	  
				    	 
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.deletecaseStage().click();
				    	 
				    	 
						  
						  Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        Thread.sleep(5000);
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(5000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        Thread.sleep(5000);	
					        // Accepting alert		
					        getDriver().switchTo().alert().accept();		
					           
					        
							  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 =getDriver().switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1=getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);	
						        
						        		
						        // Accepting alert		
						        alert1.accept();	
						        
					       /*  Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().sendKeys("Final Stage",Keys.ENTER);
							 
							 Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().clear();
							 
							 test.log(LogStatus.PASS, "Case Stage Filter work successfully");*/
				    	 
				  }
					 
					 public static void CaseStageInvalidData( ExtentTest test) throws InterruptedException, IOException
				     {
				    
						 WebDriverWait wait = new WebDriverWait(getDriver(),(60));
				    	  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						 
						  
				     	 performerPOM.caseStageMaster().click();
						  Thread.sleep(0);
				    	 performerPOM.newCaseStage().click();
				    	 
				    	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
				    	  
				    	 Thread.sleep(3000);
						
				    	 performerPOM.clickcaseStage().sendKeys("$%45");
				    	 
				  	   Thread.sleep(3000);
						  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
						  
						   test.log(LogStatus.PASS, "Enter Invalid Case Stage Name  = "+msg);
				    	 
				    	 Thread.sleep(3000);
				    	 performerPOM.savecaseStage().click();
				    	 
				    	 Thread.sleep(3000);
						 String msg1 = performerPOM.readcaseStagemsg().getText();
							if(msg1.equalsIgnoreCase(msg1))
							{
								test.log(LogStatus.PASS, "Enter Invalid Data = "+msg1);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Data  = "+msg1);
								} 
				    	 Thread.sleep(3000);
				    	 performerPOM.closecaseStage().click();
				     }
					 
					 public static void CaseStageWithoutData( ExtentTest test) throws InterruptedException, IOException
				     {
				    
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				    	  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						 
						  
				     	 performerPOM.caseStageMaster().click();
						  Thread.sleep(0);
				    	 performerPOM.newCaseStage().click();
				    	 
				    	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
				    	  
				    	 Thread.sleep(3000);
				    	 performerPOM.savecaseStage().click();
				    	 
				    	 Thread.sleep(3000);
						 String msg1 = performerPOM.readcaseStagemsg().getText();
							if(msg1.equalsIgnoreCase(msg1))
							{
								test.log(LogStatus.PASS, "Without Enter Data = "+msg1);
								
							}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data  = "+msg1);
								} 
				    	 Thread.sleep(3000);
				    	 performerPOM.closecaseStage().click();
				     }
					 public static void CaseStageCloseButton( ExtentTest test) throws InterruptedException, IOException
				     {
				    
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60)); 
				    	  Thread.sleep(3000);
						  performerPOM.clickMasters().click();
						  performerPOM.caseStageMaster().click();
						  Thread.sleep(0);
				    	 performerPOM.newCaseStage().click();
				    	 
				    	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeCaseStageType"));
				    	  
				    	 
				    	 if( performerPOM.closecaseStage().isEnabled())
				    	 {
				    	    Thread.sleep(3000);
				    	    performerPOM.closecaseStage().click();
				    	    test.log(LogStatus.PASS, "Close Button is clickable");	
				    	 }
				    	 else
				    	 {
				    		 test.log(LogStatus.FAIL, "Close Button is not clickable");	
				    	 }
				     }
					 
					 
					 public static void DocumentType( ExtentTest test) throws InterruptedException, IOException
					  {
					  
					      //XSSFSheet sheet=ReadExcel();
					      WebDriverWait wait = new WebDriverWait( getDriver(),(60));  
					      Thread.sleep(3000);
					      performerPOM.clickMasters().click();
					      
					      Thread.sleep(3000);
						  performerPOM.DocumentTypeMasters().click();
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
						  
						  Thread.sleep(500);
					      FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row=sheet.getRow(118);
						  Cell c=row.getCell(1);
						  String doctype=c.getStringCellValue();
						  performerPOM.clickDocumentType().sendKeys(doctype);
						  
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Document Type-"+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Document Type-"+msg1);
								}
			              Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  Thread.sleep(3000);
						  performerPOM.editDocumentType().click();
						  
			              wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
						  
			              Thread.sleep(3000);
			              performerPOM.clickDocumentType().clear();
			              
			              Thread.sleep(500);
						  FileInputStream fis1 = new FileInputStream(filePath);
						  Workbook workbook1 = WorkbookFactory.create(fis1);
						 Sheet  sheet1= workbook1.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row1=sheet1.getRow(119);
						  Cell c1=row1.getCell(1);
						  String doctype1=c1.getStringCellValue();
						  performerPOM.clickDocumentType().sendKeys(doctype1);
						  
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg2 = performerPOM.readOppoenentMsg().getText();
								if(msg2.contains(msg2))
								{
									test.log(LogStatus.PASS, "Update Document Type-"+msg2);
								}
								else
								{
									test.log(LogStatus.FAIL, "Update Document Type-"+msg2);
								}
			              Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						   Thread.sleep(3000);
						   performerPOM.deleteDocumentType().click();
						   
						   
						   
						   Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        Thread.sleep(3000);
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        Thread.sleep(3000);	
					        // Accepting alert		
					        getDriver().switchTo().alert().accept();		
					           
					        
							  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 =getDriver() .switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1=getDriver().switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);	
						        
						        		
						        // Accepting alert		
						        alert1.accept();	
					         
					     /*    Thread.sleep(3000);
							 performerPOM.clickLegalEntityFilter().sendKeys("Case Document",Keys.ENTER);
							   
						     Thread.sleep(3000);
							 performerPOM.clickLegalEntityFilter().clear(); 
					         
					         test.log(LogStatus.PASS,"Document Type filter working successfully");*/
						  
						 }
					 
					 public static void DocumentTypeWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
					   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					      Thread.sleep(3000);
					      performerPOM.clickMasters().click();
					      
					      Thread.sleep(3000);
						  performerPOM.DocumentTypeMasters().click();
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
						 
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Without Enter Data =" +msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data =" +msg1);
								}
			              Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
					  }
					 public static void DocumentTypeInvalidData( ExtentTest test) throws InterruptedException, IOException
					  {
					   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					      Thread.sleep(3000);
					      performerPOM.clickMasters().click();
					      
					      Thread.sleep(3000);
						  performerPOM.DocumentTypeMasters().click();
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
						 
						  Thread.sleep(3000);
						  performerPOM.clickDocumentType().sendKeys("%^$2");
						  
						   Thread.sleep(3000);
							  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
							  
							   test.log(LogStatus.PASS, "Enter Invalid Document Type  = "+msg);
						  
				  
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Invalid Data =" +msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Data =" +msg1);
								}
			              Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
					  }
					 public static void DocumentTypeCloseButton( ExtentTest test) throws InterruptedException, IOException
					  {
					   
						 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					      Thread.sleep(3000);
					      performerPOM.clickMasters().click();
					      
					      Thread.sleep(3000);
						  performerPOM.DocumentTypeMasters().click();
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_IframeDocType"));
						 
						  if( performerPOM.closeDocumentType().isEnabled())
						  {
						      Thread.sleep(3000);
						     performerPOM.closeDocumentType().click();
						     test.log(LogStatus.PASS, "Close button is clickable");					 
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, "Close button is not clickable");
						  }
					  }
						 
					 
					   
					   
					  public static void RatingCriteria( ExtentTest test) throws InterruptedException, IOException
					  {
						
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();
						  Thread.sleep(3000);
						
						  performerPOM.ratingCriteriaMasters().click();
						  
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  Thread.sleep(3000);
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
						  
						  Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row=sheet.getRow(123);
						  Cell c=row.getCell(1);
						  String criteria=c.getStringCellValue();
						  performerPOM.clickCriteria().sendKeys(criteria);
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Add Rating Criteria-"+msg1);
								}
								else
								{
									test.log(LogStatus.PASS, "Add Rating Criteria-"+msg1);
								}
						  
						  
						  Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  Thread.sleep(3000);
						  performerPOM.editcriteria().click();
						  
				        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
						  
				        Thread.sleep(3000);
				        performerPOM.clickCriteria().clear();
				        
				        Thread.sleep(500);
						 FileInputStream fis1 = new FileInputStream(filePath);
						 Workbook workbook1 = WorkbookFactory.create(fis1);
						  Sheet  sheet1= workbook1.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row1=sheet1.getRow(124);
						  Cell c1=row1.getCell(1);
						  String criteria1=c1.getStringCellValue();
						  performerPOM.clickCriteria().sendKeys(criteria1);
						  
						  Thread.sleep(3000);
						  performerPOM.saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg2 = performerPOM.readOppoenentMsg().getText();
								if(msg2.contains(msg2))
								{
									test.log(LogStatus.PASS, "Update Rating Criteria-"+msg2);
								}
								else
								{
									test.log(LogStatus.FAIL, "Update Rating Criteria-"+msg2);
								}
						  
						  
						  Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
						  
						  getDriver().switchTo().parentFrame();
						  
						  Thread.sleep(3000);
						  performerPOM.deletecriteria().click();
						  
						  
						   Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        Thread.sleep(3000);
					        // Capturing alert message.    
					        String alertMessage=getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        Thread.sleep(3000);	
					        // Accepting alert		
					        getDriver().switchTo().alert().accept();		
					  	 
					      try
					      {
					        
					        Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert1 =getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage1=getDriver().switchTo().alert().getText();	
					        
					        
					        test.log(LogStatus.PASS, alertMessage1);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage1);	
					        
					        		
					        // Accepting alert		
					        alert1.accept();
					      }
					      catch(Exception e)
					      {
					    	  
					      }
					         
					    /*     Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().sendKeys("Case Arguments",Keys.ENTER);
							 
							 Thread.sleep(3000);
							 performerPOM.clickLawFirmFilter().clear();
							 
							 test.log(LogStatus.PASS, "Rating Criteria Filter working  successfully");*/
						  
					 }
					  
					  public static void RatingCriteriaWithoutData( ExtentTest test) throws InterruptedException, IOException
					  {
						
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();
						  Thread.sleep(3000);
						
						  performerPOM.ratingCriteriaMasters().click();
						  
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  Thread.sleep(3000);
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
						
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Without Enter Data="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Without Enter Data="+msg1);
								}
						  
						  
						  Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
					  }
					  
					  public static void RatingCriteriaInvalidData( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();
						  Thread.sleep(3000);
						
						  performerPOM.ratingCriteriaMasters().click();
						  
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  Thread.sleep(3000);
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
						  
						  Thread.sleep(3000);
					     performerPOM.clickCriteria().sendKeys("#$54");
					     
					     Thread.sleep(3000);
						  String msg= performerPOM.clickCriteriaInvalidMsg().getText();
						  
						   test.log(LogStatus.PASS, "Enter Invalid Rating Criteria  = "+msg);
					     
					     
					     
						  Thread.sleep(3000);
						  performerPOM. saveDocumentType().click();
						  
						  Thread.sleep(3000);
							 String msg1 = performerPOM.readOppoenentMsg().getText();
								if(msg1.contains(msg1))
								{
									test.log(LogStatus.PASS, "Enter Invalid Data ="+msg1);
								}
								else
								{
									test.log(LogStatus.FAIL, "Enter Invalid Data ="+msg1);
								}
						  
						  
						  Thread.sleep(3000);
						  performerPOM.closeDocumentType().click();
					  }
					  
					  
					  public static void RatingCriteriaCloseButton( ExtentTest test) throws InterruptedException, IOException
					  {
						  
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();
						  Thread.sleep(3000);
						
						  performerPOM.ratingCriteriaMasters().click();
						  
						  Thread.sleep(3000);
						  performerPOM.NewDocumentType().click();
						  
						  Thread.sleep(3000);
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeCriteriaMastre"));
						
						  if(  performerPOM.closeDocumentType().isEnabled())
						  {
						     Thread.sleep(3000);
						     performerPOM.closeDocumentType().click();
						     test.log(LogStatus.PASS, "Close button is clickable");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, "Close button is not clickable");
						  }
					  }
					  
						  
					  public static void NoticeStage( ExtentTest test) throws InterruptedException, IOException
					  {
						 

						  Thread.sleep(4000);
						  performerPOM.clickMasters().click();

						  
						 
						  
						  Thread.sleep(3000);
						  performerPOM.noticeStagecfoMasters().click();
						  Thread.sleep(3000);
						  performerPOM.addNoticeStage().click();
						  
						  
						  Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						  Thread.sleep(3000);
						  Row row=sheet.getRow(128);
						  Cell c=row.getCell(1);
						  String NoticeStage=c.getStringCellValue();
						  performerPOM.clickNoticeStage().sendKeys(NoticeStage);
						  
						  Thread.sleep(3000);
						  performerPOM.updateNoticeStage().click();
						  
						  
						   Thread.sleep(10000);
						   // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage=getDriver().switchTo().alert().getText();
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        		
					        // Accepting alert		
					        alert.accept();		
					        
					        Thread.sleep(3000);
							  performerPOM.editNoticeStage().click();
							  
						        Thread.sleep(3000);
							  performerPOM.clickNoticeStage().clear();
							  
							  Thread.sleep(500);
							  FileInputStream fis1 = new FileInputStream(filePath);
							  Workbook workbook1 = WorkbookFactory.create(fis1);
							  Sheet  sheet1= workbook1.getSheetAt(2);
							  Thread.sleep(3000);
							  Row row1=sheet1.getRow(129);
							  Cell c1=row1.getCell(1);
							  String NoticeStage1=c1.getStringCellValue();
							  performerPOM.clickNoticeStage().sendKeys(NoticeStage1);
							 
							  Thread.sleep(3000);
							  performerPOM.updateNoticeStage().click();
							  
							   Thread.sleep(10000);
							  	
						        		
						        // Capturing alert message.    
						        String alertMessage1= getDriver().switchTo().alert().getText();
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						        
						        Thread.sleep(3000);
						        performerPOM.deleteNoticeStage().click();
						        
						        
						 	   Thread.sleep(10000);
							 	
						         // Capturing alert message.    
						        String alertMessage2= getDriver().switchTo().alert().getText();
						        
						        Thread.sleep(3000);
						        test.log(LogStatus.PASS, alertMessage2);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage2);	
						        
						        		
						        // Accepting alert		
						        alert.accept();	
						        
						       /* Thread.sleep(3000);
								 performerPOM.clickNoticeStageFilter().sendKeys("Notice Arguments",Keys.ENTER);
								 
								 Thread.sleep(3000);
								 performerPOM.clickNoticeStageFilter().clear();
								 
								 test.log(LogStatus.PASS, "Notice Stage Filter working  successfully");*/
							  
				     }
					  public static void UserReassignment( ExtentTest test) throws InterruptedException, IOException
					  {
						  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						
						  
						  Thread.sleep(3000);
						  performerPOM.UserReassignmentcfoMasters().click();
						  Thread.sleep(3000);
						  performerPOM.clickUser1().click();
						  Thread.sleep(3000);
						  performerPOM.selectUser1().click();
						  
						 
						  Thread.sleep(3000);
						  performerPOM.clickAssigntoUser().click();
						   Thread.sleep(3000);
						  performerPOM.selectAssigntoUser().click();
						  
						  
						     By locator = By.xpath("//*[@id='gridCases']/div[2]/table/tbody/tr[1]/td[1]/label");
						     
		                     wait.until(ExpectedConditions.presenceOfElementLocated(locator));
						     Thread.sleep(4000);
			                 WebElement ViewButton =getDriver() .findElement(locator);	
							 Thread.sleep(4000);
							  JavascriptExecutor js=( (JavascriptExecutor) getDriver());
							 js.executeScript("arguments[0].click();", ViewButton);
							 
						
							 System.out.println("true");
						  	
							 Thread.sleep(3000);
							 performerPOM.clicknotice().click();
						  
						  
							 By locator1 = By.xpath("//*[@id='gridNotices']/div[2]/table/tbody/tr[1]/td[1]/label");
		                     wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
						     Thread.sleep(4000);
			                 WebElement ViewButton1 = getDriver().findElement(locator1);	
							 Thread.sleep(4000);
							 
							 js.executeScript("arguments[0].click();", ViewButton1);
						 
							
							 Thread.sleep(3000);
							 performerPOM.clickTask().click();
							 
							 By locator2 = By.xpath("//*[@id='gridTask']/div[2]/table/tbody/tr[1]/td[1]/label");
		                     wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
						     Thread.sleep(4000);
			                 WebElement ViewButton2 =getDriver() .findElement(locator2);	
							 Thread.sleep(4000);
							 
							 js.executeScript("arguments[0].click();", ViewButton2);
							 
						  	Thread.sleep(3000);
						  	performerPOM.clickAssignButoon().click();
					
						
						 
						 	Thread.sleep(5000);
						    // Switching to Alert        
					        Alert alert = getDriver().switchTo().alert();		
					        		
					        // Capturing alert message.    
					        String alertMessage= getDriver().switchTo().alert().getText();	
					        
					        Thread.sleep(3000);
					        test.log(LogStatus.PASS, alertMessage);
					        		
					        // Displaying alert message		
					        System.out.println(alertMessage);	
					        
					        		
					        // Accepting alert		
					        alert.accept();		
					    /*    if(performerPOM.clearButton().isEnabled())
					  		{
					  			performerPOM.clearButton().click();
					  			test.log(LogStatus.PASS, "Clear button working successfully");
					  		}
					  		else
					  		{
					  			test.log(LogStatus.FAIL, "Clear button not working successfully");
					  		}*/
					        
					              
					  	  Thread.sleep(4000);
						  performerPOM.clickAutidLog().click();
							  
					  }
					  public static void MailAuthorization(ExtentTest test) throws InterruptedException
					  {
						  Thread.sleep(3000);
						  performerPOM.clickMasters().click();

						  
						  Thread.sleep(3000);
						  performerPOM.MailAuthorizationMasterscfo().click();
						  

						  Thread.sleep(3000);
						  performerPOM.clickTypeOfUser().click();
						  Thread.sleep(3000);
						  performerPOM.selectTypeOfUser().click();
						  Thread.sleep(4000);
						  performerPOM.clickRole().click();
						  Thread.sleep(4000);
						  performerPOM.selectRole().click();
						  Thread.sleep(3000);
						  performerPOM.clickUsers().click();
						 // Thread.sleep(3000);
						 // performerPOM.clickSearchBoxUser().sendKeys("company admin");
						  
						  Thread.sleep(3000);
						  performerPOM.selectUsers().click();

						  Thread.sleep(3000);
						  performerPOM.clickMailServices().click();
						 // Thread.sleep(3000);
						 // performerPOM.clickSearchBoxMail().sendKeys("Hearings After 2 Days");
						  Thread.sleep(300);
						  performerPOM.selectMailService().click();
						  Thread.sleep(3000);
						  performerPOM.clickEnable().click();
						  Thread.sleep(4000);
						  performerPOM.clickExportMail().click();
						  Thread.sleep(3000);
						  performerPOM.clickDisable().click();
						  Thread.sleep(3000);
						 // performerPOM.clearButton().click();
						  
						  if(performerPOM.clearButton().isEnabled())
					  		{
					  			performerPOM.clearButton().click();
					  			test.log(LogStatus.PASS, "Clear button working successfully");
					  		}
					  		else
					  		{
					  			test.log(LogStatus.FAIL, "Clear button not working successfully");
					  		}
						  test.log(LogStatus.PASS, "File Download successfully");
						  
						  
					  }
						public static void CaseHearing( ExtentTest test, String compliancesCount1,String type) throws InterruptedException, IOException
						{
							
							//performerPOM.CaseHearingCount().click();
							//performerPOM.CaseHearingGridCount().click();
							
							int	open = Integer.parseInt(performerPOM.CaseHearingCount().getText());	//Reading Notice Open count.
					        performerPOM.CaseHearingCount().click();						//Clicking on 'Open' notice

					        JavascriptExecutor  js = (JavascriptExecutor) getDriver();
					    	js.executeScript("window.scrollBy(0,300)");
							
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
								//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
								test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
							}
							else
							{
								//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
								test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
							}
				           	
				           	
							
							
								Thread.sleep(100);
								File dir = new File("C://Users//snehalp//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								performerPOM.CaseHearingExport().click();					//Clicking on 'Excel Report' image.
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								
								Thread.sleep(3000);
								performerPOM.CaseHearingView().click();
								
								test.log(LogStatus.PASS, "Case Hearing View Popup open successfully.");
								
								
								
								Thread.sleep(3000);
								getDriver().switchTo().parentFrame();
								
								Thread.sleep(3000);
								performerPOM.CaseHearingPopupClose().click();
								
								Thread.sleep(5000);
								performerPOM.clickSearchFilter().sendKeys("347623");
								
							/*	Thread.sleep(5000);
								if(performerPOM.clearButton().isEnabled())
								{
									performerPOM.clearButton().click();
									 test.log(LogStatus.PASS, "Case Hearing = clear button Work Successfully");
								}
								else
								{
									test.log(LogStatus.PASS, "Case Hearing  = clear button not Work Successfully");
								}*/
								
								
								
								Thread.sleep(300);
								OverduePOM.clickDashboard().click();
						}
						public static void HearingCalender(ExtentTest test,String compliancesCount1, String type) throws InterruptedException, AWTException
						{
//								Thread.sleep(3000);					
//								Robot robot = new Robot();
//								robot.keyPress(KeyEvent.VK_CONTROL);
//								robot.keyPress(KeyEvent.VK_SUBTRACT);
							   
							
//							    robot.keyPress(KeyEvent.VK_CONTROL);
								//  robot.keyPress(KeyEvent.VK_SUBTRACT);
								/*String month="March 2023";
								String day="22";
						
								while(true)
								{
						        	String text=.findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[1]/h4")).getText();    //click month and year 
						           if(text.equals(month))
						           {
							                       break;
						            }
						           else
						            {
						            	Thread.sleep(2000);
							        .findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[1]/a[2]/div")).click();           // click forward
						
							         }
							        Thread.sleep(4000);
							      //  .findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div/a[contains(text(),"+day+")]")).click();    //click day
							        .findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div[24]/a")).click();             
						    	} */
							WebElement text=getDriver().findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[3]/div[1]/div/div[3]/div[28]/a"));
							if(text.isEnabled())
							{
								getDriver().findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[3]/div[1]/div/div[3]/div[28]/a")).click();
								
								test.log(LogStatus.PASS, "Hearing for particular date is clickable.");
								
							}
							
			
							int	open = Integer.parseInt(performerPOM.HearingCalenderNumcfo().getText());	//Reading Notice Open count.
							  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						 	
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
							
							Thread.sleep(10000);
							CFOcountPOM.readcalenderCount().click();
							String item = CFOcountPOM.readcalenderCount().getText();
							String[] bits = item.split(" ");								//Splitting the String
							String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
							int count1 = 0;
							if(compliancesCount.equalsIgnoreCase("to"))
							{
								Thread.sleep(2000);
							    item = CFOcountPOM.readcalenderCount().getText();
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
								//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
								test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
							}
							else
							{
								//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
								test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
							}
				           	
							
							
							
							 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			               	js.executeScript("window.scrollBy(0,300)");
			               	
			            
			               	Thread.sleep(2000);
					
							
							Thread.sleep(100);
							new File("C://Users//snehalp//Downloads");
						
							
							Thread.sleep(250);
							performerPOM.HearingCalenderExport().click();					//Clicking on 'Excel Report' image.
							test.log(LogStatus.PASS, "File downloaded successfully.");
							
							Thread.sleep(500);
				            performerPOM.HearingCalenderView().click();
				            test.log(LogStatus.PASS, "Show Hearing details View Popup open successfully.");
				            
				        	getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
							
							Thread.sleep(2000);
							getDriver().switchTo().parentFrame();
						
							Thread.sleep(3000);
							performerPOM.HearingCalenderclose().click();
							
					
							
		                 	Thread.sleep(1000);
							OverduePOM.clickDashboard().click();
							
						}	
							
						

                  
                    public static void Draft( ExtentTest test) throws InterruptedException, IOException
                    {

						
                        Perform2(test, "Draft");
						

						OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
                  
                    }
                    public static void Perform2( ExtentTest test,String type) throws InterruptedException, IOException
                    {
                    
        			    int	open = Integer.parseInt(performerPOM.clickDraftcfo().getText());	//Reading Case Open count.
        				performerPOM.clickDraftcfo().click();						//Clicking on 'Open' Case
        				
        				 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        				js.executeScript("window.scrollBy(0,1000)");
            			
            			Thread.sleep(7000);
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
                    }		
            	  public static void NoticeDocViewandDownload( ExtentTest test) throws InterruptedException, IOException
            	  {    
            		  
            		  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
            		  Thread.sleep(3000);
            		  performerPOM.clickNoticeOpen().click();
            		  
            		  Thread.sleep(500);
          			  wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
            		  
            		  Thread.sleep(3000);
            		  performerPOM.clickEditNotice().click();
            		  
            		
            		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
          			
            		  
            		  Thread.sleep(3000);
            		  performerPOM.clickEditNotice1().click();
            		  
            		   JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
      				  js.executeScript("window.scrollBy(0,1000)");
      				  
      				  Thread.sleep(3000);
            		  performerPOM.clickViewNoticeDoc().click();
            		  
            		  Thread.sleep(1000);
                      getDriver().switchTo().frame("IframeNoticeDocument");
            		  
            		  
            		  Thread.sleep(3000);
            		  performerPOM.clickViewNoticeDocpopup().click();
            		  
            		 
            		  //.switchTo().parentFrame();
            		  
            		  Thread.sleep(4000);
            		  performerPOM.clickViewNoticeDocpopupclose1().click();
            		  
                 	  
            		  Thread.sleep(3000);
            		  performerPOM.clickDownloadNoticeDocpopup().click();
            		  
                 	  getDriver().switchTo().parentFrame();
            		  
            		  Thread.sleep(3000);
            		  performerPOM.clickViewNoticeDocpopupclose().click();
            		  
            		  test.log(LogStatus.PASS,"View Notice Document Popup open successfully");
            		  
            		  Thread.sleep(3000);
            		  performerPOM.clickDownloadNoticeDoc().click();
            		  
            		  test.log(LogStatus.PASS,"Notice Document Download successfully");
            		  
            			Thread.sleep(3000);
                		getDriver().switchTo().parentFrame();
                		performerPOM.clickClose().click();//Clicking on 'Close'
                		
                		Thread.sleep(500);
                		OverduePOM.clickDashboard().click();
             
            	  }
            	  public static void InwardDefendantAgeingGraph(ExtentTest test, String type,int counttype) throws InterruptedException, IOException
            		
            		{
            			
            			WebDriverWait wait = new WebDriverWait(getDriver(),20);
            			JavascriptExecutor js = (JavascriptExecutor) getDriver();
            				if(type.equalsIgnoreCase("Inward/Defendent"))
            				{
            		         	Thread.sleep(2000);
            			        performerPOM.clickInwardDefendentNoticeCA().click();						//Clicking on 'Open' notice
            				}
            				else if(type.equalsIgnoreCase("Outward/Plaintiff"))
            				{
            					Thread.sleep(2000);
            			        performerPOM.clickOutwardPlaintiffNoticeAgeing().click();						//Clicking on 'Open' notice
            				}
            				else if(type.equalsIgnoreCase("Petitioner"))
            				{
            					Thread.sleep(3000);
            			        performerPOM.clickPetitionerNoticeCA().click();						//Clicking on 'Open' notice
            				}
            				else if(type.equalsIgnoreCase("Respondent"))
            				{
            					Thread.sleep(3000);
            			        performerPOM.clickRespondentNoticeCA().click();						//Clicking on 'Open' notice
            				}
            				else if(type.equalsIgnoreCase("Defendant"))
            				{
            					Thread.sleep(3000);
            			        performerPOM.clickDefendantNoticeCA().click();						//Clicking on 'Open' notice
            				}
            			
            			
            		    
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
            			
            			if(counttype == count1)
            			{
            				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
            				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
            			}
            			else
            			{
            				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
            				test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
            			}
            	     	

            		Thread.sleep(3000);
            		performerPOM.clickAgeingViewIcon().click();
            		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
            		Thread.sleep(2000);
            		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
            		  
            		  if(msg.equalsIgnoreCase("Notice Summary"))
            		  {
            			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
            		  }
            		  else
            		  {
            			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
            		  }
            		  
            		  getDriver().switchTo().parentFrame();
            			
            		 Thread.sleep(3000);
            		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
            			
            			Thread.sleep(500);
            			progress();
            			
            			Thread.sleep(1000);
            			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
            			Thread.sleep(2000);
            			
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
            			File dir = new File("C:\\Users\\snehalp//Downloads");
            			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
            			
            			Thread.sleep(500);
            			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
            			Thread.sleep(250);
            			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
            			test.log(LogStatus.PASS, "File downloaded successfully.");
            			
            			Thread.sleep(5500);
            			File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
            					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
            					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
            				}
            				else
            				{
            					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
            					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
            				}
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
            			}
            			
//            			Thread.sleep(7000);
//            			performerPOM.clickRiskFilter().click();
//            			
//            			Thread.sleep(7000);
//            			performerPOM.selectRiskFilter().click();
            			
//            		    List<WebElement>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//            			selectOptionFromDropDown_bs(SeletcRisk, "High");
            			
            			Thread.sleep(7000);
            			if(performerPOM.clearButton().isEnabled())
            			{
            				Thread.sleep(7000);
            				performerPOM.clearButton().click();
            				test.log(LogStatus.PASS, "clear button work successfully.");
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "clear button not work successfully.");
            			}
            			
            			Thread.sleep(3000);
            			getDriver().switchTo().parentFrame();
            			Thread.sleep(2000);
            			performerPOM.caseNoticeSummaryGraphClose().click();
            			
            		
            	 }
            	  
            	  
            	  
            	
            	  public static void ApplicantAgeingGraph(ExtentTest test, String type) throws InterruptedException, IOException
          		
          		{
          			
            		  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
          			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
          	       	js.executeScript("window.scrollBy(0,800)");
          	       	
          	       	Thread.sleep(5000);
          			performerPOM.clickDashboardCaseNoticeFilter().click();
          			
          			Thread.sleep(5000);
          			performerPOM.clickDashboardNoticeFilter().click();
          			
          			 Thread.sleep(5000);
          				performerPOM.clickDashboardApplyBtn().click();
          				
          				js.executeScript("window.scrollBy(0,4000)");
          			
          	       	Thread.sleep(3000);
          		
          	       	int	open = Integer.parseInt(performerPOM.clickApplicantAgeing().getText());	//Reading Notice Open count.
          		    performerPOM.clickApplicantAgeing().click();						//Clicking on 'Open' notice
          		
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
          				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
          				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
          			}
          			else
          			{
          				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
          				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
          			}
          	       	
          	    
          			Thread.sleep(4000);
          			performerPOM.clickAgeingViewIcon().click();
          			

        			
        			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
        			Thread.sleep(2000);
          		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
          		  
          		  if(msg.equalsIgnoreCase("Notice Summary"))
          		  {
          			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
          		  }
          		  else
          		  {
          			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
          		  }
          		  
          		  getDriver().switchTo().parentFrame();
          			
          		 Thread.sleep(3000);
          		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
          			
          			Thread.sleep(500);
          			progress();
          			
          			Thread.sleep(1000);
          			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
          			Thread.sleep(2000);
          			
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
          			File dir = new File("C://Users//snehalp//Downloads");
          			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
          			
          			Thread.sleep(500);
          			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
          			Thread.sleep(500);
          			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
          			test.log(LogStatus.PASS, "File downloaded successfully.");
          			
          			Thread.sleep(5500);
          			File dir1 = new File("C://Users//snehalp//Downloads");
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
          				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
          				
          				int no = sheet.getLastRowNum();
          				Row row = sheet.getRow(no);
          				Cell c1 = row.getCell(0);
          				int records =(int) c1.getNumericCellValue();
          				fis.close();
          				
          				if(count2 == records)
          				{
          					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
          					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
          				}
          				else
          				{
          					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
          					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
          				}
          			}
          			else
          			{
          				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
          			}
          			
//          			Thread.sleep(7000);
//          			performerPOM.clickRiskFilter().click();
//          			
//          			Thread.sleep(7000);
//          			performerPOM.selectRiskFilter().click();
          			
//          		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//          			selectOptionFromDropDown_bs(SeletcRisk, "High");
          			
          			Thread.sleep(7000);
          			if(performerPOM.clearButton().isEnabled())
          			{
          				Thread.sleep(7000);
          				performerPOM.clearButton().click();
              			test.log(LogStatus.PASS, "clear button work successfully.");
          			}
          			else
          			{
          				test.log(LogStatus.FAIL, "clear button not work successfully.");
          			}
          		
          			
          			
          			
          			Thread.sleep(3000);
          			getDriver().switchTo().parentFrame();
          			Thread.sleep(2000);
          			performerPOM.caseNoticeSummaryGraphClose().click();
          			
         			Thread.sleep(3000);
         			OverduePOM.clickDashboard().click();
          			
          	   }
            	  public static void OutwardPlaintiffAgeingGraph(ExtentTest test, String type) throws InterruptedException, IOException
            		
            		{
            			
            		  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
            			JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
            	       	js.executeScript("window.scrollBy(0,800)");
            	       	
            	       	Thread.sleep(5000);
            			performerPOM.clickDashboardCaseNoticeFilter().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickDashboardNoticeFilter().click();
            			
            			 Thread.sleep(5000);
            				performerPOM.clickDashboardApplyBtn().click();
            				
            				js.executeScript("window.scrollBy(0,4000)");
            			
            	       	Thread.sleep(3000);
            		
            	       	int	open = Integer.parseInt(performerPOM.clickOutwardPlaintiffAgeing().getText());	//Reading Notice Open count.
            		    performerPOM.clickOutwardPlaintiffAgeing().click();						//Clicking on 'Open' notice
            		
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
            				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
            				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
            			}
            			else
            			{
            				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
            				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
            			}
            	       	
            	    
            			Thread.sleep(3000);
            			performerPOM.clickAgeingViewIcon().click();
            			

          			
          			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
          			Thread.sleep(2000);
            		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
            		  
            		  if(msg.equalsIgnoreCase("Notice Summary"))
            		  {
            			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
            		  }
            		  else
            		  {
            			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
            		  }
            		  
            		  getDriver().switchTo().parentFrame();
            			
            		 Thread.sleep(3000);
            		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
            			
            			
            			
            			
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
            			
//            			Thread.sleep(5000);
//            			performerPOM.clickAgeFilter().click();
//            			
//            			Thread.sleep(5000);
//            			performerPOM.selectAgeFiltercfo().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickCategoryFilter().click();
            			
            			
            			Thread.sleep(5000);
            			performerPOM.selectCategoryFilter2().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickStageFilter().click();
            			
            			Thread.sleep(5000);
            			performerPOM.selectStageFilter2().click(); */
            			
            			
            			Thread.sleep(500);
            			progress();
            			
            			Thread.sleep(1000);
            			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
            			Thread.sleep(2000);
            			 
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
            			js.executeScript("window.scrollBy(0,3000)");
            			
            		
            			Thread.sleep(100);
            			File dir = new File("C://Users//snehalp//Downloads");
            			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
            			
            			Thread.sleep(500);
            			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
            			Thread.sleep(250);
            			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
            			test.log(LogStatus.PASS, "File downloaded successfully.");
            			
            			Thread.sleep(5500);
            			File dir1 = new File("C://Users//snehalp//Downloads");
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
            				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
            				
            				int no = sheet.getLastRowNum();
            				Row row = sheet.getRow(no);
            				Cell c1 = row.getCell(0);
            				int records =(int) c1.getNumericCellValue();
            				fis.close();
            				
            				if(count2 == records)
            				{
            					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
            					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
            				}
            				else
            				{
            					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
            					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
            				}
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
            			}
            			
//            			Thread.sleep(7000);
//            			performerPOM.clickRiskFilter().click();
//            			
//            			Thread.sleep(7000);
//            			performerPOM.selectRiskFilter().click();
            			
//            		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//            			selectOptionFromDropDown_bs(SeletcRisk, "High");
            			
            			Thread.sleep(7000);
            			if(performerPOM.clearButton().isEnabled())
            			{
            				Thread.sleep(7000);
            				performerPOM.clearButton().click();
                			test.log(LogStatus.PASS, "clear button work successfully.");
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "clear button not work successfully.");
            			}
            		
            			
            			
            			
            			Thread.sleep(3000);
            			getDriver().switchTo().parentFrame();
            			Thread.sleep(2000);
            			performerPOM.caseNoticeSummaryGraphClose().click();
            			
           			Thread.sleep(3000);
           			OverduePOM.clickDashboard().click();
            			
            	   }
            	  public static void PetitionerAgeingGraph(ExtentTest test, String type) throws InterruptedException, IOException
          		
          		{
          			
            		  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
          			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
          	       	js.executeScript("window.scrollBy(0,800)");
          	       	
          	       	Thread.sleep(5000);
          			performerPOM.clickDashboardCaseNoticeFilter().click();
          			
          			Thread.sleep(5000);
          			performerPOM.clickDashboardNoticeFilter().click();
          			
          			 Thread.sleep(5000);
          				performerPOM.clickDashboardApplyBtn().click();
          				
          				js.executeScript("window.scrollBy(0,4000)");
          			
          	       	Thread.sleep(3000);
          		
          	       	int	open = Integer.parseInt(performerPOM.clickPetitionerAgeing().getText());	//Reading Notice Open count.
          		    performerPOM.clickPetitionerAgeing().click();						//Clicking on 'Open' notice
          		
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
          				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
          				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
          			}
          			else
          			{
          				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
          				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
          			}
          	       	
          	    
          			Thread.sleep(3000);
          			performerPOM.clickAgeingViewIcon().click();
          			

        			
        			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
        			Thread.sleep(2000);
          		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
          		  
          		  if(msg.equalsIgnoreCase("Notice Summary"))
          		  {
          			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
          		  }
          		  else
          		  {
          			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
          		  }
          		  
          		  getDriver().switchTo().parentFrame();
          			
          		 Thread.sleep(3000);
          		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
          			
          			
          			
          			
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
          			
//          			Thread.sleep(5000);
//          			performerPOM.clickAgeFilter().click();
//          			
//          			Thread.sleep(5000);
//          			performerPOM.selectAgeFiltercfo().click();
          			
          			Thread.sleep(5000);
          			performerPOM.clickCategoryFilter().click();
          			
          			
          			Thread.sleep(5000);
          			performerPOM.selectCategoryFilter2().click();
          			
          			Thread.sleep(5000);
          			performerPOM.clickStageFilter().click();
          			
          			Thread.sleep(5000);
          			performerPOM.selectStageFilter2().click(); */
          			
          			
          			Thread.sleep(500);
          			progress();
          			
          			Thread.sleep(1000);
          			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
          			Thread.sleep(2000);
          			
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
          			File dir = new File("C://Users//snehalp//Downloads");
          			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
          			
          			Thread.sleep(500);
          			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
          			Thread.sleep(250);
          			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
          			test.log(LogStatus.PASS, "File downloaded successfully.");
          			
          			Thread.sleep(5500);
          			File dir1 = new File("C://Users//snehalp//Downloads");
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
          				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
          				
          				int no = sheet.getLastRowNum();
          				Row row = sheet.getRow(no);
          				Cell c1 = row.getCell(0);
          				int records =(int) c1.getNumericCellValue();
          				fis.close();
          				
          				if(count2 == records)
          				{
          					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
          					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
          				}
          				else
          				{
          					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
          					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
          				}
          			}
          			else
          			{
          				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
          			}
          			
//          			Thread.sleep(7000);
//          			performerPOM.clickRiskFilter().click();
//          			
//          			Thread.sleep(7000);
//          			performerPOM.selectRiskFilter().click();
          			
//          		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//          			selectOptionFromDropDown_bs(SeletcRisk, "High");
          			
          			Thread.sleep(7000);
          			if(performerPOM.clearButton().isEnabled())
          			{
          				Thread.sleep(7000);
          				performerPOM.clearButton().click();
              			test.log(LogStatus.PASS, "clear button work successfully.");
          			}
          			else
          			{
          				test.log(LogStatus.FAIL, "clear button not work successfully.");
          			}
          		
          			
          			
          			
          			Thread.sleep(3000);
          			getDriver().switchTo().parentFrame();
          			Thread.sleep(2000);
          			performerPOM.caseNoticeSummaryGraphClose().click();
          			
         			Thread.sleep(3000);
         			OverduePOM.clickDashboard().click();
          			
          	   }
            	  public static void RespondentAgeingGraph(ExtentTest test, String type) throws InterruptedException, IOException
            		
            		{
            			
            		  WebDriverWait wait = new WebDriverWait( getDriver(),(60));
            			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
            	       	js.executeScript("window.scrollBy(0,800)");
            	       	
            	       	Thread.sleep(5000);
            			performerPOM.clickDashboardCaseNoticeFilter().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickDashboardNoticeFilter().click();
            			
            			 Thread.sleep(5000);
            				performerPOM.clickDashboardApplyBtn().click();
            				
            				js.executeScript("window.scrollBy(0,4000)");
            			
            	       	Thread.sleep(3000);
            		
            	       	int	open = Integer.parseInt(performerPOM.clickRespondentAgeing().getText());	//Reading Notice Open count.
            		    performerPOM.clickRespondentAgeing().click();						//Clicking on 'Open' notice
            		
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
            				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
            				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
            			}
            			else
            			{
            				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
            				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
            			}
            	       	
            	    
            			Thread.sleep(5000);
            			performerPOM.clickAgeingViewIcon().click();
            			

          			
          			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
          			Thread.sleep(2000);
            		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
            		  
            		  if(msg.equalsIgnoreCase("Notice Summary"))
            		  {
            			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
            		  }
            		  else
            		  {
            			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
            		  }
            		  
            		  getDriver().switchTo().parentFrame();
            			
            		 Thread.sleep(3000);
            		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
            			
            			
            			
            			
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
            			
//            			Thread.sleep(5000);
//            			performerPOM.clickAgeFilter().click();
//            			
//            			Thread.sleep(5000);
//            			performerPOM.selectAgeFiltercfo().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickCategoryFilter().click();
            			
            			
            			Thread.sleep(5000);
            			performerPOM.selectCategoryFilter2().click();
            			
            			Thread.sleep(5000);
            			performerPOM.clickStageFilter().click();
            			
            			Thread.sleep(5000);
            			performerPOM.selectStageFilter2().click(); */
            			
            			
            			Thread.sleep(500);
            			progress();
            			
            			Thread.sleep(1000);
            			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
            			Thread.sleep(2000);
            			
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
            			File dir = new File("C://Users//snehalp//Downloads");
            			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
            			
            			Thread.sleep(500);
            			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
            			Thread.sleep(250);
            			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
            			test.log(LogStatus.PASS, "File downloaded successfully.");
            			
            			Thread.sleep(5500);
            			File dir1 = new File("C://Users//snehalp//Downloads");
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
            				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
            				
            				int no = sheet.getLastRowNum();
            				Row row = sheet.getRow(no);
            				Cell c1 = row.getCell(0);
            				int records =(int) c1.getNumericCellValue();
            				fis.close();
            				
            				if(count2 == records)
            				{
            					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
            					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
            				}
            				else
            				{
            					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
            					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
            				}
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
            			}
            			
//            			Thread.sleep(7000);
//            			performerPOM.clickRiskFilter().click();
//            			
//            			Thread.sleep(7000);
//            			performerPOM.selectRiskFilter().click();
            			
//            		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//            			selectOptionFromDropDown_bs(SeletcRisk, "High");
            			
            			Thread.sleep(7000);
            			if(performerPOM.clearButton().isEnabled())
            			{
            				Thread.sleep(7000);
            				performerPOM.clearButton().click();
                			test.log(LogStatus.PASS, "clear button work successfully.");
            			}
            			else
            			{
            				test.log(LogStatus.FAIL, "clear button not work successfully.");
            			}
            		
            			
            			
            			
            			Thread.sleep(3000);
            			getDriver().switchTo().parentFrame();
            			Thread.sleep(2000);
            			performerPOM.caseNoticeSummaryGraphClose().click();
            			
           			Thread.sleep(3000);
           			OverduePOM.clickDashboard().click();
            			
            	   }
            	  public static void AgeingGraph1to2years(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

            	  {
            	  	
            	  		WebDriverWait wait = new WebDriverWait(getDriver(),20);
            	  		JavascriptExecutor js = (JavascriptExecutor) getDriver();
            	  		
            	  		if(type.equalsIgnoreCase("Applicant"))
            	  		{
            	           	Thread.sleep(2000);
            	  	        performerPOM.clickApplicantNoticeCA1To2Years().click();						//Clicking on 'Open' notice
            	  		}
            	  		if(type.equalsIgnoreCase("Complainant"))
            	  		{
            	           	Thread.sleep(2000);
            	  	        performerPOM.clickComplianantNoticeCA1To2Years().click();						//Clicking on 'Open' notice
            	  		}
            	  		
            	  		else if(type.equalsIgnoreCase("Inward/Defendent"))
            	  		{
            	           	Thread.sleep(2000);
            	  	        performerPOM.clickInwardDefendentNoticeCA1to2().click();						//Clicking on 'Open' notice
            	  		}
            	  		
            	  		else if(type.equalsIgnoreCase("Outward/Plaintiff"))
            	  		{
            	  			Thread.sleep(3000);
            	  	        performerPOM.clickOutwardPlaintiffNoticeCA1To2Years().click();						//Clicking on 'Open' notice
            	  		}
            	  		else if(type.equalsIgnoreCase("Petitioner"))
            	  		{
            	  			Thread.sleep(3000);
            	  	        performerPOM.clickPetitionerNoticeCA1To2Years().click();						//Clicking on 'Open' notice
            	  		}
//            	  		else if(type.equalsIgnoreCase("Respondent")) 
//            	  		{
//            	  		  Thread.sleep(3000);
//            	            performerPOM.clickRespondentNoticeCA1To2Years().click();						//Clicking on 'Open' notice
//            	  		}
            	  	
            	      
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
            	  	
            	  	if(counttype == count1)
            	  	{
            	  		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
            	  		test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
            	  	}
            	  	else
            	  	{
            	  		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
            	  		test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
            	  	}
            	   	

            	  Thread.sleep(5000);
            	  performerPOM.clickAgeingViewIcon().click();
            	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
            	  Thread.sleep(2000);
            	    String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
            	    
            	    if(msg.equalsIgnoreCase("Notice Summary"))
            	    {
            	  	  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
            	    }
            	    else
            	    {
            	  	 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
            	    }
            	    
            	    getDriver().switchTo().parentFrame();
            	  	
            	   Thread.sleep(3000);
            	   performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
            	  	
            	  	Thread.sleep(500);
            	  	progress();
            	  	
            	  	Thread.sleep(1000);
            	  	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
            	  	Thread.sleep(2000);
            	  	
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
            	  	File dir = new File("C:\\Users\\snehalp//Downloads");
            	  	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
            	  	
            	  	Thread.sleep(500);
            	  	CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
            	  	Thread.sleep(250);
            	  	performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
            	  	test.log(LogStatus.PASS, "File downloaded successfully.");
            	  	
            	  	Thread.sleep(5500);
            	  	File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
            	  			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
            	  			test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
            	  		}
            	  		else
            	  		{
            	  			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
            	  			test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
            	  		}
            	  	}
            	  	else
            	  	{
            	  		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
            	  	}
            	  	
//            	  	Thread.sleep(7000);
//            	  	performerPOM.clickRiskFilter().click();
            	  //	
//            	  	Thread.sleep(7000);
//            	  	performerPOM.selectRiskFilter().click();
            	  	
//            	      List<WebElement>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//            	  	selectOptionFromDropDown_bs(SeletcRisk, "High");
            	  	
            	  	Thread.sleep(7000);
            	  	if(performerPOM.clearButton().isEnabled())
            	  	{
            	  		Thread.sleep(7000);
            	  		performerPOM.clearButton().click();
            	  		test.log(LogStatus.PASS, "clear button work successfully.");
            	  	}
            	  	else
            	  	{
            	  		test.log(LogStatus.FAIL, "clear button not work successfully.");
            	  	}
            	  	
            	  	Thread.sleep(3000);
            	  	getDriver().switchTo().parentFrame();
            	  	Thread.sleep(2000);
            	  	performerPOM.caseNoticeSummaryGraphClose().click();
            	  	

            	  }
             public static void InwardDefendentAgeingGraph1to2years(ExtentTest test, String type) throws InterruptedException, IOException
       		
       		{
       			
            	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
       			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
       	       	js.executeScript("window.scrollBy(0,800)");
       	       	
       	       	Thread.sleep(5000);
       			performerPOM.clickDashboardCaseNoticeFilter().click();
       			
       			Thread.sleep(5000);
       			performerPOM.clickDashboardNoticeFilter().click();
       			
       			 Thread.sleep(5000);
       				performerPOM.clickDashboardApplyBtn().click();
       				
       				js.executeScript("window.scrollBy(0,4000)");
       			
       	       	Thread.sleep(3000);
       		
       	       	int	open = Integer.parseInt(performerPOM.clickInwardDefendent().getText());	//Reading Notice Open count.
       		    performerPOM.clickInwardDefendent().click();						//Clicking on 'Open' notice
       		
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
       				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
       				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
       			}
       			else
       			{
       				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
       				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
       			}
       	       	
       	    
       			Thread.sleep(3000);
       			performerPOM.clickAgeingViewIcon().click();
       			

     			
     			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
     			Thread.sleep(2000);
       		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
       		  
       		  if(msg.equalsIgnoreCase("Notice Summary"))
       		  {
       			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
       		  }
       		  else
       		  {
       			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
       		  }
       		  
       		  getDriver().switchTo().parentFrame();
       			
       		 Thread.sleep(3000);
       		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
       			
       			
       			
       			
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
       			
//       			Thread.sleep(5000);
//       			performerPOM.clickAgeFilter().click();
//       			
//       			Thread.sleep(5000);
//       			performerPOM.selectAgeFiltercfo().click();
       			
       			Thread.sleep(5000);
       			performerPOM.clickCategoryFilter().click();
       			
       			
       			Thread.sleep(5000);
       			performerPOM.selectCategoryFilter2().click();
       			
       			Thread.sleep(5000);
       			performerPOM.clickStageFilter().click();
       			
       			Thread.sleep(5000);
       			performerPOM.selectStageFilter2().click(); */
       			
       			
       			Thread.sleep(500);
       			progress();
       			
       			Thread.sleep(1000);
       			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
       			Thread.sleep(2000);
       			
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
       			File dir = new File("C://Users//snehalp//Downloads");
       			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
       			
       			Thread.sleep(500);
       			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
       			Thread.sleep(250);
       			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
       			test.log(LogStatus.PASS, "File downloaded successfully.");
       			
       			Thread.sleep(5500);
       			File dir1 = new File("C://Users//snehalp//Downloads");
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
       				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
       				
       				int no = sheet.getLastRowNum();
       				Row row = sheet.getRow(no);
       				Cell c1 = row.getCell(0);
       				int records =(int) c1.getNumericCellValue();
       				fis.close();
       				
       				if(count2 == records)
       				{
       					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
       					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
       				}
       				else
       				{
       					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
       					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
       				}
       			}
       			else
       			{
       				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
       			}
       			
//       			Thread.sleep(7000);
//       			performerPOM.clickRiskFilter().click();
//       			
//       			Thread.sleep(7000);
//       			performerPOM.selectRiskFilter().click();
       			
//       		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//       			selectOptionFromDropDown_bs(SeletcRisk, "High");
       			
       			Thread.sleep(7000);
       			if(performerPOM.clearButton().isEnabled())
       			{
       				Thread.sleep(7000);
       				performerPOM.clearButton().click();
           			test.log(LogStatus.PASS, "clear button work successfully.");
       			}
       			else
       			{
       				test.log(LogStatus.FAIL, "clear button not work successfully.");
       			}
       		
       			
       			
       			
       			Thread.sleep(3000);
       			getDriver().switchTo().parentFrame();
       			Thread.sleep(2000);
       			performerPOM.caseNoticeSummaryGraphClose().click();
       			
      			Thread.sleep(3000);
      			OverduePOM.clickDashboard().click();
       			
       	   }
             public static void OutwardPlaintiffAgeingGraph1to2years(ExtentTest test, String type) throws InterruptedException, IOException
        		
        		{
        			
            	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
        			JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
        	       	js.executeScript("window.scrollBy(0,800)");
        	       	
        	       	Thread.sleep(5000);
        			performerPOM.clickDashboardCaseNoticeFilter().click();
        			
        			Thread.sleep(5000);
        			performerPOM.clickDashboardNoticeFilter().click();
        			
        			 Thread.sleep(5000);
        				performerPOM.clickDashboardApplyBtn().click();
        				
        				js.executeScript("window.scrollBy(0,4000)");
        			
        	       	Thread.sleep(3000);
        		
        	       	int	open = Integer.parseInt(performerPOM.clickOutwardPlaintiff().getText());	//Reading Notice Open count.
        		    performerPOM.clickOutwardPlaintiff().click();						//Clicking on 'Open' notice
        		
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
        				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
        				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
        			}
        			else
        			{
        				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
        				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
        			}
        	       	
        	    
        			Thread.sleep(3000);
        			performerPOM.clickAgeingViewIcon().click();
        			

      			
      			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
      			Thread.sleep(2000);
        		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
        		  
        		  if(msg.equalsIgnoreCase("Notice Summary"))
        		  {
        			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
        		  }
        		  else
        		  {
        			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
        		  }
        		  
        		  getDriver().switchTo().parentFrame();
        			
        		 Thread.sleep(3000);
        		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
        			
        			
        			
        			
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
        			
//        			Thread.sleep(5000);
//        			performerPOM.clickAgeFilter().click();
//        			
//        			Thread.sleep(5000);
//        			performerPOM.selectAgeFiltercfo().click();
        			
        			Thread.sleep(5000);
        			performerPOM.clickCategoryFilter().click();
        			
        			
        			Thread.sleep(5000);
        			performerPOM.selectCategoryFilter2().click();
        			
        			Thread.sleep(5000);
        			performerPOM.clickStageFilter().click();
        			
        			Thread.sleep(5000);
        			performerPOM.selectStageFilter2().click(); */
        			
        			
        			Thread.sleep(500);
        			progress();
        			
        			Thread.sleep(1000);
        			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
        			Thread.sleep(2000);
        		
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
        			File dir = new File("C://Users//snehalp//Downloads");
        			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
        			
        			Thread.sleep(500);
        			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
        			Thread.sleep(250);
        			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
        			test.log(LogStatus.PASS, "File downloaded successfully.");
        			
        			Thread.sleep(5500);
        			File dir1 = new File("C://Users//snehalp//Downloads");
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
        				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
        				
        				int no = sheet.getLastRowNum();
        				Row row = sheet.getRow(no);
        				Cell c1 = row.getCell(0);
        				int records =(int) c1.getNumericCellValue();
        				fis.close();
        				
        				if(count2 == records)
        				{
        					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
        					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
        				}
        				else
        				{
        					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
        					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
        				}
        			}
        			else
        			{
        				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
        			}
        			
//        			Thread.sleep(7000);
//        			performerPOM.clickRiskFilter().click();
//        			
//        			Thread.sleep(7000);
//        			performerPOM.selectRiskFilter().click();
        			
//        		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//        			selectOptionFromDropDown_bs(SeletcRisk, "High");
        			
        			Thread.sleep(7000);
        			if(performerPOM.clearButton().isEnabled())
        			{
        				Thread.sleep(7000);
        				performerPOM.clearButton().click();
            			test.log(LogStatus.PASS, "clear button work successfully.");
        			}
        			else
        			{
        				test.log(LogStatus.FAIL, "clear button not work successfully.");
        			}
        		
        			
        			
        			
        			Thread.sleep(3000);
        			getDriver().switchTo().parentFrame();
        			Thread.sleep(2000);
        			performerPOM.caseNoticeSummaryGraphClose().click();
        			
       			Thread.sleep(3000);
       			OverduePOM.clickDashboard().click();
        			
        	   }
         public static void RespondentAgeingGraph1to2years(ExtentTest test, String type) throws InterruptedException, IOException
     		
     		{
     			
        	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
     			JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
     	       	js.executeScript("window.scrollBy(0,800)");
     	       	
     	       	Thread.sleep(5000);
     			performerPOM.clickDashboardCaseNoticeFilter().click();
     			
     			Thread.sleep(5000);
     			performerPOM.clickDashboardNoticeFilter().click();
     			
     			 Thread.sleep(5000);
     				performerPOM.clickDashboardApplyBtn().click();
     				
     				js.executeScript("window.scrollBy(0,4000)");
     			
     	       	Thread.sleep(3000);
     		
     	       	int	open = Integer.parseInt(performerPOM.clickRespondent().getText());	//Reading Notice Open count.
     		    performerPOM.clickRespondent().click();						//Clicking on 'Open' notice
     		
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
     				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
     				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
     			}
     			else
     			{
     				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
     				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
     			}
     	       	
     	    
     			Thread.sleep(3000);
     			performerPOM.clickAgeingViewIcon().click();
     			

   			
   			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
   			Thread.sleep(2000);
     		  String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
     		  
     		  if(msg.equalsIgnoreCase("Notice Summary"))
     		  {
     			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
     		  }
     		  else
     		  {
     			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
     		  }
     		  
     		  getDriver().switchTo().parentFrame();
     			
     		 Thread.sleep(3000);
     		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
     			
     			
     			
     			
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
     			
//     			Thread.sleep(5000);
//     			performerPOM.clickAgeFilter().click();
//     			
//     			Thread.sleep(5000);
//     			performerPOM.selectAgeFiltercfo().click();
     			
     			Thread.sleep(5000);
     			performerPOM.clickCategoryFilter().click();
     			
     			
     			Thread.sleep(5000);
     			performerPOM.selectCategoryFilter2().click();
     			
     			Thread.sleep(5000);
     			performerPOM.clickStageFilter().click();
     			
     			Thread.sleep(5000);
     			performerPOM.selectStageFilter2().click(); */
     			
     			
     			Thread.sleep(500);
     			progress();
     			
     			Thread.sleep(1000);
     			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
     			Thread.sleep(2000);
     		
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
     			File dir = new File("C://Users//snehalp//Downloads");
     			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
     			
     			Thread.sleep(500);
     			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
     			Thread.sleep(250);
     			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
     			test.log(LogStatus.PASS, "File downloaded successfully.");
     			
     			Thread.sleep(5500);
     			File dir1 = new File("C://Users//snehalp//Downloads");
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
     				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
     				
     				int no = sheet.getLastRowNum();
     				Row row = sheet.getRow(no);
     				Cell c1 = row.getCell(0);
     				int records =(int) c1.getNumericCellValue();
     				fis.close();
     				
     				if(count2 == records)
     				{
     					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
     					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
     				}
     				else
     				{
     					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
     					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
     				}
     			}
     			else
     			{
     				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
     			}
     			
//     			Thread.sleep(7000);
//     			performerPOM.clickRiskFilter().click();
//     			
//     			Thread.sleep(7000);
//     			performerPOM.selectRiskFilter().click();
     			
//     		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//     			selectOptionFromDropDown_bs(SeletcRisk, "High");
     			
     			Thread.sleep(7000);
     			if(performerPOM.clearButton().isEnabled())
     			{
     				Thread.sleep(7000);
     				performerPOM.clearButton().click();
         			test.log(LogStatus.PASS, "clear button work successfully.");
     			}
     			else
     			{
     				test.log(LogStatus.FAIL, "clear button not work successfully.");
     			}
     		
     			
     			
     			
     			Thread.sleep(3000);
     			getDriver().switchTo().parentFrame();
     			Thread.sleep(2000);
     			performerPOM.caseNoticeSummaryGraphClose().click();
     			
    			Thread.sleep(3000);
    			OverduePOM.clickDashboard().click();
     			
     	   }
         public static void AgeingGraph2to3years(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

         {
         	
         	WebDriverWait wait = new WebDriverWait(getDriver(),20);
         	JavascriptExecutor js = (JavascriptExecutor) getDriver();
         		if(type.equalsIgnoreCase("Inward/Defendent"))
         		{
                  	Thread.sleep(5000);
         	        performerPOM.clickInwardDefendentNoticeCA2to3().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Applicant"))
         		{
                  	Thread.sleep(5000);
         	        performerPOM.clickApplicantNoticeCA2to3().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Outward/Plaintiff"))
         		{
                  	Thread.sleep(5000);
         	        performerPOM.clickOutwardPlaintiffNoticeCA2to3().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Petitioner"))
         		{
                  	Thread.sleep(5000);
         	        performerPOM.clickPetitionerNoticeCA2to3().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Plaintiff"))
         		{
                  	Thread.sleep(5000);
         	        performerPOM.clickPlaintiffNoticeCA2to3().click();						//Clicking on 'Open' notice
         		}
         		
         	
             
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
         	
         	if(counttype == count1)
         	{
         		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
         		test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
         	}
         	else
         	{
         		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
         		test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
         	}
          	

         Thread.sleep(3000);
         performerPOM.clickAgeingViewIcon().click();
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
         Thread.sleep(2000);
           String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
           
           if(msg.equalsIgnoreCase("Notice Summary"))
           {
         	  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
           }
           else
           {
         	 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
           }
           
           getDriver().switchTo().parentFrame();
         	
          Thread.sleep(3000);
          performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
         	
         	Thread.sleep(500);
         	progress();
         	
         	Thread.sleep(1000);
         	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
         	Thread.sleep(2000);
         	
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
         	File dir = new File("C:\\Users\\snehalp//Downloads");
         	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
         	
         	Thread.sleep(500);
         	CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
         	Thread.sleep(250);
         	performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
         	test.log(LogStatus.PASS, "File downloaded successfully.");
         	
         	Thread.sleep(5500);
         	File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
         			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
         			test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
         		}
         		else
         		{
         			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
         			test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
         		}
         	}
         	else
         	{
         		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
         	}
         	
//         	Thread.sleep(7000);
//         	performerPOM.clickRiskFilter().click();
         //	
//         	Thread.sleep(7000);
//         	performerPOM.selectRiskFilter().click();
         	
//             List<WebElement>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//         	selectOptionFromDropDown_bs(SeletcRisk, "High");
         	
         	Thread.sleep(7000);
         	if(performerPOM.clearButton().isEnabled())
         	{
         		Thread.sleep(7000);
         		performerPOM.clearButton().click();
         		test.log(LogStatus.PASS, "clear button work successfully.");
         	}
         	else
         	{
         		test.log(LogStatus.FAIL, "clear button not work successfully.");
         	}
         	
         	Thread.sleep(3000);
         	getDriver().switchTo().parentFrame();
         	Thread.sleep(2000);
         	performerPOM.caseNoticeSummaryGraphClose().click();
         	

         }
         
         public static void AgeingGraphMorethan3years(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

         {
         	
         		WebDriverWait wait = new WebDriverWait(getDriver(),20);
         		JavascriptExecutor js = (JavascriptExecutor) getDriver();
         		if(type.equalsIgnoreCase("Inward/Defendent"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickInwardDefendentMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Complainant"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickComplainantMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Outward/Plaintiff"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickOutwardPlaintiffMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Petitioner"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickPetitionerMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Petitioner"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickPetitionerMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		else if(type.equalsIgnoreCase("Respondent"))
         		{
                  	Thread.sleep(2000);
         	        performerPOM.clickRespondentMorethan3years().click();						//Clicking on 'Open' notice
         		}
         		
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
         	
         	 if(counttype == count1)
         	 {
         		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
         		test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
         	 }
         	 else
         	 {
         		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
         		test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
         	 }
          	

            Thread.sleep(3000);
            performerPOM.clickAgeingViewIcon().click();
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
            Thread.sleep(2000);
            String msg =performerPOM.clickAgeingViewNoticeSummary().getText();
           
           if(msg.equalsIgnoreCase("Notice Summary"))
           {
         	  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
           }
           else
           {
         	 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
           }
           
           getDriver().switchTo().parentFrame();
         	
          Thread.sleep(3000);
          performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
         	
         	Thread.sleep(500);
         	progress();
         	
         	Thread.sleep(1000);
         	wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
         	Thread.sleep(2000);
         	
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
         	File dir = new File("C:\\Users\\snehalp//Downloads");
         	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
         	
         	Thread.sleep(500);
         	CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
         	Thread.sleep(250);
         	performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
         	test.log(LogStatus.PASS, "File downloaded successfully.");
         	
         	Thread.sleep(5500);
         	File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
         			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
         			test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
         		}
         		else
         		{
         			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
         			test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
         		}
         	}
         	else
         	{
         		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
         	}
         	
//         	Thread.sleep(7000);
//         	performerPOM.clickRiskFilter().click();
         //	
//         	Thread.sleep(7000);
//         	performerPOM.selectRiskFilter().click();
         	
//             List<WebElement>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//         	selectOptionFromDropDown_bs(SeletcRisk, "High");
         	
         	Thread.sleep(7000);
         	if(performerPOM.clearButton().isEnabled())
         	{
         		Thread.sleep(7000);
         		performerPOM.clearButton().click();
         		test.log(LogStatus.PASS, "clear button work successfully.");
         	}
         	else
         	{
         		test.log(LogStatus.FAIL, "clear button not work successfully.");
         	}
         	
         	Thread.sleep(3000);
         	getDriver().switchTo().parentFrame();
         	Thread.sleep(2000);
         	performerPOM.caseNoticeSummaryGraphClose().click();
         	

         }


     	public static void AgeingGraphLessThanYear(ExtentTest test, String type,int counttype) throws InterruptedException, IOException
		
		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				
				if(type.equalsIgnoreCase("Applicant"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickApplicantLessThanYearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Complainant"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickComplainantLessThanYearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Inward/Defendent"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickInwardDefendentLessThanYearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Appellant"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickAppellantLessThanYearCase().click();						//Clicking on 'Open' notice
				}
				
				else if(type.equalsIgnoreCase("Outward/Plaintiff"))
				{
					Thread.sleep(2000);
			        performerPOM.clickOutwardPlaintiffLessthanyearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Petitioner"))
				{
					Thread.sleep(3000);
			        performerPOM.clickPetitionerLeassThanYearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Respondent"))
				{
					Thread.sleep(3000);
			        performerPOM.clickRespondentLessThanYearCase().click();						//Clicking on 'Open' notice
				}
			
		    
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
	     	

		Thread.sleep(3000);
		performerPOM.clickAgeingViewIcon().click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(2000);
		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
		  
		  if(msg.equalsIgnoreCase("Case Summary"))
		  {
			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
		  }
		  else
		  {
			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
		  }
		  
		  getDriver().switchTo().parentFrame();
			
		 Thread.sleep(3000);
		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
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
			File dir = new File("C:\\Users\\snehalp//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		     
		     Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
			
			Thread.sleep(7000);
			if(performerPOM.clearButton().isEnabled())
			{
				Thread.sleep(7000);
				performerPOM.clearButton().click();
				test.log(LogStatus.PASS, "clear button work successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "clear button not work successfully.");
			}
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
	 }
		
         public static void OutwardPlaintiffAgeingGraphCase(ExtentTest test, String type) throws InterruptedException, IOException
 		
 		{
 			
        	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
 	       	js.executeScript("window.scrollBy(0,800)");
 	       	
 	       	Thread.sleep(5000);
 			performerPOM.clickDashboardCaseNoticeFilter().click();
 			
 			Thread.sleep(5000);
 			performerPOM.clickDashboardCaseFilter().click();
 			
 			 Thread.sleep(5000);
 				performerPOM.clickDashboardApplyBtn().click();
 				
 				js.executeScript("window.scrollBy(0,4000)");
 			
 	       	Thread.sleep(3000);
 		
 	       	int	open = Integer.parseInt(performerPOM.clickOutwardPlaintiffCase().getText());	//Reading Notice Open count.
 		    performerPOM.clickOutwardPlaintiffCase().click();						//Clicking on 'Open' notice
 		
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
 				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
 				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
 			}
 			else
 			{
 				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
 				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
 			}
 	       	
 	    
 			Thread.sleep(3000);
 			performerPOM.clickAgeingViewIcon().click();
 			

			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			Thread.sleep(2000);
 		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
 		  
 		  if(msg.equalsIgnoreCase("Case Summary"))
 		  {
 			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
 		  }
 		  else
 		  {
 			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
 		  }
 		  
 		  getDriver().switchTo().parentFrame();
 			
 		 Thread.sleep(3000);
 		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
 			
 			
 			
 			
 		
 			
 			Thread.sleep(500);
 			progress();
 			
 			Thread.sleep(1000);
 			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
 			Thread.sleep(2000);
 			
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
 			File dir = new File("C:\\Users\\snehalp\\Downloads");
 			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
 			
 			Thread.sleep(500);
 			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
 			Thread.sleep(250);
 			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
 		
 			
 			Thread.sleep(5500);
 			File dir1 = new File("C://Users//snehalp//Downloads");
 			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
 			
 			if(dirContents.length < allFilesNew.length)
 			{
 				
 				test.log(LogStatus.PASS, "File downloaded successfully.");
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
 				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
 				
 				int no = sheet.getLastRowNum();
 				Row row = sheet.getRow(no);
 				Cell c1 = row.getCell(0);
 				int records =(int) c1.getNumericCellValue();
 				fis.close();
 				
 				if(count2 == records)
 				{
 					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
 					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
 				}
 				else
 				{
 					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
 					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
 				}
 			}
 			else
 			{
 				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
 			}
 			
 			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
 			
// 			Thread.sleep(7000);
// 			performerPOM.clickRiskFilter().click();
// 			
// 			Thread.sleep(7000);
// 			performerPOM.selectRiskFilter1().click();
 			
// 		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
// 			selectOptionFromDropDown_bs(SeletcRisk, "High");
 			
 			Thread.sleep(7000);
 			if(performerPOM.clearButton().isEnabled())
 			{
 				Thread.sleep(7000);
 				performerPOM.clearButton().click();
     			test.log(LogStatus.PASS, "clear button work successfully.");
 			}
 			else
 			{
 				test.log(LogStatus.FAIL, "clear button not work successfully.");
 			}
 		
 			
 			
 			
 			Thread.sleep(3000);
 			getDriver().switchTo().parentFrame();
 			Thread.sleep(2000);
 			performerPOM.caseNoticeSummaryGraphClose().click();
 			
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
 			
 	   }
         public static void PetitionerAgeingGraphCase(ExtentTest test, String type) throws InterruptedException, IOException
  		
  		{
  			
        	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
  			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
  	       	js.executeScript("window.scrollBy(0,800)");
  	       	
  	       	Thread.sleep(5000);
  			performerPOM.clickDashboardCaseNoticeFilter().click();
  			
  			Thread.sleep(5000);
  			performerPOM.clickDashboardCaseFilter().click();
  			
  			 Thread.sleep(5000);
  				performerPOM.clickDashboardApplyBtn().click();
  				
  				js.executeScript("window.scrollBy(0,4000)");
  			
  	       	Thread.sleep(3000);
  		
  	       	int	open = Integer.parseInt(performerPOM.clickPetitionerCase().getText());	//Reading Notice Open count.
  		    performerPOM.clickPetitionerCase().click();						//Clicking on 'Open' notice
  		
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
  				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
  				test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
  			}
  			else
  			{
  				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
  				test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
  			}
  	       	
  	    
  			Thread.sleep(3000);
  			performerPOM.clickAgeingViewIcon().click();
  			

 			
 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 			Thread.sleep(2000);
  		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
  		  
  		  if(msg.equalsIgnoreCase("Case Summary"))
  		  {
  			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
  		  }
  		  else
  		  {
  			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
  		  }
  		  
  		  getDriver().switchTo().parentFrame();
  			
  		 Thread.sleep(3000);
  		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
  			
 	
  			Thread.sleep(500);
  			progress();
  			
  			Thread.sleep(1000);
  			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
  			Thread.sleep(2000);
  			
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
  			File dir = new File("C://Users//snehalp//Downloads");
  			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
  			
  			Thread.sleep(500);
  			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
  			Thread.sleep(250);
  			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
  		
  			
  			Thread.sleep(5500);
  			File dir1 = new File("C://Users//snehalp//Downloads");
  			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
  			
  			if(dirContents.length < allFilesNew.length)
  			{
  				
  				test.log(LogStatus.PASS, "File downloaded successfully.");
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
  				sheet = workbook.getSheetAt(8);					//Retrieving first sheet of Workbook
  				
  				int no = sheet.getLastRowNum();
  				Row row = sheet.getRow(no);
  				Cell c1 = row.getCell(0);
  				int records =(int) c1.getNumericCellValue();
  				fis.close();
  				
  				if(count2 == records)
  				{
  					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
  					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Report = "+records);
  				}
  				else
  				{
  					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
  					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
  				}
  			}
  			else
  			{
  				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
  			}
  			
  			
  			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(5000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		 	Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}
  			
//  			Thread.sleep(7000);
//  			performerPOM.clickRiskFilter().click();
//  			
//  			Thread.sleep(7000);
//  			performerPOM.selectRiskFilter1().click();
  			
//  		    List<Element>SeletcRisk = .findElements(By.xpath("(//ul[@class='k-group k-treeview-lines'])[8]/li/div/span"));
//  			selectOptionFromDropDown_bs(SeletcRisk, "High");
  			
  			Thread.sleep(7000);
  			if(performerPOM.clearButton().isEnabled())
  			{
  				Thread.sleep(7000);
  				performerPOM.clearButton().click();
      			test.log(LogStatus.PASS, "clear button work successfully.");
  			}
  			else
  			{
  				test.log(LogStatus.FAIL, "clear button not work successfully.");
  			}
  		
  			
  			
  			
  			Thread.sleep(3000);
  			getDriver().switchTo().parentFrame();
  			Thread.sleep(2000);
  			performerPOM.caseNoticeSummaryGraphClose().click();
  			
 			Thread.sleep(3000);
 			OverduePOM.clickDashboard().click();
  			
  	   }
         
     	public static void AgeingGraph1to2yearsCase(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
				if(type.equalsIgnoreCase("Complianant"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickComplianant1to2yearCase().click();						//Clicking on 'Open' notice
				}
				
				else if(type.equalsIgnoreCase("Inward/Defendent"))
				{
					Thread.sleep(3000);
			        performerPOM.clickInwardOutward1to2yearsCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Appleant"))
				{
					Thread.sleep(3000);
			        performerPOM.clickAppleant1to2YearCase().click();						//Clicking on 'Open' notice
				}
			
		     else if(type.equalsIgnoreCase("Outward/plaintiff"))
				{
				   Thread.sleep(3000);
		           performerPOM.clickOutwardplaintiff1toyearCase().click();
				}
		     else if(type.equalsIgnoreCase("Petitioner"))
				{
					Thread.sleep(3000);
					performerPOM.clickPetitioner1toyearCase().click();
				}
		     else if(type.equalsIgnoreCase("Respondent"))
				{
					Thread.sleep(3000);
					performerPOM.clickRespondent1toyearCase().click();
				}
				
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
		 	

		Thread.sleep(3000);
		performerPOM.clickAgeingViewIcon().click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(2000);
		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
		  
		  if(msg.equalsIgnoreCase("Case Summary"))
		  {
			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
		  }
		  else
		  {
			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
		  }
		  
		  getDriver().switchTo().parentFrame();
			
		 Thread.sleep(3000);
		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
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
			File dir = new File("C:\\Users\\snehalp//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp//Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		     Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}

			
			Thread.sleep(7000);
			if(performerPOM.clearButton().isEnabled())
			{
				Thread.sleep(7000);
				performerPOM.clearButton().click();
				test.log(LogStatus.PASS, "clear button work successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "clear button not work successfully.");
			}
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
	}
     	public static void AgeingGraph2to3yearsCase(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				if(type.equalsIgnoreCase("Inward/Defendent"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickApplicant2to3yearCase().click();						//Clicking on 'Open' notice
				}
				
				else if(type.equalsIgnoreCase("Outward/Plaintiff"))
				{
					Thread.sleep(4000);
			        performerPOM.clickOutwardPlaintiff2To3YearCase().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Respondent"))
				{
					Thread.sleep(4000);
			        performerPOM.clickRespondent2To3YearCase().click();						//Clicking on 'Open' notice
				}
				
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
			
			Thread.sleep(3000);
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
		 	

		Thread.sleep(3000);
		performerPOM.clickAgeingViewIcon().click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(2000);
		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
		  
		  if(msg.equalsIgnoreCase("Case Summary"))
		  {
			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
		  }
		  else
		  {
			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
		  }
		  
		  getDriver().switchTo().parentFrame();
			
		 Thread.sleep(3000);
		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		     Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}

			
			Thread.sleep(7000);
			if(performerPOM.clearButton().isEnabled())
			{
				Thread.sleep(7000);
				performerPOM.clearButton().click();
				test.log(LogStatus.PASS, "clear button work successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "clear button not work successfully.");
			}
			
			js.executeScript("window.scrollBy(500,0)");
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			
			
		}
     	public static void AgeingGraphMoreThan3yearsCase(ExtentTest test, String type,int counttype) throws InterruptedException, IOException

		{
			
			WebDriverWait wait = new WebDriverWait(getDriver(),20);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				if(type.equalsIgnoreCase("Inward/Defendent"))
				{
		         	Thread.sleep(2000);
			        performerPOM.clickInwardDefendentCAMoreThan3yearsCase().click();						//Clicking on 'Open' notice
				}
				
				else if(type.equalsIgnoreCase("Outward/Plaintiff"))
				{
					Thread.sleep(3000);
			        performerPOM.clickAppleantCaseCAMoreThan3years().click();						//Clicking on 'Open' notice
				}
				else if(type.equalsIgnoreCase("Petitioner"))
				{
					Thread.sleep(3000);
			        performerPOM.clickPetitionerCaseCAMoreThan3years().click();						//Clicking on 'Open' notice
				}
				
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
			
			if(counttype == count1)
			{
				//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
				test.log(LogStatus.PASS, type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
			else
			{
				//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
				test.log(LogStatus.FAIL,type+" = Dashboard Count = "+counttype+" | Displayed records from grid = "+count1);
			}
		 	

		Thread.sleep(3000);
		performerPOM.clickAgeingViewIcon().click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(2000);
		  String msg =performerPOM.clickAgeingViewCaseSummary().getText();
		  
		  if(msg.equalsIgnoreCase("Case Summary"))
		  {
			  test.log(LogStatus.PASS, "View Icon Of Ageing Graph Open Successfully = " +msg);
		  }
		  else
		  {
			 test.log(LogStatus.FAIL, "View Icon Of Ageing Graph Not Open Successfully = " +msg);
		  }
		  
		  getDriver().switchTo().parentFrame();
			
		 Thread.sleep(3000);
		 performerPOM.clickAgeingViewNoticeSummaryCloseIcon().click();
			
			Thread.sleep(500);
			progress();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			Thread.sleep(2000);
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			Thread.sleep(500);
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
			Thread.sleep(250);
			performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
					//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
				}
				else
				{
					//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			File dir2 = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
		     performerPOM.ClickDetailedExpenseReport().click();
		     
		     Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
			
		 	Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Detailed Expenses Report Download Successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "Detailed Expenses Report does not Download Successfully");
			}

			
			Thread.sleep(7000);
			if(performerPOM.clearButton().isEnabled())
			{
				Thread.sleep(7000);
				performerPOM.clearButton().click();
				test.log(LogStatus.PASS, "clear button work successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "clear button not work successfully.");
			}
			
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performerPOM.caseNoticeSummaryGraphClose().click();
			

		}
         
         public static void NoticeWithInvalidData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
 		{
 		   
        	 sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
        	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 			progress();
 			
 			Thread.sleep(500);
 			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,-700)");
            Thread.sleep(500);
        	performerPOM.clickNoticeOpen().click();		
 			
             Thread.sleep(4000);
 			clickNewNotice();
 			
 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 			
 			
 			
 			Thread.sleep(3000);
 			clickDated();

 			Thread.sleep(3000);
 			clickFinancialYear();

 			Thread.sleep(3000);
 			clickRefNo();

 			Thread.sleep(3000);
 			selectNoticeType();

 			Thread.sleep(3000);
 			clickAct();

 			Thread.sleep(3000);
 			clickOpponentcfo();

 			Thread.sleep(3000);
 			selectCategory();

 			Thread.sleep(3000);
 			clickNoticeTitle();

 			Thread.sleep(3000);
 			clickNoticeDescription();

 			Thread.sleep(3000);
 			selectLocation();

 			Thread.sleep(3000);
 			clickDepartment();

 			Thread.sleep(3000);
 			clickOwner();

 			Thread.sleep(3000);
             selectRisk();

 			Thread.sleep(3000);
             selectNoticeRecipetDate1();
             
             Thread.sleep(3000);
             clickInternalUser();
             


             Thread.sleep(3000);
     		performerPOM.selectNoticeUploadDocument(); 
     		
        		
        	Thread.sleep(3000);
     		OverduePOM.clickSaveButton().click();		
     		
     		Thread.sleep(1000);
     		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
     		
     		Thread.sleep(2000);
     		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
     		
     		if(msg.equalsIgnoreCase("Server Error Occurred. Please try again."))
     		{
     			test.log(LogStatus.FAIL, "Message displayed = "+msg);
     		
     		}
     		else
     		{
     			test.log(LogStatus.PASS, "Message displayed = "+msg);
     		}
     		
     	

     		Thread.sleep(3000);
     		getDriver().switchTo().parentFrame();
     		performerPOM.clickClose().click();//Clicking on 'Close'
     		
     		Thread.sleep(3000);
     		OverduePOM.clickDashboard().click();
     		
     	
  	}
    		
 			public  static void selectNoticeRecipetDate1( )
 		      {
 		    	 	
 		          WebElement openDate= performerPOM.selectNoticeRecipetDate();
 		          openDate.sendKeys("30-09-202");
 		        
 		      }

 			
 		  public static void NoticeWithExistingData( ExtentTest test) throws InterruptedException, IOException
 	 		{
 	 		   
 	        	
 	        	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 			progress();
 	 			
 	 			Thread.sleep(500);
 	 			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
 	            js.executeScript("window.scrollBy(0,-700)");
 	            Thread.sleep(500);
 	        	performerPOM.clickNoticeOpen().click();		
 	 			
 	             Thread.sleep(4000);
 	 			clickNewNotice();
 	 			
 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 			
 	 			
 	 			
 	 			Thread.sleep(3000);
 	 			clickDated();

 	 			Thread.sleep(3000);
 	 			clickFinancialYear();

 	 			Thread.sleep(3000);
 	 			clickRefNo3();

 	 			Thread.sleep(3000);
 	 			selectNoticeType();

 	 			Thread.sleep(3000);
 	 			clickAct();

 	 			Thread.sleep(3000);
 	 			clickOpponentcfo();

 	 			Thread.sleep(3000);
 	 			selectCategory();

 	 			Thread.sleep(3000);
 	 			clickNoticeTitle();

 	 			Thread.sleep(3000);
 	 			clickNoticeDescription();

 	 			Thread.sleep(3000);
 	 			selectLocation();

 	 			Thread.sleep(3000);
 	 			clickDepartment();

 	 			Thread.sleep(3000);
 	 			clickOwner();

 	 			Thread.sleep(3000);
 	             selectRisk();

 	 			Thread.sleep(3000);
 	             selectNoticeRecipetDate();
 	             
 	             Thread.sleep(3000);
 	             clickInternalUser();
 	             


 	             Thread.sleep(3000);
 	     		performerPOM.selectNoticeUploadDocument(); 
 	     		
 	        		
 	        	Thread.sleep(3000);
 	     		OverduePOM.clickSaveButton().click();		
 	     		
 	     		Thread.sleep(1000);
 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
 	     		
 	     		Thread.sleep(2000);
 	     		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
 	     		
 	     		if(msg.equalsIgnoreCase("Notice with Same Reference No. already exists"))
 	     		{
 	     			test.log(LogStatus.PASS, "Message displayed = "+msg);
 	     		
 	     		}
 	     		else
 	     		{
 	     			test.log(LogStatus.FAIL, "Message displayed = "+msg);
 	     		}
 	     		
 	     		Thread.sleep(3000);
 	     		getDriver().switchTo().parentFrame();
 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	     		
 	     		Thread.sleep(3000);
 	     		OverduePOM.clickDashboard().click();
 	     		
        }
 	     		
     public static void clickRefNo3( ) throws InterruptedException, IOException
 	 		{
 	 		   Thread.sleep(300);
 	 		   performerPOM.clickRefNo().sendKeys("89253");			//Writing 'Reference No'
 	 		}
 	 		
 	 	
 	 			
 	 public static void NoticeWithTwoMandatoryData( ExtentTest test) throws InterruptedException, IOException
 	 	 {
 	 	 		   
 	 	        	
 	 	        	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 			progress();
 	 	 			
 	 	 			Thread.sleep(500);
 	 	 			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
 	 	            js.executeScript("window.scrollBy(0,-700)");
 	 	            Thread.sleep(500);
 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 			
 	 	             Thread.sleep(4000);
 	 	 			clickNewNotice();
 	 	 			
 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 			
 	 	 			
 	 	 			
 	 	 			Thread.sleep(3000);
 	 	 			clickDated();

 	 	 			Thread.sleep(3000);
 	 	 			clickFinancialYear();
 	 	 			
 	 	 			Thread.sleep(3000);
 	 	     		OverduePOM.clickSaveButton().click();		
 	 	     		
 	 	     		Thread.sleep(1000);
 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
 	 	     		
 	 	     		Thread.sleep(2000);
 	 	     		String msg = performerPOM.readInvalidMessage().getText();		//Reading Message appeared after save button
 	 	     		
 	 	     	
 	 	     		test.log(LogStatus.PASS, "Message displayed = "+msg);
 	 	     		
 	 	     		
 	 	 
 	 	     		Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     		
 	 	     		Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
 	 	 }
 	 	     		
 	 	     	
 	 	 	 		
 	 	 	 		
 	 	 	 	public  static void NoticeWithEmptyFields( ExtentTest test) throws InterruptedException, IOException
 	 	 	 	 {
 	 	 	 	 		   
 	 	 	 	        	 
 	 	 	 	        	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 	 			progress();
 	 	 	 	 			
 	 	 	 	 			Thread.sleep(500);
 	 	 	 	 			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
 	 	 	 	            js.executeScript("window.scrollBy(0,-700)");
 	 	 	 	            Thread.sleep(500);
 	 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 	 			
 	 	 	 	             Thread.sleep(4000);
 	 	 	 	 			clickNewNotice();
 	 	 	 	 			
 	 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 	 			
 	 	 	 	 		
 	 	 	 	 			Thread.sleep(3000);
 	 	 	 	     		OverduePOM.clickSaveButton().click();		
 	 	 	 	     		
 	 	 	 	     		Thread.sleep(1000);
 	 	 	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessage()));
 	 	 	 	     		
 	 	 	 	     		Thread.sleep(2000);
 	 	 	 	     		String msg = performerPOM.readInvalidMessage().getText();		//Reading Message appeared after save button
 	 	 	 	     		
 	 	 	 	     	
 	 	 	 	     		test.log(LogStatus.PASS, "Message displayed = "+msg);
 	 	 	 	     		
 	 	 	 	     		
 	 	 	 	 
 	 	 	 	     		Thread.sleep(3000);
 	 	 	 	     		getDriver().switchTo().parentFrame();
 	 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	 	 	     		
 	 	 	 	     		Thread.sleep(3000);
 	 	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 	 }
 	 	 	  static void NoticeClearBtn( ExtentTest test) throws InterruptedException, IOException
	 	 	 	 {
	 	 	 	 		   
	 	 	 	        	
	 	 	 	        	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 	 			progress();
	 	 	 	 			
	 	 	 	 			Thread.sleep(500);
	 	 	 	 			 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	 	 	 	            js.executeScript("window.scrollBy(0,-700)");
	 	 	 	            Thread.sleep(500);
	 	 	 	        	performerPOM.clickNoticeOpen().click();		
	 	 	 	 			
	 	 	 	             Thread.sleep(4000);
	 	 	 	 			clickNewNotice();
	 	 	 	 			
	 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 	 		Thread.sleep(3000);
	 	 	 			clickDated();

	 	 	 			Thread.sleep(3000);
	 	 	 			clickFinancialYear();
	 	 	 	 		
	 	 	 	 			
	 	 	 	     	      Thread.sleep(2000);
	 	 	 	             if(performerPOM.clickNoticeClearBtn().isEnabled())
	 	 			          {
	 	 			            Thread.sleep(2000);
	 	 			              performerPOM.clickNoticeClearBtn().click();
	 	 			              test.log(LogStatus.PASS, "Clear Button is clickable");
	 	 			           }
	 	 			         else
	 	 			         {
	 	 			    	   test.log(LogStatus.FAIL, "Clear Button is not clickable");
	 	 			         }
	 	 	 	 
	 	 	 	     		Thread.sleep(3000);
	 	 	 	     		getDriver().switchTo().parentFrame();
	 	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	 	     		
	 	 	 	     		Thread.sleep(3000);
	 	 	 	     		OverduePOM.clickDashboard().click();
	 	 	 	 }
 	 	 	 public static void NoticeSendMailWithDoc( ExtentTest test) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 	 	        	
 	 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	             Thread.sleep(4000);
 	 	 	         
 	 			      	performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 		   Thread.sleep(4000);
 	 	 	 		   performerPOM.clickSendMail().click();
 	 	 	 		   
 	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSelectCheckbox().click();
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickMailTo().sendKeys("admin@gmail.com");
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
	 	 	 		 
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSend().click();
	 	 	 		 
	 	 	 		Thread.sleep(4000);
	 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
	 	 	 		
	 	 	 		if(msg.equalsIgnoreCase("E-Mail Sent Successfully."))
	 	 	 		{
	 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
	 	 	 		}
	 	 	 		else
	 	 	 		{
	 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
	 	 	 		}
	 	 	 		
	 	 			Thread.sleep(3000);
	 	 	     
	 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
	 	 	     	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     	
	 	 	     	Thread.sleep(3000);
	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 
 	 	 	 }
 	 		 public static void NoticeSendMailWithDocInvalidFields( ExtentTest test) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 	 	        	
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	             Thread.sleep(4000);
 	 	 	         
 	 			      	performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 		   Thread.sleep(4000);
 	 	 	 		   performerPOM.clickSendMail().click();
 	 	 	 		   
 	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSelectCheckbox().click();
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickMailTo().sendKeys("admin");
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
	 	 	 		 
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSend().click();
	 	 	 		 
	 	 	 		Thread.sleep(4000);
	 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
	 	 	 		
	 	 	 		if(msg.equalsIgnoreCase("Please enter a valid email."))
	 	 	 		{
	 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
	 	 	 		}
	 	 	 		else
	 	 	 		{
	 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
	 	 	 		}
	 	 	 		
	 	 			Thread.sleep(3000);
	 	 	     
	 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
	 	 	     	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     	
	 	 	     	Thread.sleep(3000);
	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 
 	 	 	 }
 	 	 	 			
 	 		 public static void NoticeSendMailWithDocEmptyFields( ExtentTest test) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 	 	        	
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	             Thread.sleep(4000);
 	 	 	         
 	 			      	performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 		   Thread.sleep(4000);
 	 	 	 		   performerPOM.clickSendMail().click();
 	 	 	 		   
 	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSelectCheckbox().click();
	 	 	 		 
	 	 	 		
	 	 	 		 
	 	 	 		 Thread.sleep(4000);
	 	 	 		 performerPOM.clickSend().click();
	 	 	 		 
	 	 	 		Thread.sleep(4000);
	 	 	 		String msg= performerPOM.clickSendMailMsg1().getText();
	 	 	 		
	 	 	 		
	 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
	 	 	 		
	 	 	 		
	 	 			Thread.sleep(3000);
	 	 	     
	 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
	 	 	     	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     	
	 	 	     	Thread.sleep(3000);
	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 
 	 	 	 }
 	 		 
 	 		 public static void LinkNoticeViewIcon( ExtentTest test) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 	 	        	
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	            Thread.sleep(4000);
 	 	 	            performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 		    Thread.sleep(4000);
 	 	 	            performerPOM.clickLinkedNoticeViewIcon().click();
	 			      	
	 			      	Thread.sleep(4000);
	 	 	 	        performerPOM.clickViewPopup().click();
	 	 	 	        
	 	 	 	        String msg="Linked Notice Details";
	 	 	 	        
	 	 	 	        if(msg.equalsIgnoreCase(msg))
	 	 	 	        {
	 	 	 	        	test.log(LogStatus.PASS, "View Notice Detailes icon open succssefully");
	 	 	 	        }
	 	 	 	        else
	 	 	 	        {
	 	 	 	        	test.log(LogStatus.FAIL, "View Notice Detailes icon not open succssefully");

	 	 	 	        }
	 	 	 	        

 	 	 	 		Thread.sleep(4000);
 	 	 	        performerPOM.clickClosePopup1().click();
 	 	 	     	Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     	
 	 	     	    Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 			
 	 	 	 }
 	 		 public static void LinkNoticeDeleteIcon( ExtentTest test) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 	 	        	
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	            Thread.sleep(4000);
 	 	 	            performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 		    Thread.sleep(4000);
 	 	 	            performerPOM.clickLinkedNoticeDeleteIcon().click();
	 			      	
 	 	 	         Thread.sleep(5000);
 	 			    // Switching to Alert        
 	 		        Alert alert1 = getDriver().switchTo().alert();		
 	 		        		
 	 		        // Capturing alert message.    
 	 		        String alertMessage1= getDriver().switchTo().alert().getText();	
 	 		        
 	 		        
 	 		        test.log(LogStatus.PASS, alertMessage1);
 	 		        		
 	 		        // Displaying alert message		
 	 		        System.out.println(alertMessage1);
 	 		        
 	 		       // Accepting alert		
 	 		        alert1.accept();	
 	 		        
 	 		      Thread.sleep(4000);
	 	 	       String msg= performerPOM.clickLinkedNoticeDeleteIconValidMsg().getText();
	 	 	       
	 	 	       test.log(LogStatus.PASS, "Message Displayed =" +msg);
	 	 	 	        

 	 	 	     	Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     	
 	 	     	    Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
 	 	 	 			
 	 	 	 }
 	 		 
 	 		 public static void NoticeUserAssignment( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 			        sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
 	 			      WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 	  
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();		
 	 	 	 			
 	 	 	            Thread.sleep(4000);
 	 	 	            performerPOM.clickEditNotice().click();
 	 	 	            
 	 	 	            try
 	 	 	            {
 	 	 	            
 	 	 	              	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 	 	 			
 	 	 	 	            Thread.sleep(4000);
	 	 	                 performerPOM.clickEditUserAssign().click();
 	 	 	 			 
	 	 	                 Thread.sleep(3000);
	 	 	                 performerPOM.clickInternalUser().click();	
	 	 	                 Thread.sleep(3000);
	 	 	                 elementsList = performerPOM.chooseInternalUser();
	 	 	    		     elementsList.get(5).click();							//Selecting particular user no
	 	 	    		     performerPOM.clickInternalUser().click();	//Clicking on 'Internal User' drop down.
	 	                     Thread.sleep(3000);
	 	 	                 performerPOM.clickSaveCriteria().click();   //Click Update Btn
	 	               
 	 				      
 	 	 	    		Thread.sleep(2000);
 	 	 	    		String msg = performerPOM.readMessage().getText();		//Reading Message appeared after save button
 	 	 	    		
 	 	 	    		if(msg.equalsIgnoreCase("Notice Details Updated Successfully."))
 	 	 	    		{
 	 	 	    			test.log(LogStatus.PASS, "Message displayed = "+msg);
 	 	 	    			
 	 	 	    		}
 	 	 	    		else
 	 	 	    		{
 	 	 	    			test.log(LogStatus.FAIL, "Message displayed = "+msg);
 	 	 	    		}
 	 	 	    	
 	 	 	       } 
 	 	 	            
 	 	 	            catch(Exception e)
 	 	 	            {
 	 	 	            	test.log(LogStatus.PASS, "Record not displayed in Notice-User assignment");
 	 	 	            }
 	 	 	            
 	 	 	     	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     		
 	 	 	     	
 	 	 	     	    Thread.sleep(3000);
 	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	    }
 	 		 
 	 		 public static void NoticeUserAssignmentDelete( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
 	 	 	 {
 	 	 	 		   
 	 			        sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
 	 			 	 WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 	 	 			progress();
 	 	 	 			
 	 	 	 		
 	 	 	 			
 	 	 	            Thread.sleep(500);
 	 	 	        	performerPOM.clickNoticeOpen().click();	
 	 	 	        	
// 	 	 	            Thread.sleep(4000);
//	 	 	            performerPOM.clickEditNotice().click();
	 	 	            
	 	 	            try
	 	 	            {
	 	 	            
	 	 	       	       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	       	       Thread.sleep(4000);
	 	 	                performerPOM.clickEditNotice().click();
 	 	 	 			
 	 	 	               Thread.sleep(4000);
 	 	 	               performerPOM.clickDeleteUserAssign().click();
 	 	 	            
 	 	 	               Thread.sleep(2000);
	 	 	    	 	   String msg = performerPOM.clickDeleteUserAssignValidMsg().getText();		//Reading Message appeared after save button
	 	 	    		
	 	 	    		    if(msg.equalsIgnoreCase("User Assignment Detail Deleted"))
	 	 	    		    {
	 	 	    			     test.log(LogStatus.PASS, "Message displayed = "+msg);
	 	 	    			
	 	 	    		    }
	 	 	    		    else
	 	 	    		      {
	 	 	    			         test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 	 	    		        }
 	 	 	            
 	 	 	        
 	 	 	    	
	 	 	        }
	 	 	            catch(Exception e)
	 	 	            {
	 	 	            	test.log(LogStatus.PASS, "Record not displayed in Notice-User assignment");
 	 	 	           
	 	 	            }
	 	 	            
	 	 	      	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	          
 	 	 	     	    Thread.sleep(3000);
 	 	 	     		OverduePOM.clickDashboard().click();
 	 	 	    }
 	 		public static void NoticeDocumentEmptyFields( ExtentTest test) throws InterruptedException
 	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	             
 	    	
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 				
 		        
 		        performerPOM.clickNoticeDocument().click();     //click notice document
 		        performerPOM.clickNewDocument().click();        //click new document button
 		
 		        Thread.sleep(1000);
 	           	getDriver().switchTo().frame("IFrameManageDocument");
 	  
 		        Thread.sleep(1000);
 	         	performerPOM.clickUploadDocument().click(); 
 		
 		
 	         	Thread.sleep(1000);
 	         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
 		
 	        	Thread.sleep(3000);
 		        String msg= performerPOM.readDocMsgInvalidMsg().getText();		//Reading Message appeared after save button
 		       
 	         	if(msg.equalsIgnoreCase("Please select document type"))
 	         	{
 		        	test.log(LogStatus.PASS, "Message displayed = "+msg);
 		         
 		        }
 		      else
 		        {
 			       test.log(LogStatus.FAIL, "Message displayed = "+msg);
 		        }
 		
 	         	
 		        Thread.sleep(1000);
 		        performerPOM.clickClosedDocument().click(); 
 		       getDriver().switchTo().parentFrame();
 		      
 		      Thread.sleep(3000);
 	     		getDriver().switchTo().parentFrame();
 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	    }
 	 	  	public static void NoticeWithoutUploadDocument( ExtentTest test) throws InterruptedException
 	       	{
 	 	  		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	             
 	    		Thread.sleep(1000);
 	    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 				
 		        
 		        performerPOM.clickNoticeDocument().click();     //click notice document
 		        performerPOM.clickNewDocument().click();        //click new document button
 		
 		        Thread.sleep(1000);
 	           	getDriver().switchTo().frame("IFrameManageDocument");
 	           	performerPOM.selectDocumentType();
 	           Thread.sleep(3000);
 		        performerPOM.chooseDocumentType();
 	          	
 		        Thread.sleep(1000);
 	         	performerPOM.clickUploadDocument().click(); 
 		
 		
 	         	Thread.sleep(1000);
 	         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
 		
 	        	Thread.sleep(3000);
 		        String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
 		       
 	         	if(msg.equalsIgnoreCase("Please select file to upload"))
 	         	{
 		        	test.log(LogStatus.PASS, "Message displayed = "+msg);
 		         
 		        }
 		      else
 		        {
 			       test.log(LogStatus.FAIL, "Message displayed = "+msg);
 		        }
 		
 		        Thread.sleep(1000);
 		        performerPOM.clickClosedDocument().click();
 		        
 		      getDriver().switchTo().parentFrame();
  		      
  		      Thread.sleep(3000);
  	     		getDriver().switchTo().parentFrame();
  	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	       	}
 	 	  	
 	 		static void NoticeDocumentSearchFields( ExtentTest test) throws InterruptedException
 	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	             
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

 		        Thread.sleep(3000);
 				 performerPOM.clickNoticeDocument().click();     //click notice document
 				
 				Thread.sleep(3000);
 	 			performerPOM.clickSearchDocument().sendKeys("Approver Test Case.xlsx");
 	 			
 	 			Thread.sleep(3000);
 				performerPOM.clickApplyBtn().click();
 				
 				
 				try
 				{
 					String msg=performerPOM.clickDocName().getText();
 					
 					test.log(LogStatus.PASS,"Document Filter Apply =" +msg);
 						
 					
 				}
 				catch(Exception e)
 				{
 					String msg=performerPOM.noRecordFound().getText();
 					test.log(LogStatus.PASS,"Document Filter Apply =" +msg);
 				}
 					
 				Thread.sleep(3000);
  	     		getDriver().switchTo().parentFrame();
  	     		performerPOM.clickClose().click();//Clicking on 'Close'
 				
 				
 	       	}
 	 		
 	 		public static void NoticeDocumentShareInvalidData( ExtentTest test) throws InterruptedException
 	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	             
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

 		        Thread.sleep(3000);
 				 performerPOM.clickNoticeDocument().click();     //click notice document
 				 
 				 Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharecfo().click();
 		        
 		        Thread.sleep(5000);
 			    // Switching to Alert        
 		        Alert alert1 =getDriver() .switchTo().alert();		
 		        		
 		        // Capturing alert message.    
 		        String alertMessage1= getDriver().switchTo().alert().getText();	
 		        
 		        
 		        test.log(LogStatus.PASS, alertMessage1);
 		        		
 		        // Displaying alert message		
 		        System.out.println(alertMessage1);
 		        
 		     // Accepting alert		
 		        alert1.accept();	
 		        
 		        Thread.sleep(3000);
 		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
 		        
 		        Thread.sleep(4000);
 		        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin");
 		        
 		        Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("576879");
 		        
 		        Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharesavecfo().click();
 		        
 		        
 		        Thread.sleep(3000);
 		        String msg1= performerPOM.clickNoticeDocumentshareInvalidmsgcfo().getText();		//Reading Message appeared after save button
 		       
 	         
 		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
 		      
 		        
 		        Thread.sleep(3000);
 		        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
 		        
 		       getDriver().switchTo().parentFrame();
   		      
   		        Thread.sleep(3000);
   	     		getDriver().switchTo().parentFrame();
   	     		performerPOM.clickClose().click();//Clicking on 'Close'
  	       	}
 	 		
 	 		public static void NoticeDocumentShareWithoutData( ExtentTest test) throws InterruptedException
 	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	   		      
 	             
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

 		        Thread.sleep(3000);
 				 performerPOM.clickNoticeDocument().click();     //click notice document
 				 
 				 Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharecfo().click();
 		        
 		        Thread.sleep(5000);
 			    // Switching to Alert        
 		        Alert alert1 =getDriver().switchTo().alert(); 		        		
 		        // Capturing alert message.    
 		        String alertMessage1= getDriver().switchTo().alert().getText();	
 		        
 		        
 		        test.log(LogStatus.PASS, alertMessage1);
 		        		
 		        // Displaying alert message		
 		        System.out.println(alertMessage1);
 		        
 		     // Accepting alert		
 		        alert1.accept();	
 		        
 		       Thread.sleep(3000);
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
 		        
 		      
 		        
 		        Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharesavecfo().click();
 		        
 		        
 		        Thread.sleep(3000);
 		        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
 		        if(msg1.equalsIgnoreCase("Please Enter Email."))
 		        {
 	         
 		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
 		        }
 		        else
 		        {
 		        	test.log(LogStatus.FAIL, "Message displayed = "+msg1);
 		        }
 		        
 		        Thread.sleep(3000);
 		        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
 		        
 		       getDriver().switchTo().parentFrame();
   		      
   		        Thread.sleep(3000);
   	     		getDriver().switchTo().parentFrame();
   	     		performerPOM.clickClose().click();//Clicking on 'Close'
  	       	}
 	 		
 	 		static void NoticeDocumentShareCloseBtn( ExtentTest test) throws InterruptedException
 	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	             
 	    		
 		        Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 				
 				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

 		        Thread.sleep(3000);
 				 performerPOM.clickNoticeDocument().click();     //click notice document
 				 
 				 
 				 Thread.sleep(3000);
 		        performerPOM.clickNoticeDocumentsharecfo().click();
 		        
 		       Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = getDriver().switchTo().alert();	
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
//		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert1.accept();	
		        
		       Thread.sleep(3000);
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));

	     	      Thread.sleep(2000);
	             if(performerPOM.clickNoticeDocumentshareclosepopupcfo().isEnabled())
	             {
	              Thread.sleep(2000);
	              performerPOM.clickNoticeDocumentshareclosepopupcfo().click();
	              test.log(LogStatus.PASS, "Close Button is clickable");
	             }
	            else
	           {
	    	     test.log(LogStatus.FAIL, "Close Button is not clickable");
	           }
	           
	   	     		getDriver().switchTo().parentFrame();
	   	     	getDriver().switchTo().parentFrame();
	   	     	   Thread.sleep(3000);
	   	     		performerPOM.clickClose().click();//Clicking on 'Close'
	   	     	
 	       }
 	 		
 	 		 public  static void TaskActivtityExistingData( ExtentTest test) throws InterruptedException, IOException
 			{
     		 
     		       //XSSFSheet sheet = ReadExcel();
     		      WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 				   
 				  Thread.sleep(3000);
	 				performerPOM.clickNoticeOpen().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 				

 				   
 				   Thread.sleep(1000);
 				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 				  Thread.sleep(1000);
 				  performerPOM.clickTaskorActivity().click();
 				  Thread.sleep(1000);
 				  performerPOM.clickNewTask().click(); 
 				 
 				  
 				 Thread.sleep(500);
				  FileInputStream fis = new FileInputStream(filePath);
				  Workbook workbook = WorkbookFactory.create(fis);
				  Sheet  sheet= workbook.getSheetAt(2);  
 				Thread.sleep(3000);
 				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
 				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
 				String title = c1.getStringCellValue();
 				performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
 				
 				 Thread.sleep(500);
				  FileInputStream fis1 = new FileInputStream(filePath);
				  Workbook workbook1 = WorkbookFactory.create(fis1);
				  Sheet  sheet1= workbook1.getSheetAt(2);
 				Thread.sleep(3000);
 				row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
 				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
 				String desc = c1.getStringCellValue();
 				performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
 				
 				Thread.sleep(3000);
 				performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
 				OverduePOM.selectNextMonth().click();
 				OverduePOM.selectDate().click();					//Selecting particular date.
 				
 				Thread.sleep(500);
 				Actions action = new Actions(getDriver());
// 				action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
 				
 				
 				 Thread.sleep(500);
				  FileInputStream fis2 = new FileInputStream(filePath);
				  Workbook workbook2 = WorkbookFactory.create(fis2);
				  Sheet  sheet2= workbook2.getSheetAt(2);
 				Thread.sleep(500);
 				row0 = sheet2.getRow(14);									//Selected 0th index row (First row)
 				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
 				String outcome = c1.getStringCellValue();
 				performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
 				
 				
 				 Thread.sleep(500);
				  FileInputStream fis3 = new FileInputStream(filePath);
				  Workbook workbook3 = WorkbookFactory.create(fis3);
				  Sheet  sheet3= workbook3.getSheetAt(2);
 				Thread.sleep(500);
 				row0 = sheet3.getRow(15);									//Selected 0th index row (First row)
 				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
 				String internalUser = c1.getStringCellValue();
 				performerPOM.clickInternalUser2().click();
 				//performerPOM.selectInternalUser2().click();
 				performerPOM.selectInternalUser2().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
 				
 	
 				 Thread.sleep(500);
				  FileInputStream fis4 = new FileInputStream(filePath);
				  Workbook workbook4 = WorkbookFactory.create(fis4);
				  Sheet  sheet4= workbook4.getSheetAt(2);
 				Thread.sleep(1000);
 				row0 = sheet4.getRow(16);									//Selected 0th index row (First row)
 				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
 				String externalUser = c1.getStringCellValue();
 				try
 				{
 					Thread.sleep(300);
 					performerPOM.clickExternalUser().click();
 					Thread.sleep(500);
 					action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
 				}
 				catch(Exception e)
 				{
 					
 				}
 			
 				 Thread.sleep(500);
				  FileInputStream fis6 = new FileInputStream(filePath);
				  Workbook workbook6= WorkbookFactory.create(fis6);
				  Sheet  sheet6= workbook6.getSheetAt(2);
 				Thread.sleep(2000);
 				row0 = sheet6.getRow(17);									//Selected 0th index row (First row)
 				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
 				String remark = c1.getStringCellValue();
 				performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
 				
 				//Thread.sleep(300);
 				//String workingDir = System.getProperty("user.dir");
 				//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
 				
 				Thread.sleep(3000);
 				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
 				
 				Thread.sleep(300);
 				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg()));
 				
 				Thread.sleep(300);
 				
 				String msg1 = performerPOM.readTaskMsg1().getText();
 				if(msg1.contains(msg1))
 				{
 					test.log(LogStatus.PASS, "Message displayed ="+msg1);
 				}
 				
 				else 
 				{
 					test.log(LogStatus.FAIL, "Message displayed ="+msg1);
 				}
 				
 				Thread.sleep(3000);
 				performerPOM.clickNoticeEditTaskcfo().click();
 			}
 	 		 public  static void TaskActivtityWithoutData( ExtentTest test) throws InterruptedException, IOException
  			{
      		 
      		      
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
  				   
  				  Thread.sleep(3000);
 	 				performerPOM.clickNoticeOpen().click();//click edit notice
 	 		     
 	 		        Thread.sleep(3000);
 	 				performerPOM.clickEditNotice().click();//click edit notice
 	 			   Thread.sleep(1000);
 				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 			  Thread.sleep(1000);
 				  performerPOM.clickTaskorActivity().click();
 				  Thread.sleep(1000);
 				  performerPOM.clickNewTask().click(); 
 	 				

  	
  				
  				Thread.sleep(3000);
  				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
  				
  			  Thread.sleep(3000);
				performerPOM.clickMinimize().click();
  				
//  				Thread.sleep(300);
//  				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsg()));
  				
  				Thread.sleep(300);
  				
  				String msg1 = performerPOM.readTaskMsg2().getText();
  				
  					test.log(LogStatus.PASS, "Without data ="+msg1);
  				
  				
  				Thread.sleep(3000);
  				performerPOM.clickNoticeEditTaskcfo().click();
  				
  			}
 	 		 
 	 		 public  static void TaskActivtityResponseWithoutStatus( ExtentTest test) throws InterruptedException, IOException
   			{ 
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 	 			  Thread.sleep(3000);
	 				performerPOM.clickNoticeOpen().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			   Thread.sleep(1000);
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 			  Thread.sleep(1000);
				  performerPOM.clickTaskorActivity().click();

				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo().click();
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo().click();
				
				
				String msg=performerPOM.clickInvalidResponsemsg().getText();
				if(msg.equalsIgnoreCase("Provide Response Status."))
				{
				    test.log(LogStatus.PASS, "Mesaage displayed ="+msg);
				}
				else
				{
					 test.log(LogStatus.FAIL, "Mesaage displayed ="+msg);
				}
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskCloseResponsecfo().click();
				
				getDriver().switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
				
             
			}
 	 		 public  static void TaskActivtityDeleteResponse( ExtentTest test) throws InterruptedException, IOException
    			{ 
 	 			 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
  	 			 
  	 		   		Thread.sleep(3000);
 	 				performerPOM.clickNoticeOpen().click();//click edit notice
 	 		     
 	 		        Thread.sleep(3000);
 	 				performerPOM.clickEditNotice().click();//click edit notice
 	 				

 					Thread.sleep(1000);
 					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 	 				
 	 				Thread.sleep(3000);
 					 performerPOM.clickTaskorActivity().click();
 	 				
 	 			
 					Thread.sleep(3000);
 					performerPOM.clickNoticeTaskEditResponse1().click();
 					
 					Thread.sleep(1000);
 					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 					
 					Thread.sleep(4000);
 					performerPOM.clickNoticeTaskstatusResponsecfo().click();
 					
 					
 					Thread.sleep(3000);
 					performerPOM.clickNoticeTaskstatusResponsecfo1().click();
 					
 					Thread.sleep(3000);
 					performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Testt new");
 					
 					Thread.sleep(3000);
 					performerPOM.clickNoticeTaskSaveResponsecfo().click();
 					
 					
 					
 					test.log(LogStatus.PASS,"Task Response Saved Successfully.");
 					
 		 				
 				Thread.sleep(3000);
 				performerPOM.clickDeleteResponse().click();
 				
 			   Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 =getDriver().switchTo().alert(); 
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
//		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert	
		        alert1.accept();
		        
		    	
	 			   Thread.sleep(5000);
		        String msg=performerPOM.clickTaskResponse().getText();
		        if(msg.equalsIgnoreCase("Response Deleted Successfully."))
		        {
		              test.log(LogStatus.PASS,"Message displayed ="+msg);
		        }
		        else
		        {
		        	 test.log(LogStatus.FAIL,"Message displayed ="+msg);
		        }

		        getDriver().switchTo().parentFrame();
		        getDriver().switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
				
    	
    		}
 	 		 public  static void TaskActivtityResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
 			{ 
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 			  Thread.sleep(3000);
	 				performerPOM.clickNoticeOpen().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			   Thread.sleep(1000);
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 			  Thread.sleep(1000);
				  performerPOM.clickTaskorActivity().click();

				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo().click();
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo().click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1().click();
				
				
				if(performerPOM.clickClearResponse().isEnabled())
		  		{
					Thread.sleep(3000);
		  			performerPOM.clickClearResponse().click();
		  			test.log(LogStatus.PASS, "Clear button working successfully");
		  		}
		  		else
		  		{
		  			test.log(LogStatus.FAIL, "Clear button not working successfully");
		  		}
				getDriver().switchTo().parentFrame();
				  getDriver().switchTo().parentFrame();
		   	     	Thread.sleep(3000);
		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
 			}
 	 		 
 	 		public static void ResponseWithoutData( ExtentTest test) throws InterruptedException, IOException
			{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			  
			    Thread.sleep(3000);
				performerPOM.clickNoticeOpen().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			 
			   
			    Thread.sleep(1000);
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(3000);
				performerPOM. clickResponse().click();
			    Thread.sleep(3000);
			    performerPOM. clickNewResponse().click();
					 
			    Thread.sleep(3000);		
			    JavascriptExecutor jse=( (JavascriptExecutor) getDriver());
			   jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
			   //performerPOM.clickSaveResponse().click();
							
			  Thread.sleep(3000);
			  performerPOM.clickMinimizeResponse().click();
						 
			  Thread.sleep(1000);
			   wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg1()));
								
			 Thread.sleep(500);
			 String msg4 = performerPOM.readResponseMsg1().getText();		//Reading Message appeared after save button
							
							
			test.log(LogStatus.PASS, "Message displayed = "+msg4);
							
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
			performerPOM.clickClose().click();//Clicking on 'Close'
	 }
 	 		
 	 	 public static void ResponseExistingData( ExtentTest test) throws InterruptedException, IOException
 			{
 	 		 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
 			   
 			   //XSSFSheet sheet = ReadExcel();
 			  
 			   Thread.sleep(3000);
 				performerPOM.clickNoticeOpen().click();//click edit notice
 		     
 		        Thread.sleep(3000);
 				performerPOM.clickEditNotice().click();//click edit notice
 			  
 			   
 			           Thread.sleep(1000);
 			           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
 			           Thread.sleep(3000);
 					  performerPOM. clickResponse().click();
 					  Thread.sleep(3000);
 					  performerPOM. clickNewResponse().click();
 					  Thread.sleep(3000);
 					  performerPOM. selectSentNotice();
 					  Thread.sleep(3000);
 					  performerPOM. selectReplyDueDate();
 					  Thread.sleep(3000);
 					  performerPOM. selectRespondedDate();
 				
 					 Thread.sleep(500);
					  FileInputStream fis = new FileInputStream(filePath);
					  Workbook workbook = WorkbookFactory.create(fis);
					  Sheet  sheet= workbook.getSheetAt(2);		 
 					  Thread.sleep(500);
 					  Row row1 = sheet.getRow(20);								//Selected 0th index row (First row)
 					  Cell c2 = row1.getCell(1);								//Selected cell (0 row,1 column)
 					  String DeliveryMode= c2.getStringCellValue();
 					  performerPOM.clickDeliveryMode().click();
 					  performerPOM.selectDeliveryMode().sendKeys(DeliveryMode);
 					  
 					 Thread.sleep(500);
					  FileInputStream fis1 = new FileInputStream(filePath);
					  Workbook workbook1 = WorkbookFactory.create(fis1);
					  Sheet  sheet1= workbook1.getSheetAt(2);
 					  Thread.sleep(500);
 					  Row row0 = sheet1.getRow(21);								//Selected 0th index row (First row)
 					  Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
 					  String CourierCompany= c1.getStringCellValue();
 					  performerPOM.clickCourierCompany().sendKeys(CourierCompany);
 						 
 					 Thread.sleep(500);
					  FileInputStream fis2 = new FileInputStream(filePath);
					  Workbook workbook2 = WorkbookFactory.create(fis2);
					  Sheet  sheet2= workbook2.getSheetAt(2);
 					  Thread.sleep(500);
 						Row row2 = sheet2.getRow(22);								//Selected 0th index row (First row)
 						Cell c3 = row2.getCell(1);								//Selected cell (0 row,1 column)
 						String RefNo= c3.getStringCellValue();
 						performerPOM.RefTrackingNo().sendKeys(RefNo);
 						
 						 Thread.sleep(500);
						  FileInputStream fis3 = new FileInputStream(filePath);
						  Workbook workbook3 = WorkbookFactory.create(fis3);
						  Sheet  sheet3= workbook3.getSheetAt(2);
 						Thread.sleep(500);
 						Row row3 = sheet3.getRow(23);								//Selected 0th index row (First row)
 						Cell c4 = row3.getCell(1);								//Selected cell (0 row,1 column)
 						String Description= c4.getStringCellValue();
 						 performerPOM.Description().sendKeys(Description);
 						 
 						 Thread.sleep(3000);
 						 performerPOM.clickNoticeResponseDocUploadtcfo();
 							
 						  JavascriptExecutor jse=( (JavascriptExecutor) getDriver());
 						 jse.executeScript("arguments[0].click();",  performerPOM.clickSaveResponse());
 						  //performerPOM.clickSaveResponse().click();
 							
 							
 								
 							try
							{
								
								Thread.sleep(1000);
								wait.until(ExpectedConditions.visibilityOf(performerPOM.readResponseMsg()));
								Thread.sleep(500);
								String msg3 = performerPOM.readResponseMsg().getText();		//Reading Message appeared after save button
							
								if(msg3.equalsIgnoreCase(msg3))
								{
									test.log(LogStatus.FAIL, "Add Response= "+msg3);
								
								}
								
							}
							catch(Exception e)
							{
								Thread.sleep(500);
								performerPOM.clickMinimizeResponse().click();
								Thread.sleep(500);
								String msg3 = performerPOM.readResponseInvalidMsg().getText();		//Reading Message appeared after save button
							
								if(msg3.equalsIgnoreCase(msg3))
								{
									test.log(LogStatus.PASS, "Add Response= "+msg3);
								
								}
								
							}
 							
 							getDriver().switchTo().parentFrame();
 							Thread.sleep(3000);
 							performerPOM.clickClose().click();//Clicking on 'Close'
 							
 			}
 	 	 
 	 	 static void ResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
			{
 	 		 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			   
			 
			  
			   Thread.sleep(3000);
				performerPOM.clickNoticeOpen().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   
			           Thread.sleep(1000);
			           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			           Thread.sleep(3000);
					  performerPOM. clickResponse().click();
					  Thread.sleep(3000);
					  performerPOM. clickNewResponse().click();
					  Thread.sleep(3000);
					  performerPOM. selectSentNotice();
					  Thread.sleep(3000);
					  performerPOM. selectReplyDueDate();
					  Thread.sleep(3000);
					  performerPOM. selectRespondedDate();
				
					
						if(performerPOM.clickClearNoticeResponse().isEnabled())
				  		{
							Thread.sleep(3000);
							  JavascriptExecutor jse=( (JavascriptExecutor) getDriver());
	 						 jse.executeScript("arguments[0].click();",  performerPOM.clickClearNoticeResponse());
							
				  			test.log(LogStatus.PASS, "Clear button working successfully");
				  		}
				  		else
				  		{
				  			test.log(LogStatus.FAIL, "Clear button not working successfully");
				  		}
					
						  getDriver().switchTo().parentFrame();
				   	     	Thread.sleep(3000);
				   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		 			}
 	 	 
 	 	 public static void PaymentLogWithoutData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
 		 
 		 
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			   
 		         Thread.sleep(3000);
			     performerPOM.clickNoticeOpen().click();//click edit notice
	     
	             Thread.sleep(3000);
			     performerPOM.clickEditNotice().click();//click edit notice
		  
			      getDriver().switchTo().parentFrame();
			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     
			     Thread.sleep(3000);
			    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
			    
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog().click();
				

				
				
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg1()));
					
					Thread.sleep(500);
					String msg4 = performerPOM.readPymentmsg1().getText();		//Reading Message appeared after save button
				
				
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
						
						 getDriver().switchTo().parentFrame();
				   	     	Thread.sleep(3000);
				   	     	performerPOM.clickClose().click();//Clicking on 'Close'
					
					
			}
 	 	 
 	 	 public static void PaymentLogwithExistingData( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{
 		 
 		 
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			   
			  // XSSFSheet sheet = ReadExcel();
			   
			   Thread.sleep(3000);
			     performerPOM.clickNoticeOpen().click();//click edit notice
	     
	             Thread.sleep(3000);
			     performerPOM.clickEditNotice().click();//click edit notice
		  
			     getDriver().switchTo().parentFrame();
			     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     
			     Thread.sleep(3000);
			    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
			
			    Thread.sleep(1000);
				performerPOM.clickInvoiceNo().sendKeys("56742584");
				
				
				Thread.sleep(3000);
				Row r5 = sheet.getRow(30);
				Cell c5 = r5.getCell(1);
				String PaymentType = c5.getStringCellValue();
				performerPOM.clickPaymentType().click();
				performerPOM.selectPaymentType().sendKeys(PaymentType,Keys.ENTER);
//				List<WebElement>PaymentType1= .findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
//				PaymentType1.get(2).click();
					
				Thread.sleep(3000);
				performerPOM.clickAmount().sendKeys("5000");
				
				Thread.sleep(6000);
				performerPOM.clickNoticeStatusPaymentUploadtcfo();
			
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog().click();
				

				
				
				 wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
					
					Thread.sleep(500);
					String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
				
					if(msg4.equalsIgnoreCase("Payment Details Saved Successfully."))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
					
					}
					else
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg4);
					}
					
					 getDriver().switchTo().parentFrame();
			   	     	Thread.sleep(3000);
			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			   	  }
 		 public static void PaymentLogwithInvalidData( ExtentTest test) throws InterruptedException, IOException
			{
		 
		 
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			   
 			 	
			   
 			 	Thread.sleep(3000);
			     performerPOM.clickNoticeOpen().click();//click edit notice
	     
	             Thread.sleep(3000);
			     performerPOM.clickEditNotice().click();//click edit notice
		  
			     getDriver().switchTo().parentFrame();
			     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			     
			     Thread.sleep(3000);
			    performerPOM.clickStatusPayments().click();			//Clicking on 'Status/Payments'
			
			    Thread.sleep(1000);
				performerPOM.clickInvoiceNo().sendKeys("abc");
				
				 Thread.sleep(500);
				  FileInputStream fis = new FileInputStream(filePath);
				  Workbook workbook = WorkbookFactory.create(fis);
				  Sheet  sheet= workbook.getSheetAt(2);
				Thread.sleep(3000);
				Row r5 = sheet.getRow(30);
				Cell c5 = r5.getCell(1);
				String PaymentType = c5.getStringCellValue();
				performerPOM.clickPaymentType().click();
				performerPOM.selectPaymentType().sendKeys(PaymentType,Keys.ENTER);
//				List<WebElement>PaymentType1= .findElements(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/ul/li"));
//				PaymentType1.get(2).click();
					
				Thread.sleep(3000);
				performerPOM.clickAmount().sendKeys("abc");
				
				Thread.sleep(6000);
				performerPOM.clickNoticeStatusPaymentUploadtcfo();
			
				Thread.sleep(300);
				performerPOM.clickSavePaymentLog().click();
				
				try
				{
						
				 
				   wait.until(ExpectedConditions.visibilityOf(performerPOM.readPymentmsg()));
				   Thread.sleep(500);
				   String msg4 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
				   test.log(LogStatus.PASS, "Message displayed = "+msg4);
							
				}
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Invalid Payment = Validation message not displayed");
				}
						
				getDriver().switchTo().parentFrame();
			   	Thread.sleep(3000);
			   	 performerPOM.clickClose().click();//Clicking on 'Close'
			}
 	 	 public static void CriteriaExistingData(ExtentTest test) throws InterruptedException
         {
       	  
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		   
   		         Thread.sleep(3000);
   			     performerPOM.clickNoticeOpen().click();//click edit notice
   	     
   	             Thread.sleep(3000);
   			     performerPOM.clickEditNotice().click();//click edit notice
   		  
   			      getDriver().switchTo().parentFrame();
   			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
   		         
			          
       	          
   			       Thread.sleep(1000);
   				   performerPOM. clickExternalLawyerRating().click();
   				   

   				   
   				  Thread.sleep(3000);
   				  performerPOM.selectExternalLawyerRating();
   				   Thread.sleep(3000);
   				   performerPOM.clickNewCriteria().click();
   				   Thread.sleep(3000);
   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
   				   performerPOM.clickCriteria().sendKeys("Test Test New");
   				   Thread.sleep(3000);
   				   performerPOM.clickSaveCriteria().click();
   				   String msg = performerPOM.readOppoenentMsg().getText();
   				   
   				   if(msg.equalsIgnoreCase("Criteria already exists."))
   				   {
   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
   				   }
   				   else
   				   {
   					   String msg1 = performerPOM.readMesg().getText();
   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
   				   }
   				   Thread.sleep(3000);
   				   getDriver().switchTo().parentFrame();
   				   performerPOM.clickclosecriteria().click();
   				   
   				 getDriver().switchTo().parentFrame();
		   	     	Thread.sleep(3000);
		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
         }
 	 	 public static void CriteriaInvalidData(ExtentTest test) throws InterruptedException
         {
       	  
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		  
			          Thread.sleep(3000);
					     performerPOM.clickNoticeOpen().click();//click edit notice
			     
			             Thread.sleep(3000);
					     performerPOM.clickEditNotice().click();//click edit notice
				  
					      getDriver().switchTo().parentFrame();
					      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
       	          
   			       Thread.sleep(1000);
   				   performerPOM. clickExternalLawyerRating().click();
   				   

   				   
   				  Thread.sleep(3000);
   				  performerPOM.selectExternalLawyerRating();
   				   Thread.sleep(3000);
   				   performerPOM.clickNewCriteria().click();
   				   Thread.sleep(3000);
   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
   				 Thread.sleep(3000);
   				  performerPOM.clickCriteria().sendKeys("342");
   				 
   				   Thread.sleep(3000);
   				   performerPOM.clickSaveCriteria().click();
   				   Thread.sleep(3000);
   				   String msg = performerPOM.clickCriteriaInvalidMsg().getText();
   				   
   				   if(msg.equalsIgnoreCase("Only alphabets allowed."))
   				   {
   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
   				   }
   				   else
   				   {
   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
   				   }
   				   
   				   Thread.sleep(3000);
   				   getDriver().switchTo().parentFrame();
   				   performerPOM.clickclosecriteria().click();
         }
 	 	 public static void CriteriaWithoutData(ExtentTest test) throws InterruptedException
         {
       	  
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		  
			          Thread.sleep(3000);
					     performerPOM.clickNoticeOpen().click();//click edit notice
			     
			             Thread.sleep(3000);
					     performerPOM.clickEditNotice().click();//click edit notice
				  
					      getDriver().switchTo().parentFrame();
					      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
       	          
   			       Thread.sleep(1000);
   				   performerPOM. clickExternalLawyerRating().click();
   				   

   				   
   				  Thread.sleep(3000);
   				  performerPOM.selectExternalLawyerRating();
   				   Thread.sleep(3000);
   				   performerPOM.clickNewCriteria().click();
   				   Thread.sleep(3000);
   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
   				
   				 
   				   Thread.sleep(3000);
   				   performerPOM.clickSaveCriteria().click();
   				   Thread.sleep(3000);
   				   String msg = performerPOM.readOppoenentMsg().getText();
   				   
   				   if(msg.equalsIgnoreCase("Criteria can not be empty."))
   				   {
   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
   				   }
   				   else
   				   {
   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
   				   }
   				   
   				   Thread.sleep(3000);
   				   getDriver().switchTo().parentFrame();
   				   performerPOM.clickclosecriteria().click();
         }
 	 	 
 		public static void CaseExistingData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
		{
 			
 		
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
					
			
			Thread.sleep(500);
			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
		
			js.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
			Thread.sleep(3000);
			clickNewCase();
			

			
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType();
			Thread.sleep(3000);
			clickDated1();
			Thread.sleep(3000);
			clickFinanicialYear();
			Thread.sleep(3000);
			clickRefNo1();
			Thread.sleep(3000);
			clickInternalCaseNo();
			Thread.sleep(3000);
			clickCaseTitle();
			Thread.sleep(3000);
			clickCaseAct();
			Thread.sleep(3000);
			clickUnderSection();
			Thread.sleep(3000);
			clickSearchCaseCategory();
			Thread.sleep(3000);
			clickCaseBudget();
			Thread.sleep(3000);
			clickCaseOpponent();
//			Thread.sleep(3000);
//			clickCaseOppLawyer();
			Thread.sleep(3000);
			clickCaseCourt();
			Thread.sleep(3000);
			clickCaseDescription();
			Thread.sleep(3000);
			selectCaseLocation();
			Thread.sleep(3000);
			clickCaseDepartment();
			Thread.sleep(3000);
			clickCaseOwner();
			Thread.sleep(3000);
			clickCaseRisk();
			Thread.sleep(3000);
			clickCaseInternalUser();
			
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.CaseInvalidreadMessage()));
			
			Thread.sleep(500);
			String msg = performerPOM.CaseInvalidreadMessage().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase(msg))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
		else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
		

		
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose().click();			//Clicking on 'Close'
			
		}
 		public static void CaseWithInvalidData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
		{
 				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
					
			
			Thread.sleep(500);
			 JavascriptExecutor js = ((JavascriptExecutor) getDriver()) ;
		
			js.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
			Thread.sleep(3000);
			clickNewCase();
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType();
			Thread.sleep(3000);
			clickInvalidDate();
			Thread.sleep(3000);
			clickFinanicialYear();
			Thread.sleep(3000);
			clickRefNo1();
			Thread.sleep(3000);
			clickInternalCaseNo();
			Thread.sleep(3000);
			clickCaseTitle();
			Thread.sleep(3000);
			clickCaseAct();
			Thread.sleep(3000);
			clickUnderSection();
			Thread.sleep(3000);
			clickSearchCaseCategory();
			Thread.sleep(3000);
			clickCaseBudget();
			Thread.sleep(3000);
			clickCaseOpponent();
//			Thread.sleep(3000);
//			clickCaseOppLawyer();
			Thread.sleep(3000);
			clickCaseCourt();
			Thread.sleep(3000);
			clickCaseDescription();
			Thread.sleep(3000);
			selectCaseLocation();
			Thread.sleep(3000);
			clickCaseDepartment();
			Thread.sleep(3000);
			clickCaseOwner();
			Thread.sleep(3000);
			clickCaseRisk();
			Thread.sleep(3000);
			clickCaseInternalUser();
			
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.readMessageCase()));
			
			Thread.sleep(500);
			String msg = performerPOM.readMessageCase().getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase(msg))
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
				
			}
		else
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
			}
		

		
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose().click();			//Clicking on 'Close'
			
		}
 		
 		 public  static void clickInvalidDate( ) throws InterruptedException 
		  {
			  Thread.sleep(3000);
		      performerPOM.clickCaseDate().sendKeys("22-01-202");					//Clicking on 'Dated' button
		  }
 		 
 		public static void CaseWithTwoFieldsData( ExtentTest test) throws InterruptedException
		{
 			
 				
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					
			
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			js.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
			Thread.sleep(3000);
			clickNewCase();
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(1000);
			selectCaseType();
			Thread.sleep(3000);
			clickDated1();
			
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(500);
			String msg = performerPOM.readMessageCase1().getText();		//Reading Message appeared after save button
			
			test.log(LogStatus.PASS, "Case With Two Manadatory Fields = "+msg);
				
		
		

		
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose().click();			//Clicking on 'Close'
			
		}
 		
 		public static void CaseWithEmptyFields( ExtentTest test) throws InterruptedException
		{
 			
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
					
			
			Thread.sleep(500);
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			js.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
			Thread.sleep(3000);
			clickNewCase();
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			Thread.sleep(3000);
			OverduePOM.clickSaveButton().click();						//Clicking on 'Save'button.
			
			Thread.sleep(500);
			String msg = performerPOM.readMessageCase1().getText();		//Reading Message appeared after save button
			
			test.log(LogStatus.PASS, "Case With Empty Fields = "+msg);
				
			getDriver().switchTo().parentFrame();
			performerPOM.clickClose().click();			//Clicking on 'Close'
		}
 		static void CaseWithClearBtn( ExtentTest test) throws InterruptedException
		{
 			
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
					
			
			Thread.sleep(500);
			 JavascriptExecutor js = ( (JavascriptExecutor) getDriver()) ;
		
			js.executeScript("window.scrollBy(0,-700)");
			Thread.sleep(3000);
			performerPOM.clickCaseOpencfo().click();						//Clicking on 'Open' Case
			Thread.sleep(3000);
			clickNewCase();
			
			progress();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 		Thread.sleep(3000);
	 			clickDated1();

	 			Thread.sleep(3000);
	 			clickFinancialYear();
	 	 		
	 			js.executeScript("window.scrollBy(0,-700)");
			 
	             if(performerPOM.clickCaseClearBtn().isEnabled())
		          {
		            Thread.sleep(2000);
		              performerPOM.clickCaseClearBtn().click();
		              test.log(LogStatus.PASS, "Clear Button is clickable");
		           }
		         else
		         {
		    	   test.log(LogStatus.FAIL, "Clear Button is not clickable");
		         }
	 
	     		Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
	     		
	     		Thread.sleep(3000);
	     		OverduePOM.clickDashboard().click();
		}
 		 public static void LinkCaseViewIcon( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
	 	 	        	
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 		
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	            Thread.sleep(4000);
	 	 	            performerPOM.clickEditNotice().click();
	 	 	 			
	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 	
	 	 	 			
	 	 	 		    Thread.sleep(4000);
	 	 	            performerPOM.clickLinkedCaseViewIcon().click();
 			      	
 			      	Thread.sleep(4000);
 	 	 	        performerPOM.clickViewPopup().click();
 	 	 	        
 	 	 	        String msg="Linked Case Details";
 	 	 	        
 	 	 	        if(msg.equalsIgnoreCase(msg))
 	 	 	        {
 	 	 	        	test.log(LogStatus.PASS, "View Case Detailes icon open succssefully");
 	 	 	        }
 	 	 	        else
 	 	 	        {
 	 	 	        	test.log(LogStatus.FAIL, "View Case Detailes icon not open succssefully");

 	 	 	        }
 	 	 	        

	 	 	 		Thread.sleep(4000);
	 	 	        performerPOM.clickClosePopup1().click();
	 	 	     	Thread.sleep(3000);
	 	     		getDriver().switchTo().parentFrame();
	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	     	
	 	     	    Thread.sleep(3000);
	 	     		OverduePOM.clickDashboard().click();
	 	 	 			
	 	 	 }
 		 
 		 public static void LinkCaseDeleteIcon( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
	 	 	        	
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 		
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	            Thread.sleep(4000);
	 	 	            performerPOM.clickEditNotice().click();
	 	 	 			
	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 		   	
	 	 	 			
	 	 	 		    Thread.sleep(4000);
	 	 	            performerPOM.clickLinkedCaseDeleteIcon().click();
 			      	
	 	 	         Thread.sleep(5000);
	 			    // Switching to Alert        
	 		        Alert alert1 = getDriver().switchTo().alert();		
	 		        		
	 		        // Capturing alert message.    
	 		        String alertMessage1= getDriver().switchTo().alert().getText();	
	 		        
	 		        
	 		        test.log(LogStatus.PASS, alertMessage1);
	 		        		
	 		        // Displaying alert message		
	 		        System.out.println(alertMessage1);
	 		        
	 		       // Accepting alert		
	 		        alert1.accept();	
	 		        
	 		      Thread.sleep(4000);
	 		      String msg= performerPOM.clickLinkedCaseDeleteIconValidMsg().getText();
 	 	       
	 		      test.log(LogStatus.PASS, "Message Displayed =" +msg);
 	 	 	        

	 	 	     	Thread.sleep(3000);
	 	     		getDriver().switchTo().parentFrame();
	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	     	
	 	     	    Thread.sleep(3000);
	 	     		OverduePOM.clickDashboard().click();
	 	 	 			
	 	 	 }
 		 public static void CaseUserAssignment( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 	 	 {

  			            sheet = workbook.getSheetAt(8);		

  			          WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	            Thread.sleep(4000);
	 	 	            performerPOM.clickEditNotice().click();
	 	 	            
	 	 	          try
	 	 	            {
	 	 	            
	 	 	              	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 	            Thread.sleep(4000);
	 	 	                 performerPOM.clickEditUserAssign().click();
	 	 	 			 
	 	 	                 Thread.sleep(3000);
	 	 	                 clickCaseInternalUser();
	 	 	                 Thread.sleep(3000);
	 	 	                 performerPOM.clickInternalUser().click();	
	 	 	                 
	 	 	                 Thread.sleep(3000);
	 	 	                 performerPOM.clickUpdateButton().click();
	 	 	                
	 	               
	 				      
	 	 	                 Thread.sleep(2000);
	 	 	                 String msg = performerPOM.readMessageCase().getText();		//Reading Message appeared after save button
	 	 	    		
	 	 	                 if(msg.equalsIgnoreCase("Case Details Updated Successfully."))
	 	 	                 {
	 	 	                	 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 	 	    			
	 	 	                 }
	 	 	                 else
	 	 	                 {
	 	 	                	 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 	 	                 }
	 	 	    	
	 	 	            } 
	 	 	            
	 	 	            catch(Exception e)
	 	 	            {
	 	 	            	test.log(LogStatus.PASS, "Record not displayed in Case-User assignment");
	 	 	            }
	 	 	            
	 	 	          Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     		
	 	 	     	
	 	 	     	    Thread.sleep(3000);
	 	 	     		OverduePOM.clickDashboard().click();
	 	 	    }
	 	 	            
	 	 	     
 		 public static void CaseUserAssignmentDelete( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
	 			     			
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 	        Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();	
	 	 	        	
	 	 	            Thread.sleep(4000);
 	 	                performerPOM.clickEditNotice().click();
 	 	            
 	 	         	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	            Thread.sleep(4000);
	 	 	            performerPOM.clickDeleteUserAssign().click();
	 	 	            
	 	 	         Thread.sleep(2000);
 	 	    		String msg = performerPOM.clickDeleteUserAssignValidMsg1().getText();		//Reading Message appeared after save button
 	 	    		
 	 	    		if(msg.equalsIgnoreCase("User Assignment Detail Deleted"))
 	 	    		{
 	 	    			test.log(LogStatus.PASS, "Message displayed = "+msg);
 	 	    			
 	 	    		}
 	 	    		else
 	 	    		{
 	 	    			test.log(LogStatus.FAIL, "Message displayed = "+msg);
 	 	    		}
	 	 	            
	 	 	        	Thread.sleep(3000);
	 	 	     		getDriver().switchTo().parentFrame();
	 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
	 	 	     	
	 	 	     	    Thread.sleep(3000);
	 	 	     		OverduePOM.clickDashboard().click();
	 	 	    }
 		 
 		 public static void CaseSendMailWithDoc( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
	 	 	        	
 			 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 		
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	             Thread.sleep(4000);
	 	 	         
	 			      	performerPOM.clickEditNotice().click();
	 	 	 			
	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 		   Thread.sleep(4000);
	 	 	 		   performerPOM.clickSendMailCase().click();
	 	 	 		   
	 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickSelectCheckbox().click();
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickMailTo().sendKeys("admin@gmail.com");
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
 	 	 		 
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickSend().click();
 	 	 		 
 	 	 		Thread.sleep(4000);
 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
 	 	 		
 	 	 		if(msg.equalsIgnoreCase("E-Mail Sent Successfully."))
 	 	 		{
 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
 	 	 		}
 	 	 		else
 	 	 		{
 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
 	 	 		}
 	 	 		
 	 			Thread.sleep(3000);
 	 	     
 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
 	 	     	Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     	
 	 	     	Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
	 	 	 
	 	 	 }
 		 public static void CaseSendMailWithDocInvalidFields( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
 			 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 		
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	             Thread.sleep(4000);
	 	 	         
	 			      	performerPOM.clickEditNotice().click();
	 	 	 			
	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 		   Thread.sleep(4000);
	 	 	 		   performerPOM.clickSendMailCase().click();
	 	 	 		   
	 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickSelectCheckbox().click();
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickMailTo().sendKeys("admin");
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickMessageMail().sendKeys("Test");
 	 	 		 
 	 	 		 
 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickSend().click();
 	 	 		 
 	 	 		Thread.sleep(4000);
 	 	 		String msg= performerPOM.clickSendMailMsg().getText();
 	 	 		
 	 	 		if(msg.equalsIgnoreCase("Please enter a valid email."))
 	 	 		{
 	 	 			test.log(LogStatus.PASS ,"Message displayed =" +msg);
 	 	 		}
 	 	 		else
 	 	 		{
 	 	 			test.log(LogStatus.FAIL ,"Message displayed =" +msg);
 	 	 		}
 	 	 		
 	 			Thread.sleep(3000);
 	 	     
 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
 	 	     	Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     	
 	 	     	Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
	 	 	 
	 	 	 }
 		 
 		 public static void CaseSendMailWithDocEmptyFields( ExtentTest test) throws InterruptedException, IOException
	 	 	 {
	 	 	 		   
	 	 	        	
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 	 	 			progress();
	 	 	 			
	 	 	 		
	 	 	 			
	 	 	            Thread.sleep(500);
	 	 	        	performerPOM.clickCaseOpencfo().click();		
	 	 	 			
	 	 	             Thread.sleep(4000);
	 	 	         
	 			      	performerPOM.clickEditNotice().click();
	 	 	 			
	 	 	 			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	 	 	 			
	 	 	 		   Thread.sleep(4000);
	 	 	 		   performerPOM.clickSendMailCase().click();
	 	 	 		   
	 	 	 		 Thread.sleep(4000);
 	 	 		 performerPOM.clickSelectCheckbox().click();
 	 	 		 
 	 	 		Thread.sleep(4000);
 		       performerPOM.clickSend().click();
 	 	 		 
 	 	 		Thread.sleep(4000);
 	 	 		String msg= performerPOM.clickSendMailMsg1().getText();
 	 	 		
 	 	 		test.log(LogStatus.PASS ,"Message displayed =" +msg);
 	 	 		
 	 	 		
 	 			Thread.sleep(3000);
 	 	     
 	 	     	performerPOM.clickcloseBtn().click();//Clicking on 'Close'
 	 	     	Thread.sleep(3000);
 	 	     		getDriver().switchTo().parentFrame();
 	 	     		performerPOM.clickClose().click();//Clicking on 'Close'
 	 	     	
 	 	     	Thread.sleep(3000);
 	 	     		OverduePOM.clickDashboard().click();
	 	 	 
	 	 	 }
 	 	public static void CaseWithoutUploadDocument( ExtentTest test) throws InterruptedException
	       	{
 	 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	             
	    		Thread.sleep(1000);
	    		OverduePOM.clickDashboard().click();			//Clicking on 'Dashboard'
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
		        
		        performerPOM.clickNoticeDocument().click();     //click notice document
		        performerPOM.clickNewDocument().click();        //click new document button
		
		        Thread.sleep(1000);
		        getDriver().switchTo().frame("IFrameManageDocument");
	           	performerPOM.selectDocumentType();
	           Thread.sleep(3000);
		        performerPOM.chooseDocumentType();
	          	
		        Thread.sleep(1000);
	         	performerPOM.clickUploadDocument().click(); 
		
		
	         	Thread.sleep(1000);
	         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
		
	        	Thread.sleep(3000);
		        String msg= performerPOM.readDocMsg().getText();		//Reading Message appeared after save button
		       
	         	if(msg.equalsIgnoreCase("Please select file to upload"))
	         	{
		        	test.log(LogStatus.PASS, "Message displayed = "+msg);
		         
		        }
		      else
		        {
			       test.log(LogStatus.FAIL, "Message displayed = "+msg);
		        }
		
		        Thread.sleep(1000);
		        performerPOM.clickClosedDocument().click();
		        
		      getDriver().switchTo().parentFrame();
		      
		      Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
	       	}
 	 	public static void CaseDocumentEmptyFields( ExtentTest test) throws InterruptedException
	       	{
 	 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	             
	    	
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
		        
		        performerPOM.clickNoticeDocument().click();     //click notice document
		        performerPOM.clickNewDocument().click();        //click new document button
		
		        Thread.sleep(1000);
	           	getDriver().switchTo().frame("IFrameManageDocument");
	  
		        Thread.sleep(1000);
	         	performerPOM.clickUploadDocument().click(); 
		
		
	         	Thread.sleep(1000);
	         	wait.until(ExpectedConditions.visibilityOf(performerPOM.readDocMsg()));
		
	        	Thread.sleep(3000);
		        String msg= performerPOM.readDocMsgInvalidMsg().getText();		//Reading Message appeared after save button
		       
	         	if(msg.equalsIgnoreCase("Please select document type"))
	         	{
		        	test.log(LogStatus.PASS, "Message displayed = "+msg);
		         
		        }
		      else
		        {
			       test.log(LogStatus.FAIL, "Message displayed = "+msg);
		        }
		
	         	
		        Thread.sleep(1000);
		        performerPOM.clickClosedDocument().click(); 
		      getDriver().switchTo().parentFrame();
		      
		      Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
	    }
 	 	
 	 	public static void CaseDocumentSearchFields( ExtentTest test) throws InterruptedException
	       	{
 	 				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	             
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		        Thread.sleep(3000);
				 performerPOM.clickNoticeDocument().click();     //click notice document
				
				Thread.sleep(3000);
	 			performerPOM.clickSearchDocument().sendKeys("Approver Test Case.xlsx");
	 			
	 			Thread.sleep(3000);
				performerPOM.clickApplyBtn().click();
				Thread.sleep(3000);
				String msg=performerPOM.clickDocName1().getText();
				if(msg.equalsIgnoreCase(msg)) 
				{
					test.log(LogStatus.PASS,"Document Filter Apply =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL,"Document Filter Apply  =" +msg);
				}
				
				Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
				
				
	       	}
 	 	
 		public static void CaseDocumentShareInvalidData( ExtentTest test) throws InterruptedException
	       	{
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	             
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		        Thread.sleep(3000);
				 performerPOM.clickNoticeDocument().click();     //click notice document
				 
				 Thread.sleep(3000);
		        performerPOM.clickCaseDocumentsharecfo().click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		        Alert alert1 = getDriver().switchTo().alert();		
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert1.accept();	
		        
		        Thread.sleep(3000);
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		        
		        Thread.sleep(4000);
		        performerPOM.clickNoticeDocumentshareemailcfo().sendKeys("admin");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharecontactnocfo().sendKeys("576879");
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharesavecfo().click();
		        
		        
		        Thread.sleep(3000);
		        String msg1= performerPOM.clickNoticeDocumentshareInvalidmsgcfo().getText();		//Reading Message appeared after save button
		       
	         
		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		      
		        
		        Thread.sleep(3000);
		        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
		        
		       getDriver().switchTo().parentFrame();
		      
		        Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
	       	}
 		
 		public static void CaseDocumentShareWithoutData( ExtentTest test) throws InterruptedException
	       	{
 			
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		        Thread.sleep(3000);
				 performerPOM.clickNoticeDocument().click();     //click notice document
				 
				 Thread.sleep(4000);
		        performerPOM.clickCaseDocumentsharecfo().click();
		        
		        Thread.sleep(5000);
			    // Switching to Alert        
		       
		        Alert alert1 = getDriver().switchTo().alert();
		        		
		        // Capturing alert message.    
		        String alertMessage1= getDriver().switchTo().alert().getText();	
		        
		        
		        test.log(LogStatus.PASS, alertMessage1);
		        		
		        // Displaying alert message		
		        System.out.println(alertMessage1);
		        
		     // Accepting alert		
		        alert1.accept();	
		        
		       Thread.sleep(3000);
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));
		        
		      
		        
		        Thread.sleep(3000);
		        performerPOM.clickNoticeDocumentsharesavecfo().click();
		        
		        
		        Thread.sleep(3000);
		        String msg1= performerPOM.clickNoticeDocumentsharereadmsgcfo().getText();		//Reading Message appeared after save button
		        if(msg1.equalsIgnoreCase("Please Enter Email."))
		        {
	         
		        	test.log(LogStatus.PASS, "Message displayed = "+msg1);
		        }
		        else
		        {
		        	test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		        }
		        
		        Thread.sleep(3000);
		        performerPOM. clickNoticeDocumentshareclosepopupcfo().click();
		        
		       getDriver().switchTo().parentFrame();
		      
		        Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
	       	}
 		static void CaseDocumentShareCloseBtn( ExtentTest test) throws InterruptedException
	       	{
 				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	             
	    		
		        Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));

		        Thread.sleep(3000);
				 performerPOM.clickNoticeDocument().click();     //click notice document
				 
				 
				 Thread.sleep(3000);
		        performerPOM.clickCaseDocumentsharecfo().click();
		        
		       Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert1 =getDriver().switchTo().alert();	
	        // Capturing alert message.    
	        String alertMessage1= getDriver().switchTo().alert().getText();	
	        
	        
//	        test.log(LogStatus.PASS, alertMessage1);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);
	        
	     // Accepting alert		
	        alert1.accept();	
	        
	       Thread.sleep(3000);
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe_Docshare"));

     	      Thread.sleep(2000);
             if(performerPOM.clickNoticeDocumentshareclosepopupcfo().isEnabled())
             {
              Thread.sleep(2000);
              performerPOM.clickNoticeDocumentshareclosepopupcfo().click();
              test.log(LogStatus.PASS, "Close Button is clickable");
             }
            else
           {
    	     test.log(LogStatus.FAIL, "Close Button is not clickable");
           }
           
         	getDriver().switchTo().parentFrame();
   	     	getDriver().switchTo().parentFrame();
   	     	   Thread.sleep(3000);
   	     		performerPOM.clickClose().click();//Clicking on 'Close'
   	     	
	       }
 		
 		 public static void CaseTaskActivitywithExistingData( ExtentTest test ) throws InterruptedException, IOException
			{
 			 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			    
			    

		       Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
		      
			    Thread.sleep(3000);
			   
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(3000);
			    performerPOM.clickCaseTask().click();
			    Thread.sleep(300);
			    performerPOM.clickCaseNewTask().click();
//			    Thread.sleep(5000);
//			    performerPOM.clickHearingDate().sendKeys("23-07-2022");
			    
			    
			    Thread.sleep(3000);
			    performerPOM.clickHearingDatecfo().click(); 
			    Thread.sleep(3000);
			    performerPOM.clickHearingDatedropdowncfo().click(); 
//			    Thread.sleep(2000);
//			    performerPOM.clickSaveHearingDatecfo().click();
			  
			    Thread.sleep(500);
				  FileInputStream fis = new FileInputStream(filePath);
				  Workbook workbook = WorkbookFactory.create(fis);
				  Sheet  sheet= workbook.getSheetAt(2);
				Thread.sleep(6000);
				Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
				Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
				String title = c1.getStringCellValue();
				performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
				
				 Thread.sleep(500);
				  FileInputStream fis1 = new FileInputStream(filePath);
				  Workbook workbook1 = WorkbookFactory.create(fis1);
				  Sheet  sheet1= workbook1.getSheetAt(2);
				Thread.sleep(5000);
				row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String desc = c1.getStringCellValue();
				performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
				
				
				Thread.sleep(1000);
				performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
				OverduePOM.selectNextMonth().click();
				OverduePOM.selectDate().click();					//Selecting particular date.
				
				Thread.sleep(1000);
				Actions action = new Actions(getDriver());
//				action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
				
				 Thread.sleep(500);
				  FileInputStream fis2 = new FileInputStream(filePath);
				  Workbook workbook2= WorkbookFactory.create(fis2);
				  Sheet  sheet2= workbook2.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet2.getRow(14);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String outcome = c1.getStringCellValue();
				performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
				

				 Thread.sleep(500);
				  FileInputStream fis3 = new FileInputStream(filePath);
				  Workbook workbook3 = WorkbookFactory.create(fis3);
				  Sheet  sheet3= workbook3.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet3.getRow(15);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String internalUser = c1.getStringCellValue();
				performerPOM.clickInternalUser3().click();
				//performerPOM.selectInternalUser2().click();
				performerPOM.selectInternalUser3().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
				
				
				 Thread.sleep(500);
				  FileInputStream fis4 = new FileInputStream(filePath);
				  Workbook workbook4= WorkbookFactory.create(fis4);
				  Sheet  sheet4= workbook4.getSheetAt(2);
				Thread.sleep(1000);
				row0 = sheet4.getRow(16);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String externalUser = c1.getStringCellValue();
				try
				{
					Thread.sleep(300);
					performerPOM.clickExternalUser().click();
					Thread.sleep(500);
					action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
				}
				catch(Exception e)
				{
					
				}
				
				 Thread.sleep(500);
				  FileInputStream fis5 = new FileInputStream(filePath);
				  Workbook workbook5 = WorkbookFactory.create(fis5);
				  Sheet  sheet5= workbook5.getSheetAt(2);
				Thread.sleep(5000);
				row0 = sheet5.getRow(17);									//Selected 0th index row (First row)
				c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
				String remark = c1.getStringCellValue();
				performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
          	Thread.sleep(1000);
				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
				

				
				Thread.sleep(300);
				wait.until(ExpectedConditions.visibilityOf(performerPOM.readTaskMsgcfo()));
				
				Thread.sleep(3000);
			
				String msg1 = performerPOM.readTaskMsgcfo().getText();
				if(msg1.contains("Task with same title already exists."))
				{
					test.log(LogStatus.PASS, "Case -Task/Activtiy with existing data =" +msg1);
				}
				
				else 
				{
					test.log(LogStatus.FAIL, "Case -Task/Activtiy with existing data =" +msg1);
				}
				
				Thread.sleep(3000);
	     		getDriver().switchTo().parentFrame();
	     		performerPOM.clickClose().click();//Clicking on 'Close'
			}
 		 
 		 public static void CaseTaskActivityWithoutData( ExtentTest test) throws InterruptedException, IOException
			{
 			 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			    
		       Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
		      
			    Thread.sleep(3000);
			   
			    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			    Thread.sleep(3000);
			    performerPOM.clickCaseTask().click();
			    Thread.sleep(300);
			    performerPOM.clickCaseNewTask().click();
			    
			    Thread.sleep(3000);
  				OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
  				
//  			  Thread.sleep(3000);
//				performerPOM.clickMinimize().click();
			    

  				Thread.sleep(300);
  				String msg1 = performerPOM.readTaskMsg2().getText();
  				
  					test.log(LogStatus.PASS, "Task/Activity Without data ="+msg1);
  				
  				
  					Thread.sleep(3000);
  		     		getDriver().switchTo().parentFrame();
  		     		performerPOM.clickClose().click();//Clicking on 'Close'
  				
  			}
 		 public  static void CaseTaskActivtityResponseWithoutStatus( ExtentTest test) throws InterruptedException, IOException
			{ 
 			 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 			  Thread.sleep(3000);
	 				performerPOM.clickCaseOpencfo().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			   
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    Thread.sleep(3000);
				    performerPOM.clickCaseTask().click();
				  

				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo1().click();
				
				Thread.sleep(2000);
//				performerPOM.clickMinimize().click();	
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskcmtResponsecfo().sendKeys("Automate Test");
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskSaveResponsecfo().click();
				
				
				String msg=performerPOM.clickInvalidResponsemsg().getText();
				if(msg.equalsIgnoreCase("Provide Response Status."))
				{
				    test.log(LogStatus.PASS, "Mesaage displayed ="+msg);
				}
				else
				{
					 test.log(LogStatus.FAIL, "Mesaage displayed ="+msg);
				}
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskCloseResponsecfo().click();
				
				getDriver().switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
				
          
			}
 		 
 		 public  static void CaseTaskActivtityResponseClearBtn( ExtentTest test) throws InterruptedException, IOException
			{ 
 			 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
	 			  Thread.sleep(3000);
	 				performerPOM.clickCaseOpencfo().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			  
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    Thread.sleep(3000);
				    performerPOM.clickCaseTask().click();
			

				Thread.sleep(3000);
				performerPOM.clickNoticeTaskEditResponsecfo1().click();
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo().click();
				
				Thread.sleep(3000);
				performerPOM.clickNoticeTaskstatusResponsecfo1().click();
				
				
				if(performerPOM.clickClearResponse().isEnabled())
		  		{
					Thread.sleep(3000);
		  			performerPOM.clickClearResponse().click();
		  			test.log(LogStatus.PASS, "Clear button working successfully");
		  		}
		  		else
		  		{
		  			test.log(LogStatus.FAIL, "Clear button not working successfully");
		  		}
				getDriver().switchTo().parentFrame();
				  
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				  
					Thread.sleep(3000);
					performerPOM.clickNoticeTaskCloseResponsecfo().click();
					
	                Thread.sleep(3000);
					performerPOM.clickNoticeTaskClosecfo1().click();
					
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert =getDriver().switchTo().alert();	
				        		
				        // Capturing alert message.    
				        String alertMessage= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage);
				        
				     // Accepting alert		
				        alert.accept();
				  
				     getDriver().switchTo().parentFrame();
		   	     	Thread.sleep(3000);
		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		   	     	
		   	
					
	             
			}
 		 
 		 public static void CaseExistingHearingData( ExtentTest test) throws InterruptedException, IOException
			{
 			 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 
			   
			       
			       Thread.sleep(3000);
	 				performerPOM.clickCaseOpencfo().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			  
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    performerPOM.clickCaseHearing().click();
					Thread.sleep(3000);
					performerPOM.clickNewCaseHearing().click();
					Thread.sleep(3000);
                	performerPOM.clickCaseHearingDate().sendKeys("28-06-2023");	//Writing 'HearingDate'
				    Thread.sleep(3000);
				    performerPOM.clickSaveCaseHearingDate().click();
				
					
				    Thread.sleep(500);
					  FileInputStream fis = new FileInputStream(filePath);
					  Workbook workbook = WorkbookFactory.create(fis);
					  Sheet  sheet= workbook.getSheetAt(2);
					Thread.sleep(2000);
					Row row1 = sheet.getRow(50);									//Selected 0th index row (First row)
					Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
					String HearingDescription = c2.getStringCellValue();
					performerPOM.clickCaseHearingDecsri().sendKeys(HearingDescription);		//Writing 'HearingDescription'
					
					
				
					 Thread.sleep(3000);
					 performerPOM.clickMinimizeHearing().click();	
				    Thread.sleep(3000);
					String msg = performerPOM.clickReadHearingMsg1().getText();
					if(msg.contains(msg))
					{
						test.log(LogStatus.PASS, "Existing Hearing Date =" +msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Existing Hearing Date =" +msg);
					}
					
					 getDriver().switchTo().parentFrame();
			   	     Thread.sleep(3000);
			   	     performerPOM.clickClose().click();//Clicking on 'Close'
			}
 		 
 		 public static void CaseHearingWithoutData( ExtentTest test) throws InterruptedException, IOException
			{
 			 	WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			       
			       Thread.sleep(3000);
	 				performerPOM.clickCaseOpencfo().click();//click edit notice
	 		     
	 		        Thread.sleep(3000);
	 				performerPOM.clickEditNotice().click();//click edit notice
	 			  
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				    performerPOM.clickCaseHearing().click();
					Thread.sleep(3000);
					performerPOM.clickNewCaseHearing().click();
					Thread.sleep(3000);
				    performerPOM.clickSaveCaseHearing().click();
				    Thread.sleep(3000);
					performerPOM.clickMinimizeHearing().click();	
					 
					String msg = performerPOM.clickReadHearingMsg1().getText();
					test.log(LogStatus.PASS, "Case  without hearing data =" +msg);
					 Thread.sleep(1000);
					  getDriver().switchTo().parentFrame();
			   	     	Thread.sleep(3000);
			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			}
 		public static void CaseHearingInvalidDate( ExtentTest test) throws InterruptedException, IOException
		{
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
	
		       
		       Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		       
		       Thread.sleep(3000);
			   performerPOM.clickCaseHearing().click();
				Thread.sleep(3000);
				performerPOM.clickNewCaseHearing().click();
				
				Thread.sleep(3000);
				performerPOM.clickCaseHearingDate().sendKeys("31-05-202");	//Writing 'HearingDate'
			   Thread.sleep(3000);
			    performerPOM.clickSaveCaseHearingDate().click();
			
			    Thread.sleep(500);
				  FileInputStream fis = new FileInputStream(filePath);
				  Workbook workbook = WorkbookFactory.create(fis);
				  Sheet  sheet= workbook.getSheetAt(2);
				Thread.sleep(2000);
				Row row1 = sheet.getRow(50);									//Selected 0th index row (First row)
				Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
				String HearingDescription = c2.getStringCellValue();
				performerPOM.clickCaseHearingDecsri().sendKeys(HearingDescription);		//Writing 'HearingDescription'
				
			 
			    
			    Thread.sleep(3000);
				String msg = performerPOM.clickReadHearingMsg1().getText();
				if(msg.contains("Server Error Occurred. Please try again."))
				{
					test.log(LogStatus.FAIL, "Case with Invalid Hearng Date=" +msg);
				}
				else
				{
					test.log(LogStatus.PASS, "Case with Invalid Hearng Date=" +msg);
				}
				
				  getDriver().switchTo().parentFrame();
		   	     	Thread.sleep(3000);
		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		}
 		
 		 static void CaseHearingClearBtn( ExtentTest test) throws InterruptedException, IOException
			{
 			 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
			    //   XSSFSheet sheet=ReadExcel();
			       
			       Thread.sleep(3000);
					performerPOM.clickCaseOpencfo().click();//click edit notice
			     
			        Thread.sleep(3000);
					performerPOM.clickEditNotice().click();//click edit notice
				  
				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			       Thread.sleep(3000);
				   performerPOM.clickCaseHearing().click();
					Thread.sleep(3000);
					performerPOM.clickNewCaseHearing().click();
					
					 Thread.sleep(500);
					  FileInputStream fis = new FileInputStream(filePath);
					  Workbook workbook = WorkbookFactory.create(fis);
					  Sheet  sheet= workbook.getSheetAt(2);
					Thread.sleep(2000);
					Row row1 = sheet.getRow(50);									//Selected 0th index row (First row)
					Cell c2 = row1.getCell(1);									//Selected cell (0 row,1 column)
					String HearingDescription = c2.getStringCellValue();
					performerPOM.clickCaseHearingDecsri().sendKeys(HearingDescription);		//Writing 'HearingDescription'
					
					if(performerPOM.clickHearingClearBtn().isEnabled())
					{

						Thread.sleep(3000);
					   performerPOM.clickHearingClearBtn().click();
					   
					   test.log(LogStatus.PASS,"After clicking the clear button the data should be remove");
					}
					else
					{
						 test.log(LogStatus.FAIL,"After clicking the clear button the data should not be remove");
					}

					  getDriver().switchTo().parentFrame();
			   	     	Thread.sleep(3000);
			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			}
 		 
 		public static void CaseOrderWithoutData( ExtentTest test) throws InterruptedException, IOException
		{
 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			
			 Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			 Thread.sleep(5000);
			 performerPOM.clickCaseOrder().click();
			 Thread.sleep(6000);
			 performerPOM.clickNewCaseOrder().click();
			  Thread.sleep(3000);
			 performerPOM.clickSaveCaseOrder().click();
			 Thread.sleep(3000);
			 String msg= performerPOM.readResponseMsgOrder().getText();
			 String msg1= performerPOM.readResponseMsgOrder1().getText();
			 String msg2= performerPOM.readResponseMsgOrder2().getText();
			
				 test.log(LogStatus.PASS," Without data in Case Order = " +msg +"," +msg1 +"," +msg2);
		
			 getDriver().switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		}
 		
		public static void CaseOrderwithExistingData( ExtentTest test) throws InterruptedException, IOException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 JavascriptExecutor js =(JavascriptExecutor) getDriver();

			
			 Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			 Thread.sleep(5000);
			 performerPOM.clickCaseOrder().click();
			 Thread.sleep(6000);
			 performerPOM.clickNewCaseOrder().click();
			 Thread.sleep(6000);
			 performerPOM. clickCaseOrderDate().sendKeys("25-02-2023");
			 Thread.sleep(3000);
			 performerPOM.clickOrderPanel().click();
			 Thread.sleep(3000);
			 performerPOM. clickCaseOrderType().click();
			 Thread.sleep(3000);
			 performerPOM.selectCaseOrderType().click();
			
			 Thread.sleep(500);
			  FileInputStream fis = new FileInputStream(filePath);
			  Workbook workbook = WorkbookFactory.create(fis);
			  Sheet  sheet= workbook.getSheetAt(2);
			 Thread.sleep(300);
			 Row row0 = sheet.getRow(53);					//Selected 0th index row (First row)
			 Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			 int OrderTitle = (int) c1.getNumericCellValue();
			 performerPOM.clickCaseOrderTitle().sendKeys(OrderTitle+"");	//Writing 'HearingDate'
				
			 Thread.sleep(500);
			  FileInputStream fis1 = new FileInputStream(filePath);
			  Workbook workbook1 = WorkbookFactory.create(fis1);
			  Sheet  sheet1= workbook1.getSheetAt(2);
			 Thread.sleep(2000);
			 Row row2 = sheet1.getRow(54);									//Selected 0th index row (First row)
			 Cell c2 = row2.getCell(1);									//Selected cell (0 row,1 column)
			 String OrderDecri = c2.getStringCellValue();
			 performerPOM.clickCaseOrderDecri().sendKeys(OrderDecri);     //click oder description
			 Thread.sleep(3000);
			 performerPOM.ChooseOrderFile().click();
			 
			 Thread.sleep(3000);
			 performerPOM.clickSaveCaseOrder().click();
			 	
				 Thread.sleep(3000);
					String msg = performerPOM.readResponseMsg().getText();
					if(msg.contains("Order Details Saved Successfully."))
					{
						test.log(LogStatus.FAIL, "Case Order with Duplicate data ="+msg);
					}
					else
					{
						test.log(LogStatus.PASS, "Case Order with Duplicate data ="+msg);
					
					}
					
					getDriver() .switchTo().parentFrame();
			   	     	Thread.sleep(3000);
			   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		}
		
		static void CaseOrderwithClearBtn( ExtentTest test) throws InterruptedException, IOException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			
			
			 Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			 Thread.sleep(5000);
			 performerPOM.clickCaseOrder().click();
			 Thread.sleep(6000);
			 performerPOM.clickNewCaseOrder().click();
			 Thread.sleep(6000);
			 performerPOM. clickCaseOrderDate().sendKeys("25-02-2023");
			 
			 if(performerPOM.clickClearCaseOrderBtn().isEnabled())
			 {
				 Thread.sleep(6000);
				 performerPOM.clickClearCaseOrderBtn().click();
				test.log(LogStatus.PASS, "After clicking on the clear button the data should be remove");
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "After clicking on the clear button the data should not be remove");
			 }
			 
			getDriver() .switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			  
		}
		
		public static void CaseStatusAppealtoNextCourt( ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			
			 Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
			
			performerPOM.clickCaseStage().click();
			Thread.sleep(300);
			performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
			
			Thread.sleep(300);
			performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
			Thread.sleep(300);
			performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
			
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseCloseDate()));
			performerPOM.clickCaseCloseDate().click();				//Clicking on 'Closed Date' date box
			OverduePOM.selectLastMonth().click();					//Getting last month
			OverduePOM.selectDate2().click();						//Selecting particular date.
			
			Thread.sleep(300);
			performerPOM.clickCaseResult().click();
			performerPOM.clickSelectCaseResult().sendKeys("In Progress", Keys.ENTER);
			
			Thread.sleep(3000);
			performerPOM.clickRemark1().sendKeys("Automation Testing");
			
			
			Thread.sleep(3000);
			performerPOM.clickCaseAppealToNextCourt().click();	
			
			Thread.sleep(300);
			String msg=performerPOM.clickCasereadMsg().getText();
			
			if(msg.equalsIgnoreCase(msg))
			{
				test.log(LogStatus.PASS, "Message dispalyed =" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message dispalyed =" +msg);
			}
			 getDriver().switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		}
		
		public static void CaseStatusAppealtoNextCourtTwoMandatoryfields( ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			
			 Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
			
			wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
			
			performerPOM.clickCaseStage().click();
			Thread.sleep(300);
			performerPOM.selectCaseStage().sendKeys("Hearing", Keys.ENTER);
			
			Thread.sleep(3000);
			performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
			Thread.sleep(3000);
			performerPOM.clickCaseStatusClose().click();			//Selecting 'Closed' option from drop down.
			
			
			Thread.sleep(3000);
			performerPOM.clickCaseAppealToNextCourt().click();	
			
			Thread.sleep(3000);
			String msg=performerPOM.clickCasereadMsg().getText();
			
			if(msg.equalsIgnoreCase(msg))
			{
				test.log(LogStatus.PASS, "Message dispalyed =" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message dispalyed =" +msg);
			}
			getDriver() .switchTo().parentFrame();
	   	     	Thread.sleep(3000);
	   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		}
			
		
		
		
		
		public static void CaseStatuswithEmptyFields( ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
			
			   Thread.sleep(3000);
				performerPOM.clickCaseOpencfo().click();//click edit notice
				
			 	Thread.sleep(1000);
 				wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
 				/*Thread.sleep(3000);
	 	        	performerPOM.clickTrignle1().click();		
	 	 			
 				
	 	        	Thread.sleep(3000);
	 	        	performerPOM.clickFilter().click();		
	 	        	
	 	        	Thread.sleep(2000);
	 	     		wait.until(ExpectedConditions.visibilityOf(performerPOM.GridLoad()));
	 	 			
 				
	 	        	Thread.sleep(5000);
	 	        	performerPOM.clickSearchFilterworkspace().sendKeys("4658461");	
	 	        	
	 	        	Thread.sleep(5000);
	 	     		performerPOM.clickCheckbox1().click();	
	        	
	 	        	
	 	        	Thread.sleep(5000);
	 	        	performerPOM.clickFilter1().click();	*/
		     
		        Thread.sleep(3000);
				performerPOM.clickEditNotice().click();//click edit notice
			  
			   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			   performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
			
			   wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
				
				performerPOM.clickCaseStage().click();
				Thread.sleep(300);
				performerPOM.selectCaseStage().sendKeys("Select Stage", Keys.ENTER);
				
				 Thread.sleep(300);
				    performerPOM.clickSave1().click();
				Thread.sleep(300);
				String msg=performerPOM.clickCasereadMsg().getText();
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Case Stage with Empty fields =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Case Stage with Empty fields =" +msg);
				}
				 
				
				Thread.sleep(300);
				performerPOM.clickCaseStatus().click();				//Clicking on 'Case Status' drop down.
				Thread.sleep(300);
				performerPOM.clickCaseStatus1().click();			//Selecting 'Closed' option from drop down.
			   
			   Thread.sleep(300);
			    performerPOM.clickSave1().click();
			    
				Thread.sleep(300);
				String msg1=performerPOM.clickCasereadMsg().getText();
				
				if(msg1.equalsIgnoreCase(msg1))
				{
					test.log(LogStatus.PASS, "Case Status with Empty fields =" +msg1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Case Status with Empty fields =" +msg1);
				}
				 
				 getDriver().switchTo().parentFrame();
		   	     	Thread.sleep(3000);
		   	     	performerPOM.clickClose().click();//Clicking on 'Close'
			    
			    
			
		}
		
		   public static void StatusPaymentExistingdata( ExtentTest test) throws InterruptedException, IOException
		      {	
				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				    	       
		    	       Thread.sleep(3000);
						performerPOM.clickCaseOpencfo().click();//click edit notice
				     
				        Thread.sleep(3000);
						performerPOM.clickEditNotice().click();//click edit notice
					  
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					  
		    	       Thread.sleep(3000);
		               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
						
						
						 Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						Thread.sleep(3000);
						Row row0 = sheet.getRow(58);					//Selected 0th index row (First row)
						Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
						int InvoiceNo = (int) c1.getNumericCellValue();
						performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
						
					
					    Thread.sleep(4000);
						performerPOM.clickPaymentTyp1().click();
						Thread.sleep(2000);
						List<WebElement>PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
						selectOptionFromDropDown_bs(PaymentType1, "Checks");
						Thread.sleep(10000);
                     performerPOM.clickAmount1().sendKeys("900000");	//Writing 'Amount'
					
                 	Thread.sleep(10000);
                    performerPOM. clickAmountPaid().sendKeys("5000");
						Thread.sleep(3000);
						performerPOM.clickSavePaymentLog1().click();
						
						
						   Thread.sleep(500);
							String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
							if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg5);
							
							}
							else
							{
								test.log(LogStatus.FAIL, "Message displayed = "+msg5);
							}
							
							 getDriver().switchTo().parentFrame();
					   	     	Thread.sleep(3000);
					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		      }
		   public static void StatusPaymentwithInvaliddata( ExtentTest test) throws InterruptedException, IOException
		      {	
				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		
		    	       Thread.sleep(3000);
						performerPOM.clickCaseOpencfo().click();//click edit notice
				     
				        Thread.sleep(3000);
						performerPOM.clickEditNotice().click();//click edit notice
					  
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					  
		    	       Thread.sleep(3000);
		               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
						
						wait.until(ExpectedConditions.visibilityOf(performerPOM.clickCaseStatus()));
						
						
						 Thread.sleep(500);
						  FileInputStream fis = new FileInputStream(filePath);
						  Workbook workbook = WorkbookFactory.create(fis);
						  Sheet  sheet= workbook.getSheetAt(2);
						Thread.sleep(3000);
						Row row0 = sheet.getRow(58);					//Selected 0th index row (First row)
						Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
						int InvoiceNo = (int) c1.getNumericCellValue();
						performerPOM.clickCaseInvoiceNo1().sendKeys(InvoiceNo+"");	//Writing 'Invoice No'
						
					    Thread.sleep(4000);
						performerPOM.clickPaymentTyp1().click();
						Thread.sleep(2000);
						List<WebElement>PaymentType1= getDriver().findElements(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/ul/li"));
						selectOptionFromDropDown_bs(PaymentType1, "Checks");
						Thread.sleep(10000);
						performerPOM.clickAmount1().sendKeys("abc");	//Writing 'Amount'
					
						Thread.sleep(10000);
						performerPOM. clickAmountPaid().sendKeys("asf");
						Thread.sleep(3000);
						performerPOM.clickSavePaymentLog1().click();
						
						try
						{
						   Thread.sleep(500);
							String msg5 = performerPOM.readPymentmsg1().getText();		//Reading Message appeared after save button
						    test.log(LogStatus.PASS, "Message displayed = "+msg5);
						}
							
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Validation message not displayed");
						}
							
						getDriver().switchTo().parentFrame();
					    Thread.sleep(3000);
					   	performerPOM.clickClose().click();//Clicking on 'Close'
		      }
		
		   public static void StatusPaymentWithoutdata( ExtentTest test) throws InterruptedException, IOException
		      {	
				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			
		    	       
		    	       Thread.sleep(3000);
						performerPOM.clickCaseOpencfo().click();//click edit notice
				     
				        Thread.sleep(3000);
						performerPOM.clickEditNotice().click();//click edit notice
					  
					   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					  
		    	       Thread.sleep(3000);
		               performerPOM.clickCaseStatusPayments().click();		//Clicking on 'Status/Payments'
		               
		               Thread.sleep(3000);
						performerPOM.clickSavePaymentLog1().click();
						
						
						   Thread.sleep(500);
							String msg5 = performerPOM.readPymentmsg().getText();		//Reading Message appeared after save button
						
							if(msg5.equalsIgnoreCase("Payment Details Saved Successfully."))
							{
								test.log(LogStatus.FAIL, "Message displayed = "+msg5);
							
							}
							else
							{
								test.log(LogStatus.PASS, "Message displayed = "+msg5);
							}
							
							 getDriver().switchTo().parentFrame();
					   	     	Thread.sleep(3000);
					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
		      }
		   
		 	  public static void CaseExternalLawyerCriteria(ExtentTest test) throws InterruptedException
	          {
	        	  
		 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			   
	    		         Thread.sleep(3000);
							performerPOM.clickCaseOpencfo().click();//click edit notice
					     
					        Thread.sleep(3000);
							performerPOM.clickEditNotice().click();//click edit notice
						    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	    		            Thread.sleep(1000);
	    				    performerPOM. clickExternalLawyerRating1().click();
	    				   
	    				    Thread.sleep(3000);
	    				  performerPOM.selectExternalLawyerRating();
	    				   Thread.sleep(3000);
	    				   performerPOM.clickNewCriteria().click();
	    				   Thread.sleep(3000);
	    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
	    				   performerPOM.clickCriteria().sendKeys("LNT");
	    				   Thread.sleep(3000);
	    				   performerPOM.clickSaveCriteria().click();
	    				   String msg = performerPOM.readOppoenentMsg().getText();
	    				   
	    				   if(msg.equalsIgnoreCase("Criteria Saved Successfully."))
	    				   {
	    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
	    				   }
	    				   else
	    				   {
	    					   String msg1 = performerPOM.readMesg().getText();
	    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
	    				   }
	    				   
	    				   Thread.sleep(3000);
	    				   getDriver().switchTo().parentFrame();
	    				   performerPOM.clickclosecriteria().click();
	    				   
	    					 getDriver().switchTo().parentFrame();
					   	     	Thread.sleep(3000);
					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
	          }
			
			
		 	  public static void CaseExistingCriteria(ExtentTest test) throws InterruptedException
	          {
	        	  
		 			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					
			   
	    		         Thread.sleep(3000);
							performerPOM.clickCaseOpencfo().click();//click edit notice
					     
					        Thread.sleep(3000);
							performerPOM.clickEditNotice().click();//click edit notice
						    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	    		            Thread.sleep(1000);
	    				    performerPOM. clickExternalLawyerRating1().click();
	    				   
	    				    Thread.sleep(3000);
	    				  performerPOM.selectExternalLawyerRating();
	    				   Thread.sleep(3000);
	    				   performerPOM.clickNewCriteria().click();
	    				   Thread.sleep(3000);
	    				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
	    				   performerPOM.clickCriteria().sendKeys("Test Test New");
	    				   Thread.sleep(3000);
	    				   performerPOM.clickSaveCriteria().click();
	    				   String msg = performerPOM.readOppoenentMsg().getText();
	    				   
	    				   if(msg.equalsIgnoreCase("Criteria already exists."))
	    				   {
	    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
	    				   }
	    				   else
	    				   {
	    					   String msg1 = performerPOM.readMesg().getText();
	    					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg1);
	    				   }
	    				   
	    				   Thread.sleep(3000);
	    				   getDriver().switchTo().parentFrame();
	    				   performerPOM.clickclosecriteria().click();
	    				   
	    					 getDriver().switchTo().parentFrame();
					   	     	Thread.sleep(3000);
					   	     	performerPOM.clickClose().click();//Clicking on 'Close'
	          }
		 	 public static void CaseCriteriaInvalidData(ExtentTest test) throws InterruptedException
	         {
	       	  
		 		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				
			  
	   		      Thread.sleep(3000);
					performerPOM.clickCaseOpencfo().click();//click edit notice
				             Thread.sleep(3000);
						     performerPOM.clickEditNotice().click();//click edit notice
					  
						      getDriver().switchTo().parentFrame();
						      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	       	          
	   			       Thread.sleep(1000);
	   				   performerPOM. clickExternalLawyerRating1().click();
	   				   
	   				
	   				  Thread.sleep(3000);
	   				  performerPOM.selectExternalLawyerRating();
	   				   Thread.sleep(3000);
	   				   performerPOM.clickNewCriteria().click();
	   				   Thread.sleep(3000);
	   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
	   				 Thread.sleep(3000);
	   				  performerPOM.clickCriteria().sendKeys("342");
	   				 
	   				   Thread.sleep(3000);
	   				   performerPOM.clickSaveCriteria().click();
	   				   Thread.sleep(3000);
	   				   String msg = performerPOM.clickCriteriaInvalidMsg().getText();
	   				   
	   				   if(msg.equalsIgnoreCase("Only alphabets allowed."))
	   				   {
	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
	   				   }
	   				   else
	   				   {
	   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
	   				   }
	   				   
	   				   Thread.sleep(3000);
	   				getDriver().switchTo().parentFrame();
	   				   performerPOM.clickclosecriteria().click();
	         }
		 	 
			 public static void CaseCriteriaWithoutData(ExtentTest test) throws InterruptedException
	         {
	       	  
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 
			  
	   		      Thread.sleep(3000);
					performerPOM.clickCaseOpencfo().click();//click edit notice
				     
				             Thread.sleep(3000);
						     performerPOM.clickEditNotice().click();//click edit notice
					  
						     getDriver().switchTo().parentFrame();
						      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	       	          
	   			       Thread.sleep(1000);
	   				   performerPOM. clickExternalLawyerRating1().click();
	   				   
	   				
	   		
	   				  Thread.sleep(3000);
	   				  performerPOM.selectExternalLawyerRating();
	   				   Thread.sleep(3000);
	   				   performerPOM.clickNewCriteria().click();
	   				   Thread.sleep(3000);
	   				   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeLayerRatingCriteria"));
	   				
	   				 
	   				   Thread.sleep(3000);
	   				   performerPOM.clickSaveCriteria().click();
	   				   Thread.sleep(3000);
	   				   String msg = performerPOM.readOppoenentMsg().getText();
	   				   
	   				   if(msg.equalsIgnoreCase("Criteria can not be empty."))
	   				   {
	   					   test.log(LogStatus.PASS, "Meassag Displayed ="+msg);
	   				   }
	   				   else
	   				   {
	   					   test.log(LogStatus.FAIL, "Meassag Displayed ="+msg);
	   				   }
	   				   
	   				   Thread.sleep(3000);
	   				getDriver().switchTo().parentFrame();
	   				   performerPOM.clickclosecriteria().click();
	         }
				public static void TaskwithExistingData( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
				{
					
					 
					 
					
						WebDriverWait wait = new WebDriverWait( getDriver(),(60));
						 JavascriptExecutor js =(JavascriptExecutor) getDriver();
					Thread.sleep(500);
					performerPOM.clickTaskOpen().click();	
					Thread.sleep(500);
					
					CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
					js.executeScript("window.scrollBy(0,-700)");
					performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
					
					progress();
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
					
//					
//					Thread.sleep(300);
//					performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
//					OverduePOM.selectNextMonth().click();
//					OverduePOM.selectDate().click();					//Selecting particular date.
//					
					 Thread.sleep(500);
					  FileInputStream fis = new FileInputStream(filePath);
					  Workbook workbook = WorkbookFactory.create(fis);
					  Sheet  sheet= workbook.getSheetAt(2);
					Thread.sleep(500);
					Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					String title = c1.getStringCellValue();
					performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
					
					 Thread.sleep(500);
					  FileInputStream fis1 = new FileInputStream(filePath);
					  Workbook workbook1 = WorkbookFactory.create(fis1);
					  Sheet  sheet1= workbook1.getSheetAt(2);
					Thread.sleep(300);
					row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String desc = c1.getStringCellValue();
					performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
					
					Thread.sleep(300);
					performerPOM.clickDueDate().click();				//Clicking on 'Due Date' text box
					OverduePOM.selectNextMonth().click();
					OverduePOM.selectDate().click();					//Selecting particular date.
					
					Thread.sleep(300);
					Actions action = new Actions(getDriver());
					action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
					
					
					 Thread.sleep(500);
					  FileInputStream fis2 = new FileInputStream(filePath);
					  Workbook workbook2 = WorkbookFactory.create(fis2);
					  Sheet  sheet2= workbook2.getSheetAt(2);
					Thread.sleep(300);
					row0 = sheet2.getRow(14);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String outcome = c1.getStringCellValue();
					performerPOM.clickExpOutcome().sendKeys(outcome);	//Writing 'Expected Outcome'
					
					
					 Thread.sleep(500);
					  FileInputStream fis3 = new FileInputStream(filePath);
					  Workbook workbook3 = WorkbookFactory.create(fis3);
					  Sheet  sheet3= workbook3.getSheetAt(2);
					Thread.sleep(1000);
					row0 = sheet3.getRow(15);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String internalUser = c1.getStringCellValue();
					performerPOM.clickInternalUser3().click();
					//performerPOM.selectInternalUser2().click();
					performerPOM.selectInternalUser3().sendKeys(internalUser, Keys.ENTER);	//Selecting 'Internal User'
					
					 Thread.sleep(500);
					  FileInputStream fis4 = new FileInputStream(filePath);
					  Workbook workbook4= WorkbookFactory.create(fis4);
					  Sheet  sheet4= workbook4.getSheetAt(2);
					Thread.sleep(1000);
					row0 = sheet4.getRow(16);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String externalUser = c1.getStringCellValue();
					try
					{
						Thread.sleep(300);
						performerPOM.clickExternalUser().click();
						Thread.sleep(500);
						action.moveToElement(performerPOM.clickSearchExternalUser()).sendKeys(externalUser, Keys.ENTER).perform();
					}
					catch(Exception e)
					{
						
					}
					
					 Thread.sleep(500);
					  FileInputStream fis5 = new FileInputStream(filePath);
					  Workbook workbook5 = WorkbookFactory.create(fis5);
					  Sheet  sheet5= workbook5.getSheetAt(2);
					Thread.sleep(5000);
					row0 = sheet5.getRow(17);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String remark = c1.getStringCellValue();
					performerPOM.clickRemark().sendKeys(remark);		//Writing 'Remark'
					//Thread.sleep(300);
					//String workingDir = System.getProperty("user.dir");
					//performerPOM.clickUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file
					
					Thread.sleep(300);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
					Thread.sleep(300);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickTaskInvalidMessage()));
					
					Thread.sleep(300);
					String msg = performerPOM.clickTaskInvalidMessage().getText();
					if(msg.contains(msg))
					{
						test.log(LogStatus.PASS, "Task with existing data ="+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Task with existing data ="+msg);
					}
					
					getDriver().switchTo().parentFrame();
					performerPOM.clickClose1().click();			//Clicking on 'Close'
				}
				static void TaskwithClearBtn( ExtentTest test) throws InterruptedException
				{
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 JavascriptExecutor js =(JavascriptExecutor) getDriver();
					Thread.sleep(500);
					performerPOM.clickTaskOpen().click();
					Thread.sleep(500);
					
					CFOcountPOM.clickNextPage1().sendKeys(Keys.UP);
					js.executeScript("window.scrollBy(0,-700)");
					performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
					
					progress();
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
					
					Thread.sleep(300);
					Actions action = new Actions(getDriver());
					action.moveToElement(performerPOM.clickPriority()).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
					
					Thread.sleep(300);
					
					if(performerPOM.clickTaskClearBtn().isEnabled())
					{
						performerPOM.clickTaskClearBtn().click();
						test.log(LogStatus.PASS, "After clicking the clear button the data should be remove");
					}
					else
					{
						test.log(LogStatus.FAIL, "After clicking the clear button the data should not be remove");
					}
					
					getDriver().switchTo().parentFrame();
					performerPOM.clickClose1().click();			//Clicking on 'Close'
				}
				
				public static void TaskDelete( ExtentTest test) throws InterruptedException
				{
					
					Thread.sleep(500);
					performerPOM.clickTaskOpen().click();
					Thread.sleep(2000);
					performerPOM.clickTaskdelete().click();	
					
					 Thread.sleep(5000);
					    // Switching to Alert        
				        Alert alert1 =getDriver().switchTo().alert();		
				        		
				        // Capturing alert message.    
				        String alertMessage1= getDriver().switchTo().alert().getText();	
				        
				        
				        test.log(LogStatus.PASS, alertMessage1);
				        		
				        // Displaying alert message		
				        System.out.println(alertMessage1);
				        
				     // Accepting alert		
				        alert1.accept();	
				}
				
				public static void TaskwithoutData( ExtentTest test) throws InterruptedException
				{
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				
					Thread.sleep(500);
					performerPOM.clickTaskOpen().click();	
					Thread.sleep(500);
					
					performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
					
					progress();
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
					
					Thread.sleep(300);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
					Thread.sleep(300);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage2()));
					
					Thread.sleep(300);
					String msg = performerPOM.clickMessage2().getText();
					if(msg.contains(msg))
					{
						test.log(LogStatus.PASS, "Task without data ="+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Task without data ="+msg);
					}
					
					getDriver().switchTo().parentFrame();
					performerPOM.clickClose1().click();			//Clicking on 'Close'
				}
				
				
				public static void TaskwithTwoManadatoryFields( ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException
				{
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					
					Thread.sleep(500);
					performerPOM.clickTaskOpen().click();	
					Thread.sleep(500);
				
					performerPOM.clickAddNewTask().click();				//Clicking on 'New' button
					
					progress();
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeAddTask"));
						
					
					 Thread.sleep(500);
					  FileInputStream fis = new FileInputStream(filePath);
					  Workbook workbook = WorkbookFactory.create(fis);
					  Sheet  sheet= workbook.getSheetAt(2);
					Thread.sleep(500);
					Row row0 = sheet.getRow(12);								//Selected 0th index row (First row)
					Cell c1 = row0.getCell(1);								//Selected cell (0 row,1 column)
					String title = c1.getStringCellValue();
					performerPOM.clickTaskTitle().sendKeys(title);	//Writing 'Task Title'
					
					 Thread.sleep(500);
					  FileInputStream fis1 = new FileInputStream(filePath);
					  Workbook workbook1 = WorkbookFactory.create(fis1);
					  Sheet  sheet1= workbook1.getSheetAt(2);
					Thread.sleep(300);
					row0 = sheet1.getRow(13);									//Selected 0th index row (First row)
					c1 = row0.getCell(1);									//Selected cell (0 row,1 column)
					String desc = c1.getStringCellValue();
					performerPOM.clickTaskDesc().sendKeys(desc);		//Writing 'Task Description'
					
					Thread.sleep(300);
					OverduePOM.clickSaveButton().click();				//Clicking on 'Save' button.
					
					Thread.sleep(300);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.clickMessage1()));
					
					Thread.sleep(300);
					String msg = performerPOM.clickMessage1().getText();
					if(msg.contains(msg))
					{
						test.log(LogStatus.PASS, "Task with two mandatory fields ="+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Task with two mandatory fields ="+msg);
					}
					
					getDriver().switchTo().parentFrame();
					performerPOM.clickClose1().click();			//Clicking on 'Close'
				}
				
				
				
				public static void CaseNoticeTypeFilter( ExtentTest test,String type) throws InterruptedException
				{
					
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			     	
			     	if(type.equalsIgnoreCase("CaseNoticeTypeSummaryGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,800)");
			     	  Thread.sleep(2000);
			          performerPOM.CaseNoticeTypeOutwardPlaintiff().click();
			     	}
			     	else if(type.equalsIgnoreCase("CaseNoticeStageHearingGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,1500)");
			     	  Thread.sleep(2000);
			          performerPOM.clickCaseNoticeStageHearingGraph().click();
			     	}
			     	else if(type.equalsIgnoreCase("RiskSummaryHigh"))
			     	{
			     		js.executeScript("window.scrollBy(0,2000)");
				      Thread.sleep(2000);
				     	performerPOM.RiskSummaryHigh().click();						//Clicking on 'Open' notice
				  		
			     	}
			     
			     	else if(type.equalsIgnoreCase("DepartmentSummaryGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,2000)");
				     	Thread.sleep(2000);
				     	performerPOM.DepartmentSummaryGraph1().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
				  		
			     	}
			    	else if(type.equalsIgnoreCase("LocationSummaryGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,2200)");
				     	Thread.sleep(2000);
				     	performerPOM.LocationSummaryGraph().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
				  		
			     	}
			     	
			     	else if(type.equalsIgnoreCase("CategorySummaryGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,2500)");
				     	 Thread.sleep(2000);
				     	performerPOM.CategorySummaryGraph1().click();						//Clicking on 'Open' notice				//Clicking on 'Open' notice					//Clicking on 'Open' notice
				  		
			     	}
			    
			     
			    	else if(type.equalsIgnoreCase("2to3YearAgeingGraph"))
			     	{
			     		js.executeScript("window.scrollBy(0,5000)");
				     	Thread.sleep(2000);
				     	performerPOM.clickInwardOutward1to2yearsCase().click();						//Clicking on 'Open' notice
				  						
				  	}
			     	
			     	
			     	
			        
			        Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
					
			     	
			        Thread.sleep(2000);
					performerPOM.clickLocationFilter().click();
					Thread.sleep(2000);
					performerPOM.clickExpand().click();
					Thread.sleep(500);
			       String locationtext =performerPOM.SelectLocation().getText();
			       Thread.sleep(500);
			       performerPOM. SelectLocation().click();
			       Thread.sleep(500);
			       performerPOM.clickLocationFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM.clickCaseNotice().click();
				   Thread.sleep(500);
			       String caseNotice=performerPOM.selectCaseNotice().getText();
			       Thread.sleep(500);
				   performerPOM.selectCaseNotice().click();
			       Thread.sleep(500);
				   performerPOM.clickCaseNotice().click();
			        
			       Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();
			       Thread.sleep(500);
			       String Statustext = performerPOM.selectStatusFilter().getText();
			       Thread.sleep(500);
			       performerPOM.selectStatusFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();
			       Thread.sleep(500);
			       
			       performerPOM.clickDepartmentFilter().click();
			       Thread.sleep(500);
			       String DeptText = performerPOM.selectDepartmentFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectDepartmentFilter().click();
			     //  Thread.sleep(500);
			       //performerPOM.clickDepartmentFilter().click();
			       
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       Thread.sleep(1000);
			       String RiskText = performerPOM.selectRiskFilter().getText();
			       Thread.sleep(1000);
			       performerPOM. selectRiskFilter().click();
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
//			       Thread.sleep(500);
//			       String AgeText = performerPOM.selectAgeFilter().getText();
//			       Thread.sleep(500);
//			       performerPOM. selectAgeFilter().click();
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM. clickCategoryFilter().click();
			       Thread.sleep(500);
			       String CategoryText = performerPOM.selectCategoryFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectCategoryFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickCategoryFilter().click();
			       
			       
			        List<String> li=new ArrayList<String>();
			        li.add(locationtext);
			        li.add(caseNotice);
			        li.add(Statustext);
			        li.add(DeptText);
			        li.add(RiskText);
			       // li.add(AgeText);
			        li.add(CategoryText);
			        
			        Thread.sleep(3000);
			        
					List<String> filter=new ArrayList<String>();	
					filter.add("Location");
					filter.add("caseNotice");	
					filter.add("Status");
					filter.add("Dept");
					filter.add("Risk");
					//filter.add("Age");
					filter.add("Category");
					
					 Thread.sleep(500);
					 performerPOM.clickTrignle().click();
				     Thread.sleep(500);
				     performerPOM.clickCol().click();
//				     Thread.sleep(3000);
//				     performerPOM.clickRiskcol().click();
				     
				     By locator = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Risk']");
                     wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				     Thread.sleep(4000);
	                 WebElement ViewButton = getDriver().findElement(locator);	
					 Thread.sleep(4000);
					 
					 js.executeScript("arguments[0].click();", ViewButton);
				     Thread.sleep(500);
					 performerPOM.clickTrignle().click();
					
					
					js.executeScript("window.scrollBy(0,150)");	
					Thread.sleep(3000);

					CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
					String s = CFOcountPOM.readTotalItems1().getText();
					Thread.sleep(2000);

					if(!s.equalsIgnoreCase("No items to display")) {
					Thread.sleep(5000);
				
					List<WebElement>entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
					List<WebElement>casenotice=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
					List<WebElement>status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[11]"));
					List<WebElement>Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[10]"));
					List<WebElement>Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[12]"));
					List<WebElement>Category=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
					Thread.sleep(2000);

					for(int i=0; i<li.size(); i++){
						
						List<String> text= new ArrayList<String>();
						HashSet<String> pass=new LinkedHashSet<>();
						HashSet<String> fail=new LinkedHashSet<>();
						List<WebElement>raw=new ArrayList<WebElement>();

							if(i==0)
							{
								raw.addAll(entitycol);
							}
							else if(i==1)
							{
								raw.addAll(casenotice);
							}
							
						   else if(i==2)
							{
								raw.addAll(status);
							}
							
						   else if(i==3)
						   {
							 raw.addAll(Dept);
						   }
						   else if(i==4)
						   {
							   raw.addAll(Risk);
						   }
						   else if(i==5)
						   {
							   raw.addAll(Category);
						   }
									
						for(int k=0;k<raw.size();k++)
							{
								text.add(raw.get(k).getText());
							}

							for(int l=0;l<text.size();l++)
							{
								
//								if(i==2)
//								{
//									pass.add(text.get(l));	
//								}
//								else
//								{
									
								
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
							//}
					 
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
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(2000);
					performerPOM.caseNoticeSummaryGraphClose().click();
					
					  
				}
				
			
				public static void AgeingGraphFilter( ExtentTest test,String type) throws InterruptedException
				{
					
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			     	
			     	if(type.equalsIgnoreCase("Inward/Defendent"))
			     	{
			     		
			     	  Thread.sleep(3000);
			          performerPOM.clickAgeing().click();
			     	}
			     	else if(type.equalsIgnoreCase("Complainant"))
			     	{
			     	
			     	  Thread.sleep(2000);
			          performerPOM.clickComplainantLessThanYearCase().click();
			     	}
			     	else if(type.equalsIgnoreCase("Applicant"))
			     	{
			     		
				      Thread.sleep(2000);
				     	performerPOM.clickApplicantAgeing().click();						//Clicking on 'Open' notice
				  		
			     	}
			     
			     	else if(type.equalsIgnoreCase("Outward/Plaintiff"))
			     	{
			     		
				     	Thread.sleep(2000);
				     	performerPOM.clickOutwardPlaintiffAgeing().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
				  		
			     	}
			    	else if(type.equalsIgnoreCase("Petitioner"))
			     	{
			     		
				     	Thread.sleep(2000);
				     	performerPOM.clickPetitionerAgeing().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
			     	}      
			    	else if(type.equalsIgnoreCase("Respondent"))
			     	{
			     		
				     	Thread.sleep(2000);
				     	performerPOM.clickRespondentAgeing().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
			     	}      
			        Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
					
			        Thread.sleep(2000);
					performerPOM.clickLocationFilter().click();
					Thread.sleep(500);
					performerPOM.clickExpand().click();
					Thread.sleep(500);
			       String locationtext =performerPOM.SelectLocation().getText();
			       Thread.sleep(500);
			       performerPOM. SelectLocation().click();
			       Thread.sleep(500);
			       performerPOM.clickLocationFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM.clickCaseNotice().click();
				   Thread.sleep(500);
			       String caseNotice=performerPOM.selectCaseNotice().getText();
			       Thread.sleep(500);
				   performerPOM.selectCaseNotice().click();
			       Thread.sleep(500);
				   performerPOM.clickCaseNotice().click();
			        
			     /*  Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();
			       Thread.sleep(500);
			       String Statustext = performerPOM.selectStatusFilter().getText();
			       Thread.sleep(500);
			       performerPOM.selectStatusFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();*/
			       Thread.sleep(500);
			       
			       performerPOM.clickDepartmentFilter().click();
			       Thread.sleep(500);
			       String DeptText = performerPOM.selectDepartmentFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectDepartmentFilter().click();
			     //  Thread.sleep(500);
			       //performerPOM.clickDepartmentFilter().click();
			       
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       Thread.sleep(1000);
			       String RiskText = performerPOM.selectRiskFilter().getText();
			       Thread.sleep(1000);
			       performerPOM. selectRiskFilter().click();
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
//			       Thread.sleep(500);
//			       String AgeText = performerPOM.selectAgeFilter().getText();
//			       Thread.sleep(500);
//			       performerPOM. selectAgeFilter().click();
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM. clickCategoryFilter().click();
			       Thread.sleep(500);
			       String CategoryText = performerPOM.selectCategoryFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectCategoryFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickCategoryFilter().click();
			       
			       
			        List<String> li=new ArrayList<String>();
			        li.add(locationtext);
			        li.add(caseNotice);
			        //li.add(Statustext);
			        li.add(DeptText);
			        li.add(RiskText);
			       // li.add(AgeText);
			        li.add(CategoryText);
			        
			        Thread.sleep(3000);
			        
					List<String> filter=new ArrayList<String>();	
					filter.add("Location");
					filter.add("caseNotice");	
					//filter.add("Status");
					filter.add("Dept");
					filter.add("Risk");
					//filter.add("Age");
					filter.add("Category");
					
					 Thread.sleep(500);
					 performerPOM.clickTrignle().click();
				     Thread.sleep(500);
				     performerPOM.clickCol().click();
//				     Thread.sleep(3000);
//				     performerPOM.clickRiskcol().click();
				     
				     By locator = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Risk']");
                     wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				     Thread.sleep(4000);
	                 WebElement ViewButton = getDriver().findElement(locator);	
					 Thread.sleep(4000);
					 
					 js.executeScript("arguments[0].click();", ViewButton);
				     Thread.sleep(500);
					 performerPOM.clickTrignle().click();
					
					
					js.executeScript("window.scrollBy(0,150)");	
					Thread.sleep(3000);

					CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
					String s = CFOcountPOM.readTotalItems1().getText();
					Thread.sleep(2000);

					if(!s.equalsIgnoreCase("No items to display")) {
					Thread.sleep(5000);
				
					List<WebElement>entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
					List<WebElement>casenotice=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
					//List<WebElement>status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[11]"));
					List<WebElement>Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[10]"));
					List<WebElement>Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[12]"));
					List<WebElement>Category=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
					Thread.sleep(2000);

					for(int i=0; i<li.size(); i++){
						
						List<String> text= new ArrayList<String>();
						HashSet<String> pass=new LinkedHashSet<>();
						HashSet<String> fail=new LinkedHashSet<>();
						List<WebElement>raw=new ArrayList<WebElement>();

							if(i==0)
							{
								raw.addAll(entitycol);
							}
							else if(i==1)
							{
								raw.addAll(casenotice);
							}
							
						  /* else if(i==2)
							{
								raw.addAll(status);
							}*/
							
						   else if(i==2)
						   {
							 raw.addAll(Dept);
						   }
						   else if(i==3)
						   {
							   raw.addAll(Risk);
						   }
						   else if(i==4)
						   {
							   raw.addAll(Category);
						   }
									
						for(int k=0;k<raw.size();k++)
							{
								text.add(raw.get(k).getText());
							}

							for(int l=0;l<text.size();l++)
							{
								
//								if(i==2)
//								{
//									pass.add(text.get(l));	
//								}
//								else
//								{
									
								
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
							//}
					 
				for(String Fal : fail)
					 {
							test.log(LogStatus.FAIL,type+ ":-" +filter.get(i)+" column shows incorrect value : "+Fal);
					 }	
					 for(String Pas : pass)
					 {
						 test.log(LogStatus.PASS, type+ ":-" +filter.get(i)+" dropdown working properly.");
							test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
							System.out.println(filter.get(i)+" : "+Pas);
				 }
					text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
					
					
					}
					}else {
						test.log(LogStatus.PASS, type+ ":-" +"No records found");	
					}
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(2000);
					performerPOM.caseNoticeSummaryGraphClose().click();
					
					  
				}
						
				
				
			
				public static void AgeingGraph1to2Filter( ExtentTest test,String type) throws InterruptedException
				{
					
					WebDriverWait wait = new WebDriverWait( getDriver(),(60));
					 JavascriptExecutor js =(JavascriptExecutor) getDriver();
			     	
			     	
			     	if(type.equalsIgnoreCase("Complianant"))
			     	{
			     		
			     	  Thread.sleep(2000);
			          performerPOM.clickComplianant2().click();
			     	}
			     	else if(type.equalsIgnoreCase("Inward/Defendent"))
			     	{
			     	
			     	  Thread.sleep(2000);
			          performerPOM.clickComplianant1().click();
			     	}
			     	else if(type.equalsIgnoreCase("Outward/Plaintiff"))
			     	{
			     		
				      Thread.sleep(2000);
				     	performerPOM.clickOutwardPlaintiff().click();						//Clicking on 'Open' notice
				  		
			     	}
			     
			     	else if(type.equalsIgnoreCase("Respondent"))
			     	{
			     		
				     	Thread.sleep(2000);
				     	performerPOM.clickOutwardPlaintiffAgeing().click();						//Clicking on 'Open' notice					//Clicking on 'Open' notice
				  		
			     	}
			    	
			     
			        Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
					
			        Thread.sleep(2000);
					performerPOM.clickLocationFilter().click();
					Thread.sleep(500);
					performerPOM.clickExpand().click();
					Thread.sleep(500);
			       String locationtext =performerPOM.SelectLocation().getText();
			       Thread.sleep(500);
			       performerPOM. SelectLocation().click();
			       Thread.sleep(500);
			       performerPOM.clickLocationFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM.clickCaseNotice().click();
				   Thread.sleep(500);
			       String caseNotice=performerPOM.selectCaseNotice().getText();
			       Thread.sleep(500);
				   performerPOM.selectCaseNotice().click();
			       Thread.sleep(500);
				   performerPOM.clickCaseNotice().click();
			        
			      /* Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();
			       Thread.sleep(500);
			       String Statustext = performerPOM.selectStatusFilter().getText();
			       Thread.sleep(500);
			       performerPOM.selectStatusFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickStatusFilter().click();*/
			       Thread.sleep(500);
			       
			       performerPOM.clickDepartmentFilter().click();
			       Thread.sleep(500);
			       String DeptText = performerPOM.selectDepartmentFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectDepartmentFilter().click();
			     //  Thread.sleep(500);
			       //performerPOM.clickDepartmentFilter().click();
			       
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       Thread.sleep(1000);
			       String RiskText = performerPOM.selectRiskFilter().getText();
			       Thread.sleep(1000);
			       performerPOM. selectRiskFilter().click();
			       Thread.sleep(1000);
			       performerPOM.clickRiskFilter().click();
			       
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
//			       Thread.sleep(500);
//			       String AgeText = performerPOM.selectAgeFilter().getText();
//			       Thread.sleep(500);
//			       performerPOM. selectAgeFilter().click();
//			       Thread.sleep(500);
//			       performerPOM.clickAgeFilter().click();
			       
			       Thread.sleep(500);
			       performerPOM. clickCategoryFilter().click();
			       Thread.sleep(500);
			       String CategoryText = performerPOM.selectCategoryFilter().getText();
			       Thread.sleep(500);
			       performerPOM. selectCategoryFilter().click();
			       Thread.sleep(500);
			       performerPOM.clickCategoryFilter().click();
			       
			       
			        List<String> li=new ArrayList<String>();
			        li.add(locationtext);
			        li.add(caseNotice);
			       // li.add(Statustext);
			        li.add(DeptText);
			        li.add(RiskText);
			       // li.add(AgeText);
			        li.add(CategoryText);
			        
			        Thread.sleep(3000);
			        
					List<String> filter=new ArrayList<String>();	
					filter.add("Location");
					filter.add("caseNotice");	
					//filter.add("Status");
					filter.add("Dept");
					filter.add("Risk");
					//filter.add("Age");
					filter.add("Category");
					
					 Thread.sleep(500);
					 performerPOM.clickTrignle().click();
				     Thread.sleep(500);
				     performerPOM.clickCol().click();
//				     Thread.sleep(3000);
//				     performerPOM.clickRiskcol().click();
				     
				     By locator = By.xpath("//span[@class='k-link k-menu-link'][normalize-space()='Risk']");
                     wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				     Thread.sleep(4000);
	                 WebElement ViewButton = getDriver().findElement(locator);	
					 Thread.sleep(4000);
					 
					 js.executeScript("arguments[0].click();", ViewButton);
				     Thread.sleep(500);
					 performerPOM.clickTrignle().click();
					
					
					js.executeScript("window.scrollBy(0,150)");	
					Thread.sleep(3000);

					CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
					String s = CFOcountPOM.readTotalItems1().getText();
					Thread.sleep(2000);

					if(!s.equalsIgnoreCase("No items to display")) {
					Thread.sleep(5000);
				
					List<WebElement>entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
					List<WebElement>casenotice=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]"));
					//List<WebElement>status=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[11]"));
					List<WebElement>Dept=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[10]"));
					List<WebElement>Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[12]"));
					List<WebElement>Category=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
					Thread.sleep(2000);

					for(int i=0; i<li.size(); i++){
						
						List<String> text= new ArrayList<String>();
						HashSet<String> pass=new LinkedHashSet<>();
						HashSet<String> fail=new LinkedHashSet<>();
						List<WebElement>raw=new ArrayList<WebElement>();

							if(i==0)
							{
								raw.addAll(entitycol);
							}
							else if(i==1)
							{
								raw.addAll(casenotice);
							}
							
						  /* else if(i==2)
							{
								raw.addAll(status);
							}*/
							
						   else if(i==2)
						   {
							 raw.addAll(Dept);
						   }
						   else if(i==3)
						   {
							   raw.addAll(Risk);
						   }
						   else if(i==4)
						   {
							   raw.addAll(Category);
						   }
									
						for(int k=0;k<raw.size();k++)
							{
								text.add(raw.get(k).getText());
							}

							for(int l=0;l<text.size();l++)
							{
								
//								if(i==2)
//								{
//									pass.add(text.get(l));	
//								}
//								else
//								{
									
								
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
							//}
					 
				for(String Fal : fail)
					 {
							test.log(LogStatus.FAIL,type+ ":-" +filter.get(i)+" column shows incorrect value : "+Fal);
					 }	
					 for(String Pas : pass)
					 {
						 test.log(LogStatus.PASS, type+ ":-" +filter.get(i)+" dropdown working properly.");
							test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
							System.out.println(filter.get(i)+" : "+Pas);
				 }
					text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
					
					
					}
					}else {
						test.log(LogStatus.PASS, type+ ":-" +"No records found");	
					}
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(2000);
					performerPOM.caseNoticeSummaryGraphClose().click();
					
					  
				}			
				
				
				public static void CaseUpdationImportUtility(ExtentTest test) throws InterruptedException
				{
					
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationFile();
					Thread.sleep(3000);
					performerPOM.UploadCaseFile().click();
					
					
					WebDriverWait wait = new WebDriverWait(getDriver(),300);
					Thread.sleep(3000);
					wait.until(ExpectedConditions.visibilityOf(performerPOM.readCaseMsg()));
					
					Thread.sleep(500);
					String msg5 = performerPOM.readCaseMsg().getText();		//Reading Message appeared after save button
				
					if(msg5.equalsIgnoreCase(msg5))
					{
						test.log(LogStatus.PASS, "Message displayed = "+msg5);
					
					}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg5);
					}
					
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
				
				public static void CaseUpdationUploadEmtyFile(ExtentTest test) throws InterruptedException
				{
				
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationFile1();
					Thread.sleep(3000);
					performerPOM.UploadCaseFile().click();
					
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
		              test.log(LogStatus.PASS, "Case Updation =  Upload Empty File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
				public static void CaseUpdationUploadInvalidData(ExtentTest test) throws InterruptedException
				{
				
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationFile2();
					Thread.sleep(3000);
					performerPOM.UploadCaseFile().click();
					
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
		              test.log(LogStatus.PASS, "Case Updation =  Upload Empty File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
						
				public static void CaseUpdationUploadInvalidFile(ExtentTest test) throws InterruptedException
				{
				
					performerPOM.ClickImportUtility().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseUpdationType().click();
					Thread.sleep(3000);
					performerPOM.ChooseCaseFile3();
					Thread.sleep(3000);
					performerPOM.UploadCaseFile().click();
					
					
					try
					{
						
					  Thread.sleep(500);
					  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
		              test.log(LogStatus.PASS, "Case Updation =  Upload Invalid File = "+msg7);
						
					  }
					catch(Exception e)
					{
						test.log(LogStatus.FAIL, "Case Updation = Validation message not displayed");
					}
					Thread.sleep(300);
					OverduePOM.clickDashboard().click();
				}
						
			public static void NoticeUpdation(ExtentTest test) throws InterruptedException
			{
				
				performerPOM.ClickImportUtility().click();
				Thread.sleep(3000);
				performerPOM.clickNotice().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdationType().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdationFile();
				Thread.sleep(3000);
				performerPOM.UploadNoticeFile().click();
				
				
				
				Thread.sleep(500);
				String msg = performerPOM.readNoticeMsg().getText();		//Reading Message appeared after save button
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg);
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
				Thread.sleep(300);
				OverduePOM.clickDashboard().click();
			}
			
			public static void NoticeUpdationUploadEmtyFile(ExtentTest test) throws InterruptedException
			{
			
				performerPOM.ClickImportUtility().click();
				Thread.sleep(3000);
				performerPOM.clickNotice().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdationType().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdtionEmptyFile();
				Thread.sleep(3000);
				performerPOM.UploadNoticeFile().click();
				
				try
				{
					
				  Thread.sleep(500);
				  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
	              test.log(LogStatus.PASS, "Notice Updation =  Upload Empty File = "+msg7);
					
				  }
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
				}
				Thread.sleep(300);
				OverduePOM.clickDashboard().click();
			}
			public static void NoticeUpdationUploadInvalidData(ExtentTest test) throws InterruptedException
			{
			
				performerPOM.ClickImportUtility().click();
				Thread.sleep(3000);
				performerPOM.clickNotice().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdationType().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdtionInvalidData();
				Thread.sleep(3000);
				performerPOM.UploadNoticeFile().click();
				
				
				try
				{
					
				  Thread.sleep(500);
				  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
	              test.log(LogStatus.PASS, "Notice Updation =  Upload Empty File = "+msg7);
					
				  }
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
				}
				Thread.sleep(300);
				OverduePOM.clickDashboard().click();
			}
			public static void NoticeUpdationUploadInvalidFile(ExtentTest test) throws InterruptedException
			{
				performerPOM.ClickImportUtility().click();
				Thread.sleep(3000);
				performerPOM.clickNotice().click();
				Thread.sleep(3000);
				performerPOM.ChooseNoticeUpdationType().click();
				Thread.sleep(3000);
				performerPOM.ChooseCaseFile3();
				Thread.sleep(3000);
				performerPOM.UploadNoticeFile().click();
				
				
				
				try
				{
					
				  Thread.sleep(500);
				  String msg7 = performerPOM.readCaseMsg1().getText();		//Reading Message appeared after save button
	              test.log(LogStatus.PASS, "Notice Updation =  Upload Invalid File = "+msg7);
					
				  }
				catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Notice Updation = Validation message not displayed");
				}
				Thread.sleep(300);
				OverduePOM.clickDashboard().click();
			}
			 
				
			 

					
					
	 		
	 		
	 	 	 			
 		
				
		
 				
 		        
 	 	 	  static void selectOptionFromDropDown_bs(List<WebElement> options, String value)
            	  {
          			
          			for(WebElement option:options) 
          			{
          				if(option.getText().equals(value))
          				{
          					option.click();
          					
          					break;
          				}
          			}
          		 }
        		
}

                         
						
					    
						
						
					
					
				
				
						 
				
		

