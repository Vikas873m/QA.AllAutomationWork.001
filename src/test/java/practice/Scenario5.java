package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 
{

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Mishra1");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		Thread.sleep(2000);
		String mainwin=driver.getWindowHandle();
		System.out.println(mainwin);
		Set<String> allwin = driver.getWindowHandles();
		//System.out.println(allwin);
		
		for(String a: allwin)
		{
			if(!mainwin.equals(a))
			{
				driver.switchTo().window(a);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[.='TCS']")).click();
			}
		}
		driver.switchTo().window(mainwin);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		driver.findElement(By.xpath("(//td[@class='small' and @valign='bottom'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		

	}

}
