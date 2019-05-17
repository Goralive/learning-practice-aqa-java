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

    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(postField));
        } catch (TimeoutException e) {
            log.info("Locator of the post field isn't visible: {}", e.fillInStackTrace());
        }
        return postField.isDisplayed()
                && messangerBtn.isDisplayed()
                && driver.getTitle().toLowerCase().contains("facebook");
    }

    public void getLastMessege() {
        wait.until(ExpectedConditions.elementToBeClickable(messangerBtn));
        messangerBtn.click();
        wait.until(ExpectedConditions.visibilityOf(friendsMessages));
        log.info("The first message from messenger is: {}", friendsMessages.getText());
    }
}


