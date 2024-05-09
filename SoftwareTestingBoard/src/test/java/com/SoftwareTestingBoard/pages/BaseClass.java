package com.SoftwareTestingBoard.pages;

import java.io.File;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.SoftwareTestingBoard.utility.BrowserFactory;
import com.SoftwareTestingBoard.utility.ConfigDataProvider;
import com.SoftwareTestingBoard.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	// public Logger logger1;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	public Helper helper;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and Test is getting ready", true);
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/Framework+" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done-Test can be started",true);
	}

	@BeforeClass
	public void setUp() {
		
		Reporter.log("Trying to start browser and Getting application ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		Reporter.log("Browser and  Application is up and running",true);

		// logger=logger.getLogger("Framework");
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		Reporter.log("Test is about to end",true);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed >>>> Reports Generated",true);
	}
	
	public boolean isAlertPresent() // User defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
}
