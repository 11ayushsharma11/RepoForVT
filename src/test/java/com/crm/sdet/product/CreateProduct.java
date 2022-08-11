package com.crm.sdet.product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vTiger.genericUtility.BaseClass;
import comcast.vTiger.genericUtility.Excel_Utility;
import comcast.vTiger.genericUtility.Java_Utility;
import comcast.vTiger.genericUtility.WebDriver_Utility;
import comcast.vTiger.pageRepositories.CreateNewProductPage;
import comcast.vTiger.pageRepositories.HomePage;
import comcast.vTiger.pageRepositories.ProductInformationPage;
import comcast.vTiger.pageRepositories.ProductsPage;

public class CreateProduct extends BaseClass {
	
	@Test(groups = {"smoke","regression"})
	public void createProduct()
	{
//		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
//		String url = pu.getProperty("url");
//		String userName = pu.getProperty("username");
//		String password = pu.getProperty("password");
//				
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
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
		
		int rNum = ju.getRandomNumber();
		
		String prodName = eu.getDataFromExcel("Product", 1, 0) + rNum;
				
		CreateNewProductPage createNewProductPage = new CreateNewProductPage(driver);
		createNewProductPage.enterProductName(prodName);
		createNewProductPage.clickSaveButton();
		
//		Assert.assertEquals(0, 1); //create product failure after creating product before assertion
		
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
	
}
