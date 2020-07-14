package com.training.sanity.tests;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Login;
import com.training.pom.Registration;
import com.training.pom.sessionCategories;
import com.training.pom.LoginPOM;
import com.training.pom.studentRegistrationwithInvalidCredentials;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class studentRegistrationwithInvalidCredentialsTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	private sessionCategories sessionCategories;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private studentRegistrationwithInvalidCredentials studentRegistrationwithInvalidCredentials;
	

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/studentregistrationwithinvalidcredentials.html");
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
		studentRegistrationwithInvalidCredentials = new studentRegistrationwithInvalidCredentials(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		extent.flush();
		extent.close();
		driver.quit();
		driver.quit();
	
	}
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	/* TO verify whether application displays error message upon entering invalid credentials in student registration page */
	public void StudentRegistrationwithInvalidCredentials(String firstname,String lastname,String email, String username, String password, String confirmpassword, String phone,String language) {
		extentTest = extent.startTest("Student registration for Invalid validation");
		studentRegistrationwithInvalidCredentials.clicksignupBtn();
		studentRegistrationwithInvalidCredentials.enterfirstname(firstname);
		studentRegistrationwithInvalidCredentials.enterlastname(lastname);
		studentRegistrationwithInvalidCredentials.enteremail(email);
		studentRegistrationwithInvalidCredentials.enterusername(username);
		studentRegistrationwithInvalidCredentials.enterpassword(password);
		studentRegistrationwithInvalidCredentials.enterconfirmpassword(confirmpassword);
		studentRegistrationwithInvalidCredentials.enterphonenumber(phone);
		studentRegistrationwithInvalidCredentials.selectlanguage(language);
		//studentRegistrationwithInvalidCredentials.clickstudentchkbox();
		studentRegistrationwithInvalidCredentials.clickregisterBtn();
		String actualtext =studentRegistrationwithInvalidCredentials.validateerrorMSg();
	    String expectedtext = "This login is already in use";
	    Assert.assertEquals(actualtext, expectedtext);
		extentTest.log(LogStatus.INFO, actualtext);
		extent.endTest(extentTest);
		

	}
}
