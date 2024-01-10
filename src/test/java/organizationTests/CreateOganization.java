package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOganization extends BaseClass {
@Test(groups = "RegressionSuite")
	public void createOrg() throws EncryptedDocumentException, IOException {
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2)+jUtil.getRandomNumber();

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
	}
}
