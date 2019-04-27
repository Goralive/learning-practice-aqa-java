package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.facebook.FacebookLoginPage;
import pages.ukranianbanks.*;

public class WebDriverTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected FacebookLoginPage facebookLoginPage;
    protected ChromeOptions options;
    protected PrivatBank privatBank;
    protected UkrSibBank ukrSibBank;
    protected UniversalBank universalBank;
    protected OshadBank oshadBank;
    protected NationalBank nationalBank;

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        options = new ChromeOptions().addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        facebookLoginPage = new FacebookLoginPage(driver);
        privatBank = new PrivatBank(driver);
        ukrSibBank = new UkrSibBank(driver);
        universalBank = new UniversalBank(driver);
        oshadBank = new OshadBank(driver);
        nationalBank = new NationalBank(driver);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
