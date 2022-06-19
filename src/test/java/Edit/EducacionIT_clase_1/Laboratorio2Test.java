package Edit.EducacionIT_clase_1;


import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Laboratorio2Test {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT-clase-1\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		// Inicialización del Driver y abrir el navegador en la página
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("incognito");
		
		//WebDriver driver = new ChromeDriver(options);

	
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Escribir el correo y hacer clic en el botón Create An Account
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
		
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		
		// Completar el formulario
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// Boton
		driver.findElement(By.id("id_gender1")).click();
		
		//Nombre
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Antonio");
		
		// Apellido
		driver.findElement(By.id("customer_lastname")).sendKeys("Martinez");
		
		//Password
		driver.findElement(By.name("passwd")).sendKeys("chesster21");
		
		// Campo Desplegable
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("18");//Valor interno que acompaña a la opción
		//days.selectByVisibleText("18  "); // Texto que se en la pagina
		//days.selectByIndex(2); //Orden en que se muestra la opción
		
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("June");
		
		Select years = new Select(driver.findElement(By.xpath("//*[@id='years']")));
		years.selectByIndex(30);
		
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.cssSelector("#address1")).sendKeys("Jauretche 210");
		
		driver.findElement(By.id("city")).sendKeys("Buenos Aires");
		
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Arizona");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("C1405CUF");
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		driver.findElement(By.name("phone_mobile")).sendKeys("4657463736");
		
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Dirección de Trabajo");
		
		driver.findElement(By.cssSelector("#submitAccount")).click();
			
		//driver.close();
	}
	
}
