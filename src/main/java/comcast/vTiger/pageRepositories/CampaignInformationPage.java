package comcast.vTiger.pageRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	private String xpathForCampaignHeading = "//span[contains(text(),'" + "%s" +" -  Campaign Information')]";
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElement Getters
	public WebElement getCampaignInformationHeading(WebDriver driver, String campaignName)
	{
		String xpath = String.format(xpathForCampaignHeading, campaignName);
		System.out.println(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele;
	}

}
