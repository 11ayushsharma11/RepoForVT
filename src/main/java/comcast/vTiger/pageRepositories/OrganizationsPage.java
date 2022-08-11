package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Organizations']")
	private WebElement organizations_Tab;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plus_Icon;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements Getters
	public WebElement getOrganizations_Tab() {
		return organizations_Tab;
	}
	
	public WebElement getPlus_Icon() {
		return plus_Icon;
	}
	
	//Method to click on the plus icon
	public void clickPlusIcon()
	{
		getPlus_Icon().click();
	}
	
}
