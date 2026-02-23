package StartingWithTestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertions {
	
	//@Test
	public void hard()
	{
		System.out.println("testing....");
		System.out.println("testing...");
		
//		Assert.assertEquals(10, 20); fail
//		Assert.assertEquals("s", "A"); fail
//		Assert.assertTrue(true); pass
//		Assert.assertFalse(false); pass
		
		Assert.assertEquals(10, 20, "not equal");
		
		System.out.println("testing....");
		System.out.println("testing....");

	}
	
	@Test
	public void soft()
	{
		System.out.println("testing....");
		System.out.println("testing....");
		
		SoftAssert sa=new SoftAssert();		//SoftAssert
		sa.assertEquals(10, 1);
		
		System.out.println("testing....");
		System.out.println("testing....");
		
		sa.assertAll();          //mandatory otherwise asset is shown always pass
	}
}
