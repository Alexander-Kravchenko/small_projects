package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by akravchenko on 05.02.19.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "identifierId")
    WebElement loginNameField;

    @FindBy(id = "identifierNext")
    WebElement nextLoginButton;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(id = "passwordNext")
    WebElement nextPasswordButton;


    public void typeLogin(String loginName){
        loginNameField.sendKeys(loginName);
    }

    public void typePassword(String password){
        this.waitForElementToAppear(By.id("password"));
        passwordField.sendKeys(password);
    }

    public void nextLoginButtonClick(){
        nextLoginButton.click();
    }

    public void nextPasswordButtonClick(){
        nextPasswordButton.click();
    }

    public void login(String loginName, String password){

    }

}
