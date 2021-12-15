package definitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import steps.PortalWebSteps;
import excelExport.leerExcel;
import pageobject.PortalWebPageObject;


public class NewToursDefinitions {
	
	@Steps
	PortalWebSteps PortalWebSteps;
	@Steps
	PortalWebPageObject PortalWebPageObject;
	
	@Given("ingreso a web new tours")
	public void ingresoAWebNewTours()throws Throwable  {
	  PortalWebSteps.abrirPortal();
	}

	@When("ingresa en seccion registro")
	public void ingresaEnSeccionRegistro() throws Throwable{
	   PortalWebSteps.registro();
	}
	
	@When("ingresa datos en formulario desde archivo {string} y numerofila {int}")
	public void ingresaDatosEnFormularioDesdeArchivoYNumerofila(String nombreHoja, Integer numeroFila) throws InvalidFormatException, IOException {
	   leerExcel reader= new  leerExcel();
	   List<Map<String,String>> dataDriven = reader.getData("/Users/m80lu/eclipse-workspace/newtours/src/test/resources/datadriven/datascenarios.xlsx", nombreHoja);
	   
	   String name= dataDriven.get(numeroFila).get("FirstName");
	   String apellido= dataDriven.get(numeroFila).get("LastName");
	   String telefono= dataDriven.get(numeroFila).get("Phone");
	   String correo= dataDriven.get(numeroFila).get("email");
	   String direccion= dataDriven.get(numeroFila).get("Address");
	   String ciudad= dataDriven.get(numeroFila).get("City");
	   String departamento = dataDriven.get(numeroFila).get("State");
	   String codigopost= dataDriven.get(numeroFila).get("Postalcode");
	   String pais= dataDriven.get(numeroFila).get("country");
	   String user= dataDriven.get(numeroFila).get("username");
	   String clave= dataDriven.get(numeroFila).get("password");
	   String clavecon= dataDriven.get(numeroFila).get("confirmpassword");
	   
	   PortalWebSteps.diligenciaForm(name,apellido,telefono,correo,direccion,ciudad,departamento,codigopost,pais,user,clave,clavecon);
	}
	@When("el usuario ingresa datos del vuelo desde archivo {string} numerofila {int}")
	public void elUsuarioIngresaDatosDelVueloDesdeArchivoNumerofila0(String nombreHoja, Integer numeroFila)throws InvalidFormatException, IOException {
		   leerExcel reader= new  leerExcel();
		   List<Map<String,String>> dataD = reader.getData("/Users/m80lu/eclipse-workspace/newtours/src/test/resources/datadriven/datascenarios.xlsx", nombreHoja); 
		   
		   String pasajeros = dataD.get(numeroFila).get("passengers");
		   String depart  = dataD.get(numeroFila).get("departing");
		   String on      = dataD.get(numeroFila).get("on");
		   String dayOn = dataD.get(numeroFila).get("dayon");
		   String arrive = dataD.get(numeroFila).get("arriving");
		   String returnM = dataD.get(numeroFila).get("returning");
		   String returnD = dataD.get(numeroFila).get("dayreturn");
		   
		   PortalWebSteps.consultaVuelos(pasajeros,depart,on,dayOn,arrive,returnM,returnD);
		   
	}
	

	@When("envia consulta")
	public void enviaConsulta() {	   
	   PortalWebSteps.enviarBoton();
	}

	@Then("confirma registro de usuario")
	public void confirmaRegistroDeUsuario() {
	   PortalWebSteps.mensajeRegistro();
		
	}


	@When("ingreso en seccion vuelos")
	public void ingresoEnSeccionVuelos() {
	   PortalWebSteps.vuelos();
	  
	}


	@Then("usuario consulta disponibilidad de vuelo")
	public void usuarioConsultaDisponibilidadDeVuelo() {
	    PortalWebSteps.clase();
	    PortalWebSteps.consultaVuelo();
	    PortalWebSteps.mensajeBusqueda();
	}



	@When("se visualiza fecha en pagina principal")
	public void seVisualizaFechaEnPaginaPrincipal() {
	   PortalWebSteps.fechaWeb();
	    
	}

	@Then("se compara fecha actual del sistema")
	public void seComparaFechaActualDelSistema() {
	  PortalWebSteps.compararWeb();
	   
	}
	
}
	