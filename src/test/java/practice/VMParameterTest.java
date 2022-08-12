package practice;

import org.testng.annotations.Test;

public class VMParameterTest {
	
	@Test
	public void VMParameterTest()
	{
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
		System.out.println(System.getProperty("name"));
	}

}
