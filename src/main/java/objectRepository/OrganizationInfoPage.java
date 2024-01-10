package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgaHeaderText;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgaHeaderText() {
		return OrgaHeaderText;
	}
	
	//Business Library
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	public String getHeaderText() {
		return OrgaHeaderText.getText();
	}
}
