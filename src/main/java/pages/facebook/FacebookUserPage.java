package pages.facebook;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class FacebookUserPage extends AbstractPage {

    @FindBy(css = "#content_container")
    WebElement postField;

    @FindBy(xpath = "//a[@name='mercurymessages']")
    WebElement messangerBtn;

    @FindBy(css = "a.messagesContent")
    WebElement friendsMessages;

    public FacebookUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean profileLoading() {
        try {
            wait.until(ExpectedConditions.visibilityOf(postField));
        } catch (TimeoutException e) {
            System.out.println("Locator isn't visible: " + e);
        }
        return true;
    }

    public FacebookUserPage getLastMessege () {
        wait.until(ExpectedConditions.elementToBeClickable(messangerBtn));
        messangerBtn.click();
        wait.until(ExpectedConditions.visibilityOf(friendsMessages));
        System.out.println(friendsMessages.getText());

        return new FacebookUserPage(driver);
    }
}


