package StartingWithTestNG.Dependencies;

import org.testng.annotations.Test;

public class PaymentTests {
	
	@Test(priority = 1,groups = {"log","siup","functional"})	//multiple groups with "functional" as unique to execute 
	public void inRupees()
	{
		System.out.println("in rupees");
	}
	
	@Test(priority = 2,groups = {"log","siup","functional"})
	public void inDollars()
	{
		System.out.println("in dollars");
	}
}
