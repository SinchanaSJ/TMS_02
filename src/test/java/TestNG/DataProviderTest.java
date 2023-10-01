package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.TMS.genericUtils.IPathConstants;

public class DataProviderTest {

	@DataProvider
	public Object[][] mobiles(){
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Samsung";
		obj[0][1]=15000;
		
		obj[1][0]="Redmi";
		obj[1][1]=10000;
		
		return obj;
	}
	@DataProvider
	public Object[][] tv(){
		Object[][] obj=new Object[3][4];
		
		obj[0][0]="LG";
		obj[0][1]=50000;
		obj[0][2]="45 inch";
		obj[0][3]="Black";
		
		obj[1][0]="Samsung";
		obj[1][1]=55000;
		obj[1][2]="50 inch";
		obj[1][3]="Silver";
		
		obj[2][0]="Sony";
		obj[2][1]=65000;
		obj[2][2]="55 inch";
		obj[2][3]="Red";
		
		return obj;
	}
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable{
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow+1][lastCell];
		
		for(int i=0;i<=lastRow;i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
	}
	
}
