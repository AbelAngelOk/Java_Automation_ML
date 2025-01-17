package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseProductsPage extends BasePage {
    @FindBy(
            className = "ui-search-search-result__quantity-results"
    )
    private WebElement subtitulo_cantidad_de_productos;
    @FindBy(
            xpath = "//span[contains(.,'te da env')]/ancestor::button"
    )
    private WebElement switch_envio_gratis_FULL;
    @FindBy(
            name = "Minimum"
    )
    private WebElement input_precio_minimo;
    @FindBy(
            name = "Maximum"
    )
    private WebElement input_precio_maximo;
    @FindBy(
            xpath = "//form[@class='ui-search-price-filter ui-search-filter-range--MAX_FLIGHT_TIME']//button[@aria-label='Aplicar']"
    )
    private WebElement btn_aplicar_filtro;

    public BaseProductsPage(WebDriver driver) {
        super(driver);
        this.initPage();
    }

    public void seleccionar_subcategoria(String categoria) {
        String xpath = String.format("//span[@class='ui-search-filter-name' and contains(.,'%s')]", categoria);
        WebElement una_seccion_de_categoria = this.driver.findElement(By.xpath(xpath));
        this.waitAndScroll(una_seccion_de_categoria);
        this.waitAndClick(una_seccion_de_categoria);
    }

    public int extraer_cantidad_de_resultados_del_subtitulo() {
        String texto_del_webElement = this.subtitulo_cantidad_de_productos.getText();
        String numeros_del_texto = texto_del_webElement.replaceAll("[^0-9]", "");
        return Integer.parseInt(numeros_del_texto);
    }

    public int contar_cantidad_de_resultados_en_la_pagina() {
        List<WebElement> cantidad_de_productos = this.waitAndFinds(By.cssSelector(".andes-card.poly-card.poly-card--grid-card.andes-card--flat.andes-card--padding-0.andes-card--animated"));
        return cantidad_de_productos.size();
    }

    public void filtrar_por_precio(int precio_minimo, int precio_maximo) {
        this.waitAndScroll(this.input_precio_minimo);
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].value = arguments[1];", new Object[]{this.input_precio_minimo, precio_minimo});
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", new Object[]{this.input_precio_minimo});
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", new Object[]{this.input_precio_minimo});
        this.waitAndScroll(this.input_precio_maximo);
        js.executeScript("arguments[0].value = arguments[1];", new Object[]{this.input_precio_maximo, precio_maximo});
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", new Object[]{this.input_precio_maximo});
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", new Object[]{this.input_precio_maximo});
        this.waitAndClick(this.btn_aplicar_filtro);
    }

    public void filtrar_por_envio_gratis_full() {
        this.waitAndClick(this.switch_envio_gratis_FULL);
    }
}
