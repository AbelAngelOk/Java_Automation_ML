package ML.tests;

import ML.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.menu.ConstructionMenuPage;
import pages.menu.DigitalCamerasMenuPage;
import pages.menu.DronesAndAccessoriesMenuPage;
import pages.menu.DronesMenuPage;
import pages.menu.SupermarketMenuPage;
import pages.products.BathroomFaucetsProductsPage;
import pages.products.DronesProductsPage;
import pages.products.OffersProductsPage;
import pages.products.ProfessionalCamerasProductsPage;

public class MainTest {
    WebDriver driver;
    MainPage mainPage;
    ConstructionMenuPage constructionMenuPage;
    BathroomFaucetsProductsPage bathroomFaucetsProductsPage;
    SupermarketMenuPage superMenuPage;
    OffersProductsPage offersProductsPage;
    DigitalCamerasMenuPage digitalCamerasMenuPage;
    ProfessionalCamerasProductsPage professionalCamerasProductsPage;
    DronesProductsPage dronesProductsPage;
    DronesAndAccessoriesMenuPage dronesAndAccessoriesMenuPage;
    DronesMenuPage dronesMenuPage;

    public MainTest() {
    }

    @BeforeMethod
    public void configurar() {
        this.driver = DriverSingleton.getDriver();
        this.mainPage = new MainPage(this.driver);
        this.constructionMenuPage = new ConstructionMenuPage(this.driver);
        this.bathroomFaucetsProductsPage = new BathroomFaucetsProductsPage(this.driver);
        this.superMenuPage = new SupermarketMenuPage(this.driver);
        this.offersProductsPage = new OffersProductsPage(this.driver);
        this.digitalCamerasMenuPage = new DigitalCamerasMenuPage(this.driver);
        this.professionalCamerasProductsPage = new ProfessionalCamerasProductsPage(this.driver);
        this.dronesProductsPage = new DronesProductsPage(this.driver);
        this.dronesAndAccessoriesMenuPage = new DronesAndAccessoriesMenuPage(this.driver);
        this.dronesMenuPage = new DronesMenuPage(this.driver);
        this.driver.get("https://www.mercadolibre.com.ar/");
    }

    @AfterMethod
    public void cerrar() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void test_ingresar_a_griferia_para_banio() {
        this.mainPage.ingresar_a_categoria("Construcción");
        this.constructionMenuPage.ir_a_productos_de_bano();
        this.bathroomFaucetsProductsPage.seleccionar_subcategoria("Grifería para Baño");

        assert this.driver.getTitle().contains("Grifería para Baño");

    }

    @Test
    public void test_ingresar_a_accesorios_para_celulares() {
        this.mainPage.ingresar_a_categoria("Tecnología");
        this.mainPage.ingresar_a_una_seccion_de_tecnologia("Accesorios para Celulares");

        assert this.driver.getTitle().contains("Accesorios para Celulares");

    }

    @Test
    public void test_ingresar_a_ofertas_del_dia() {
        this.mainPage.ingresar_a_ofertas();
        this.offersProductsPage.seleccionar_subcategoria("Oferta del día");

        assert this.driver.getTitle().contains("Ofertas");

    }

    @Test
    public void test_ingresar_a_capsulas_de_supermercado() {
        this.mainPage.ingresar_a_categoria("Supermercado");
        this.superMenuPage.seleccionar_item_del_carrusel("capsulas");

        assert this.driver.getTitle().contains("Supermercado");

    }

    @Test
    public void test_cantidad_de_publicaciones_en_camaras_profesionales_Nikon() {
        this.mainPage.ingresar_a_categoria("Tecnología");
        this.mainPage.ingresar_a_una_seccion_de_tecnologia("Cámaras Digitales");
        this.digitalCamerasMenuPage.seleccionar_card("Camara profesional");
        this.professionalCamerasProductsPage.seleccionar_subcategoria("Nikon");
        int a = this.professionalCamerasProductsPage.extraer_cantidad_de_resultados_del_subtitulo();
        int b = this.professionalCamerasProductsPage.contar_cantidad_de_resultados_en_la_pagina();

        assert a == b;

    }

    @Test
    public void test_cantidad_de_publicaciones_en_drones_con_filtro_rango_de_precio() {
        this.mainPage.ingresar_a_categoria("Tecnología");
        this.mainPage.ingresar_a_una_seccion_de_tecnologia("Drones y Accesorios");
        this.dronesAndAccessoriesMenuPage.seleccionar_subcategoria("Drones");
        this.dronesMenuPage.seleccionar_card("Drones");
        this.dronesProductsPage.seleccionar_subcategoria("Solo tiendas oficiales");
        this.dronesProductsPage.filtrar_por_envio_gratis_full();
        int a = this.dronesProductsPage.extraer_cantidad_de_resultados_del_subtitulo();
        int b = this.dronesProductsPage.contar_cantidad_de_resultados_en_la_pagina();

        assert a == b;

    }
}