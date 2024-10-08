package baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepositry.HomePage;
import ObjectRepositry.LoginPage;
import genericUtility.PropertyFileUtility;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver;
	PropertyFileUtility putil=new PropertyFileUtility();
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("Database connection,Report config");
	}
	@AfterSuite
	public void configAs() {
		System.out.println("Disconnect Database connection, Report Back up");
	}
	@BeforeTest
	public void configBT() {
		System.out.println("Pre condition");
	
	}
	@AfterTest
	public void afterAt() {
		System.out.println("post condition");
	}
	@BeforeClass
	public void configBC() throws IOException {
	String 	BROWSER=putil.readDataFromProperties("Browser");
	String 	URL=putil.readDataFromProperties("Url");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver= new FirefoxDriver();
	}else if(BROWSER.equalsIgnoreCase("edge")) {
		driver= new EdgeDriver();
	}else {
		driver= new ChromeDriver();
	}
	sdriver=driver;
		driver.get(URL);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void configBM() throws IOException {
		String UNAME=putil.readDataFromProperties("Username");
		String PWD=putil.readDataFromProperties("Password");
		LoginPage lp= new LoginPage(driver);
		lp.Login();
		
	}
	@AfterMethod
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void configAC() {
		driver.quit();
	}

}
