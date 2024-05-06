package com.cmro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmro.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement Loginbtn;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
	return driver.getTitle();
	}
	
	
	public Homepage Login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Loginbtn.click();
		return new Homepage();
	}

}
