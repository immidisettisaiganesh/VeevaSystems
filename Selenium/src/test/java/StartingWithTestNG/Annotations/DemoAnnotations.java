package StartingWithTestNG.Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/* 
 * 1)login ---before every test begin
 * 2)logout--After every test end
 * 3)search --test1
 * 4)advsearch--test2
 * */
public class DemoAnnotations {
	
	@BeforeMethod
	 public void login()
	 {
		 System.out.println("login into system");
	 }
	 
	@AfterMethod
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
