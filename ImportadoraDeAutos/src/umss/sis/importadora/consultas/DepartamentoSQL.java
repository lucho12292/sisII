/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umss.sis.importadora.consultas;

import Out.ConexionBD;
import Out.InterfazVistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import umss.sis.importadora.modelo.Departamento;

/**
 *
 * @author lucho
 */
public class DepartamentoSQL {
    
    private ConexionBD con = new ConexionBD();
    private Connection cn = con.conexion();
    private PreparedStatement pps;
    
    public ArrayList<Departamento> recuperarTodosLosDepartamentos(){
        ArrayList<Departamento> departamentosRecuperados = new ArrayList<>();
        try {
             pps = cn.prepareStatement("SELECT * FROM Departamento");

            ResultSet departamentos = pps.executeQuery();
            while(departamentos.next()){
                Departamento actual = new Departamento();
                actual.setId(Integer.parseInt(departamentos.getString("ID")));
                actual.setDepartamento(departamentos.getString("Departamento"));
                departamentosRecuperados.add(actual);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamentosRecuperados;
    }
}
