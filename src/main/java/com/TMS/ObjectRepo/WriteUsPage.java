package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.audits.model.IssueId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class WriteUsPage {
	String actWrite="Info successfully submited";
	WebdriverUtility libW=new WebdriverUtility();
	@FindBy(xpath = "//a[contains(.,' / Write Us ')]")
	private WebElement writeLink;
	
	@FindBy(xpath = "//select[@name='issue']")
	private WebElement issue;
	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement description;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='con-top animated wow fadeInUp animated animated']/h4")
	private WebElement sent;

	public WriteUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void writeUs(String des) {
		writeLink.click();
		issue.click();
		libW.selectDropDown("Booking Issues", issue);
		description.sendKeys(des);
		submit.click();
		String expWrite=sent.getText();
		if(actWrite.contains(expWrite)) {
			System.out.println("Issue has been Submitted");
		}
		else {
			System.out.println("Issue has not been Submitted");
		}
	}



	public WebElement getWriteLink() {
		return writeLink;
	}



	public WebElement getIssue() {
		return issue;
	}



	public WebElement getDescription() {
		return description;
	}



	public WebElement getSubmit() {
		return submit;
	}



	public WebElement getSent() {
		return sent;
	}
	
	
}
