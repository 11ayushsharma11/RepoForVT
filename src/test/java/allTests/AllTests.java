package allTests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import allUtils.BeforeAndAfterConfiguration;
import allUtils.Driver;
import comcast.vTiger.genericUtility.BaseClass;
import comcast.vTiger.genericUtility.Excel_Utility;
import comcast.vTiger.genericUtility.Java_Utility;
import comcast.vTiger.genericUtility.Property_Utility;
import comcast.vTiger.genericUtility.WebDriver_Utility;
import comcast.vTiger.pageRepositories.AddProductPartialWindow;
import comcast.vTiger.pageRepositories.CampaignInformationPage;
import comcast.vTiger.pageRepositories.CampaignsPage;
import comcast.vTiger.pageRepositories.CreateNewCampaignPage;
import comcast.vTiger.pageRepositories.CreateNewOrganizationPage;
import comcast.vTiger.pageRepositories.CreateNewProductPage;
import comcast.vTiger.pageRepositories.HomePage;
import comcast.vTiger.pageRepositories.LoginPage;
import comcast.vTiger.pageRepositories.OrganizationInformationPage;
import comcast.vTiger.pageRepositories.OrganizationsPage;
import comcast.vTiger.pageRepositories.ProductInformationPage;
import comcast.vTiger.pageRepositories.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllTests extends BeforeAndAfterConfiguration {
	
	private ArrayList<WebDriver> driverList = Driver.getDriverList();
    int i = 0;

    public synchronized WebDriver getDriver()
    {
        WebDriver driver = driverList.get(i);
        i=i+1;
        return driver;
    }
	
	@Test
	public void createOrganization()
	{
		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
				
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		driver.get(url);
		
		WebDriver driver = getDriver();
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
				
		HomePage homePage = new HomePage(driver);
		homePage.clickOrganizationsTab();
				
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.clickPlusIcon();
		
		int rNum = ju.getRandomNumber();
		
		String orgName = eu.getDataFromExcel("Organization", 1, 0) + rNum;
				
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.enterOrganizationName(orgName);
		createNewOrganizationPage.clickSaveButton();
		
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		String actualText = organizationInformationPage.getOrganizationInformationHeading(driver, orgName).getText();
		String expectedText = orgName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
		
	}
	
	@Test
	public void createProduct()
	{
		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get(url);
		
		WebDriver driver = getDriver();
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductTab();
				
		ProductsPage productPage = new ProductsPage(driver);
		productPage.clickPlusIcon();
		
		int rNum = ju.getRandomNumber();
		
		String prodName = eu.getDataFromExcel("Product", 1, 0) + rNum;
				
		CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
		createNewProductPage.enterProductName(prodName);
		createNewProductPage.clickSaveButton();
				
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		
		String actualText = productInformationPage.getProductInformationHeading(driver, prodName).getText();
		String expectedText = prodName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
		
	}

	@Test
	public void deleteProduct()
	{
		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		driver.get(url);
		
		WebDriver driver = getDriver();
		
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
				
		HomePage homePage = new HomePage(driver);
		homePage.clickProductTab();
				
		ProductsPage productPage = new ProductsPage(driver);
		productPage.clickPlusIcon();
		
		int rNum = ju.getRandomNumber();
		
		String prodName = eu.getDataFromExcel("Product", 1, 0) + rNum;
				
		CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
		createNewProductPage.enterProductName(prodName);
		createNewProductPage.clickSaveButton();
				
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		
		String actualText = productInformationPage.getProductInformationHeading(driver, prodName).getText();
		String expectedText = prodName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(prodName);
//		WebDriver_Utility wu = new WebDriver_Utility();
		
//		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		productInformationPage.clickDeleteButton();
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		wu.switchToAlertAndAccept(driver);
		
//		HomePage homePage = new HomePage(driver);
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
	}

	@Test
	public void createCampaign()
	{
		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		driver.get(url);
		
		WebDriver driver = getDriver();
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
				
		HomePage homePage = new HomePage(driver);
		wu.hoverMouseOnElement(driver, homePage.getMore_Tab());
		homePage.clickCampaignTab();
				
		CampaignsPage campaignsPage = new CampaignsPage(driver);
		campaignsPage.clickPlusIcon();
		
		int rNum = ju.getRandomNumber();
		
		String campName = eu.getDataFromExcel("Campaign", 1, 0) + rNum;
				
		CreateNewCampaignPage createNewCampaignPage = new CreateNewCampaignPage(driver);
		createNewCampaignPage.enterCampaignName(campName);
		createNewCampaignPage.clickSaveButton();
		
		CampaignInformationPage campaignInformationPage = new CampaignInformationPage(driver);
		String actualText = campaignInformationPage.getCampaignInformationHeading(driver, campName).getText();
		String expectedText = campName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
		
	}

	@Test
	public void createCampaignWithProduct()
	{
		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		String url = pu.getProperty("url");
		String userName = pu.getProperty("username");
		String password = pu.getProperty("password");
				
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
//		driver.get(url);
		
		WebDriver driver = getDriver();
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductTab();
				
		ProductsPage productPage = new ProductsPage(driver);
		productPage.clickPlusIcon();
		
		int rNum = ju.getRandomNumber();
		
		String prodName = eu.getDataFromExcel("Product", 1, 0) + rNum;
				
		CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
		createNewProductPage.enterProductName(prodName);
		createNewProductPage.clickSaveButton();
				
		ProductInformationPage productInformationPage = new ProductInformationPage(driver);
		
		String actualText = productInformationPage.getProductInformationHeading(driver, prodName).getText();
		String expectedText = prodName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
//		Java_Utility ju = new Java_Utility();
//		WebDriver_Utility wu = new WebDriver_Utility();
				
//		HomePage homePage = new HomePage(driver);
		wu.hoverMouseOnElement(driver, homePage.getMore_Tab());
		homePage.clickCampaignTab();
		
		CampaignsPage campaignsPage = new CampaignsPage(driver);
		campaignsPage.clickPlusIcon();
				
		CreateNewCampaignPage createNewCampaignPage = new CreateNewCampaignPage(driver);
		createNewCampaignPage.clickOnProductPlusIcon();
		
		wu.switchToWindow(driver, "Products&action");
				
		AddProductPartialWindow addProductPartialWindow = new AddProductPartialWindow(driver);
		addProductPartialWindow.enterProductName(prodName);
		addProductPartialWindow.clickOnSearchButton();
		addProductPartialWindow.clickOnProductName(driver, prodName);
		
		wu.switchToWindow(driver, "Campaigns");
				
		rNum = ju.getRandomNumber();
		
		String campName = eu.getDataFromExcel("Campaign", 1, 0) + rNum;
		
		createNewCampaignPage.enterCampaignName(campName);
		createNewCampaignPage.clickSaveButton();
		
		CampaignInformationPage campaignInformationPage = new CampaignInformationPage(driver);
		actualText = campaignInformationPage.getCampaignInformationHeading(driver, campName).getText();
		expectedText = campName;
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
		
	}

	
}
