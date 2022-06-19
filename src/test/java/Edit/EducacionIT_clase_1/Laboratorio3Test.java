package Edit.EducacionIT_clase_1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Laboratorio3Test {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT-clase-1\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test(description="CP01 - Verificar la seccion Contactoanos", priority=200, enabled= true)
	public void irAContactos() {
		driver.findElement(By.linkText("Contact us")).click();
		
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("sa@gmail.com");
		
		driver.findElement(By.id("message")).sendKeys("Comentarios del contacto");
		
		driver.findElement(By.id("fileUpload")).sendKeys("C:/Users/Casa/Desktop/PDF-TODAS/Asesor.pdf");
		
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
	}

	@Test(description="CP02 - Verificar la busqueda de productos", priority=100)
	public void buscarPalabra() {
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		String urlEsperado = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl();
		
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(urlActual, urlEsperado);
		Assert.assertEquals(tituloActual, tituloEsperado);
		
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
		
	}
}
