package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * this class consists o all basic configuration annotations to TestNG
 * @author Vikas
 *
 */
public class BaseClass {
	
   public PropertyFileUtilities pUtil =new PropertyFileUtilities();
   public ExcelFileUtility eUtil = new ExcelFileUtility();
   public JavaUtility jUtil = new JavaUtility();
   public WebDriverUtility wUtil = new WebDriverUtility();
   public WebDriver driver= null;
   
   public static WebDriver sdriver;
   
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() 
	{
		System.out.println("---- DB Connection Successful ----");
	}
	//@Parameters("browser")
	//BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException 
	{
	  String BROWSER = pUtil.readDataFromPropertyFile("browser");
      String URL = pUtil.readDataFromPropertyFile("url");
		   
	  if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
    	System.out.println(BROWSER+" ----Launched----");
	}
	 else if(BROWSER.equalsIgnoreCase("Firefox")) {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
    	System.out.println(BROWSER+" ----Launched----");
	}
	 else if(BROWSER.equalsIgnoreCase("Edge")) {
	    WebDriverManager.edgedriver().setup();
	    driver=new EdgeDriver();
    	System.out.println(BROWSER+" ----Launched----");
	}
	 else 
	 {
		System.out.println("Invalid Browser Name");
	}
				
	   wUtil.maximizeWindow(driver);
	   wUtil.waitForPageLoad(driver);
	   
	   // only used in Listeners 
	   sdriver=driver;
			   
	  driver.get(URL);
			    	   
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException 
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---- Login Successful ----");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("---- Logout Successful ----");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("---- Browser Close ----");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() 
	{
		System.out.println("---- DB Connection Close ----");

	}
}
