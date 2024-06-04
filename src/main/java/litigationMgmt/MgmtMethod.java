package litigationMgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import litigationAdditionalOwner.performerPOM;
import login.BasePage;
import cfo.OverduePOM;

public class MgmtMethod extends BasePage{
	
private static List<WebElement> elementsList = null;

	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable


	

	public static void AdvocateBill(ExtentTest test) throws InterruptedException
	{
		 WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 
		 Thread.sleep(4000);
          performerPOM.clickCaseOpen().click();
          Thread.sleep(3000);
          performerPOM.clickEditNotice().click();
          
     	 getDriver().switchTo().parentFrame();
          Thread.sleep(3000);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		    
		   
		   
	      Thread.sleep(3000);
		 performerPOM.clickAdvocateBill().click();
		 
		 Thread.sleep(3000);
		 performerPOM.clickExportAdvocateBill().click();
		 Thread.sleep(3000);
		 performerPOM. clickNewAdvocateBill().click();
		 
		/* Thread.sleep(4000);
		 performerPOM.clickSaveAdvocateBill().click();
		 
			String msg6 = performerPOM.clickReadAdvocateMsg1().getText();		//Reading Message appeared after save button
		 
			
				test.log(LogStatus.PASS, "Message displayed = "+msg6);*/
			
		
			
			
		 
		 
		
		 Thread.sleep(5000);
	     performerPOM. clickInvoiceNum().sendKeys("604657");
		 Thread.sleep(5000);
		 performerPOM. clickInvoiceDate().sendKeys("17-11-2022");
		 //Thread.sleep(5000);
		 //performerPOM.clickAdvocateBillPanel().click();
		 Thread.sleep(5000);
		 performerPOM. clickInvoiceAmount().sendKeys("30000");
		 Thread.sleep(4000);
		 performerPOM.clickLawFirm1().click();
		// performerPOM.selectLawFirm2().get(2).click();
		 Thread.sleep(5000);
		 performerPOM.clickApprover1().click();
	      Thread.sleep(5000);
	      performerPOM.selectApprover1().get(5).click();
		 Thread.sleep(5000);
		 performerPOM.clickApprover2().click();
	     Thread.sleep(5000);
		 performerPOM.selectApprover2().get(5).click();
		 
		 Thread.sleep(5000);
		 performerPOM.clickUploadDoc().click();
		
		 Thread.sleep(4000);
		 performerPOM.clickSaveAdvocateBill().click();
		 
		 Thread.sleep(500);
			String msg5 = performerPOM.clickReadAdvocateMsg().getText();		//Reading Message appeared after save button
			String msg7= performerPOM.clickReadAdvocateMsg1().getText();		//Reading Message appeared after save button
			if(msg5.equalsIgnoreCase("Advocate Bill Added Successfully."))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg5);
			
			}
			
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg7);
			}
			performerPOM.clickeditAdvocatebill().click();
			
			 Thread.sleep(5000);
		     performerPOM. clickInvoiceNum().clear();
			 Thread.sleep(5000);
		     performerPOM. clickInvoiceNum().sendKeys("60957");
		     
		     Thread.sleep(4000);
			 performerPOM.clickSaveAdvocateBill().click();
		     
			 Thread.sleep(500);
				String msgg = performerPOM.clickReadAdvocateMsg().getText();		//Reading Message appeared after save button
			
				if(msgg.equalsIgnoreCase("Advocate Bill Updated Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msgg);
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msgg);
				}
				
				Thread.sleep(2000);
				performerPOM.clickDownloadDocAdvocatebill().click();
				
				 test.log(LogStatus.PASS, "Advocate Bill Document Download Successfully");
				 
				 Thread.sleep(2000);
				performerPOM.clickViewDocAdvocatebill().click();
		         
				 test.log(LogStatus.PASS, "Advocate Bill Document View Successfully");
				 
				 Thread.sleep(2000);
				performerPOM.clickViewDocAdvocatebillClose().click();
		 
				 Thread.sleep(2000);
				performerPOM.clickViewDocAdvocatebillPdf().click();
					
			    Thread.sleep(3000);
				performerPOM.clickViewDocAdvocatebillPdfClose().click();
				
				 test.log(LogStatus.PASS, "Advocate Bill Document Pdf Successfully");
				
				Thread.sleep(2000);
				performerPOM.clickAdvocateBillDelete().click();
				
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
		 
				 test.log(LogStatus.PASS, "Advocate Bill Document Deleted Successfully");
				 
				 
				 getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
			  		performerPOM .clickclosebutton().click();
			  		

			  		Thread.sleep(500);
			  		performerPOM.clickDashboard().click();
			  		
			  		
			  		
		 
  }
	
	public static void AdvocateBillTab(ExtentTest test) throws InterruptedException, IOException
	{
  		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	     Thread.sleep(3000);
  		performerPOM.clickAdvocateBillTab().click();
  		 Thread.sleep(3000);
  		performerPOM.clickAdvocateBillTabViewIcon().click();
  		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
  		Thread.sleep(2000);
  		performerPOM.clickAdvocateBillTabAuditLog().click();
  		getDriver().switchTo().parentFrame();
  		Thread.sleep(2000);
  		performerPOM.clickAdvocateBillTabclose().click();
  		Thread.sleep(2000);
  		performerPOM.clickAdvocateBillTabTriangle().click();
  		Thread.sleep(2000);
  		performerPOM.clearButton().click();

  		
		Thread.sleep(10000);
		CFOcountPOM.readTotalItems1().click();
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count2 = Integer.parseInt(compliancesCount1);
		
	    try
		{
			performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			
		}
	
	
		Thread.sleep(100);
		File dir = new File("C://Users//Admin//Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(500);
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
		
		
		Thread.sleep(5500);
		File dir1 = new File("C://Users//Admin//Downloads");
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
				test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				//test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Report = "+records);
			}
			else
			{
				test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				//test.log(LogStatus.PASS, "Total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
			}
		}
		
			
  		
		else
		{
		
  		Thread.sleep(3000);
  		performerPOM.clickApproverAssignmentLog().click();
		}
		
		
	}	
		public static void ApproverAssignmentLog(ExtentTest test) throws InterruptedException, IOException
    	{
		
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
    	     Thread.sleep(3000);
      		performerPOM.clickAdvocateBillTab().click();
		Thread.sleep(3000);
  		performerPOM.clickApproverAssignmentLog().click();
  		
//  		Thread.sleep(3000);
//		performerPOM.clickExportAdavanced().click();
  		
//		Thread.sleep(3000);
//		performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_DOWN);
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("window.scrollBy(0,700)");
//  		
//  		
//  		
//		
//		Thread.sleep(3000);
//		CFOcountPOM.readTotalItems1().click();
//		String item = CFOcountPOM.readTotalItems1().getText();
//		String[] bits = item.split(" ");								//Splitting the String
//		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
//		int count = Integer.parseInt(compliancesCount);
		
//	    try
//		{
//			performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_UP);
//		}
//		catch(Exception e)
//		{
//			
//		}
	
	
		Thread.sleep(100);
		File dir2 = new File("C://Users//Admin//Downloads");
		File[] dirContents1 = dir2.listFiles();							//Counting number of files in directory before download 
		
//		Thread.sleep(500);
//		CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
		Thread.sleep(250);
		performerPOM.clickExportAdavanced().click();					//Clicking on 'Excel Report' image.
		
		
		Thread.sleep(5500);
		File dir3 = new File("C://Users//Admin//Downloads");
		File[] allFilesNew1 = dir3.listFiles();							//Counting number of files in directory after download
		
		if(dirContents1.length < allFilesNew1.length)
		{
			test.log(LogStatus.PASS, "Approver Assignment Log - File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew1[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew1.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew1[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew1[i];
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
			
			Thread.sleep(3000);
    		performerPOM.clickExportAdavanced().sendKeys(Keys.PAGE_DOWN);
    		JavascriptExecutor js = (JavascriptExecutor) getDriver();
    		js.executeScript("window.scrollBy(0,700)");
      		
      		
      		
			
			Thread.sleep(3000);
			CFOcountPOM.readTotalItems2().click();
			String item = CFOcountPOM.readTotalItems2().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = Integer.parseInt(compliancesCount);
			
			if(count == records)
			{
				//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				//test.log(LogStatus.INFO, "Total records from Grid = "+count+" | Total records from Report = "+records);
			}
			else
			{
				//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				//test.log(LogStatus.INFO, "Total records from Grid = "+count+" | Total records from Excel Sheet = "+records);
			}
		}
  		
  		
  		Thread.sleep(500);
  		OverduePOM.clickDashboard().click();
  		
    	}		
		
		  public static void AdvocateBillApprover(ExtentTest test) throws InterruptedException
		  {
			  Thread.sleep(3000);
			  performerPOM.clickMasters().click();
			  Thread.sleep(3000);
			  performerPOM.clickMasterAdvocateBill().click();
			  Thread.sleep(3000);
			  performerPOM.clickAddApprover().click();
			  Thread.sleep(3000);
			  performerPOM.clickSelectapprover1().click();
			  Thread.sleep(3000);
			  performerPOM.clickSelectapprover1Dropdown().click();
			  Thread.sleep(3000);
			  performerPOM.clickSelectapprover2().click();
			  Thread.sleep(3000);
			  performerPOM.clickSelectapprover1Dropdown1().click();
			  Thread.sleep(3000);
			  performerPOM.clickupdate().click();
			  
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
		        
		        Thread.sleep(2000);
		        OverduePOM.clickDashboard().click();


		  }

}
