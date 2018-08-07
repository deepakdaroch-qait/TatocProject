package tatocActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TatocHomePageActions {
	
	WebDriver driver;
	@FindBy(how = How.CSS, using="div.page a:first-of-type") 
	WebElement basic;
	
	public TatocHomePageActions(WebDriver driver) {
		
		this.driver = driver;
	}
	/*
	 * Base methods
	 */
	
	public void launchURL(String URL)
	{
		driver.get(URL);
		System.out.println("URL launched");
	}
	
	public void verify_Element_On_Page(String locatorType, String locator)
	{
		if(locatorType.equals("id"))
		{
			driver.findElement(By.id(locator)).isDisplayed();
		}
		if(locatorType.equals("name"))
		{
			driver.findElement(By.name(locator)).isDisplayed();
		}
		if(locatorType.equals("class"))
		{
			driver.findElement(By.className(locator)).isDisplayed();
		}
		if(locatorType.equals("xpath"))
		{
			driver.findElement(By.xpath(locator)).isDisplayed();
		}
		
		System.out.println(locator + " is displayed on the page");
	}
	
	public void click_Element_On_Page(String locatorType, String locator)
	{
		if(locatorType.equals("id"))
		{
			driver.findElement(By.id(locator)).click();
		}
		if(locatorType.equals("name"))
		{
			driver.findElement(By.name(locator)).click();
		}
		if(locatorType.equals("class"))
		{
			driver.findElement(By.className(locator)).click();
		}
		if(locatorType.equals("xpath"))
		{
			driver.findElement(By.xpath(locator)).click();
		}
		
		System.out.println(locator + " is displayed on the page");
	}
	
	public WebElement get_Basic_Course_Link()
	{
		//return driver.findElement(By.xpath("//div[@class='page']/a[contains(text(), 'Basic Course')]"));
		return driver.findElement(By.xpath("//a[@href='/tatoc/basic']"));
	}
	
	public WebElement get_Advanced_Course_Link()
	{
		return driver.findElement(By.xpath("//div[@class='page']/a[contains(text(), 'Advanced Course')]"));
	}
	
	
	/*
	 * Main methods
	 */
	public void launch_Tatoc_URL()
	{
		launchURL("http://10.0.1.86/tatoc");
	}
	
	public void verify_Title_Of_HomePage() {
		verify_Element_On_Page("class", "title");
	}
	
	public void is_Basic_Course_Link_Displayed()
	{
		get_Basic_Course_Link().isDisplayed();
		System.out.println(get_Basic_Course_Link().getText() + " link is displayed");
	}
	
	public void is_Advanced_Course_Link_Displayed()
	{
		get_Advanced_Course_Link().isDisplayed();
		System.out.println(get_Advanced_Course_Link().getText() + "link is displayed");
	}
	
	public void verify_Elements_On_Tatoc_Homepage()
	{
		verify_Title_Of_HomePage();
		is_Basic_Course_Link_Displayed();
		is_Advanced_Course_Link_Displayed();
		
		System.out.println("All the elements are displayed on Tatoc homepage");
	}
	
	public void click_On_Basic_Course_Link() throws InterruptedException
	{
		//click_Element_On_Page("xpath", "//div[@class='page']/a[contains(text(), 'Basic Course')]");
//		driver.findElement(By.xpath("//div[@class='page']/a[contains(text(), 'Basic Course')]"));
//		get_Basic_Course_Link().click();
		//driver.findElement(By.linkText("Basic Course"));
		Thread.sleep(2000);
		get_Basic_Course_Link().click();
		System.out.println("User has clicked on 'Basic Course' link");
	}
	
	public void click_On_Advanced_Course_Link()
	{
		get_Advanced_Course_Link().click();
		System.out.println("User has clicked on 'Advanced Course' link");
	}

}
