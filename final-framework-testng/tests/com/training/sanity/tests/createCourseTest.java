package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Login;
import com.training.pom.Registration;
import com.training.pom.sessionCategories;
import com.training.pom.createCourse;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class createCourseTest {

	private WebDriver driver;
	private String baseUrl;
	public ExtentReports extent;
	public ExtentTest extentTest;
	private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	private sessionCategories sessionCategories;
	private createCourse createCourse;
	
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/createcourse.html");
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		 
		login = new Login(driver); 
		Registration = new Registration(driver); 
	    createCourse = new createCourse(driver);
		
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
		extent.flush();
		extent.close();
		driver.quit();
	}
	@Test
	/*To verify whether application allows admin to create training session
	  based on the created sessions categories list*/
	public void CreateSessionCategories() throws InterruptedException {
		extentTest = extent.startTest("create course");
		login.sendUserName("kamarajteach");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		createCourse.clickcreateCourseLnk();
		createCourse.enterCoursetextbox("selenium10020030");
		createCourse.clickadvanceButton();
		createCourse.entercoursecode("selenium10020030");
		createCourse.selectcourseCategory("PR001");
		createCourse.selectlanguage("english");
		createCourse.clickCreatethiscourse();
		createCourse.clickintroductioIcon();
		Thread.sleep(10000);
		createCourse.enterintroductionTxt("this is selenium");
		createCourse.clicksaveintroduction();
		createCourse.clickcoursedescription();
		createCourse.clickDescriptionIcon();
		createCourse.enterDescriptionTitle("selenium course for beginners");
		Thread.sleep(5000);
		createCourse.enterDescriptionContent("this is content");
		createCourse.clicksaveBtn();
		createCourse.clickObjectiveIcon();
		createCourse.enterObjectiveTitle("Selenium for begineers");
		Thread.sleep(5000);
		createCourse.enterObjectiveContent("this is content");
		createCourse.clicksaveBtn();
		createCourse.clickTopicicon();
		createCourse.enterTopicTitle("Selenium for begineers");
		Thread.sleep(5000);
		createCourse.enterTopicContent("this is content");
		createCourse.clicksaveBtn();
		createCourse.clickdropdown();
		createCourse.clickLogout();
		login.sendUserName("kamarajstudent");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		createCourse.clickcoursesCatalog();
		createCourse.enterSearchterm("selenium10020030");
		createCourse.clicksearchBtn();
		createCourse.clickSubscribeBtn();
		createCourse.clickdropdown();
		createCourse.clickLogout();
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		createCourse.clickreportingTab();
		createCourse.clickfollowedStudents();
		createCourse.enterStudent("Sunil");
		createCourse.clicksearchButton();
		createCourse.clickstudentrightarrow();
		createCourse.clickcourserightarrow();
		String expected = "Achieved skills";
		String actual= createCourse.validateskills();
		Assert.assertEquals(actual, expected);
		extentTest.log(LogStatus.INFO, actual);
		extent.endTest(extentTest);
		
		screenShot.captureScreenShot("Create course");
	}
}
