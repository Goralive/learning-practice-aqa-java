package pages.ukranianbanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.List;

public class UkrSibBank extends AbstractPage {

    public UkrSibBank(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(css = "table.currency__table tbody td"))
    private List<WebElement> usdCurrencySibList;

    private double usdUrkSibSell;
    private double usdUrkSibBuy;

    public double getUsdUrkSibBuy() {
        return usdUrkSibBuy;
    }

    public double getUsdUrkSibSell() {
        return usdUrkSibSell;
    }

    public void getUSDCurrencyValue() {
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        usdUrkSibBuy = Double.valueOf(usdCurrencySibList.get(1).getText());
        usdUrkSibSell = Double.valueOf(usdCurrencySibList.get(2).getText());

        log.info("Get USD ukranianbanks from UrkSib buy: {}" , usdUrkSibBuy);
        log.info("Get USD ukranianbanks from UrkSib sell: {}" , usdUrkSibSell);
        log.info("-----------");
    }
}

