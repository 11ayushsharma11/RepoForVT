package comcast.vTiger.pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//@author : Ayush Sharma
public class LoginPage {
	
	@FindAll({@FindBy(xpath="//input[@type='text']"),@FindBy(xpath="//input[@name='user_name']")})
	private WebElement user_Name;
	
//	@FindBy(xpath="//input[@name='user_name']")
//	private WebElement user_Name;
	
	@FindAll({@FindBy(xpath="//input[@type='password']"),@FindBy(xpath="//input[@name='user_password']")})
	private WebElement password;
	
//	@FindBy(xpath="//input[@name='user_password']")
//	private WebElement password;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement login_Button;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//WebElements getters
	public WebElement getUser_Name() {
		return user_Name;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLogin_Button() {
		return login_Button;
	}
	
	//business logic
	//Used to login to the application
	//@param : userName
	//@param : password
	public void login(String userName, String password)
	{
		getUser_Name().sendKeys(userName);
		getPassword().sendKeys(password);
		getLogin_Button().click();
	}

}
