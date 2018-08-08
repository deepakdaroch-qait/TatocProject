package QAIT.TatocProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Remote_Run {
	
	public static WebDriver driver;
	 
	@BeforeClass
	public static void test() throws MalformedURLException, InterruptedException
	{
 
 		String URL = "http://www.google.com";
 		String Node = "http://10.0.31.227:4444/wd/hub";
 		DesiredCapabilities cap = DesiredCapabilities.chrome();
 
 		driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
	}
	
	@Test
	public static void print()
	{
		System.out.println("Hello World");
	}

}
