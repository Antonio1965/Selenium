package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicioTest {
	// Elementos de la pÃ¡gina
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;     // Todo esto reemplaza al driver.findElement...
	
	
	@FindBy(css="#search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;

	
	// Constructor
	public PaginaInicioTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre los elementos de la pÃ¡gina
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void escribirPalabra1(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void escribirPalabra2(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}

	public void clear() {
		txtBuscador.clear();
		// TODO Auto-generated method stub
		
	}

	
	

}

