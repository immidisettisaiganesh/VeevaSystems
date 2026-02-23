package StartingWithTestNG.Dependencies;

import org.testng.annotations.Test;

public class SighupTests {

	@Test(priority = 1,groups = {"siup"})
	public void byEmail()
	{
		System.out.println("sup by email");
	}
	
	@Test(priority = 2,groups = {"siup"})
	public void byFb()
	{
		System.out.println("sup by fb");
	}
	@Test(priority = 3,groups = {"siup"})
	public void byGoogle()
	{
		System.out.println("sup by google");
	}
	
	@Test(priority = 4,groups = {"siup"})
	public void byTwitter()
	{
		System.out.println("sup by twitter");
	}
	
}
