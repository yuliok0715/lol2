package steps;

import Contexts.Basket;
import Driver.DriverSingleton;
import PageObjects.BasePage;
import PageObjects.BasketPage;
import PageObjects.Rozetka;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Elements.Element.isExisting;

public class Bucket_steps {
    private WebDriver driver;
    @Given("^Browser \"([^\"]*)\" is opened$")
    public void browzer_is_opened(String browser){
        driver = DriverSingleton.getInstance(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Website \"([^\"]*)\" is opened$")
    public void website_is_opened(String arg1) throws Throwable {
        driver.get(arg1);
        // Write code here that turns the phrase above into concrete action
    }

    @When("^I click on \"([^\"]*)\"$")
    public void click_on(String button){
        if (button.equals("bucket")){
            Rozetka page = new Rozetka(driver);
            page.go_to_bucket();
        }
       else{
            Rozetka page = new Rozetka(driver);;
            page.buy_something(button);
        }
    }

    @Then("^The bucket is opened$")
    public void bucket_is_opened(){
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(isExisting(page.Page));
    }

    @Then("^Good \"([^\"]*)\" is in bucket$")
    public void is_in_bucket(String good){
        BasketPage page = new BasketPage(driver);
        Assert.assertTrue(page.isOnPage(good));
    }

    @Then("^Browser is closed$")
    public void browser_closed(){
        driver.quit();
    }


}
