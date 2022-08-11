package comcast.vTiger.pageRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	private String OrganizationInformationHeading = "//span[contains(text(),'" + "%s" +" -  Organization Information')]";
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements Getters
	public WebElement getOrganizationInformationHeading(WebDriver driver, String orgName) {
		
		String xpath = String.format(OrganizationInformationHeading, orgName);
		System.out.println(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
		
	}

}
