package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	@CacheLookup
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	

	
	@FindBy(xpath="//a[contains(text(),'Deals')]")	
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	

	public HomePage()
	{
	PageFactory.initElements(driver, this);	
	}
	
	public String VerifyHomepageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage ClickonContactsLink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	
	
	public DealsPage ClickonDealsLink()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	
	
	public TasksPage ClickonTaskslink()
	{
		return new TasksPage();
	}
	
	public boolean Verifycorrectusername()
	{
		return usernamelabel.isDisplayed();
	}
	
	
	public void clickonNewContactlink()
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(contactslink).build().perform();
		newcontactslink.click();
	}
	
	
	
	
}
