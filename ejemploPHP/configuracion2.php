<?php
$servidor="localhost";
$usuario="root"
$clave="";
$base_datos="libro"
$conexion=mysqli_connect($servidor, $usuario, $clave, $base_datos) or die ("Problemas con la conexion".mysql_error());
?>