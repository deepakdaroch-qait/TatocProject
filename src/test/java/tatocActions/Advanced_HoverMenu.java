package tatocActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Advanced_HoverMenu {
	
	WebDriver driver;
	
	public Advanced_HoverMenu(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/h1[text()='Hover Menu']")
	WebElement lbl_HoverMenu;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'menutop')]")
	WebElement tab_menu2;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'menutop')]/span[text()='Go Next']")
	WebElement lnk_goNext;
	
	public void verify_Hover_Menu_Page()
	{
		lbl_HoverMenu.isDisplayed();
		System.out.println("User is on 'Hover Menu' page");
	}
	
	public void hover_Over_Menu2_And_Click_Go_Next_Link()
	{
		Actions action = new Actions(driver);
		action.moveToElement(tab_menu2).build().perform();
		lnk_goNext.click();	
		
	}

}
