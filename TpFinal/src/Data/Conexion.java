/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="bomberos";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection=null;
    
    private Conexion() {
    }
    
    public static Connection getConnection(){

    if (connection == null) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers!");
            ex.printStackTrace();
        }
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar la BD!");
            ex.printStackTrace();
        }
}
        return connection;
   
}
    
    
    
    
}
