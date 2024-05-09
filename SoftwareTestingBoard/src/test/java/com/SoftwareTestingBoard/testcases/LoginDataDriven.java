package com.SoftwareTestingBoard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SoftwareTestingBoard.pages.BaseClass;
import com.SoftwareTestingBoard.pages.LoginPage;
import com.SoftwareTestingBoard.utility.ExcelDataProvider;



public class LoginDataDriven extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = ExcelDataProvider.class, priority = 1)
	public void loginDDT(String usernm, String pwd) throws Exception {
		logger = report.createTest("Data driven Test for framework");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteremail(usernm);
		logger.info("Email provided");
		loginPage.enterpassword(pwd);
		logger.info("password provided");
		loginPage.clickonSignIn();
		logger.info("login success");
		Thread.sleep(2000);
		
		//validation
		String actualTitle=driver.getTitle();
		String ExpTitle="Home Page";
		Assert.assertEquals(actualTitle,ExpTitle, "Title is mismatched"); //Compare both titles
		}

}
