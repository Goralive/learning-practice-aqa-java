package pages.facebook;

import core.WebDriverTestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GetLastMessageFromFacebookMessengerTest extends WebDriverTestBase {

    //TODO make cucumber scenario

    /**
     * 1. Open browser
     * 2. Open https://www.facebook.com/
     * 3. Enter login (email) in the login field
     * 4. Enter the password in the password field
     * 5. Press the “Login” button
     * 6. Open messages
     * 7. Get the text of the last message (the most recent)
     * 8. Print the last message to the console.
     */

    private FacebookLoginPage facebookLoginPage;


    @Test
    public void getLastMessage() {
        facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.openFacebookLogIn("https://www.facebook.com");
        FacebookUserPage facebookUserPage = facebookLoginPage.enterCredsForFacebookAccount("will14ka@gmail.com", "QA14DAXX");
        facebookUserPage.profileLoading();
        facebookUserPage.getLastMessege();
    }
}
