package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class studentRegistrationwithInvalidCredentials {
	private WebDriver driver; 
	
	public studentRegistrationwithInvalidCredentials(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'/main/auth/inscription')]")
	private WebElement signupBtn; 
	
	@FindBy(id="registration_firstname")
	private WebElement firstnameTxtbox;
	
	@FindBy(id="registration_lastname")
	private WebElement LastnameTxtbox; 
	
	@FindBy(id="registration_email")
	private WebElement emailTxtbox; 
	
	@FindBy(name="username")
	private WebElement usernameTxtbox; 
	
	@FindBy(id="pass1")
	private WebElement passwordTxtbox; 
	
	@FindBy(id="pass2")
	private WebElement confirmpasswordTxtbox;
	
	@FindBy(id="registration_phone")
	private WebElement phonenumberTextBox;
	
	
	
	@FindBy(id="registration_language")
	private WebElement languagedropdown;
	
	@FindBy(xpath="(//*[@class='register-profile'])[1]")
	private WebElement studentchkbox;
	
	@FindBy(xpath="(//*[@id='registration_submit'])")
	private WebElement registerBtn;
	
	@FindBy(xpath="//*[@class='alert alert-warning']")
	private WebElement alertMsg;
	
	
	
	
	
	public void clicksignupBtn() {
		this.signupBtn.click();
		}
	
	public void enterfirstname(String valuetobeenetered) {
		this.firstnameTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enterlastname(String valuetobeenetered) {
		this.LastnameTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enteremail(String valuetobeenetered) {
		this.emailTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enterusername(String valuetobeenetered) {
		this.usernameTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enterpassword(String valuetobeenetered) {
		this.passwordTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enterconfirmpassword(String valuetobeenetered) {
		this.confirmpasswordTxtbox.sendKeys(valuetobeenetered);
		}
	
	public void enterphonenumber(String valuetobeenetered) {
		this.phonenumberTextBox.sendKeys(valuetobeenetered);
		}
	
	public void selectlanguage(String optiontobeselected) {
		Select sel = new Select(languagedropdown);
		sel.selectByVisibleText(optiontobeselected);	
	}
	
	public void clickstudentchkbox() {
		this.studentchkbox.click();
		}
	
	public void clickregisterBtn() {
		this.registerBtn.click();
		}
	public String validateerrorMSg() {
		String alertmessage =this.alertMsg.getText();
		return alertmessage;
		}
	
}
