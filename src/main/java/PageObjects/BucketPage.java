package PageObjects;

import Elements.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Waiter.Waiter.Wait;
import static Waiter.Waiter.waitForClick;

public class BucketPage extends BasePage {

    public BucketPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "cart-popup")
    private Page page;

    public Page getPage() {
        return page;
    }

    @FindBy(id = "popup-checkout")
    private Button confirmOrderButton;

    @FindBy(css = ".slider-sliding-box.clearfix > div")
    private List<AdLabel> sales;

    @FindBy(css = ".slider-sliding-box.clearfix > div")
    private List<AdLabel> ads;

    @FindBy(name = "plus")
    private Html_label buttonPlus;

    public Html_label getButtonPlus() {
        return buttonPlus;
    }

    @FindBy(name = "minus")
    private Html_label buttonMinus;

    public Html_label getButtonMinus() {
        return buttonMinus;
    }

    @FindBy(name = "quantity")
    private TextField numberOfItem;

    public TextField getNumberOfItem() {
        return numberOfItem;
    }

    @FindBy(name="before_delete")
    private List<Button> buttonDeleteItem;

    public List<Button> getButtonDeleteItem() {
        return buttonDeleteItem;
    }

    @FindBy(css = ".popup-close")
    private Button buttonCloseBucket;

    public Button getButtonCloseBucket() {
        return buttonCloseBucket;
    }

    @FindBy (css = ".sprite-side.novisited.cart-i-delete-link")
    private List<Button> buttonDeleteWithoutSave;

    public List<Button> getButtonDeleteWithoutSave() {
        return buttonDeleteWithoutSave;
    }

    @FindBy (css = ".empty-cart-title.inline.sprite-side")
    private WebElement emptyBucket;

    public WebElement getEmptyBucket() {
        return emptyBucket;
    }

    @FindBy(xpath = "//*[@id = \"cart-popup\"] //*[@class=\"g-title-link novisited\"] | //*[@class=\"novisited cart-i-title-link\"]")
    private List<Html_label> allLabels;

    public List<Html_label> getAllLabels() {
        return allLabels;
    }

    public void confirmOrder(){
        waitForClick(driver, confirmOrderButton,5);
        confirmOrderButton.click();
    }
}
