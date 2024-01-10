package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // rule1

	//rule 2 - declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath ="//input[@type='submit']")})
     private WebElement loginBtn;
	
	// Rule3 : Initialization 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	// rule4 : Utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Business Library - generic methods according to the need of project
	/**
	 * this method will login the application 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
