package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	@FindBy(xpath = "//a[.='Admin Login']")
	private WebElement adLogin;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement un;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement loginBtn;
	
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAdLogin() {
		return adLogin;
	}

	public WebElement getUn() {
		return un;
	}


	public WebElement getPwd() {
		return pwd;
	}



	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void adminLogin(String uname, String password) {
		adLogin.click();
		un.sendKeys(uname);
		pwd.sendKeys(password);
		loginBtn.click();
		
	}
}
