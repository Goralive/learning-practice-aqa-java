package pages.ukranianbanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class PrivatBank extends AbstractPage {

    public PrivatBank(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.section-content.rate")
    WebElement usdCurrencyPrivat;

    private double usdPrivatSell, usdPrivatBuy;


    public double getUsdPrivatSell() {
        return usdPrivatSell;
    }

    public double getUsdPrivatBuy() {
        return usdPrivatBuy;
    }

    public PrivatBank getUSDCurrencyValue() {
        driver.get("https://www.privat24.ua");

        usdPrivatBuy = Double.valueOf(usdCurrencyPrivat.getText().substring(0,6));
        usdPrivatSell = Double.valueOf(usdCurrencyPrivat.getText().substring(9,15));
        log.info("USD ukranianbanks from privat buy: " + usdPrivatBuy);
        log.info("USD ukranianbanks from privat sell: "+ usdPrivatSell);
        log.info("-----------");
        return new PrivatBank(driver);
    }
}
