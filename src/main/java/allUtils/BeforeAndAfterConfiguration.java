package allUtils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BeforeAndAfterConfiguration {

    @BeforeMethod
    public synchronized void beforeTestMethod()
    {
        WebDriver driver = BrowserFactory.launchTheBrowser("chrome","windows");
        Driver.setDriver(driver);
    }

    @AfterClass
    public void afterTestClass()
    {
        ArrayList<WebDriver> driverList = Driver.getDriverList();
        for(WebDriver driver : driverList)
            driver.quit();
    }

}