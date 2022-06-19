package Edit.EducacionIT_clase_1;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;


public class Laboratorio3aTest {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT-clase-1\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String evidenciasDir = "..\\EducacionIT-clase-1\\Evidencias\\"; // Poner al final dos barras.
	File pantalla;
	String nombreDocumento = "Evidencias - AutomationPractice.docx";

	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Verificar la seccion Contactanos", priority=200, enabled= true)
	public void irAContactanos() throws Exception, IOException, InterruptedException {
		
		CapturaEvidencia.escribirTituloEnDocumento(evidenciasDir + nombreDocumento, "Documento de Evidencias de Prueba", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 1 - Pantalla Principal");

		
		// Pasos para ir a Contactanos
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 2 - Luego de hacer clic en Contact us");
		
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("correob@mailinator.com");
		driver.findElement(By.id("message")).sendKeys("Comentarios del Contacto");
		
		// Subir un archivo - Escribir en el campo deshabilitado donde va el nombre del archivo
		driver.findElement(By.id("fileUpload")).sendKeys("C:/Users/Casa/Desktop/PDF-TODAS/Asesor.pdf");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 3 - Al completar el formulario");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 4 - Luego de hacer clic en Contact us");
	}
	
	@Test(description="CP02 - Verificar la busqueda de productos", priority=100)
	public void buscarPalabra() throws IOException {	
		// Captura de pantalla (Formato Imagen)
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasDir + "01_pantalla_inicial.jpg"));

		// Pasos para buscar Palabra
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de pantalla (Formato Imagen)
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasDir + "02_palabra_a_buscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de pantalla (Formato Imagen)
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(evidenciasDir + "03_resultados_busqueda.jpg"));


		
		
		// Comprobar que la busqueda se realizÃ³
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl();
		
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(urlActual, urlEsperada);
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		// Assert.assertEquals(numRegistrosBD, 1);
		
		/*
		 * assertEquals
		 * assertNotEquals
		 * assertTrue(2 + 2 == 4)
		 * assertFalse
		 * assertNull
		 * assertNotNull
		 * */
	}
	
	@AfterTest
	public void cerrarPagina() {
		driver.close();
	}


}
