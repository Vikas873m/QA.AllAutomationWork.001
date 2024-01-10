package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {


	public static void main(String[] args) throws IOException, InterruptedException {

		//Step1: Read all the necessary data
		
		/* read data from property file*/
		
      FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(file);
		String Url = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/* read data from Excel Sheet*/
		 FileInputStream file1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
        Workbook wb = WorkbookFactory.create(file1);
        wb.getSheet("Contacts").getRow(1).getCell(2).getRichStringCellValue();
        WebDriver driver= null;
        
        // Step2: Launch the Browser // Run time Polymorphism - driver
        
        if(BROWSER.equalsIgnoreCase("chrome")) {
        	driver=new ChromeDriver();
        	System.out.println(BROWSER+" launches");
        	
        }
        else if(BROWSER.equalsIgnoreCase("Firefox")) {
        	driver=new FirefoxDriver();
        	System.out.println(BROWSER+" launches");
        	
        }
        else if(BROWSER.equalsIgnoreCase("Edge")) {
        	driver=new EdgeDriver();
        	System.out.println(BROWSER+" launches");

        }
        else {
        	System.out.println("Indivisual Browser Name");
        }
        driver.manage().window().maximize();
      		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      		
      		//Step 2: Load the Application
      		driver.get(Url);
      		
      		//Step 3: Login to Application
      		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
      		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
      		driver.findElement(By.id("submitButton")).click();
      	//Step 4: Navigate to Contacts LInk
    		driver.findElement(By.linkText("Contacts")).click();
    		
    		//Step 5: Click on create conatcts look up Image
    		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    		
    		//Step 6: create conatct
    		driver.findElement(By.name("lastname")).sendKeys("LASTNAME");
    		
    		//Step 7: Save
    		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    		
    		//Step 8: Validate
    		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    		
    		
			if(contactHeader.contains(contactHeader)) {
    			System.out.println("PASS");
    		}
    		else
    		{
    			System.out.println("FAIL");
    		}
    		
    		
    		//Step 9: Logout
    		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    		
    		Actions act = new Actions(driver);
    		act.moveToElement(ele).perform();
    		Thread.sleep(1000);
    		
    		driver.findElement(By.linkText("Sign Out")).click();
    		
    		System.out.println("SignOut successful");
    		driver.quit();
        
	}

}
