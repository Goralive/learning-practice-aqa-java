package pages.imdbfilms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MovieInformationFromIMDB extends AbstractPage {


    public MovieInformationFromIMDB(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(css = "td.titleColumn a"))
    List<WebElement> movieFromList;

    public void openIMDB250Url(String url) {
        driver.get(url);
        assertThat(driver.getTitle().toLowerCase().contains("imdb top 250"));
    }

    public MovieFromList getMovieName(int i) {
        log.info("You have select movie: " + movieFromList.get(i).getText());
        wait.until(ExpectedConditions.visibilityOf(movieFromList.get(i)));
        movieFromList.get(i).click();
        assertThat(driver.getCurrentUrl().contains("top"));
        return new MovieFromList(driver);
    }
}
