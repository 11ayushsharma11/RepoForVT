package com.crm.sdet.campaign;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vTiger.genericUtility.BaseClass;
import comcast.vTiger.genericUtility.Excel_Utility;
import comcast.vTiger.genericUtility.Java_Utility;
import comcast.vTiger.genericUtility.WebDriver_Utility;
import comcast.vTiger.pageRepositories.CampaignInformationPage;
import comcast.vTiger.pageRepositories.CampaignsPage;
import comcast.vTiger.pageRepositories.CreateNewCampaignPage;
import comcast.vTiger.pageRepositories.HomePage;

public class CreateCampaign extends BaseClass {
	
//	HomePage homePage;
//	CampaignsPage campaignsPage;
//	CreateNewCampaignPage createNewCampaignPage;
//	CampaignInformationPage campaignInformationPage;
//	
//	@BeforeClass
//	public void initializaPomClasses()
//	{
//		homePage = new HomePage(driver);
//		campaignsPage = new CampaignsPage(driver);
//		createNewCampaignPage = new CreateNewCampaignPage(driver);
//		campaignInformationPage = new CampaignInformationPage(driver);
//	}
	
	@Test(groups = {"smoke","regression"})
	public void createCampaign()
	{
//		Property_Utility pu = new Property_Utility("./src/test/resources/cred.properties");
		Excel_Utility eu = new Excel_Utility("./src/test/resources/TestData.xlsx");
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
//		Assert.assertEquals(0, 1); //campaign failure after login
		
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

}
