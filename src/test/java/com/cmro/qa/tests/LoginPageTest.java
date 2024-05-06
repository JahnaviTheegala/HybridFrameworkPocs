package com.cmro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmro.qa.base.TestBase;
import com.cmro.qa.pages.Homepage;
import com.cmro.qa.pages.Loginpage;

public class LoginPageTest extends TestBase {
	
	public Loginpage loginpage;
	public Homepage homepage;
	
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void Setup() {
		initilization();
		loginpage = new Loginpage();
		
	}

	
	@Test(priority=1)
	public void PageTitle() {
	String title =loginpage.validateTitle();
	Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void Login() throws InterruptedException {
		homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		Thread.sleep(5000);
	}

	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
