package practice;

public class Student extends Person {
	
	public int rollNumber;
	
	public void initializaAll()
	{
		name = "Abc";
		age = 16;
		rollNumber = 9;
	}
	
	public void displayAll()
	{
		System.out.println(this.name);
		System.out.println(super.age);
		System.out.println(this.age);
	}

}
