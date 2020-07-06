package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.training.pom.reportGenerationStudent;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class reportGenerationStudentTest {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	private reportGenerationStudent reportGenerationStudent;
	
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
		reportGenerationStudent = new reportGenerationStudent(driver);
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
	/* To verify whether application allows admin to generate report based
	  on the student*/
	public void ReportGenerationStudent() throws InterruptedException {
		login.sendUserName("kamarajteach");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		reportGenerationStudent.clickreportingtab();
		reportGenerationStudent.enterkeywordTxtBox("kamaraj");
		reportGenerationStudent.clicksearchBtn();
		reportGenerationStudent.clickfollowedStudentLnk();
		reportGenerationStudent.clickstudentsArrow();
		reportGenerationStudent.clickcourseArrow();
		reportGenerationStudent.clickquizIcon();
		reportGenerationStudent.clicksendemailCheckbox();
		reportGenerationStudent.clickcorrectTextBtn();
		String actuals= reportGenerationStudent.validateconfirmTxt();
		String expected = "Message Sent";
		//validate the success Message
		Assert.assertEquals(actuals, expected);
		reportGenerationStudent.clickcoursenameLnk();
		screenShot.captureScreenShot("Report Generation Student");
	
	}
}
