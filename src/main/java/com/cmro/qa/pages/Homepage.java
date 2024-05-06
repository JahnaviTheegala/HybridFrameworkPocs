package com.cmro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmro.qa.base.TestBase;

public class Homepage extends TestBase {
	
	Actions action;

	@FindBy(xpath="//span[text()='Calendar']")
	WebElement Calender;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement ContactUs;
	
	@FindBy(xpath="//span[text()='Companies']")
	WebElement Companies;
	
	
	
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public String verifyHomePage()
	{
		return driver.getTitle();
	}
	
	public CalenderPage calender_Page()
	{
		action.moveToElement(Calender).build().perform();
		Calender.click();
		return new CalenderPage();
	}
	
	public void Contactus_Page()
	{
		action.moveToElement(ContactUs).build().perform();;
		ContactUs.click();
		
	}
	
	public CompaniesPage Companies()
	{
		action.moveToElement(Companies).click();
		return new CompaniesPage();
	}

	

	
	
}
