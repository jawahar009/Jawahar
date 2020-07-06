package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Login;
import com.training.pom.Registration;
import com.training.pom.sessionCategories;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class sessionCategoriesTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	private sessionCategories sessionCategories;
	
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		 
		login = new Login(driver); 
		Registration = new Registration(driver); 
		sessionCategories = new sessionCategories(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	/*To verify whether application allows admin to create training session
	  based on the created sessions categories list*/
	public void CreateSessionCategories() throws InterruptedException {
		
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		Registration.clickRegistrationTab();
		Thread.sleep(3000);
		sessionCategories.clickcancelicon();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll the windows
		js.executeScript("window.scrollBy(0,200)");
		sessionCategories.clicksessionCatgoryLnk();
		//Click Add category Image
		sessionCategories.clickAddCatgoryImg();
		//enter category name in textbox
		sessionCategories.entercategoryNameTextbox("Testing 229");
		sessionCategories.clickaddCategoryBtn();
		sessionCategories.clickTrainingSessionListImg();
		sessionCategories.clickaddTrainingSessionImg();
		sessionCategories.entersessionNameTextBox("selenium session 7227");
		sessionCategories.entercoachUserName("manzoor");
		sessionCategories.clickadvancedSettingsbtn();
		Thread.sleep(3000);
		sessionCategories.selectsessionCategoryList("29");
		Thread.sleep(2000);
		sessionCategories.clicknextStepBtn();
		sessionCategories.selectcourseList("754");
		sessionCategories.clickarrowButton();
		sessionCategories.clicknextStepBtninaddCoursePage();
		Thread.sleep(2000);
		sessionCategories.enterportalUserListTextBox("sunil");
		sessionCategories.clickfirstresultDisplayed();
		sessionCategories.clickFinishSessionCreationBtn();
		String actuals= sessionCategories.validatesuceessMSG();
		String expected = "Update successful";
		//Validate the Success Message
		Assert.assertEquals(actuals, expected);
		screenShot.captureScreenShot("Session category");
		

	}
}
