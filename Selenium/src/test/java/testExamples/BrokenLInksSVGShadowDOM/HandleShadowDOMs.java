package testExamples.BrokenLInksSVGShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadowDOMs {
	public static void main(String args[]) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		// ====> ONLY CSS SELECTOR CAN HANDLEE THE SHADOWDOM <====
		
		// Single Shadow dom
		SearchContext con1=driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		String ans=con1.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(ans);
		
		//Nested ShadowDOMs
		//This Element is inside 2 nested shadow DOM.
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		System.out.println(shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText());
		
		//MultiNested ShadowDOMs
		//This Element is inside 3 nested shadow DOM.
		SearchContext shadow0_3 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		SearchContext shadow1_3 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		SearchContext shadow2_3 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		System.out.println(shadow2_3.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());;
	}
}
