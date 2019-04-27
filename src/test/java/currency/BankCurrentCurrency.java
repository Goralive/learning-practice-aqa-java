package currency;

import core.WebDriverTestBase;
import org.junit.Test;
import pages.ukranianbanks.CurrencyCalculation;

import java.util.Arrays;

public class BankCurrentCurrency extends WebDriverTestBase {

    /**
     * 1. Go to the websites of banks
     * 2. Write 2 variables of the type "double" - the rate of buying / selling currencies (hryvnia / dollar)
     * 3. Calculate the average exchange rate, separately, purchases and sales between all banks (output to the console)
     * 4. Print the bank with the lowest dollar purchase rate to the console
     * 5. Print the bank with the highest selling rate to the console
     */



    @Test
    public void sellingRates() {
        privatBank.getUSDCurrencyValue();
        ukrSibBank.getUSDCurrencyValue();
        universalBank.getUSDCurrencyValue();
        oshadBank.getUSDCurrency();
        nationalBank.getUSDCurencyValue();
        CurrencyCalculation currencyCalculation = new CurrencyCalculation();
        currencyCalculation.highestSellingRatePrint(privatBank.getUsdPrivatSell(),ukrSibBank.getUsdUrkSibSell(),universalBank.getUsdMonoSell(),oshadBank.getUsdOshadSell(),nationalBank.getNationalBankUSDSell());
        currencyCalculation.lowestUSDPurchasePrint(privatBank.getUsdPrivatBuy(),ukrSibBank.getUsdUrkSibBuy(),universalBank.getUsdMonoBuy(),oshadBank.getUsdOshadBuy());


        
        }


    }
