package com.TMS.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class EnquiryPage {

	@FindBys({@FindBy(name="fname"),@FindBy(id="fname")})
	private WebElement fname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="mobileno")
	private WebElement mob;
	
	@FindBy(id="subject")
	private WebElement subject;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(xpath = "//button[@name='submit1']")
	private WebElement submit;

	public EnquiryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getFname() {
		return fname;
	}



	public WebElement getEmail() {
		return email;
	}



	public WebElement getMob() {
		return mob;
	}



	public WebElement getSubject() {
		return subject;
	}



	public WebElement getDescription() {
		return description;
	}



	public WebElement getSubmit() {
		return submit;
	}

	


	public void writeEnquiry(HashMap<String, String> map, WebDriver driver, String actualText) throws InterruptedException {
		for(Entry<String, String> s:map.entrySet()) {
			driver.findElement(By.id(s.getKey())).sendKeys(s.getValue());
		}
		
		submit.click();
		//driver.findElement(By.xpath("//button[@name='submit1']")).click();
		Thread.sleep(5000);
		String expText=driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		/*if(expText.contains(actualText)) {
			System.out.println("Enquiry Submitted");
		}
		else {
			System.out.println("Enquiry not Submitted");
		}*/
		assertEquals(actualText, expText);
	}
	
	
}
