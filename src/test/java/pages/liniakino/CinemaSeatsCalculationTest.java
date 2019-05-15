package pages.liniakino;

import core.WebDriverTestBase;
import org.testng.annotations.Test;

public class CinemaSeatsCalculationTest extends WebDriverTestBase {

    /**
     * Write a program that will display the number of seats in the cinema hall:
     * <p>
     * Number of seats in the hall
     * Number of places occupied
     * Number of free places
     * % Of occupied places from “all seats in the hall”
     * % Empty seats from “all seats in the hall”
     * <p>
     * What the program does:
     * <p>
     * Go to http://liniakino.com/showtimes/aladdin/
     * Choose the movie the next session.
     * Open the scheme of the hall
     * We consider places
     * Print the result to the console.
     */


    private LiniaKinoCinema liniaKinoCinema;

    @Test
    public void numberOfSeatsInCinema() {
        liniaKinoCinema = new LiniaKinoCinema(driver);
        liniaKinoCinema.mainPage("http://liniakino.com/showtimes/aladdin/");
        SchemeOfHall hall =  liniaKinoCinema.openFistActualMovie();
        hall.chooseTheMovieSession();
        hall.getSeats();
        hall.seatPercentage();
    }


}
