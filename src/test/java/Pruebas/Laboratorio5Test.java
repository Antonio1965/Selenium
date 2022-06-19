package Pruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Laboratorio5Test {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.edgedriver().setup();// Cambiar el driver.
		
		driver = new EdgeDriver();// Cambiar por EDGE, FIREFOX, CHROME.
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void prueba() {
		System.out.println("Utilizando el WebDriverManager En .....");
	}
}
