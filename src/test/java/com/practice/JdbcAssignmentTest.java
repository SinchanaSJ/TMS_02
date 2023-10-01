package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JdbcAssignmentTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name to be added");
		String name=sc.nextLine();
		Connection con=null;
		Driver driver=new Driver();
		try {
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata","root","root");
			Statement state = con.createStatement();
			String query = "select * from tyss";
			ResultSet result = state.executeQuery(query);
			boolean b=false;
			Random ran=new Random();
			int id = ran.nextInt(500);
			while(result.next()) {
				String text=result.getString(2);
				if(name.equalsIgnoreCase(text)){
					b=true;
				}
			}
			if(!b) {
				String inQuery="insert into tyss values('"+id+"','"+name+"');";
				int res=state.executeUpdate(inQuery);
				System.out.println(name+" has been inserted into table");
			}
			else {
				System.out.println("Name already exist");
			}
		}
		catch(Exception e) {
		}
		finally {
			con.close();
		}
	}
}