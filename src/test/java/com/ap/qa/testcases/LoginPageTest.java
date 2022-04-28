package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		lp=new LoginPage();

	}
	
	@Test(priority = 1)
	public void loginTitleTest() {
		String loginTitle=lp.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "Login - My Store");
	}
	
	@Test(priority = 2)
	public void validateLogoTest() {
		boolean flag=lp.validateLogo();
		Assert.assertTrue(flag, "logo is correct");
		
	}
	
	@Test(priority = 3)
	public void validateLinkTest() {
		String actual=lp.validateAuthLink();
		Assert.assertEquals(actual, "Authentication");
		
	}
	
	@Test(priority = 4)
	public void loginTest() {
		hp=lp.login(p.getProperty("Username"), p.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
