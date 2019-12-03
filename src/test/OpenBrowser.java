package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class OpenBrowser {
	public WebDriver driver=null;
	String expFooterText = null;
	String expFooterUrl =null;
	String expFooterTitle =null;
	String expForkImgURL=null;
	String expectedTitle = null;
	String expectedHeading = null;
	String expectedDesc = null;
	String editURL = null;
	String deleteURL = null;
	
	public void launchBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Neethu\\eclipse-workspace\\Challenging_DOM\\Data.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neethu\\work\\chrome\\version78\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Neethu\\work\\firefox\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
		}else {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Neethu\\work\\ie\\MicrosoftWebDriver.exe");
		WebDriver driver= new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expFooterText =prop.getProperty("expFooterText");
		expFooterUrl =prop.getProperty("expFooterUrl");
		expFooterTitle=prop.getProperty("expFooterTitle");
		expForkImgURL=prop.getProperty("expForkImgURL");
		expectedTitle=prop.getProperty("expectedTitle");
		expectedHeading=prop.getProperty("expectedHeading");
		expectedDesc = prop.getProperty("expectedDesc");
		editURL = prop.getProperty("editURL");
		deleteURL = prop.getProperty("deleteURL");
	}
	
}
