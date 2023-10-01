package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class BookPackagePage {

	String actualText="SUCCESS:Booked Successfully";
	WebdriverUtility libW=new WebdriverUtility();
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement succes;
	
	@FindBy(xpath = "//a[contains(.,'Tour Packages')]")
	private WebElement tour;
	
	@FindBy(xpath="//a[@href='package-details.php?pkgid=1']")
	private WebElement details;
	
	@FindBy(xpath = "//input[@name='fromdate']")
	private WebElement from;
	
	@FindBy(xpath = "//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='3']")
	private WebElement fromDate;
	
	@FindBy(xpath = "//input[@name='todate']")
	private WebElement to;
	
	@FindBy(xpath = "//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table/tbody/tr/td[@class=' ui-datepicker-week-end ']/a[.='10']")
	private WebElement toDate;
	
	@FindBy(xpath = "//input[@name='comment']")
	private WebElement com;
	
	@FindBy(xpath = "//button[.='Book']")
	private WebElement book;
	
	public BookPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getTour() {
		return tour;
	}

	public WebElement getDetails() {
		return details;
	}


	public WebElement getFrom() {
		return from;
	}


	public WebElement getFromDate() {
		return fromDate;
	}


	public WebElement getTo() {
		return to;
	}


	public WebElement getToDate() {
		return toDate;
	}


	public WebElement getCom() {
		return com;
	}


	public WebElement getBook() {
		return book;
	}


	public void bookPackage(WebDriver driver, String comment) throws InterruptedException {
		tour.click();
		details.click();
		from.click();
		fromDate.click();
		to.click();
		toDate.click();
		libW.mouseHoverOnElement(driver, com);
		Thread.sleep(3000);
		com.sendKeys(comment);
		book.click();
		String expText=succes.getText();
		if(actualText.contains(expText)) {
			System.out.println("Tour Package Booked Successfully");
		}
		else {
			System.out.println("Tour Package not Booked");
		}
	}
	
	
}
