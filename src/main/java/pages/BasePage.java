package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void initPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void waitAndClick(WebElement e) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    public void waitAndHover(WebElement e) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(e));
        Actions actions = new Actions(this.driver);
        actions.moveToElement(e).perform();
    }

    public void waitAndScroll(WebElement e) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(e));
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", new Object[]{e});
    }

    public WebElement waitAndFind(By by_element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_element));
        return this.driver.findElement(by_element);
    }

    public List<WebElement> waitAndFinds(By by_element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by_element));
        return this.driver.findElements(by_element);
    }

    public void waitAndSendKeys(WebElement e, String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.sendKeys(new CharSequence[]{text});
    }
}
