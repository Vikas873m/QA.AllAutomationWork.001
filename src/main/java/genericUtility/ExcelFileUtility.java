package genericUtility;
/**
 * This Method will read the data from excel file
 * @author Vikas
 */

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file and
	 *  return the value of caller
	 * @param sheetName
	 * @param rowNO
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	
		public String readDataFromExcelSheet(String sheetName, int rowNO, int cellNo) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 String value = wb.getSheet(sheetName).getRow(rowNO).getCell(cellNo).getStringCellValue();
	return value;
	
	}
		/**
		 * this method will read multiple data from excel sheet at the time
		 * used for data provider
		 * @param sheetName
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		    Workbook wb= WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet(sheetName);
		   int lastRow = sh.getLastRowNum();
		   int lastCell = sh.getRow(0).getLastCellNum();
		   
		   Object[][] data =new Object[lastRow][lastCell];
		   for(int i=0;i<lastRow;i++)
		   {
			   for(int j=0;j<lastCell;j++)
		   {
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();	  
		   }
		   }
		   return data;
		}

}
