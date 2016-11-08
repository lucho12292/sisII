/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.servicio.service.AsistenciaFacadeREST.class);
        resources.add(com.mycompany.servicio.service.BalanceFacadeREST.class);
        resources.add(com.mycompany.servicio.service.CargoFacadeREST.class);
        resources.add(com.mycompany.servicio.service.CompradorFacadeREST.class);
        resources.add(com.mycompany.servicio.service.DepartamentoFacadeREST.class);
        resources.add(com.mycompany.servicio.service.DetalleVentaFacadeREST.class);
        resources.add(com.mycompany.servicio.service.EmpleadoCargoFacadeREST.class);
        resources.add(com.mycompany.servicio.service.EmpleadoFacadeREST.class);
        resources.add(com.mycompany.servicio.service.EstadoAsistenciaFacadeREST.class);
        resources.add(com.mycompany.servicio.service.HerramientaFacadeREST.class);
        resources.add(com.mycompany.servicio.service.MarcaFacadeREST.class);
        resources.add(com.mycompany.servicio.service.ModeloFacadeREST.class);
        resources.add(com.mycompany.servicio.service.TipoVehiculoFacadeREST.class);
        resources.add(com.mycompany.servicio.service.VehiculoFacadeREST.class);
    }
    
}
