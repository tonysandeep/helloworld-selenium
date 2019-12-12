package stepDefinition; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And; 
import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When; 

public class stepDef
{
WebDriver driver;

@Given("^landing page is loaded$")
public void landing_page_is_loaded() throws Throwable {
    //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\windows\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver","C:\\Users\\tonysn7\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver(); 
    driver.manage().window().maximize(); 
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    driver.get("http://34.93.179.229:8081/winagenttest/");
    DesiredCapabilities capability = DesiredCapabilities.chrome();
    //driver = new RemoteWebDriver(new URL("http://35.200.254.176:4444/wd/hub"), capability);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    //driver.get("http://34.93.73.51:8080/helloworld/");
    //driver.get("http://34.93.220.37:8080/singlepagewebapp/");
}

@Given("^click sign in$")
public void click_sign_in() throws Throwable {
    driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
}

@When("^enter email address$")
public void enter_email_address() throws Throwable {
	driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/form/div/div[1]/input")).sendKeys("example@host.com");
}

@Then("^click sign up$")
public void click_sign_up() throws Throwable {
	driver.findElement(By.xpath("//button[.='Sign up!']")).click();
}

@After
public void afterAction(Scenario scenario)
{driver.quit();}


}
