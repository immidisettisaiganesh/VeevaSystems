package testExamples.MouseActionsHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {
	
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://vinothqaacademy.com/mouse-event/");
		
		WebElement element1=driver.findElement(By.xpath("//div[@id=\"draggableElement\"]")); 
		WebElement element2=driver.findElement(By.xpath("//div[@id='droppableElement']"));
		
		Actions act=new Actions(driver);                        // Actions - class - have all the mouse actions to perform 
																//Action  - Interface - holds the CreadA 	ction to perform - Action a = Actions.build()
		act.dragAndDrop(element1, element2).build().perform();
	}
	
}
