package pages.ukranianbanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class OshadBank extends AbstractPage {
    public OshadBank(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".buy-USD")
    WebElement getUSDOshadBuy;

    @FindBy (css = ".sell-USD")
    WebElement getUSDOshadSell;

    private double usdOshadBuy, usdOshadSell;

    public double getUsdOshadBuy() {
        return usdOshadBuy;
    }

    public double getUsdOshadSell() {
        return usdOshadSell;
    }

    public void getUSDCurrency () {
        driver.get("https://www.oschadbank.ua/ua");
        usdOshadBuy = Double.valueOf(getUSDOshadBuy.getText());
        usdOshadSell = Double.valueOf(getUSDOshadSell.getText());
        log.info("USD ukranianbanks from Osadbank buy: " + usdOshadBuy);
        log.info("USD ukranianbanks from Osadbank sell: " + usdOshadSell);
        log.info("-------------------------------");
    }
}
