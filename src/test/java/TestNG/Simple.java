package TestNG;

import org.testng.annotations.Test;

import com.TMS.genericUtils.BaseClass;

public class Simple extends BaseClass{
	@Test(groups = {"Smoke","Regression"})
	public void simple() {
		System.out.println("Simple");
	}
	
}
