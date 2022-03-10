package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class EbayStepDefs {
    WebDriver driver;
    @Given("user is on ebay homepage")
    public void user_is_on_ebay_homepage() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");
    }
    @When("user searches for iMac 2020")
    public void user_searches_for_i_mac() {
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("iMac 2020", Keys.ENTER);

    }
    @Then("user sees results about i mac only")
    public void user_sees_results_about_i_mac_only() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> allheaders=driver.findElements(By.xpath("//ul//a//h3[@class='s-item__title']"));
            for(WebElement hader:allheaders){
               Thread.sleep(200);
                System.out.println(hader.getText().trim());
                Assert.assertTrue(hader.getText().trim().toLowerCase().contains("imac"));
            }

    }
    @Then("there are more than {int} pages of result")
    public void there_are_more_than_pages_of_result(Integer expectedPages) {
    List<WebElement> pagesOfResult=driver.findElements(By.xpath("//ol[@class=\"pagination__items\"]//li"));
    Assert.assertTrue(pagesOfResult.size()>expectedPages);
    }

}
