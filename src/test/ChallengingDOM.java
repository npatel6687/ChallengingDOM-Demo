package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChallengingDOM extends OpenBrowser{
	
	@BeforeTest
	public  void openBrowser() throws IOException {
		launchBrowser();
	}
	
	@Test(priority = 0)
	public  void verifyTitle() throws IOException {
		String expectedTitle = "The Internet";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title: "+actualTitle);
	}
	

	@Test(priority = 1)
	public  void verifyHeading() throws IOException {
		String expectedHeading = "Challenging DOM";
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		String actualHeading = table.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		System.out.println("Heading: "+actualHeading);
		//to check header text
		}
	
	@Test(priority = 2)
	public  void verifyDescription() throws IOException {
		String expectedDesc = "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element.";
		
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		String actualDesc = table.findElement(By.xpath("//div[@class='example']/p")).getText();
		Assert.assertEquals(actualDesc, expectedDesc);
		System.out.println("Description: "+actualDesc);
		}//to check para text
	
	@Test(priority = 3)
	public  void verifyButtonSet() {
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int expButtonCount=3;
		
		WebElement buttonSet=driver.findElement(By.xpath("//div[@class='large-2 columns']"));
		int actualButtonCount=buttonSet.findElements(By.xpath("(//a[contains(@class,'button')])")).size();
		
		Assert.assertEquals(actualButtonCount, expButtonCount);
		System.out.println("Number of buttons:"+actualButtonCount);
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		boolean answerDisplayed = table.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed();
		System.out.println("Before clicking on any button, Answer displayed: "+answerDisplayed);
		
	}
	@Test(priority = 4)
	public  void verifyBlueButtonClick() {
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement buttonSet=driver.findElement(By.xpath("//div[@class='large-2 columns']"));
		WebElement blueButton = buttonSet.findElement(By.xpath("//a[@class='button']"));
		blueButton.click();
		WebElement canvasElement = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		boolean answerDisplayed = canvasElement.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed();
		Assert.assertTrue(answerDisplayed);
		System.out.println("Answer displayed: "+answerDisplayed);
		
	}
	@Test(priority = 5)
public  void verifyRedButtonClick() {
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement buttonSet=driver.findElement(By.xpath("//div[@class='large-2 columns']"));
		WebElement redButton = buttonSet.findElement(By.xpath("//a[@class='button alert']"));
		redButton.click();
		WebElement canvasElement = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		boolean answerDisplayed = canvasElement.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed();
		Assert.assertTrue(answerDisplayed);
		System.out.println("Answer displayed: "+answerDisplayed);
}
	
	@Test(priority = 6)
	public  void verifyGreenButtonClick() {
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement buttonSet=driver.findElement(By.xpath("//div[@class='large-2 columns']"));
			WebElement greenButton = buttonSet.findElement(By.xpath("//a[@class='button success']"));
			greenButton.click();
			WebElement canvasElement = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
			boolean answerDisplayed = canvasElement.findElement(By.xpath("//canvas[@id='canvas']")).isDisplayed();
			Assert.assertTrue(answerDisplayed);
			System.out.println("Answer displayed: "+answerDisplayed);
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//String query = "return document.getElementsByTagName(\"script\").canvas;";    
			//String text=(String) js.executeScript(query);
			//System.out.println(text);
			
	}
	@Test
	public  void verifyTableHeadings() {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		System.out.println(headingsCount);
		List<String> expHeadings = Arrays.asList("Lorem", "Ipsum", "Dolor","Sit","Amet","Diceret","Action"); 
		for(int i=0,count=1;i<headingsCount;i++,count++){
				String actualHeading = actionTable.findElements(By.tagName("th")).get(i).getText();
				Assert.assertEquals(actualHeading, expHeadings.get(i));
				//System.out.println("expheading: "+expHeadings.get(i));
				System.out.println(count + ": "+actionTable.findElements(By.tagName("th")).get(i).getText());
				
		}
	}
	
	@Test
	public  void verifyRows() {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		int rowCount = actionTable.findElements(By.tagName("tr")).getSize();
		System.out.println(headingsCount);
		List<String> expRow1 = Arrays.asList("Iuvaret0", "Apeirian0	", "Adipisci0","Definiebas0","Consequuntur0","Phaedrum0"); 
		for(int i=0;i<headingsCount-1;i++){
				String actualHeading = actionTable.findElements(By.tagName("tr")).get(i).getText();
				Assert.assertEquals(actualHeading, expHeadings.get(i));
				//System.out.println("expheading: "+expHeadings.get(i));
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

@AfterSuite 
public void CloseBowser() {
	driver.close();
}
}
