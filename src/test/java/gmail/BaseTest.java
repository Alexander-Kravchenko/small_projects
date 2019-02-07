package gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.PropertyLoader;

import java.io.IOException;

/**
 * Created by akravchenko on 05.02.19.
 */
public class BaseTest {

    protected WebDriver driver;
    protected static String browser;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() throws IOException {

        browser = PropertyLoader.loadProperty("browser");

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        } else {
            throw new Error("Unknown browser " + browser);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        if(driver != null) {
            driver.quit();        }
    }


    public WebDriver getDriver() {
        return driver;
    }

}
