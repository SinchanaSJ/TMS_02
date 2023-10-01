package com.TMS.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	@FindBy(xpath = "//a[contains(.,'Sign Up')]")
	private WebElement signUp;
	
	@FindBy(xpath = "//input[@name='fname']")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@name='mobilenumber']")
	private WebElement mob;
	
	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement email;
	
	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='CREATE ACCOUNT']")
	private WebElement create;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignUp() {
		return signUp;
	}


	public WebElement getFname() {
		return fname;
	}


	public WebElement getMob() {
		return mob;
	}


	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCreate() {
		return create;
	}

	public void signUp(HashMap<String, String> map, WebDriver driver, String emailId, String actAcc)
	{
		signUp.click();
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		email.sendKeys(emailId);
		create.click();
		
		String expAcc = driver.findElement(By.xpath("//div[@class='con-top animated wow fadeInUp animated animated']/h4")).getText();
		if(actAcc.contains(expAcc)) {
			System.out.println("Issue has been Submitted");
		}
		else {
			System.out.println("Issue has not been Submitted");
		}
		
	}
	
}
