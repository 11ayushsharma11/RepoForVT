package comcast.vTiger.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {

	private String filePath;

	public Property_Utility(String fp)
	{
		filePath = fp;
	}
	
	public String getProperty(String propertyName)
	{
		String propertyValue = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			propertyValue = prop.getProperty(propertyName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return propertyValue;
	}

}
