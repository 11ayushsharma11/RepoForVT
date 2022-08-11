package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void test1()
	{
		System.out.println("Login");
		System.out.println("click organizations on the homepage");
		System.out.println("Enter organization name");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(0, 0);
		sa.assertEquals(0, 1, "0 - 1 mismatch");
		sa.assertEquals(0, 2, "0 - 2 mismatch");
		System.out.println("Click save button");
		sa.assertAll();
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
