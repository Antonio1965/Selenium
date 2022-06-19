package Cuspide;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prueba1Test {
	String url = "https://www.cuspide.com/";
	WebDriver driver;
	
@Test
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();// Cambiar el driver.
		
		driver = new ChromeDriver();// Cambiar por EDGE, FIREFOX, CHROME.
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@id='lnkHeader']")).click();
		
		driver.findElement(By.xpath("//li[@id='liLogin']")).click();
		
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("Sa@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='btnContinuar']")).click();
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("saburo2020");
		
		driver.findElement(By.xpath("//input[@id='btnIngresar']")).click();
		
		
	}
		
@AfterTest
public void cierreNavegador() {
	driver.close();
}
		
	
}
	

