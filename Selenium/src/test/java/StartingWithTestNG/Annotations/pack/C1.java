package StartingWithTestNG.Annotations.pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	
	@BeforeTest
	public void bt()
	{
		System.out.println("before testing...");
	}
	@BeforeClass
	public void bc()
	{
		System.out.println("Before class...");
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("After testing...");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("After class...");
	}
	
	@Test
	public void check1()
	{
		System.out.println("checkingg...1");
	}
	
	@Test
	public void check2()
	{
		System.out.println("checkingg...2");
	}
	
}
