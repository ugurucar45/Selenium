package ProjectDays.FirstWeek;

import jdk.internal.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestCase4 {
    @Test
    public void order() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        Thread.sleep(1000);
        WebElement selectProduct = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        String a1 = "ScreenSaver";
        selectProduct.sendKeys(a1);

        WebElement quantitiy = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        String a2 = "5";
        quantitiy.sendKeys(a2);

        WebElement customerName = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtName']"));
        String a3 = "Techtorial Academy";
        customerName.sendKeys(a3);

        Date time = new Date();
        System.out.println(time.toString());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String a31=(df.format(time));

        WebElement street = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        String a4 = "2200 E devon";
        street.sendKeys(a4);

        WebElement city = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        String a5 = "Des Plaines";
        city.sendKeys(a5);

        WebElement state = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        String a6 = "Illinois";
        state.sendKeys(a6);

        WebElement zip = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        String a7 = "60018";
        zip.sendKeys(a7);

        WebElement card = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]"));
        card.click();
        String a8 = "MasterCard";

        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        String a9 = "444993876233";
        cardNumber.sendKeys(a9);

        WebElement expDate = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        String a10 = "03/21";
        expDate.sendKeys(a10);

        WebElement processButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));
        processButton.click();

        WebElement isDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
        boolean a = isDisplayed.getText().equals("New order has been successfully added.");
        Assert.assertTrue(a);

        WebElement clickOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        clickOrders.click();

        List<WebElement> orders = driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]"));
        List <String> order= new LinkedList<String>();
        order.add(a3+" "+a1+" "+a2+" "+a31+" "+a4+" "+a5+" "+a6+" "+a7+" "+a8+" "+a9+" "+a10);
        boolean isItSame= true;
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getText());
            System.out.println(order.get(i));
            System.out.println("========");
        }
        for (int i = 0; i < orders.size(); i++) {
            if(!orders.get(i).getText().equals(order.get(i))){
                isItSame=false;
            }
        }

        Assert.assertTrue(isItSame);

    }
}
