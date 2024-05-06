package com.cmro.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmro.qa.base.TestBase;

public class ContactUsPage extends TestBase{
	
	WebDriverWait wait;
	Duration timeout;
	Actions action = new Actions(driver);
	
	@FindBy(xpath= "//button[@class='ui linkedin button']//child::i[@class='edit icon']")
	WebElement Create;
	
	@FindBy(xpath= "//span[text()='Lead']")
	WebElement lead;
	
	@FindBy(xpath= "//span[text()='Customer']")
	WebElement customer;
	
	@FindBy(xpath= "//span[text()='Contact']")
	WebElement contact;
	
	@FindBy(xpath= "//span[text()='Affiliate']")
	WebElement affiliate;

	@FindBy (name= "first_name")
	WebElement Firstname;
	
	@FindBy (name= "last_name")
	WebElement lastname;
	
	@FindBy (name= "category")
	WebElement Category;
	
	@FindBy (xpath= "//button[@class='ui linkedin button']//child::i[@class='save icon']")
	WebElement save;
	
	public ContactUsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void CreateContactPage(String ftname, String Ltname, String Customer_title) throws InterruptedException {
		Create.click();
		wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Firstname));
		Firstname.sendKeys(ftname);
		wait.until(ExpectedConditions.visibilityOf(lastname));
		lastname.sendKeys(Ltname);
		wait.until(ExpectedConditions.visibilityOf(Category));
		Category.click();
	//	Select select = new Select(Category);
		//select.selectByVisibleText(Customer_title);
		/*Select select = new Select(Category);
		select.selectByVisibleText(Lead);
		select.selectByVisibleText(Customer);
		select.selectByVisibleText(Contact);
		select.selectByVisibleText(Affiliate);
	    /*lead.sendKeys(Lead);
		customer.sendKeys(Customer);
		contact.sendKeys(Contact);
		affiliate.sendKeys(Affiliate);*/
		save.click();
	}
	

}
