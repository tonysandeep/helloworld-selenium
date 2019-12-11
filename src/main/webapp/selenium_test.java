import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import java.util.concurrent.TimeUnit;
 
/**
 * Created by TripleQA
 */
 
public class DemoSelenium {
 
    private WebDriver driver;
 
    @BeforeClass
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @Test(testName = "helloWorld")
    public void tstHelloWorldGoogle() throws InterruptedException {
        driver.get("http://www.google.com/xhtml");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TripleQA hello world");
        searchBox.submit();
        //Deliberately adding pause
        Thread.sleep(15000);
    }
 
    @AfterClass
    public void cleanup(){
        if(driver !=null)
            driver.quit();
    }
}
