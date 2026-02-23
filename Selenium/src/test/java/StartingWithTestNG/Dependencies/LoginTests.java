package StartingWithTestNG.Dependencies;

import java.beans.Transient;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(priority = 1 ,groups = {"log"})	//groups names are user defined to sun set of tests
	public void loginByEmail()
	{
		System.out.println("login by email");
	}
	
	@Test(priority = 2,groups = {"log"})
	public void loginByFb()
	{
		System.out.println("login by fb");
	}
	@Test(priority = 3,groups = {"log"})
	public void loginByGoogle()
	{
		System.out.println("login by google");
	}
	
	@Test(priority = 4,groups = {"log"})
	public void loginByTwitter()
	{
		System.out.println("login by twitter");
	}
}
