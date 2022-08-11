package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToRetry {
	
	@Test(retryAnalyzer = comcast.vTiger.genericUtility.Retry.class)
	public void test1()
	{
		System.out.println("running test1");
		Assert.assertEquals('a', 'b');
	}

}
