package tatocActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FrameDungeonActions {
	
	WebDriver driver;
	String FD_URL = "http://10.0.1.86/tatoc/basic/frame/dungeon";
	
	@FindBy(how = How.CSS, using = ".page h1")
	WebElement label_FrameDungeon;
	
	@FindBy(how = How.LINK_TEXT, using = "Repaint Box 2")
	WebElement rePaintBox2;
	
	@FindBy(how = How.CSS, using = "#main")
	WebElement mainFrame;
	
	@FindBy(how = How.CSS, using = "#child")
	WebElement childFrame;
	
	@FindBy(how = How.XPATH, using  = "//div[@id='answer' and text()='Box 1']")
	WebElement box1;
	
	@FindBy(how = How.XPATH, using  = "//div[@id='answer' and text()='Box 2']")
	WebElement box2;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Proceed']")
	WebElement lnk_Proceed;
	
	public FrameDungeonActions(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void verify_Frame_Dungeon_Page()
	{
		label_FrameDungeon.isDisplayed();
		System.out.println("Frame Dungeon label is displayed on the page");
		Assert.assertTrue(driver.getCurrentUrl().equals(FD_URL));
		System.out.println("User is on correct URL");
	}
	
	public void switch_To_Main_Frame()
	{
		driver.switchTo().frame(mainFrame);
		System.out.println("User is in main frame");
	}
	
	public void switch_To_Child_Frame()
	{
		//switch_To_Main_Frame();
		driver.switchTo().frame(childFrame);
		System.out.println("User is in child frame");
	}
	
	public void switch_To_Default_Frame()
	{
		driver.switchTo().defaultContent();
		System.out.println("User is in default frame");
	}
	
	public void click_On_Repaint_Box_2_Link()
	{
		//switch_To_Main_Frame();
		rePaintBox2.click();
	}
	
	public void match_Color_Of_Boxes()
	{
		switch_To_Main_Frame();
		String color_Box1 = box1.getAttribute("class");
		System.out.println("Color of Box1 is " + color_Box1);
		switch_To_Child_Frame();
		String color_Box2 = box2.getAttribute("class");
		System.out.println("Color of Box1 is " + color_Box2);
		
		do {
			switch_To_Default_Frame();
			switch_To_Main_Frame();
			click_On_Repaint_Box_2_Link();
			switch_To_Child_Frame();
			color_Box2 = box2.getAttribute("class");
			//System.out.println(color_Box2);
		}
		while(!color_Box1.equals(color_Box2));
	}
	
	public void click_On_Proceed_Link()
	{
		switch_To_Default_Frame();
		switch_To_Main_Frame();
		lnk_Proceed.click();
		System.out.println("User has clicked on Proceed link");
	}
}
