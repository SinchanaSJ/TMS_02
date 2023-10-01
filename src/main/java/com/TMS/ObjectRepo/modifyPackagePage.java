package com.TMS.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class modifyPackagePage {
	
	String actUpdate="SUCCESS:Package Updated Successfully";
	WebdriverUtility libW=new WebdriverUtility();

	@FindBy(xpath = "//a//span[.=' Tour Packages']")
	private WebElement pkgLink;
	
	@FindBy(xpath = "//a[@href='manage-packages.php']")
	private WebElement modPkg;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-block'])[1]")
	private WebElement det;
	
	@FindBy(id = "packagedetails")
	private WebElement details;
	
	@FindBy(xpath = "//button[.='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement confirm;

	public modifyPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPkgLink() {
		return pkgLink;
	}


	public WebElement getModPkg() {
		return modPkg;
	}


	public WebElement getDet() {
		return det;
	}


	public WebElement getUpdateBtn() {
		return updateBtn;
	}


	public WebElement getConfirm() {
		return confirm;
	}


	public void modifyPkg(WebDriver driver, String detail) {
		pkgLink.click();
		modPkg.click();
		libW.mouseHoverOnElement(driver, det);
		details.clear();
		details.sendKeys(detail);
		libW.mouseHoverOnElement(driver, updateBtn);
		String ExpUpdate=confirm.getText();
		if(ExpUpdate.contains(actUpdate)) {
			System.out.println("Package Updated Successfully");
		}
		else {
			System.out.println("Package not Updated");
		}
	}

}
