package practice;

import org.testng.annotations.Test;

public class TestDataProvider {
	
	@Test(dataProvider = "getData", dataProviderClass = MyDataProvider.class)
	public void testDP1(String rollNo, String firstName, String lastName)
	{
		System.out.println(rollNo + " " + firstName + " " + lastName);
	}
	
	@Test(dataProvider = "getData", dataProviderClass = MyDataProvider.class)
	public void testDP2(String rollNo, String firstName, String lastName)
	{
		System.out.println(rollNo + " " + firstName + " " + lastName);
	}

}
