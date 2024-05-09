package com.SoftwareTestingBoard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "pass")
	WebElement pass;

	@FindBy(id = "send2")
	WebElement SignInButton;

	public void loginToApp(String enteremail, String enterpasss) throws Exception {
		Thread.sleep(2000);
		email.sendKeys(enteremail);
		pass.sendKeys(enterpasss);
		SignInButton.click();

	}

	public void enteremail(String username) {
		email.sendKeys(username);
	}

	public void enterpassword(String pwd) {
		pass.sendKeys(pwd);
	}

	public void clickonSignIn() {
		SignInButton.click();
	}

	public void clickOnSignout() throws Exception {
		driver.findElement(By.xpath("//div[@class=\"panel header\"]/ul/li[2]/span/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"panel header\"]/ul/li[2]/div/ul/li[3]/a")).click();

	}

}
