package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		Driver driver = new Driver();
		try {
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata", "root", "root");
		Statement state = con.createStatement();
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" ");
		}
	}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}
	}
}
