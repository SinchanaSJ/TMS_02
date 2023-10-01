package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataFromPropertyTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		p.setProperty("username", "anuj@gmail.com");
		p.setProperty("password", "Test@123");
		p.setProperty("url", "http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		p.setProperty("Browser", "chrome");
		p.setProperty("adminId", "admin");
		p.setProperty("adminPwd", "Test@123");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		p.store(fout,"write data");
		fout.close();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		p.load(fis);
		String BROWSER = p.getProperty("Browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
		
		
		System.out.println("Browser--> "+BROWSER);
		System.out.println("Url --> "+URL);
		System.out.println("User Name --> "+UN);
		System.out.println("Password --> "+PWD);
		
	}

}
