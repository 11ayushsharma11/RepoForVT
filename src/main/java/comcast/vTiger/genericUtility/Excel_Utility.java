package comcast.vTiger.genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	private String filePath;
	
	public Excel_Utility(String fp)
	{
		filePath = fp;
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
	{
		
		String data = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
}
