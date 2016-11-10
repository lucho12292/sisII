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
import umss.sis.importadora.modelo.Balance;
import umss.sis.importadora.modelo.Departamento;

/**
 *
 * @author lucho
 */
public class BalanceSQL {
    
    private static final String CONSULTA_ID_DEPARTAMENTO= "SELECT * FROM Balance WHERE idDeparatamento = %d";
    private ConexionBD con = new ConexionBD();
    private Connection cn = con.conexion();
    private PreparedStatement pps;
    
    public Balance recuperarBalancePorDepartamento(int id){
        Balance balance = new Balance();
        String consulta = String.format(CONSULTA_ID_DEPARTAMENTO, id);
        try {
             pps = cn.prepareStatement(consulta);

            ResultSet departamentos = pps.executeQuery();
            while(departamentos.next()){
                balance.setNroBalance(Integer.parseInt(departamentos.getString("nroBalance")));
                balance.setIdDepartamento(Integer.parseInt(departamentos.getString("idDepartamento")));
                balance.setIngreso(Long.parseLong(departamentos.getString("ingreso")));
                balance.setEgreso(Long.parseLong(departamentos.getString("egreso")));
                balance.setDeudas(Long.parseLong(departamentos.getString("deudas")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazVistas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
}
