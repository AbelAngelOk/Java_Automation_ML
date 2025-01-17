package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ConstructionMenuPage extends BasePage {
    @FindBy(
            xpath = "//h2[contains(.,'baño')]/following-sibling::a"
    )
    private WebElement inputVerMasProductosBanio;

    public ConstructionMenuPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void ir_a_productos_de_bano() {
        this.waitAndClick(this.inputVerMasProductosBanio);
    }
}
