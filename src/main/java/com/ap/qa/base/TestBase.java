package com.ap.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.qa.utilities.TestUtil;
import com.ap.qa.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties p;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		p= new Properties();
		try {
			FileInputStream fis=new FileInputStream("/Users/rjghori/eclipse-workspace/AutomationPracticeTest/src/main/java/com/ap/qa/config/config.properties");
			p.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void init() {
		
		String browserName = p.getProperty("Browser");
		
				
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/rjghori/SeleniumJars/chromedriver");
			driver=new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/rjghori/SeleniumJars/geckodriver");
			driver=new FirefoxDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "/Users/rjghori/SeleniumJars/safaridriver");
			driver=new SafariDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Pageload_timeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_wait));
		
		driver.get(p.getProperty("Url"));
	}

}
