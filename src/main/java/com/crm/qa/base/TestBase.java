package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prob;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {
		prob = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Ahmed Adel\\Eclipse Work Space\\FreeCRMTest\\src"
					+ "\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prob.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException o) {
			o.printStackTrace();
		}
	}


	public static void initialization() {

		String browserName = prob.getProperty("browser");
		log.info("Lanching Chrome browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

		}
		tdriver.set(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prob.getProperty("url"));
	}

	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public void takeScreenShotWithFailedTC(String testMethodName) {
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("D:\\Ahmed Adel\\Eclipse Work Space\\TestNGTutorial\\screenShots\\"+
		"failedshotForTestMethod_"+testMethodName+"_.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
