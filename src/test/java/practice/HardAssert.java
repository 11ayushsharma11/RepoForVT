package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void test1()
	{
		System.out.println("Login");
		System.out.println("click organizations on the homepage");
		System.out.println("Enter organization name");
		Assert.assertEquals("A", "B");
		System.out.println("Click save button");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Login");
		System.out.println("click organizations on the homepage");
		System.out.println("Enter organization name");
		System.out.println("Click save button");
	}

}
