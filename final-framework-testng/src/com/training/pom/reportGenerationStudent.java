package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reportGenerationStudent {
	private WebDriver driver; 
	
	public reportGenerationStudent(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'/main/mySpace')]")
	private WebElement reportingtab ; 
	
	@FindBy(xpath="//a[contains(@href,'/main/mySpace/student')]")
	private WebElement followedStudentLnk;
	
	@FindBy(id="search_user_keyword")
	private WebElement keywordTxtBox; 
	
	@FindBy(id="search_user_submit")
	private WebElement searchBtn ; 
	
	@FindBy(xpath="//a[contains(@href,'/main/mySpace/myStudents')]/img")
	private WebElement studentsArrow; 
	
	@FindBy(xpath="//a[contains(@href,'infosStudent')]/img")
	private WebElement courseArrow; 
	
	@FindBy(xpath="(//*[@alt='Test'])[1]")
	private WebElement quizIcon;
	
	@FindBy(name="send_notification")
	private WebElement sendemailCheckbox;
	
	@FindBy(id="form-email_submit")
	private WebElement correctTestBtn;
	
	@FindBy(xpath="//*[@class='alert alert-info']")
	private WebElement messageSentMsg;
	
	@FindBy(xpath="(//*[@class='active']/a)[1]")
	private WebElement coursenameLnk;
	
		
	
	public void clickreportingtab() {
		this.reportingtab.click();
	}
	
	public void clickfollowedStudentLnk() {
		this.followedStudentLnk.click();
	}
	
	public void enterkeywordTxtBox(String entervalue) {
		this.keywordTxtBox.sendKeys(entervalue);
	}
	
	public void clicksearchBtn() {
		this.searchBtn.click();
	}
	
	public void clickstudentsArrow() {
		this.studentsArrow.click();
	}
	
	public void clickcourseArrow() {
		this.courseArrow.click();
	}
	
	public void clickquizIcon() {
		this.quizIcon.click();
	}
	
	public void clicksendemailCheckbox() {
		this.sendemailCheckbox.click();
	}
	
	public void clickcorrectTextBtn() {
		this.correctTestBtn.click();
	}
	
	public String validateconfirmTxt() {
		String messagetext =this.messageSentMsg.getText();
		return messagetext;
	}
	
	public void clickcoursenameLnk() {
		this.coursenameLnk.click();
	}
}
