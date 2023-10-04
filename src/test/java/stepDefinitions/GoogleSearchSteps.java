package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {

	

	WebDriver driver = null;
@Given("User has opened the browser")
public void user_has_opened_the_browser() {
   System.setProperty("webdriver.chrome", "/Users/x230-Thinkpad/eclipse-workspace/Batch1WeekendClass/src/test/resources/Drivers/chromedriver.exe");
   ChromeOptions options = new ChromeOptions();
   options.addArguments("--remote-allow-origins=*");
   
   driver = new ChromeDriver(options);
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
   
	
}

@When("User has navigated to google search column")
public void user_has_navigated_to_google_search_column() {
  driver.navigate().to("https://www.google.com/");
}

@When("User enters keyword")
public void user_enters_keyword() {
    driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
}

@When("User clicks enter from the keyboard")
public void user_clicks_enter_from_the_keyboard() {
	driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
}

@Then("Showing selenium.dev at the first place")
public void showing_selenium_dev_at_the_first_place() {
    driver.findElement(By.xpath("//span[text()= 'selenium.dev']")).isDisplayed();
    
}

}
