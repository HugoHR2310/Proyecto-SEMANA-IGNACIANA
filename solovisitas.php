<?php
//Inicio de Sesion
	session_start();
//Recoge la información del formulario
	$nombre=$_POST["nombre"];  //asigna el valor que se envía del formulario, recuerda acabar con ;
	$codigo=$_POST["codigo"];	
//Conecta con la base de datos ($conexión)
    include 'configdb.php'; //include del archivo con los datos de conexión
	$conexion = new mysqli(SERVIDOR, USUARIO, PASSWORD, BBDD); //Conecta con la base de datos
    $conexion->set_charset("utf8"); //Usa juego caracteres UTF8
	//Desactiva errores
	$controlador = new mysqli_driver();
    $controlador->report_mode = MYSQLI_REPORT_OFF;
	
//Cadena de caracteres de la consulta sql	
	$sql = "SELECT nombre,codigo FROM jesuita WHERE codigo= '$codigo' AND nombre='$nombre';";   //completa lo que falta
	echo $sql; //envía el contenido de la variable al navegador, o sea, muestra la información en el navegador
	$resultado=$conexion->query($sql);
//Ejecuta la consulta
	
	if($resultado->num_rows > 0){
		$_SESSION["nombre"]=$nombre;
		echo '<h2><a href="Visita.php">Ves a la visita</a></h2>';
	}
	else{
		echo "<h2>La visita no se ha realizado</h2>";
		echo '<h3><a href="Jesuitas.html"> Vuelve a intentarlo</a></h3>';
		exit();
	}	

//Cierra la conexión
	$conexion->close();
?>