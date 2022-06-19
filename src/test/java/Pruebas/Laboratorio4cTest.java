package Pruebas;


import java.io.File;
import java.io.IOException;
//import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.PaginaInicioTest;
import Paginas.PaginaLoginTest;
import Utilidades.CapturaEvidencia;

public class Laboratorio4cTest {
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
	
	@Test(description="CP01 - Verificar la seccion LOGIN", priority=100)
	public void login() throws InvalidFormatException, IOException, InterruptedException {
		PaginaInicioTest inicio = new PaginaInicioTest(driver);
		inicio.hacerClicEnSignIn();
		
		CapturaEvidencia.escribirTituloEnDocumento(evidenciasDir + nombreDocumento, "Documento de Evidencias de Prueba", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 1 - Pantalla Principal Sing-IN");
		
		PaginaLoginTest login = new PaginaLoginTest(driver);
		login.escribirEmail("correo0.9076905803257301@mailinator.com");
		login.escribirPassword("chesster21");
		login.hacerClicEnLogin();
		
		//new WebDriverWait(driver, Duration.ofSeconds(10));
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 2 - Pantalla Principal Login");
		
		
	}
	
	@Test(description="CP02 - Verificar buscar palabra- DRESS", priority=200)
	public void buscarPalabra() throws InvalidFormatException, IOException, InterruptedException {
		PaginaInicioTest inicio = new PaginaInicioTest(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
		
        //new WebDriverWait(driver, Duration.ofSeconds(20));
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 3 - Pantalla Principal Buscar Palabra dess");
	}
	
	@Test(description="CP01 - Verificar buscar palabra- TOP", priority=300)
	public void buscarPalabra1() throws InvalidFormatException, IOException, InterruptedException {
		PaginaInicioTest inicio = new PaginaInicioTest(driver);
		inicio.clear();
		inicio.escribirPalabra("top");
		inicio.hacerClicEnBuscar();
		
		
        //new WebDriverWait(driver, Duration.ofSeconds(20));
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 4 - Pantalla Principal Buscar palabra TOP");
	}
	
	@Test(description="CP01 - Verificar buscar palabra- T-SHIRTS", priority=400)
	public void buscarPalabra2() throws InvalidFormatException, IOException, InterruptedException {
		PaginaInicioTest inicio = new PaginaInicioTest(driver);
		inicio.clear();
		inicio.escribirPalabra("t-shirts");
		inicio.hacerClicEnBuscar();
		
		
        //new WebDriverWait(driver, Duration.ofSeconds(20));
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, evidenciasDir + "img.jpg", evidenciasDir + nombreDocumento, "Paso 5 - Pantalla Principal Buscar palabra t-shirts");
	}


	@AfterTest
	public void cierreNavegador() {
		driver.close();
	}
	


}
