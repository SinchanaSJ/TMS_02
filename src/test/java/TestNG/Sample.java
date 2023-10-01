package TestNG;

import org.testng.annotations.Test;

import com.TMS.genericUtils.BaseClass;

public class Sample extends BaseClass{

	@Test(groups = "Smoke")
	public void sample() {
		System.out.println("Sample");
	}
	
}
