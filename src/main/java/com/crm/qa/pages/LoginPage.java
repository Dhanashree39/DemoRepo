package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(linkText ="Sign Up")
	WebElement Signup;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMlogo()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
