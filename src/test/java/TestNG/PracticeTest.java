package TestNG;

import org.testng.annotations.Test;

public class PracticeTest {

	@Test(invocationCount = -1)
	public void createTest() {
		int [] a= {10,20,30};
		//System.out.println(a[5]);
		System.out.println("--Data Created--");
	}
	@Test(dependsOnMethods="createTest")
	public void editTest() {
		System.out.println("--Data Edited--");
	}
	@Test(priority=2, invocationCount = 2)
	public void deleteTest() {
		System.out.println("--Data deleted--");
	}
}
