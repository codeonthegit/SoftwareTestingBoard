package com.SoftwareTestingBoard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[@class=\"action showcart active\"]")
	WebElement clickOnCheckoutButton;
	
		
	@FindBy(id="top-cart-btn-checkout")
	WebElement clickOnProceedToCheckoutButton;
	
	public void proceedToCheckout() throws Exception
	{
		Thread.sleep(2000);
		clickOnCheckoutButton.click();
		Thread.sleep(2000);
		clickOnProceedToCheckoutButton.click();
	}
		
	@FindBy(id="B8W0VYJ")
	WebElement firstName;
	
	@FindBy(id="JL8H7NG")
	WebElement lastName;
	
	@FindBy(id="U9CKJHJ")
	WebElement StreetAddress;
	
	@FindBy(id="SP4WK6X")
	WebElement city;
	
	public void enterInfo()
	{
		firstName.sendKeys("Test");
		lastName.sendKeys("Here");
		StreetAddress.sendKeys("2345 near New York");
		city.sendKeys("New York");
	}
	
	
	public void selectStatevalue()
	{
	WebElement selectState=driver.findElement(By.id("V1KMA7M"));
	Select s= new Select(selectState);
	s.selectByVisibleText("New York");
	}
	
	@FindBy(id="N690CX4")
	WebElement zipCode;
	
	public void enterZip()
	{
		zipCode.sendKeys("52424");
	}
	
	
	public void selectCountry()
	{
	WebElement selectcountry=driver.findElement(By.id("P4H60KX"));
	Select s= new Select(selectcountry);
	s.selectByValue("US");
	}
	
	@FindBy(id="XTO4DW0")
	WebElement phoneNumber;
	
	public void enterPhone()
	{
		phoneNumber.sendKeys("1234567890");
	}
	
	@FindBy(xpath = "//button[@data-role=\"opc-continue\"]/span")
	WebElement Next;
	
	public void clickOnNext()
	{
		Next.click();
	}
	

}
