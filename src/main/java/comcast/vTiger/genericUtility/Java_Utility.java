package comcast.vTiger.genericUtility;

import java.util.Random;

public class Java_Utility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int rNum = r.nextInt(1000);
		return rNum;
	}
	
}
