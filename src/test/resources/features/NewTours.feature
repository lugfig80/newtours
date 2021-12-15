#Empresa: Gml Software
#Automatizador: Luis Figueredo
#solucion: New Tours


@NewTours
Feature: registro de usuarios en portal web

Background: ingreso portal web
	Given ingreso a web new tours 


  @registro
 	Scenario Outline: usuario requiere completar registro en formulario
		
		
    When ingresa en seccion registro 
    And  ingresa datos en formulario desde archivo "<nombreHoja>" y numerofila <numfila>
    And  envia consulta 
		Then confirma registro de usuario
		
Examples:
|nombreHoja|numfila|
|form|0|
|form|1|


@busquedavuelos
 Scenario Outline: usuario desea validar disponibilidad de vuelos
 
    When ingreso en seccion vuelos
    And  el usuario ingresa datos del vuelo desde archivo "<nombreHoja>" numerofila <numfila>
		Then usuario consulta disponibilidad de vuelo

Examples:
|nombreHoja|numfila|
|flights|0|
|flights|1|


@validafecha
	Scenario: validar fecha actual portal web
	
		When se visualiza fecha en pagina principal
		Then se compara fecha actual del sistema






 