package tatocActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CookieHandlingActions {
	
	WebDriver driver;
	
	@FindBy(how = How.CSS, using = ".page>h1")
	WebElement label_CookieHandling;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Generate Token']")
	WebElement lnk_GenerateToken;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Proceed']")
	WebElement lnk_Proceed;
	
	@FindBy(how = How.XPATH, using = "//span[@id='token']")
	WebElement lbl_token;
	
	String rawtokenValue;
	String token;
	
	public CookieHandlingActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verify_Cookie_Handling_Page()
	{
		label_CookieHandling.isDisplayed();
		System.out.println("User is on 'Cookie Handling' page");
	}
	
	public void click_On_Generate_Token_Link()
	{
		lnk_GenerateToken.click();
		System.out.println("User has clicked on 'Generate Token' link");
	}
	
	public void verify_Token_Is_Generated()
	{
		rawtokenValue = lbl_token.getText();
		System.out.println(rawtokenValue);
		String splitToken[] = rawtokenValue.split(":");
		for(String string : splitToken)
		{
			System.out.println(string.trim());
			if(!string.equals("Token"))
			{
				token = string.trim();
				System.out.println("Token value is " + token);
			}
		}
	}
	
	public void create_And_Add_Cookie()
	{
		System.out.println("Cookie has been added=========="+token);
		Cookie cookie = new Cookie("cookieToken", token);
		driver.manage().addCookie(cookie);
		System.out.println("Cookie has been added");
	}
	
	public void click_On_Proceed_Link()
	{
		lnk_Proceed.click();
		System.out.println("User has clicked on 'Proceed' link");
	}

}
