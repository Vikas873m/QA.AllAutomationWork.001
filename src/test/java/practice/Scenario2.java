package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 
{


	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		driver.findElement(By.xpath("//td[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='small' and @valign='bottom'])[1]")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();

	}
}
