package pages.ukranianbanks;

import java.util.Arrays;

public class CurrencyCalculation {

    public void lowestUSDPurchasePrint(double firstBank, double secondBank, double thirdBank, double fourBank) {
        double[] usdBuyList = {firstBank, secondBank, thirdBank, fourBank};
        Arrays.sort(usdBuyList);
        System.out.println("The lowest pushare rate is: " + usdBuyList[0]);

    }

    public void highestSellingRatePrint (double firstBank, double secondBank, double thirdBank, double fourBank, double fifthBank) {
        double[] usdSellList = {firstBank, secondBank, thirdBank, fourBank, fifthBank};
        Arrays.sort(usdSellList);
        System.out.println("The highest selling rate is: " + usdSellList[usdSellList.length - 1]);
    }
}
