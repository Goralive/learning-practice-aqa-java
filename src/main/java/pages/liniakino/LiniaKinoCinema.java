package pages.liniakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import static org.assertj.core.api.Assertions.*;


public class LiniaKinoCinema extends AbstractPage {
    protected LiniaKinoCinema(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.show.actual")
    WebElement elementAvaliableSession;

    public void mainPage(String url) {
        driver.get(url);
        assertThat(url).contains(driver.getCurrentUrl());
    }

    public SchemeOfHall openFistActualMovie() {
        wait.until(ExpectedConditions.elementToBeClickable(elementAvaliableSession));
        elementAvaliableSession.click();
        return new SchemeOfHall(driver);
    }
}
