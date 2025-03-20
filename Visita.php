 <?php
//Inicio de Sesion
	session_start();	
//Conecta con la base de datos ($conexión)
    include 'configdb.php'; //include del archivo con los datos de conexión
	$conexion = new mysqli(SERVIDOR, USUARIO, PASSWORD, BBDD); //Conecta con la base de datos
    $conexion->set_charset("utf8"); //Usa juego caracteres UTF8
	//Desactiva errores
	$controlador = new mysqli_driver();
    $controlador->report_mode = MYSQLI_REPORT_OFF;
	
//Cadena de caracteres de la consulta sql	
	$lugar="SELECT ip,lugar FROM lugar;";
	$resultado=$conexion->query($lugar);
	$nombre=$_SESSION["nombre"];
//Cierra la conexión
	$conexion->close();
?>
 
 <DOCTYPE html>
<html>
	<head>
		<title>Semana Ignaciana</title>
		<meta charset="UTF-8"/>
		<meta name="autor" content="Hugo Hernández Royano">
		<link rel="stylesheet" href="css1.css">
	</head>
	<body>
		<h2 align="center">Hola Jesuita</h2>
		<form name="Visitas" method="POST" action="guardar_Visitas.php">
			<?php echo'<h1>Bienvenido a la Pagina' .$nombre .'</h1>';
			?>
			<br>
			<label for="lugar">Lugar</label>
			<input type="hidden" name="nombre" <?php echo'value="'.$nombre.'"'?>>
			<br>
				<select name="ip" id="ciudades">
				<?php 
					while($fila=$lugar->fetch_array()){
						echo'<option value="'.$fila["ip"].'">'.$fila["lugar"].'</option>';
					}
					$conexion->close();
					?>
				</select>
					<br><br>
					<input type="submit" value="enviar" id="enviar"/>
					<br><br>
		</form>
	</body>
</html>
