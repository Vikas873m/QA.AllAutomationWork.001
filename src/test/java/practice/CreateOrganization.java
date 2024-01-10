package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtilities;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		//Step1 : Create all the requirements
		JavaUtility jUtil = new JavaUtility();
	    ExcelFileUtility eUtil=new ExcelFileUtility();
	    PropertyFileUtilities pUtil=new  PropertyFileUtilities();
	    WebDriverUtility wUtil=new WebDriverUtility();
	    WebDriver driver=null;
	    
	    //Step2: Read to required data
	   String BROWSER = pUtil.readDataFromPropertyFile("browser");
	   String URL = pUtil.readDataFromPropertyFile("url");
	   String USERNAME = pUtil.readDataFromPropertyFile("username");
	   String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
	
	// step3: Launch the Browser
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println(BROWSER+" Launched");
	}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+" Launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+" Launched");
	}
		else {
			System.out.println("Invalid Browser Name");
		}
		
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForPageLoad(driver);
	    
	    //Step4:  to load the URL
	    driver.get(URL);
	    
	    //Step5: login to the application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
	    //Step6: navigate organization link
	    driver.findElement(By.linkText("Organizations")).click();
	    
	    // step7: click on create organization lookup image
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    //step8: create organization with mandatory information
	    driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	    
	    //setp9: save
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //step10: Validate
	    String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(OrgHeader.contains(ORGNAME)){
		System.out.println(OrgHeader);
		System.out.println("Pass");

	}
	else {
		System.out.println("Fail");
	}
	
	//Step11: logout the application
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, ele);
	
	driver.findElement(By.linkText("Sign Out")).click();
	
	Thread.sleep(1000);
	driver.quit();
	
	}
	}

