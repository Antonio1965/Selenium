package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLoginTest {
	// Elementos
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignOut;

	
	// Constructor
	public PaginaLoginTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void completarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void hacerClicEnSignOut() {
		lnkSignOut.click();
	}



}
