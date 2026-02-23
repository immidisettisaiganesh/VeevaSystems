package StartingWithTestNG.Dependencies;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
	@Test(priority = 1)
	public void openApp()
	{		
		Assert.assertTrue(true);
		System.out.println("opening app...");
	}
	
	@Test(priority = 2 , dependsOnMethods = {"openApp"})
	public void login()
	{
		System.out.println("Logging in");
		Assert.assertTrue(true);

	}
	
	@Test(priority = 3 , dependsOnMethods = {"login"})
	public void search()
	{
		System.out.println("Searching...");
		Assert.assertTrue(false);

	}
	
	@Test(priority = 4 , dependsOnMethods = {"login","search"})
	public void advSearch()
	{
		System.out.println("Advance search...");
		Assert.assertTrue(true);

	}
	
	@Test(priority = 5 , dependsOnMethods = {"login"})
	public void logout()
	{
		System.out.println("logging out...");
		Assert.assertTrue(true);

	}
}
