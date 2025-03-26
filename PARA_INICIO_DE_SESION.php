<!--
<?php
/* Para inicio de sesión*/
	session_start();
	$fila=$resultado->fetch_array();
	$_SESSION["idJesuita"]=$fila["idJesuita"];
	$_SESSION["nombre"]=$fila["nombre"];
/* Para usar la sesión	*/
	session_start();
	//Un ejemplo de usar una variable de sesión
	echo $_SESSION["nombre"];