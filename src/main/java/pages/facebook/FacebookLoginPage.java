package pages.facebook;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class FacebookLoginPage extends AbstractPage {

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#pass")
    WebElement passwordField;

    @FindBy(css = "#u_0_2")
    WebElement logInButton;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public FacebookLoginPage openFacebookLogIn(String url) {
        driver.get(url);
        return new FacebookLoginPage(driver);
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
