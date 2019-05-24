package pages.imdbfilms;

import core.WebDriverTestBase;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class MovieInformationFromIMDBTest extends WebDriverTestBase {
    /**
     * Write a program that will display information about the film.
     * Link to the movie page: https://www.imdb.com/title/tt0111161/
     * <p>
     * 1. The name of the film
     * 2. Release date
     * 3. The duration of the film in minutes. Duration of the film in seconds.
     * 4. Movie rating
     * 5. Genre
     * 6. Link to the movie trailer
     * 7. Link to the movie poster
     * 8. Film directors
     * 9. 5 Film Actors
     * 10. Rating Metascore
     * 11. Number of reviews (separately for users, separately for critics, amount of users and critics)
     * 12. Names of 3 "similar" films
     */

    private MovieInformationFromIMDB informationFromIMDB;

    @Test
    public void getInformation() {
        informationFromIMDB = new MovieInformationFromIMDB(driver);
        informationFromIMDB.openIMDB250Url("https://www.imdb.com/chart/top");
        MovieFromList movie = informationFromIMDB.getMovieName(0);
        assertThat(movie.getReleaseDate()).isTrue();
        assertThat(movie.getDuration()).isTrue();
        assertThat(movie.getMovieRating()).isTrue();
        assertThat(movie.getGenre()).isTrue();
        assertThat(movie.getURLTrailer()).isTrue();
        assertThat(movie.getUrlPoster()).isTrue();
        movie.getFilmDirectors();
        movie.getFiveActors();
        movie.getMetaScore();
        movie.getNumberUserReview();
        movie.getNumberCriticsReview();
        movie.numberOfReview();
        movie.getSimilarFilms();
    }
}
