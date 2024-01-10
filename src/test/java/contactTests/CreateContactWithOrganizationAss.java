package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtilities;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactPageInfo;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateContactWithOrganizationAss {


	public static void main(String[] args) throws IOException, InterruptedException {
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
	
	String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 3)+jUtil.getRandomNumber();
	String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 2);
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
	    cnop.createNewOrganization(ORGNAME);
	    
	    //Step9: validate for Organization
	    OrganizationInfoPage oip= new OrganizationInfoPage(driver);
	    String orgHeader = oip.getHeaderText();
	    
	    Assert.assertTrue(orgHeader.contains(orgHeader));
	    System.out.println(orgHeader);
	 
	    
	    //Step 10: Click on Contacts link
	    hp.clickOnContactsLink();
	
	    //Step11: click on create lookup image
	    ContactsPage cp=new ContactsPage(driver);
	    cp.clickOnCreateContactLookUpImg();
	    
	    //Step12: create contact with organization
	    CreateNewContactPage cncp=new CreateNewContactPage(driver);
	    cncp.createNewContact(driver, LASTNAME, ORGNAME);
	
	//step13: Validation
	    ContactPageInfo cip=new ContactPageInfo(driver);
	   String contactHeader = cip.getHeaderText();
	   Assert.assertTrue(contactHeader.contains(LASTNAME));
	   System.out.println(contactHeader);
	 
	   
	   //Step14: Logout
	   hp.logoutOfApp(driver);
	
	//step15: close the Browser
	   driver.quit();
	
	}

}
