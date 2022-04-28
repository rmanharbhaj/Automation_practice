package com.ap.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class DressesPage extends TestBase {
	
	
	@FindBy(xpath = "(//span[contains(text(),'Dresses')])[1]")
	public WebElement bannerDresses;
	
	@FindBy(xpath = "//ul[@id='ul_layered_category_0']//li")
	public List<WebElement> categoriesList;
	
	public DressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfDresses() {
		return driver.getTitle();
	}
	
	public boolean verifyBannerOfDresses() {
		return bannerDresses.isDisplayed();
	}
	
	public void getListOfCategories() throws InterruptedException {
		for(WebElement a:categoriesList) {
			System.out.println(a.getText());
		}
		categoriesList.get(0).click();
		Thread.sleep(3000);
		categoriesList.get(1).click();
		Thread.sleep(2000);
		categoriesList.get(2).click();
	}

}
