package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory -- Object-Repository 
	@FindBy(xpath="//span[contains(text(),'Ahmed Adel')]")
	WebElement loginUserNameLable;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyloginUserName() {
		return loginUserNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}
}
