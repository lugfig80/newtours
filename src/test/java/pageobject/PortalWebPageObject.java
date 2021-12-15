package pageobject;

import org.openqa.selenium.By;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.text.DateFormatSymbols;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertThat;



@DefaultUrl ("http://demo.guru99.com/test/newtours/")

public class PortalWebPageObject extends PageObject{
	
	//home
	String fecha ="//b[contains(text(),'Jul 6, 2017')]";	
	//registro 
    String register="REGISTER";
	String nombre ="//tbody/tr[2]/td[2]/input[1]";
    String apellido ="//tbody/tr[3]/td[2]/input[1]";
    String telefono ="//tbody/tr[4]/td[2]/input[1]";
    String correo="//input[@id='userName']";
    String direccion="//tbody/tr[7]/td[2]/input[1]";
    String ciudad="//tbody/tr[8]/td[2]/input[1]";
    String departamento="//tbody/tr[9]/td[2]/input[1]";
    String codigopostal="//tbody/tr[10]/td[2]/input[1]";
    String pais="//tbody/tr[11]/td[2]/select[1]";
    String username="//input[@id='email']";
    String password="//tbody/tr[14]/td[2]/input[1]";
    String confirmpass="//tbody/tr[15]/td[2]/input[1]";
    String enviarbtn="//tbody/tr[17]/td[1]/input[1]";
    String msnregistro="//tbody/tr[3]/td[1]/p[2]/font[1]";
    //vuelos
    String flights="//a[contains(text(),'Flights')]";
    String pasajeros="//tbody/tr[3]/td[2]/b[1]/select[1]";
    String salida="//tbody/tr[4]/td[2]/select[1]";
    String messalida="//tbody/tr[5]/td[2]/select[1]";
    String diasalida="//tbody/tr[5]/td[2]/select[2]";
    String llegada="//tbody/tr[6]/td[2]/select[1]";
    String mesllegada="//tbody/tr[7]/td[2]/select[1]";
    String diallegada="//tbody/tr[7]/td[2]/select[2]";
    String clase ="//tbody/tr[9]/td[2]/font[1]/input[1]";
    String continuarbtn="//tbody/tr[14]/td[1]/input[1]";
    String msnbusqueda="//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]";
    
    public void seccionRegistro () {
    	find(By.linkText(register)).click();
    	
    }
    public void ingresaNombre (String nombreUsu) {
    	find(By.xpath(nombre)).sendKeys(nombreUsu);
    	
    }
    public void diligenciaForm (String nombreUsu, String apellidoUsu,String telefonoNum,String correoM,String direc,
    		String ciu,String depar,String codPost,String country,String usu, String pass, String passC) {
    	find(By.xpath(nombre)).sendKeys(nombreUsu);
    	find(By.xpath(apellido)).sendKeys(apellidoUsu);
    	find(By.xpath(telefono)).sendKeys(telefonoNum);
    	find(By.xpath(correo)).sendKeys(correoM);
    	find(By.xpath(direccion)).sendKeys(direc);
    	find(By.xpath(ciudad)).sendKeys(ciu);
    	find(By.xpath(departamento)).sendKeys(depar);
    	find(By.xpath(codigopostal)).sendKeys(codPost);
    	find(By.xpath(pais)).sendKeys(country);
    	find(By.xpath(username)).sendKeys(usu);
    	find(By.xpath(password)).sendKeys(pass);
    	find(By.xpath(confirmpass)).sendKeys(passC);
    }
	
public void enviarBoton () {
	find(By.xpath(enviarbtn)).click();
	
}
public void mensajeRegistro () {
	String actualMensaje = find(By.xpath(msnregistro)).getText();
	String expectedMens  = " Thank you for registering. You may now sign-in using the user name and password you've just entered. ";
	assertThat(expectedMens, equalToIgnoringWhiteSpace (actualMensaje));
	
}
  public void seccionVuelos() {
	find(By.xpath(flights)).click();
}
  public void consultaVuelos(String cantPas,String org, String mesSal, String diaSal, String destinoV,String mesLleg,
		  String diaLleg) {
	  find(By.xpath(pasajeros)).sendKeys(cantPas);
	  find(By.xpath(salida)).sendKeys(org);
	  find(By.xpath(messalida)).sendKeys(mesSal);
	  find(By.xpath(diasalida)).sendKeys(diaSal);
	  find(By.xpath(llegada)).sendKeys(destinoV);
	  find(By.xpath(mesllegada)).sendKeys(mesLleg);
	  find(By.xpath(diallegada)).sendKeys(diaLleg);
  }

  public void clase() {
	  find(By.xpath(clase)).click();
  }
  public void consultaVuelo() {
	  find(By.xpath(continuarbtn)).click();
  }
  public void mensajeBusqueda () {
		String actualMensaje = find(By.xpath(msnbusqueda)).getText();
		String expectedMens  = "         After flight finder - No Seats Avaialble   ";
		assertThat(expectedMens, equalToIgnoringWhiteSpace (actualMensaje));
  }
  
  public void fechaWeb() {
	  find(By.xpath(fecha)).isPresent();
  }
  public void compararfechaWeb() {
	   
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM"+" "+"dd"+","+" Y");
		String fechaSys = sdf.format(date);
		
		String actualMensaje = find(By.xpath(fecha)).getText();
		assertThat(fechaSys, equalToIgnoringWhiteSpace (actualMensaje));
		
  }
}
