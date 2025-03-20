package bbdd;

import java.sql.SQLException;

public class SqlJesuitas {
	ConexionBD objConexion = null;
	
	public SqlJesuitas(ConexionBD objConexion){
		this.objConexion=objConexion;
	}
	
	public void insertarFila (String codigo, String nombre, String nombreAlumno, String firma, String firmaIngles){
       int i;
       i=0;
		try {
        	
           String cadena = "INSERT INTO JESUITA VALUES ('"+i+"','"
        		+codigo+ "','"   
				+nombre+ "','" 
				+nombreAlumno+ "','" 
				+firma+ "','" 
				+firmaIngles+"');";
            
System.out.println(cadena);
            objConexion.sentencia.executeUpdate(cadena);
          } catch (SQLException ex) {ex.printStackTrace();}
    }
       
    

}
