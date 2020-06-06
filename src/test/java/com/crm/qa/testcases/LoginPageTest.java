package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class LoginPageTest extends TestBase{
	
	MainPage  mainPage;
	LoginPage loginPage;
	HomePage  homePage ;
	SoftAssert softAssert= new SoftAssert();

	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Login Page Test");
		mainPage  = new MainPage();
		loginPage = new LoginPage();
		homePage  = new HomePage();
	}
	

	@Test(priority=1)
	public void getTitleForMainPage() {
		String title=mainPage.getTitleForMainPage();
		System.out.println("title "+title);
		softAssert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		softAssert.assertAll();
	}
	
	@Test (priority=2)
	public void loginCRMTest() throws InterruptedException
	{
		mainPage.clickLoginCRM();
		homePage=loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
		String title=loginPage.getTitleForLoginPage();
		System.out.println("title "+title);
		softAssert.assertEquals(title, "Cogmento CRM");
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
