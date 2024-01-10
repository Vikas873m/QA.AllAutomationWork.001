package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Open doc from java readable format
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: create workbook
		Workbook wb = WorkbookFactory.create(fil);
		
		//Step3: navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Step4:navigate to required row
		Row ew = sh.getRow(1);
		
		//step5: navigate to required cell
	   Cell cl = ew.getCell(2);
	 
	 //Step5: Capture the value and print
	String value = cl.getStringCellValue();
	System.out.println(value);
		
		
	}
}
