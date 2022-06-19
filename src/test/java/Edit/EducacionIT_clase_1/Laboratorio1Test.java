package Edit.EducacionIT_clase_1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Laboratorio1Test {
	@Test
	public void buscarEnChome() {
		System.setProperty("webdriver.chrome.driver","..//EducacionIT-clase-1//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("t-shirts");
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		driver.close();

			
	}
	
	@Test
	public void buscarEnFirefox() {
		System.setProperty("webdriver.gecko.driver","..//EducacionIT-clase-1//Drivers//geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("t-shirts");
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		driver.close();
	
			
	}
}
