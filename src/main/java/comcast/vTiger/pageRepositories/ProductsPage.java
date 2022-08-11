package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plus_Icon;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getPlus_Icon() {
		return plus_Icon;
	}
	
	//Method to click on the plus icon button
	public void clickPlusIcon()
	{
		getPlus_Icon().click();
	}
	
}
