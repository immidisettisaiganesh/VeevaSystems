package testExamples.ExcelDataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//In automation frameworks:
//First try normal click
//Then explicit wait
//Then Actions
//Last option → JavaScriptExecutor
//Never directly jump to JS.

//https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator  --Assignment

public class FDCalculator {

    public static void main(String args[]) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        String filepath = System.getProperty("user.dir") + "\\testData\\testdataExel.xlsx";

        int rcount = ExcelUtils.getRowCount(filepath, "Sheet1");

        for (int i = 1; i <= rcount; i++) {

            String pAmount = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
            String interest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
            String period1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
            String period2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
            String freq = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
            String expValue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);

            driver.findElement(By.id("principal")).clear();
            driver.findElement(By.id("principal")).sendKeys(pAmount);

            driver.findElement(By.id("interest")).clear();
            driver.findElement(By.id("interest")).sendKeys(interest);

            driver.findElement(By.id("tenure")).clear();
            driver.findElement(By.id("tenure")).sendKeys(period1);

            Select s1 = new Select(driver.findElement(By.id("tenurePeriod")));
            s1.selectByVisibleText(period2);

            Select s2 = new Select(driver.findElement(By.id("frequency")));
            s2.selectByVisibleText(freq);

            WebElement cal = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cal);


            String result = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
            System.out.println(result+" "+expValue);
            
            double actual = Double.parseDouble(result.replace(",", ""));
            double expected = Double.parseDouble(expValue);

            if (actual == expected) 
            {
            	
            	System.out.print("	  TestPassed	");
                ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Pass");
                ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);
                
            } 
            else 
            {
            	System.out.print("  TestFailed	");
                ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Fail");
                ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);
                
            }

            WebElement clear = driver.findElement(By.xpath("//div[@class='cal_div']//a[2]//img"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clear);
        
        }

        driver.quit();
    }
}
