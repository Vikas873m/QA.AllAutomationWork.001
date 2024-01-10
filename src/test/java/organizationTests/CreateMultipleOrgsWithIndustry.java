package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtilities;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrgsWithIndustry {

	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtilities pUtil=new PropertyFileUtilities();
	WebDriverUtility wUtil=new WebDriverUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRYTNAME ) throws IOException
	{
		WebDriver driver=null;
		 //Step2: Read to required data
		   String BROWSER = pUtil.readDataFromPropertyFile("browser");
		   String URL = pUtil.readDataFromPropertyFile("url");
		   String USERNAME = pUtil.readDataFromPropertyFile("username");
		   String PASSWORD = pUtil.readDataFromPropertyFile("password");

		   String ORGNAME =ORG+jUtil.getRandomNumber();
		   
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
		    
		    //Step5: login to Application
		    LoginPage lp=new LoginPage(driver);
		    lp.loginToApp(USERNAME, PASSWORD);
		    
		    // Step6Cllick on Organization
		    HomePage hp=new HomePage(driver);
		    hp.clickOnOrganizationLink();

		    //Step7: click onOrganization Lookup image
		    OrganizationPage op=new OrganizationPage(driver);
		    op.clickOnOrganization();
		    
		    //step8 create new Organization with mandatory field
		    CreateOrganizationPage cnop=new CreateOrganizationPage(driver);
		    cnop.createNewOrganization(ORGNAME, INDUSTRYTNAME);
		    wUtil.captureScreenShot(driver, ORGNAME);
		    
		    //Step9: validate for Organization
		    OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		    String orgHeader = oip.getHeaderText();
		    if(orgHeader.contains(orgHeader)) {
		    	System.out.println(orgHeader);
		    	System.out.println("Organization Created");
		    }
		    else {
		    	System.out.println("Fail");
		    }
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	return	eUtil.readMultipleData("MultipleOrganizations");
		
	}
}
