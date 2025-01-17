package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class DronesAndAccessoriesMenuPage extends BasePage {
    public DronesAndAccessoriesMenuPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void seleccionar_subcategoria(String item) {
        String xpath = String.format("//span[contains(.,'%s')]/ancestor::a", item);
        WebElement un_item = this.driver.findElement(By.xpath(xpath));
        this.waitAndClick(un_item);
    }
}
