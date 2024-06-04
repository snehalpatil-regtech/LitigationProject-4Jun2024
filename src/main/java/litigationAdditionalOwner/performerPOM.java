package litigationAdditionalOwner;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import login.BasePage;




public class performerPOM extends BasePage
{
	private static WebElement litigation = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)

	
	
	public static WebElement clickNoticeOpen()			//Searching 'Open' Notice link
	{
		
		litigation = getDriver().findElement(By.id("ContentPlaceHolder1_divOpenNoticeCount"));
		return litigation;
	}
	
	public static WebElement clickNew()					//Searching 'New'
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewCaseNotice']"));
		return litigation;
	}
	
	public static WebElement clickDated()				//Searching 'Dated' input box
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtNoticeDate']"));
		
		return litigation;
	}
	
	public static WebElement clickFinancialYear()
	{//Searching 'Financial Year' drop down
	
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]")));
		//litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return litigation;
	}
	
	public static List<WebElement> chooseDropDownOption()	//Searching drop down in 'Financial Year'
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNotice']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		elementsList = getDriver().findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[1]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	public static WebElement clickAct()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[2]"));
		return litigation;
	}
	
	public static List<WebElement> chooseAct()
	{
    //	div.findElement(By.className("multiselect-container dropdown-menu")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNotice']/div[5]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		elementsList=getDriver().findElement(By.xpath("//*[@id=\"pnlNotice\"]/div[4]/div[1]/div[1]/span[1]/div/ul")).findElements(By.tagName("li"));
		
		return elementsList;
	}
	
	public static List<WebElement> chooseAct1()
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCase']/div[4]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		//elementsList=getDriver().findElement(By.xpath("//*[@id=\"pnlCase\"]/div[4]/div[1]/div[1]/span[1]/div/ul")).findElements(By.tagName("li"));
		elementsList=getDriver().findElements(By.xpath("//*[@id='pnlCase']/div[5]/div[1]/div[1]/span[1]/div/ul/li/a/label"));
		return elementsList;
	}
	
	public static WebElement clickRefNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxRefNo']"));
		return litigation;
	}
	
	public static WebElement clickNoticeType()
	{
		//litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']"));
		litigation = getDriver().findElement(By.id("rbNoticeInOutType_chosen"));
		
		return litigation;
	}
	
	public static WebElement chooseNoticeType()
	{
		  // elementsList =  getDriver().findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		   litigation= getDriver().findElement(By.xpath("//*[@id='rbNoticeInOutType_chosen']/div/ul/li[2]"));
		   		
		   return litigation;
		}
	
	
	public static WebElement clickUnderSection()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxSection']"));
		return litigation;
	}
	
	public static WebElement clickNoticeCategory()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']"));
		return litigation;
		
		
	}
	
	public static WebElement chooseCategory()
	{
		//elementsList = clickNoticeCategory(getDriver()).findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));
		litigation=getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']/div/ul/li[1]"));
		return litigation;
	}
	
	
	
	
	public static WebElement clickSearch()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickOpponentcfo()
	{
		//litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[3]"));
		
		 litigation=getDriver().findElement(By.xpath("//*[@id='divOpponentAndOpposition']/div[1]/div[1]/span[1]/div/button"));
		  return litigation;
	}
	public static WebElement clickOpponent()
	{
		//litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[3]"));
		
		 litigation=getDriver().findElement(By.xpath(("(//*[@id='divOpponentAndOpposition']/div[1]/div[1]/span[1]/div/button)")));
		  return litigation;
	}
	public static WebElement chooseOpponent()
	{
		//elementsList = getDriver().findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[3]")).findElements(By.tagName("li"));
		litigation=getDriver().findElement(By.xpath("//*[@id='divOpponentAndOpposition']/div[1]/div[1]/span[1]/div/ul/li/a/label/input"));
		return litigation;
	}
	
	public static WebElement deleteOpponent()
	{
		
		litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLCParty_LinkButton2_0']/img"));
		return litigation;
	}
	
	
	public static WebElement clickOppLawyer()
	{    
		
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSearch1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSearch2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[1]/div/input"));
		return litigation;
	}
	
	public static WebElement clickSelectAll()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlNotice']/div[4]/div[2]/span/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickNoticeTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTitle']"));
		return litigation;
	}
	
	public static WebElement clickNoticeDescription()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxDescription']"));
		return litigation;
	}
	
	public static WebElement clickLocation()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxBranch']"));
		return litigation;
	}
	
	public static WebElement clickPlus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tvBranchesn1']"));
		return litigation;
	}
	
	public static WebElement selectLocation()
	{
		litigation = getDriver().findElement(By.xpath("(//a[normalize-space()='ABC Mall, Thane'])[1]"));
		
		return litigation;
	}
	
	public static WebElement clickJurisdiction()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch3()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlJurisdiction_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickDepartment()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		 litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlDepartment_chosen']")));
		//litigation = getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch4()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickContactDept()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch5()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCPDepartment_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickNoticeTerm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeTerm']"));
		return litigation;
	}
	
	public static WebElement clickOwner()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearch6()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickWinningProspect1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/a"));
		return litigation;
	}
	
	//*[@id="ddlNoticeRisk_chosen"]
	public static WebElement clickRisk()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']"));
		return litigation;
	}
	public static WebElement clickSapCode()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxSapcode']"));
		return litigation;
	}
	
	public static WebElement selectRisk()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement selectRisk1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickNoticeBudget()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeBudget']"));
		return litigation;
	}
	
	public static WebElement clickClaimedAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxClaimedAmt']"));
		return litigation;
	}
	
	public static WebElement clickState()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlState_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchState()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlState_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickProbableAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxProbableAmt']"));
		return litigation;
	}
	
	public static WebElement clickProvisionalAmount()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtprovisionalamt']"));
		return litigation;
	}
	
	public static WebElement clickProtestMoney()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtprotestmoney']"));
		return litigation;
	}
	
	public static WebElement clickRisk1()
	{
		//litigation = getDriver().findElement(By.xpath("//div[@id='ddlRisk_chosen']"));
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseRisk_chosen']"));
		return litigation;
	}
	
	public static WebElement selectRisk2()
	{
		litigation = getDriver().findElement(By.xpath("//div[@id='ddlRisk_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickPotentialImpactRadio()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='rblPotentialImpact_0']"));
		return litigation;
	}
	
	public static WebElement clickMonetary()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxMonetory']"));
		return litigation;
	}
	
	public static WebElement clickLawFirm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']"));
		return litigation;
	}
	
	public static WebElement chooseLawFirm()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
		return litigation;
	}
	
	
	
	
	
	
	 public  static WebElement selectNoticeUploadDocument() throws InterruptedException 
	    {
	  	  
		 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	        WebElement NoticeUploadDocument = wait.until(ExpectedConditions.elementToBeClickable(By.id("FileUpLoad1")));
	  	  NoticeUploadDocument.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
	  	  Thread.sleep(3000);
	  	    return litigation;
	    }
	 
	  public  static WebElement selectNoticeRecipetDate()
      {
 	
         WebElement openDate=getDriver().findElement(By.id("txtNoticeReceiptDate"));
         return openDate;
        
      }
	 
	public static WebElement clickInternalUser()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[5]"));
		return litigation;
	}
	
	public static List<WebElement> chooseInternalUser()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNoticeAssignment']/div[1]/div/span[1]/div/ul/li/a/label/input"));
		return elementsList;
	}
	
	public static List<WebElement> chooseInternalUser1()
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/ul/li/a/label"));
		
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/button"));
		
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCaseAssignment']/div[1]/div/span[1]/div/ul/li/a/label/input"));
		//elementsList=getDriver().findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[5]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	public static WebElement clickLawyer()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[6]"));
		return litigation;
	}
	
	public static List<WebElement> chooseLawyer()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='UpdatePanel6']/div/span/div/ul/li/a/label"));
		return 		elementsList;
	}
	
	public static WebElement readTotal()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span"));
		return litigation;
	}
	
	public static WebElement readMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSNoticePopup']"));
		return litigation;
	}
	public static WebElement readMessageCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']"));
		return litigation;
	}
	public static WebElement readMessageCase1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']/ul"));
		return litigation;
	}
	public static WebElement readInvalidMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSNoticePopup']/ul"));
		return litigation;
	}
	
	public static WebElement readMessage1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']"));
		return litigation;
	}
	public static WebElement CaseInvalidreadMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']/ul/li"));
		return litigation;
	}
	
	public static WebElement clickClose()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
		return litigation;
	}
	public static WebElement clickClose3()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@id='btnAddEditcase'])[2]"));
		return litigation;
	}
	
	public static WebElement clickLinkNotice()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkLinkNotice']"));
		return litigation;
	}
	
	public static WebElement clickLinkCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickViewDoc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkActDetails']"));
		return litigation;
	}
	
	public static WebElement clickSendMail()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnSendMailPopup']"));
		return litigation;
	}
	public static WebElement clickSendMailCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkSendMailWithDoc']"));
		return litigation;
	}
	public static WebElement clickSendMail1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkSendMailWithDoc']"));
		return litigation;
	}
	
	public static WebElement clickEditNotice()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[19]/a[1]"));
		return litigation;
	}
	public static WebElement clickEditnotice()
	{
		litigation = getDriver().findElement(By.xpath("(//a[@class='k-button k-button-icontext ob-edit k-grid-edit'])[2]"));
		return litigation;
	}
	public static WebElement clickEditNotice1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnEditNoticeDetail']"));
		return litigation;
	}
	public static WebElement clickViewNoticeDoc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ViewNoticeDoc']"));
		return litigation;
	}
	public static WebElement clickViewNoticeDocpopup()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdComplianceDocument_lblViewFile_0']"));
		return litigation;
	}
	
	public static WebElement clickViewNoticeDocpopupclose()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divNoticeDocumentShowDialog']/div/div/div[1]/button"));
		return litigation;
	}
	public static WebElement clickViewNoticeDocpopupclose1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divViewDocument']/div/div/div[1]/button"));
		return litigation;
	}
	
	
	public static WebElement clickDownloadNoticeDoc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lblDownLoadfile']"));
		return litigation;
	}
	public static WebElement clickDownloadNoticeDocpopup()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdComplianceDocument_lblDownLoadfile_0']"));
		return litigation;
	}
	
	public static WebElement clickEditCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnEditCaseDetail']"));
		return litigation;
	}
	
	public static WebElement clickNoticeClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedNoticeCount']"));
		return litigation;
	}
	
	public static WebElement clickExcelReport()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
		return litigation;
	}
	public static WebElement clickExcelReport1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='exportReport2']"));
		return litigation;
	}
	
	public static WebElement clickCaseOpen()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenCaseCount']"));
		return litigation;
	}
	public static WebElement clickCaseOpencfo()
	{
		//litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenCaseCountRPA']"));
		litigation = getDriver().findElement(By.id("ContentPlaceHolder1_divOpenCaseCount"));
		//litigation = getDriver().findElement(By.xpath("(//div[@class='count'])[3]"));
		return litigation;
	}
	public static WebElement clickCaseskipfo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnSkip']"));
		return litigation;
	}
	
	public static WebElement clickCaseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtCaseDate']"));
		return litigation;
	}
	
	public static List<WebElement> clickFinanceSearchCheckbox()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='pnlCase']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		
		return elementsList;
	}
	
	public static WebElement clickFinancialYear1()
	{//Searching 'Financial Year' drop down
	
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]")));
		//litigation = getDriver().findElement(By.xpath("(//*[@class='multiselect dropdown-toggle btn btn-default'])[1]"));
		return litigation;
	}
	
	public static List<WebElement> chooseDropDownOption1()	//Searching drop down in 'Financial Year'
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@id='pnlNotice']/div[1]/div[2]/div[2]/div[2]/span[1]/div/ul/li/a/label"));
		elementsList = getDriver().findElement(By.xpath("(//*[@class='multiselect-container dropdown-menu'])[1]")).findElements(By.tagName("li"));
		return elementsList;
	}
	
	
	public static WebElement clickInternalCaseNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxInternalCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickCaseCategory()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchCaseCategory()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseCategory_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseType1() 
	{
		//WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 20);
		//WebElement CaseType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rbCaseInOutType_chosen")));
		litigation = getDriver().findElement(By.id("rbCaseInOutType_chosen"));
		return litigation;
	}
	
	public static WebElement chooseCaseType()	//Searching drop down in 'case type'
	{
		litigation=getDriver().findElement(By.xpath("//*[@id='rbCaseInOutType_chosen']/div/ul/li[2]"));

		return litigation;
	}
	
	
	public static WebElement clickCaseBudget()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseBudget']"));
		return litigation;
	}
	
	public static WebElement clickSearchBox()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[3]"));
		return litigation;
	}
	
	public static WebElement clickSearchBox1()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[4]"));
		return litigation;
	}
	
	public static WebElement clickSelectAll2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='pnlCase']/div[6]/div[1]/div[1]/span[1]/div/ul/li[2]/a/label"));
		return litigation;
	}
	
	public static WebElement clickSelectAll3()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@value='multiselect-all'])[4]"));
		return litigation;
	}
	
	public static WebElement clickCourt()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCourt_chosen']/a"));
		return litigation;
	}
	
	public static WebElement clickSearchCourt()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCourt_chosen']/div/ul/li[1]"));
		return litigation;
	}
	
	public static WebElement clickJudge()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxJudge']"));
		return litigation;
	}
	
	public static WebElement clickCaseClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedCaseCount']"));
		return litigation;
	}
	public static WebElement clickCaseClosedCFO()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedCaseCount']"));
		return litigation;
	}
	public static WebElement clickTaskOpen()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOpenTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickAddNewTask()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAdd']"));
		return litigation;
	}
	
	public static WebElement clickTaskTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskTitle']"));
		return litigation;
	}
	
	public static WebElement clickTaskDesc()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskDesc']"));
		return litigation;
	}
	
	public static WebElement clickDueDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskDueDate']"));
		return litigation;
	}
	
	public static WebElement clickPriority()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskPriorityADD_chosen']"));
		return litigation;
	}
	
	public static WebElement clickExpOutcome()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxExpOutcome']"));
		return litigation;
	}
	
	public static WebElement clickInternalUser1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchInternalUser1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickExternalUser()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSearchExternalUser()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTaskUserExternal_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxTaskRemark']"));
		return litigation;
	}
	
	public static WebElement clickUpload()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='fuTaskDocUpload']"));
		return litigation;
	}
	
	public static WebElement clickMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VsAddTasValidateSuccess']"));
		return litigation;
	}
	
	public static WebElement clickTaskInvalidMessage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VsAddTasValidate']/ul/li"));
		return litigation;
	}
	
	public static WebElement clickMessagewithoutdata()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VSCasePopup']/ul"));
		return litigation;
	}
	public static WebElement clickMessage1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VsAddTasValidate']/ul/li"));
		return litigation;
	}
	public static WebElement clickMessage2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='VsAddTasValidate']/ul"));
		return litigation;
	}
	
	public static WebElement clickTaskClearBtn()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnTaskClear']"));
		return litigation;
	}
	public static WebElement clickTaskdelete()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[9]/a[2]"));
		return litigation;
	}
	
	public static WebElement clickClose1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='javascript:reloadTaskList();']"));
		return litigation;
	}
	
	public static WebElement clickTaskClosed()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedTaskCount']"));
		return litigation;
	}
	
	public static WebElement clickStatusDropDown()
	{
		litigation = getDriver().findElement(By.xpath("(//*[@class='k-multiselect-wrap k-floatwrap'])[3]"));
		return litigation;
	}
	
	public static WebElement selectStatusDropDown()
	{
		litigation = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[40]"));
		return litigation;
	}
	public static WebElement selectStatusDropDown1()
	{
		litigation = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[41]"));
		return litigation;
	}
	public static WebElement GridLoad()
	{
		litigation = getDriver().findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']"));
		return litigation;
	}
	
	public static WebElement clickGridElement()
	{
		litigation = getDriver().findElement(By.xpath("//div[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[1]"));
		return litigation;
	}
	
	public static List<WebElement> clickAction()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	
	public static WebElement clickCheckBox()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement clickApply()
	{
		litigation = getDriver().findElement(By.xpath("//a[@id='lnkLinkCaseFilter']"));
		return litigation;
	}
	
	public static WebElement clickApply1()
	{
		litigation = getDriver().findElement(By.xpath("//a[@id='lnkLinkNoticeFilter']"));
		return litigation;
	}
	
	public static WebElement clickSave()
	{
		litigation = getDriver().findElement(By.xpath("//*[@value='Save']"));
		return litigation;
	}
	
	public static WebElement readMsg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsLinkCase']"));
		return litigation;
	}
	
	public static WebElement clickClosePopup()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divLinkNoticePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement readRef()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticeList_LinkNotice']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readRef1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'grdLinkedNotices_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickMyWorkspace()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenu']"));
		return litigation;
	}
	
	public static WebElement clickStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div/span"));
		return litigation;
	}
	
	public static WebElement clickStatusPayments()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkNoticeStatusPayment']"));
		return litigation;
	}
	
	public static WebElement clickNoticeStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickClosedStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeStatus_chosen']/div/ul/li[2]"));
		return litigation;
	}
	
	public static WebElement clickCloseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxNoticeCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickNoticeResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlNoticeResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickRemark1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCloseRemark']"));
		return litigation;
	}
	
	public static WebElement clickSave1()
	{
		litigation = getDriver().findElement(By.xpath("//input[@id='btnSaveStatus']"));
		return litigation;
	}
	
	public static WebElement readMessage2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary3']"));
		return litigation;
	}
	
	public static WebElement clickCourtCaseNo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxAppealCaseNo']"));
		return litigation;
	}
	
	public static WebElement clickSaveConvertCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnSaveConvertCase']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusPayments()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='lnkCaseStatus']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatus()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']"));
		return litigation;
	}
	
	public static WebElement clickCaseStatusClose()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']/div/ul/li[3]"));
		return litigation;
	}
	public static WebElement clickCaseStatus1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStatus_chosen']/div/ul/li[1]"));
		return litigation;
	}
	public static WebElement clickCaseAppealToNextCourt()
	{
		litigation = getDriver().findElement(By.xpath("//input[@id='btnCaseTransfer']"));
		return litigation;
	}
	public static WebElement clickCasereadMsg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary3']/ul/li"));
		return litigation;
	}
	public static WebElement clickCaseCloseDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseCloseDate']"));
		return litigation;
	}
	
	public static WebElement clickCaseResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseResult_chosen']"));
		return litigation;
	}
	
	public static WebElement clickSelectCaseResult()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseResult_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseStage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStage_chosen']"));
		return litigation;
	}
	
	public static WebElement selectCaseStage()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlCaseStage_chosen']/div/div/input"));
		return litigation;
	}
	
	public static WebElement clickCaseCheckBox()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdCaseList_LinkCase_chkRowLinkCases_0']"));
		return litigation;
	}
	
	public static WebElement readCaseRef()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grdCaseList_LinkCase']/tbody/tr[2]/td[3]/div/span"));
		return litigation;
	}
	
	public static List<WebElement> readCaseRef1()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'grdLinkedCases_lblCaseNo')]"));
		return elementsList;
	}
	
	public static WebElement clickClosePopupCase()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='divLinkCasePopup']/div/div/div[1]/button"));
		return litigation;
	}
	
	public static WebElement clickMyReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return litigation;
	}
	public static WebElement clickMoreReports()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		litigation = getDriver().findElement(By.xpath("//*[@id='MoreReport']"));
		return litigation;
	}
	public static WebElement clicklocationFilterReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return litigation;
	}
	public static WebElement selectlocationFilterReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt8']"));
		return litigation;
	}
	public static WebElement selectlocationFilterReportscfo()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt6']"));
		return litigation;
	}
	public static WebElement FromDateReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFromDate']"));
		return litigation;
	}
	public static WebElement MISReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMis']"));
		return litigation;
	}
	
	public static WebElement closedCasesReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMisCloseReport']"));
		return litigation;
	}
	public static WebElement ExtLawyerPerformanceReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnLawyerPerformance']"));
		return litigation;
	}
	public static WebElement BudgetReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnBudgetVsExpenseTracking']"));
		return litigation;
	}
	public static WebElement LawyerDetailsReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnLawyerDetails']"));
		return litigation;
	}
	public static WebElement CasePaymentReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCasepayments']"));
		return litigation;
	}
	public static WebElement CaseHearingReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCaseHearning']"));
		return litigation;
	}
	public static WebElement CourtCaseReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCourtCases']"));
		return litigation;
	}
	public static WebElement CourtOrderReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCourtOrders']"));
		return litigation;
	}
	public static WebElement CourtDoumentReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCaseDocument']"));
		return litigation;
	}
	public static WebElement noticeCovertedToCaseReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticeToCase']"));
		return litigation;
	}
	public static WebElement AllReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAll']"));
		return litigation;
	}
	
	public static WebElement clickNoticeReport()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkNotice']"));
		return litigation;
	}
	public static WebElement clickNoticePaymentReport()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticepayments']"));
		return litigation;
	}
	public static WebElement clickNoticeResponseReport()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnNoticeResponse']"));
		return litigation;
	}
	
	
	
	
	
	public static WebElement selectFromDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"));
		return litigation;
	}
	public static WebElement selectToDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a"));
		return litigation;
	}
	
	
	public static WebElement ToDateReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtToDate']"));
		return litigation;
	}
	public static WebElement AdvancedSearchReports()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='AdavanceSearch']"));
		return litigation;
	}
	public static WebElement startDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='Startdatepicker']"));
		return litigation;
	}
	
	public static WebElement endDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='Lastdatepicker']"));
		return litigation;
	}
	public static WebElement clickApplyButton()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ApplyBtnAdvanced']"));
		return litigation;
	}
	public static WebElement clickExportAdavanced()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return litigation;
	}
	public static WebElement clickShowResponseDetails()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]"));
		return litigation;
	}
	public static WebElement clickclosepopup()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
		return litigation;
	}
	
	public static WebElement clickviewNoticeDtails()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]"));
		return litigation;
	}
	
	public static WebElement CheckRecordsTable()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='grid']"));
		return litigation;
	}
	
	public static WebElement clickTypeDropdown()
	{
		litigation = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownType_listbox']"));
		return litigation;
	}
	public static WebElement clickTypeDropdown1()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[6]")));
		return litigation;
	}
	public static WebElement clickTypeDropdown2()
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[15]")));
		//litigation = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[15]"));
		return litigation;
	}
	public static WebElement clickTypeDropdown3()
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span/span/span[2]/span")));

		return litigation;
	}
	
	
	public static WebElement selectTypeNotice()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[2]"));
		return litigation;
	}
	
	public static WebElement selectTypeCase1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType1_listbox']/li[2]"));
		return litigation;
	}
	public static WebElement selectTypeCase2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownlistCase_listbox']/li[2]"));
		return litigation;
	}

	
	public static WebElement selectTypeTask()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[3]"));
		return litigation;
	}
	
	public static WebElement selectTypeTask1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownType1_listbox']/li[3]"));
		return litigation;
	}
	public static WebElement selectTypeTask2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='dropdownlistCase_listbox']/li[3]"));
		return litigation;
	}
	public static WebElement clickMyReminder()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftremindersmenu'][@class='leftdummy']"));
		return litigation;
	}
	
	public static WebElement clickAddNew1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='Addnew']"));
		return litigation;
	}
	
	public static WebElement clickType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTypePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickTitle()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ddlTitlePopup_chosen']"));
		return litigation;
	}
	
	public static WebElement clickReminderText()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtReminderTitle']"));
		return litigation;
	}
	
	public static WebElement clickDescription()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtReminderDesc']"));
		return litigation;
	}
	
	public static WebElement clickRemark2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtRemark']"));
		return litigation;
	}
	
	public static WebElement clickDate()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='txtRemindOn']"));
		return litigation;
	}
	
	public static WebElement readMsg1()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsReminder']"));
		return litigation;
	}
	
	public static WebElement readMsg2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsReminder']/ul/li"));
		return litigation;
	}
	public static WebElement readMsg3()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsReminder']/ul"));
		return litigation;
	}
	
	public static WebElement clickCloseReminder()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='CloseMyReminderPopup();']"));
		return litigation;
	}
	
	public static WebElement clickMasters()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftmastermenu']"));
		return litigation;
	}
	
	public static WebElement clickMastersMenu()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='leftmastermenu']/ul"));
		return litigation;
	}
	
	public static WebElement clickAddNew2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return litigation;
	}
	
	public static WebElement clickCaseNoticeType()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='tbxCaseType']"));
		return litigation;
	}
	
	public static WebElement readMesg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return litigation;
	}
	
	public static WebElement clickClose2()
	{
		litigation = getDriver().findElement(By.xpath("//*[@onclick='RefreshParent()']"));
		return litigation;
	}
	
	public static WebElement clickDtei()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDtevrt()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}
	
	public static WebElement clickDteir()
	{
		litigation = getDriver().findElement(By.xpath(""));
		return litigation;
	}

	
	public static WebElement readDocMsg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsContractDocument']"));
		return litigation;
	}
	public static WebElement readDocMsgInvalidMsg()
	{
		litigation = getDriver().findElement(By.xpath("//*[@id='vsContractDocument']/ul/li"));
		return litigation;
	}
	
	 public static WebElement clickNoticeDocument()
	 {
		litigation= getDriver().findElement(By.xpath("//*[@id='lnkDocument']"));
		return litigation;
		 
	 }
	 public static WebElement clickNewDocument()
	    {
		 litigation = getDriver().findElement(By.xpath("//*[@id='lnkAddNewDoctype']"));
	  	  return litigation;
	 } 
	 
	    public static void selectDocumentType()
	    {
	  	
	        WebElement DocumentType = getDriver().findElement(By.xpath ("//*[@id='ddlDocType_chosen']"));
            System.out.println("PDF");
	  	    DocumentType.click();
	    } 

		    public static void chooseDocumentType()
		    {
		    	 WebElement DocumentType = getDriver().findElement(By.xpath ("//*[@id='ddlDocType_chosen']/div/ul/li"));
		            System.out.println("pdf doc");
			  	    DocumentType.click();
		    	
		    }

	    public static void selectUploadDocument() 
	     {
	   	  
	    	WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	         WebElement UploadDocument = wait.until(ExpectedConditions.elementToBeClickable(By.id("LitigationFileUpload")));
	   	     UploadDocument.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
	   	
	     } 
		 
		 public static WebElement clickUploadDocument() 
	     {
	   	  
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
	         litigation = wait.until(ExpectedConditions.elementToBeClickable(By.id("lnkDocumentUpload")));
	    	  return litigation;
	   	
	     } 
		 
		 public static WebElement clickClosedDocument()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			 litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
			 return litigation;
			
			 
		 }
		 
		 public static WebElement readTaskMsg()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary8']"));
				return litigation;
			}
		 public static WebElement readTaskMsg1()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary8']/ul/li"));
				return litigation;
			}
		 public static WebElement readTaskMsg2()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary5']/ul"));
				return litigation;
			}
		 public static WebElement readTaskMsgcfo()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary8']/ul/li"));
				return litigation;
			}
		 
		 public static WebElement clickTaskorActivity()
		 {
			
			 litigation=getDriver().findElement(By.id("lnkNoticeTask"));
			 return litigation;
		 }
		 
		 public static WebElement clickNewTask()
		 {
			 litigation=getDriver().findElement(By.id("LinkButton2")); 
			return litigation;
		 }
		 

		public static WebElement ClickTaskTitle()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbxTaskTitle")));
			   return litigation;
		 }
		
		public static WebElement ClickTaskDescription()
		{

			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			    litigation= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbxTaskDesc']")));
			    return litigation;
			 
		 }
		
		public static WebElement selectTaskDueDate()
	    {
		
	       litigation = getDriver().findElement(By.id("tbxTaskDueDate"));
	       return litigation;
	    }
	       public static WebElement UpdatePanel1()
		    {
	    	     litigation=getDriver().findElement(By.id("UpdatePanel1"));
	    	     return litigation;
	     }
		
		public static WebElement clickInternalUser2()
	    {      
			WebElement TaskPanel=getDriver().findElement(By.id("UpdatePanel1"));
	        TaskPanel.click();
			
	        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskUserInternal_chosen']")));
          TaskPanel.click();
            return litigation;
		  }
		
		 public static WebElement selectInternalUser2() 
	      {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/ul/li[4]")));
	    	  return litigation;
	    	  
	      } 
		 public static WebElement selectInternalUser3() 
	      {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']/div/ul/li[4]")));
	    	  return litigation;
	    	  
	      } 
		
		  public static WebElement clickSaveButton() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTaskSave")));
	    	// litigation = getDriver().findElement(By.id("btnTaskSave"));
	    	  return litigation;
	    	  
	      } 

		  public static WebElement readResponseMsg()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary10']"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseMsg2()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary10']/ul/li"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseInvalidMsg()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']/ul/li"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseMsgOrder()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary2']/ul/li[1]"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseMsgOrder1()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary2']/ul/li[2]"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseMsgOrder2()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary2']/ul/li[3]"));
			 return litigation;
			  
		  }
		  public static WebElement readResponseMsg1()
		  {
			  litigation= getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
			 return litigation;
			  
		  }
		  public static WebElement readOrderMsg()
		  {
			 return litigation;
			  
		  }
		  
		  public static WebElement clickResponse()
		  {
			  
			  litigation= getDriver().findElement(By.xpath("//*[@id='lnkNoticeResponse']"));
			 return litigation;
			  
		  }
		  
		  public static WebElement clickNewResponse()
		  {
			  litigation =getDriver().findElement(By.id("LinkButton1"));
			  return litigation;
		  }
		  
		  public static void selectSentNotice()
		  {
			
			  System.out.println("Received");
			  Select sentnotice = new Select(getDriver().findElement(By.id("ddlNoticeResponseDate"))); 
			 // sentnotice .selectByVisibleText("Received");
			  sentnotice.selectByValue("1");
			
		  }
		  
		  public static void selectReplyDueDate()
		  {
			

			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  WebElement ReplyDueDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxNoticeDueDate']")));
			 ReplyDueDate.sendKeys("01-10-2022");
			
		  }
		  
		  public static void selectRespondedDate()
		  {
			  

			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  WebElement RespondedDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxResponseDate']")));
			 // WebElement RespondedDate =getDriver().findElement(By.xpath("//*[@id='tbxResponseDate']"));
			  RespondedDate.sendKeys("01-09-2022");
			  
			  WebElement ResponsePanel=getDriver().findElement(By.id("DivResponceCollapsTwo"));
			  ResponsePanel.click();
			  
		  }
		  
		  public static WebElement clickDeliveryMode()
		  {
		
//			  Select selectDeliveryMode = new Select(getDriver().findElement(By.xpath("//*[@id='ddlRespBy_chosen']"))); 
//			
//			  selectDeliveryMode.selectByValue("1");
			  litigation =getDriver().findElement(By.xpath("//*[@id='ddlRespBy_chosen']"));
			  return litigation;
			  
			  
		  }
		  
		  public static WebElement selectDeliveryMode()
		  {
		
			  litigation =getDriver().findElement(By.xpath("//*[@id='ddlRespBy_chosen']/div/div/input"));
			  return litigation;
			  
		  }
		  
		  public static WebElement clickCourierCompany()
		  {
			 litigation =getDriver().findElement(By.id("tbxRespThrough"));
			  return litigation;
		  }
		
		  
		  public static WebElement RefTrackingNo()
		  {

			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxRespRefNo']"));
			  return litigation;
			  
		  }
		
		
		  public static WebElement Description()
		  {
			  litigation =getDriver().findElement(By.xpath("//*[@id='tbxResponseDesc']"));
			 return litigation;
			  
		  }
		
		  
		  public static WebElement clickSaveResponse()
		  {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			 // litigation =getDriver().findElement((By.xpath("//*[@id='btnSaveResponse']")));
			 
			litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSaveResponse']")));
			  return litigation;
			 
			  
		  }
		  
		  public static WebElement clickExternalLawyerRating() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lnkLawyerRating']")));
	    	// litigation = getDriver().findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	      }  
		  
		  public static void selectExternalLawyerRating() 
	      {  
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		     WebElement ExternalLawyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlLayerType_chosen']")));
		     ExternalLawyer.click();
	    	 List<WebElement> ExternalLawyer1= getDriver().findElements(By.xpath("//*[@id='ddlLayerType_chosen']/div/ul/li"));
	    	 ExternalLawyer1.get(1).click();
	    		 
	      } 
		  public static WebElement clickExternalLawyerRating1() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='lnkCaseRating']")));
	    	// litigation = getDriver().findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	    	  
	      } 
		
		  
		  public static void selectCaseExternalLawyer() 
	      {

			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  WebElement ExternalLawyer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlLayerType_chosen']")));
	    
	    	 ExternalLawyer.click();
	    	  List<WebElement> options =ExternalLawyer.findElement(By.className("chosen-drop")).findElement(By.className("chosen-results")).findElements(By.tagName("li"));

				for (WebElement option : options)
				{
				    if (option.getText().equals("Amol Patil"))
				    {
				    	System.out.println(option.getText());
				        option.click(); // click the desired option
				        break;
				    }
				} 
				 
		 }
		  
		  public static WebElement clickNewCriteria() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnAddPromotor']")));
	    	// litigation = getDriver().findElement(By.xpath("//*[@id='lnkLawyerRating']"));
	    	  return litigation;
	    	  
	      } 
		  public static WebElement clickCriteria () 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxCriteria']")));
	         // litigation = getDriver().findElement(By.xpath("//*[@id='tbxCriteria']"));
	    	  return litigation;

