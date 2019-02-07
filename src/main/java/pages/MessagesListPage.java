package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by akravchenko on 05.02.19.
 */
public class MessagesListPage extends BasePage {

    public MessagesListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    WebElement createNewEmailButton;

    @FindBy(xpath = "//span[@class='T-I J-J5-Ji T-I-KE L3']")
    WebElement createNewEmailButton1;

    @FindBy(xpath="//div[@class='ar9 T-I-J3 J-J5-Ji']/ancestor::div[1]")
    WebElement deleteButton;

    @FindBy(xpath="//span[@class='gb_cb gbii']")
    WebElement googleAccountButton;

    @FindBy(xpath = "//a[@class='gb_Aa gb_Ag gb_Ig gb_ff gb_Tb']")
    WebElement signOutButton;

    @FindBy(xpath = "//div[@class='asf T-I-J3 J-J5-Ji']/ancestor::div[1]")
    WebElement refreshButton;

    public void clickCreateNewEmailButton(){
        waitForCreateNewEmailButton();
        createNewEmailButton.click();
    }

    public void selectTheEmail(String subject){
        waitForCreateNewEmailButton();
        driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::tr/td[2]", subject))).click();
    }

    public void clickDeleteButton(){
        deleteButton.click();
        this.waitForWebelementToDisappear(deleteButton);
    }

    public void clickGoogleAccountButton(){
        googleAccountButton.click();
    }

    public void clickSignOutButton(){
//        this.waitForWebelementToAppear(signOutButton);
//        signOutButton.click();
        driver.findElement(By.xpath("//a[@class='gb_Aa gb_Ag gb_Ig gb_ff gb_Tb']")).click();
    }

    public void checkNotification(String notification){
        this.waitForElementToAppear(By.xpath(String.format("//span[text()='%s']", notification)));
    }

    public void waitForCreateNewEmailButton(){
       this.waitForWebelementToAppear(createNewEmailButton);
    }

    public void waitForCreateNewEmailButton1(){
        this.waitForWebelementToAppear(createNewEmailButton1);
    }

    public int getMessagesCount(String subject){
        List<WebElement> elements = driver.findElements(By.xpath(String.format("//span[text()='%s']/ancestor::tr/td[2]", subject)));
        return elements.size();
    }

    public void clickRefreshButton(){
        refreshButton.click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
