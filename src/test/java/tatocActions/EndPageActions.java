package tatocActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class EndPageActions {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class='page']/h1[text()='End']")
	WebElement lbl_End;
	
	@FindBy(how = How.XPATH, using = "//span[@class='finish']")
	WebElement lbl_completeCourse;
	
	public EndPageActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verify_End_Tatoc_Page()
	{
		lbl_End.isDisplayed();
		System.out.println("User is on 'End TATOC' page");
		Assert.assertEquals(lbl_completeCourse.getText(), "Obstacle Course is Complete!");
		System.out.println("Congrats, you have completetly Automated TATOC Basic Course");
	}

}
