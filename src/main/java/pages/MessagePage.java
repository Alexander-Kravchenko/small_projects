package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by akravchenko on 05.02.19.
 */
public class MessagePage extends BasePage {

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@name='to']")
    WebElement toField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    WebElement bodyField;

    @FindBy(xpath = "//div[text()='Send']")
    WebElement sendButton;

    public void typeToField(String recipient){
        toField.sendKeys(recipient);
    }

    public void typeSubjectField(String subject){
        subjectField.sendKeys(subject);
    }

    public void typeBodyField(String bodyText){
        bodyField.sendKeys(bodyText);
    }

    public void sendMessage(){
        sendButton.click();
    }

}
