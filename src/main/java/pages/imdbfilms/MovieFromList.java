package pages.imdbfilms;

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

    public void getReleaseDate() {
        wait.until(ExpectedConditions.visibilityOf(webElementTitleOverview));
        log.info("Release date: {}", webElementTitleYear.getText());
        assertThat(webElementTitleYear.isDisplayed());
    }

    public void getDuration() {
        assertThat(webElementDuration.isDisplayed());
        int duration = Integer.parseInt(webElementDuration.getText().replaceAll("\\D+", ""));
        log.info("Duration in minutes: {}", duration);
        log.info("Duration in seconds: {}", duration * 60);
    }

    public void getMovieRating() {
        assertThat(webElementMovieRating.isDisplayed());
        log.info("Movie rating: {}", webElementMovieRating.getText());
    }

    public void getGenre() {
        assertThat(webElementGenre.isDisplayed());
        log.info("Genre: {}", webElementGenre.getText());
    }

    public void getURLTrailer() {
        assertThat(webElementTrailer.isDisplayed());
        log.info("Link to the movie trailer: {}", webElementTrailer.getAttribute("href"));
    }

    public void getUrlPoster() {
        assertThat(webElementPoster.isDisplayed());
        log.info("Link to the movie poster: {}", webElementPoster.getAttribute("href"));
    }

    public void getFilmDirectors() {
        assertThat(webElementFilmDirector.isDisplayed());
        log.info("Film directors: {}", webElementFilmDirector.getText());
    }

    public void getFiveActors() {
        if (assertThat(webElementGetFiveActors) != null) {
            log.info("Here is the five actors: ");
            for (int i = 1; i <= 5; i++) {
                log.info("{}. {}", i, webElementGetFiveActors.get(i).getText());
            }

        } else {
            log.info("No actors was found");

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
        for (int i = 1; i <= 3; i++) {
            log.info("{}. {} ", i, listOfSimilarfilms.get(i).getAttribute("title"));
        }
    }
}


