package steps;

import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.Step;
import pageobject.PortalWebPageObject;

public class PortalWebSteps {
	
	PortalWebPageObject PortalWebPageObject;
	
	@Step
	
	public void abrirPortal() {
		PortalWebPageObject.getDriver().manage().deleteAllCookies();
		PortalWebPageObject.open();
		
	}
	@Step
	
	public void registro() {
		PortalWebPageObject.seccionRegistro();	
	}
	@Step
	
	public void diligenciaForm (String nombreUsu, String apellidoUsu,String telefonoNum,String correoM,String direc,
    		String ciu,String depar,String codPost,String country,String usu, String pass, String passC) {
		PortalWebPageObject.diligenciaForm(nombreUsu, apellidoUsu, telefonoNum, correoM, direc, ciu, depar, codPost, country, usu, pass, passC);

	
	}
	@Step
	public void enviarBoton () {
		PortalWebPageObject.enviarBoton();
		
	}
	@Step
	public void mensajeRegistro () {
		PortalWebPageObject.mensajeRegistro();
}

@Step
public void vuelos () {
	PortalWebPageObject.seccionVuelos();
}

@Step
public void consultaVuelos(String cantPas,String org, String mesSal, String diaSal, String destinoV,String mesLleg,
		  String diaLleg) {
	 PortalWebPageObject.consultaVuelos(cantPas, org, mesSal, diaSal, destinoV, mesLleg, diaLleg);

}
@Step
public void clase() {
	 PortalWebPageObject.clase();
}
@Step
public void consultaVuelo() {
	  PortalWebPageObject.consultaVuelo();
}
@Step
public void mensajeBusqueda () {
	PortalWebPageObject.mensajeBusqueda();
}
@Step
public void  fechaWeb() {
	PortalWebPageObject.fechaWeb();
}
@Step
public void  compararWeb() {
	PortalWebPageObject.compararfechaWeb();
}

}