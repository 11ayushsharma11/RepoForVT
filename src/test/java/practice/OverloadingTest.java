package practice;

public class OverloadingTest {
	
	public static void main(String[] args) {
		
		test(200);
		
	}
	
	private static void test(int i)
	{
		System.out.println(i);
	}
	
	private static void test(Integer i)
	{
		System.out.println(i);
	}
	
	private static void test(String i)
	{
		System.out.println(i);
	}
	
	private static void test(Object i)
	{
		System.out.println(i);
	}
	
}
