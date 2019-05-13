package pages.ukranianbanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.List;

public class NationalBank extends AbstractPage {
    public NationalBank(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy(css = "td.cell_c:nth-child(5)"))
    List<WebElement> listWebElementValue;

    private double nationalBankUSDSell;

    public void getUSDCurencyValue() {
        driver.get("https://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        nationalBankUSDSell = Math.round (((Double.valueOf(listWebElementValue.get(7).getText())) * 100.0)/ 100 )/ 100.0;
        log.info("Get USD sell ukranianbanks from National bank: " + nationalBankUSDSell);
        log.info("----------------------");
    }

    public double getNationalBankUSDSell() {
        return nationalBankUSDSell;
    }

}
