package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class courseCategories {
	private WebDriver driver; 
	
	public courseCategories(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'course_category')]")
	private WebElement coursecategory;
	
	@FindBy(xpath="	//a[contains(@href,'/admin/course_category.php')]/img[@alt='Add category']")
	private WebElement Addcategoryimg; 


	@FindBy(id="course_category_code")
	private WebElement categoryCode; 
	
	@FindBy(id="course_category_name")
	private WebElement categoryName;
	
	@FindBy(xpath="//*[@value='TRUE']")
	private WebElement CourseCategoryYES; 
	
	@FindBy(id="course_category_submit")
	private WebElement addCategoryBtn;
	
	@FindBy(xpath="//table[@class='data_table']")
	private WebElement listofAvailableCategory;
	

	
	
	public void clickCourseCategory() {
		this.coursecategory.click();				
	}
	
	public void clickAddCategory() {
		this.Addcategoryimg.click();				
	}
	
	public void enterCategoryName(String entervalue) {
		this.categoryName.sendKeys(entervalue);				
	}
	
	public void enterCategoryCode(String entervalue) {
		this.categoryCode.sendKeys(entervalue);				
	}
	
	public void ClickCourseCategoryYES() {
		this.CourseCategoryYES.click();		
	}
	
	public void ClickaddCategoryBtn() {
		this.addCategoryBtn.click();	
	}
	
	
	public Boolean validateavailablecategory(String enteredname) {
		Boolean validateCategory =this.listofAvailableCategory.getText().contains(enteredname);
		return validateCategory;	 
	}
	
	
	

	
		

}
