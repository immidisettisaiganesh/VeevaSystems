package StartingWithTestNG;

import org.testng.annotations.Test;

public class SampleTestNG {
	
	@Test(priority = 1)								//default proprity is 0;
	public void openApp()
	{
		System.out.println("Opening application");
	}
	
	@Test(priority = 2)
	public void login()
	{
		System.out.println("Logging into app");
	}
	
	@Test(priority = 3)
	public void logout()
	{
		System.out.println("Logging out...");
	}
}
