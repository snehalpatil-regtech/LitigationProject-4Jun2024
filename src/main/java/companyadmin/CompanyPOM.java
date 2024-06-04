package companyadmin;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import login.BasePage;

public class CompanyPOM extends BasePage
{
	
	private static WebElement admin = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> adminList = null;
	
	
	public static WebElement clickMyAdmin()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='leftApprovermenu']/a/span[1]"));
		return admin;
	}
	public static WebElement clickReport()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"));
		return admin;
	}
	public static WebElement clickUserLogReport()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[10]/a"));
		return admin;
	}
	public static WebElement clickAlertpopup()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='divbnl']/div/div/div[1]/button"));
		return admin;
	}
	public static WebElement clickNotificatonpopup()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='divNotification']/div/div/div[1]/button"));
		return admin;
	}
	
	public static WebElement clickUsers()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']"));
		return admin;
	}
	public static WebElement clickExport()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return admin;
	}
	public static WebElement clickUserName()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//span[normalize-space()='abc External']"));
		return admin;
	}
	public static WebElement clickUserName1()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("(//span[normalize-space()='abc lawyer'])[1]"));
		return admin;
	}
	public static WebElement clickAppyButton()			//Searching 'Open' Notice link
	{
		
		admin = getDriver().findElement(By.xpath("//button[@id='Applybtn']"));
		return admin;
	}
	

}
