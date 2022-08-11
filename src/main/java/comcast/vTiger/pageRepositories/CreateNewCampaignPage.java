package comcast.vTiger.pageRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaign_Name;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save_Button;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement product_Plus_Icon;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getCampaign_Name() {
		return campaign_Name;
	}

	public WebElement getSave_Button() {
		return save_Button;
	}
	
	public WebElement getProduct_Plus_Icon() {
		return product_Plus_Icon;
	}
	
	//Method to enter campaign name
	public void enterCampaignName(String campaignName)
	{
		getCampaign_Name().sendKeys(campaignName);
	}
	
	//Method to click save button
	public void clickSaveButton()
	{
		getSave_Button().click();
	}
	
	//Method to click on choose product plus icon
	public void clickOnProductPlusIcon()
	{
		getProduct_Plus_Icon().click();
	}

}
