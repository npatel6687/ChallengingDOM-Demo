package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DataValidation {
	
	@Test
	public  void verifyButtonClick() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neethu\\work\\chrome\\version78\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement buttonSet=driver.findElement(By.xpath("//div[@class='large-2 columns']"));
		WebElement button1 = buttonSet.findElement(By.xpath("//a[@class='button']"));
		WebElement button2 = buttonSet.findElement(By.xpath("//a[@class='button alert']"));
		WebElement button3 	= buttonSet.findElement(By.xpath("//a[@class='button success']"));
		System.out.println(button1.getText());
		System.out.println(button2.getText());
		System.out.println(button3.getText());
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		
		boolean answerDisplayed = table.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed();
		System.out.println("Answer displayed: "+answerDisplayed);
		
	}
	@Test
	public  void verify() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neethu\\work\\chrome\\version78\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		System.out.println(headingsCount);
		for(int i=0,count=1;i<headingsCount;i++,count++){
				System.out.println(count + ": "+actionTable.findElements(By.tagName("th")).get(i).getText());
		}
		int rowCount = actionTable.findElements(By.tagName("tr")).size();
		System.out.println(rowCount);
		//for(int i=1;i<rowCount;i++){
		//		System.out.println(i + ": "+actionTable.findElements(By.tagName("tr")).get(i).getText());
		//}
		for(int i=1;i<rowCount;i++){
			System.out.print("Row"+i+" ");
			WebElement rowElement = actionTable.findElements(By.tagName("tr")).get(i);
			for(int j=0;j<headingsCount;j++){
				System.out.print(rowElement.findElements(By.tagName("td")).get(j).getText());
				System.out.print(" ");
			}
			System.out.println("");
		}
		//verify the edit and delete link
		for(int i=1;i<rowCount;i++){
			System.out.print("Row"+i+" ");
			WebElement rowElement = actionTable.findElements(By.tagName("tr")).get(i);
			System.out.println(rowElement.findElements(By.tagName("td")).get(headingsCount-1).getText());
			rowElement.findElement(By.xpath("(//a[contains(@href,'edit')])")).click();
			System.out.println(driver.getCurrentUrl());
			rowElement.findElement(By.xpath("(//a[contains(@href,'delete')])")).click();
			System.out.println(driver.getCurrentUrl());
		
	}
	
	}

}
