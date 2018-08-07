package tatocActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DragAroundActions {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/h1[text()='Drag Around']")
	WebElement label_DragAround;
	
	@FindBy(how = How.CSS, using = ".ui-draggable")
	WebElement btn_DragMe;
	
	@FindBy(how = How.CSS, using = "#dropbox")
	WebElement dropbox;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Proceed']")
	WebElement lnk_Proceed;
	
	public DragAroundActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verify_Drag_Around_Homepage()
	{
		label_DragAround.isDisplayed();
		System.out.println("Label 'Drag Around' is displayed");
	}
	
	public void drag_Button_Into_Box()
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(btn_DragMe, dropbox).build().perform();
		System.out.println("Drag and Drop complete");
	}
	
	public void click_On_Proceed_Button()
	{
		lnk_Proceed.click();
		System.out.println("User has clicked on Proceed button on Drag Around page");
	}

}
