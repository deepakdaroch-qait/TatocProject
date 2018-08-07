package tatocActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Date_Picker {

	WebDriver driver;
	private String url = "https://qa.hbsp.harvard.edu";

	@BeforeClass
	public void initiateBrowser()
	{
		String exePath = "E:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	}
	
	@Test
	public void Step01()
	{
		driver.get(url);
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		driver.findElement(By.id("desktopSignInButton")).click();
		driver.findElement(By.name("email")).sendKeys("rashmi.solanki@hbr.org");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button//span[text()='LOGIN']")).click();
		
		driver.findElement(By.cssSelector(".search")).click();
		driver.findElement(By.cssSelector(".search")).sendKeys("4040");
		driver.findElement(By.xpath("(//button[contains(@class, 'search-button')])[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Add To Coursepack']")).click();
		driver.findElement(By.xpath("//a[text()='Create New Coursepack']")).click();
	}
}
