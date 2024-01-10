package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//Declaration 
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookUpImg;
	
	//initialization 
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization 
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	//Business Library
	/**
	 * this method will click on create organization lookup image
	 */
	public void clickOnOrganization() {
		CreateOrgLookUpImg.click();
	}
	
}
