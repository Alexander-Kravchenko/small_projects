package gmail;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MessagePage;
import pages.MessagesListPage;
import utils.PropertyLoader;

import java.io.IOException;

/**
 * Created by akravchenko on 05.02.19.
 */
public class ChromeTests extends BaseTest{


    String subject = "test email";
    String messageBody = "some text";

    @Test
    public void first_checkLogin(){
        MessagesListPage messagesListPage = new MessagesListPage(getDriver());
        messagesListPage.waitForCreateNewEmailButton();
    }

    @Test
    public void second_sendAnEmail() throws IOException{
        String email_address = PropertyLoader.loadProperty("login");
        MessagesListPage messagesListPage = new MessagesListPage(getDriver());
        MessagePage newMessagePage = new MessagePage(getDriver());

        messagesListPage.clickCreateNewEmailButton();

        newMessagePage.typeToField(email_address);
        newMessagePage.typeSubjectField(subject);
        newMessagePage.typeBodyField(messageBody);
        newMessagePage.sendMessage();
        messagesListPage.checkNotification("Message sent.");
    }

    @Test
    public void third_deleteEmail(){

        MessagesListPage messagesListPage = new MessagesListPage(getDriver());

        messagesListPage.selectTheEmail(subject);
        int countBeforeRemoving = messagesListPage.getMessagesCount(subject);
        messagesListPage.clickDeleteButton();
        messagesListPage.checkNotification("Conversation moved to Trash.");
        messagesListPage.clickRefreshButton();
        int countAfterRemoving = messagesListPage.getMessagesCount(subject);
        Assert.assertEquals(countBeforeRemoving,countAfterRemoving + 1);

    }

    @BeforeMethod(alwaysRun = true)
    public void before() throws IOException {

        String email_address = PropertyLoader.loadProperty("login");
        String password = PropertyLoader.loadProperty("password");

        LoginPage loginPage = new LoginPage(getDriver());

        getDriver().navigate().to("http://www.gmail.com");

        loginPage.typeLogin(email_address);
        loginPage.nextLoginButtonClick();

        loginPage.typePassword(password);
        loginPage.nextPasswordButtonClick();

    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        LoginPage loginPage = new LoginPage(getDriver());
        MessagesListPage messagesListPage = new MessagesListPage(getDriver());

        messagesListPage.clickGoogleAccountButton();
        messagesListPage.clickSignOutButton();
    }


}
