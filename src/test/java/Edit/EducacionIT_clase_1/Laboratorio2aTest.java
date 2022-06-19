package Edit.EducacionIT_clase_1;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2aTest {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT-clase-1\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/**
		 * incognito
		 * start-maximized
		 * disable-extension
		 * disable-infobars
		 * headless
		 */
		
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to(url); // Abre la pÃ¡gina
		driver.manage().deleteAllCookies(); // Borra las cookies
		driver.manage().window().maximize(); // Maximiza la ventana
		
		// Escribo el correo y hago clic en el botÃ³n
		driver.findElement(By.id("email_create")).sendKeys("correo" + Math.random() + "@mailinator.com");
		driver.findElement(By.name("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// Completar el Formulario - InformaciÃ³n Personal
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Radio Button
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Gonzalo");
		driver.findElement(By.id("customer_lastname")).sendKeys("Gutierrez Barrios");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("chesster21");

		Select days = new Select(driver.findElement(By.name("days")));
		days.selectByValue("18"); // valor interno que acompaÃ±a a la opciÃ³n
		//days.selectByVisibleText("18  "); // texto que se ve en la pÃ¡gina
		//days.selectByIndex(17); // orden en que se muestra la opciÃ³n

		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("June ");
		
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByIndex(30);
		
		driver.findElement(By.cssSelector("#newsletter")).click();
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		driver.findElement(By.name("company")).sendKeys("ABC C.A.");
		driver.findElement(By.id("address1")).sendKeys("MiCalle 3245 6B");
		driver.findElement(By.cssSelector("#address2")).sendKeys("Entre Calles A y B");
		driver.findElement(By.id("city")).sendKeys("CABA");
		
		Select states = new Select(driver.findElement(By.id("id_state")));
		states.selectByVisibleText("California");
		
		driver.findElement(By.id("postcode")).sendKeys("23456");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Comentarios sobre el registro");
		driver.findElement(By.name("phone")).sendKeys("35465667");
		driver.findElement(By.id("phone_mobile")).sendKeys("7867564754");
		
		WebElement txtAlias = driver.findElement(By.cssSelector("#alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Dirección de Casa");
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		driver.close();
	}
}

