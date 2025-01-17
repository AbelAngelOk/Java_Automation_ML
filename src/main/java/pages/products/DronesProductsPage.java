package pages.products;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProductsPage;

public class DronesProductsPage extends BaseProductsPage {
    public DronesProductsPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public int contar_cantidad_de_resultados_en_la_pagina() {
        List<WebElement> cantidad_de_productos = this.waitAndFinds(By.xpath("//li[@class='ui-search-layout__item shops__layout-item']"));
        return cantidad_de_productos.size();
    }
}
