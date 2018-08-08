package QAIT.TatocProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remote_Run {
	
	public static WebDriver driver;
	 
	public static void main(String[]  args) throws MalformedURLException, InterruptedException{
 
 		String URL = "http://www.google.com";
 		String Node = "http://10.0.31.227:4444/wd/hub";
 		DesiredCapabilities cap = DesiredCapabilities.chrome();
 
 		driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();
	}

}
