package TestNG;

import org.testng.annotations.Test;


public class DP_getDataTest {

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void getData(String Mname, String price)
	{
		System.out.println(Mname+"-->"+price);
	}
	
	
}
