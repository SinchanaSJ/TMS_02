package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		String expdata = "RMG_TEST_PROJ_105";
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(ele);
		s.selectByVisibleText("Created");	
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Connection con=null;
		String actual=null;
		boolean flag=false;
		try {
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			 actual = result.getString(4);
			if(actual.equalsIgnoreCase(expdata)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("Project created");
		}
		else {
			System.out.println("Project not created");
		}
		}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}
	}

}
