
import umss.sis.importadora.restclients.AsistenciaRestClient;

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
        AsistenciaRestClient client = new AsistenciaRestClient();
        String count = client.countREST();
        System.out.println(count);
        client.close();
    }
}
