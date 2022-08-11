package com.crm.sdet.campaign;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vTiger.genericUtility.BaseClass;
import comcast.vTiger.genericUtility.Excel_Utility;
import comcast.vTiger.genericUtility.Java_Utility;
import comcast.vTiger.genericUtility.WebDriver_Utility;
import comcast.vTiger.pageRepositories.AddProductPartialWindow;
import comcast.vTiger.pageRepositories.CampaignInformationPage;
import comcast.vTiger.pageRepositories.CampaignsPage;
import comcast.vTiger.pageRepositories.CreateNewCampaignPage;
import comcast.vTiger.pageRepositories.CreateNewProductPage;
import comcast.vTiger.pageRepositories.HomePage;
import comcast.vTiger.pageRepositories.ProductInformationPage;
import comcast.vTiger.pageRepositories.ProductsPage;

public class CreateCampaignWithProduct extends BaseClass {
	
//	private String prodName;
//	private WebDriver driver;
	
	@Test(groups = {"smoke","regression"})
	public void createCampaignWithProduct()
	{
//		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
//		String url = pu.getProperty("url");
//		String userName = pu.getProperty("username");
//		String password = pu.getProperty("password");
				
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
//		driver.get(url);
		
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
//		driver.get(url);
		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(userName, password);
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductTab();
				
		ProductsPage productPage = new ProductsPage(driver);
		productPage.clickPlusIcon();
		
//		Assert.assertEquals(0, 1); //campaignwithproduct failure after clicking add product icon. 
		
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
