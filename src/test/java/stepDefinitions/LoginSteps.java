package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {
	WebDriver driver = null;
	@Given("User has opened swag labs browser")
	public void user_has_opened_swag_labs_browser() {
		   System.setProperty("webdriver.chrome", "/Users/x230-Thinkpad/eclipse-workspace/Batch1WeekendClass/src/test/resources/Drivers/chromedriver.exe");
		   ChromeOptions options = new ChromeOptions();
		   options.addArguments("--remote-allow-origins=*");
		   
		   driver = new ChromeDriver(options);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		   
		   driver.manage().window().maximize();
		   driver.navigate().to("https://www.saucedemo.com/");
	}
	
	
	@Given("User has navigated to the login page")
	public void user_has_navigated_to_the_login_page() {
		   
		   driver.navigate().to("https://www.saucedemo.com/");
	}

	
	//TCID001 (positive case)
	@When("User enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
	driver.findElement(By.id("user-name")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	Thread.sleep(2000);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   driver.findElement(By.id("login-button")).click();
	}

	@Then("User should be able to see Product page")
	public void user_should_be_able_to_see_product_page() {
	    driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
	driver.close();
	driver.quit();
	}

	//TCID002 (negatif case)

	@When("User enters invalid (.*) and (.*)$")
	public void user_enters_invalid_username_and_password (String username, String password) throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
Thread.sleep(2000);
	}

	@Then("User should be able to see the error pop up message")
	public void user_should_be_able_to_see_the_error_pop_up_message() throws InterruptedException {
	   driver.findElement(By.xpath("//button[@class='error-button']")).isDisplayed(); 
	Thread.sleep(2000);
	driver.close();
	driver.quit();
	}

}
