package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organization_Name_Field;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save_Button;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Webelement Getters
	public WebElement getOrganization_Name_Field() {
		return organization_Name_Field;
	}

	public WebElement getSave_Button() {
		return save_Button;
	}
	
	//Step to enter Organization name
	public void enterOrganizationName(String orgName)
	{
		getOrganization_Name_Field().sendKeys(orgName);
	}
	
	//Step to click on save button
	public void clickSaveButton()
	{
		getSave_Button().click();
	}

}
