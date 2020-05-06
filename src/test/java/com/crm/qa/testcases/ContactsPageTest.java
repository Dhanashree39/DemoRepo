package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName="contacs";
	
	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.ClickonContactsLink();
	}
	
	
@Test(priority = 1)
public void Verifycontactspagelabel()
{
	Assert.assertTrue(contactspage.Verifycontactlabel(),"contacts label is missing");
}
	
	
@Test(priority=2)
public void Selectcontacttest()
{
	contactspage.selectContactsByName("Aakash Jain");
}
	
@Test(priority=3)
public void SelectMultiplecontacttest()
{
	contactspage.selectContactsByName("Aakash Jain");
	contactspage.selectContactsByName("Demo 1");
}
	
@DataProvider
public Object[][] getCRMTestData() throws InvalidFormatException
{

Object data[][]	=TestUtil.getTestData(sheetName);
return data;
}



@Test(priority = 4,dataProvider = "getCRMTestData")
public void validatecreatenewcontact(String title,String firstname,String lastname,String company) throws InterruptedException
{
	homepage.clickonNewContactlink();
	
	//contactspage.createNewcontact("Mr.", "Krishna", "Sudesh", "Flipkart");
contactspage.createNewcontact(title, firstname, lastname, company);
}

	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
