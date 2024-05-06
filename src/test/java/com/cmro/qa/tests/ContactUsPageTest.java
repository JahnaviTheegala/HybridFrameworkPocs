package com.cmro.qa.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cmro.qa.base.TestBase;
import com.cmro.qa.pages.ContactUsPage;
import com.cmro.qa.pages.Homepage;
import com.cmro.qa.pages.Loginpage;
import com.cmro.qa.util.TestUtil;

public class ContactUsPageTest extends TestBase {
	
	Homepage homepage;
	Loginpage loginpage;
	ContactUsPage contctuspage;
	String sheetname = "Sheet1";
	
	public ContactUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		 homepage = new Homepage();
		 loginpage = new Loginpage();
		contctuspage = new ContactUsPage();
		homepage = loginpage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	
	@DataProvider
	public Object[][] testdata() {
		Object[][] data1 = TestUtil.getTestdata(sheetname);
		return data1;
	}
	
	@Test(dataProvider="testdata")
	public void create_contact(String firstname, String Lastname, String Customer_title) throws InterruptedException {
		homepage.Contactus_Page();
		contctuspage.CreateContactPage(firstname, Lastname, Customer_title);
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
