package pages.facebook;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import static org.junit.Assert.assertTrue;


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
        assertTrue(driver.getTitle().toLowerCase().contains("facebook"));
    }
    public FacebookUserPage enterCredsForFacebookAccount(String mail, String pass) {
        emailField.clear();
        emailField.sendKeys(mail);
        passwordField.clear();
        passwordField.sendKeys(pass);
        logInButton.click();
        return new FacebookUserPage(driver);

    }
}
