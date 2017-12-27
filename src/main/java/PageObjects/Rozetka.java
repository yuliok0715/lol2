package PageObjects;

import Elements.Button;
import Elements.Html_label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Waiter.Waiter.waitForClick;

public class Rozetka extends BasePage {
    public Rozetka(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "btn-link-i")
    List<Button> buy_buttons;

    @FindBy(css = "hub-i-link hub-i-cart-link sprite-side whitelink")
    Button bucket;

    @FindBy(css = ".g-i-table > div:first-child> .g-i-td")
    private List<Html_label> allLabels;

    public void buy_something(String name){
        int i = 0;
        while (true){
            Html_label iter = allLabels.get(i);
            if (iter.findElement(By.xpath(".//*[@class=\"g-title g-title-elipsis\"]/a")).getText().contains(name)){
                iter.findElement(By.xpath(".//*[@class=\"g-buy\"]")).click();
                break;}
            i++;
        }
    }
    public void  go_to_bucket(){
        waitForClick(driver, bucket, 5);
        bucket.click();
    }
}
