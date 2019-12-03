package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class OpenBrowser {
	public WebDriver driver=null;
	
	
	public void launchBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Neethu\\eclipse-workspace\\Challenging_DOM\\Data.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neethu\\work\\chrome\\version78\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}else if(prop.getProperty("browser").equals("firefox")){
			driver =new FirefoxDriver();
		}
	}
	
}
