package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int result=0;
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into project values('API','Sachin','Banglore',1),('Manual','Ashish','Banglore',1)";
		result=state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally {
			if(result==2)//adding to 2 data 
			{
				System.out.println("Data is created");
			}
			else {
				System.out.println("Data is not present");
			}
			con.close();
		}
		
	}
}
