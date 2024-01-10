package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	//Declaration 
	@FindBy(name = "accountname")
	private WebElement OrgaNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization 
	public WebElement getOrgaNameEdt() {
		return OrgaNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}

	public WebElement getSavebtn() {
		return SaveBtn;
	}
	
	//Business library
	/**
	 * this method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		OrgaNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * this method  will create new organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY ) {
		OrgaNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn, INDUSTRY );
		SaveBtn.click();
	}
	public void createNewOrganization(String ORGNAME, String INDUSTRY, String TYPE ) {
		OrgaNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn, INDUSTRY );
		handleDropdown(IndustryDropDwn, TYPE);
		SaveBtn.click();
	
}
}