package pages.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static org.assertj.core.api.Assertions.*;


public class FacebookLoginPage extends AbstractPage {

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#pass")
    WebElement passwordField;

    @FindBy(css = "[data-testid='royal_login_button']")
    WebElement logInButton;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public void openFacebookLogIn(String url) {
        driver.get(url);
    }

    public FacebookUserPage enterCredsForFacebookAccount(String mail, String pass) {
        emailField.clear();
        emailField.sendKeys(mail);
        passwordField.clear();
        passwordField.sendKeys(pass);
        logInButton.click();
        return new FacebookUserPage(driver);
    }

    public boolean isPageLoaded() {
        return emailField.isDisplayed()
                && passwordField.isDisplayed()
                && logInButton.isDisplayed()
                && driver.getTitle().toLowerCase().contains("facebook")
                && driver.getCurrentUrl().toLowerCase().contains("facebook");
    }
}
