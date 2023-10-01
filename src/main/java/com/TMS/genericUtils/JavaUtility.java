package com.TMS.genericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Admin
 *
 */
public class JavaUtility {
	/**
	 * Method is used to generate random numbers
	 * @return
	 */
	public int getRandomNumber(){
		Random ran = new Random();
		int randNum=ran.nextInt(1000);
		return randNum;
	}
	/**
	 * To fetch system date in IST format
	 * @return
	 */
	public String getSystemDate() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * to fetch date in the required format
	 * @return
	 */
	public String dateFormat() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date = new Date();
		String systemDateInFormat=dateformat.format(date);
		return systemDateInFormat;
	}
}
