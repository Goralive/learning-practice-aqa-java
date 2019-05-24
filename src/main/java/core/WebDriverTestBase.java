package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WebDriverTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ChromeOptions options;
    protected EventFiringWebDriver eventDriver;
    protected DriverEventListener eventListener;

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        options = new ChromeOptions().addArguments("--incognito");
        driver = new ChromeDriver(options);
        eventDriver = new EventFiringWebDriver(driver);
        eventListener = new DriverEventListener();
        eventDriver.register(eventListener);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
