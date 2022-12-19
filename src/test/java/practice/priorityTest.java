package practice;

import org.testng.annotations.Test;

public class priorityTest 
{
	@Test(priority = 2)
	public void test1()
	{
		System.out.println("this is test1");
	}
	
	@Test(priority = 1)
	public void test2()
	{
		System.out.println("this is test2");
	}

	@Test(priority = -10 )
	public void test3()
	{
		System.out.println("this is test3");
	}
	
	@Test(priority = -3,dependsOnMethods = "test1")
	public void test4()
	{
		System.out.println("this is test4");
	}
}
