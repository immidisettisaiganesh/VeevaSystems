package StartingWithTestNG.Annotations;

import org.testng.annotations.*;

public class AllAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@Test(priority = 1)
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(priority = 2)
	public void test2() {
		System.out.println("Test 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
	}
}
