package Edit.EducacionIT_clase_1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio7Test {
	String url= "https://www.saucedemo.com/";
	String driverPath= "..\\EducacionIT-clase-1\\Drivers\\chromedriver.exe";
	String evidenciaDir= "..\\EducacionIT-clase-1\\Evidencias";
	WebDriver driver;
	File screen;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="C01 - Realizar una compra", priority=1)
	public void registrarCompra() throws IOException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		capturarPantalla("01 - Ingresar login");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		capturarPantalla("02 - Agregar producto 1");
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
		capturarPantalla("03 - Agregar producto 2");
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		
		driver.findElement(By.className("shopping_cart_link")).click();
		capturarPantalla("04 - Verificar productos");
		driver.findElement(By.name("checkout")).click();	
		
		driver.findElement(By.name("firstName")).sendKeys("Vanessa");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Duque");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("1037"); 
		capturarPantalla("06 - Ingresar datos cliente");
		driver.findElement(By.id("continue")).click();
		capturarPantalla("07 - Compra realizada");
		driver.findElement(By.cssSelector("#finish")).click();
		
		/*AssertTrue
		 * String mensajeResultado= driver.findElement(By.xpath("//span[contains(text(),'Checkout: Complete!')]")).getText();
		Assert.assertTrue(mensajeResultado.contentEquals("Checkout: Complete!"));*/
		
		String urlActual= driver.getCurrentUrl();
		String urlEsperada="https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(urlActual, urlEsperada);
	}
	
	public void capturarPantalla(String nombreCaptura) throws IOException {
		screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(evidenciaDir + nombreCaptura + ".jpg"));
		
		//driver.close();
	}
	
	


}
