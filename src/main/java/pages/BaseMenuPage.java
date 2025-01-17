package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseMenuPage extends BasePage {
    public BaseMenuPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void seleccionar_card(String categoria) {
        String xpath = String.format("//h3[normalize-space(text())='%s']/parent::a", categoria);
        WebElement e = this.waitAndFind(By.xpath(xpath));
        this.waitAndClick(e);
    }
}
