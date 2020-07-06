package com.training.pom;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

public class sessionCategories {
	private WebDriver driver; 
	
	public sessionCategories(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(@href,'main/admin/')])[1]")
	private WebElement registrationTab; 
	
	@FindBy(xpath="//*[@class='alert alert-info']/button")
	private WebElement cancelicon; 
	
	@FindBy(xpath="(//a[contains(@href,'session_category')])")
	private WebElement sessionCatgoryLnk; 
	
	@FindBy(xpath="//*[@alt='Add category']")
	private WebElement AddCatgoryImg; 
	
	
	@FindBy(xpath="(//a[contains(@href,'main/mySpace/')])[1]")
	private WebElement reportingTab; 
	
	@FindBy(xpath="(//a[contains(@href,'main/mySpace/student')])")
	private WebElement followedStudents; 
	
	@FindBy(id="search_user_keyword")
	private WebElement keywordTextbox;
	
	@FindBy(id="search_user_submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[@src='http://elearningm1.upskills.in/main/img/icons/22/2rightarrow.png']")
	private WebElement studentNextArrow; 
	
	@FindBy(xpath="//*[@alt='Training sessions list']")
	private WebElement TrainingSessionListImg; 
	
	@FindBy(xpath="//*[@name='name']")
	private WebElement categoryNameTextbox; 
	
	@FindBy(xpath="//*[@class='btn btn-success']")
	private WebElement addCategoryBtn; 
	
	@FindBy(xpath="//*[@alt='Add a training session']")
	private WebElement addTrainingSessionImg; 
	
	@FindBy(id="add_session_name")
	private WebElement sessionNameTextBox; 
	
	@FindBy(className="select2-selection__arrow")
	private WebElement coacheselectionArrow; 
	
	@FindBy(className="select2-search__field")
	private WebElement coachSearchbox; 
	
	
	@FindBy(xpath="//*[@id='coach_username']/..")
	private WebElement coachUserName; 
	
	@FindBy(id="advanced_params")
	private WebElement advancedSettingsbtn; 
	
	@FindBy(id="session_category")
	private WebElement sessionCategoryList; 
	
	@FindBy(xpath="//*[@id='add_session_submit']")
	private WebElement nextStepBtn; 
	
	@FindBy(xpath="//*[@name='NoSessionCoursesList[]']")
	private WebElement courseList;
	
	@FindBy(name="add_course")
	private WebElement arrowButton;
	
	@FindBy(xpath="//*[@class='btn btn-success']")
	private WebElement nextStepBtninaddCoursePage;
	
	@FindBy(xpath="//*[@name='formulaire']/legend")
	private WebElement subscribeUsertextMessage;
	
	@FindBy(id="user_to_add")
	private WebElement portalUserListTextBox; 
	
	@FindBy(xpath="//*[@id='ajax_list_users_single']/a[1]")
	private WebElement firstresultDisplayed;
	
	@FindBy(xpath="destination_users")
	private WebElement destinationUser;
	
	@FindBy(xpath="//*[@class='btn btn-success']")
	private WebElement FinishSessionCreationBtn;
	
	@FindBy(xpath="//*[@class='alert alert-info']")
	private WebElement updateMessage;
	
	@FindBy(xpath="session-user-list")
	private WebElement sessionUserList;
	
	@FindBy(xpath="//*[@class='alert alert-info']")
	private WebElement successMsg;
	
	
	
	public void clickRegistrationtab() {
		this.registrationTab.click();	
	}
	
	public void clickcancelicon() {
		this.cancelicon.click();	
	}
	
	
	
	public void clicksessionCatgoryLnk() {
		this.sessionCatgoryLnk.click();	
	}
	
	public void clickAddCatgoryImg() {
		this.AddCatgoryImg.click();	
	}
	
	
	public void clickTrainingSessionListImg() {
		this.TrainingSessionListImg.click();	
	}
	
	public void entercategoryNameTextbox(String entervalue) {
		this.categoryNameTextbox.sendKeys(entervalue);	
	}
	
	public void clickaddCategoryBtn() {
		this.addCategoryBtn.click();	
	}
	
	public void clickaddTrainingSessionImg() {
		this.addTrainingSessionImg.click();	
	}
	
	public void entersessionNameTextBox(String entervalue) {
		this.sessionNameTextBox.sendKeys(entervalue);	
	}
	
	public void entercoachUserName(String entervalue) throws InterruptedException {
		this.coacheselectionArrow.click();
		Thread.sleep(2000);
		this.coachSearchbox.sendKeys(entervalue);
		Thread.sleep(2000);
		coachSearchbox.sendKeys(Keys.ENTER);
		
	}
	
	public void clickadvancedSettingsbtn() {
		this.advancedSettingsbtn.click();	
	}
	
	public void selectsessionCategoryList(String valuetobeselected) {
		Select sel = new Select(sessionCategoryList);
		sel.selectByValue(valuetobeselected);
	}
	
	public void clicknextStepBtn() {
		this.nextStepBtn.click();	
	}
	
	public void selectcourseList(String valuetobeselected) {
		Select sel = new Select(courseList);
		sel.selectByValue(valuetobeselected);	
	}
	
	public void clickarrowButton() {
		this.arrowButton.click();	
	}
	
	public void clicknextStepBtninaddCoursePage() {
		this.nextStepBtninaddCoursePage.click();	
	}
	
	public void validatesubscribeUsertextMessage() {
		this.subscribeUsertextMessage.click();	
	}
	
	public void enterportalUserListTextBox(String entervalue) {
		this.portalUserListTextBox.sendKeys(entervalue);	
	}
	
	public void clickfirstresultDisplayed() {
		this.firstresultDisplayed.click();	
	}
	
	public void validatedestinationUser() {
		this.destinationUser.click();	
	}
	
	public void clickFinishSessionCreationBtn() {
		this.FinishSessionCreationBtn.click();	
	}
	
	public void validateupdateMessage() {
		this.updateMessage.click();	
	}
	
	public void validatesessionUserList() {
		this.sessionUserList.click();	
	}
	
	public String validatesuceessMSG() {
		String msgtext =this.successMsg.getText();
		return msgtext;
	}
	
		
}
