<?php
$Identificacion = $_POST["idepoca"];
$Epoca=$_POST["epocaTime"];
$TiempoComprendido=$_POST["tiempoComprendido"];
include("configuracion2.php");
if(isset($_POST["enviar"])){
    $cadSQL="insert into epoca (idepoca, epocaTime, tiempoComprendido) values ('$Identificacion', '$Epoca', '$TiempoComprendido')";
    $resultado =$conexion -> query($cadSQL);
    echo "Ejcucion Existosa";
}
if(isset($_POST["modificar"])){
    $modificar="update epoca set epocaTime ='" .$Epoca. "', tiempoComprendido ='" .$TiempoComprendido. "' where idepoca= '".$Identificacion."'";
    echo "Modificacion exitosa";
}
if(isset($_POST["eliminar"])){
    $indetificacion = $_POST["idepoca"];
    $borrar="delete from epoca where idepoca = '".$Identificacion."'";
    $conexion -> query($borrar);
    echo "Borrado existosamente";
}
if(isset($_POST["buscar"])){
    $sql="SELECT epocaTime, tiempoComprendido FROM epoca WHERE idepoca='".$_POST['idepoca']."'";
    $query=$conexion ->query($sql);
    if($query -> num_rows>0){
        echo "<table border= '1'><tr><td>Autor</td><td>Lugar</td><td>Lugar Nacimiento</td></tr><tr>";
        while($row=$query -> fetch_array()){
            echo"<td>.$row["epoca"]."</td><td>.$row["tiempoComprendido"]."</td>";
            echo"<br>";
        }
        echo"</tr></table>";
    }else{
        echo "No hay registros";
    }
}
?>