package login;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentTest;


import cfo.OverduePOM;

public class Login extends BasePage
{
	//public static Web  = null;				//Web instance created
	//public static WebElement upload = null;				//WebElement to get upload button
	
	/*public static void BrowserSetup(String URL)
	{

		
			//WebManager.edge().setup();
			// = new Edge();					//Created new Chrome  instance. 
		
			//WebManager.chrome().setup();
			// System.setProperty("web.chrome.","E:\eclips-projects\Selenium\chromedriver-win64_1\\chrome.exe");
		  	 
			WebManager.chrome().setup();		
		    = new Chrome();		
				
			
			//WebManager.firefox().setup();
			// = new Firefox();
		
			//	WebManager.opera().setup();
			//	 = new Opera();
		
		    System.setProperty("web.opera.", "E:\\eclips-projects\\Selenium\\opera_win64 -121 version\\opera.exe");
		    OperaOptions operaOptions =new OperaOptions();
		    operaOptions.setBinary("C:\\Program Files\\OperaBroswer\\opera.exe");
			 = new Opera(operaOptions);
		
			.manage().window().maximize();			//Set window size to maximum.
			.get(URL);								//Set the URL of WebApplication.
	}

	
	
	public static void BrowserSetup1(String URL,String browser) throws Exception
	{
		
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			 //create firefox instance
				System.setProperty("web.gecko.", "E:\\eclips-projects\\Selenium\\gecko-v0.33.0-win64\\gecko.exe");
				 = new Firefox();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome"))
			{
				//set path to chrome.exe
				System.setProperty("web.chrome.","E:\eclips-projects\Selenium\chromedriver-win64_1\\chrome.exe");
				//create chrome instance
				 = new Chrome();
			
			}
			else if(browser.equalsIgnoreCase("Opera"))
			{
				//set path to chrome.exe
				System.setProperty("web.opera.","E:\\eclips-projects\\Selenium\\opera_win32\\opera.exe");
				//create chrome instance
				 = new Opera();
			
			}
			//Check if parameter passed as 'Edge'
			else if(browser.equalsIgnoreCase("Edge")) 
			{
			     //set path to Edge.exeMicrosoftWeb
			     WebManager.edge().setup();
			     //System.setProperty("web.edge.","C:\\Users\\Admin\\Desktop\\eclips-projects\\Selenium\\Edge\\msedge.exe");
			     //create Edge instance
				  = new Edge();
			}
			else
			{
						//If no browser passed throw exception
						throw new Exception("Browser is not correct");
			}
							 
							 
		               .manage().window().maximize();			//Set window size to maximum.
		                .get(URL);
		
	}*/
	
	public static WebDriver UserLogin(String username, String password, String method) throws InterruptedException
	{		
		 WebDriverWait wait = new WebDriverWait(getDriver(),20);
		
		
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		Thread.sleep(500);
		if(!username.equalsIgnoreCase("performer@avantis.info"))
		{
			try
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(LoginPOM.clickQALink()));
				wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickQALink()));
				LoginPOM.clickQALink().click();				//Clicking on QA Link instead of OTP.
				
				//----------------------------------------------------------------------------//
				
				wait.until(ExpectedConditions.invisibilityOf(LoginPOM.clickQALink()));
		
			
		 Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(LoginPOM.Question1()));
			wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.Question1()));
			String que1 = LoginPOM.Question1().getText();	//Storing the question in que variable.
			String ans1 = null;
			
			if(method.equalsIgnoreCase("cfo"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("fe"))
			{
				ans1 = getAnswerFE(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("company"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Implementation"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			
			else
			{
				ans1 = getAnswer(que1);							//Storing the answer in ans variable.
			}
			
			if(ans1.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer1().sendKeys("place");		//Sending answer to the input box.
			else
				LoginPOM.Answer1().sendKeys(ans1);		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------//
			
			String que2 = LoginPOM.Question2().getText();	//Storing the question in que variable.
			String ans2 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("fe"))
			{
				ans2 = getAnswerFE(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("company"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Implementation"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else
			{
				ans2 = getAnswer(que2);							//Storing the answer in ans variable.
			}
			
			
			if(ans2.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer2().sendKeys("place");		//Sending answer to the input box.
			else
				LoginPOM.Answer2().sendKeys(ans2);		//Sending answer to the input box.
			Thread.sleep(100);
			
			LoginPOM.SubmitAnswer().click();				//Clicking on Submit button.
		
			}
			catch(Exception e)
			{
				
			}
			
		}
		
		
		
		if(!method.equalsIgnoreCase("Implementation"))
		{
			//wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickComplicane()));
			
			if(method.equalsIgnoreCase("License"))
			{
				LoginPOM.clickLicense().click();				//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Litigation"))
			{
				//Thread.sleep(8000);
				LoginPOM.ClickLitigation().click();			//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Contract"))
			{
				LoginPOM.ClickContract().click();			//Clicking on Litigation Image.
			}
			else
			{
				LoginPOM.ClickLitigation().click();	
				//LoginPOM.clickComplicane().click();			//Clicking on Compliance Image.
			}
			
			try
			{
				Thread.sleep(500);
				if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
				{
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
					OverduePOM.closeMessage().click();		//then close the message.
				}
			}
			catch(Exception e)
			{
				
			}
		}		
		return getDriver() ;
	}
	
	public static String getAnswer(String que)				//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));		//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerCFO(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	public static String getAnswerFE(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	/*public static Web UserLogin1(String username, String password, String method) throws InterruptedException
	{		
		WebWait wait = new WebWait(, 20);
		WebWait wait1 = new WebWait(, 60);
		
		LoginPOM.setUname().clear();
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		
		return ;
    }
	
	  public static Web forgotPassword() throws InterruptedException, IOException
		
		{
	
		  
		LoginPOM.ClickForgotPass().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		
		Thread.sleep(2000);
		LoginPOM.ClickSubmit().click();
		Thread.sleep(2000);
		LoginPOM.ClickBackButton().click();
		return ;
	}
	  
	  public static void AccountLocked(Web ,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebWait wait1 = new WebWait(, 60);
		
	
		Thread.sleep(2000);
		LoginPOM.ClickAccountLocked().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		Thread.sleep(2000);
		LoginPOM.ClickSubmit().click();
		Thread.sleep(2000);
		LoginPOM.ClickBackButton1().click();
	}
	  public static void Google(Web ,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebWait wait1 = new WebWait(, 60);
		
		
		LoginPOM.ClickGoogle().click();
		
		//LoginPOM.ClickEmailid().sendKeys("");
		//LoginPOM.ClickSubmit().click();
		//LoginPOM.ClickBackButton().click();
	}
	  public static void LoginHelp(Web ,ExtentTest test, String type) throws InterruptedException, IOException
		
		{
		WebWait wait1 = new WebWait(, 60);
		
		LoginPOM.ClickLoginHelp().click();
		
		
	}*/
}