//			  WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(), 30);
//			  WebElement criteria = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxCriteria']")));
//			 criteria.sendKeys("Test");
	    	  
	      } 
		  public static WebElement clickSaveCriteria() 
	      {
//			  WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(),30);
//			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSave']")));
	    	 litigation = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
	    	  return litigation;
	    	  
	      } 
		  
		  public static WebElement clickclosecriteria() 
	      {
//			  WebgetDriver()Wait wait = new WebgetDriver()Wait(getDriver(),30);
//			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSave']")));
	    	 litigation = getDriver().findElement(By.xpath("//*[@id='AddLayerRatingCriteriaShowDialog']/div/div/div[1]/button"));
	    	  return litigation;
	    	  
	      } 
		  
		  public static WebElement clickstar() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='grdLawyerRating_LawyerRating_0_Star_1']")));
	    	
	    	  return litigation;
	      } 
		  
		  public static WebElement clickstar1() 
	      {
			  
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='grdLawyerRating_LawyerRating_0_Star_2']")));
	    	//litigation = getDriver().findElement(By.xpath("//*[@id='grdLawyerRating_LawyerRating_9_Star_2']"));
	    	  return litigation;
	      } 
		  public static WebElement clickSaveRating() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnSaveLawRating']")));
	    	//litigation = getDriver().findElement(By.xpath("	//*[@id='btnSaveLawRating']"));
	    	  return litigation;
	      } 
		  
		  public static WebElement clickAuditLog() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='liAuditLog']")));
	    	 //litigation = getDriver().findElement(By.xpath("//*[@id='liAuditLog']"));
	    	  return litigation;
	    	  
	      } 
		
		  
		  public static WebElement clickExport() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnExport']")));
	    	// litigation = getDriver().findElement(By.xpath("//*[@id='btnExport']"));
	    	  return litigation;
	    	  
	      } 
		  
	
		  public static WebElement clickclosebutton() 
	      {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnAddEditcase']")));
	    	 //litigation = getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
	    	  return litigation;
	    	  
	      } 
		  public static WebElement clickInvoiceNo()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_tbxInvoiceNo']"));
				return litigation;
			}
		  public static WebElement clickPaymentType()
			{
			litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']"));
			return litigation;
			
			}
		  
		  public static WebElement selectPaymentType()
			{
			litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_ddlPaymentType_chosen']/div/div/input"));
			return litigation;
			
			}
		  
		  public static WebElement selectPaymentTypeCase()
			{
			litigation = getDriver().findElement(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']/div/div/input"));
			return litigation;
			
			}
		  
				
		  
		  public static WebElement clickAmount()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_tbxAmount']"));
				return litigation;
			}
		
		  public static WebElement clickSavePaymentLog()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_btnPaymentSave']"));
				return litigation;
			}
		  
		  public static WebElement readPymentmsg()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary4']/ul/li"));
				return litigation;
			}
		  public static WebElement readPymentmsg1()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary4']/ul"));
				return litigation;
			}
		  
		  public static WebElement readRatingmsg()
			{
				litigation = getDriver().findElement(By.xpath("//*[@id='ValidationSummary6']"));
				return litigation;
			}
		  public static WebElement clickCaseTask()
			{
				litigation = getDriver().findElement(By.id("lnkCaseTask"));
				return litigation;
			}
		  public static WebElement clickCaseNewTask()
		    {
		  	  litigation = getDriver().findElement(By.xpath("//*[@id='LinkButton1']"));
		  	  return litigation ;
		    }
		 public static WebElement clickHearingDate()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tbxTaskHearingDate']")));
		  	 //litigation = getDriver().findElement(By.id("tbxTaskHearingDate"));
		  	  return litigation;
		  	  
		    }
		 public static WebElement clickSaveHearingDate()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkSaveRefNo']/img")));
			
		  	 return litigation; 
		  	  
		    }
		 
		
		 public static WebElement clickSaveHearingDatecfo()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.id("lnkSaveRefNo")));
		  
		   
		  	 return litigation; 
		  	  
		    }
		 public static WebElement clickHearingDatecfo()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlHearingRefNo_chosen']/a")));
		     return litigation; 
		  	  
		    }
		 public static WebElement clickHearingDatedropdowncfo()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlHearingRefNo_chosen']/div/ul/li[2]")));
		     return litigation; 
		  	  
		    }
		 public static WebElement clickHearingcfo()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTabHearingRef_chosen']")));
		     return litigation; 
		  	  
		    }
		 public static WebElement clickHearingdropdowncfo()
		    {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlTabHearingRef_chosen']/div/ul/li[3]")));
		     return litigation; 
		  	  
		    }
		 
		 
		 public static WebElement clickInternalUser3()
		    {      
//				WebElement TaskPanel=getDriver().findElement(By.id("UpdatePanel1"));
//		        TaskPanel.click();
				
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ddlTaskLawyerListInternal_chosen']")));
				
				 
				return litigation;

			  }
		 public static WebElement clickCaseHearing()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkCaseHearing']")));
			// litigation=getDriver().findElement(By.xpath("//*[@id='lnkCaseHearing']"));
			 return litigation;
		 }
		 public static WebElement clickNewCaseHearing()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkAddhearing']")));
			 //litigation=getDriver().findElement(By.xpath("//*[@id='lnkAddhearing']"));
			 return litigation;
		 }
		 
		 public static WebElement clickCaseHearingDate()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxTabHearingDate']")));
			   return litigation;
		 }
		 
		 public static WebElement clickSaveCaseHearingDate()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				//litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lnkTabSaveRefNo']")));
				litigation=getDriver().findElement(By.xpath("//*[@id='lnkTabSaveRefNo']"));
				
		       return litigation;
		 }
		 public static WebElement clickCaseHearingDecsri()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxResponseDesc']"));
			 return litigation;
		 }
		 public static WebElement clickSaveCaseHearing()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='btnSaveHearing']"));
			 return litigation;
		 }
		
		 public static WebElement clickCaseOrder()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='lnkCaseOrder']"));
			 return litigation;
		 }
		 public static WebElement clickNewCaseOrder()
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='LinkButton3']")));
			// litigation=getDriver().findElement(By.xpath("//*[@id='AddNewOrderDiv']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderDate()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxOrderDate']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderType()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='ddlOrderType_chosen']"));
			 return litigation;
		 }
		 public static WebElement selectCaseOrderType()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='ddlOrderType_chosen']/div/ul/li[2]"));
			 return litigation;
		 }
		 
		 public static WebElement clickCaseOrderTitle()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxOrderTitle']"));
			 return litigation;
		 }
		 public static WebElement clickCaseOrderDecri()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxOrderDesc']"));
			 return litigation;
		 }
		
		 public static WebElement clickSaveCaseOrder()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='btnOrderSave']"));
			 return litigation;
		 }
		 public static WebElement clickClearCaseOrderBtn()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='btnOrderClear']"));
			 return litigation;
		 }
		 
		 public static WebElement clickOrderPanel()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='collapseDivOrderLogs']"));
			 return litigation;
		 }
		 public static WebElement clickAdvocateBillGridload()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='id='imgUpdateProgress']"));
			 return litigation;
		 }
		 
		 public static WebElement clickAdvocateBill()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='lnkCaseAdvocateBill']"));
			 return litigation;
		 }
		 public static WebElement clickNewAdvocateBill()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='LnkAddAdvocateBill']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceNum()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxAdvInvoiceno']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceDate()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxinvoicedate']"));
			 return litigation;
		 }
		 public static WebElement clickInvoiceAmount()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='tbxAdvInvoiceAmount']"));
			 return litigation;
		 }
		 public static WebElement clickLawFirm1()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='ddlLawyerAdvocate_chosen']"));
			 return litigation;
		 }
		 public static WebElement selectLawFirm1()
		 {
	
			 litigation=getDriver().findElement(By.xpath("//*[@id='dlLawyerAdvocate_chosen']/div/ul/li[3]"));
			 return litigation;
	    }
		 public static WebElement selectLawFirm2()
		 {
	
			// elementsList=getDriver().findElements(By.xpath("//*[@id='ddlLawyerAdvocate_chosen']/div/ul/li"));
			 litigation=getDriver().findElement(By.cssSelector("#ddlLawyerAdvocate_chosen > div > ul > li:nth-child(3)"));
			 return litigation; 
			
	    }
		 public static WebElement clickMinimiz()
			{
				litigation=getDriver().findElement(By.xpath("//a[@class='btn-minimize']"));
				return litigation;
			}

		public static WebElement clickApprover1()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='ddlApprover1_chosen']"));
			 return litigation;
		 }
		 public static List<WebElement> selectApprover1() throws InterruptedException
		 {
			 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			 elementsList=getDriver().findElements(By.xpath("//*[@id='ddlApprover1_chosen']/div/ul/li"));
		      return elementsList; 
		
		 }
		 public static WebElement clickApprover2()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='ddlApprover2_chosen']"));
			 return litigation;
		 }
		 public static List<WebElement> selectApprover2()
		 {
			 elementsList=getDriver().findElements(By.xpath("//*[@id='ddlApprover2_chosen']/div/ul/li"));
		      return elementsList; 
		 }
		 public static WebElement clickSaveAdvocateBill()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='btnAdvocateBillSave']"));
			 return litigation;
		 }
		 public static WebElement clickAdvocateBillPanel()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='collapseDivAdvocateBillLogs']"));
			 return litigation;
		 }
		
		 public static WebElement clickCaseInvoiceNo1()
		 {
			 litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_tbxInvoiceNo']"));
			 return litigation;
		 }
		  public static WebElement clickPaymentTyp1()
				{
			        litigation = getDriver().findElement(By.xpath("//*[@id='grdCasePayment_ddlPaymentType_chosen']"));
				    return litigation;
					
				}
			  
		  public static WebElement clickAmount1()
			 {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grdCasePayment_tbxAmount']")));
			  return litigation;
			 }
		  public static WebElement clickSavePaymentLog1()
			 {
				 litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_btnPaymentSave']"));
				 return litigation;
			 }
		  public static WebElement clickAmountPaid()
			 {
				 litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_tbxAmountPaid']"));
				 return litigation;
			 }
		  
		  
		  public static WebElement clickMyDocument()
			 {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			    litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftdocumentsmenu']/a/span[1]")));
	            return litigation;
			 }
		  public static WebElement clickmyDocument()
			{
		
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DocumentShareListNew']")));
			 
			   return litigation;
			   
			}
		  public static WebElement clickcriticalDocument()
			{
		
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='DocumentShareListNew']/a)[2]")));
			 
			   return litigation;
			   
			}
		  public static WebElement clickDownloadDocument()
			{
		
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[16]/a[1]")));
			 
			   return litigation;
			   
			}
		  public static WebElement clickDownloadDocument1()
			{
		
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[14]/a[1]")));
			 
			   return litigation;
			   
			}
		    public static WebElement clickViewDocument()
			{
		
		    	WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[16]/a[2]")));
			 
			   return litigation;
			 }

		    public static WebElement clickViewDocument1()
			{
		
		    	WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[14]/a[2]")));
			 
			   return litigation;
			 }
		    
		    
		    public static WebElement clickcloseViewDocument()
			{
		
		    	WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divViewDocument2']/div/div/div[1]/button")));
			 
			   return litigation;
			   
			}
		  
		    public static WebElement clickcloseViewDocument1()
			{
		
		    	WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		      litigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divViewDocument1']/div/div/div[1]/button")));
			 
			   return litigation;
			   
			}
		  public static WebElement ClickImportUtility()
		  {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftuploadmenu']/a/span[1]")));
			  return litigation;
		  }
		  public static WebElement ChooseCaseType()
		  {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoCCUpload']")));
			  return litigation;
		  }
		  public static WebElement ChooseCaseUpdationType()
		  {
			  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoCUUpload']")));
			  return litigation;
		  }
		  public static WebElement ChooseCaseFile() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Case_Upload_Format.xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseFile1() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Case_Upload_Format (1).xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseFile2() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Case_Upload_Format (2).xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseFile3() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Case_Upload_Format (3).xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseUpdationFile() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\CaseUpdation.xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseUpdationFile1() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\CaseUpdation-EmptyFile.xlsx");
			     return litigation;
	      }
		  public static WebElement ChooseCaseUpdationFile2() throws InterruptedException
		  {
			  
			     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
			    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\CaseUpdation-Invalid Data.xlsx");
			     return litigation;
	      }
		  public static WebElement UploadCaseFile() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUploadFile']"));
			  return litigation;
		  }
		  
		  
		  
		  public static WebElement readCaseMsg() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']"));
			  return litigation;
		  }
		  public static WebElement readCaseMsg2() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li"));
			  return litigation;
		  }
		  public static WebElement readCaseMsg1() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li"));
			  return litigation;
		  }
		  public static WebElement ClickcaseHearing() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCHUpload']"));
			  return litigation;
		  }
		  
		  public static WebElement ClickcaseOrder() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCOUpload']"));
			  return litigation;
		  }
		  public static WebElement ClickcasePayment() throws InterruptedException
		  {
			  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoCPUpload']"));
			  return litigation;
		  }
		  
		  
		  

        public static WebElement clickNotice() throws InterruptedException
          {
              litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLN']"));
               return litigation;
           }
        
  	  public static WebElement ChooseNoticeType()
	  {
  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoLNUpload']")));
		  return litigation;
	  }
  	 public static WebElement ChooseNoticeUpdationType()
	  {
  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoNUUpload']")));
		  return litigation;
	  }
  	  
  	  public static WebElement ChooseNoticeResponse()
	  {
  		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoNRUpload']")));
		  return litigation;
	  }
  	  
	  public static WebElement ChoosePaymentInfo()
	  {
		  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		  litigation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rdoPIUpload']")));
		  return litigation;
	  }
  	    
	  public static WebElement ChooseNoticeFile() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Notice_Upload_Format.xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeUpdationFile() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\NoticeUpdation.xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeFile1() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Notice_Upload_Format (1).xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeFile2() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Notice_Upload_Format (2).xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeFile3() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\Litigation_Notice_Upload_Format (3).xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeUpdtionEmptyFile() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\NoticeUpdation-EmptyFile.xlsx");
		     return litigation;
      }
	  public static WebElement ChooseNoticeUpdtionInvalidData() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.cssSelector("input[type='file']"));
		    CaseFile.sendKeys("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\NoticeUpdation-Invalid Data.xlsx");
		     return litigation;
      }
	  public static WebElement ChooseOrderFile() throws InterruptedException
	  {
		  
		     WebElement CaseFile=getDriver().findElement(By.xpath("//*[@id='fuCaseOrderDocUpload']"));
		    CaseFile.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
		     return litigation;
      }
	  public static WebElement UploadNoticeFile() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUploadFileLN']"));
		  return litigation;
	  }
	  
	  public static WebElement readNoticeMsg() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']"));
		  return litigation;
	  }
	  public static WebElement readNoticeMsg1() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraph() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		  return litigation;
	  }
	  
	  
	  public static WebElement readTotalItemsD() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraphExport() throws InterruptedException
	  {
		  
		  WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		  litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exportReport']")));
		 // litigation=getDriver().findElement(By.cssSelector("button[id='exportReport']"));
		  return litigation;
	  }
	  
	  public static WebElement CaseNoticeTypeOutwardPalintiffCaseGraph() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 ']"));
		  return litigation;
	  }
	  public static WebElement CaseNoticeStageSummaryGraph() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[2]"));
		  return litigation;
	  }
	  public static WebElement RiskSummaryGraph() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[3]"));
		  return litigation;
	  }
	  public static WebElement RiskSummaryGraphCase() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])"));
		  return litigation;
	  }
	  public static WebElement DepartmentSummaryGraph() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
		  return litigation;
	  }
	  public static WebElement DepartmentSummaryGraph3() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
		  return litigation;
	  }
	  public static WebElement LocationSummaryGraph() throws InterruptedException
	  {
		 
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[5]"));
	
		  return litigation;
	  }
	  public static WebElement LocationSummaryGraph1() throws InterruptedException
	  {
		 
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[4]"));
	
		  return litigation;
	  }
	  public static WebElement LocationSummaryGraphCase() throws InterruptedException
	  {
		 
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[5]"));
	
		  return litigation;
	  }
	  
	  public static WebElement CategorySummaryGraph() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[8]"));
		  return litigation;
	  }
	  public static WebElement CategorySummaryGraph1() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[5]"));
		  return litigation;
	  }
	  public static WebElement CategorySummaryGraphCase1() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[10]"));
		  return litigation;
	  }
	  public static WebElement CategorySummaryGraphCase() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[5]"));
		  return litigation;
	  }
	  
	  public static WebElement caseNoticeSummaryGraphClose() throws InterruptedException
	  {
		  
		  litigation=getDriver().findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
		 // litigation=getDriver().findElement(By.cssSelector("button[id='exportReport']"));
		  return litigation;
	  }
	  
	  

	  public static WebElement TableLoad() throws InterruptedException
	  {
		  litigation=getDriver().findElement(By.xpath("//*[@id='grid']"));
		  return litigation;
	  }
	  
	  
	  
		public static WebElement chooseMasterLegalEntity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[1]/a")));
			//WebElement LawFirm = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
			return litigation;
			
		}
		
		public static WebElement addLegalEntity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddCustomerBranch']")));
			return litigation;
		}
	  
		public static WebElement legalEntityName()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxName']")));
			return litigation;
		}
		
		
	
	  
		public static WebElement clickUnitType()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlType']")));
			return litigation;
		}
		public static WebElement chooseUnitType()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlType']/option[2]")));
			return litigation;
		}
		public static WebElement clickLegalEntityType()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompanyType']")));
			return litigation;
		}
		public static WebElement chooseLegalEntityType()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompanyType']/option[2]")));
			return litigation;
		}
		public static WebElement editLegalEntity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomerBranch_LinkButton1_0']/img")));
			return litigation;
		}
		
		
		public static WebElement clickAddressLine()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxAddressLine1']")));
			return litigation;
		}
  	  
		public static WebElement clickState1()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlState']")));
			return litigation;
		}
        
		public static WebElement chooseState1()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlState']/option[92]")));
			return litigation;
		}
        
        
		public static WebElement clickCity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCity']")));
			return litigation;
		}
        
		public static WebElement chooseCity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlCity']/option[3]")));
			return litigation;
		}
        
		public static WebElement clickContactPerson()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactPerson']")));
			return litigation;
		}
		public static WebElement clickEmail()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
			return litigation;
		}
		
		public static WebElement clickSaveLegalEntity()
		{
			
			litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']"));
			return litigation;
		}
		public static WebElement clickcloseLegalEntity()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
			return litigation;
		}
		
		public static WebElement readlegalmsg()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_valcustomerbranch']")));
			return litigation;
		}
		public static WebElement readlegalmsg1()
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_valcustomerbranch']/ul")));
			return litigation;
		}
		
		public static WebElement chooseMasterLawFirm()
		{
			litigation=getDriver().findElement(By.xpath("//*[@id='Mastersubmenu']/li[2]/a"));
			//WebElement LawFirm = getDriver().findElement(By.xpath("//*[@id='ddlLawFirm_chosen']/div/div/input"));
			return litigation;
			
		}
		  public static WebElement newLawFirm()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddLaywer']"));
				return litigation;
				
			}
			
			public static WebElement  nameLawFirm()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
				return litigation;
			}
			
			public static WebElement Email()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
				return litigation;
			}
		 
			public static WebElement contactNo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
				return litigation;
			}
			public static WebElement opponentcontactNo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxContactNo']")));
				return litigation;
			}
			
			public static WebElement ReadLawFirmMsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li")));
				return litigation;
			}
			public static WebElement ReadLawFirmMsg1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul")));
				return litigation;
			}
			
			public static WebElement clickSaveLawFirm()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
				return litigation;
			}
			

			public static WebElement clickCloseButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
				return litigation;
			}
			
			public static WebElement editLawFirm()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLawyer_lbtnEdit_0']/img")));
				return litigation;
			}
			
			public static WebElement clickAddNewLawyer()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLawyer_lbtAddLawyer_0']/img")));
				return litigation;
			}
			
			public static WebElement clickLawyerName()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstNameUser']")));
				return litigation;
			}
			
			public static WebElement clickLawyerLastName()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastNameUser']")));
						
				return litigation;
			}
			
			public static WebElement clickLawyerDesignation()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
						
				return litigation;
			}
			public static WebElement clickLawyerEmail()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmailUser']")));
						
				return litigation;
			}
			public static WebElement clickLawyerContactNo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNoUser']")));
						
				return litigation;
			}
			
			public static WebElement clickLawyerDepartment()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
						
				return litigation;
			}
			public static WebElement selectLawyerDepartment()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[3]")));
						
				return litigation;
			}
			public static WebElement clickLawyerRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']")));
						
				return litigation;
			}
			public static WebElement selectLawyerRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']/option[2]")));
						
				return litigation;
			}
			public static WebElement readLawyerMsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul/li")));
						
				return litigation;
			}
			
			public static WebElement readLawyerMsg1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul")));
						
				return litigation;
			}
			public static WebElement saveLawyer()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_SaveLawyer']")));
						
				return litigation;
			}
			public static WebElement closeLawyer()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divUserDialog']/div/div/div[1]/button")));
						
				return litigation;
			}
			public static WebElement CloseLawyer()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ContentPlaceHolder1_CloseLaywerPopUp']")));
						
				return litigation;
			}
			
			public static WebElement clickUserMaster()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[3]/a")));
				return litigation;
			}
			
			public static WebElement clickAddNewUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddUser']")));
				return litigation;
			}
			
			public static WebElement clickUserName()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
				return litigation;
			}
			
			public static WebElement clickUserLastName()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastName']")));
						
				return litigation;
			}
			
			public static WebElement clickUserDesignation()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
						
				return litigation;
			}
			public static WebElement clickUserEmail()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
						
				return litigation;
			}
			public static WebElement clickUserContactNo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
						
				return litigation;
			}
			
			public static WebElement clickUserDepartment()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
						
				return litigation;
			}
			public static WebElement selectUserDepartment()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[3]")));
						
				return litigation;
			}
			public static WebElement clickUserRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']")));
						
				return litigation;
			}
			public static WebElement selectUserRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLitigationRole']/option[2]")));
						
				return litigation;
			}
			
			public static WebElement saveUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
						
				return litigation;
			}
			public static WebElement closeUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
						
				return litigation;
			}
			public static WebElement editUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnEdit_0']/img")));
						
				return litigation;
			}
			
			public static WebElement UserAddress()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxAddress']")));
						
				return litigation;
			}
			public static WebElement UserReadMsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul/li")));
						
				return litigation;
			}
			public static WebElement UserReadMsg1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_vsUserPopup']/ul")));
						
				return litigation;
			}
			public static WebElement UserDeleted()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnDelete_0']/img")));
						
				return litigation;
			}
			
			
			
			public static WebElement chooseOpponentMasters()
			{
				
				litigation =getDriver().findElement(By.xpath("//*[@id='Mastersubmenu']/li[4]/a"));
						
				return litigation;
			}
			public static WebElement NewOpponent()
			{
				
				litigation =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
						
				return litigation;
			}
			public static WebElement clickOpponentName()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='tbxName']"));
			    return litigation;
			}
			public static WebElement clickOpponentEmail()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='tbxEmail']"));
			    return litigation;
			}
			
			public static WebElement  opponentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rbPartyType_1']")));
				return litigation;
			}
			public static WebElement  readOppoenentMsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ValidationSummary1']/ul/li")));
				return litigation;
			}
			public static WebElement  readOppoenentMsg1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ValidationSummary1']/ul")));
				return litigation;
			}
			public static WebElement  saveOpponent()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement  closeOpponent()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement  editOpponent()
			{
				
				litigation =getDriver().findElement(By.xpath("//img[@alt='Edit Details']"));
				return litigation;
			}
			
			public static WebElement  clickCourtMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[5]/a")));
				return litigation;
			}
			public static WebElement  clickNewCourt()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickCourtName()
			{
				//WebgetDriver()Wait wait= new WebgetDriver()Wait(getDriver(),300);
				//litigation =wait.until(ExpectedConditions.elementToBeClickable(By.id("tbxCourtName")));
			//	litigation =getDriver().findElement(By.id("tbxCourtName"));
				
				//WebgetDriver()Wait wait= new WebgetDriver()Wait(getDriver(),30);
				litigation =getDriver().findElement(By.xpath("//*[@id='tbxCourtName']"));
				
				
				
				return litigation;
			}
			public static WebElement  clickCourtType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCourtType_chosen']")));
				return litigation;
			}
			
			public static WebElement  selectCourtType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCourtType_chosen']/div/ul/li[3]")));
				return litigation;
			}
			
			public static WebElement  clickCountry()
			{
//				WebgetDriver()Wait wait= new WebgetDriver()Wait(getDriver(),30);
				litigation =getDriver().findElement(By.xpath("//*[@id='ddlCountry_chosen']"));
				return litigation;
			}
			
			public static WebElement  selectCountry()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlCountry_chosen']/div/ul/li[1]")));
				return litigation;
			}
			
			
			
			public static WebElement  saveCourt()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
	
			
			
			public static WebElement  closeCourt()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			public static WebElement  editCourt()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCourtMaster_lbtcourMedit_0']/img")));
				return litigation;
			}
			public static WebElement deleteCourt()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCourtMaster_lbtcourMdelete_0']/img")));
				return litigation;
			}
			
			
			public static WebElement  clickCasNoticeTypecfo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Case/Notice Type")));
				return litigation;
			}
			
			
			public static WebElement  clickCasNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[6]")));
				return litigation;
			}
			
			public static WebElement  NewCaseNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement  CaseNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='upPromotor']/div/div[2]/div/span[1]/div/button")));
				return litigation;
			}
			public static WebElement  selectCaseNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='upPromotor']/div/div[2]/div/span[1]/div/ul/li[2]/a/label/input")));
				return litigation;
			}
			
			public static WebElement  TypeName()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxCaseType']")));
				return litigation;
			}
			
			public static WebElement  saveCaseNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement  closeCaseNoticeType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement  editCaseNoticeType()
			{
				//WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =getDriver().findElement(By.id("ContentPlaceHolder1_grdCaseType_LinkButton1_0"));
				return litigation;
			}
			
			public static WebElement  deleteCaseNoticeType()
			{
				//WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdCaseType_LinkButton2_0']/img"));
				return litigation;
			}
			
			
			public static WebElement  clickPaymentTypeMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[7]/a")));
				return litigation;
			}
			
			public static WebElement  clickPaymentTypeNew()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPayment']")));
				return litigation;
			}
			public static WebElement PaymentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtFName']")));
				return litigation;
			}
			
			
			public static WebElement savePaymentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closePaymentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancelDeptPopUp']")));
				return litigation;
			}
			public static WebElement editPaymentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPayment_LinkButton1_0']/img")));
				return litigation;
			}
			public static WebElement deletePaymentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPayment_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			public static WebElement customParameterMaster()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[8]/a")));
				return litigation;
			}
			public static WebElement newCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAdd']")));
				return litigation;
			}
			public static WebElement typeCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='AddCustFieldDiv']/div/div[2]/span[1]/div/button")));
				return litigation;
			}
			public static WebElement selectTypeCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='AddCustFieldDiv']/div/div[2]/span[1]/div/ul/li[2]")));
				return litigation;
			}
			
			public static WebElement ParameterLabel()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxLableName']")));
				return litigation;
			}
			public static WebElement saveCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closeCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement editCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomFieldList_lblEdit_0']/img")));
				return litigation;
			}
			public static WebElement deleteCustomParameter()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomFieldList_lblDelete_0']/img")));
				return litigation;
			}
			
			public static WebElement caseStageMaster()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[9]/a")));
				return litigation;
			}
			public static WebElement newCaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickcaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxcasestageType']")));
				return litigation;
			}
			public static WebElement readcaseStagemsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='vsAddEditCaseStageType']/ul/li")));
				return litigation;
			}
			
			
			public static WebElement savecaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closecaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			
			public static WebElement editcaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdcaseStageType_LinkButton1_0']/img")));
				return litigation;
			}
			
			
			public static WebElement deletecaseStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdcaseStageType_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			
			public static WebElement DocumentTypeMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[10]/a")));
				return litigation;
			}
			public static WebElement NewDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']")));
				return litigation;
			}
			public static WebElement clickDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxDocumentType']")));
				return litigation;
			}
			public static WebElement saveDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
				return litigation;
			}
			public static WebElement closeDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCancel']")));
				return litigation;
			}
			public static WebElement editDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDocType_lnkEditDocType_0']/img")));
				return litigation;
			}
			
			public static WebElement deleteDocumentType()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDocType_lnkDeleteDocType_0']/img")));
				return litigation;
			}
			
			
			public static WebElement ratingCriteriaMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[11]/a")));
				return litigation;
			}
			public static WebElement clickcriteria()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbxCriteria']")));
				return litigation;
			}
			
			public static WebElement editcriteria()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCriteriaMaster_LinkButton1_0']/img")));
				return litigation;
			}
			public static WebElement deletecriteria()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdCriteriaMaster_LinkButton2_0']/img")));
				return litigation;
			}
			
			
			
			
			public static WebElement pageAuthorizationaMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[12]/a")));
				return litigation;
			}
			public static WebElement clickUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUserType_chosen']/a/span")));
				return litigation;
			}
			public static WebElement selectUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUserType_chosen']/div/ul/li[2]")));
				return litigation;
			}
			public static WebElement clickAddButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkADD_0']")));
				return litigation;
			}
			
			public static WebElement clickUpdateButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkupdate_0']")));
				return litigation;
			}
			public static WebElement clickDeleteButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkDelete_0']")));
				return litigation;
			}
			public static WebElement clickViewButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdPageAuthorization_chkView_0']")));
				return litigation;
			}
			public static WebElement clicksaveButton()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSavePageAutorization']")));
				return litigation;
			}
			
			public static WebElement readPageAuthoMsg()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary2']/ul/li")));
				return litigation;
			}
			
			
			public static WebElement noticeStageMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[15]/a")));
				return litigation;
			}
			public static WebElement noticeStagecfoMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[12]")));
				return litigation;
			}
			public static WebElement addNoticeStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[1]/div/a")));
				return litigation;
			}
			public static WebElement clickNoticeStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[1]/input")));
				return litigation;
			}
			public static WebElement updateNoticeStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[1]")));
				return litigation;
			}
			public static WebElement editNoticeStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[1]")));
				return litigation;
			}
			public static WebElement deleteNoticeStage()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/a[2]")));
				return litigation;
			}
			
			
			public static WebElement UserReassignmentMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[15]/a")));
				return litigation;
			}
			public static WebElement UserReassignmentcfoMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[13]")));
				return litigation;
			}
			
			public static WebElement clickUser1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[1]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectUser1()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlUsers_listbox']/li[1]")));
				return litigation;
			}
			public static WebElement clickAssigntoUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[2]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectAssigntoUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlAssignUsers_listbox']/li[2]")));
				return litigation;
			}
			public static WebElement selectcheckBox()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridCases']/div[2]/table/tbody/tr[1]/td[1]/label")));
				
						//*[@id='gridCases']/div[2]/table/tbody/tr[1]/td[1]
			     return litigation;
			     
			}
			 public static void selectcheckBoxcfo()
			 {	
					WebElement checkBoxSelected = getDriver().findElement(By.cssSelector("label[class='k-checkbox-label k-no-text']"));
					boolean isSelected = checkBoxSelected.isSelected();

					// performing click operation if element is not selected 
					if(isSelected == false) 
					{
						checkBoxSelected.click();
					}
			 }  
       
			

			public static WebElement clickAssignButoon()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnAssignTo']")));
				return litigation;
			}
			public static WebElement clicknotice()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[2]/span[2]")));
				return litigation;
			}
			
			
			public static WebElement selectNoticeCheckkBox()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridNotices']/div[2]/table/tbody/tr[1]/td[1]/label")));
				return litigation;
			}
			public static WebElement clickTask()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[3]/span[2]")));
				return litigation;
			}
			public static WebElement selectTaskCheckkBox()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridTask']/div[2]/table/tbody/tr[1]/td[1]/label")));
				return litigation;
			}
			public static WebElement clickAutidLog()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tabstripAssignment']/ul/li[4]/span[2]")));
				return litigation;
			}
			
			public static WebElement MailAuthorizationMasters()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[16]/a")));
				return litigation;
			}
			public static WebElement MailAuthorizationMasterscfo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[14]/a")));
				return litigation;
			}
			
			public static WebElement clickTypeOfUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectTypeOfUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownUserType_listbox']/li[1]")));
				return litigation;
			}
			public static WebElement clickRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[2]/span/span/span[1]")));
				return litigation;
			}
			public static WebElement selectRole()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownRole_listbox']/li[2]")));
				return litigation;
			}
			public static WebElement clickUsers()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divusers']/div/div")));
				return litigation;
			}
			
			public static WebElement clickSearchBoxUser()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[11]/div/span/input")));
				return litigation;
			}
			
		
			public static WebElement selectUsers()
			{
		    
			  
			    
			    litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[9]"));
				
				return litigation;
			}
			
	
			public static WebElement clickMailServices()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='childrow']/div/div[1]/div[4]/div/div/span[1]")));
				return litigation;
			}
			
			public static WebElement clickSearchBoxMail()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/span/input")));
				return litigation;
			}
			
			
			
			public static WebElement selectMailService()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-checkbox-wrapper'])[2]")));
				return litigation;
			}
			public static WebElement clickEnable()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnEnabledMail']")));
				return litigation;
			}
			public static WebElement clickExportMail()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[1]/a")));
				return litigation;
			}
			public static WebElement clickDisable()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnDisabledMail']")));
				return litigation;
			}
			
			public static WebElement clickCaseNoticeStageHearingGraph()
			{
				
				litigation =getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[2]"));
				return litigation;
			}
			public static WebElement clickCaseNoticeStageHearingGraph1()
			{
				
				litigation =getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[2]"));
				return litigation;
			}
			public static WebElement clickCaseNoticeStageHearingExport()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exportReport']")));
				return litigation;
			}
			
			public static WebElement clickGridCount()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
				return litigation;
			}
			public static WebElement clickLocationFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickExpand()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]"));
				return litigation;
			}
			
			public static WebElement SelectLocation()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='A/Bita Pharma Company'])[1]"));
				return litigation;
			}
			public static WebElement SelectDocLocation()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Karnataka Pvt Ltdd'])[1]"));
				return litigation;
			}
			public static WebElement SelectLocationCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[109]"));
				return litigation;
			}
			public static WebElement SelectLocationWorkspace()
			{
				litigation=getDriver().findElement(By.xpath("(//span[contains(text(),'A/Bita Pharma Company')])[1]"));
				return litigation;
			}
			public static WebElement SelectLocationWorkspaceCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[413]"));
				return litigation;
			}
			public static WebElement SelectLocationDoceNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABC Mall, Thane'])[1]"));
				return litigation;
			}
			public static WebElement SelectLocationCase()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABC Mall, Thane'])[1]"));
				return litigation;
			}
			public static WebElement SelectLocationWorkspaceNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABC'])[1]"));
				return litigation;
			}
			public static WebElement clickLocationFilter4()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[268]"));
				return litigation;
			}
			public static WebElement clickCaseNotice()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div[2]/div/span[1]"));
				return litigation;
			}
			
			public static WebElement selectCaseNotice()
			{
				litigation=getDriver().findElement(By.xpath("//span[normalize-space()='Case']"));
				return litigation;
			}
			
			public static WebElement clickStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath(" //span[normalize-space()='Closed']"));
				return litigation;
			}
			
			public static WebElement selectStatusFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[138]"));
				return litigation;
			}
			
			public static WebElement clickDepartmentFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div[4]/div/span[1]"));
				return litigation;
			}
			
			public static WebElement selectDepartmentFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABCD'])[1]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[74]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilter1()
			{

				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[56]"));
				return litigation;
			}
			public static WebElement clickRiskFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div[6]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectRiskFilter()
			{
				litigation=getDriver().findElement(By.xpath("//span[@class='k-in'][normalize-space()='High']"));
				return litigation;
			}
			public static WebElement selectRiskFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[31]"));
				return litigation;
			}
			public static WebElement selectRiskFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[137]"));
				return litigation;
			}
			public static WebElement clickAgeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement selectAgeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='drpAgeing_listbox']/li[1]"));
				return litigation;
			}
			public static WebElement clickCategoryFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[2]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectCategoryFilter()
			{
				litigation=getDriver().findElement(By.xpath("//span[normalize-space()='Judicial notice']"));
				return litigation;
			}
			public static WebElement selectCategoryFilterGraph()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='abc'])[1]"));
				return litigation;
			}
			public static WebElement selectCategoryFilterGraph1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Tax Laws'])[2]"));
				return litigation;
			}
			public static WebElement selectCategoryFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[19]"));
				return litigation;
			}
			public static WebElement selectCategoryFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[5]"));
				return litigation;
			}
			
			
			public static WebElement clickStageFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[3]/div[2]/div[2]/div"));
				return litigation;
			}
			public static WebElement selectStageFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[39]"));
				return litigation;
			}
			
			public static WebElement selectNotice1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[183]"));
				return litigation;
			}
			public static WebElement clickCaseNoticeType1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[3]/div[1]/div[5]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectCaseNoticeType1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[29]"));
				return litigation;
			}
			public static WebElement clickTrignle()
			{
				litigation=getDriver().findElement(By.xpath("//span[@class='k-icon k-i-more-vertical']"));
				return litigation;
			}
			public static WebElement clickTrignle1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-more-vertical'])[3]"));
				return litigation;
			}
			public static WebElement clickTrignle2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-more-vertical'])[6]"));
				return litigation;
			}
			public static WebElement clickFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[normalize-space()='Filter'])[1]"));
				return litigation;
			}
			public static WebElement clickSearchFilterworkspace()
			{
				litigation=getDriver().findElement(By.xpath("//input[@placeholder='Search']"));
				return litigation;
			}
			public static WebElement clickSearchFilterworkspace1()
			{
				litigation=getDriver().findElement(By.xpath("//input[@placeholder='Search']"));
				return litigation;
			}
			public static WebElement clickCheckboxcfo()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='mgmt regtrack']"));
				return litigation;
			}
			public static WebElement clickCheckbox2()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='company admin']"));
				return litigation;
			}
			public static WebElement clickCheckbox3()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='performer a']"));
				return litigation;
			}
			public static WebElement clickCheckbox4()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='Lawyer ABCD']"));
				return litigation;
			}
			public static WebElement clickFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//button[@class='k-button k-primary']"));
				return litigation;
			}
			public static WebElement clickCheckbox()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='12344']"));
				return litigation;
			}
			public static WebElement clickCheckbox1()
			{
				litigation=getDriver().findElement(By.xpath("//input[@value='4658461']"));
				return litigation;
			}
			public static WebElement clickCol()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-link'])[3]"));
				return litigation;
			}
			public static WebElement clickColCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-link'])[7]"));
				return litigation;
			}
			public static WebElement clickRiskcol()
			{
				litigation=getDriver().findElement(By.xpath("(//input[@data-field='RiskType'])[2]"));
				return litigation;
			}
			public static WebElement clickRiskcolCA()
			{
				litigation=getDriver().findElement(By.xpath("//input[@data-field='RiskType']"));
				return litigation;
			}
			
			
        	public static WebElement clearButton()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
				return litigation;
			}
			
			
			public static WebElement CaseHearingCount() 
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_divPendingHearing']")));
				return litigation;
			}
			public static WebElement CaseHearingGridCount() 
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridPendingUpdation']/div[3]/span[2]")));
				return litigation;
			}
			public static WebElement CaseHearingExport() 
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnexport']")));
				return litigation;
			}
			public static WebElement CaseHearingView() 
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gridPendingUpdation']/div[2]/table/tbody/tr[1]/td[7]/a")));
				return litigation;
			}
			public static WebElement CaseHearingPopupClose() 
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")));
				return litigation;
			}
			
			
			public static WebElement HearingCalender()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div[13]/a")));
				return litigation;
			}
			public static WebElement HearingCalenderNum()
			{
	
				litigation=getDriver().findElement(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[2]/div[1]/div/div[3]/div[32]/span"));
				return litigation;
			}
			public static WebElement HearingCalenderNumcfo()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='collapseUpcomingHearing']/div/div[3]/div[1]/div/div[3]/div[28]/span")));
				return litigation;
			}
			
			public static WebElement HearingCalenderCount()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[3]/span[2]")));
				return litigation;
			}
			
			
			public static WebElement HearingCalenderView()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[5]/a")));
				return litigation;
			}
			
			
			public static WebElement HearingCalenderExport()
			{
				//WebgetDriver()Wait wait=new WebgetDriver()Wait(getDriver(),30);
				litigation=getDriver().findElement(By.xpath("//*[@id='exportReport']/span"));
				return litigation;
			}
			public static WebElement HearingCalenderclose()
			{
				//WebgetDriver()Wait wait=new WebgetDriver()Wait(getDriver(),30);
				litigation=getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
				return litigation;
			}
			
			public static WebElement CaseNoticeTypeViewGraph()
			{
				//WebgetDriver()Wait wait=new WebgetDriver()Wait(getDriver(),30);
				litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
				return litigation;
			}
			public static WebElement CaseNoticeTypeclosePopupGraph()
			{
				//WebgetDriver()Wait wait=new WebgetDriver()Wait(getDriver(),30);
				litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
				return litigation;
			}
			
			public static WebElement viewNoticeDetails1()
			{
				
				litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-hearing k-grid-hearing']"));
	            return litigation;
			}
			public static WebElement viewNoticeDetails()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a[2]"));
				return litigation;
			}
			public static WebElement viewTaskDetails()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
				return litigation;
			}
			public static WebElement Actionclosepopup()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditcase1']"));
				return litigation;
			}
			public static WebElement Actionclosepopup1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
				return litigation;
			}
			
			public static WebElement ActioncloseTaskpopup()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
				return litigation;
			}
			public static WebElement showResponseDetailIcon()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a[1]"));
				return litigation;
			}
		
			public static WebElement showResponseDetailIcon1()
			{
				litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
				return litigation;
			}
			public static WebElement clickEditReminder()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a[1]"));
				return litigation;
			}
			public static WebElement clickDeleteReminder()
			{
				litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-deleteuser k-grid-edit1']"));
				return litigation;
			}
			
			public static WebElement clickCaseNotice1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='linoticeCase']/a"));
				return litigation;
			}
			
			public static WebElement clicklocationFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement clicklocationFilter2()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[242]")));
				return litigation;
			}
			public static WebElement clicklocationFilter3()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[276]")));
				return litigation;
			}
			public static WebElement clicklocationFilter4()
			{
				WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				  litigation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='k-in k-state-selected')[2]")));
				return litigation;
			}
			public static WebElement clickDepartmentFilterWorkspace()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/div[2]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilterWorkspace()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABCD'])"));
				return litigation;
			}
			public static WebElement selectDepartmentFilterWorkspacecCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[542]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilterDocNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='IT'])[1]"));
				return litigation;
			}
			public static WebElement selectDepartmentFilterWorkspacecNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Finance'])[1]"));
				return litigation;
			}
			public static WebElement clickDepartmentFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[402]"));
				return litigation;
			}
			
			public static WebElement clickFinancialYear2()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[2]/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickFinancialYear3()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickFinancialYearCase()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[4]"));
				return litigation;
			}
			public static WebElement clickCalenderYear2()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[3]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickCalenderYear3()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownCalYear_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickstatus()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickstatus1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownStatus_listbox']/li[3]"));
				return litigation;
			}
			public static WebElement clickcategory()
			{
				litigation=getDriver().findElement(By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[3]"));
				return litigation;
			}
			public static WebElement clickcategory1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[286]"));
				return litigation;
			}
			public static WebElement clickcategory2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[153]"));
				return litigation;
			}
			public static WebElement clickTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement SelectTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[654]"));
				return litigation;
			}
			public static WebElement SelectTypeFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Inward/Defendant'])[1]"));
				return litigation;
			}
			public static WebElement SelectTypeFilterNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Respondent'])[1]"));
				return litigation;
			}
			public static WebElement clickType2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[726]"));
				return litigation;
			}
			public static WebElement clicktype2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[476]"));
				return litigation;
			}
			public static WebElement clicktype4()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[488]"));
				return litigation;
			}
			public static WebElement clicktype3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in k-state-selected'])[3]"));
				return litigation;
			}
			public static WebElement clickeditButton()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[18]/a[1]"));
				return litigation;
			}
			public static WebElement clickdeleteButton()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[18]/a[2]"));
				return litigation;
			}
			public static WebElement viewTaskDetails1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[9]/a"));
				return litigation;
			}
			public static WebElement clickDropdown()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[2]/span[1]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickCaseHearing1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='liHearing']/a"));
				return litigation;
			}
			public static WebElement clickSearchFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='txtSearch']"));
				return litigation;
			}
			
			public static WebElement clickTaskLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[1]/div"));
				return litigation;
			}
			public static WebElement clickTaskLocFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[5]"));
				return litigation;
			}
			
			public static WebElement clickTaskPriorityFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[2]/div"));
				return litigation;
			}
			
			public static WebElement SelectTaskPriorityFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[normalize-space()='High'])[1]"));
				return litigation;
			}
			public static WebElement clickTaskPriorityFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[23]"));
				return litigation;
			}
			public static WebElement clickTaskStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[3]/div"));
				return litigation;
			}
			public static WebElement SelectTaskStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//span[normalize-space()='Pending/Open']"));
				return litigation;
			}
			public static WebElement clickTaskStatusFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[26]"));
				return litigation;
			}
			public static WebElement clickTaskPeriodFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement clickTaskPeriodFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickDocStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement selectDocStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//div[@id='dropdownlist2-list']//li[2]"));
				return litigation;
			}
			public static WebElement selectDocStatusFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//div[@id='dropdownlist2-list']//li[2]"));
				return litigation;
			}
			public static WebElement clickDocStatusFilter2()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickDocTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div"));
				return litigation;
			}
			public static WebElement selectDocTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[4]"));
				return litigation;
			}
			public static WebElement selectDocTypeFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Inward/Defendant'])[1]"));
				return litigation;
			}
			public static WebElement clickDocTypeFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[1]"));
				return litigation;
			}
			public static WebElement clickDocLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectDocLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[17]"));
				return litigation;
			}
			public static WebElement selectDocLocFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='AB Pvt Ltd'])[1]"));
				return litigation;
			}
			
			public static WebElement clickDocLocFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[21]"));
				return litigation;
			}
			public static WebElement clickDocDeptFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[4]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickDocDeptFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[109]"));
				return litigation;
			}
			
			public static WebElement clickDocDropdownFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[1]/span/span[1]"));
				return litigation;
			}
			
			public static WebElement clickDocTaskFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[3]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickDocTaskFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownTaskType_listbox']/li[4]"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div[2]/div"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[158]"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[210]"));
				return litigation;
			}
			public static WebElement clickDocTaskPriorityFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[181]"));
				return litigation;
			}
			public static WebElement clickReportStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement selectReportStatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//ul[@id='dropdownStatus_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickReportStatusFilter2()
			{
				litigation=getDriver().findElement(By.xpath("//ul[@id='dropdownlist2_listbox]/li[4]"));
				return litigation;
			}
			
			public static WebElement clickReportDeptFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[1]/div/span[1]"));
				return litigation;
			}
			public static WebElement selectReportDeptFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='ABCD'])[1]"));
				return litigation;
			}
			
			public static WebElement selectReportCaseDeptFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'][normalize-space()='Compliance Dept'])[1]"));
				return litigation;
			}
			public static WebElement selectReportCaseDeptFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[normalize-space()='Admin'])[1]"));
				return litigation;
			}
			public static WebElement selectReportDeptFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[545]"));
				return litigation;
			}
			public static WebElement selectReportDeptFilterNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[524]"));
				return litigation;
			}
			public static WebElement clickReportDeptFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[397]"));
				return litigation;
			}
			public static WebElement clickReportDeptFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[402]"));
				return litigation;
			}
			public static WebElement clickReportDeptFiltercfo()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[484]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement selectReportTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[699]"));
				return litigation;
			}
			public static WebElement selectReportTypeFilterCase()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@role='presentation'])[706]"));
				return litigation;
			}
			public static WebElement selectReportTypeFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[563]"));
				return litigation;
			}
			public static WebElement selectReportTypeFilterNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[546]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[480]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter5()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[597]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter4()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[738]"));
				return litigation;
			}
			public static WebElement clickReportTypeFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[471]"));
				return litigation;
			}
			public static WebElement clickReportTypeFiltercfo()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[585]"));
				return litigation;
			}
			public static WebElement clickReportTypeFiltercfo1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[586]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[3]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[96]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[94]"));
				return litigation;
			}
			public static WebElement clickReportCategoryFiltercfo()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[255]"));
				return litigation;
			}
			public static WebElement clickReportLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/div/div"));
				return litigation;
			}
			public static WebElement selectReportLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[549]"));
				return litigation;
			}
			public static WebElement selectReportLocFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[411]"));
				return litigation;
			}
			public static WebElement selectReportLocFilterNonAdmin()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[412]"));
				return litigation;
			}
			public static WebElement clickReportLocFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[379]"));
				return litigation;
			}
			public static WebElement clickReportLocFiltercfo()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[398]"));
				return litigation;
			}
			public static WebElement clickReportFYFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/span[1]/span/span[1]"));
				return litigation;
			}
			public static WebElement selectReportFYFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//li[@role='option'][normalize-space()='2021-2022'])[1]"));
				return litigation;
			}
			public static WebElement selectReportFYFilterCA()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[3]"));
				return litigation;
			}
			public static WebElement clickReportCYFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div/div[4]/span[2]/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportCYFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownCalYear_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickReportprioFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[2]/div"));
				return litigation;
			}
			public static WebElement clickReportprioFilter1()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[4]"));
				return litigation;
			}
			public static WebElement clickReportstatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/div[3]/div/span[1]"));
				return litigation;
			}
			public static WebElement clickReportstatusFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//span[@class='k-checkbox-label checkbox-span']"));
				return litigation;
			}
			public static WebElement clickReportFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[3]/span/span/span[1]"));
				return litigation;
			}
			public static WebElement clickReportFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardLocFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
				return litigation;
			}
			public static WebElement clickDashboardLocFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt10']"));
				return litigation;
			}
			public static WebElement clickDashboardCaseNoticeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTypePage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardNoticeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTypePage_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardCaseFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTypePage_chosen']/div/ul/li[3]"));
				return litigation;
			}
			public static WebElement clickDashboardTypeFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNoticeTypePage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardTypeFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNoticeTypePage_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardDeptFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDeptPage_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardDeptFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDeptPage_chosen']/div/ul/li[4]"));
				return litigation;
			}
			public static WebElement clickDashboardstatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardstatusFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardRiskFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlWinningImpact_chosen']/a/span"));
				return litigation;
			}
			public static WebElement clickDashboardRiskFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlWinningImpact_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickDashboardApplyBtn()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnFilter']"));
				return litigation;
			}
			
			public static WebElement clickDashboardClearBtn()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClearFilter']"));
				return litigation;
			}
			
			public static WebElement clickLegalEntityFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']"));
				return litigation;
			}
			public static WebElement clickSubUnits()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomerBranch']/tbody/tr[3]/td[8]/a"));
				return litigation;
			}
			public static WebElement clickSubUnitscfo()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdCustomerBranch']/tbody/tr[2]/td[8]/a"));
				return litigation;
			}
			public static WebElement clickUnitTypePlusIcon()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_lnkShowAddNewVendorModal']"));
				return litigation;
			}
			public static WebElement EnterUnitType()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxSubunitType']"));
				return litigation;
			}
			public static WebElement SaveUnitType()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSaveSubUnitType']"));
				return litigation;
			}
			public static WebElement SaveValidationMsg()
			{
				litigation=getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_SubUnitValidationSummary']"));
				return litigation;
			}
			public static WebElement CloseUnitType()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnCancelCityPopUp']"));
				return litigation;
			}
			public static WebElement CloseLegalEntity()
			{
				litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnCancel']"));
				return litigation;
			}
			public static WebElement clickLawFirmFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxtypeTofilter']"));
				return litigation;
			}
			
			public static WebElement clickApplybtn()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
				return litigation;
			}
			public static WebElement clickCustomParameterFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlType_chosen']/a/span"));
				return litigation;
			}
			
			public static WebElement clickCustomParameterFilter1()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlType_chosen']/div/ul/li[2]"));
				return litigation;
			}
			public static WebElement clickNoticeStageFilter()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='txtSearch']"));
				return litigation;
			}
			public static WebElement clickLocationFilter3()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[117]"));
				return litigation;
			}
			public static WebElement selectstatusFilter()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[196]"));
				return litigation;
			}
			public static WebElement selectstatusFiltercfo()
			{
				litigation=getDriver().findElement(By.linkText("Closed"));
				return litigation;
			}
			public static WebElement selectDepartmentFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[57]"));
				return litigation;
			}
			public static WebElement selectCaseNoticeType2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[28]"));
				return litigation;
			}
			public static WebElement selectRiskFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[202]"));
				return litigation;
			}
			public static WebElement selectRiskFilter2cfo()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[204]"));
				return litigation;
			}
			public static WebElement selectAgeFilter2()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='drpAgeing_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement selectAgeFiltercfo()
			{
				litigation=getDriver().findElement(By.xpath("//*[@id='drpAgeing_listbox']/li[2]"));
				return litigation;
			}
			public static WebElement selectCategoryFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[3]"));
				return litigation;
			}
			public static WebElement selectStageFilter2()
			{
				litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[38]"));
				return litigation;
			}
			
			 public static WebElement RiskSummaryHigh() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[3]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryMedium() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[2]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryLow() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[2]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryLowCA() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[2]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryNotApplicable() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[2]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryNotApplicableCA() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[2]"));
				  return litigation;
			  }
			 public static WebElement RiskSummaryGraph2() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
				  return litigation;
			  }
			 public static WebElement DepartmentSummaryGraph1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
				  return litigation;
			  }
			 public static WebElement DepartmentSummaryGraph2() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[4]"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeOutwardPlaintiff() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeInwardDefendentCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeApplicantCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeAppleantCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeComplianantCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypePetitionerCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeRespondentCase() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-6 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypePetitionerNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeRespondentNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeDefendantNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeInwardDefendantNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeApplicantNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeComplainantNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-6 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypePlaintiffNotice() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-7 ']"));
				  return litigation;
			  }
			
			 public static WebElement CaseNoticeTypeRespondent1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypeApplicant() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
				  return litigation;
			  }
			 public static WebElement CaseNoticeTypePetitioner() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
				  return litigation;
			  }
			 public static WebElement ExpensesCategoryWiseCaseGraph() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[14]"));
				  return litigation;
			  }
			 public static WebElement ExpensesCounselWiseCaseGraph() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[54]"));
				  return litigation;
			  }
			 public static WebElement ExpensesCounselWiseCaseGraphCA() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[16]"));
				  return litigation;
			  }
			 public static WebElement UtilizedBudgetGraph() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[67]"));
				  return litigation;
			  }
			 public static WebElement UtilizedBudgetGraphCA() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[18]"));
				  return litigation;
			  }
			 public static WebElement ExpensesCaseGraph() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[7]"));
				  return litigation;
			  }
			 public static WebElement CaseInwardDefendent1to2year() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[73]"));
				  return litigation;
			  }
			 public static WebElement CaseOutwardPlaintiff1to2year() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[11]"));
				  return litigation;
			  }
			 public static WebElement CaseRespondnent1to2year() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[11]"));
				  return litigation;
			  }
			 public static WebElement CaseComplainant1to2year() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[74]"));
				  return litigation;
			  }
			 public static WebElement CaseInwardDefendnent2to3year() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[75]"));
				  return litigation;
			  }
			 public static WebElement ClickDetailedExpenseReport() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-export k-grid-edit2']"));
				  return litigation;
			  }
			 public static WebElement clickDeptCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']/a/span"));
				  return litigation;
			  }
			 public static WebElement selectDeptCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlDepartment_chosen']/div/ul/li[3]"));
				  return litigation;
			  }
			 public static WebElement clickOwnerCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']/a/span"));
				  return litigation;
			  }
			 public static WebElement selectOwnerCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlOwner_chosen']/div/ul/li[2]"));
				  return litigation;
			  }
			 public static WebElement clickRiskCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/a/span"));
				  return litigation;
			  }
			 public static WebElement selectRiskCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlNoticeRisk_chosen']/div/ul/li[2]"));
				  return litigation;
			  }
			 public static WebElement selectLocationCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='tvBranchest3']"));
				  return litigation;
			  }
			 public static WebElement SelectLocation1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='tvBranchest11']"));
				  return litigation;
			  }
			 public static WebElement clickAdditionalOwnerCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='pnlNoticeAssignment']/div[1]/div/span[1]/div/button"));
				  return litigation;
			  }
			 public static WebElement selectAdditionalOwnerCfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='pnlNoticeAssignment']/div[1]/div/span[1]/div/ul/li[4]/a/label/input"));
				  return litigation;
			  }
			 public static WebElement selectApplyBtn() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ApplyBtnMain']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentDownloadcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments_lnkBtnDownLoadNoticeDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentViewcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments_lblNoticeDocView_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentViewClosepopupcfo() throws InterruptedException
			  {
				 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				litigation =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='DocumentReviewPopUp1']/div/div/div[1]/button")));
				return litigation;
			  }
			 public static WebElement clickNoticeDocumentdeletecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments_lnkBtnDeleteNoticeDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentsharecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments_lnkBtnShareNoticeDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentshareemailcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='txtEmail']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentsharecontactnocfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='txtcontactNum']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentsharesavecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='btnUpdateDocInfo']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentshareclosepopupcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='btnCancel']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentsharereadmsgcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='vsDocInfoValidateSuccess']/ul/li"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDocumentshareInvalidmsgcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='vsDocInfo']/ul"));
				  return litigation;
			  }
			 public static WebElement clickNoticeEditTaskcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//img[@title='Edit Task']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeEditTask() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnEditTaskDoc_0']/img"));
				  return litigation;
			  }
			
			 public static WebElement clickNoticeTaskEditResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnEditTask_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskEditResponsecfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnEditResponseTask_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskEditResponse1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnEditResponseTask_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskstatusResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlStatus_chosen']/a/span"));
				  return litigation;
			  }
			 public static WebElement clickTaskstatuscfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlStatus_chosen']/a/div/b"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskstatusResponsecfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='ddlStatus_chosen']/div/ul/li[1]"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskcmtResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='tbxTaskResComment']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskSaveResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='btnSaveTaskResponse']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskCloseResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskClosecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnCloseTask_0']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskClosecfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnResCloseTask_0']"));
				  return litigation;
			  }
			 public static WebElement clickNoticeTaskdeletecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnDeleteTask_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickCaseTaskdelete() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskActivity_lnkBtnResDeleteTask_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeEditResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lnkBtnEditResponseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDownloadResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lnkBtnDownLoadResponseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeViewResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lblNoticeResponseDocView_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeclosePopupResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='DocumentReviewPopUp1']/div/div/div[1]/button"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDeleteResponsecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lnkBtnDeleteResponse_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeViewPaymentDoccfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_lnkBtnViewPayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeclosePaymentDocpopupcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='PaymentDocumentReviewPopUp1']/div/div/div[1]/button"));
				  return litigation;
			  }
			 public static WebElement clickNoticeEditPaymentcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_lnkBtnEditPayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDeletePaymentcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_lnkBtnDeletePayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickNoticeDownloadPaymentcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_lnkBtnDownLoadCaseDoc_0']/img"));
				  return litigation;
			  }
			 public static void clickNoticeResponseDocUploadtcfo() throws InterruptedException
			  {
				  
				 WebElement ResponseDoc =getDriver().findElement(By.xpath("//*[@id='fuResponseDocUpload']"));
				 ResponseDoc.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
				  
			  }
			 public static void clickNoticeStatusPaymentUploadtcfo() throws InterruptedException
			  {
				  
				 WebElement ResponseDoc =getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_fuSampleFileNew']"));
				 ResponseDoc.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
				  
			  }
			 public static void clickCaseStatusPaymentUploadtcfo() throws InterruptedException
			  {
				  
				 WebElement ResponseDoc =getDriver().findElement(By.xpath("//*[@id='grdCasePayment_fuSampleFile']"));
				 ResponseDoc.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
				  
			  }
			 public static void clickCaseorderFile() throws InterruptedException
			  {
				  
				 WebElement ResponseDoc =getDriver().findElement(By.xpath("//*[@id='fuCaseOrderDocUpload']"));
				 ResponseDoc.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
				  
			  }
			 
			 public static WebElement clickCaseDownloadDocumentcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseDocuments_lnkBtnDownLoadCaseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickCaseDocumentViewcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseDocuments_lnkBtnViewDocCase_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickCaseDocumentdeletecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseDocuments_lnkBtnDeleteCaseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickCaseDocumentsharecfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseDocuments_LinkButton2_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickEditCaseHearingcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lnkBtnEditResponseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickDeleteCaseHearingcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdResponseLog_lnkBtnDeleteResponse_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickCaseHearingcfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='secondTabAccordion']/div/div/div[1]/div/div/a/i"));
				  return litigation;
			  }
			 public static WebElement clickEditCaseOrdercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseOrder_lnkBtnEditOrderDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickDownloadCaseOrdercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseOrder_lnkBtnDownloadOrderDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickViewCaseOrdercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseOrder_lnkBtnViewDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickDeleteCaseOrdercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseOrder_lnkBtnDeleteOrder_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickViewPaymentDoccfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_lnkBtnViewPayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickEditPaymentDoccfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_lnkBtnEditPayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickdownloadPaymentDoccfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_lnkBtnDownLoadCaseDoc_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickDeletePaymentDoccfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='grdCasePayment_lnkBtnDeletePayment_0']/img"));
				  return litigation;
			  }
			 public static WebElement clickLocationFiltercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[398]"));
				  return litigation;
			  }
			 public static WebElement clickDepartFiltercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[484]"));
				  return litigation;
			  }
			 public static WebElement clickCategoryFiltercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[251]"));
				  return litigation;
			  }
			 public static WebElement clickCategoryFiltercfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[252]"));
				  return litigation;
			  }
			 
			 public static WebElement clickTypeFiltercfo() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[575]"));
				  return litigation;
			  }
			 public static WebElement clickTypeFiltercfo1() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[585]"));
				  return litigation;
			  }
			 public static WebElement clickTaskLocFiltercfo()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[6]"));
					return litigation;
				}
			 public static WebElement clickTaskPriorityFiltercfo()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[30]"));
					return litigation;
				}
			 public static WebElement clickTaskStatusFiltercfo()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[33]"));
					return litigation;
				}
			 public static WebElement clickUserMasterResetcfo()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnReset_0']"));
					return litigation;
				}
			 public static WebElement clickDraftcfo()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRPADraft']"));
					return litigation;
				}
			 public static WebElement clickReminderFilter()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/div[1]/span/span"));
					return litigation;
				}
			 public static WebElement clickReminderFilter1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dropdownlist1_listbox']/li[2]"));
					return litigation;
				}
			 public static WebElement clickReminderFilter2()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dd2']/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement clickReminderFilter3()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dropdownlist2_listbox']/li[2]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmt()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='leftCMmastermenu']/a/span[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtAdd()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAddNew']"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCBU()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='window']/div[1]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCBUdropdown()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ddlCBU_listbox']/li[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtZone()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='window']/div[2]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtZoneSearch()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ddlZone-list']/span/input"));
					return litigation;
				}

			 public static List<WebElement> clickCustomerMgmtZonedropdown() throws InterruptedException
			 {
				 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				 elementsList=getDriver().findElements(By.xpath("//*[@id='ddlZone_listbox']/li"));
			      return elementsList; 
			
			 }
			 public static WebElement clickCustomerMgmtRegion()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='window']/div[3]/span/span/span[1]"));
					return litigation;
				}
			 public static List<WebElement> clickCustomerMgmtRegiondropdown()
				{
				 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
					 elementsList=getDriver().findElements(By.xpath("//*[@id='ddlRegion_listbox']/li"));
				      return elementsList; 
				}
			 public static WebElement clickCustomerMgmtTerritory()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='window']/div[4]/span/span/span[1]"));
					return litigation;
				}
			
			 public static List<WebElement> clickCustomerMgmtTerritorydropdown() throws InterruptedException
			 {
				 WebDriverWait wait = new WebDriverWait(getDriver(), 50);
				 elementsList=getDriver().findElements(By.xpath("//*[@id='ddlTerritory_listbox']/li"));
			      return elementsList; 
			
			 }
			 public static WebElement clickCustomerMgmtCityname()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtCity']"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtSave()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnSubmit']"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtClose2()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[16]/div[1]/div/a"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtClose()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[14]/div[1]/div/a"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtClose1()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[18]/div[1]/div/a"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCity()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[1]/a"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtOk()
				{
					litigation=getDriver().findElement(By.xpath("//button[@class='k-button k-primary']"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtOk1()
				{
					litigation=getDriver().findElement(By.xpath("//div[@role='toolbar']"));
					return litigation;
				}
			 
			 public static WebElement clickCustomerMgmtEdit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[6]/a[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCustomer()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[2]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtDelete()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[6]/a[2]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCBUFilter()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[1]/div"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtCBUFilter1()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerName()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtCustomerName']"));
					return litigation;
				}
			 public static WebElement clickCustomerID()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtSalesCustomerID']"));
					return litigation;
				}
			 public static WebElement clickSPOCName()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtUserName']"));
					return litigation;
				}
			 public static WebElement clickEmailID()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtEmailID']"));
					return litigation;
				}
			 public static WebElement clickMobNo()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtMobileNo']"));
					return litigation;
				}
			 public static WebElement clickCity1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='window']/div/div[7]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement selectCity1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ddlCity_listbox']/li[1]"));
					return litigation;
				}
			 public static WebElement clickWhatsappNo()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtWhatsappNo']"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtEdit1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[15]/a[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtok()
				{
					litigation=getDriver().findElement(By.xpath("(//button[@class='k-button k-primary'])[1]"));
					return litigation;
				}
			 public static WebElement clickCustomerMgmtDelete1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[15]/a[2]"));
					return litigation;
				}
			 
			  public static WebElement clickCustomerUpload() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='btnUploadCustomer']"));
				     
				     return litigation;
		      }
			  public static WebElement clickChooseFile()
				{
				  WebElement CustomerUpload=getDriver().findElement(By.xpath("//*[@id='fileinputForCustomer']"));
				   CustomerUpload.sendKeys("C:\\Users\\Admin\\Desktop\\Customer (3).xlsx");
					return litigation;
				}
			  public static WebElement clickUploadfile()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnFileUploadForCustomer']"));
					return litigation;
				}
			  public static WebElement clickCustomerUploadOutStanding() throws InterruptedException
			  {
				  
				  litigation=getDriver().findElement(By.xpath("//*[@id='btnUpload']"));
			        return litigation;
		      }
			  public static WebElement clickChooseFile1()
				{

				     WebElement CustomerUploadOutStanding=getDriver().findElement(By.xpath("//*[@id='fileinput']"));
				     CustomerUploadOutStanding.sendKeys("C:\\Users\\Admin\\Desktop\\CustomerOutsatnding (1).xlsx");
					return litigation;
				}
			  public static WebElement clickUploadfile1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnFileUpload']"));
					return litigation;
				}
			  public static WebElement clickPlanVisit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[3]/a"));
					return litigation;
				}
			  public static WebElement clickPlanVisitAdd()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAddVisits']"));
					return litigation;
				}
			  public static WebElement selectPlanVisitcustomaerid()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[1]"));
					return litigation;
				}
			  public static WebElement clickPlanVisitcustomaerid()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dvSalesCustomer']/div/div/span[1]"));
					return litigation;
				}
			  public static WebElement clickPlanVisitdate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dateVisit']"));
					return litigation;
				}
			  public static WebElement clickPlanVisitremark()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtRemarks']"));
					return litigation;
				}
			  public static WebElement clickPlanVisitsubmit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditVisits']"));
					return litigation;
				}
			  public static WebElement clickUpdatedVisit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripVisits']/ul/li[2]/span[2]"));
					return litigation;
				}
			  public static WebElement clickEditUpdatedVisit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridUpdatedVisits']/div[2]/table/tbody/tr[1]/td[13]/a"));
					return litigation;
				}
			  public static WebElement clickPlanVisityear()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dateCaseYear']"));
					return litigation;
				}
			  public static WebElement clickPlanVisitedit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPlannedVisits']/div[2]/table/tbody/tr[1]/td[13]/a[1]"));
					return litigation;
				}
			  public static WebElement clickPlanVisitdelete()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPlannedVisits']/div[2]/table/tbody/tr[1]/td[13]/a[2]"));
					return litigation;
				}
			  public static WebElement clickPlanVisitOverdueVisit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripVisits']/ul/li[2]/span[2]"));
					return litigation;
				}
			  public static WebElement clickPlanVisitErrotfile()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='errorLink']"));
					return litigation;
				}
			  public static WebElement clickCustomerErrotfile()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='errorLinkForCustomer']"));
					return litigation;
				}
			  public static WebElement clickUpdateCommitmentsafterremarks()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[4]/a"));
					return litigation;
				}
			  public static WebElement clickEditPendingVisit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPendingVisits']/div[2]/table/tbody/tr[1]/td[13]/a"));
					return litigation;
				}
			  public static WebElement clickAddNewRecord()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[1]/a"));
					return litigation;
				}
			  public static WebElement clickAmount2()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]/table/tbody/tr/td[3]/span[1]/span/input[1]"));
					return litigation;
				}
			  public static WebElement clickFollowupDate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='Schedule_FollowUp_Date']"));
					return litigation;
				}
			  public static WebElement clickFollowupDate1()
				{
					litigation=getDriver().findElement(By.xpath("//input[@name='Schedule_FollowUp_Date']"));
					return litigation;
				}
			  public static WebElement clickUpdate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]/table/tbody/tr/td[5]/a[1]"));
					return litigation;
				}
			  public static WebElement clickScheduleDate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ScheduleDate']"));
					return litigation;
				}
			  public static WebElement clickScheduleDate1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]/table/tbody/tr[1]/td[2]/span/span/span[2]"));
					return litigation;
				}
			  public static WebElement clickScheduleDate2()
				{
					litigation=getDriver().findElement(By.linkText("6"));
					return litigation;
				}
			  public static WebElement clickBlankSapce()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]"));
					return litigation;
				}
			  public static WebElement clickEdit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]/table/tbody/tr/td[5]/a[1]"));
					return litigation;
				}
			  public static WebElement clickDelete()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPaymentSchedule']/div[3]/table/tbody/tr/td[5]/a[2]"));
					return litigation;
				}
			  public static WebElement clickUpdateCommitmentsStatus()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[5]/a"));
					return litigation;
				}
			  public static WebElement clickUpdateCommitmentsStatusEdit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridSchedule']/div[2]/table/tbody/tr[1]/td[14]/a"));
					return litigation;
				}
			  public static WebElement clickAddNewRecords()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[1]/a"));
					return litigation;
				}
			  public static WebElement clickCommitDate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='CommitDate']"));
					return litigation;
				}
			  public static WebElement clickCommitAmount()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[3]/span[1]/span/input[1]"));
					return litigation;
				}
			  public static WebElement clickRecieptDate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ReceiveDate']"));
					return litigation;
				}
			  public static WebElement clickRecieptDateAmount()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[5]/span[1]/span/input[1]"));
					return litigation;
				}
			  public static WebElement clickCommitRemark()
				{
					litigation=getDriver().findElement(By.xpath("//input[@name='commitRemark']"));
					return litigation;
				}
			  public static WebElement clickUpdateCommit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[7]/a[1]"));
					return litigation;
				}
			  public static WebElement clickUpdateCommitedit()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[7]/a[1]"));
					return litigation;
				}
			  public static WebElement clickSendReminder()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[7]/a[3]"));
					return litigation;
				}
			  public static WebElement clickStopReminder()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[7]/a[4]"));
					return litigation;
				}
			  public static WebElement clickDelete1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridCommitments']/div[3]/table/tbody/tr[1]/td[7]/a[2]"));
					return litigation;
				}
			  public static WebElement clickclosePopuopCommitments()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[17]/div[1]/div/a"));
					return litigation;
				}
			  public static WebElement clickReports()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='MasterCMsubmenu']/li[6]/a"));
					return litigation;
				}
			  public static WebElement clickSchedulesReport()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripVisits']/ul/li[2]/span[2]"));
					return litigation;
				}
			  public static WebElement clickCommitmentReport()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripVisits']/ul/li[3]/span[2]"));
					return litigation;
				}
			  public static WebElement clickAuditLogReport()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripVisits']/ul/li[4]/span[2]"));
					return litigation;
				}
			  public static WebElement clickExportAuditLogReport()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='exportReportLog']"));
					return litigation;
				}
			  public static WebElement clickNoRecordFound()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='gridPlannedVisits']/div[2]/div[1]/div"));
					return litigation;
				}
			  
			 public static WebElement clickAdvocateBillTab()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lefAdvocatemenu']/a/span[1]"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillTabViewIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[21]/a[2]"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillTabAuditLog()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lnkAuditLog']"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillTabclose()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditcase1']"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillTabTriangle()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[3]/td[1]/a"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillTabTriangle1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]/a"));
					return litigation;
				}
			 public static WebElement clickApproverAssignmentLog()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tabstripAssignment']/ul/li[2]/span[2]"));
					return litigation;
				}
			 public static WebElement clickMinimize()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='DivTaskCollapsTwo']/div/div/div[1]/div/div/a/i"));
					return litigation;
				}
			 public static WebElement clickMinimizeHearing()
				{
					litigation=getDriver().findElement(By.cssSelector("#DivHearingCollapsTwo > div > div > div.panel.panel-default > div > div > a > i"));
					return litigation;
				}
			 public static WebElement clickMinimizeResponse()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='DivResponceCollapsTwo']/div/div/div[1]/div/div/a/i"));
					return litigation;
				}
			 public static WebElement clickReadHearingMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary9']"));
					return litigation;
				}
			 public static WebElement clickReadHearingMsg1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']/ul/li"));
					return litigation;
				}
			 		
			 public static WebElement clickHearingClearBtn()
				{
					litigation=getDriver().findElement(By.xpath("//input[@name='btnHearingClear']"));
					return litigation;
				}
			 public static WebElement clickReadOrderMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary10']"));
					return litigation;
				}
			 public static WebElement clickminimize()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='secondTabAccordion']/div/div/div[1]/div/div/a"));
					return litigation;
				}
			 public static WebElement clickUploadDoc()
				{
					WebElement UploadDocument =getDriver().findElement(By.xpath("//*[@id='fuAdvocateBillDocUpload']"));
					 UploadDocument.sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
					return litigation;
				}
			 public static WebElement clickReadAdvocateMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary12']"));
					return litigation;
				}
			 public static WebElement clickReadAdvocateMsg1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary13']"));
					return litigation;
				}
			 public static WebElement clickeditAdvocatebill()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdAdvocateBill_lnkBtnEditCaseAdvocateBill_0']"));
					return litigation;
				}
			 public static WebElement clickDownloadDocAdvocatebill()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdAdvocateBill_lnkBtnDownloadAdvocateBillDoc_0']"));
					return litigation;
				}
			 public static WebElement clickViewDocAdvocatebill()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdAdvocateBill_lnkBtnViewAdvocateBillDoc_0']"));
					return litigation;
				}
			 public static WebElement clickViewDocAdvocatebillClose()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='DocumentAdvBillReviewPopUp1']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement clickViewDocAdvocatebillPdf()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdAdvocateBill_LnkBtnconvetpdf_0']"));
					return litigation;
				}
			 public static WebElement clickViewDocAdvocatebillPdfClose()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='divViewDocument']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement clickExportAdvocateBill()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAdvbillExport']"));
					return litigation;
				}
			 public static WebElement clickAdvocateBillDelete()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdAdvocateBill_lnkBtnDeleteAdvocateBill_0']"));
					return litigation;
				}
			 public static WebElement clickTaskActionIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[9]/a"));
					return litigation;
				}
			 public static WebElement clickAssignedBy()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lblAssignBy']"));
					return litigation;
				}
			 public static WebElement clickStatus1()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/form/div[3]/div[3]/div/div/div[2]/div/div/div/div[3]/div[1]/div[2]/div/a/span"));
					return litigation;
				}
			 public static WebElement clickStatusdropdown()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ddlStatus_chosen']/div/ul/li[2]"));
					return litigation;
				}
			 public static WebElement clickTaskResponse()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsTaskResponse']/ul/li"));
					return litigation;
				}
			 public static WebElement clickTaskResponseclose()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement clickMasterAdvocateBill()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='Mastersubmenu']/li[13]/a"));
					return litigation;
				}
			 public static WebElement clickAddApprover()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div/a"));
					return litigation;
				}
			 public static WebElement clickSelectapprover1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[1]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement clickSelectapprover1Dropdown()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ApproverLevel_listbox']/li[1]"));
					return litigation;
				}
			 public static WebElement clickSelectapprover2()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement clickSelectapprover1Dropdown1()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[9]/div/div[3]/ul/li[2]"));
					return litigation;
				}
			 public static WebElement clickupdate()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[3]/a[1]"));
					return litigation;
				}
			 public static WebElement clickAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[10]"));
					return litigation;
				}
			 public static WebElement clickAgeing1()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[8]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentNoticeCA()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[8]"));
					return litigation;
				}
			 
			 public static WebElement clickApplicantLessThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[19]"));
					return litigation;
				}
			 public static WebElement clickComplainantLessThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[18]"));
					return litigation;
				}
			
			 public static WebElement clickInwardDefendentLessThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[6]"));
					return litigation;
				}
			 public static WebElement clickAppellantLessThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[6]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffLessthanyearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[3]"));
					return litigation;
				}
			 public static WebElement clickPetitionerLeassThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[3]"));
					return litigation;
				}
			 public static WebElement clickRespondentLessThanYearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-6 '])[2]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentNoticeCA1to2()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[6]"));
					return litigation;
				}
			 
			 public static WebElement clickComplianant1to2yearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[20]"));
					return litigation;
				}
			 public static WebElement clickApplicant2to3yearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[21]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentCAMoreThan3yearsCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[22]"));
					return litigation;
				}
			 public static WebElement clickAgeingViewIcon()
				{
					litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
					return litigation;
				}
			 public static WebElement clickAgeingViewNoticeSummary()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lnkNoticeDetail']"));
					return litigation;
				}

              public static WebElement clickAgeingViewCaseSummary()
	          {
		          litigation=getDriver().findElement(By.xpath("//*[@id='lnkCaseDetail']"));
		           return litigation;
	          }
			 
			 public static WebElement clickAgeingViewNoticeSummaryCloseIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnAddEditcase']"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffNoticeAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[7]"));
					return litigation;
				}
			 public static WebElement clickApplicantAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[12]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[10]"));
					return litigation;
				}
			
			 public static WebElement clickPetitionerAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[8]"));
					return litigation;
				}
			 public static WebElement clickRespondentAgeing()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[7]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendent()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[13]"));
					return litigation;
				}
			 public static WebElement clickComplianant()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[13]"));
					return litigation;
				}
			 public static WebElement clickComplianant2()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[70]"));
					return litigation;
				}
			 public static WebElement clickComplianant1()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[69]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiff()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[11]"));
					return litigation;
				}
			 public static WebElement clickRespondent()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[11]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentMorethan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[10]"));
					return litigation;
				}
			 public static WebElement clickComplainantMorethan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[11]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffMorethan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[8]"));
					return litigation;
				}
			 public static WebElement clickPetitionerMorethan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[8]"));
					return litigation;
				}
			 public static WebElement clickRespondentMorethan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[6]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentNoticeCA2to3()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[9]"));
					return litigation;
				}
			 public static WebElement clickApplicantNoticeCA2to3()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[10]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffNoticeCA2to3()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[7]"));
					return litigation;
				}
			 public static WebElement clickPetitionerNoticeCA2to3()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[7]"));
					return litigation;
				}
			 public static WebElement clickPlaintiffNoticeCA2to3()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[3]"));
					return litigation;
				}
			 public static WebElement clickInwardDefendentCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[10]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[9]"));
					return litigation;
				}
			 public static WebElement clickInwardOutward1to2yearsCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[19]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiff2To3YearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[20]"));
					return litigation;
				}
			 public static WebElement clickRespondent2To3YearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[8]"));
					return litigation;
				}
			 public static WebElement clickAppleantCaseCAMoreThan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[21]"));
					return litigation;
				}
			 public static WebElement clickPetitionerCaseCAMoreThan3years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[9]"));
					return litigation;
				}
			 public static WebElement clickPetitionerCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[9]"));
					return litigation;
				}
			 public static WebElement clickPetitionerNoticeCA()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[5]"));
					return litigation;
				}
			 public static WebElement clickOutwardPlaintiffNoticeCA1To2Years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[6]"));
					return litigation;
				}
			 public static WebElement clickPetitionerNoticeCA1To2Years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[4]"));
					return litigation;
				}
			
			 public static WebElement clickAppleant1to2YearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[7]"));
					return litigation;
				}
			 public static WebElement clickRespondentNoticeCA()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[5]"));
					return litigation;
				}
			 public static WebElement clickDefendantNoticeCA()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[3]"));
					return litigation;
				}
			 public static WebElement clickRespondentNoticeCA1To2Years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[3]"));
					return litigation;
				}
			 public static WebElement clickApplicantNoticeCA1To2Years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[9]"));
					return litigation;
				}
			 public static WebElement clickComplianantNoticeCA1To2Years()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[8]"));
					return litigation;
				}
			 
			 public static WebElement clickOutwardplaintiff1toyearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[7]"));
					return litigation;
				}
			 public static WebElement clickPetitioner1toyearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 '])[4]"));
					return litigation;
				}
			 public static WebElement clickRespondent1toyearCase()
				{
					litigation=getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 '])[4]"));
					return litigation;
				}
			 public static WebElement clickNoticeClearBtn()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnClearNoticeDetail']"));
					return litigation;
				}
			 public static WebElement clickSelectCheckbox()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdShowDocumentList_chkDocument_0']"));
					return litigation;
				}
			 public static WebElement clickMailTo()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tbxMailTo']"));
					return litigation;
				}
			 public static WebElement clickMessageMail()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='tbxMailMsg']"));
					return litigation;
				}
			 public static WebElement clickSend()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnSendDocumentMail']"));
					return litigation;
				}
			 public static WebElement clickSendMailMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary7']/ul/li"));
					return litigation;
				}
			 public static WebElement clickSendMailMsg1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ValidationSummary7']/ul"));
					return litigation;
				}
			 public static WebElement clickcloseBtn()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='divOpenSendMailPopup']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement clickLinkedNoticeViewIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdLinkedNotices_lnkViewLinkedNotice_0']/img"));
					return litigation;
				}
			 public static WebElement clickLinkedCaseViewIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdLinkedCases_lnkViewLinkedCase_0']/img"));
					return litigation;
				}
			 public static WebElement clickViewPopup()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='historyPopUpHeader']"));
					return litigation;
				}
			 public static WebElement clickClosePopup1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='divNoticeCaseHistoryPopup']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement clickLinkedNoticeDeleteIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdLinkedNotices_lnkBtnDeleteNoticeLinking_0']/img"));
					return litigation;
				}
			 public static WebElement clickLinkedCaseDeleteIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdLinkedCases_lnkBtnDeleteCaseLinking_0']/img"));
					return litigation;
				}
			 public static WebElement clickLinkedNoticeDeleteIconValidMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsLinkedNotices']/ul/li"));
					return litigation;
				}
			 public static WebElement clickLinkedCaseDeleteIconValidMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsLinkedCases']/ul/li"));
					return litigation;
				}
			 public static WebElement clickUserAssign()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdUserAssignment_lblUserName_2']"));
					return litigation;
				}
			 public static WebElement clickEditUserAssign()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lnkBtnEditUserAssignment']"));
					return litigation;
				}
			 public static WebElement clickDeleteUserAssign()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdUserAssignment_lnkDeleteUserAssignment_0']/img"));
					return litigation;
				}
			 public static WebElement clickDeleteUserAssignValidMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsNoticeUserAssign']/ul/li"));
					return litigation;
				}
			 public static WebElement clickDeleteUserAssignValidMsg1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsCaseUserAssign']/ul/li"));
					return litigation;
				}
			 public static WebElement clickSearchDocument()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtdocsearch']"));
					return litigation;
				}
			 public static WebElement clickApplyBtn()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnsearchDoc']"));
					return litigation;
				}
			 public static WebElement clickDocName()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments_lblFileName_0']"));
					return litigation;
				}
			 public static WebElement noRecordFound()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticeDocuments']/tbody/tr[2]/td"));
					return litigation;
				}
			 public static WebElement clickDocName1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdCaseDocuments_lblFileName_0']"));
					return litigation;
				}
			 public static WebElement clickInvalidResponsemsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='vsTaskResponse']/ul/li"));
					return litigation;
				}
			 public static WebElement clickDeleteResponse()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdTaskResponseLognew_lnkBtnDeleteTaskResponse_0']/img"));
					return litigation;
				}
			 public static WebElement clickClearResponse()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='Button2']"));
					return litigation;
				}
			 public static WebElement clickClearNoticeResponse()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnResponseClear']"));
					return litigation;
				}
			 public static WebElement clickCriteriaInvalidMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='lblError']"));
					return litigation;
				}
			 public static WebElement clickCaseClearBtn()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='btnClearCaseDetail']"));
					return litigation;
				}
			 public static WebElement clickNoticAmountPaid()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grdNoticePayment_tbxAmountPaid']"));
					return litigation;
				}
			 public static WebElement clickNoticeStatus1()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/form/div[3]/section/section/section/div/div/div/div[3]/span/span/span[1]"));
					return litigation;
				}
			 public static WebElement selectNoticeStatus()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[5]/div/div[2]/ul/li[2]"));
					return litigation;
				}
			 public static WebElement selectDocument()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[4]"));
					return litigation;
				}
			 public static WebElement selectDocument1()
				{
					litigation=getDriver().findElement(By.xpath("/html/body/div[77]/div/div[2]/ul/li[2]"));
					
					
					return litigation;
					
					
				}
			 public static WebElement shareDocumentIcon()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[16]/a[3]"));
					return litigation;
				}
			 public static WebElement shareDocumentIcon1()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[14]/a[3]"));
					return litigation;
				}
			 public static WebElement CloseSharePopup()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='divViewDocument3']/div/div/div[1]/button"));
					return litigation;
				}
			 public static WebElement ClickNewBtn()
				{
					litigation=getDriver().findElement(By.xpath("//button[@id='menu1']"));
					return litigation;
				}
			 public static WebElement ClickNewFolderName()
				{
					litigation=getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_lnkAddNewFolder']"));
					return litigation;
				}
			 public static WebElement ClickUsers()
				{
					litigation=getDriver().findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
					return litigation;
				}
			 public static WebElement ClickFoldername()
				{
					litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtFolderName']"));
					return litigation;
				}
			 public static WebElement ClickViewFile()
				{
					litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_grdFolderDetail_lblName_0']"));
					return litigation;
				}
			 public static WebElement ClickDeleteFile()
				{
					litigation=getDriver().findElement(By.xpath("//img[@class='deletedrive']"));
					return litigation;
				}
			 public static WebElement ClickSuccessMsg()
				{
					litigation=getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divsuccessmsgaCTemSec']"));
					return litigation;
				}
			 public static WebElement ClickInvalidMsg()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']/ul/li"));
					return litigation;
				}
			 public static WebElement ClickEditFolder()
				{
					litigation=getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']"));
					return litigation;
				}
			 public static WebElement ClickDownloadfile()
				{
					litigation=getDriver().findElement(By.xpath("//img[@class='viewdrive']"));
					return litigation;
				}
			 public static WebElement ClickEditDetailesFile()
				{
					litigation=getDriver().findElement(By.xpath("//img[@class='editdrive']"));
					return litigation;
				}
			 public static WebElement ClickHeader()
				{
					litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_TxtDocHeader']"));
					return litigation;
				}
			 public static WebElement ClickUpdateInfo()
				{
					litigation=getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnUpdateInfo']"));
					return litigation;
				}
			 public static WebElement ClickUpdateSuccessmsg()
				{
					litigation=getDriver().findElement(By.xpath("//span[@id='ContentPlaceHolder1_successmsg']"));
					return litigation;
				}
			 public static WebElement SelectStatusFilter()
				{
					litigation=getDriver().findElement(By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[3]"));
					return litigation;
				}
			 public static WebElement StatusDropDown()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-in'])[130]"));
					return litigation;
				}
			 public static WebElement NoRecordFound()
				{
					litigation=getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
					return litigation;
				}
			 public static WebElement StageName()
				{
					litigation=getDriver().findElement(By.xpath("(//*[name()='tspan'][normalize-space()='Notice abc'])[1]"));
					return litigation;
				}
			 public static WebElement CaseStageName()
				{
					litigation=getDriver().findElement(By.xpath("(//*[name()='tspan'][contains(text(),'ABC')])[1]"));
					return litigation;
				}
			 public static WebElement DepartName()
				{
					litigation=getDriver().findElement(By.cssSelector("#highcharts-2 > svg > g.highcharts-axis-labels.highcharts-xaxis-labels > text:nth-child(1)"));
					return litigation;
				}
			 public static WebElement LocationName()
				{
					litigation=getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-axis-labels.highcharts-xaxis-labels > text:nth-child(1) > tspan"));
					return litigation;
				}
			 public static WebElement CategoryName()
				{
					litigation=getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-axis-labels.highcharts-xaxis-labels > text:nth-child(3) > tspan"));
					return litigation;
				}
			 public static WebElement ExpenseCategoryName()
				{
					litigation=getDriver().findElement(By.xpath("(//*[name()='tspan'][contains(text(),'public notice')])[2]"));
					return litigation;
				}
			 public static WebElement ExpenseCategoryNamecfo()
				{
					litigation=getDriver().findElement(By.xpath("(//*[name()='tspan'][contains(text(),'Civil')])[3]"));
					return litigation;
				}
			 public static WebElement CaseNoticeFilter()
				{
					litigation=getDriver().findElement(By.xpath("(//span[@class='k-input'])[2]"));
					return litigation;
				}
			 public static WebElement SelectCaseNoticeFilter()
				{
					litigation=getDriver().findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(4) > ul:nth-child(1) > li:nth-child(48)"));
					return litigation;
				}
			 public static WebElement FYFilter()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='form1']/div[4]/div[2]/span[2]/span"));
					return litigation;
				}
			 public static WebElement SelectFYFilter()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='dropdownFY_listbox']/li[4]"));
					return litigation;
				}
			 public static WebElement AddAnnualBudgetMaster()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div/a"));
					return litigation;
				}
			 public static WebElement EnterFY()
				{
					litigation=getDriver().findElement(By.xpath("//input[@name='FinancialYear']"));
					return litigation;
				}
			 public static WebElement EnterAnnualBudget()
				{
					litigation=getDriver().findElement(By.xpath("(//input[@type='text'])[2]"));
					return litigation;
				}
			 public static WebElement ClickUpdateBtn()
				{
					litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext k-primary k-grid-update']"));
					return litigation;
				}
			 public static WebElement ClickEditIcon()
				{
					litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext edit k-grid-edit']"));
					return litigation;
				}
			 public static WebElement ClickDeleteIcon()
				{
					litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext destroy k-grid-delete']"));
					return litigation;
				}
			 public static WebElement ClicksearchFilter()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='txtSearch']"));
					return litigation;
				}
			 public static WebElement WithoutEnterFY()
				{
					litigation=getDriver().findElement(By.xpath("//span[@class='k-icon k-i-warning']"));
					return litigation;
				}
			 public static WebElement clickLoader()
				{
					litigation=getDriver().findElement(By.xpath("//*[@id='updateProgressPanel']/img"));
					return litigation;
				}
			 public static WebElement clickTaskShowDetailes()
				{
					litigation=getDriver().findElement(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
					return litigation;
				}
			 
			 public static WebElement clickDashboard()				//Method to search Dashboard Link
				{
				  litigation = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
					return litigation;
				}
}


			




		  
