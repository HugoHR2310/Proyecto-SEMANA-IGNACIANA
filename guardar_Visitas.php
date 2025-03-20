 <?php 
//Conecta con la base de datos ($conexión)
    include 'configdb.php'; //include del archivo con los datos de conexión
	$conexion = new mysqli(SERVIDOR, USUARIO, PASSWORD, BBDD); //Conecta con la base de datos
    $conexion->set_charset("utf8"); //Usa juego caracteres UTF8
	//Desactiva errores
	$controlador = new mysqli_driver();
    $controlador->report_mode = MYSQLI_REPORT_OFF;
	//VARIABLES
	$ip=$_POST["ip"];
	$idJesuita=$_POST["nombre"];
	
	//CONSULTA
	$consulta="SELECT idJesuita FROM jesuita WHERE nombre='$idJesuita'";
	$resultado=$conexion->query($consulta);
	$Jesuita=$resultado->fetch_assoc()["Jesuita"];
	
//Cadena de caracteres de la consulta sql	
	echo $sql="INSERT INTO visita (idJesuita,ip) VALUES ('$idJesuita','$ip')";
	$conexion->query($sql);
	//MOSTRAR LO REALIZADO
	echo "La IP seleccionada es: ".$ip."Visita Realizada";
	echo'<h3><a href="Visita.php">Volver a realizar otra visita</a></h3>';
//Cierra la conexión
	$conexion->close();
?>