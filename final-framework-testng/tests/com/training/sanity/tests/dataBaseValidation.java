package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Login;
import com.training.pom.LoginPOM;
import com.training.pom.Registration;
import com.training.pom.sessionCategories;

import com.training.pom.LoginPOM;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.bean.LoginBean;
import com.training.pom.studentRegistrationwithInvalidCredentials;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class  dataBaseValidation{

	private WebDriver driver;
	private String baseUrl;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	//private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	private LoginPOM loginPOM;
	private LoginBean LoginBean;
	private sessionCategories sessionCategories;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private studentRegistrationwithInvalidCredentials studentRegistrationwithInvalidCredentials;
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/datbasevalidation.html");
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception 
	{
		extentTest = extent.startTest("Launch browser");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		
		login = new Login(driver); 
		Registration = new Registration(driver); 
		loginPOM = new LoginPOM(driver);
		LoginBean = new LoginBean();
		sessionCategories = new sessionCategories(driver);
		studentRegistrationwithInvalidCredentials = new studentRegistrationwithInvalidCredentials(driver);
		baseUrl = properties.getProperty("baseURL");
		String pagetitle= driver.getTitle();
		extentTest.log(LogStatus.PASS,pagetitle);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//Thread.sleep(5000);
		extent.endTest(extentTest);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
		extent.flush();
		extent.close();
		driver.quit();
	}
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	
	public void dataBasevalidations(String userName, String password) {
		/*To verify whether registered student details get stored in database  */
		extentTest = extent.startTest("Registration validation");
		studentRegistrationwithInvalidCredentials.clicksignupBtn();
		studentRegistrationwithInvalidCredentials.enterfirstname(userName);
		studentRegistrationwithInvalidCredentials.enterlastname(password);
		studentRegistrationwithInvalidCredentials.enteremail("manzoor@gmail.com");
		studentRegistrationwithInvalidCredentials.enterusername("Mangor4");
		studentRegistrationwithInvalidCredentials.enterpassword("manzoor");
		studentRegistrationwithInvalidCredentials.enterconfirmpassword("manzoor");
		studentRegistrationwithInvalidCredentials.enterphonenumber("9876543210");
		studentRegistrationwithInvalidCredentials.selectlanguage("English");
		//studentRegistrationwithInvalidCredentials.clickstudentchkbox();
		studentRegistrationwithInvalidCredentials.clickregisterBtn();
		String expected = "Registration";
		String actual = studentRegistrationwithInvalidCredentials.validateerrorMSg();
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("Registration validation");
		extentTest.log(LogStatus.INFO, actual);
		extent.endTest(extentTest);	

	}
}
