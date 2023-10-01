package TestNG;

import org.testng.annotations.Test;

public class DPExcnTest {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	/*public void getData(String Tname, int price, String size, String colour)
	{
		System.out.println(Tname+"-->"+price+"-->"+size+"-->"+colour);
	}*/
	public void getData(String Mname, int price) {
		System.out.println(Mname+"-->"+price);
	}

}
