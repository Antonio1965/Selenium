package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.PaginaTablaTst;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Laboratorio7aTest {
	String url = "https://demo.guru99.com/test/table.html";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void consultarValoresTabla() {
		PaginaTablaTst tabla = new PaginaTablaTst(driver);
		
		System.out.println(tabla.obtenerTextoCelda12()); // 2
		System.out.println(tabla.obtenerTextoCelda23()); // 6
		System.out.println(tabla.obtenerTextoCelda43()); // 8
	}
	
	@AfterTest
	public void cierreNavegador() {
		driver.close();
	}

}
