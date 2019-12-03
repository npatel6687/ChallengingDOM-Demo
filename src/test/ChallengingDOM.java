package test;

import java.io.IOException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChallengingDOM extends OpenBrowser{
	
	@BeforeTest
	public  void openBrowser() throws IOException {
		launchBrowser();
	}
	
	@Test(priority = 0)
	public  void verifyTitle() throws IOException {
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title: "+actualTitle);
	}
	

	@Test(priority = 1)
	public  void verifyHeading() throws IOException {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		String actualHeading = table.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals(actualHeading, expectedHeading);
		System.out.println("Heading: "+actualHeading);
		//to check header text
		}
	
	@Test(priority = 2)
	public  void verifyDescription() throws IOException {
		
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
	}
	@Test(priority = 7)
	public  void verifyTableHeadings() {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		System.out.println(headingsCount);
		List<String> expHeadings = Arrays.asList("Lorem", "Ipsum", "Dolor","Sit","Amet","Diceret","Action"); 
		for(int i=0;i<headingsCount;i++){
				String actualHeading = actionTable.findElements(By.tagName("th")).get(i).getText();
				Assert.assertEquals(actualHeading, expHeadings.get(i));
				//System.out.println("expheading: "+expHeadings.get(i));
				//System.out.println(count + ": "+actionTable.findElements(By.tagName("th")).get(i).getText());
				
		}
	}
	
	@Test(priority = 8)
	public  void validateRowData() {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		int rowCount = actionTable.findElements(By.tagName("tr")).size();
		//System.out.println("Number of rows:"+rowCount);
		//System.out.println("Number of headings:"+headingsCount);
		List<String> expRow1 = Arrays.asList("Iuvaret","Apeirian","Adipisci","Definiebas","Consequuntur","Phaedrum"); 
		
		for(int i=1;i<rowCount;i++){
			WebElement fullRow = actionTable.findElements(By.tagName("tr")).get(i);
			for(int j=0;j<headingsCount-1;j++){
				int index=i-1;
				String actualRowElement = fullRow.findElements(By.tagName("td")).get(j).getText();
				String expRowElement = expRow1.get(j)+index;
				//System.out.println("actualRowElement:"+actualRowElement +" expRowElement:"+expRowElement);
				Assert.assertEquals(actualRowElement,expRowElement);
			}
		}
		
	}
	@Test(priority = 9)	
	public void verifyEditDeleteLink() {
		WebElement table = driver.findElement(By.cssSelector("div[class='large-10 columns']"));
		WebElement actionTable = table.findElement(By.tagName("table"));
		int headingsCount = actionTable.findElements(By.tagName("th")).size();
		int rowCount = actionTable.findElements(By.tagName("tr")).size();
		
		//verify the edit and delete link
		for(int i=1;i<rowCount;i++){
			WebElement rowElement = actionTable.findElements(By.tagName("tr")).get(i);
			System.out.println(rowElement.findElements(By.tagName("td")).get(headingsCount-1).getText());
			rowElement.findElement(By.xpath("(//a[contains(@href,'edit')])")).click();
			String actualEditURL=driver.getCurrentUrl();
			System.out.println(actualEditURL);
			Assert.assertEquals(actualEditURL, editURL);
			rowElement.findElement(By.xpath("(//a[contains(@href,'delete')])")).click();
			String actualDeleteURL=driver.getCurrentUrl();
			System.out.println(actualDeleteURL);
			Assert.assertEquals(actualDeleteURL, deleteURL);	
		}
	}
	@Test(priority = 10)	
	public void verifyForkImg() {
		WebElement forkImg = driver.findElement(By.tagName("img"));
		Assert.assertTrue(forkImg.isDisplayed());
		forkImg.click();
		String actualForkImgUrl= driver.getCurrentUrl();
		System.out.println("After switching to Child window:"+actualForkImgUrl);
		Assert.assertEquals(actualForkImgUrl, expForkImgURL);	
		driver.navigate().back();
	}

	@Test(priority = 11)
	public void verifyFooter() {
		WebElement footerElement = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']"));
		String footerText = driver.findElement(By.xpath("//div[text()='Powered by ']")).getText();
		System.out.println("Footer Text:"+footerText);
		Assert.assertEquals(footerText, expFooterText);
		System.out.println("Footer: "+footerElement.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).isDisplayed());
		
		footerElement.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
			Iterator<String> windowIterator = windowIds.iterator();
			String parentWindowId=windowIterator.next();
			String childWindowId=windowIterator.next();
			driver.switchTo().window(childWindowId);
			String actualFootUrl= driver.getCurrentUrl();
			System.out.println("After switching to Child window:"+actualFootUrl);
			Assert.assertEquals(actualFootUrl, expFooterUrl);
			
			String actualFooterTitle = driver.getTitle();
			System.out.println("After switching to Child window:"+actualFooterTitle);
			Assert.assertEquals(actualFooterTitle, expFooterTitle);
			
	}

@AfterSuite 
public void CloseBowser() {
	driver.close();
}
}
