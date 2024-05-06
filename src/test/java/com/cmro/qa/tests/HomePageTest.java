package com.cmro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmro.qa.base.TestBase;
import com.cmro.qa.pages.CalenderPage;
import com.cmro.qa.pages.Homepage;
import com.cmro.qa.pages.Loginpage;

public class HomePageTest extends TestBase {
	
	Homepage homepage;
	Loginpage loginpage;
	CalenderPage calenderpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		homepage = new Homepage();
		loginpage = new Loginpage();
		calenderpage = new CalenderPage();
		homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@Test(priority=1)
	public void verifytitle()
	{
		String homepaget = homepage.verifyHomePage();
		Assert.assertEquals(homepaget, "Cogmento CRM", "Homepage titile not found");
	}
	
	@Test(priority=2)
	public void calender_Page()
	{
		calenderpage = homepage.calender_Page();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
}
