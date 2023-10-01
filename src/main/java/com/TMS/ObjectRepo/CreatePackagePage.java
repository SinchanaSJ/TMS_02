package com.TMS.ObjectRepo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.TMS.genericUtils.WebdriverUtility;

public class CreatePackagePage {
	String actCreate = "SUCCESS:Package Created Successfully";
	WebdriverUtility libW=new WebdriverUtility();
	
	@FindBy(xpath = "//h1[@class='wow zoomIn animated animated animated']")
	private WebElement navText;
	
	@FindBy(xpath = "//a[contains(.,'Tour Packages')]")
	private WebElement tPkg;
	
	@FindBy(xpath = "//a//span[.=' Tour Packages']")
	private WebElement packageLink;
	
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement success;
	
	@FindBy(xpath = "//a[@href='create-package.php']")
	private WebElement createPackage;
	
	@FindBy(id = "packagename" )
	private WebElement pkgName;
	
	@FindBy(id="packagetype")
	private WebElement pkgType;
	
	@FindBy(id="packagelocation")
	private WebElement location;
	
	@FindBy(id="packageprice")
	private WebElement priceEd;
	
	@FindBy(id="packagefeatures")
	private WebElement feature;
	
	@FindBy(id="packagedetails")
	private WebElement details;
	
	@FindBy(id = "packageimage")
	private WebElement img;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement create;
	
	
	
	
	public WebElement getCreatePackage() {
		return createPackage;
	}
	public WebElement getPackageLink() {
		return packageLink;
	}
	public WebElement getPkgName() {
		return pkgName;
	}
	public WebElement getPkgType() {
		return pkgType;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getPriceEd() {
		return priceEd;
	}
	public WebElement getFeature() {
		return feature;
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getImg() {
		return img;
	}
	public WebElement getCreate() {
		return create;
	}
	
	public CreatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createPackage(WebDriver driver, String pkName, String pkType, String loc, String price, String feat, String det) throws InterruptedException
	{
		//Thread.sleep(2000);
		packageLink.click();
		//Thread.sleep(1000);
		createPackage.click();
		pkgName.sendKeys(pkName);
		pkgType.sendKeys(pkType);
		location.sendKeys(loc);
		priceEd.sendKeys(price);
		feature.sendKeys(feat);
		details.sendKeys(det);
		packageImgUpload();
		libW.mouseHoverOnElement(driver, create);
		//create.click();
		String ExpCreate=success.getText();
		if(actCreate.contains(ExpCreate)) {
			 System.out.println("Package Created Successfully");
		 }
		 else {
			 System.out.println("Package not Created");
		 }
		
	}
	public void packageImgUpload() {
		File f=new File(".\\src\\test\\resources\\nature-background-nawpic-11.jpg");
		String absPath = f.getAbsolutePath();
		img.sendKeys(absPath);
		
	}
	public void navigate(String actualText) throws InterruptedException {
		tPkg.click();
		Thread.sleep(3000);
		String expText=navText.getText();
		System.out.println(expText);
	/*if(actualText.contains(expText)) {
			System.out.println("Package List is displaying");
		}
		else {
			System.out.println("Package List is not displaying");
		}*/
		assertEquals(expText,actualText);
		
	}
}
