package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageFactory.googleMapHomePage;

import org.testng.annotations.Test;


public class testCases {
	
	String driverPath= "C:\\chromedriver.exe";
	String Url = "https://www.google.com/maps";
	WebDriver driver;
	
	googleMapHomePage objGoogleMapHomePage;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("−−incognito");

		this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        this.driver.get(Url);
        objGoogleMapHomePage = new googleMapHomePage(this.driver);
	}
	
		
	@Test(testName="searchFieldVerification",priority=1)
	public void searchVerification () {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		objGoogleMapHomePage.enterSerachKey(input);
		
		WebElement [] tmp = objGoogleMapHomePage.getSearchResults();
		
	for (int i=0; i<tmp.length; i++) {
			Assert.assertEquals(tmp[i].getText(), "Dublin");
		}
	}
	
		@AfterTest
	public void closeBrowser() {
		this.driver.close();
	}
  
 }

