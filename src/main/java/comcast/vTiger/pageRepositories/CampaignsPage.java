package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement plus_Icon;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getPlus_Icon() {
		return plus_Icon;
	}
	
	//Method to click on create campaign plus icon
	public void clickPlusIcon()
	{
		getPlus_Icon().click();
	}

}
