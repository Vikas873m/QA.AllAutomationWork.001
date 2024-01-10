package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration - dropdowns,frames,windows, textFields,popups
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	// initialization 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization 

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	// Business Library 
	/**
	 * this method will click on organization link
	 */
	public void clickOnOrganizationLink() {
		organizationLnk.click();
		
	}
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactsLink() {
		contactsLnk.click();
	}
	/**
	 * this method will logout the application 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutLink.click();
	}
}
