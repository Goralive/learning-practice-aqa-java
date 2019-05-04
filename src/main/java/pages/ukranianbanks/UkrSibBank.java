package pages.ukranianbanks;

import org.openqa.selenium.By;
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

    @FindAll(@FindBy(css = "table.currency__table tbody td") )
    private List<WebElement> usdCurrencySibList;

    private double usdUrkSibBuy, usdUrkSibSell;

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

        System.out.println("Get USD ukranianbanks from UrkSib buy: " + usdUrkSibBuy);
        System.out.println("Get USD ukranianbanks from UrkSib sell: " + usdUrkSibSell);
        System.out.println("-----------");
    }
}

