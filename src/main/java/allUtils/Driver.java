package allUtils;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class Driver {

    private static ArrayList<WebDriver> driverList = new ArrayList<WebDriver>();

    public synchronized static void setDriver(WebDriver driver)
    {
        driverList.add(driver);
    }

    public synchronized static ArrayList<WebDriver> getDriverList()
    {
        return driverList;
    }

}
