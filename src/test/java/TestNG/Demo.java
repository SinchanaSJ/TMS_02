package TestNG;

import org.testng.annotations.Test;

import com.TMS.genericUtils.BaseClass;

public class Demo extends BaseClass{

	@Test(groups = "Regression")
	public void demo() {
		System.out.println("Demo");
	}
	
}
