package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vTiger.genericUtility.WebDriver_Utility;

public class HomePage {
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Organizations']")
	private WebElement organizations_Tab;
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Products']")
	private WebElement products_Tab;
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='More']")
	private WebElement more_Tab;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaign_Tab;
	
	@FindBy(xpath="(//span[text()=' Administrator']//parent::td//following-sibling::td//img)[1]")
	private WebElement user_Icon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout_Link;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getOrganizations_Tab() {
		return organizations_Tab;
	}

	public WebElement getUser_Icon() {
		return user_Icon;
	}

	public WebElement getSignout_Link() {
		return signout_Link;
	}

	public WebElement getProducts_Tab() {
		return products_Tab;
	}

	public WebElement getMore_Tab() {
		return more_Tab;
	}

	public WebElement getCampaign_Tab() {
		return campaign_Tab;
	}
	
	//Method to click on Organizations tab
	public void clickOrganizationsTab()
	{
		getOrganizations_Tab().click();
	}
	
	//Method to click on sign out link
	public void clickSignOutLink()
	{
		getSignout_Link().click();
	}
	
	//Method to click on the Products tab
	public void clickProductTab()
	{
		getProducts_Tab().click();
	}
	
	//Method to click on the Campaigns tab
	public void clickCampaignTab()
	{
		getCampaign_Tab().click();
	}
	
}
