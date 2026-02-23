package StartingWithTestNG.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/* 
 * 1)login ---before tests begin--only once
 * 2)logout--After tests end ---only once
 * 3)search --test1
 * 4)advsearch--test2
 * */
public class DemoAnnotations2 {
	
	@BeforeClass
	 public void login()
	 {
		 System.out.println("login into system");
	 }
	 
	@AfterClass
	 public void logout()
	 {
		 System.out.println("logging out from system");
	 }
	 
	@Test(priority = 1)
	 public void search()
	 {
		 System.out.println("searching....");
	 }
	 
	@Test(priority = 2)
	 public void advSearch()
	 {
		 System.out.println("advsearching...");
	 }
}
