package Contexts;

import Elements.Html_label;
import PageObjects.BucketPage;
import PageObjects.ContactsPage;
import org.openqa.selenium.Keys;

import static Waiter.Waiter.Wait;
import static Waiter.Waiter.waitForClick;

public class Bucket {
    public static ContactsPage confirmOrder(BucketPage page){
        page.confirmOrder();
        return new ContactsPage(page.driver);
    }


    public static void addOneMore(BucketPage page){
        waitForClick(page.get_driver(), page.getButtonPlus(), 5);
        page.getButtonPlus().click();
    }

    public static Integer numberOfItem(BucketPage page) {
        return Integer.parseInt(page.getNumberOfItem().getValue());
    }

    public static void deleteItem(BucketPage page, String name){
        int i = 0;
        while (i < page.getAllLabels().size()){
            Html_label iter = page.getAllLabels().get(i);
            if (iter.getText().contains(name)) {
                page.getButtonDeleteItem().get(i).click();
                waitForClick(page.get_driver(), page.getButtonDeleteWithoutSave().get(i), 50);
                page.getButtonDeleteWithoutSave().get(i).click();
            }
            i++;
        }
    }

    public static void deleteOne(BucketPage page){
        waitForClick(page.get_driver(), page.getButtonMinus(), 5);
        page.getButtonMinus().click();
    }

    public static boolean isOnPage(BucketPage page, String name){
        for(Html_label iter: page.getAllLabels()){
            if (iter.getText().contains(name)) return true;
        }
        return false;
    }

    public static void setNumberOfItem(BucketPage page, String value){
        page.getNumberOfItem().setValue(value);
        page.getNumberOfItem().sendKeys(Keys.ENTER);
        Wait(5);
    }

    public static void closeBucket(BucketPage page) {
        waitForClick(page.get_driver(), page.getButtonCloseBucket(), 1500);
        page.getButtonCloseBucket().click();
    }

    public static boolean emptyBucket(BucketPage page){
        return page.getEmptyBucket().getText().contains("пуста");
    }
}
