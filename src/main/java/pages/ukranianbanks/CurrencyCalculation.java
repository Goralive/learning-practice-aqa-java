package pages.ukranianbanks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class CurrencyCalculation {

    private Logger log;

    public CurrencyCalculation() {
        this.log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    }

    public void lowestUSDPurchasePrint(double firstBank, double secondBank, double thirdBank, double fourBank) {
        double[] usdBuyList = {firstBank, secondBank, thirdBank, fourBank};
        Arrays.sort(usdBuyList);
        log.info("The lowest pushare rate is: {}" , usdBuyList[0]);

    }

    public void highestSellingRatePrint(double firstBank, double secondBank, double thirdBank, double fourBank, double fifthBank) {
        double[] usdSellList = {firstBank, secondBank, thirdBank, fourBank, fifthBank};
        Arrays.sort(usdSellList);
        log.info("The highest selling rate is: {}" , usdSellList[usdSellList.length - 1]);
    }
}
