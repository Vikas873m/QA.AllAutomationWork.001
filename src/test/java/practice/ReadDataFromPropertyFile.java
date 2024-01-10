package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Step1: Open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step2: create object of properties for java.util package
		Properties p = new Properties();
		
		// step3: load the file input Stream into Properties
		p.load(fis);
		
		// Step4: Provide the key and read the value 
		String value = p.getProperty("browser");
		System.out.println(value);
		
		String value1 = p.getProperty("url");
		System.out.println(value1);
	}
}
