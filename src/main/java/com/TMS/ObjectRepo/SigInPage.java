package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigInPage {
	@FindBy(xpath = "//li[@class='sigi']")
	private WebElement signInLink;
	
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Password' and @id='password']")
	private WebElement userPassword;
	
	@FindBy(xpath = "//input[@value='SIGNIN']")
	private WebElement signInBtn;
	
	public SigInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getUserName() {
		return userName;
	}



	public void setUserName(WebElement userName) {
		this.userName = userName;
	}



	public WebElement getUserPassword() {
		return userPassword;
	}


	public void userSignin(String username, String password) throws InterruptedException {
		signInLink.click();
		userName.sendKeys(username);
		Thread.sleep(2000);
		userPassword.sendKeys(password);
		signInBtn.click();
	}
	
}
