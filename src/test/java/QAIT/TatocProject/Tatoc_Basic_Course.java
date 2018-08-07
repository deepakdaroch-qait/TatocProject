package QAIT.TatocProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tatocActions.CookieHandlingActions;
import tatocActions.DragAroundActions;
import tatocActions.EndPageActions;
import tatocActions.FrameDungeonActions;
import tatocActions.GridGatePageActions;
import tatocActions.PopUpWindowsActions;
import tatocActions.TatocHomePageActions;


public class Tatoc_Basic_Course 
{
	WebDriver driver;
	TatocHomePageActions tatochp;
	GridGatePageActions gg;
	FrameDungeonActions FD;
	DragAroundActions drag;
	PopUpWindowsActions popUp;
	CookieHandlingActions cookie;
	EndPageActions end;
	
	@BeforeClass
	public void initiateBrowser()
	{
		String exePath = "E:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		tatochp = new TatocHomePageActions(driver);
		gg = new GridGatePageActions(driver);
		FD = PageFactory.initElements(driver, FrameDungeonActions.class);
		drag = PageFactory.initElements(driver, DragAroundActions.class);
		popUp = PageFactory.initElements(driver, PopUpWindowsActions.class);
		cookie = PageFactory.initElements(driver, CookieHandlingActions.class);
		end = PageFactory.initElements(driver, EndPageActions.class);
	}
	
	@Test(priority=1)
	public void verify_User_Is_On_Tatoc_Homepage()
	{
		tatochp.launch_Tatoc_URL();
		tatochp.verify_Elements_On_Tatoc_Homepage();
	}
	
	@Test(priority=2)
	public void click_On_Basic_Course_Link() throws InterruptedException
	{
		tatochp.click_On_Basic_Course_Link();
	}
	
	@Test(priority=3)
	public void click_On_Green_Box_On_Grid_Gate() throws InterruptedException
	{
//		gg.launch_Grid_Gate_URL();
		gg.verify_User_Is_On_Grid_Gate_Page();
		gg.verify_Title_Of_Grid_Gate_Page();
		gg.click_On_Green_Grid();
	}
	
	@Test(priority=4)
	public void verify_Color_Of_Boxes_Match()
	{
		FD.verify_Frame_Dungeon_Page();
		FD.match_Color_Of_Boxes();
		FD.click_On_Proceed_Link();
		drag.verify_Drag_Around_Homepage();
	}
	
	@Test(priority=5)
	public void Drag_And_Drop_Button()
	{
		drag.drag_Button_Into_Box();
		drag.click_On_Proceed_Button();
	}
	
	@Test(priority=6)
	public void Launch_Popup_And_Submit_Form()
	{
		popUp.verify_Popup_Windows_Homepage();
		popUp.click_On_Launch_Popup_Window_Link();
		popUp.switch_Window();
		popUp.enter_Name_And_Submit_Popup();
		popUp.switch_To_Main_Window();
		popUp.click_On_Proceed_Link();
	}
	
	@Test(priority=7)
	public void Generate_Token_And_Cookie()
	{
		cookie.verify_Cookie_Handling_Page();
		cookie.click_On_Generate_Token_Link();
		cookie.verify_Token_Is_Generated();
		cookie.create_And_Add_Cookie();
		cookie.click_On_Proceed_Link();
	}
	
	@Test(priority=8)
	public void Verify_End_Page_And_Complete_Basic_Course()
	{
		end.verify_End_Tatoc_Page();
	}
	
	
	
	@AfterClass
	public void close_Browser()
	{
		driver.quit();
	}
    
}
