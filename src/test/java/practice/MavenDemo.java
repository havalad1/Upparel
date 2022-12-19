package practice;

import org.testng.annotations.Test;

public class MavenDemo 
{
	@Test
	public void demo1()
	{
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		System.out.println("username : "+username);
		System.out.println("password : "+password);
	}	
}
