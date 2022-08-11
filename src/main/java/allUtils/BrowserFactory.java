package allUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public synchronized static WebDriver launchTheBrowser(String browserName, String platformName)
    {
        WebDriver driver = null;

        if(browserName.equalsIgnoreCase("chrome") && platformName.equalsIgnoreCase("windows"))
        {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox") && platformName.equalsIgnoreCase("windows"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge") && platformName.equalsIgnoreCase("windows"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        return driver;
    }

}
