package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaTablaTst {
	// Elementos
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement celda12;
	
	@FindBy(xpath="//tbody/tr[2]/td[3]")
	WebElement celda23;
	
	@FindBy(xpath="//tbody/tr[4]/td[3]")
	WebElement celda43;
	
	// Constructor
	public PaginaTablaTst(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Acciones
	public String obtenerTextoCelda12() {
		return celda12.getText();
	}
	
	public String obtenerTextoCelda23() {
		return celda23.getText();
	}
	
	public String obtenerTextoCelda43() {
		return celda43.getText();
	}


}
