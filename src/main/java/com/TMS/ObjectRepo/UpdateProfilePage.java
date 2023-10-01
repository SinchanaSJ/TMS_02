package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {

	String actProfile="SUCCESS:Profile Updated Successfully";
	@FindBy(xpath = "//a[@href='profile.php']")
	private WebElement profile;
	
	@FindBy(xpath = "//input[@name='mobileno']")
	private WebElement mob;
	
	@FindBy(xpath = "//button[.='Updtae']")
	private WebElement update;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement success;
	
	public UpdateProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getMob() {
		return mob;
	}

	public WebElement getUpdate() {
		return update;
	}

	public WebElement getSuccess() {
		return success;
	}
	
	public void update(String mobile) {
		profile.click();
		mob.clear();
		mob.sendKeys(mobile);
		update.click();
		String expProfile=success.getText();
		
		if(actProfile.contains(expProfile)) {
			System.out.println("Profile updated Successfully");
		}
		else {
			System.out.println("Profile not updated");
		}

	}
	
}
