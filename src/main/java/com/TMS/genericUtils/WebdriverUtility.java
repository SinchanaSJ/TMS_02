
package com.TMS.genericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Admin
 *
 */
public class WebdriverUtility {

//	static {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * method will wait until element in the page gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until the url gets loaded
	 * @param driver
	 * @param duration
	 */
	public void explicitWait(WebDriver driver, int duration, String expectedUrl) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	
	/**
	 * This method will wait until the title gets loaded
	 * @param driver
	 * @param duration
	 */
	public void waitUntilTitleLoad(WebDriver driver, int duration, String expectedTitle) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	

	/**
	 *  This method will wait until the element of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore the NoSuchElementException and continues execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element to be visible in page
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void customWait(WebElement element) throws InterruptedException {
		int count=0;
		while(count <20) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * Select the drop down based on the index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * Select the drop down based on the value
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByValue(value);
	}
	/**
	 * Select the drop down based on the text
	 * @param element
	 * @param index
	 */
	public void selectDropDown(String text, WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * Used to mouse hover on the element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element ) {
		Actions a= new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	/**used to right click on the element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element ) {
		Actions a= new Actions(driver);
		a.contextClick(element).perform();
	}
	/**used to right click on the enter key
	 * 
	 * @param driver
	 * @param element
	 */
	/*public void clickOnEnterKey(WebDriver driver, WebElement element ) {
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}*/
	/**
	 * Used to switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * Used to switch from one frame to another using id
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * Used to switch from one frame to another using webElement
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * Used to switch from one frame to main frame
	 * @param driver
	 * @param index
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * used to accept alert popup
	 * @param driver
	 * @param expMsg
	 */
	public void acceptAlertPopup(WebDriver driver) {
	Alert alt=driver.switchTo().alert();
//		if(alt.getText().equalsIgnoreCase(expMsg)) {
//			System.out.println("Alert msg is verified");
//		}
//		else {
//			System.out.println("Alert msg is not verified");
//		}
		alt.accept();
	}
	/**
	 * used to dismiss alert popup
	 * @param driver
	 * @param expMsg
	 */
	public void dismissAlertPopup(WebDriver driver, String expMsg) {
		Alert alt=driver.switchTo().alert();
	/*	if(alt.getText().equalsIgnoreCase(expMsg)) {
			System.out.println("Alert msg is verified");
		}
		else {
			System.out.println("Alert msg is not verified");
		}*/
		alt.dismiss();
	}
	/**
	 * used to switch one window to another using title
	 * @param driver
	 * @param expTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver, String expTitle) {
		Set<String> set = driver.getWindowHandles();
		for(String string: set) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if(title.contains(expTitle)) {
				break;
			}
		}
	}
	/**
	 * used to switch one window to another using url
	 * @param driver
	 * @param expTitle
	 */
	public void switchWindowBasedOnUrl(WebDriver driver, String expUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String url=driver.getCurrentUrl();
			if(url.contains(expUrl)) {
				break;
			}
		}
	}
	/**
	 * Used to take screen shot of the page
	 * @param driver
	 * @param screenShotName
	 * @return
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./screenShots/"+screenShotName+".png");
		 try {
			 FileUtils.copyFile(src, dest);
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
		 return screenShotName;
	}
	/**
	 * Used to scroll to a particular element
	 */
	public void moveToParticularElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", element);
	}
	public void enterKey(WebDriver driver) throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * To perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")","");
	}
	/**
	 * To perform scroll to particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element ) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	public void scrollUsingActionsClass(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
}
