package com.crm.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MainPage extends TestBase {
	
	//PageFactory -- Object-Repository 
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement loginLink;

	@FindBy(linkText="Sign Up")
	WebElement signUpLink;

	
	// Initializing Page Object
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public LoginPage clickLoginCRM() {
		loginLink.click();
		//Landing to LoginPage
		return new LoginPage();
		
	}
	
	public String getTitleForMainPage() {
		
		return driver.getTitle();
	}
	
	
	public SignUpPage clickSignUpCRM() {
		signUpLink.click();
		//Landing to SignUpPage
		return new SignUpPage();
		
	}

}
