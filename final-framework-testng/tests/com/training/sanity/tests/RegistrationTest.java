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

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegistrationTest {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private Registration Registration;
	private Login login;
	
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
	public void Registratingnewcourse() throws InterruptedException {
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		Registration.clickRegistrationTab();
		Registration.clickcreateCourselnk();
		Registration.enterTitle("Testing010");
		Registration.enterCourseCode("Testing010");
		Thread.sleep(3000);
		Registration.enterteacher("dinuser");
		Thread.sleep(3000);
		Registration.clickenterteacher();
		Registration.selectcategory("PR001");
		Registration.selectlanguage("english");
		Registration.clickcreatecoursebtn();
		Registration.entersearchitem("Testing010");
		Thread.sleep(3000);
		Registration.clickSearchBtn();
		Thread.sleep(3000);
        Boolean vc = Registration.validatecourseList("Testing010");
		Assert.assertTrue(vc);
		screenShot.captureScreenShot("First");
	}
}
