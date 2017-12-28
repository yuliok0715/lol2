package steps;

import Driver.DriverSingleton;
import PageObjects.BucketPage;
import PageObjects.Rozetka;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Contexts.Bucket.*;
import static Contexts.RozetkaAct.buySomething;
import static Contexts.RozetkaAct.goToBucket;
import static Elements.Element.isExisting;
import static Waiter.Waiter.Wait;

public class Bucket_steps {
    private WebDriver driver;
    @Given("^Browser \"([^\"]*)\" is opened$")
    public void browserIsOpened(String browser){
        driver = DriverSingleton.getInstance(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Website \"([^\"]*)\" is opened$")
    public void websiteIsOpened(String url) {
        driver.get(url);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void clickOn(String button){
        Rozetka page = new Rozetka(driver);
        if (button.equals("bucket")){
            goToBucket(page);
        }
       else{
            buySomething(page, button);
        }
    }

    @Then("^The bucket is \"([^\"]*)\"$")
    public void bucketIs(String flag){
        BucketPage page = new BucketPage(driver);
        if (flag.equals("opened")){
            Assert.assertTrue(isExisting(page.getPage()));}
        if (flag.equals("closed")){
            Assert.assertFalse(isExisting(page.getPage()));
            Wait(1000);
        }
    }

    @Then("^Good \"([^\"]*)\" is in bucket$")
    public void isInBucket(String good){
        BucketPage page = new BucketPage(driver);
        Assert.assertTrue(isOnPage(page,good));
        Wait(5000);
    }

    @Then("^Good \"([^\"]*)\" not in bucket$")
    public void goodNotInBucket(String good) throws Throwable {
        BucketPage page = new BucketPage(driver);
        Assert.assertFalse(isOnPage(page, good));
    }

    @Then("^Browser is closed$")
    public void browserIsClosed(){
        driver.quit();
    }


    @When("^I click plus to add one more$")
    public void clickPlusToAddOneMore() throws Throwable {
        BucketPage page = new BucketPage(driver);
        addOneMore(page);
    }

    @When("^I click minus to delete one copy$")
    public void clickMinusToDeleteOne() throws Throwable {
        BucketPage page = new BucketPage(driver);
        deleteOne(page);}

    @Then("^Number of items is (\\d+)$")
    public void numberOfItemsIs(int number) throws Throwable {
        BucketPage page = new BucketPage(driver);
        Assert.assertTrue(numberOfItem(page) == number);
    }

    @And("^I set number of goods (\\d+)$")
    public void setNumberOfGoods(int numberOfGoods) throws Throwable {
        BucketPage page = new BucketPage(driver);
        setNumberOfItem(page, Integer.toString(numberOfGoods) );
    }

    @And("^I close bucket$")
    public void CloseBucket() throws Throwable {
        BucketPage page = new BucketPage(driver);
        closeBucket(page);
        Wait(1000); }

    @Then("^Bucket is empty$")
    public void basket_is_empty(){
        BucketPage page = new BucketPage(driver);
        Assert.assertTrue(emptyBucket(page));
    }

    @And("^I delete \"([^\"]*)\"$")
    public void iDelete(String item) throws Throwable {
        BucketPage page = new BucketPage(driver);
        deleteItem(page, item);
    }
}
