package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.DressesPage;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	DressesPage dp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		lp=new LoginPage();
		hp=new HomePage();
		hp=lp.login(p.getProperty("Username"), p.getProperty("Password"));

	}
	
	@Test(priority = 1)
	public void homepageTitleTest(){
		String homePageTitle=hp.validateHomePagetitle();
		Assert.assertEquals(homePageTitle, "My account - My Store","not matched");//if title is not matched thn msg showing
		
	}
	
	@Test(priority = 2)
	public void validateLinkTest(){
		String actual=hp.validateAuthLink();
		Assert.assertEquals(actual, "My account","Not Matched");
		
	}
	
	
	@Test(priority = 3)
	public void clickOnDressesLinkTest() {
		dp=hp.clickOnDressesLink();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	


}
