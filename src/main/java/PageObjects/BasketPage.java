package PageObjects;

import Elements.AdLabel;
import Elements.Button;
import Elements.Html_label;
import Elements.Page;
import Waiter.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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



    public void confirm_order(){
        waitForClick(driver, confirmOrderButton,5);
        confirmOrderButton.click();
    }

    public void addOneMore() {
        waitForClick(driver, buttonPlus, 5);
        buttonPlus.click();
    }

    public void delOne(){
        waitForClick(driver, buttonMinus, 5);
    }

    @FindBy(xpath = "//*[@id = \"cart-popup\"] //*[@class=\"g-title-link novisited\"] | //*[@class=\"novisited cart-i-title-link\"]")
    public List<Html_label> allLabels;

    public boolean isOnPage(String name){
        for(Html_label iter: allLabels){
            if (iter.getText().equals(name)) return true;
        }
        return false;
    }
}
