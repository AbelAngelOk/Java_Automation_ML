# Proyecto de Automatización con Selenium y Maven

Este proyecto utiliza **Maven** para la gestión de dependencias y **Selenium** para la automatización de pruebas. Está diseñado para ejecutar pruebas automatizadas en navegadores web utilizando Page Object Model (POM).

## 📋 Requisitos previos

1. **Java**: Instala JDK 8 o superior.
   - Verifica tu instalación ejecutando `java -version` en la terminal.

2. **Maven**: Instala Apache Maven.
   - Verifica tu instalación ejecutando `mvn -version` en la terminal.

3. **Git**: (Opcional) Clona este repositorio usando Git si no lo has descargado directamente.

---

## 🚀 Instalación

1. Clona este repositorio o descarga los archivos:
   ```
   git clone https://github.com/usuario/proyecto-automatizacion.git
   ```
2. Descarga las dependencias del proyecto
   ```
   mvn clean install
   ```
   ---
## 🛠️ Estructura del Proyecto
```
src/ 
├── main/java 
│   └── pages/                            
│
└── test/java 
    ├── tests/                         
    └── utils/                          
```

# A nivel conceptal se tomaron estas distinciones:
- **Main**: hace referencia a la pagina principal
- **Menu**: hace referencia a la pagina posterior a seleccionar una categoria y previa a la pagina de productos.
- **Products**: hace referencia a la pagina con la lista de productos
---
# Ademas tener en cuenta estos archivos:
- **BasePage**: contiene el driver y los metodos principales del proyecto.
- **BaseMenuPage** y **BaseProductsPage**: contienen los metodos que se consideran reutilizables para el tipo de pagina al que hace referencia cada uno.
- **MainPage**: es la pagina principal de mercado libre
- **DriverSingleton**: gestiona el driver y asegura que el driver tenga una unica instancia.
- **MainTest**: Contiene los casos de prueba.
---
## 📖 Ejecución de las Pruebas
## Ejecutar todas las pruebas
Para ejecutar todas las pruebas definidas en el proyecto:
```
mvn test
```
---
## Ejecutar pruebas específicas desde la clase MainTest
Navega hasta la carpeta donde está definida la clase MainTest:
``` 
cd src/test/java/tests
```
Luego puede precionar sobre el icono de ejecucion un test o la suite de pruebas.



