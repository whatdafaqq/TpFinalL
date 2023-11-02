/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Cuartel;
import Entidades.Siniestro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class CuartelData {
private Connection conn = null;
    public CuartelData() {
       conn = Conexion.getConnection();
    }
    
    
    
   public void agregarCuartel(Cuartel cuartel){
     String sql = "insert into cuartel (nombre_cuartel, direccion, coord_X, coord_Y, telefono, correo)"
             + "values ( ?, ?, ?, ?, ?, ?)";
     
     try {
           PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         //  ps.setInt(1, cuartel.getCodCuartel());
           ps.setString(1, cuartel.getNombre_Cuartel());
           ps.setString(2, cuartel.getDireccion());
           ps.setInt(3, cuartel.getCoord_X());
           ps.setInt(4, cuartel.getCoord_Y());
           ps.setString(5, cuartel.getTelefono());
           ps.setString(6, cuartel.getCorreo());
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next()){
               cuartel.setCodCuartel(rs.getInt(1));
               JOptionPane.showMessageDialog(null, "cuartel Guardado!");
           }
           ps.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");
           ex.printStackTrace();
       }
   }
   
   
   
   public void modificarCuartel(Cuartel cuartel){ 
     
       
   }
   
   //fisico porque logico no se puede creo.
   public void eliminarCuartel(Cuartel cuartel){
       
   }

   public List<Cuartel> buscarCuartel(){
       
    return null;
       
   }
   
   public List<Cuartel> buscarCuartelPorCorreo(){
       
       return null;
       
   }
   
   public List<Cuartel> listarCuarteles(){
       
       return null;
       
   }

//⦁	Mostrar los cuarteles de bomberos cerca de un punto de siniestro o incidente.
public List<Cuartel> cuartelesCercaDelLugarDeSiniestro(int eje_x, int eje_y){
ArrayList<Cuartel> cuarteles = new ArrayList<>();
String sql= "select * from cuartel where (sqrt(pow(coord_X-?, 2) + pow(coord_Y-?, 2)))<20";

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, eje_x);
        ps.setInt(2, eje_y);
       ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Cuartel cuartel = new Cuartel();
          
            cuartel.setCodCuartel(rs.getInt("codCuartel"));
            cuartel.setNombre_Cuartel(rs.getString("nombre_cuartel"));
            cuartel.setDireccion(rs.getString("direccion"));
            cuartel.setCoord_X(rs.getInt("coord_X"));
            cuartel.setCoord_Y(rs.getInt("coord_Y"));
            cuartel.setTelefono(rs.getString("telefono"));
            cuartel.setCorreo(rs.getString("correo"));
            cuarteles.add(cuartel);
            
        }
        ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel!");
        ex.printStackTrace();
    }


    return cuarteles;


}

}
