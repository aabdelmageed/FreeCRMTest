package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	

	//PageFactory -- Object-Repository 
	
	@FindBy(xpath="//input[@name='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement submit;
	// Initializing Page Object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getTitleForLoginPage() {
		
		return driver.getTitle();
	}
	
	@Step("Login With FreeCRM App with username: {0} And Password: {1} ")
	public HomePage login(String usename , String pass) {
		loginEmailAddress.sendKeys(usename);
		password.sendKeys(pass);
		submit.click();
		return new HomePage();
	}
}
