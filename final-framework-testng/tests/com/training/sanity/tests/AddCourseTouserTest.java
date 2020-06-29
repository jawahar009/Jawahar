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
import com.training.pom.AddCoursetoUser;
import com.training.pom.Login;
import com.training.pom.Registration;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCourseTouserTest {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	
	private Login login;
	private AddCoursetoUser AddCoursetoUser;
	
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
		 
		AddCoursetoUser = new AddCoursetoUser(driver);
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
	public void Registratingnewcourse() {
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		AddCoursetoUser.clickAddtoUserBtn();
		AddCoursetoUser.selectuserfromlist("778");
		AddCoursetoUser.selectcoursefromlist("331");
		AddCoursetoUser.clickAddtoCourseBtn();
		String expected =AddCoursetoUser.alertSuccess();
		String actual="The selected users are subscribed to the selected course";
		Assert.assertEquals(actual, expected);
	}
}
