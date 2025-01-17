
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(
            xpath = "//a[contains(.,'Categorías')]"
    )
    private WebElement input_categorias;
    @FindBy(
            xpath = "//a[contains(.,'Ofertas')]"
    )
    private WebElement input_Ofertas;

    public MainPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void ingresar_a_categoria(String categoria) {
        this.waitAndHover(this.input_categorias);
        String xpath = String.format("//li/a[contains(.,'%s')]", categoria);
        WebElement element = this.driver.findElement(By.xpath(xpath));
        this.waitAndClick(element);
    }

    public void ingresar_a_ofertas() {
        this.waitAndClick(this.input_Ofertas);
    }

    public void ingresar_a_una_seccion_de_tecnologia(String seccion) {
        String xpath = String.format("//div[@aria-label='Tecnología']//a[contains(.,'%s')]", seccion);
        WebElement element = this.driver.findElement(By.xpath(xpath));
        this.waitAndClick(element);
    }
}
