package practice;

import org.testng.annotations.DataProvider;

public class MyDataProvider {
	
	@DataProvider
	public synchronized static Object[][] getData()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0] = "1";
		obj[0][1] = "Ram";
		obj[0][2] = "Kumar";
		
		obj[1][0] = "2";
		obj[1][1] = "Shyam";
		obj[1][2] = "Singh";
		
		obj[2][0] = "3";
		obj[2][1] = "Aam";
		obj[2][2] = "Sod";
		
		return obj;
	}
	
}
