package tatocActions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PopUpWindowsActions {
	
	WebDriver driver;
	String originalHandle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/h1[text()='Popup Windows']")
	WebElement label_PopupWindows;
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/a[contains(text(), 'Launch')]")
	WebElement lnk_LaunchPopup;
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/a[contains(text(), 'Proceed')]")
	WebElement lnk_Proceed;
	
	@FindBy(how = How.CSS, using = "#name")
	WebElement input_Name;
	
	@FindBy(how = How.CSS, using = "#submit")
	WebElement btn_Submit;
	
	public PopUpWindowsActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verify_Popup_Windows_Homepage()
	{
		label_PopupWindows.isDisplayed();
		System.out.println("User is on Popup Windows page");
	}
	
	public void click_On_Launch_Popup_Window_Link()
	{
		lnk_LaunchPopup.click();
		System.out.println("User has clicked on 'Launch Popup Window");
	}
	
	public void switch_Window()
	{
		originalHandle = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for(String winHandle : handle)
		{
			driver.switchTo().window(winHandle);
			System.out.println("User is on newly opened tab");
		}		
	}
	
	public void enter_Name_And_Submit_Popup()
	{
		input_Name.clear();
		input_Name.sendKeys("Deepak");
		System.out.println("Entered name in textbox");
		btn_Submit.click();
		System.out.println("User has clicked on 'Submit' button");
	}
	
	public void switch_To_Main_Window()
	{
		driver.switchTo().window(originalHandle);
		verify_Popup_Windows_Homepage();
		System.out.println("User is on 'Popup Windows' page");
	}
	
	public void click_On_Proceed_Link()
	{
		lnk_Proceed.click();
		System.out.println("User has clicked on 'Proceed' link");
	}

}
