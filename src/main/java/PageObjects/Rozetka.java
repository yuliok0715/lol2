package PageObjects;

import Elements.Button;
import Elements.Html_label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Rozetka extends BasePage {
    public Rozetka(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "btn-link-i")
    List<Button> buy_buttons;

    @FindBy(id = "cart_block97704")
    Button bucket;

    @FindBy(css = "[class = \"slider-i-td available \"], [class = \"slider-i-td limited \"]")
    private List<Html_label> allLabels;


    public void buy_something(String name){
        for(Html_label iter: allLabels)
            if (iter.findElement(By.xpath(".//*[@class = \"g-title\"]")).getText().contains(name))
                iter.findElement(By.xpath(".//*[@class = \"g-buy\"]")).click();
    }
    public void  go_to_bucket(){
        bucket.click();
    }
}
