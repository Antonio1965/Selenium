package Paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlertaTest {
WebDriver driver;
	
	// Elementos
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	@FindBy(xpath="//button[@id='timerAlertButton']")
	WebElement btnEspera;
	
	@FindBy(css="#confirmButton")
	WebElement btnConfirmacion;
	
	@FindBy(id="promtButton")
	WebElement btnEscribir;
	
	// Constructor
	public PaginaAlertaTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Acciones
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnEspera() {
		btnEspera.click();
	}
	
	public void hacerClicEnConfirmacion() {
		btnConfirmacion.click();
	}
	
	public void hacerClicEnEscribir() {
		btnEscribir.click();
	}
	
	public Alert obtenerAlerta() {
		return driver.switchTo().alert();
	}
	
	public void aceptarAlerta() {
		obtenerAlerta().accept(); // Hacer clic en OK del popup/alerta
	}
	
	public void cancelarAlerta() {
		obtenerAlerta().dismiss(); // Hacer clic en Cancel del popup/alerta
	}
	
	public void escribirEnAlerta(String palabra) {
		obtenerAlerta().sendKeys(palabra);
	}
	
	public String obtenerTextoAlerta() {
		return obtenerAlerta().getText();
	}
}



