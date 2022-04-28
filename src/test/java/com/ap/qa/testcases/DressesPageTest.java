//DRESSES PAGE//

package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.DressesPage;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class DressesPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	DressesPage dp;
	
	public DressesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		lp=new LoginPage();
		hp=new HomePage();
		hp=lp.login(p.getProperty("Username"), p.getProperty("Password"));
		dp=hp.clickOnDressesLink();
	}
	
	@Test(priority = 1)
	public void verifyTitleOfDressesTest() {
		String actual=dp.verifyTitleOfDresses();
		Assert.assertEquals(actual, "Dresses - My Store","Not Matched");
	}
	
	@Test(priority = 2)
	public void verifyBannerOfDressesTest() {
		Assert.assertTrue(dp.verifyBannerOfDresses(), "Banner is not found");
	}
	
	@Test(priority = 3)
	public void getListOfCategoriesTest() throws InterruptedException {
		dp.getListOfCategories();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
