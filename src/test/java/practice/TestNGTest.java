package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(priority = 1, invocationCount = 3)
	private void createContact()
	{
		System.out.println("Creating a new contact.");
//		Assert.assertTrue(false);
	}
	
	@Test(priority = 2, dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("Modifying the existing contact.");
	}
	
	@Test(priority = 3, dependsOnMethods = {"createContact","modifyContact"})
	public void deleteContact()
	{
		System.out.println("Deleting the existing contact.");
	}
	
}
