package com.crm.sdet.organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vTiger.genericUtility.BaseClass;
import comcast.vTiger.genericUtility.Excel_Utility;
import comcast.vTiger.genericUtility.Java_Utility;
import comcast.vTiger.genericUtility.WebDriver_Utility;
import comcast.vTiger.pageRepositories.CreateNewOrganizationPage;
import comcast.vTiger.pageRepositories.HomePage;
import comcast.vTiger.pageRepositories.OrganizationInformationPage;
import comcast.vTiger.pageRepositories.OrganizationsPage;

public class CreateOrganization extends BaseClass {
	
	@Test(groups = {"smoke"})
	public void createOrganization()
	{
//		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
//		String url = pu.getProperty("url");
//		String userName = pu.getProperty("username");
//		String password = pu.getProperty("password");
				
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		driver.get(url);
		
		wu.pageLoadTimeout(driver);
		driver.manage().window().maximize();
//		driver.get(url);
		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(userName, password);
				
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
		
//		Assert.assertEquals(0, 1); //organization failure after organization creation.
		
		wu.hoverMouseOnElement(driver, homePage.getUser_Icon());
		homePage.clickSignOutLink();
		
	}
	
}
