package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
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
@Listeners(genericUtility.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws InterruptedException, IOException {
 
	
   
   String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 3)+jUtil.getRandomNumber();
   String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 7, 2);
   
    
    
    // Step6: Click on Organization
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
   /* if(orgHeader.contains(orgHeader)) {
    	System.out.println(orgHeader);
    	System.out.println("Organization Created");
    }
    else {
    	System.out.println("Fail");
    }
    */
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
  /* if(contactHeader.contains(LASTNAME)) {
	   System.out.println(contactHeader);
	   System.out.println("Pass");
   }
   else {
	   System.out.println("Fail");
   }
   */
  
}

}
