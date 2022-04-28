package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="passwd")
	public WebElement passWord;
	
	@FindBy(id="SubmitLogin")
	public WebElement loginButton;
	
	@FindBy(id="header_logo")
	public WebElement logo;
	
	@FindBy(xpath = "//span[@class='navigation_page']")
	public WebElement authLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateAuthLink() {
		return authLink.getText();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String user,String pass) {
		email.sendKeys(user);
		passWord.sendKeys(pass);
		loginButton.click();
		
		return new HomePage();
	}

}
