package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class ConfirmBookingPage {
	String actManage="SUCCESS:Booking Confirm successfully";
	WebdriverUtility libW=new WebdriverUtility();
	
	@FindBy(xpath = "//a[@href='manage-bookings.php']")
	private WebElement manageBook;
	
	@FindBy(xpath = "//td[@data-th='Action ']/span[text()!='Cancelled']/../preceding-sibling::td[@data-th='Status ']/span[text()='Pending']/../following-sibling::td[@data-th='Action ']/span/a[.='Confirm']")
	private WebElement confirmBook;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement confirm;

	public ConfirmBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void confirmBooking(WebDriver driver) {
		manageBook.click();
		libW.mouseHoverOnElement(driver, confirmBook);
		libW.acceptAlertPopup(driver);
		String expManage=confirm.getText();
		
		if(expManage.contains(actManage)) {
			System.out.println("Booking Confirmed");
		}
		else {
			System.out.println("Booking not Confirmed");
		}
		
	}

	public String getActManage() {
		return actManage;
	}

	public WebdriverUtility getLibW() {
		return libW;
	}

	public WebElement getManageBook() {
		return manageBook;
	}

	public WebElement getConfirmBook() {
		return confirmBook;
	}

	public WebElement getConfirm() {
		return confirm;
	}
	
	
}
