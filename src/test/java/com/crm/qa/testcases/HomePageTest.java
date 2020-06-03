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
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SoftAssert softAssert = new SoftAssert();

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		mainPage = new MainPage();
		loginPage = mainPage.clickLoginCRM();
		homePage = loginPage.login(prob.getProperty("username"), prob.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.homePageTitle();
		System.out.println(homePageTitle);
		softAssert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title Not Matched");
		softAssert.assertAll();

	}
	
	@Test(priority=2)
	public void verifyUserNameTitleTest() {
		Assert.assertTrue(homePage.verifyloginUserName());
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
