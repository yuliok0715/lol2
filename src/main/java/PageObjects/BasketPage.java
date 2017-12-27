package PageObjects;

import Elements.*;
import Waiter.Waiter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Waiter.Waiter.Wait;
import static Waiter.Waiter.waitForClick;

public class BasketPage extends BasePage {

    public BasketPage (WebDriver driver){
        super(driver);
    }

    @FindBy(id = "cart-popup")
    public Page Page;

    @FindBy(id = "popup-checkout")
    private Button confirmOrderButton;

    @FindBy(css = ".slider-sliding-box.clearfix > div")
    private List<AdLabel> sales;

    @FindBy(css = ".slider-sliding-box.clearfix > div")
    private List<AdLabel> ads;

    @FindBy(name = "plus")
    private Html_label buttonPlus;

    @FindBy(name = "minus")
    private Html_label buttonMinus;

    @FindBy(name = "quantity")
    private TextField number_of_item;

    @FindBy(css = "scc .cart-check-icon.sprite")
    private Button buttonDelItem;

    @FindBy(css = ".popup-close-icon.sprite")
    private Button buttonCloseBucket;

    public void confirm_order(){
        waitForClick(driver, confirmOrderButton,5);
        confirmOrderButton.click();
    }

    public void addOneMore() {
        waitForClick(driver, buttonPlus, 5);
        buttonPlus.click();
    }

    public Integer numberOfItem() {
        return Integer.parseInt(number_of_item.getValue());
    }

    public boolean PlusMinusISOK(int number1, int number2){
        if(number1>number2){
            return true;
        }else{
            return false;
        }
    }

    public void delItem(){
        waitForClick(driver, buttonDelItem, 5);
        buttonDelItem.click();
    }

    public void delOne(){
        waitForClick(driver, buttonMinus, 5);
        buttonMinus.click();
    }

    @FindBy(xpath = "//*[@id = \"cart-popup\"] //*[@class=\"g-title-link novisited\"] | //*[@class=\"novisited cart-i-title-link\"]")
    public List<Html_label> allLabels;

    public boolean isOnPage(String name){
        for(Html_label iter: allLabels){
            if (iter.getText().contains(name)) return true;
        }
        return false;
    }

    public void setNumber_of_item(String value){
        number_of_item.setValue(value);
        number_of_item.sendKeys(Keys.ENTER);
        Wait(5);
    }

    public void CloseBasket() {
        waitForClick(driver, buttonCloseBucket, 5);
        buttonCloseBucket.click();
    }
}
