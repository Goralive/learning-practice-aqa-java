package pages;

import core.WebDriverTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractPage extends WebDriverTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger log;

    protected AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }
}
