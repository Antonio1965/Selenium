package Pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.PaginaInicioTest;
import Paginas.PaginaLoginTest;
import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Laboratorio6Test {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	String evidenciasDir = "..\\EducacionIT-clase-1\\Evidencias\\"; // Poner al final dos barras.
	File pantalla;
	String nombreDocumento = "Evidencias - AutomationPractice.docx";

	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();// Cambiar el driver.
		
		driver = new ChromeDriver();// Cambiar por EDGE, FIREFOX, CHROME.
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}

	@Test(dataProvider="Datos Login Excel", priority=1)
	public void login(String email, String password) throws InvalidFormatException, IOException, InterruptedException {
		
		CapturaEvidencia.escribirTituloEnDocumento(evidenciasDir + nombreDocumento, "Documento de Evidencias de Prueba", 20);//TITULO
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 1 - Pantalla Principal");
		
		PaginaInicioTest inicio = new PaginaInicioTest(driver);
		inicio.hacerClicEnSignIn();
		
	
		PaginaLoginTest login = new PaginaLoginTest(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 2 - Pantalla Login-1");
		
		// Comprobar si el usuario inicia sesion
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
		
		// Desloguear al usuario
		login.hacerClicEnSignOut();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 2 - Pantalla Login-1");
	}

	
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT-clase-1\\Datos\\Book 1.xlsx", "Sheet1");
	}

	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() throws InvalidFormatException, IOException, InterruptedException{
		Object[][] datos = new Object[3][2];
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 2 - Pantalla Login-1");
		
		// Completar el arreglo con los datos para la prueba (email, contraseÃ±a)
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1q2w3e4r5t";
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 3 - Pantalla Login-2");
		
		datos[1][0] = "def@correo.com";
		datos[1][1] = "0p9o8i7u6y";
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 4 - Pantalla Login-3");
		
		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "qawsedrftg";
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 4 - Pantalla Login-4");
		
		return datos;

		
	}

}

