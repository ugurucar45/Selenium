package Utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtil {

    public static void selectBy(WebElement element, String value, String methodName) {

        Select select = new Select(element);

        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                System.out.println("Method name is not available, use text, value or index for method name");
        }
        // to use this method in another class use this syntax:
        // BrowserUtils.selectBy(passengerCount, "2", "value");
    }

    public static String getTextMethod(WebElement ss) {
        return ss.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title").toString();
        return title;
    }

    public static void clickWithJs(WebDriver driver,WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }
}
