package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class WelcomePage {
	WebdriverUtility libW= new WebdriverUtility();
	
	@FindBy(xpath = "//a[.='Admin Login']")
	private WebElement adminLogin;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement home;
	
	@FindBy(xpath = "//a[.='About']")
	private WebElement about;
	
	@FindBy(xpath = "//a[.='Tour Packages']")
	private WebElement tourPack;
	
	@FindBy(xpath = "(//a[.='Privacy Policy'])[1]")
	private WebElement privPolicy;
	
	@FindBy(xpath = "//a[.='Terms of Use']")
	private WebElement terms;
	
	@FindBy(xpath = "//a[.='Contact Us']")
	private WebElement contact;
	
	@FindBy(xpath = "//a[contains(.,' Enquiry ')]")
	private WebElement enquiry;
	
	@FindBy(xpath = "//li[@class='sig']")
	private WebElement signUp;

	@FindBy(xpath = "//li[@class='sigi']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement toggle;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu drp-mnu']/li[2]/a")
	private WebElement drop;
	
	@FindBy(xpath = "//div[@class='back']")
	private WebElement back;
	
	@FindBy(xpath = "//a[contains(.,'/ Logout')]")
	private WebElement signOut;

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void homeMenu() {
		adminLogin.click();
		home.click();
		about.click();
		tourPack.click();
		privPolicy.click();
		terms.click();
		contact.click();
		enquiry.click();
		signIn.click();
		signUp.click();
	}
	
	public void adminLogOut(WebDriver driver) {
		libW.scrollUsingActionsClass(driver, toggle);
		libW.mouseHoverOnElement(driver, toggle);
		drop.click();
		back.click();
	}
	
	public void userLogOut(WebDriver driver) {
		libW.mouseHoverOnElement(driver, signOut);
	}


	
}
