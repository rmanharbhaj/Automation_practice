package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[@class='navigation_page']")
	public WebElement authLink;
	
	@FindBy(xpath = "(//div[@id='block_top_menu']//a)[1]")
	public WebElement womenLink;
	
	@FindBy(xpath = "(//div[@id='block_top_menu']//a)[9]")
	public WebElement dressesLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePagetitle(){
		return driver.getTitle();
	}
	
	public String validateAuthLink(){
		return authLink.getText();
	}
	
	public WomenPage clickOnWomenLink() {
		womenLink.click();
		return new WomenPage();
	}
	
	public DressesPage clickOnDressesLink() {
		dressesLink.click();
		return new DressesPage();
	}

}
