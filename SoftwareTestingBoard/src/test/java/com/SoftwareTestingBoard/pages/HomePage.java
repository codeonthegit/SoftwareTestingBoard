package com.SoftwareTestingBoard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	//@FindBy(xpath="//a[@id='ui-id-4']/span[1]")
//WebElement clickonWomenText
	
	public void selectProduct()
	{
		
		//driver.findElement(By.xpath("//a[@id='ui-id-4']/span[1]")).click();
		//driver.findElement(By.xpath("//a[@id='ui-id-9']")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id='ui-id-4']/span[1]"))).perform();  //MoveonWomen
		driver.findElement(By.xpath("//a[@id='ui-id-9']")).click(); //ClickOnTop
		act.doubleClick(driver.findElement(By.xpath("//img[@src=\"https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/t/wt09-white_main_1.jpg\"]"))).perform();
				
	}
	
	@FindBy(id="option-label-size-143-item-166")
	WebElement size;
	
	@FindBy(id="option-label-color-93-item-59")
	WebElement color;
	
	@FindBy(id="product-addtocart-button")
	WebElement AddtoCart;
	
	public void selectSize()
	{
		size.click();
	}
	
	public void selectcolor()
	{
		color.click();
	}
	
	public void clickOnAddtoCart()
	{
		AddtoCart.click();
	}
	
}
