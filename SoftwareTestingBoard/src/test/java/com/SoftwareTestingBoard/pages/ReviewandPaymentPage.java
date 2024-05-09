package com.SoftwareTestingBoard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewandPaymentPage {
	WebDriver driver;
	
	public ReviewandPaymentPage(WebDriver ldriver){
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	public void clickOnPlaceOrder()
	{
		driver.findElement(By.xpath("//button[@class=\"action primary checkout\"]")).click();
	}

}
