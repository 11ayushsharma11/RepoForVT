package comcast.vTiger.genericUtility;

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import comcast.vTiger.pageRepositories.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
	
	public WebDriver driver;
	
	public static WebDriver staticDriver;
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuite()
	{
		//database connectivity
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest()
	{
		//specify what type of the execution will be performed (batch, parallel etc)
	}
	
	@Parameters({"browserName"})
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClass(@Optional("chrome")String browserName)
	{
		//launching the desired browser
//		browserName = pu.getProperty("browsername");
		
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		staticDriver = driver;
		
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethod()
	{
		//login to the application
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod()
	{
		//logout from the application
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass()
	{
		driver.close();
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void afterTest()
	{
		//close the execution
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuite()
	{
		//close database connection
	}
}
