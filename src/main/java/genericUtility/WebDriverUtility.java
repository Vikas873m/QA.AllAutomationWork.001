package genericUtility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of all generic methods related to web driver actions
 * @author Vikas
 *
 */

public class WebDriverUtility
{
	/**
	 * This method will be maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method will be minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver) 
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will be wait for a particular element to be visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) 
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will be wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, By element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method handle dropdown by index
	 * @param element
	 * @param index
	 * @param Index 
	 */
	public void handleDropdown(WebElement element,  int Index) 
	{
		Select sel=new Select(element);
		sel.selectByIndex(Index);
	}
	
	/**
	 *  this method handle dropdown by value
	 * @param element
	 * @param Value
	 */
	public void handleDropdown(WebElement element, String Value) 
	{
		Select sel=new Select(element);
		sel.selectByValue(Value);
	

}
	/**
	 *  this method handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown( String text,WebElement element ) 
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hovering actions
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will move the cursor based on offset and click on web page
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10,10 ).click().perform();
	}
	/**
	 * this method will perform right click
	 * @param driver
	 */
	public void righClickAction(WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}
	/**
	 * this method will perform double click
	 * @param driver
	 */
	public void dubbleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will perform drag and drop operation
	 * @param driver
	 * @param scrEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver, WebElement scrEle, WebElement dstEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(scrEle, dstEle);
	}
	/**
	 * This method will handle Frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}
		
	/**
	 * This method will handle Frame by name or ID
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String NameOrID) 
	{
		driver.switchTo().frame(NameOrID);
		
	}
	/**
	 * This method will handle Frame by WebElement
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element) 
	{
		driver.switchTo().frame(element);
		
	}
	/**this method will scroll down by 500 Units
	 * 
	 * @param driver
	 */
	public void ScrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**this method will scroll Up by 500 Units
	 * 
	 * @param driver
	 */
	public void ScrollUpAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500)", "");
	}
	/**
	 * This Method will accept the alert popup
	 * @param driver
	 */
	public void accpetAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();;
	}
	/**
	 * This Method will cancel the alert popup
	 * @param driver
	 */
	public void cancleAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert text and return it to caller
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will take screenshot and return the dst path
	 * @param TakesScreenshot 
	 * @param <TakesScreenshot>
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE); // temporary location
		File dst = new File(".\\ScreenShot\\"+screenshotName+".png" ); 
		                                    // Scenario1.png
		Files.copy(src, dst);
		return dst.getAbsolutePath(); //used for extent reports
	} 
	/** This method will switch from one window to another based on Window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) 
	{
		//step1:get all the Window IDs
		Set<String> allwinIds = driver.getWindowHandles();
		
		//step2:navigate through each window
		for(String WinIds:allwinIds) 
		{
			//step3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(WinIds).getTitle();
			
			//step4: Compare act title with expected partial title
			if(actTitle.contains(partialWinTitle)) 
			{
				break;
			}
		}
	}
		
}