package pages.imdbfilms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

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

    public void getReleaseDate() {
        wait.until(ExpectedConditions.visibilityOf(webElementTitleOverview));
        System.out.println("Release date: " + webElementTitleYear.getText());

        System.out.println("5 film actors: ");
        System.out.println("Rating Metascore ");
        System.out.println("Number of review for user ");
        System.out.println("Number of review for critics ");
        System.out.println("Number of review for user and critics ");
        System.out.println("Names pf 3 similar films ");
    }

    public void getDuration() {
        int duration = Integer.valueOf(webElementDuration.getText().replaceAll("\\D+", ""));
        System.out.println("Duration in minutes: " + duration);
        System.out.println("Duration in seconds: " + duration * 60);
    }

    public void getMovieRating() {
        System.out.println("Movie rating: " + webElementMovieRating.getText());
    }

    public void getGenre() {
        System.out.println("Genre: " + webElementGenre.getText());
    }

    public void getURLTrailer() {
        System.out.println("Link to the movie trailer: " + webElementTrailer.getAttribute("href"));
    }

    public void getUrlPoster() {
        System.out.println("Link to the movie poster: " + webElementPoster.getAttribute("href"));
    }

    public void getFilmDirectors() {
        System.out.println("Film directors: ");

    }

}
