package StartingWithTestNG.Annotations.pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class C3 {
	
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("Before suite...");
	}
	
	@AfterSuite
	public void as()
	{
		System.out.println("After suite....");
	}
}
