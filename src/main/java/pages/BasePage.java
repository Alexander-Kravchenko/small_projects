package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by akravchenko on 05.02.19.
 */
public class BasePage {
    private static final int TIMEOUT = 30;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        this.driver.manage().window().maximize();
    }

    protected void waitForElementToAppear(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForWebelementToDisappear(WebElement element) {
        this.wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForWebelementToAppear(WebElement element){
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }
}
