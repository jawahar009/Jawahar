package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCoursetoUser {
	private WebDriver driver; 
	
	public AddCoursetoUser(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'user2course')]")
	private WebElement addUsertoCourse; 
	
	@FindBy(xpath="//select[@name='UserList[]']")
	private WebElement selectuser;
	
	
	@FindBy(xpath="//select[@name='CourseList[]']")
	private WebElement selectcourse;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement AddtoCourseBtn;
	

	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertSuccess;
	
	
	
	public void selectuserfromlist(String valuetobeselected) {
		Select sel = new Select(selectuser);
		sel.selectByValue(valuetobeselected);
	}
	
	public void selectcoursefromlist(String valuetobeselected) {
		Select sel = new Select(selectcourse);
		sel.selectByValue(valuetobeselected);
	}
	
	public void clickAddtoCourseBtn() {
		this.AddtoCourseBtn.click();
					
	}
	
	public void clickAddtoUserBtn() {
		this.addUsertoCourse.click();
					
	}
	
	public String alertSuccess() {
		String actualresult = this.alertSuccess.getText();
		return actualresult;
					
	}
	
	
	
	
	
	
	
	  
	  
	
	  

	

}
