package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMLibrary 
{
	 public static WebDriver driver;
	 public String empno;
	@Given("^i open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url)  
	{
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get(url);
	}

	@Then("^i shold see login page$")
	public void i_shold_see_login_page() 
	{
	   driver.findElement(By.id("btnLogin")).isDisplayed();
	   System.out.println("System Displayed Login Page");
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname) 
	{
	  driver.findElement(By.id("txtUsername")).sendKeys(uname); 
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword) 
	{
	  driver.findElement(By.id("txtPassword")).sendKeys(pword);  
	}

	@When("^i click login$")
	public void i_click_login() 
	{
	  driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module()
	{
	 driver.findElement(By.linkText("Admin")).isDisplayed();
	 System.out.println("System Displayed Admin Module");
	}

	@When("^i click logout$")
	public void i_click_logout() 
	{
	  driver.findElement(By.partialLinkText("Welcome")).click();
	  driver.findElement(By.linkText("Logout")).click();
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
	  driver.close();  
	}
	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
		String errmsg;
		errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		if (errmsg.contains("invalid")) 
		{
			System.out.println("System Displyed appropriate error message for invalid data");
		}
	}
	}
