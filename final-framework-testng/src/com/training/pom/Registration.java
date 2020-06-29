package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	private WebDriver driver; 
	
	public Registration(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(@href,'main/admin/')])[1]")
	private WebElement registrationTab; 
	
	@FindBy(xpath="//a[contains(@href,'course_add')]")
	private WebElement createCourseLnk;
	
	@FindBy(id="update_course_title")
	private WebElement courseTitleTxtbox; 
	
	@FindBy(id="visual_code")
	private WebElement courseCodeTxtbox; 
	
	@FindBy(xpath="//select[@id='update_course_category_code']")
	private WebElement categorySelection; 
	
	
	  @FindBy(xpath="//select[@id='course_teachers']")
	  private WebElement teacher;
	  
	  @FindBy(xpath="(//*[@class='select2-selection select2-selection--multiple'])[1]")
	  private WebElement enterteacher;
	  
	  @FindBy(xpath="//select[@name='course_language']")
	  private WebElement courselanguauge ;
	  
	  @FindBy(xpath="//button[@id='update_course_submit']")
	  private WebElement createCourseBtn ;
	  
	  @FindBy(xpath="//div[@class='alert alert-success']")
	  private WebElement alertaddedMessage;
	  
	  @FindBy(id="course-search-keyword")
	  private WebElement searchtextbox ;
	  
	  @FindBy(id="search_simple_submit")
	  private WebElement searchBtn ;
	  
	  @FindBy(id="course-list")
	  private WebElement courseList ;
	  
	  
	  
	  public void entersearchitem(String valuetobeselected) {
			this.searchtextbox.sendKeys(valuetobeselected);		
		}
	
	  public void clickSearchBtn() {
			this.searchBtn.click();		
		}
	  
		public Boolean validatecourseList(String enteredname) {
			Boolean validateCorselist =this.courseList.getText().contains(enteredname);
			return validateCorselist;	 
		}
	  
	
	  
	  
	  public void enterteacher(String valuetobeselected) {
			this.enterteacher.sendKeys(valuetobeselected);			
		}
	  
	  public void clickenterteacher() {
			this.enterteacher.sendKeys(Keys.ENTER);			
		}
	 
	  
	 public void selectteacher(String valuetobeselected) {
			Select sel = new Select(teacher);
			sel.selectByValue(valuetobeselected);			
		}
	 
	
	 
	public void selectcategory(String valuetobeselected) {
		Select sel = new Select(categorySelection);
		sel.selectByValue(valuetobeselected);
				
	}
	
	public void selectlanguage(String valuetobeselected) {
		Select sel = new Select(courselanguauge);
		sel.selectByValue(valuetobeselected);
				
	
	}
	
	
	public void clickRegistrationTab() {
		this.registrationTab.click();
				
	}
	
	public void clickcreateCourselnk() {
		this.createCourseLnk.click();
				
	}
	
	public void enterCourseCode(String courseCodeTxtbox) {
		this.courseCodeTxtbox.sendKeys(courseCodeTxtbox);			
	}
	
	public void enterTitle(String courseTitleTxtbox) {
		this.courseTitleTxtbox.sendKeys(courseTitleTxtbox);			
	}
	
	public void clickcreatecoursebtn() {
		this.createCourseBtn.click();
	}
	
	
	
	public String alertSuccessMessage() {
		String actualresultalertmessage = this.alertaddedMessage.getText();
		return actualresultalertmessage;
					
	}

}
