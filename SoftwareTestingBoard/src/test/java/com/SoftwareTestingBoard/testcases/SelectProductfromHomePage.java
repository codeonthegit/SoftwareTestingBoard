package com.SoftwareTestingBoard.testcases;

import org.testng.annotations.Test;

import com.SoftwareTestingBoard.pages.BaseClass;
import com.SoftwareTestingBoard.pages.CheckoutPage;
import com.SoftwareTestingBoard.pages.HomePage;
import com.SoftwareTestingBoard.pages.LoginPage;


public class SelectProductfromHomePage extends BaseClass{

	@Test
	public void loginDDT() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp("Testhere@yopmail.com", "Team@123");
		Thread.sleep(2000);
				
		HomePage homePage=new HomePage(driver);
		homePage.selectProduct();
		Thread.sleep(2000);
		homePage.selectSize();
		homePage.selectcolor();
		homePage.clickOnAddtoCart();
		Thread.sleep(2000);
		
	 	CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.proceedToCheckout();
		checkoutpage.enterInfo();
		checkoutpage.selectStatevalue();
		checkoutpage.enterZip();
		checkoutpage.selectCountry();
		checkoutpage.enterPhone();
		checkoutpage.clickOnNext();
		
		
	}
}
