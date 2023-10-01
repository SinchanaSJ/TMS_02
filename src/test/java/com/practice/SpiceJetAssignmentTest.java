package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetAssignmentTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//JavascriptExecutor j=(JavascriptExecutor)driver;
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='svg-img']/*[name()='circle'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys("Delhi");
		driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='svg-img']/*[name()='path' and @d='M14 .941h-2V0h-1v.941H5V0H4v.941H2c-1.105 0-2 .843-2 1.883v11.294C0 15.158.895 16 2 16h12c1.105 0 2-.843 2-1.882V2.824c0-1.04-.895-1.883-2-1.883zm1 13.177c0 .52-.448.94-1 .94H2c-.552 0-1-.42-1-.94v-8.47h14v8.47zm0-9.412H1V2.824c0-.52.448-.941 1-.942h2v.942h1v-.942h6v.942h1v-.942h2c.552 0 1 .422 1 .942v1.882z'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[contains(.,'September')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@data-testid='undefined-calendar-day-4'])[1]")).click();
		driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='svg-img']/*[name()='path' and @d='M14 .941h-2V0h-1v.941H5V0H4v.941H2c-1.105 0-2 .843-2 1.883v11.294C0 15.158.895 16 2 16h12c1.105 0 2-.843 2-1.882V2.824c0-1.04-.895-1.883-2-1.883zm1 13.177c0 .52-.448.94-1 .94H2c-.552 0-1-.42-1-.94v-8.47h14v8.47zm0-9.412H1V2.824c0-.52.448-.941 1-.942h2v.942h1v-.942h6v.942h1v-.942h2c.552 0 1 .422 1 .942v1.882z'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(.,'October')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu']/div[.='3']")).click();
		driver.findElement(By.xpath("(//*[name()='svg' and @data-testid='svg-img']/*[name()='path' and @d='M10.93 0L6.017 5.637 1.034.124 0 1.326 6.055 8 12 1.16z'])[1]")).click();
		for(int i=0;i<5;i++) {
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[1]")).click();
		}
		//j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1habvwh r-19fu0aa r-1loqt21 r-1777fci r-1mi0q7o r-1yt7n81 r-m611by r-1otgn73']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();

	}

}
