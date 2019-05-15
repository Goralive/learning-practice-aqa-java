package pages.ukranianbanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class UniversalBank extends AbstractPage {
    public UniversalBank(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tr:nth-child(2) > td:nth-child(2)")
    WebElement usdBuyCurrencyMono;
    @FindBy(css = " tr:nth-child(2) > td:nth-child(3)")
    WebElement usdSellCurrencyMono;

    private double usdMonoBuy;
    private double usdMonoSell;

    public double getUsdMonoBuy() {
        return usdMonoBuy;
    }

    public double getUsdMonoSell() {
        return usdMonoSell;
    }

    public void getUSDCurrencyValue() {
        driver.get("https://www.universalbank.com.ua/");
        usdMonoBuy = Double.valueOf(usdBuyCurrencyMono.getText());
        usdMonoSell = Double.valueOf(usdBuyCurrencyMono.getText());
        log.info("Get USD ukranianbanks from MonoBank buy: {}" , usdMonoBuy);
        log.info("Get USD ukranianbanks from MonoBank sell: {}" , usdMonoSell);
        log.info("-----------");
    }
}
