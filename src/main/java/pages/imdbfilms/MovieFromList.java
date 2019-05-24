package pages.imdbfilms;

import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MovieFromList extends AbstractPage {
    public MovieFromList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title-overview")
    WebElement webElementTitleOverview;

    @FindBy(css = "span#titleYear")
    WebElement webElementTitleYear;

    @FindBy(css = "div.txt-block time")
    WebElement webElementDuration;

    @FindBy(css = "span[itemprop='ratingValue']")
    WebElement webElementMovieRating;

    @FindBy(css = "#titleStoryLine h4.inline+a:last-of-type")
    WebElement webElementGenre;

    @FindBy(css = "div.slate > a")
    WebElement webElementTrailer;

    @FindBy(css = ".poster a")
    WebElement webElementPoster;

    @FindBy(css = "div.credit_summary_item > a:only-of-type")
    WebElement webElementFilmDirector;

    @FindAll(@FindBy(css = "td.primary_photo + td"))
    List<WebElement> webElementGetFiveActors;

    @FindBy(css = "div.metacriticScore > span")
    WebElement webElementMetascore;

    @FindBy(css = "span.subText a:nth-last-of-type(2)")
    WebElement webElementUserReview;

    @FindBy(css = "span.subText a ~ a")
    WebElement webElementCriticsReview;

    @FindAll(@FindBy(css = "div.rec_item img"))
    List<WebElement> listOfSimilarfilms;

    private int numberOfUserReview;
    private int numberOfCriticsReview;

    public boolean getReleaseDate() {
        wait.until(ExpectedConditions.visibilityOf(webElementTitleOverview));
        log.info("Release date: {}", webElementTitleYear.getText());
        return webElementTitleYear.isDisplayed();
    }

    public boolean getDuration() {
        int duration = Integer.parseInt(webElementDuration.getText().replaceAll("\\D+", ""));
        log.info("Duration in minutes: {}", duration);
        log.info("Duration in seconds: {}", duration * 60);
        return webElementDuration.isDisplayed();
    }

    public boolean getMovieRating() {
        log.info("Movie rating: {}", webElementMovieRating.getText());
        return webElementMovieRating.isDisplayed();
    }

    public boolean getGenre() {
        log.info("Genre: {}", webElementGenre.getText());
        return webElementGenre.isDisplayed();
    }

    public boolean getURLTrailer() {
        log.info("Link to the movie trailer: {}", webElementTrailer.getAttribute("href"));
        return webElementTrailer.isDisplayed();
    }

    public boolean getUrlPoster() {
        log.info("Link to the movie poster: {}", webElementPoster.getAttribute("href"));
        return webElementPoster.isDisplayed();
    }

    public boolean getFilmDirectors() {
        log.info("Film directors: {}", webElementFilmDirector.getText());
        return webElementFilmDirector.isDisplayed();
    }

    public void getFiveActors() {
        if (webElementGetFiveActors != null) {
            log.info("Here is the five actors: ");
            for (int i = 1; i <= 5; i++) {
                log.info("{}. {}", i, webElementGetFiveActors.get(i).getText());
            }

        } else {
            log.info("No element is present");
        }
    }

    public void getMetaScore() {
        assertThat(webElementMetascore.isDisplayed());
        log.info("Rating Metascore: {} ", webElementMetascore.getText());
    }

    public void getNumberUserReview() {
        assertThat(webElementUserReview.isDisplayed());
        log.info("Number of user review: {}", webElementUserReview.getText());
        numberOfUserReview = Integer.valueOf(webElementUserReview.getText().replaceAll("\\D+", ""));
    }

    public void getNumberCriticsReview() {
        assertThat(webElementCriticsReview.isDisplayed());
        log.info("Number of critics review: {}", webElementCriticsReview.getText());
        numberOfCriticsReview = Integer.valueOf(webElementCriticsReview.getText().replaceAll("\\D+", ""));
    }

    public void numberOfReview() {
        log.info("Amount of users and critics: {}", (numberOfUserReview + numberOfCriticsReview));
    }

    public void getSimilarFilms() {
        log.info("Names of the 3 similar films: ");
        if (assertThat(listOfSimilarfilms) != null) {
            for (int i = 1; i <= 3; i++) {
                log.info("{}. {} ", i, listOfSimilarfilms.get(i).getAttribute("title"));
            }
        } else {
            log.info("No similar films");
        }
    }
}


