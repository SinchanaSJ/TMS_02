package com.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD = p.getProperty("password");
		
		System.out.println("Browser--> "+BROWSER);
		System.out.println("Url --> "+URL);
		System.out.println("User Name --> "+UN);
		System.out.println("Password --> "+PWD);
		
	}
}
