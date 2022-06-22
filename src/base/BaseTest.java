package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.saiteja.automation.Utilities.Driverpaths;

public class BaseTest {

	private static WebDriver driver;
	
	/*
	This open browser method is used for opening browser
	param: which browser want to open(chrome,ie,firefox,edge,etc.)
	*/
	
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowse(@Optional("chrome") String browser) {
	if (browser.equalsIgnoreCase("firefox")) 
	{
		System.setProperty(utilities.Driverpaths.firefoxkey, utilities.Driverpaths.firefoxvalue);
		driver = new FirefoxDriver();
		init();
	}
	else if (browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty(utilities.Driverpaths.chromekey,utilities.Driverpaths.chromevalue);
		driver = new ChromeDriver();
		init();
	}
	else if (browser.equalsIgnoreCase("ie"))
	{
		System.setProperty(utilities.Driverpaths.iekey, utilities.Driverpaths.ievalue);
		driver = new InternetExplorerDriver();
		init();
		}
		
	}
	
	public void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	
	//To close Browser
	@AfterSuite
	public void closebrowser() {
		if(driver !=null) {
			driver.close();
		}
			else {
				//throw exception
				System.out.println("DRIVER IS POINTING TO NULL");
			}

	}
	
	/*
	To access webDriver object outside the class
	*/
		public static WebDriver getDriver() {
			return driver;
		}
}
