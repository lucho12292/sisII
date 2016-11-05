/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Out;
 
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Charlie
 */
public class connectBD {
    
    
    
    
    
    
    Connection conect = null;
    public Connection conexion()
        {
     
          
            
            
            
            
            try {
                //Cargamos el Driver MySQL
                Class.forName("Driver");
                //direccion de la base de datos
                //conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
                conect = DriverManager.getConnection("jdbc:mysql://127.8.127.130:3306/sis2","adminlEbMSuM","35kes6wiqNAk");
                System.out.println("conexion establecida");
                JOptionPane.showMessageDialog(null,"Conectado");
                
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("error al conexion");
                JOptionPane.showMessageDialog(null,"Error de conexion"+e);
            }
            return conect;
        }
     
}

