package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void softAssert() {
		String exp="Hello";
		String act="Hello";
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(exp, act);
		System.out.println("hi");
		sa.assertAll();
	}
}
