package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reportGenerationTeacher {
	private WebDriver driver; 
	
	public reportGenerationTeacher(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(@href,'/main/mySpace/teachers')]")
	private WebElement followedTeacherLnk;
	
	
	@FindBy(xpath="(//a[contains(@href,'infosStudent')]/img)[2]")
	private WebElement courseArrow; 
	
	
	public void clickfollowedTeacherLnk() {
		this.followedTeacherLnk.click();
	}
	
	public void clickcourseArrow() {
		this.courseArrow.click();
	}
	
}
