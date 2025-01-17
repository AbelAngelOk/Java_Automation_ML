package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SupermarketMenuPage extends BasePage {
    @FindBy(
            xpath = "//span[contains(.,'CAPSULAS')]/ancestor::a"
    )
    private WebElement item_capculas;

    public SupermarketMenuPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void seleccionar_item_del_carrusel(String item) {
        String xpath = String.format("//span[contains(.,'%s')]/ancestor::a", item.toUpperCase());
        WebElement un_item = this.driver.findElement(By.xpath(xpath));
        this.waitAndClick(un_item);
    }
}