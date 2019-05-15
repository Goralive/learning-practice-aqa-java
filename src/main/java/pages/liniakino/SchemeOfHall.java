package pages.liniakino;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SchemeOfHall extends AbstractPage {
    public SchemeOfHall(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(css = "div#hall-scheme-container div.seat"))
    List<WebElement> elementListSeat;

    @FindBy(css = "div.window-close")
    WebElement elementPopUp;

    @FindBy(css = "span.show-time > a")
    WebElement elementSelectFirstShowPopUp;

    @FindAll(@FindBy(css = "div.seat-occupied"))
    List<WebElement> elementOccupiedSeat;

    @FindAll(@FindBy(css = "div#hall-scheme-container div.seat-color1"))
    List<WebElement> elementFreeSeat;

    @FindBy(css = "iframe")
    WebElement iframePopUp;

    @FindBy(css = "button.purchase-button")
    WebElement elementBtn;

    private int allSeats;
    private int occupiedSeats;
    private int freeSeats;

    public void chooseTheMovieSession() {
        driver.switchTo().frame(iframePopUp);
        try {
            elementSelectFirstShowPopUp.isDisplayed();
            elementSelectFirstShowPopUp.click();
        } catch (NoSuchElementException e) {
            log.info("No pop-up to choose the movie session was shown");
        }
        try {
            elementPopUp.click();
        } catch (NoSuchElementException e) {
            log.info("There is no 3D popUp");
        }
    }

    public void getSeats() {
        wait.until(ExpectedConditions.visibilityOf(elementBtn));
        assertThat(elementListSeat != null).isTrue();
        allSeats = elementListSeat.size();
        occupiedSeats = elementOccupiedSeat.size();
        freeSeats = elementFreeSeat.size();
        log.info("Number of seats in the hall {}", allSeats);
        log.info("Number of occupied seats {}", occupiedSeats);
        log.info("Number of free seats {}", freeSeats);

    }

    public void seatPercentage() {
        log.info("% Of occupied seats from all seats in the hall {}%", (occupiedSeats * 100) / allSeats);
        log.info("% Empty seats from all seats in the hall {}%", (freeSeats * 100) / allSeats);
    }
}
