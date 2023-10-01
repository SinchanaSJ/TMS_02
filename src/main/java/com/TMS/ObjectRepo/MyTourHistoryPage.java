package com.TMS.ObjectRepo;

import java.util.List;
import java.util.TreeSet;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TMS.genericUtils.WebdriverUtility;

public class MyTourHistoryPage {

	WebdriverUtility libW= new WebdriverUtility();
	
	String actualText="SUCCESS:Booked Successfully";
	String actCancel="SUCCESS:Booking Cancelled successfully";
	
	@FindBy(xpath = "//a[@href='tour-history.php']")
	private WebElement history;
	
	@FindBy(xpath = "//a[@href='manage-bookings.php']")
	private WebElement mb;
	
	public MyTourHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHistory() {
		return history;
	}
	public int tour(WebDriver driver) throws InterruptedException {
		history.click();
		List<WebElement> text = driver.findElements(By.xpath("//table//tr/td[1]"));
		TreeSet<String> set = new TreeSet<>();
		Thread.sleep(2000);
		for (WebElement text1 : text) {
			String num=text1.getText();
			set.add(num);
		}
		int lastNum = set.size();
		return lastNum;
	}
	
	public void tourH(WebDriver driver, int lastNum) throws InterruptedException {
		history.click();
		List<WebElement> text2 = driver.findElements(By.xpath("//table//tr/td[1]"));
		TreeSet<String> set1 = new TreeSet<>();
		Thread.sleep(2000);
		for (WebElement text12 : text2) {
			String num1=text12.getText();
			set1.add(num1);
		}
		int lastNum1 = set1.size();
		//System.out.println(lastNum1);
		if(lastNum1==lastNum+1) {
			System.out.println("Package Added");
		}
		else {
			System.out.println("Package not Added");
		}
		Thread.sleep(3000);
		WebElement cancel = driver.findElement(By.xpath("//table//tr/td[.='"+lastNum1+"']/..//a[contains(.,'Cancel')]"));
		Actions a= new Actions(driver);
		a.scrollByAmount(0, 3000).perform();
		cancel.click();
		libW.acceptAlertPopup(driver);
		//Alert al=driver.switchTo().alert();
		//al.accept();
		String expCancel = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(expCancel);
		if(actCancel.contains(expCancel)) {
			System.out.println("Package cancelled Successfully");
		}
		else {
			System.out.println("Package not cancelled");
		}
	
		
	}
	public void manageBook(WebDriver driver) throws InterruptedException {
		mb.click();
		String path = "//table//tr/td[@data-th='Action ']";
		List<WebElement> text3 = driver.findElements(By.xpath(path));
        int count = text3.size();
        System.out.println(count);
        Thread.sleep(3000);
        WebElement t = driver.findElement(By.xpath("("+path+")"+"["+count+"]"));
		libW.mouseHoverOnElement(driver, t);
       
		String m = t.getText();
		//System.out.println(m);
		String s="Cancelled";
		if(s.contains(m)) {
			System.out.println("User Cancelled the Package");
		}
		else {
			System.out.println("User not Cancelled the Package");
		}

	}
	
	public void confirmBookings(WebDriver driver) {
		history.click();
		String userBookingId="#BK25";
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+userBookingId+"']"));
		libW.mouseHoverOnElement(driver, ele);
		List<WebElement> allStatus = driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		boolean flag=false;
		for(int i=0;i<allStatus.size();i++)
		{
			if(i==allStatus.size()-1)
			{
				String value=allStatus.get(i).getText();
				System.out.println(value);
				if(value.contains("Confirmed"))
				{
					flag=true;
					break;
				}
			}
		}
		if(flag)
			System.out.println("The admin confirmed booking is updated");
		else
			System.out.println("The admin confirmed booking is not get updated");
		
	}
	
}
