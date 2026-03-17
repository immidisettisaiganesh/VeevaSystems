package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMehods {
		
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@Test
	public void test_1() {
		System.out.println("Test Case 1 impl");
	}
	
	@Test
	public void test_2() {
		System.out.println("Test case 2 impl");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
}
