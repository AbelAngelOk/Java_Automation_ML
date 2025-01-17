package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProductsPage;

public class OffersProductsPage extends BaseProductsPage {
    public OffersProductsPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void seleccionar_subcategoria(String categoria) {
        String xpath = String.format("//a[contains(.,'%s')]", categoria);
        WebElement una_seccion_de_categoria = this.driver.findElement(By.xpath(xpath));
        this.waitAndScroll(una_seccion_de_categoria);
        this.waitAndClick(una_seccion_de_categoria);
    }
}