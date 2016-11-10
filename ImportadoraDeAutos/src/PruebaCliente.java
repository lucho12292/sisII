
import java.util.ArrayList;
import javax.ws.rs.core.GenericType;
import umss.sis.importadora.restclients.AsistenciaRestClient;
import umss.sis.importadora.restclients.DepartamentoRestClient;
import umss.sis.importadora.restclients.EmpleadoRestClient;
import umss.sis.importadora.modelo.Departamento;
import umss.sis.importadora.modelo.Empleado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisMaldonado
 */
public class PruebaCliente {
    
    public static void main(String[] args) {
        EmpleadoRestClient client = new EmpleadoRestClient();
        GenericType<ArrayList<Empleado>> algo;
        algo = new GenericType<ArrayList<Empleado>>(){};
        ArrayList<Empleado> res = (ArrayList<Empleado>) client.findAll_XML(algo);
        System.out.println(res);
        client.close();
    }
}
