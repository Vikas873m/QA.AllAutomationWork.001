package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class Scenario1Test {
@Test
	public static void main(String[] args) throws InterruptedException {
		
		//step1: to lunch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2: to load the application
		driver.get("http://localhost:8888");
		
		// step3: login to the application
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		
		WebElement login = driver.findElement(By.id("submitButton"));
		login.click();
		
		//step4: create contact link
		WebElement contact = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contact.click();
		
		 //step5: navigate to  plus contact look up icon
		WebElement plus = driver.findElement(By.xpath("//img[@alt='Create Contact...']"));
		plus.click();
		
	   //step: create contact
		WebElement lstname = driver.findElement(By.name("lastname"));
		lstname.sendKeys("Mishra");
		
		//step7: save
		driver.findElement(By.name("button")).click();
		
		//step8 : validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if( contactHeader.contains("Mishra")) {
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
		
		// ste9: logout 
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions lo = new Actions(driver);
		lo.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout is successful");
	}
}
