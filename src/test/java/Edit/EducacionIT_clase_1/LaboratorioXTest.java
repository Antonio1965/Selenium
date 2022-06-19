package Edit.EducacionIT_clase_1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaboratorioXTest {
	WebDriver driver;
	String driverPath = "..\\EducacionIt-clase-1\\Drivers\\chromedriver.exe";
	String urlTest ="https://selenium.dev/";
	@BeforeSuite
	public void setUp() {System.setProperty("webdriver.chrome.driver",driverPath) ; driver= new ChromeDriver(); }
	@BeforeTest
	public void IrURL(){ driver.get(urlTest); }
	@BeforeClass
	public void maximizarNavegador() { driver.manage().window().maximize(); }
	@Test
	public void verificarLink() { driver.findElement(By.linkText("Downloads")).click();}
	
	@AfterTest
	public void cerrarPagina(){
		driver.quit();
		
	}
	@AfterSuite
	public void finSuite(){ System.out.println("Fin suite de pruebas."); }

	
	
}
