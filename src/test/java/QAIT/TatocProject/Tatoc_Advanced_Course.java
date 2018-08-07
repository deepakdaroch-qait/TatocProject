package QAIT.TatocProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tatocActions.Advanced_HoverMenu;
import tatocActions.Advanced_QueryGate;
import tatocActions.TatocHomePageActions;

public class Tatoc_Advanced_Course {
	
	WebDriver driver;
	String url = "http://10.0.1.86/tatoc"; 
	TatocHomePageActions home;
	Advanced_HoverMenu hover;
	Advanced_QueryGate queryGate;
	
	@BeforeClass
	public void initiate_Driver()
	{
		String str = "E:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", str);
		driver = new ChromeDriver();
		driver.get(url);
		home = PageFactory.initElements(driver, TatocHomePageActions.class);
		hover = PageFactory.initElements(driver, Advanced_HoverMenu.class);
		queryGate = PageFactory.initElements(driver, Advanced_QueryGate.class);
	}
	
	@Test(priority=1)
	public void click_On_Advanced_Course_Link()
	{
		home.click_On_Advanced_Course_Link();
	}
	
	@Test(priority=2)
	public void click_On_Go_Next_Link_On_Hover_Menu_Page() throws InstantiationException, IllegalAccessException
	{
		hover.verify_Hover_Menu_Page();
		hover.hover_Over_Menu2_And_Click_Go_Next_Link();
		queryGate.verify_Query_Gate_Page();
		queryGate.create_JDBC_Connection();
	}

}
