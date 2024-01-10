package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Report;

import genericUtility.BaseClass;
import objectRepository.ContactPageInfo;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
@Listeners(genericUtility.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass {
@Test (groups = "SmokeSuite")
  public void createcontact() throws EncryptedDocumentException, IOException 
{
	String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
	 //Step 10: Click on Contacts link
	HomePage hp=new HomePage(driver);
    hp.clickOnContactsLink();
    Reporter.log("clicked on contact link ");

    //Step11: click on create lookup image
    ContactsPage cp=new ContactsPage(driver);
    cp.clickOnCreateContactLookUpImg();
    // Assert.fail();
    Reporter.log("clicked on create contact lookup image ");

    
    //Step12: create contact with organization
    CreateNewContactPage cncp=new CreateNewContactPage(driver);
    cncp.createNewContact( LASTNAME);
    Reporter.log("contact created successfully  ");


//step13: Validation
    ContactPageInfo cip=new ContactPageInfo(driver);
   String contactHeader = cip.getHeaderText();

   Reporter.log("Header captured");
   

   Assert.assertTrue(contactHeader.contains(LASTNAME));
   Reporter.log("Header Validated ");
   System.out.println(contactHeader);
}
@Test
public void demo() {
	System.out.println("Demo");
}
	
}
