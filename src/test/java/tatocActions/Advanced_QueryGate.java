package tatocActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mysql.jdbc.Statement;

public class Advanced_QueryGate {
	
	WebDriver driver;
	
	@FindBy(how = How.CSS, using = ".page>h1")
	WebElement lbl_QueryGate;
	
	@FindBy(how = How.CSS, using = "#symboldisplay")
	WebElement symbol;
	
	@FindBy(how = How.CSS, using = "#name")
	WebElement input_Name;
	
	@FindBy(how = How.CSS, using = "#passkey")
	WebElement input_Password;
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DB_URL = "10.0.1.86";
	private String username = "tatocuser";
	private String password = "tatoc01";
	private Connection con;
	String txt_Symbol;
	
	@FindBy(how = How.CSS, using = "#submit")
	WebElement submit;
	
	public Advanced_QueryGate(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void verify_Query_Gate_Page()
	{
		lbl_QueryGate.isDisplayed();
		System.out.println("User is on 'Query Gate' page");
	}
	
//	public void get_Symbol()
//	{
//		txt_Symbol = symbol.getText();
//	}
	
	public void create_JDBC_Connection() throws InstantiationException, IllegalAccessException
	{
		try {
			txt_Symbol = symbol.getText();
			System.out.println(txt_Symbol);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection(DB_URL, username, password);
			
			java.sql.Statement st = con.createStatement();
			ResultSet result = st.executeQuery("Select username from identity where Symbol='" + txt_Symbol +"'");
			System.out.println(result.getNString("Name"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
