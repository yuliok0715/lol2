package Contexts;

import PageObjects.BucketPage;
import PageObjects.GoodPage;
import Waiter.Waiter;

public class Good {
    public static BucketPage buyGood(GoodPage page){
        page.buy_good();
        Waiter.Wait(1000);
        return new BucketPage(page.driver);
    }
}
