package practice;

import java.io.IOException;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtilities;

public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		String Username = pUtil.readDataFromPropertyFile("username");
		System.out.println(Username);
	
		String Browser = pUtil.readDataFromPropertyFile("browser");
		System.out.println(Browser);
	
		String Url = pUtil.readDataFromPropertyFile("url");
		System.out.println(Url);
	
		String pwd = pUtil.readDataFromPropertyFile("password");
		System.out.println(pwd);
		
		ExcelFileUtility eUtl=new ExcelFileUtility();
		String data = eUtl.readDataFromExcelSheet("Contacts", 1, 2);
		System.out.println(data);
	
		String data1 = eUtl.readDataFromExcelSheet("Contacts", 1, 1);
		System.out.println(data1);
		
		JavaUtility jUtil = new JavaUtility();
		int r = jUtil.getRandomNumber();
		System.out.println(r);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
	
	}
}
