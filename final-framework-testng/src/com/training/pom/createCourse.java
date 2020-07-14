package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createCourse {
	private WebDriver driver; 
	
	public createCourse(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'add_course')]")
	private WebElement createCourseLnk;
	
	@FindBy(id="title")
	private WebElement coursetextbox; 


	@FindBy(id="advanced_params")
	private WebElement advanceButton; 
	
	@FindBy(id="add_course_wanted_code")
	private WebElement courseCode;
	
	@FindBy(id="add_course_category_code")
	private WebElement courseCategorydropdown;
	
	@FindBy(id="add_course_course_language")
	private WebElement courseLanguage; 
	
	@FindBy(id="add_course_submit")
	private WebElement createthisCourse;
	
	@FindBy(xpath="(//*[@title='Add an introduction text'])[1]")
	private WebElement introductioIcon;
	
	@FindBy(xpath="//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement introductionTxtBox; 
	
	@FindBy(id="introduction_text_intro_cmdUpdate")
	private WebElement saveIntroductionTxt;
	
	@FindBy(xpath="//*[@title='Course description']")
	private WebElement coursedescriptionIcon;

	@FindBy(xpath="//*[@title='Description']")
	private WebElement DescriptionIcon;
	
	@FindBy(id="course_description_title")
	private WebElement DescriptionTitle;
	
	@FindBy(xpath="//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement descContent;
	
	
	@FindBy(id="course_description_submit")
	private WebElement saveBtn;
	
	@FindBy(xpath="//*[@title='Objectives']")
	private WebElement ObjectiveIcon;
	
	@FindBy(id="course_description_title")
	private WebElement ObjectiveTitle;
	
	@FindBy(xpath="//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement ObjectiveContent;
	
	
	@FindBy(xpath="//*[@title='Topics']")
	private WebElement topicsIcon;
	
	@FindBy(id="course_description_title")
	private WebElement topicsTitle;
	
	@FindBy(xpath="//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement topicscontent;
	
	
	
	@FindBy(xpath="//*[@class='dropdown-toggle']")
	private WebElement dropdownToggle;
	
	@FindBy(xpath="//*[@id='logout_button']")
	private WebElement logoutButton;
	
	@FindBy(xpath="//a[@href='main/auth/courses.php']")
	private WebElement coursesCatalog;
	
	@FindBy(xpath="//*[@name='search_term']")
	private WebElement searchTerm;
	
	@FindBy(xpath="//*[@class='input-group-btn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[@title='Subscribe']")
	private WebElement subscribeBtn;
	

	@FindBy(xpath="//*[@class='alert alert-info']")
	private WebElement subscribedSuccessMsg;
	
	@FindBy(xpath="//*[@title='Reporting']")
	private WebElement reportingTab;
	
	@FindBy(xpath="//a[contains(@href,'mySpace/student')]")
	private WebElement followedStudents;
	

	@FindBy(id="search_user_keyword")
	private WebElement keywordStudent;

	@FindBy(id="search_user_submit")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[contains(@src,'2rightarrow')]")
	private WebElement studentrightarrow;
	
	@FindBy(xpath="(//*[contains(@src,'2rightarrow')])[1]")
	private WebElement courserightarrow;
	
	@FindBy(xpath="//*[@id='skillList']/h3")
	private WebElement AchievedSkills;
	
	
	
	public void clickcreateCourseLnk() {
		this.createCourseLnk .click();				
	}
	
	public void enterCoursetextbox(String valuetobeentered) {
		this.coursetextbox.sendKeys(valuetobeentered);			
	}
	
	public void clickadvanceButton() {
		this.advanceButton.click();				
	}
	
	public void entercoursecode(String valuetobeentered) {
		this.courseCode.sendKeys(valuetobeentered);				
	}
	public void selectcourseCategory(String valuetobeentered) {
		Select sel = new Select(courseCategorydropdown);
		sel.selectByValue(valuetobeentered);
	}
	public void selectlanguage(String valuetobeentered) {
		Select sel = new Select(courseLanguage);
		sel.selectByValue(valuetobeentered);
	}
	
	public void clickCreatethiscourse() {
		this.createthisCourse.click();				
	}
	
	public void clickintroductioIcon() {
		this.introductioIcon.click();				
	}
	
	public void enterintroductionTxt(String valuetobeentered) {
		driver.switchTo().frame(0);	
		this.introductionTxtBox.sendKeys(valuetobeentered);	
		driver.switchTo().defaultContent();
	}
	
	public void clicksaveintroduction() {
		this.saveIntroductionTxt.click();			
	}
	
	public void clickcoursedescription() {
		this.coursedescriptionIcon.click();			
	}
	
	public void clickDescriptionIcon() {
		this.DescriptionIcon.click();			
	}
	
	public void enterDescriptionTitle(String valuetobeentered) {
		this.DescriptionTitle.sendKeys(valuetobeentered);
		
	}
	
	public void enterDescriptionContent(String valuetobeentered) {
		driver.switchTo().frame(0);	
		this.descContent.sendKeys(valuetobeentered);
		driver.switchTo().defaultContent();
	}
	
	public void clickObjectiveIcon() {
		this.ObjectiveIcon.click();			
	}
	
	public void enterObjectiveTitle(String valuetobeentered) {
		this.ObjectiveTitle.sendKeys(valuetobeentered);
		
	}
	
	public void enterObjectiveContent(String valuetobeentered) {
		driver.switchTo().frame(0);	
		this.ObjectiveContent.sendKeys(valuetobeentered);
		driver.switchTo().defaultContent();
	}
	
	public void clickTopicicon() {
		this.topicsIcon.click();			
	}
	
	public void enterTopicTitle(String valuetobeentered) {
		this.topicsTitle.sendKeys(valuetobeentered);
		
	}
	
	public void enterTopicContent(String valuetobeentered) {
		driver.switchTo().frame(0);	
		this.topicscontent.sendKeys(valuetobeentered);
		driver.switchTo().defaultContent();
	}
	
	
	
	public void clicksaveBtn() {
		this.saveBtn.click();			
	}
	
	public void clickdropdown() {
		this.dropdownToggle.click();			
	}

	public void clickLogout() {
		this.logoutButton.click();			
	}

	public void clickcoursesCatalog() {
		this.coursesCatalog.click();			
	}
	

	public void enterSearchterm(String valuetobeentered) {
		this.searchTerm.sendKeys(valuetobeentered);
	
	}
	
	public void clicksearchBtn() {
		this.searchBtn.click();			
	}
	
	public void clickSubscribeBtn() {
		this.subscribeBtn.click();			
	}
	
	public void clickreportingTab() {
		this.reportingTab.click();			
	}
	
	public void clickfollowedStudents() {
		this.followedStudents.click();			
	}
	
	public void enterStudent(String valuetobeentered) {
		this.keywordStudent.sendKeys(valuetobeentered);
	
	}
	
	public void clicksearchButton() {
		this.searchButton.click();			
	}
	
	public void clickstudentrightarrow() {
		this.studentrightarrow.click();			
	}
	
	public void clickcourserightarrow() {
		this.courserightarrow.click();			
	}
	public String validateskills() {
		 String skills = this.AchievedSkills.getText();
		return skills;
	}		

}
