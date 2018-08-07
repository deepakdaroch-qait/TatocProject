package tatocActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class GridGatePageActions {
	
	WebDriver driver;
	
	public GridGatePageActions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void launch_Grid_Gate_URL()
	{
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
	}
	
	public void verify_User_Is_On_Grid_Gate_Page()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.0.1.86/tatoc/basic/grid/gate");
		System.out.println("User is on Grid Gate page");
	}
	
	public void verify_Title_Of_Grid_Gate_Page()
	{
		String title = driver.findElement(By.xpath("//div[@class='page']/h1[text()='Grid Gate']")).getText();
		Assert.assertEquals(title, "Grid Gate");
		System.out.println("Title of the page is " + title);
	}
	
	public void click_On_Green_Grid() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td/div"));
		for(WebElement element : list)
		{
			String color = element.getAttribute("class");
			if(color.equals("greenbox"))
			{
				element.click();
				break;
			}
		}
	}

}
